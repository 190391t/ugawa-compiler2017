// Generated from parser/PiLang.g4 by ANTLR 4.6
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ADDOP=15, MULOP=16, ANDOP=17, 
		OROP=18, SUBOP=19, NOTOP=20, IDENTIFIER=21, VALUE=22, WS=23;
	public static final int
		RULE_prog = 0, RULE_funcDecl = 1, RULE_params = 2, RULE_varDecls = 3, 
		RULE_stmt = 4, RULE_expr = 5, RULE_orExpr = 6, RULE_andExpr = 7, RULE_addExpr = 8, 
		RULE_mulExpr = 9, RULE_unaryExpr = 10, RULE_args = 11;
	public static final String[] ruleNames = {
		"prog", "funcDecl", "params", "varDecls", "stmt", "expr", "orExpr", "andExpr", 
		"addExpr", "mulExpr", "unaryExpr", "args"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'function'", "'('", "')'", "'{'", "'}'", "','", "'var'", "';'", 
		"'='", "'if'", "'else'", "'while'", "'return'", "'print'", "'+'", null, 
		"'&'", "'|'", "'-'", "'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "ADDOP", "MULOP", "ANDOP", "OROP", "SUBOP", "NOTOP", 
		"IDENTIFIER", "VALUE", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public VarDeclsContext varDecls() {
			return getRuleContext(VarDeclsContext.class,0);
		}
		public List<FuncDeclContext> funcDecl() {
			return getRuleContexts(FuncDeclContext.class);
		}
		public FuncDeclContext funcDecl(int i) {
			return getRuleContext(FuncDeclContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			varDecls();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(25);
				funcDecl();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PiLangParser.IDENTIFIER, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public VarDeclsContext varDecls() {
			return getRuleContext(VarDeclsContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(T__0);
			setState(32);
			match(IDENTIFIER);
			setState(33);
			match(T__1);
			setState(34);
			params();
			setState(35);
			match(T__2);
			setState(36);
			match(T__3);
			setState(37);
			varDecls();
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(38);
				stmt();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PiLangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PiLangParser.IDENTIFIER, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_params);
		int _la;
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(IDENTIFIER);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(48);
					match(T__5);
					setState(49);
					match(IDENTIFIER);
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclsContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PiLangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PiLangParser.IDENTIFIER, i);
		}
		public VarDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecls; }
	}

	public final VarDeclsContext varDecls() throws RecognitionException {
		VarDeclsContext _localctx = new VarDeclsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(57);
				match(T__6);
				setState(58);
				match(IDENTIFIER);
				setState(59);
				match(T__7);
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class WhileStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class IfStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class CompoundStmtContext extends StmtContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public CompoundStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssignStmtContext extends StmtContext {
		public TerminalNode IDENTIFIER() { return getToken(PiLangParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new CompoundStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(T__3);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(66);
					stmt();
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				match(T__4);
				}
				break;
			case IDENTIFIER:
				_localctx = new AssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(IDENTIFIER);
				setState(74);
				match(T__8);
				setState(75);
				expr();
				setState(76);
				match(T__7);
				}
				break;
			case T__9:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				match(T__9);
				setState(79);
				match(T__1);
				setState(80);
				expr();
				setState(81);
				match(T__2);
				setState(82);
				stmt();
				setState(83);
				match(T__10);
				setState(84);
				stmt();
				}
				break;
			case T__11:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				match(T__11);
				setState(87);
				match(T__1);
				setState(88);
				expr();
				setState(89);
				match(T__2);
				setState(90);
				stmt();
				}
				break;
			case T__12:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				match(T__12);
				setState(93);
				expr();
				setState(94);
				match(T__7);
				}
				break;
			case T__13:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(96);
				match(T__13);
				setState(97);
				expr();
				setState(98);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			orExpr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExprContext extends ParserRuleContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode OROP() { return getToken(PiLangParser.OROP, 0); }
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
	}

	public final OrExprContext orExpr() throws RecognitionException {
		return orExpr(0);
	}

	private OrExprContext orExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OrExprContext _localctx = new OrExprContext(_ctx, _parentState);
		OrExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_orExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(105);
			andExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_orExpr);
					setState(107);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(108);
					match(OROP);
					setState(109);
					andExpr(0);
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndExprContext extends ParserRuleContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public TerminalNode ANDOP() { return getToken(PiLangParser.ANDOP, 0); }
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
	}

	public final AndExprContext andExpr() throws RecognitionException {
		return andExpr(0);
	}

	private AndExprContext andExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExprContext _localctx = new AndExprContext(_ctx, _parentState);
		AndExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_andExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(116);
			addExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpr);
					setState(118);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(119);
					match(ANDOP);
					setState(120);
					addExpr(0);
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AddExprContext extends ParserRuleContext {
		public MulExprContext mulExpr() {
			return getRuleContext(MulExprContext.class,0);
		}
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(PiLangParser.ADDOP, 0); }
		public TerminalNode SUBOP() { return getToken(PiLangParser.SUBOP, 0); }
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
	}

	public final AddExprContext addExpr() throws RecognitionException {
		return addExpr(0);
	}

	private AddExprContext addExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddExprContext _localctx = new AddExprContext(_ctx, _parentState);
		AddExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_addExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(127);
			mulExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(135);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new AddExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addExpr);
						setState(129);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(130);
						match(ADDOP);
						setState(131);
						mulExpr(0);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addExpr);
						setState(132);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(133);
						match(SUBOP);
						setState(134);
						mulExpr(0);
						}
						break;
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public MulExprContext mulExpr() {
			return getRuleContext(MulExprContext.class,0);
		}
		public TerminalNode MULOP() { return getToken(PiLangParser.MULOP, 0); }
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		return mulExpr(0);
	}

	private MulExprContext mulExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulExprContext _localctx = new MulExprContext(_ctx, _parentState);
		MulExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_mulExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(141);
			unaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulExpr);
					setState(143);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(144);
					match(MULOP);
					setState(145);
					unaryExpr();
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	 
		public UnaryExprContext() { }
		public void copyFrom(UnaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarExprContext extends UnaryExprContext {
		public TerminalNode IDENTIFIER() { return getToken(PiLangParser.IDENTIFIER, 0); }
		public VarExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class NotExprContext extends UnaryExprContext {
		public TerminalNode NOTOP() { return getToken(PiLangParser.NOTOP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralExprContext extends UnaryExprContext {
		public TerminalNode VALUE() { return getToken(PiLangParser.VALUE, 0); }
		public LiteralExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class SubExprContext extends UnaryExprContext {
		public TerminalNode SUBOP() { return getToken(PiLangParser.SUBOP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SubExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class CallExprContext extends UnaryExprContext {
		public TerminalNode IDENTIFIER() { return getToken(PiLangParser.IDENTIFIER, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public CallExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExprContext extends UnaryExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unaryExpr);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				match(VALUE);
				}
				break;
			case 2:
				_localctx = new VarExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(IDENTIFIER);
				}
				break;
			case 3:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				match(T__1);
				setState(154);
				expr();
				setState(155);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new SubExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				match(SUBOP);
				setState(158);
				expr();
				}
				break;
			case 5:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				match(NOTOP);
				setState(160);
				expr();
				}
				break;
			case 6:
				_localctx = new CallExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(161);
				match(IDENTIFIER);
				setState(162);
				match(T__1);
				setState(163);
				args();
				setState(164);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_args);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__1:
			case SUBOP:
			case NOTOP:
			case IDENTIFIER:
			case VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				expr();
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(170);
					match(T__5);
					setState(171);
					expr();
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return orExpr_sempred((OrExprContext)_localctx, predIndex);
		case 7:
			return andExpr_sempred((AndExprContext)_localctx, predIndex);
		case 8:
			return addExpr_sempred((AddExprContext)_localctx, predIndex);
		case 9:
			return mulExpr_sempred((MulExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean orExpr_sempred(OrExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean andExpr_sempred(AndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean addExpr_sempred(AddExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mulExpr_sempred(MulExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u00b6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4"+
		"\65\n\4\f\4\16\48\13\4\5\4:\n\4\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B\13\5\3"+
		"\6\3\6\7\6F\n\6\f\6\16\6I\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6g\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bq\n\b\f\b\16\bt\13\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\7\t|\n\t\f\t\16\t\177\13\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\7\n\u008a\n\n\f\n\16\n\u008d\13\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\7\13\u0095\n\13\f\13\16\13\u0098\13\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a9\n\f\3\r\3\r\3\r\3\r"+
		"\7\r\u00af\n\r\f\r\16\r\u00b2\13\r\5\r\u00b4\n\r\3\r\2\6\16\20\22\24\16"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\2\2\u00c0\2\32\3\2\2\2\4!\3\2\2\2\69\3"+
		"\2\2\2\b@\3\2\2\2\nf\3\2\2\2\fh\3\2\2\2\16j\3\2\2\2\20u\3\2\2\2\22\u0080"+
		"\3\2\2\2\24\u008e\3\2\2\2\26\u00a8\3\2\2\2\30\u00b3\3\2\2\2\32\36\5\b"+
		"\5\2\33\35\5\4\3\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2"+
		"\2\37\3\3\2\2\2 \36\3\2\2\2!\"\7\3\2\2\"#\7\27\2\2#$\7\4\2\2$%\5\6\4\2"+
		"%&\7\5\2\2&\'\7\6\2\2\'+\5\b\5\2(*\5\n\6\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2"+
		"\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\7\2\2/\5\3\2\2\2\60:\3\2\2\2\61\66"+
		"\7\27\2\2\62\63\7\b\2\2\63\65\7\27\2\2\64\62\3\2\2\2\658\3\2\2\2\66\64"+
		"\3\2\2\2\66\67\3\2\2\2\67:\3\2\2\28\66\3\2\2\29\60\3\2\2\29\61\3\2\2\2"+
		":\7\3\2\2\2;<\7\t\2\2<=\7\27\2\2=?\7\n\2\2>;\3\2\2\2?B\3\2\2\2@>\3\2\2"+
		"\2@A\3\2\2\2A\t\3\2\2\2B@\3\2\2\2CG\7\6\2\2DF\5\n\6\2ED\3\2\2\2FI\3\2"+
		"\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2Jg\7\7\2\2KL\7\27\2\2LM\7"+
		"\13\2\2MN\5\f\7\2NO\7\n\2\2Og\3\2\2\2PQ\7\f\2\2QR\7\4\2\2RS\5\f\7\2ST"+
		"\7\5\2\2TU\5\n\6\2UV\7\r\2\2VW\5\n\6\2Wg\3\2\2\2XY\7\16\2\2YZ\7\4\2\2"+
		"Z[\5\f\7\2[\\\7\5\2\2\\]\5\n\6\2]g\3\2\2\2^_\7\17\2\2_`\5\f\7\2`a\7\n"+
		"\2\2ag\3\2\2\2bc\7\20\2\2cd\5\f\7\2de\7\n\2\2eg\3\2\2\2fC\3\2\2\2fK\3"+
		"\2\2\2fP\3\2\2\2fX\3\2\2\2f^\3\2\2\2fb\3\2\2\2g\13\3\2\2\2hi\5\16\b\2"+
		"i\r\3\2\2\2jk\b\b\1\2kl\5\20\t\2lr\3\2\2\2mn\f\4\2\2no\7\24\2\2oq\5\20"+
		"\t\2pm\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\17\3\2\2\2tr\3\2\2\2uv\b"+
		"\t\1\2vw\5\22\n\2w}\3\2\2\2xy\f\4\2\2yz\7\23\2\2z|\5\22\n\2{x\3\2\2\2"+
		"|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\21\3\2\2\2\177}\3\2\2\2\u0080\u0081"+
		"\b\n\1\2\u0081\u0082\5\24\13\2\u0082\u008b\3\2\2\2\u0083\u0084\f\5\2\2"+
		"\u0084\u0085\7\21\2\2\u0085\u008a\5\24\13\2\u0086\u0087\f\4\2\2\u0087"+
		"\u0088\7\25\2\2\u0088\u008a\5\24\13\2\u0089\u0083\3\2\2\2\u0089\u0086"+
		"\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\23\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\b\13\1\2\u008f\u0090\5\26"+
		"\f\2\u0090\u0096\3\2\2\2\u0091\u0092\f\4\2\2\u0092\u0093\7\22\2\2\u0093"+
		"\u0095\5\26\f\2\u0094\u0091\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3"+
		"\2\2\2\u0096\u0097\3\2\2\2\u0097\25\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u00a9\7\30\2\2\u009a\u00a9\7\27\2\2\u009b\u009c\7\4\2\2\u009c\u009d\5"+
		"\f\7\2\u009d\u009e\7\5\2\2\u009e\u00a9\3\2\2\2\u009f\u00a0\7\25\2\2\u00a0"+
		"\u00a9\5\f\7\2\u00a1\u00a2\7\26\2\2\u00a2\u00a9\5\f\7\2\u00a3\u00a4\7"+
		"\27\2\2\u00a4\u00a5\7\4\2\2\u00a5\u00a6\5\30\r\2\u00a6\u00a7\7\5\2\2\u00a7"+
		"\u00a9\3\2\2\2\u00a8\u0099\3\2\2\2\u00a8\u009a\3\2\2\2\u00a8\u009b\3\2"+
		"\2\2\u00a8\u009f\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a9"+
		"\27\3\2\2\2\u00aa\u00b4\3\2\2\2\u00ab\u00b0\5\f\7\2\u00ac\u00ad\7\b\2"+
		"\2\u00ad\u00af\5\f\7\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\u00aa\3\2\2\2\u00b3\u00ab\3\2\2\2\u00b4\31\3\2\2\2\21\36+\669@Gfr}\u0089"+
		"\u008b\u0096\u00a8\u00b0\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}