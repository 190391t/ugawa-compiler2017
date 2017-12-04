import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.PiLangLexer;
import parser.PiLangParser;

public class Compiler extends CompilerBase {
	Environment globalEnv;
	
	void compileFunction(ASTFunctionNode nd) {
		Environment env = new Environment();
		String epilogueLabel = freshLabel();
		for (int i = 0; i < nd.params.size(); i++) {
			String name = nd.params.get(i);
			int offset = 4 * (i + 1);
			LocalVariable var = new LocalVariable(name, offset);
			env.push(var);
		}

		/* ここにプログラムを追加する */
		emitLabel(nd.name);
		System.out.println("\t@ prologue");
		emitPUSH(REG_FP);
		emitRR("mov", REG_FP, REG_SP);
		emitPUSH(REG_LR);
		emitPUSH(REG_R1);
		emitRRI("sub", REG_SP, REG_SP, nd.varDecls.size() * 4);
		
		for (int n = 0; n < nd.varDecls.size(); n++) {
			String name = nd.varDecls.get(n);
			int offset = (n + 3) * (-4);
			LocalVariable var = new LocalVariable(name, offset);
			env.push(var);
		}
		
		for (ASTNode stmt: nd.stmts)
			compileStmt(stmt, epilogueLabel, env);
		emitRI("mov", REG_DST, 0);  // returnがなかったときの戻り値0
		emitLabel(epilogueLabel);
		/*ここにエピローグを生成するコードを書くこと*/
		System.out.println("\t@ prologue");
		emitRRI("add", REG_SP, REG_SP, 4 * nd.varDecls.size());
		emitPOP(REG_R1);
		emitPOP(REG_LR);
		emitPOP(REG_FP);
		emitRET();
	}
	
	void compileStmt(ASTNode ndx, String epilogueLabel, Environment env) {
		if (ndx instanceof ASTCompoundStmtNode) {
			ASTCompoundStmtNode nd = (ASTCompoundStmtNode) ndx;
			ArrayList<ASTNode> stmts = nd.stmts;
			for  (ASTNode child: stmts)
				compileStmt(child, epilogueLabel, env);
		} else if (ndx instanceof ASTAssignStmtNode) {
			ASTAssignStmtNode nd = (ASTAssignStmtNode) ndx;
			Variable var = env.lookup(nd.var);
			if (var == null)
				var = globalEnv.lookup(nd.var);
			if (var == null)
				throw new Error("Undefined variable: "+nd.var);
			compileExpr(nd.expr, env);
			if (var instanceof GlobalVariable) {
				GlobalVariable globalVar = (GlobalVariable) var;
				emitLDC(REG_R1, globalVar.getLabel());
				emitSTR(REG_DST, REG_R1, 0);
			} else {
				LocalVariable localVar = (LocalVariable) var;
				int offset = localVar.offset;
				emitSTR(REG_DST, REG_FP, offset);
			}
		} else if (ndx instanceof ASTIfStmtNode) {
			ASTIfStmtNode nd = (ASTIfStmtNode) ndx;
			String elseLabel = freshLabel();
			String endLabel = freshLabel();
			compileExpr(nd.cond, env);
			emitRI("cmp", REG_DST, 0);
			emitJMP("beq", elseLabel);
			compileStmt(nd.thenClause, epilogueLabel, env);
			emitJMP("b", endLabel);
			emitLabel(elseLabel);
			compileStmt(nd.elseClause, epilogueLabel, env);
			emitLabel(endLabel);
		} else if (ndx instanceof ASTWhileStmtNode) {
			ASTWhileStmtNode nd = (ASTWhileStmtNode) ndx;
			String whileLabel = freshLabel();
			String endLabel = freshLabel();
			compileExpr(nd.cond, env);
			emitLabel(whileLabel);
			compileStmt(nd.stmt, epilogueLabel, env);
			emitRI("cmp", REG_DST, 0);
			emitJMP("bne", whileLabel);
			emitJMP("b", endLabel);
			emitLabel(endLabel);
		} else if (ndx instanceof ASTReturnNode) {
			ASTReturnNode nd = (ASTReturnNode) ndx;
			compileExpr(nd.expr, env);
			emitJMP("b", epilogueLabel);
		} else if (ndx instanceof ASTPrintStmtNode) {
			ASTPrintStmtNode nd = (ASTPrintStmtNode) ndx;
			String loopLabel = freshLabel();
			String hexLabel = freshLabel();
			String endLabel = freshLabel();
			
			emitPUSH(REG_R1);
			emitPUSH(REG_R2);
			emitPUSH(REG_R4);
			emitPUSH(REG_R5);
			emitPUSH(REG_R6);
			emitPUSH(REG_R7);
			emitPUSH(REG_R8);
			emitPUSH(REG_R9);
			
			compileExpr(nd.expr, env);
			emitRR("ldr", REG_R1, "=buf + 16");
			emitRI("mov", REG_R2, 16);
			emitRI("mov", REG_R6, 1);
			emitRI("mov", REG_R8, 8);
			emitRI("mov", REG_R9, 0);
			
			emitLabel(loopLabel);
			emitRRR("udiv", REG_R4, REG_DST, REG_R2);
			emitRRR("mul", REG_R5, REG_R4, REG_R2);
			emitRRR("sub", REG_R7, REG_DST, REG_R5);
			emitRI("cmp", REG_R7, 10);
			emitJMP("bcs", hexLabel);
			emitJMP("b", endLabel);
			
			emitLabel(hexLabel);
			emitRRI("add", REG_R7, REG_R7, 39);
			
			emitLabel(endLabel);
			emitRRI("sub", REG_R1, REG_R1, 1);
			emitRRI("add", REG_R7, REG_R7, '0');
			emitSTRB(REG_R7, REG_R1);
			emitRRI("add", REG_R6, REG_R6, 1);
			emitRR("mov", REG_DST, REG_R4);
			emitRRI("add", REG_R9, REG_R9, 1);
			emitRR("cmp", REG_R9, REG_R8);
			
			emitJMP("bmi", loopLabel);
			emitRI("mov", REG_R7, 4);
			emitRI("mov", REG_DST, 1);
			emitRR("mov", REG_R2, REG_R6);
			emitI("swi", 0);
			
			emitPOP(REG_R1);
			emitPOP(REG_R2);
			emitPOP(REG_R4);
			emitPOP(REG_R5);
			emitPOP(REG_R6);
			emitPOP(REG_R7);
			emitPOP(REG_R8);
			emitPOP(REG_R9);
			
		}
		else
			throw new Error("Unknown expression: "+ndx);
	}

