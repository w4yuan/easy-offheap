// Generated from /Users/siyuan03.wang/code/h2o/easy-offheap-generator/src/main/java/com/vip/easy_offheap/parser/EasyOffheap.g4 by ANTLR 4.13.1
package w4yuan.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class EasyOffheapLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, PACKAGE=2, ORIGIN=3, REPEATED=4, STRUCT=5, LONG=6, STRING=7, BYTE=8, 
		BOOLEAN=9, FLOAT=10, DOUBLE=11, INT=12, CHAR=13, DEFAULT=14, EQUAL=15, 
		SEMI=16, LCURLY=17, RCURLY=18, DOT=19, ID=20, LITERAL=21, INTLIT=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "PACKAGE", "ORIGIN", "REPEATED", "STRUCT", "LONG", "STRING", 
			"BYTE", "BOOLEAN", "FLOAT", "DOUBLE", "INT", "CHAR", "DEFAULT", "EQUAL", 
			"SEMI", "LCURLY", "RCURLY", "DOT", "ID", "LITERAL", "INTLIT", "WS"
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


	public EasyOffheapLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EasyOffheap.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0017\u00a4\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u0092\b\u0013\n\u0013\f\u0013\u0095"+
		"\t\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0004\u0015\u009a\b\u0015"+
		"\u000b\u0015\f\u0015\u009b\u0001\u0016\u0004\u0016\u009f\b\u0016\u000b"+
		"\u0016\f\u0016\u00a0\u0001\u0016\u0001\u0016\u0000\u0000\u0017\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017\u0001\u0000"+
		"\u0004\u0002\u0000<<>>\u0003\u0000AZ__az\u0001\u000009\u0003\u0000\t\n"+
		"\r\r  \u00a8\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0001/\u0001\u0000\u0000\u0000\u00031\u0001\u0000\u0000\u0000\u0005"+
		"9\u0001\u0000\u0000\u0000\u0007@\u0001\u0000\u0000\u0000\tI\u0001\u0000"+
		"\u0000\u0000\u000bP\u0001\u0000\u0000\u0000\rU\u0001\u0000\u0000\u0000"+
		"\u000f\\\u0001\u0000\u0000\u0000\u0011a\u0001\u0000\u0000\u0000\u0013"+
		"i\u0001\u0000\u0000\u0000\u0015o\u0001\u0000\u0000\u0000\u0017v\u0001"+
		"\u0000\u0000\u0000\u0019z\u0001\u0000\u0000\u0000\u001b\u007f\u0001\u0000"+
		"\u0000\u0000\u001d\u0083\u0001\u0000\u0000\u0000\u001f\u0085\u0001\u0000"+
		"\u0000\u0000!\u0087\u0001\u0000\u0000\u0000#\u0089\u0001\u0000\u0000\u0000"+
		"%\u008b\u0001\u0000\u0000\u0000\'\u008d\u0001\u0000\u0000\u0000)\u0096"+
		"\u0001\u0000\u0000\u0000+\u0099\u0001\u0000\u0000\u0000-\u009e\u0001\u0000"+
		"\u0000\u0000/0\u0005-\u0000\u00000\u0002\u0001\u0000\u0000\u000012\u0005"+
		"p\u0000\u000023\u0005a\u0000\u000034\u0005c\u0000\u000045\u0005k\u0000"+
		"\u000056\u0005a\u0000\u000067\u0005g\u0000\u000078\u0005e\u0000\u0000"+
		"8\u0004\u0001\u0000\u0000\u00009:\u0005o\u0000\u0000:;\u0005r\u0000\u0000"+
		";<\u0005i\u0000\u0000<=\u0005g\u0000\u0000=>\u0005i\u0000\u0000>?\u0005"+
		"n\u0000\u0000?\u0006\u0001\u0000\u0000\u0000@A\u0005r\u0000\u0000AB\u0005"+
		"e\u0000\u0000BC\u0005p\u0000\u0000CD\u0005e\u0000\u0000DE\u0005a\u0000"+
		"\u0000EF\u0005t\u0000\u0000FG\u0005e\u0000\u0000GH\u0005d\u0000\u0000"+
		"H\b\u0001\u0000\u0000\u0000IJ\u0005s\u0000\u0000JK\u0005t\u0000\u0000"+
		"KL\u0005r\u0000\u0000LM\u0005u\u0000\u0000MN\u0005c\u0000\u0000NO\u0005"+
		"t\u0000\u0000O\n\u0001\u0000\u0000\u0000PQ\u0005l\u0000\u0000QR\u0005"+
		"o\u0000\u0000RS\u0005n\u0000\u0000ST\u0005g\u0000\u0000T\f\u0001\u0000"+
		"\u0000\u0000UV\u0005s\u0000\u0000VW\u0005t\u0000\u0000WX\u0005r\u0000"+
		"\u0000XY\u0005i\u0000\u0000YZ\u0005n\u0000\u0000Z[\u0005g\u0000\u0000"+
		"[\u000e\u0001\u0000\u0000\u0000\\]\u0005b\u0000\u0000]^\u0005y\u0000\u0000"+
		"^_\u0005t\u0000\u0000_`\u0005e\u0000\u0000`\u0010\u0001\u0000\u0000\u0000"+
		"ab\u0005b\u0000\u0000bc\u0005o\u0000\u0000cd\u0005o\u0000\u0000de\u0005"+
		"l\u0000\u0000ef\u0005e\u0000\u0000fg\u0005a\u0000\u0000gh\u0005n\u0000"+
		"\u0000h\u0012\u0001\u0000\u0000\u0000ij\u0005f\u0000\u0000jk\u0005l\u0000"+
		"\u0000kl\u0005o\u0000\u0000lm\u0005a\u0000\u0000mn\u0005t\u0000\u0000"+
		"n\u0014\u0001\u0000\u0000\u0000op\u0005d\u0000\u0000pq\u0005o\u0000\u0000"+
		"qr\u0005u\u0000\u0000rs\u0005b\u0000\u0000st\u0005l\u0000\u0000tu\u0005"+
		"e\u0000\u0000u\u0016\u0001\u0000\u0000\u0000vw\u0005i\u0000\u0000wx\u0005"+
		"n\u0000\u0000xy\u0005t\u0000\u0000y\u0018\u0001\u0000\u0000\u0000z{\u0005"+
		"c\u0000\u0000{|\u0005h\u0000\u0000|}\u0005a\u0000\u0000}~\u0005r\u0000"+
		"\u0000~\u001a\u0001\u0000\u0000\u0000\u007f\u0080\u0005d\u0000\u0000\u0080"+
		"\u0081\u0005e\u0000\u0000\u0081\u0082\u0005f\u0000\u0000\u0082\u001c\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0005=\u0000\u0000\u0084\u001e\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0005;\u0000\u0000\u0086 \u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0005{\u0000\u0000\u0088\"\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0005}\u0000\u0000\u008a$\u0001\u0000\u0000\u0000\u008b\u008c\u0005"+
		".\u0000\u0000\u008c&\u0001\u0000\u0000\u0000\u008d\u0093\u0003)\u0014"+
		"\u0000\u008e\u0092\u0003)\u0014\u0000\u008f\u0092\u0003+\u0015\u0000\u0090"+
		"\u0092\u0007\u0000\u0000\u0000\u0091\u008e\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0001\u0000\u0000\u0000\u0094(\u0001\u0000\u0000\u0000\u0095\u0093"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0007\u0001\u0000\u0000\u0097*\u0001"+
		"\u0000\u0000\u0000\u0098\u009a\u0007\u0002\u0000\u0000\u0099\u0098\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0099\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c,\u0001\u0000"+
		"\u0000\u0000\u009d\u009f\u0007\u0003\u0000\u0000\u009e\u009d\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0006\u0016\u0000\u0000\u00a3.\u0001\u0000\u0000"+
		"\u0000\u0005\u0000\u0091\u0093\u009b\u00a0\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
