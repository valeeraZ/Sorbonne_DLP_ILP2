// Generated from ILPMLgrammar2tme4.g4 by ANTLR 4.4

    package antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ILPMLgrammar2tme4Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__31=1, T__30=2, T__29=3, T__28=4, T__27=5, T__26=6, T__25=7, T__24=8, 
		T__23=9, T__22=10, T__21=11, T__20=12, T__19=13, T__18=14, T__17=15, T__16=16, 
		T__15=17, T__14=18, T__13=19, T__12=20, T__11=21, T__10=22, T__9=23, T__8=24, 
		T__7=25, T__6=26, T__5=27, T__4=28, T__3=29, T__2=30, T__1=31, T__0=32, 
		IDENT=33, INT=34, FLOAT=35, STRING=36, ESC=37, LINE_COMMENT=38, COMMENT=39, 
		SPACE=40;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'true'", "'!='", "'while'", "'unless'", "';'", "'='", 
		"'if'", "'^'", "'<='", "'&'", "'do'", "'('", "'*'", "','", "'false'", 
		"'>='", "'|'", "'=='", "'<'", "'>'", "'!'", "'let'", "'%'", "'else'", 
		"'in'", "'function'", "')'", "'and'", "'then'", "'+'", "'-'", "IDENT", 
		"INT", "FLOAT", "STRING", "ESC", "LINE_COMMENT", "COMMENT", "SPACE"
	};
	public static final int
		RULE_prog = 0, RULE_globalFunDef = 1, RULE_expr = 2;
	public static final String[] ruleNames = {
		"prog", "globalFunDef", "expr"
	};

	@Override
	public String getGrammarFileName() { return "ILPMLgrammar2tme4.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ILPMLgrammar2tme4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public com.paracamplus.ilp2.interfaces.IASTprogram node;
		public GlobalFunDefContext globalFunDef;
		public List<GlobalFunDefContext> defs = new ArrayList<GlobalFunDefContext>();
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<GlobalFunDefContext> globalFunDef() {
			return getRuleContexts(GlobalFunDefContext.class);
		}
		public TerminalNode EOF() { return getToken(ILPMLgrammar2tme4Parser.EOF, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GlobalFunDefContext globalFunDef(int i) {
			return getRuleContext(GlobalFunDefContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(6); ((ProgContext)_localctx).globalFunDef = globalFunDef();
				((ProgContext)_localctx).defs.add(((ProgContext)_localctx).globalFunDef);
				setState(8);
				_la = _input.LA(1);
				if (_la==T__26) {
					{
					setState(7); match(T__26);
					}
				}

				}
				}
				setState(14);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__28) | (1L << T__24) | (1L << T__19) | (1L << T__16) | (1L << T__10) | (1L << T__9) | (1L << T__0) | (1L << IDENT) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
				{
				{
				setState(15); ((ProgContext)_localctx).expr = expr(0);
				((ProgContext)_localctx).exprs.add(((ProgContext)_localctx).expr);
				setState(17);
				_la = _input.LA(1);
				if (_la==T__26) {
					{
					setState(16); match(T__26);
					}
				}

				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24); match(EOF);
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

	public static class GlobalFunDefContext extends ParserRuleContext {
		public com.paracamplus.ilp2.interfaces.IASTfunctionDefinition node;
		public Token name;
		public Token IDENT;
		public List<Token> vars = new ArrayList<Token>();
		public ExprContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENT(int i) {
			return getToken(ILPMLgrammar2tme4Parser.IDENT, i);
		}
		public List<TerminalNode> IDENT() { return getTokens(ILPMLgrammar2tme4Parser.IDENT); }
		public GlobalFunDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalFunDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterGlobalFunDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitGlobalFunDef(this);
		}
	}

	public final GlobalFunDefContext globalFunDef() throws RecognitionException {
		GlobalFunDefContext _localctx = new GlobalFunDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalFunDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); match(T__5);
			setState(27); ((GlobalFunDefContext)_localctx).name = match(IDENT);
			setState(28); match(T__19);
			setState(30);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(29); ((GlobalFunDefContext)_localctx).IDENT = match(IDENT);
				((GlobalFunDefContext)_localctx).vars.add(((GlobalFunDefContext)_localctx).IDENT);
				}
			}

			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(32); match(T__17);
				setState(33); ((GlobalFunDefContext)_localctx).IDENT = match(IDENT);
				((GlobalFunDefContext)_localctx).vars.add(((GlobalFunDefContext)_localctx).IDENT);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39); match(T__4);
			setState(40); ((GlobalFunDefContext)_localctx).body = expr(0);
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
		public com.paracamplus.ilp1.interfaces.IASTexpression node;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.node = ctx.node;
		}
	}
	public static class BindingContext extends ExprContext {
		public Token IDENT;
		public List<Token> vars = new ArrayList<Token>();
		public ExprContext expr;
		public List<ExprContext> vals = new ArrayList<ExprContext>();
		public ExprContext body;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IDENT(int i) {
			return getToken(ILPMLgrammar2tme4Parser.IDENT, i);
		}
		public List<TerminalNode> IDENT() { return getTokens(ILPMLgrammar2tme4Parser.IDENT); }
		public BindingContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitBinding(this);
		}
	}
	public static class LoopContext extends ExprContext {
		public ExprContext condition;
		public ExprContext body;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LoopContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitLoop(this);
		}
	}
	public static class VariableContext extends ExprContext {
		public Token var;
		public TerminalNode IDENT() { return getToken(ILPMLgrammar2tme4Parser.IDENT, 0); }
		public VariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitVariable(this);
		}
	}
	public static class AlternativeContext extends ExprContext {
		public ExprContext condition;
		public ExprContext consequence;
		public ExprContext alternant;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AlternativeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitAlternative(this);
		}
	}
	public static class InvocationContext extends ExprContext {
		public ExprContext fun;
		public ExprContext expr;
		public List<ExprContext> args = new ArrayList<ExprContext>();
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public InvocationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitInvocation(this);
		}
	}
	public static class ConstFloatContext extends ExprContext {
		public Token floatConst;
		public TerminalNode FLOAT() { return getToken(ILPMLgrammar2tme4Parser.FLOAT, 0); }
		public ConstFloatContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterConstFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitConstFloat(this);
		}
	}
	public static class VariableAssignContext extends ExprContext {
		public Token var;
		public ExprContext val;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(ILPMLgrammar2tme4Parser.IDENT, 0); }
		public VariableAssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterVariableAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitVariableAssign(this);
		}
	}
	public static class SequenceContext extends ExprContext {
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SequenceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitSequence(this);
		}
	}
	public static class ConstFalseContext extends ExprContext {
		public ConstFalseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterConstFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitConstFalse(this);
		}
	}
	public static class UnaryContext extends ExprContext {
		public Token op;
		public ExprContext arg;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitUnary(this);
		}
	}
	public static class ConstTrueContext extends ExprContext {
		public ConstTrueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterConstTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitConstTrue(this);
		}
	}
	public static class ConstIntegerContext extends ExprContext {
		public Token intConst;
		public TerminalNode INT() { return getToken(ILPMLgrammar2tme4Parser.INT, 0); }
		public ConstIntegerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterConstInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitConstInteger(this);
		}
	}
	public static class ConstStringContext extends ExprContext {
		public Token stringConst;
		public TerminalNode STRING() { return getToken(ILPMLgrammar2tme4Parser.STRING, 0); }
		public ConstStringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterConstString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitConstString(this);
		}
	}
	public static class BinaryContext extends ExprContext {
		public ExprContext arg1;
		public Token op;
		public ExprContext arg2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitBinary(this);
		}
	}
	public static class UnlessContext extends ExprContext {
		public ExprContext body;
		public ExprContext condition;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public UnlessContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).enterUnless(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ILPMLgrammar2tme4Listener ) ((ILPMLgrammar2tme4Listener)listener).exitUnless(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(43);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__0) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(44); ((UnaryContext)_localctx).arg = expr(18);
				}
				break;
			case 2:
				{
				_localctx = new BindingContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45); match(T__9);
				setState(46); ((BindingContext)_localctx).IDENT = match(IDENT);
				((BindingContext)_localctx).vars.add(((BindingContext)_localctx).IDENT);
				setState(47); match(T__25);
				setState(48); ((BindingContext)_localctx).expr = expr(0);
				((BindingContext)_localctx).vals.add(((BindingContext)_localctx).expr);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(49); match(T__3);
					setState(50); ((BindingContext)_localctx).IDENT = match(IDENT);
					((BindingContext)_localctx).vars.add(((BindingContext)_localctx).IDENT);
					setState(51); match(T__25);
					setState(52); ((BindingContext)_localctx).expr = expr(0);
					((BindingContext)_localctx).vals.add(((BindingContext)_localctx).expr);
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58); match(T__6);
				setState(59); ((BindingContext)_localctx).body = expr(5);
				}
				break;
			case 3:
				{
				_localctx = new VariableAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61); ((VariableAssignContext)_localctx).var = match(IDENT);
				setState(62); match(T__25);
				setState(63); ((VariableAssignContext)_localctx).val = expr(2);
				}
				break;
			case 4:
				{
				_localctx = new LoopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64); match(T__28);
				setState(65); ((LoopContext)_localctx).condition = expr(0);
				setState(66); match(T__20);
				setState(67); ((LoopContext)_localctx).body = expr(1);
				}
				break;
			case 5:
				{
				_localctx = new SequenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69); match(T__19);
				setState(70); ((SequenceContext)_localctx).expr = expr(0);
				((SequenceContext)_localctx).exprs.add(((SequenceContext)_localctx).expr);
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(72);
						_la = _input.LA(1);
						if (_la==T__26) {
							{
							setState(71); match(T__26);
							}
						}

						setState(74); ((SequenceContext)_localctx).expr = expr(0);
						((SequenceContext)_localctx).exprs.add(((SequenceContext)_localctx).expr);
						}
						} 
					}
					setState(79);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				setState(81);
				_la = _input.LA(1);
				if (_la==T__26) {
					{
					setState(80); match(T__26);
					}
				}

				setState(83); match(T__4);
				}
				break;
			case 6:
				{
				_localctx = new ConstTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85); match(T__30);
				}
				break;
			case 7:
				{
				_localctx = new ConstFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86); match(T__16);
				}
				break;
			case 8:
				{
				_localctx = new ConstIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87); ((ConstIntegerContext)_localctx).intConst = match(INT);
				}
				break;
			case 9:
				{
				_localctx = new ConstFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88); ((ConstFloatContext)_localctx).floatConst = match(FLOAT);
				}
				break;
			case 10:
				{
				_localctx = new ConstStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89); ((ConstStringContext)_localctx).stringConst = match(STRING);
				}
				break;
			case 11:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90); ((VariableContext)_localctx).var = match(IDENT);
				}
				break;
			case 12:
				{
				_localctx = new AlternativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91); match(T__24);
				setState(92); ((AlternativeContext)_localctx).condition = expr(0);
				setState(93); match(T__2);
				setState(94); ((AlternativeContext)_localctx).consequence = expr(0);
				setState(97);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(95); match(T__7);
					setState(96); ((AlternativeContext)_localctx).alternant = expr(0);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(135);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(102);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__18) | (1L << T__8))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(103); ((BinaryContext)_localctx).arg2 = expr(18);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(105);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__0) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(106); ((BinaryContext)_localctx).arg2 = expr(17);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(108);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__15) | (1L << T__12) | (1L << T__11))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(109); ((BinaryContext)_localctx).arg2 = expr(16);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(111);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__13) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(112); ((BinaryContext)_localctx).arg2 = expr(15);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(114); ((BinaryContext)_localctx).op = match(T__21);
						setState(115); ((BinaryContext)_localctx).arg2 = expr(14);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						((BinaryContext)_localctx).arg1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(117);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__14) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(118); ((BinaryContext)_localctx).arg2 = expr(13);
						}
						break;
					case 7:
						{
						_localctx = new UnlessContext(new ExprContext(_parentctx, _parentState));
						((UnlessContext)_localctx).body = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(120); match(T__27);
						setState(121); ((UnlessContext)_localctx).condition = expr(4);
						}
						break;
					case 8:
						{
						_localctx = new InvocationContext(new ExprContext(_parentctx, _parentState));
						((InvocationContext)_localctx).fun = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(122);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(123); match(T__19);
						setState(125);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__28) | (1L << T__24) | (1L << T__19) | (1L << T__16) | (1L << T__10) | (1L << T__9) | (1L << T__0) | (1L << IDENT) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
							{
							setState(124); ((InvocationContext)_localctx).expr = expr(0);
							((InvocationContext)_localctx).args.add(((InvocationContext)_localctx).expr);
							}
						}

						setState(131);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__17) {
							{
							{
							setState(127); match(T__17);
							setState(128); ((InvocationContext)_localctx).expr = expr(0);
							((InvocationContext)_localctx).args.add(((InvocationContext)_localctx).expr);
							}
							}
							setState(133);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(134); match(T__4);
						}
						break;
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 17);
		case 1: return precpred(_ctx, 16);
		case 2: return precpred(_ctx, 15);
		case 3: return precpred(_ctx, 14);
		case 4: return precpred(_ctx, 13);
		case 5: return precpred(_ctx, 12);
		case 6: return precpred(_ctx, 3);
		case 7: return precpred(_ctx, 19);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u008f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\3\2\3\2\5\2\13\n\2\7\2\r\n\2\f\2\16\2\20\13\2\3\2\3\2\5"+
		"\2\24\n\2\7\2\26\n\2\f\2\16\2\31\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3!\n\3"+
		"\3\3\3\3\7\3%\n\3\f\3\16\3(\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4K\n\4\3\4\7\4N\n\4\f\4\16\4Q\13\4\3\4"+
		"\5\4T\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"d\n\4\5\4f\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0080\n\4\3\4\3\4\7\4\u0084"+
		"\n\4\f\4\16\4\u0087\13\4\3\4\7\4\u008a\n\4\f\4\16\4\u008d\13\4\3\4\2\3"+
		"\6\5\2\4\6\2\b\4\2\30\30\"\"\5\2\3\3\20\20\32\32\3\2!\"\5\2\f\f\23\23"+
		"\26\27\4\2\5\5\25\25\4\2\13\13\24\24\u00ab\2\16\3\2\2\2\4\34\3\2\2\2\6"+
		"e\3\2\2\2\b\n\5\4\3\2\t\13\7\b\2\2\n\t\3\2\2\2\n\13\3\2\2\2\13\r\3\2\2"+
		"\2\f\b\3\2\2\2\r\20\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\27\3\2\2\2\20"+
		"\16\3\2\2\2\21\23\5\6\4\2\22\24\7\b\2\2\23\22\3\2\2\2\23\24\3\2\2\2\24"+
		"\26\3\2\2\2\25\21\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30"+
		"\32\3\2\2\2\31\27\3\2\2\2\32\33\7\2\2\3\33\3\3\2\2\2\34\35\7\35\2\2\35"+
		"\36\7#\2\2\36 \7\17\2\2\37!\7#\2\2 \37\3\2\2\2 !\3\2\2\2!&\3\2\2\2\"#"+
		"\7\21\2\2#%\7#\2\2$\"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2"+
		"\2(&\3\2\2\2)*\7\36\2\2*+\5\6\4\2+\5\3\2\2\2,-\b\4\1\2-.\t\2\2\2.f\5\6"+
		"\4\24/\60\7\31\2\2\60\61\7#\2\2\61\62\7\t\2\2\629\5\6\4\2\63\64\7\37\2"+
		"\2\64\65\7#\2\2\65\66\7\t\2\2\668\5\6\4\2\67\63\3\2\2\28;\3\2\2\29\67"+
		"\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\34\2\2=>\5\6\4\7>f\3\2\2\2"+
		"?@\7#\2\2@A\7\t\2\2Af\5\6\4\4BC\7\6\2\2CD\5\6\4\2DE\7\16\2\2EF\5\6\4\3"+
		"Ff\3\2\2\2GH\7\17\2\2HO\5\6\4\2IK\7\b\2\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2"+
		"\2LN\5\6\4\2MJ\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PS\3\2\2\2QO\3\2\2"+
		"\2RT\7\b\2\2SR\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\7\36\2\2Vf\3\2\2\2Wf\7\4"+
		"\2\2Xf\7\22\2\2Yf\7$\2\2Zf\7%\2\2[f\7&\2\2\\f\7#\2\2]^\7\n\2\2^_\5\6\4"+
		"\2_`\7 \2\2`c\5\6\4\2ab\7\33\2\2bd\5\6\4\2ca\3\2\2\2cd\3\2\2\2df\3\2\2"+
		"\2e,\3\2\2\2e/\3\2\2\2e?\3\2\2\2eB\3\2\2\2eG\3\2\2\2eW\3\2\2\2eX\3\2\2"+
		"\2eY\3\2\2\2eZ\3\2\2\2e[\3\2\2\2e\\\3\2\2\2e]\3\2\2\2f\u008b\3\2\2\2g"+
		"h\f\23\2\2hi\t\3\2\2i\u008a\5\6\4\24jk\f\22\2\2kl\t\4\2\2l\u008a\5\6\4"+
		"\23mn\f\21\2\2no\t\5\2\2o\u008a\5\6\4\22pq\f\20\2\2qr\t\6\2\2r\u008a\5"+
		"\6\4\21st\f\17\2\2tu\7\r\2\2u\u008a\5\6\4\20vw\f\16\2\2wx\t\7\2\2x\u008a"+
		"\5\6\4\17yz\f\5\2\2z{\7\7\2\2{\u008a\5\6\4\6|}\f\25\2\2}\177\7\17\2\2"+
		"~\u0080\5\6\4\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0085\3\2\2\2\u0081"+
		"\u0082\7\21\2\2\u0082\u0084\5\6\4\2\u0083\u0081\3\2\2\2\u0084\u0087\3"+
		"\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0088\u008a\7\36\2\2\u0089g\3\2\2\2\u0089j\3\2\2\2\u0089"+
		"m\3\2\2\2\u0089p\3\2\2\2\u0089s\3\2\2\2\u0089v\3\2\2\2\u0089y\3\2\2\2"+
		"\u0089|\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\7\3\2\2\2\u008d\u008b\3\2\2\2\22\n\16\23\27 &9JOSce\177\u0085"+
		"\u0089\u008b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}