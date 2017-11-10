import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.TinyPiELexer;
import parser.TinyPiEParser;

public class Interpreter extends InterpreterBase {
	int evalExpr(ASTNode ndx, Environment env) {
		if (ndx instanceof ASTBinaryExprNode) {
			ASTBinaryExprNode nd = (ASTBinaryExprNode) ndx;
			int lhsValue = evalExpr(nd.lhs, env);
			int rhsValue = evalExpr(nd.rhs, env);
			if (nd.op.equals("+"))
				return lhsValue + rhsValue;
			if (nd.op.equals("*"))
				return lhsValue * rhsValue;
			if (nd.op.equals("/"))
				return lhsValue / rhsValue;
			if (nd.op.equals("&"))
				return lhsValue & rhsValue;
			if (nd.op.equals("|"))
				return lhsValue | rhsValue;
			else 
				throw new Error("Unkwon operator: "+nd.op);
		} else if (ndx instanceof ASTNumberNode) {
			ASTNumberNode nd = (ASTNumberNode) ndx;
			return nd.value;
		} else if (ndx instanceof ASTVarRefNode) {
			ASTVarRefNode nd = (ASTVarRefNode) ndx;
			Variable var = env.lookup(nd.varName);
			if (var == null) 
				throw new Error("Unkwon variable: "+nd.varName);
			return var.get();
		} else if (ndx instanceof ASTUnaryExprNode) {
			ASTUnaryExprNode nd = (ASTUnaryExprNode) ndx;
			int lhsValue = evalExpr(nd.lhs, env);
			if (nd.op.equals("-"))
				return -lhsValue;
			if (nd.op.equals("~"))
				return ~lhsValue;
			else
				throw new Error("Unkwon operator: "+nd.op);
		} else {
			throw new Error("Unkwon expression: "+ndx);
		}
	}

	public int eval(ASTNode ast) {
		Environment env = new Environment();
		addGlobalVariable(env, "x", 1);
		addGlobalVariable(env, "y", 10);
		addGlobalVariable(env, "z", -1);		
		return evalExpr(ast, env);
	}

	public static void main(String[] args) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		TinyPiELexer lexer = new TinyPiELexer(input);
		CommonTokenStream token = new CommonTokenStream(lexer);
		TinyPiEParser parser = new TinyPiEParser(token);
		ParseTree tree = parser.expr();
		ASTGenerator astgen = new ASTGenerator();
		ASTNode ast = astgen.translate(tree);
		Interpreter interp = new Interpreter();
		int answer = interp.eval(ast);
		System.out.println(answer);
	}
}
