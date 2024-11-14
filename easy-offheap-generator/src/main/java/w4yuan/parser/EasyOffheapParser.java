// Generated from /Users/siyuan03.wang/code/h2o/easy-offheap-generator/src/main/java/com/vip/easy_offheap/parser/EasyOffheap.g4 by ANTLR 4.13.1
package w4yuan.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EasyOffheapParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, PACKAGE=2, ORIGIN=3, REPEATED=4, STRUCT=5, LONG=6, STRING=7, BYTE=8, 
		BOOLEAN=9, FLOAT=10, DOUBLE=11, INT=12, CHAR=13, DEFAULT=14, EQUAL=15, 
		SEMI=16, LCURLY=17, RCURLY=18, DOT=19, ID=20, LITERAL=21, INTLIT=22, WS=23;
	public static final int
		RULE_idlFile = 0, RULE_package = 1, RULE_package_name = 2, RULE_structDef = 3, 
		RULE_fieldDef = 4, RULE_defaultDef = 5, RULE_defValue = 6, RULE_fieldType = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"idlFile", "package", "package_name", "structDef", "fieldDef", "defaultDef", 
			"defValue", "fieldType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'package'", "'origin'", "'repeated'", "'struct'", "'long'", 
			"'string'", "'byte'", "'boolean'", "'float'", "'double'", "'int'", "'char'", 
			"'def'", "'='", "';'", "'{'", "'}'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "PACKAGE", "ORIGIN", "REPEATED", "STRUCT", "LONG", "STRING", 
			"BYTE", "BOOLEAN", "FLOAT", "DOUBLE", "INT", "CHAR", "DEFAULT", "EQUAL", 
			"SEMI", "LCURLY", "RCURLY", "DOT", "ID", "LITERAL", "INTLIT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "EasyOffheap.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EasyOffheapParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdlFileContext extends ParserRuleContext {
		public PackageContext package_() {
			return getRuleContext(PackageContext.class,0);
		}
		public List<StructDefContext> structDef() {
			return getRuleContexts(StructDefContext.class);
		}
		public StructDefContext structDef(int i) {
			return getRuleContext(StructDefContext.class,i);
		}
		public IdlFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idlFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).enterIdlFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).exitIdlFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyOffheapVisitor ) return ((EasyOffheapVisitor<? extends T>)visitor).visitIdlFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdlFileContext idlFile() throws RecognitionException {
		IdlFileContext _localctx = new IdlFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_idlFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(16);
				package_();
				}
			}

			setState(20); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(19);
				structDef();
				}
				}
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRUCT );
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

	@SuppressWarnings("CheckReturnValue")
	public static class PackageContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(EasyOffheapParser.PACKAGE, 0); }
		public Package_nameContext package_name() {
			return getRuleContext(Package_nameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(EasyOffheapParser.SEMI, 0); }
		public PackageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_package; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).enterPackage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).exitPackage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyOffheapVisitor ) return ((EasyOffheapVisitor<? extends T>)visitor).visitPackage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageContext package_() throws RecognitionException {
		PackageContext _localctx = new PackageContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_package);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(PACKAGE);
			setState(25);
			package_name();
			setState(26);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Package_nameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(EasyOffheapParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyOffheapParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(EasyOffheapParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(EasyOffheapParser.DOT, i);
		}
		public Package_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_package_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).enterPackage_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).exitPackage_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyOffheapVisitor ) return ((EasyOffheapVisitor<? extends T>)visitor).visitPackage_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Package_nameContext package_name() throws RecognitionException {
		Package_nameContext _localctx = new Package_nameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_package_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(ID);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(29);
				match(DOT);
				setState(30);
				match(ID);
				}
				}
				setState(35);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructDefContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(EasyOffheapParser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(EasyOffheapParser.ID, 0); }
		public TerminalNode LCURLY() { return getToken(EasyOffheapParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(EasyOffheapParser.RCURLY, 0); }
		public List<FieldDefContext> fieldDef() {
			return getRuleContexts(FieldDefContext.class);
		}
		public FieldDefContext fieldDef(int i) {
			return getRuleContext(FieldDefContext.class,i);
		}
		public StructDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).enterStructDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).exitStructDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyOffheapVisitor ) return ((EasyOffheapVisitor<? extends T>)visitor).visitStructDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDefContext structDef() throws RecognitionException {
		StructDefContext _localctx = new StructDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(STRUCT);
			setState(37);
			match(ID);
			setState(38);
			match(LCURLY);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1064920L) != 0)) {
				{
				{
				setState(39);
				fieldDef();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			match(RCURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDefContext extends ParserRuleContext {
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(EasyOffheapParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(EasyOffheapParser.EQUAL, 0); }
		public TerminalNode INTLIT() { return getToken(EasyOffheapParser.INTLIT, 0); }
		public TerminalNode SEMI() { return getToken(EasyOffheapParser.SEMI, 0); }
		public TerminalNode ORIGIN() { return getToken(EasyOffheapParser.ORIGIN, 0); }
		public TerminalNode REPEATED() { return getToken(EasyOffheapParser.REPEATED, 0); }
		public DefaultDefContext defaultDef() {
			return getRuleContext(DefaultDefContext.class,0);
		}
		public FieldDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).enterFieldDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).exitFieldDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyOffheapVisitor ) return ((EasyOffheapVisitor<? extends T>)visitor).visitFieldDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDefContext fieldDef() throws RecognitionException {
		FieldDefContext _localctx = new FieldDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORIGIN) {
				{
				setState(47);
				match(ORIGIN);
				}
			}

			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REPEATED) {
				{
				setState(50);
				match(REPEATED);
				}
			}

			setState(53);
			fieldType();
			setState(54);
			match(ID);
			setState(55);
			match(EQUAL);
			setState(56);
			match(INTLIT);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(57);
				defaultDef();
				}
			}

			setState(60);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultDefContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(EasyOffheapParser.DEFAULT, 0); }
		public DefValueContext defValue() {
			return getRuleContext(DefValueContext.class,0);
		}
		public DefaultDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).enterDefaultDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).exitDefaultDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyOffheapVisitor ) return ((EasyOffheapVisitor<? extends T>)visitor).visitDefaultDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultDefContext defaultDef() throws RecognitionException {
		DefaultDefContext _localctx = new DefaultDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defaultDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(DEFAULT);
			setState(63);
			defValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefValueContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(EasyOffheapParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyOffheapParser.ID, i);
		}
		public List<TerminalNode> INTLIT() { return getTokens(EasyOffheapParser.INTLIT); }
		public TerminalNode INTLIT(int i) {
			return getToken(EasyOffheapParser.INTLIT, i);
		}
		public List<TerminalNode> DOT() { return getTokens(EasyOffheapParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(EasyOffheapParser.DOT, i);
		}
		public DefValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).enterDefValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).exitDefValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyOffheapVisitor ) return ((EasyOffheapVisitor<? extends T>)visitor).visitDefValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefValueContext defValue() throws RecognitionException {
		DefValueContext _localctx = new DefValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_defValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 5767170L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 5767170L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldTypeContext extends ParserRuleContext {
		public TerminalNode LONG() { return getToken(EasyOffheapParser.LONG, 0); }
		public TerminalNode STRING() { return getToken(EasyOffheapParser.STRING, 0); }
		public TerminalNode BYTE() { return getToken(EasyOffheapParser.BYTE, 0); }
		public TerminalNode BOOLEAN() { return getToken(EasyOffheapParser.BOOLEAN, 0); }
		public TerminalNode FLOAT() { return getToken(EasyOffheapParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(EasyOffheapParser.DOUBLE, 0); }
		public TerminalNode INT() { return getToken(EasyOffheapParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(EasyOffheapParser.CHAR, 0); }
		public TerminalNode ID() { return getToken(EasyOffheapParser.ID, 0); }
		public FieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).enterFieldType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyOffheapListener ) ((EasyOffheapListener)listener).exitFieldType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyOffheapVisitor ) return ((EasyOffheapVisitor<? extends T>)visitor).visitFieldType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldTypeContext fieldType() throws RecognitionException {
		FieldTypeContext _localctx = new FieldTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1064896L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001\u0017I\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0003\u0000\u0012\b\u0000\u0001\u0000\u0004\u0000\u0015\b\u0000"+
		"\u000b\u0000\f\u0000\u0016\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002 \b\u0002\n\u0002\f\u0002"+
		"#\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		")\b\u0003\n\u0003\f\u0003,\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0003\u00041\b\u0004\u0001\u0004\u0003\u00044\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004;\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0004"+
		"\u0006C\b\u0006\u000b\u0006\f\u0006D\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0002\u0003\u0000"+
		"\u0001\u0001\u0013\u0014\u0016\u0016\u0002\u0000\u0006\r\u0014\u0014H"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0002\u0018\u0001\u0000\u0000\u0000"+
		"\u0004\u001c\u0001\u0000\u0000\u0000\u0006$\u0001\u0000\u0000\u0000\b"+
		"0\u0001\u0000\u0000\u0000\n>\u0001\u0000\u0000\u0000\fB\u0001\u0000\u0000"+
		"\u0000\u000eF\u0001\u0000\u0000\u0000\u0010\u0012\u0003\u0002\u0001\u0000"+
		"\u0011\u0010\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000"+
		"\u0012\u0014\u0001\u0000\u0000\u0000\u0013\u0015\u0003\u0006\u0003\u0000"+
		"\u0014\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000"+
		"\u0016\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000"+
		"\u0017\u0001\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0002\u0000\u0000"+
		"\u0019\u001a\u0003\u0004\u0002\u0000\u001a\u001b\u0005\u0010\u0000\u0000"+
		"\u001b\u0003\u0001\u0000\u0000\u0000\u001c!\u0005\u0014\u0000\u0000\u001d"+
		"\u001e\u0005\u0013\u0000\u0000\u001e \u0005\u0014\u0000\u0000\u001f\u001d"+
		"\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0005\u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000$%\u0005\u0005\u0000\u0000%&\u0005\u0014\u0000"+
		"\u0000&*\u0005\u0011\u0000\u0000\')\u0003\b\u0004\u0000(\'\u0001\u0000"+
		"\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001"+
		"\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000"+
		"-.\u0005\u0012\u0000\u0000.\u0007\u0001\u0000\u0000\u0000/1\u0005\u0003"+
		"\u0000\u00000/\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0001"+
		"\u0000\u0000\u000024\u0005\u0004\u0000\u000032\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000056\u0003\u000e\u0007"+
		"\u000067\u0005\u0014\u0000\u000078\u0005\u000f\u0000\u00008:\u0005\u0016"+
		"\u0000\u00009;\u0003\n\u0005\u0000:9\u0001\u0000\u0000\u0000:;\u0001\u0000"+
		"\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0005\u0010\u0000\u0000=\t\u0001"+
		"\u0000\u0000\u0000>?\u0005\u000e\u0000\u0000?@\u0003\f\u0006\u0000@\u000b"+
		"\u0001\u0000\u0000\u0000AC\u0007\u0000\u0000\u0000BA\u0001\u0000\u0000"+
		"\u0000CD\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000"+
		"\u0000\u0000E\r\u0001\u0000\u0000\u0000FG\u0007\u0001\u0000\u0000G\u000f"+
		"\u0001\u0000\u0000\u0000\b\u0011\u0016!*03:D";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