	void compileExpr(ASTNode ndx, Environment env) {
		if (ndx instanceof ASTBinaryExprNode) {
			ASTBinaryExprNode nd = (ASTBinaryExprNode) ndx;
			compileExpr(nd.lhs, env);
			emitPUSH(REG_R1);
			emitRR("mov", REG_R1, REG_DST);
			compileExpr(nd.rhs, env);
			if (nd.op.equals("+"))
				emitRRR("add", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("-"))
				emitRRR("sub", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("*"))
				emitRRR("mul", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("/"))
				emitRRR("udiv", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("&"))
				emitRRR("and", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("|"))
				emitRRR("orr", REG_DST, REG_R1, REG_DST);
			else
				throw new Error("Unknwon operator: "+nd.op);
			emitPOP(REG_R1);
		} else if (ndx instanceof ASTCallNode) {
			ASTCallNode nd = (ASTCallNode) ndx;
			for (ASTNode arg: nd.args) {
				compileExpr(arg, env);
				emitPUSH(REG_DST);
			}
			emitCALL(nd.name);
			emitRRI("add", REG_SP, REG_SP, 4 * nd.args.size());
		} else if (ndx instanceof ASTNumberNode) {
			ASTNumberNode nd = (ASTNumberNode) ndx;
			emitLDC(REG_DST, nd.value);
		} else if (ndx instanceof ASTVarRefNode) {
			ASTVarRefNode nd = (ASTVarRefNode) ndx;
			Variable var = env.lookup(nd.varName);
			if (var == null)
				var = globalEnv.lookup(nd.varName);
			if (var == null)
				throw new Error("Undefined variable: "+nd.varName);
			if (var instanceof GlobalVariable) {
				GlobalVariable globalVar = (GlobalVariable) var;
				emitLDC(REG_DST, globalVar.getLabel());
				emitLDR(REG_DST, REG_DST, 0);
			} else {
				LocalVariable localVar = (LocalVariable) var;
				int offset = localVar.offset;
				emitSTR(REG_DST, REG_FP, offset);
			}
		} else if (ndx instanceof ASTUnaryExprNode) {
			ASTUnaryExprNode nd = (ASTUnaryExprNode) ndx;
			compileExpr(nd.lhs, env);
			emitPUSH(REG_R1);
			emitRR("mov", REG_R1, REG_DST);
			if (nd.op.equals("-")) {
				emitRR("mvn", REG_DST, REG_DST);
				emitRRI("add", REG_DST, REG_DST, 1);	
			} else if (nd.op.equals("~"))
				emitRR("mvn", REG_DST, REG_R1);
			else 
				throw new Error("Not a giobal variable: "+nd.op);
			emitPOP(REG_R1);		
		} else 
			throw new Error("Unknown expression: "+ndx);
	}
	
	void compile(ASTNode ast) {
		globalEnv = new Environment();
		ASTProgNode program = (ASTProgNode) ast;

		System.out.println("\t.section .data");
		System.out.println("\t@ 大域変数の定義");		
		for (String varName: program.varDecls) {
			if (globalEnv.lookup(varName) != null)
				throw new Error("Variable redefined: "+varName);
			GlobalVariable v = addGlobalVariable(globalEnv, varName);
			emitLabel(v.getLabel());
			System.out.println("\t.word 0");
		}

		System.out.println("\t.section .text");
		System.out.println("\t.global _start");
		System.out.println("_start:");
		System.out.println("\t@ main関数を呼出す．戻り値は r0 に入る");
		emitJMP("bl", "main");
		System.out.println("\t@ EXITシステムコール");
		emitRI("mov", "r7", 1);      // EXIT のシステムコール番号
		emitI("swi", 0);
		
		/* 関数定義 */
		for (ASTFunctionNode func: program.funcDecls)
			compileFunction(func);
		
		System.out.println(".section .data");
		emitLabel("buf");
		System.out.println("\t .space 16,0x30");
		System.out.println(".byte 0x0a");
		
	}

	public static void main(String[] args) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		PiLangLexer lexer = new PiLangLexer(input);
		CommonTokenStream token = new CommonTokenStream(lexer);
		PiLangParser parser = new PiLangParser(token);
		ParseTree tree = parser.prog();
		ASTGenerator astgen = new ASTGenerator();
		ASTNode ast = astgen.translate(tree);
		Compiler compiler = new Compiler();
		compiler.compile(ast);
	}
}
