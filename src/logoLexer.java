// Generated from C:/Users/alfab/Desktop/Practica Para el Examen 2/Logo/src\logo.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class logoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, STRING=70, BRACKET_OPEN=71, BRACKET_CLOSE=72, 
		PAR_OPEN=73, PAR_CLOSE=74, COMMENT=75, NOMBRE=76, NUMERO=77, BOOL=78, 
		CARACTER=79, WS=80;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
			"T__57", "T__58", "T__59", "T__60", "T__61", "T__62", "T__63", "T__64", 
			"T__65", "T__66", "T__67", "T__68", "STRING", "BRACKET_OPEN", "BRACKET_CLOSE", 
			"PAR_OPEN", "PAR_CLOSE", "COMMENT", "NOMBRE", "NUMERO", "BOOL", "CARACTER", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'para'", "'fin'", "'haz'", "'inic'", "'='", "'inc'", "'avanza'", 
			"'av'", "'retrocede'", "'re'", "'giraDerecha'", "'gd'", "'giraIzquierda'", 
			"'gi'", "'ocultatortuga'", "'ot'", "'aparecetortuga'", "'at'", "'ponpos'", 
			"'ponxy'", "'ponrumbo'", "'rumbo'", "'ponx'", "'pony'", "'imprimir'", 
			"'goma'", "'bajalapiz'", "'bl'", "'subelapiz'", "'sb'", "'poncolorlapiz'", 
			"'poncl'", "'centro'", "'espera'", "'ejecuta'", "'repite'", "'si'", "'sisino'", 
			"'haz.hasta'", "'hasta'", "'haz.mientras'", "'mientras'", "'iguales?'", 
			"'y'", "'o'", "'<'", "'>'", "'mayorque?'", "'menorque?'", "'redondea'", 
			"'azar'", "'menos'", "'producto'", "'potencia'", "'division'", "'resto'", 
			"'diferencia'", "'suma'", "'elegir'", "'cuenta'", "'ultimo'", "'ul'", 
			"'elemento'", "'primero'", "'borraPantalla'", "'+'", "'-'", "'*'", "'/'", 
			null, "'['", "']'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "STRING", 
			"BRACKET_OPEN", "BRACKET_CLOSE", "PAR_OPEN", "PAR_CLOSE", "COMMENT", 
			"NOMBRE", "NUMERO", "BOOL", "CARACTER", "WS"
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
	public void notifyListeners(LexerNoViableAltException e) {
		String text = this._input.getText(Interval.of(this._tokenStartCharIndex, this._input.index()));
		String msg = "error de reconocimiento de token : '" + this.getErrorDisplay(text) + "'";
		ANTLRErrorListener listener = this.getErrorListenerDispatch();
		listener.syntaxError(this, (Object)null, this._tokenStartLine, this._tokenStartCharPositionInLine, msg, e);
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


	public logoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "logo.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2R\u02e0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3"+
		")\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\38\38\38\38\38\38\38\38\38\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3:"+
		"\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3>"+
		"\3>\3>\3>\3>\3>\3>\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A"+
		"\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C\3D\3D\3E\3E"+
		"\3F\3F\3G\3G\3G\3G\7G\u0272\nG\fG\16G\u0275\13G\3G\3G\3H\3H\3I\3I\3J\3"+
		"J\3K\3K\3L\3L\3L\3L\7L\u0285\nL\fL\16L\u0288\13L\3M\3M\3M\3M\3M\3M\3M"+
		"\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M"+
		"\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M"+
		"\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\5M\u02c9\nM\3N\6N\u02cc\nN\rN\16N\u02cd"+
		"\3O\3O\3O\3O\3O\3O\3O\3O\3O\5O\u02d9\nO\3P\3P\3Q\3Q\3Q\3Q\3\u0273\2R\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9"+
		"q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008f"+
		"I\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1R\3\2\7"+
		"\4\2\f\f\17\17\3\2c|\3\2\62;\b\2((//\62;B\\aac|\5\2\13\f\17\17\"\"\2\u02ed"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\3\u00a3\3\2\2\2\5\u00a8\3\2\2\2\7\u00ac\3\2\2\2\t\u00b0"+
		"\3\2\2\2\13\u00b5\3\2\2\2\r\u00b7\3\2\2\2\17\u00bb\3\2\2\2\21\u00c2\3"+
		"\2\2\2\23\u00c5\3\2\2\2\25\u00cf\3\2\2\2\27\u00d2\3\2\2\2\31\u00de\3\2"+
		"\2\2\33\u00e1\3\2\2\2\35\u00ef\3\2\2\2\37\u00f2\3\2\2\2!\u0100\3\2\2\2"+
		"#\u0103\3\2\2\2%\u0112\3\2\2\2\'\u0115\3\2\2\2)\u011c\3\2\2\2+\u0122\3"+
		"\2\2\2-\u012b\3\2\2\2/\u0131\3\2\2\2\61\u0136\3\2\2\2\63\u013b\3\2\2\2"+
		"\65\u0144\3\2\2\2\67\u0149\3\2\2\29\u0153\3\2\2\2;\u0156\3\2\2\2=\u0160"+
		"\3\2\2\2?\u0163\3\2\2\2A\u0171\3\2\2\2C\u0177\3\2\2\2E\u017e\3\2\2\2G"+
		"\u0185\3\2\2\2I\u018d\3\2\2\2K\u0194\3\2\2\2M\u0197\3\2\2\2O\u019e\3\2"+
		"\2\2Q\u01a8\3\2\2\2S\u01ae\3\2\2\2U\u01bb\3\2\2\2W\u01c4\3\2\2\2Y\u01cd"+
		"\3\2\2\2[\u01cf\3\2\2\2]\u01d1\3\2\2\2_\u01d3\3\2\2\2a\u01d5\3\2\2\2c"+
		"\u01df\3\2\2\2e\u01e9\3\2\2\2g\u01f2\3\2\2\2i\u01f7\3\2\2\2k\u01fd\3\2"+
		"\2\2m\u0206\3\2\2\2o\u020f\3\2\2\2q\u0218\3\2\2\2s\u021e\3\2\2\2u\u0229"+
		"\3\2\2\2w\u022e\3\2\2\2y\u0235\3\2\2\2{\u023c\3\2\2\2}\u0243\3\2\2\2\177"+
		"\u0246\3\2\2\2\u0081\u024f\3\2\2\2\u0083\u0257\3\2\2\2\u0085\u0265\3\2"+
		"\2\2\u0087\u0267\3\2\2\2\u0089\u0269\3\2\2\2\u008b\u026b\3\2\2\2\u008d"+
		"\u026d\3\2\2\2\u008f\u0278\3\2\2\2\u0091\u027a\3\2\2\2\u0093\u027c\3\2"+
		"\2\2\u0095\u027e\3\2\2\2\u0097\u0280\3\2\2\2\u0099\u02c8\3\2\2\2\u009b"+
		"\u02cb\3\2\2\2\u009d\u02d8\3\2\2\2\u009f\u02da\3\2\2\2\u00a1\u02dc\3\2"+
		"\2\2\u00a3\u00a4\7r\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7"+
		"\7c\2\2\u00a7\4\3\2\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab"+
		"\7p\2\2\u00ab\6\3\2\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af"+
		"\7|\2\2\u00af\b\3\2\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3"+
		"\7k\2\2\u00b3\u00b4\7e\2\2\u00b4\n\3\2\2\2\u00b5\u00b6\7?\2\2\u00b6\f"+
		"\3\2\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7e\2\2\u00ba"+
		"\16\3\2\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd\7x\2\2\u00bd\u00be\7c\2\2\u00be"+
		"\u00bf\7p\2\2\u00bf\u00c0\7|\2\2\u00c0\u00c1\7c\2\2\u00c1\20\3\2\2\2\u00c2"+
		"\u00c3\7c\2\2\u00c3\u00c4\7x\2\2\u00c4\22\3\2\2\2\u00c5\u00c6\7t\2\2\u00c6"+
		"\u00c7\7g\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7t\2\2\u00c9\u00ca\7q\2\2"+
		"\u00ca\u00cb\7e\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7f\2\2\u00cd\u00ce"+
		"\7g\2\2\u00ce\24\3\2\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7g\2\2\u00d1\26"+
		"\3\2\2\2\u00d2\u00d3\7i\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7t\2\2\u00d5"+
		"\u00d6\7c\2\2\u00d6\u00d7\7F\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7t\2\2"+
		"\u00d9\u00da\7g\2\2\u00da\u00db\7e\2\2\u00db\u00dc\7j\2\2\u00dc\u00dd"+
		"\7c\2\2\u00dd\30\3\2\2\2\u00de\u00df\7i\2\2\u00df\u00e0\7f\2\2\u00e0\32"+
		"\3\2\2\2\u00e1\u00e2\7i\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7t\2\2\u00e4"+
		"\u00e5\7c\2\2\u00e5\u00e6\7K\2\2\u00e6\u00e7\7|\2\2\u00e7\u00e8\7s\2\2"+
		"\u00e8\u00e9\7w\2\2\u00e9\u00ea\7k\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec"+
		"\7t\2\2\u00ec\u00ed\7f\2\2\u00ed\u00ee\7c\2\2\u00ee\34\3\2\2\2\u00ef\u00f0"+
		"\7i\2\2\u00f0\u00f1\7k\2\2\u00f1\36\3\2\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4"+
		"\7e\2\2\u00f4\u00f5\7w\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7\7v\2\2\u00f7"+
		"\u00f8\7c\2\2\u00f8\u00f9\7v\2\2\u00f9\u00fa\7q\2\2\u00fa\u00fb\7t\2\2"+
		"\u00fb\u00fc\7v\2\2\u00fc\u00fd\7w\2\2\u00fd\u00fe\7i\2\2\u00fe\u00ff"+
		"\7c\2\2\u00ff \3\2\2\2\u0100\u0101\7q\2\2\u0101\u0102\7v\2\2\u0102\"\3"+
		"\2\2\2\u0103\u0104\7c\2\2\u0104\u0105\7r\2\2\u0105\u0106\7c\2\2\u0106"+
		"\u0107\7t\2\2\u0107\u0108\7g\2\2\u0108\u0109\7e\2\2\u0109\u010a\7g\2\2"+
		"\u010a\u010b\7v\2\2\u010b\u010c\7q\2\2\u010c\u010d\7t\2\2\u010d\u010e"+
		"\7v\2\2\u010e\u010f\7w\2\2\u010f\u0110\7i\2\2\u0110\u0111\7c\2\2\u0111"+
		"$\3\2\2\2\u0112\u0113\7c\2\2\u0113\u0114\7v\2\2\u0114&\3\2\2\2\u0115\u0116"+
		"\7r\2\2\u0116\u0117\7q\2\2\u0117\u0118\7p\2\2\u0118\u0119\7r\2\2\u0119"+
		"\u011a\7q\2\2\u011a\u011b\7u\2\2\u011b(\3\2\2\2\u011c\u011d\7r\2\2\u011d"+
		"\u011e\7q\2\2\u011e\u011f\7p\2\2\u011f\u0120\7z\2\2\u0120\u0121\7{\2\2"+
		"\u0121*\3\2\2\2\u0122\u0123\7r\2\2\u0123\u0124\7q\2\2\u0124\u0125\7p\2"+
		"\2\u0125\u0126\7t\2\2\u0126\u0127\7w\2\2\u0127\u0128\7o\2\2\u0128\u0129"+
		"\7d\2\2\u0129\u012a\7q\2\2\u012a,\3\2\2\2\u012b\u012c\7t\2\2\u012c\u012d"+
		"\7w\2\2\u012d\u012e\7o\2\2\u012e\u012f\7d\2\2\u012f\u0130\7q\2\2\u0130"+
		".\3\2\2\2\u0131\u0132\7r\2\2\u0132\u0133\7q\2\2\u0133\u0134\7p\2\2\u0134"+
		"\u0135\7z\2\2\u0135\60\3\2\2\2\u0136\u0137\7r\2\2\u0137\u0138\7q\2\2\u0138"+
		"\u0139\7p\2\2\u0139\u013a\7{\2\2\u013a\62\3\2\2\2\u013b\u013c\7k\2\2\u013c"+
		"\u013d\7o\2\2\u013d\u013e\7r\2\2\u013e\u013f\7t\2\2\u013f\u0140\7k\2\2"+
		"\u0140\u0141\7o\2\2\u0141\u0142\7k\2\2\u0142\u0143\7t\2\2\u0143\64\3\2"+
		"\2\2\u0144\u0145\7i\2\2\u0145\u0146\7q\2\2\u0146\u0147\7o\2\2\u0147\u0148"+
		"\7c\2\2\u0148\66\3\2\2\2\u0149\u014a\7d\2\2\u014a\u014b\7c\2\2\u014b\u014c"+
		"\7l\2\2\u014c\u014d\7c\2\2\u014d\u014e\7n\2\2\u014e\u014f\7c\2\2\u014f"+
		"\u0150\7r\2\2\u0150\u0151\7k\2\2\u0151\u0152\7|\2\2\u01528\3\2\2\2\u0153"+
		"\u0154\7d\2\2\u0154\u0155\7n\2\2\u0155:\3\2\2\2\u0156\u0157\7u\2\2\u0157"+
		"\u0158\7w\2\2\u0158\u0159\7d\2\2\u0159\u015a\7g\2\2\u015a\u015b\7n\2\2"+
		"\u015b\u015c\7c\2\2\u015c\u015d\7r\2\2\u015d\u015e\7k\2\2\u015e\u015f"+
		"\7|\2\2\u015f<\3\2\2\2\u0160\u0161\7u\2\2\u0161\u0162\7d\2\2\u0162>\3"+
		"\2\2\2\u0163\u0164\7r\2\2\u0164\u0165\7q\2\2\u0165\u0166\7p\2\2\u0166"+
		"\u0167\7e\2\2\u0167\u0168\7q\2\2\u0168\u0169\7n\2\2\u0169\u016a\7q\2\2"+
		"\u016a\u016b\7t\2\2\u016b\u016c\7n\2\2\u016c\u016d\7c\2\2\u016d\u016e"+
		"\7r\2\2\u016e\u016f\7k\2\2\u016f\u0170\7|\2\2\u0170@\3\2\2\2\u0171\u0172"+
		"\7r\2\2\u0172\u0173\7q\2\2\u0173\u0174\7p\2\2\u0174\u0175\7e\2\2\u0175"+
		"\u0176\7n\2\2\u0176B\3\2\2\2\u0177\u0178\7e\2\2\u0178\u0179\7g\2\2\u0179"+
		"\u017a\7p\2\2\u017a\u017b\7v\2\2\u017b\u017c\7t\2\2\u017c\u017d\7q\2\2"+
		"\u017dD\3\2\2\2\u017e\u017f\7g\2\2\u017f\u0180\7u\2\2\u0180\u0181\7r\2"+
		"\2\u0181\u0182\7g\2\2\u0182\u0183\7t\2\2\u0183\u0184\7c\2\2\u0184F\3\2"+
		"\2\2\u0185\u0186\7g\2\2\u0186\u0187\7l\2\2\u0187\u0188\7g\2\2\u0188\u0189"+
		"\7e\2\2\u0189\u018a\7w\2\2\u018a\u018b\7v\2\2\u018b\u018c\7c\2\2\u018c"+
		"H\3\2\2\2\u018d\u018e\7t\2\2\u018e\u018f\7g\2\2\u018f\u0190\7r\2\2\u0190"+
		"\u0191\7k\2\2\u0191\u0192\7v\2\2\u0192\u0193\7g\2\2\u0193J\3\2\2\2\u0194"+
		"\u0195\7u\2\2\u0195\u0196\7k\2\2\u0196L\3\2\2\2\u0197\u0198\7u\2\2\u0198"+
		"\u0199\7k\2\2\u0199\u019a\7u\2\2\u019a\u019b\7k\2\2\u019b\u019c\7p\2\2"+
		"\u019c\u019d\7q\2\2\u019dN\3\2\2\2\u019e\u019f\7j\2\2\u019f\u01a0\7c\2"+
		"\2\u01a0\u01a1\7|\2\2\u01a1\u01a2\7\60\2\2\u01a2\u01a3\7j\2\2\u01a3\u01a4"+
		"\7c\2\2\u01a4\u01a5\7u\2\2\u01a5\u01a6\7v\2\2\u01a6\u01a7\7c\2\2\u01a7"+
		"P\3\2\2\2\u01a8\u01a9\7j\2\2\u01a9\u01aa\7c\2\2\u01aa\u01ab\7u\2\2\u01ab"+
		"\u01ac\7v\2\2\u01ac\u01ad\7c\2\2\u01adR\3\2\2\2\u01ae\u01af\7j\2\2\u01af"+
		"\u01b0\7c\2\2\u01b0\u01b1\7|\2\2\u01b1\u01b2\7\60\2\2\u01b2\u01b3\7o\2"+
		"\2\u01b3\u01b4\7k\2\2\u01b4\u01b5\7g\2\2\u01b5\u01b6\7p\2\2\u01b6\u01b7"+
		"\7v\2\2\u01b7\u01b8\7t\2\2\u01b8\u01b9\7c\2\2\u01b9\u01ba\7u\2\2\u01ba"+
		"T\3\2\2\2\u01bb\u01bc\7o\2\2\u01bc\u01bd\7k\2\2\u01bd\u01be\7g\2\2\u01be"+
		"\u01bf\7p\2\2\u01bf\u01c0\7v\2\2\u01c0\u01c1\7t\2\2\u01c1\u01c2\7c\2\2"+
		"\u01c2\u01c3\7u\2\2\u01c3V\3\2\2\2\u01c4\u01c5\7k\2\2\u01c5\u01c6\7i\2"+
		"\2\u01c6\u01c7\7w\2\2\u01c7\u01c8\7c\2\2\u01c8\u01c9\7n\2\2\u01c9\u01ca"+
		"\7g\2\2\u01ca\u01cb\7u\2\2\u01cb\u01cc\7A\2\2\u01ccX\3\2\2\2\u01cd\u01ce"+
		"\7{\2\2\u01ceZ\3\2\2\2\u01cf\u01d0\7q\2\2\u01d0\\\3\2\2\2\u01d1\u01d2"+
		"\7>\2\2\u01d2^\3\2\2\2\u01d3\u01d4\7@\2\2\u01d4`\3\2\2\2\u01d5\u01d6\7"+
		"o\2\2\u01d6\u01d7\7c\2\2\u01d7\u01d8\7{\2\2\u01d8\u01d9\7q\2\2\u01d9\u01da"+
		"\7t\2\2\u01da\u01db\7s\2\2\u01db\u01dc\7w\2\2\u01dc\u01dd\7g\2\2\u01dd"+
		"\u01de\7A\2\2\u01deb\3\2\2\2\u01df\u01e0\7o\2\2\u01e0\u01e1\7g\2\2\u01e1"+
		"\u01e2\7p\2\2\u01e2\u01e3\7q\2\2\u01e3\u01e4\7t\2\2\u01e4\u01e5\7s\2\2"+
		"\u01e5\u01e6\7w\2\2\u01e6\u01e7\7g\2\2\u01e7\u01e8\7A\2\2\u01e8d\3\2\2"+
		"\2\u01e9\u01ea\7t\2\2\u01ea\u01eb\7g\2\2\u01eb\u01ec\7f\2\2\u01ec\u01ed"+
		"\7q\2\2\u01ed\u01ee\7p\2\2\u01ee\u01ef\7f\2\2\u01ef\u01f0\7g\2\2\u01f0"+
		"\u01f1\7c\2\2\u01f1f\3\2\2\2\u01f2\u01f3\7c\2\2\u01f3\u01f4\7|\2\2\u01f4"+
		"\u01f5\7c\2\2\u01f5\u01f6\7t\2\2\u01f6h\3\2\2\2\u01f7\u01f8\7o\2\2\u01f8"+
		"\u01f9\7g\2\2\u01f9\u01fa\7p\2\2\u01fa\u01fb\7q\2\2\u01fb\u01fc\7u\2\2"+
		"\u01fcj\3\2\2\2\u01fd\u01fe\7r\2\2\u01fe\u01ff\7t\2\2\u01ff\u0200\7q\2"+
		"\2\u0200\u0201\7f\2\2\u0201\u0202\7w\2\2\u0202\u0203\7e\2\2\u0203\u0204"+
		"\7v\2\2\u0204\u0205\7q\2\2\u0205l\3\2\2\2\u0206\u0207\7r\2\2\u0207\u0208"+
		"\7q\2\2\u0208\u0209\7v\2\2\u0209\u020a\7g\2\2\u020a\u020b\7p\2\2\u020b"+
		"\u020c\7e\2\2\u020c\u020d\7k\2\2\u020d\u020e\7c\2\2\u020en\3\2\2\2\u020f"+
		"\u0210\7f\2\2\u0210\u0211\7k\2\2\u0211\u0212\7x\2\2\u0212\u0213\7k\2\2"+
		"\u0213\u0214\7u\2\2\u0214\u0215\7k\2\2\u0215\u0216\7q\2\2\u0216\u0217"+
		"\7p\2\2\u0217p\3\2\2\2\u0218\u0219\7t\2\2\u0219\u021a\7g\2\2\u021a\u021b"+
		"\7u\2\2\u021b\u021c\7v\2\2\u021c\u021d\7q\2\2\u021dr\3\2\2\2\u021e\u021f"+
		"\7f\2\2\u021f\u0220\7k\2\2\u0220\u0221\7h\2\2\u0221\u0222\7g\2\2\u0222"+
		"\u0223\7t\2\2\u0223\u0224\7g\2\2\u0224\u0225\7p\2\2\u0225\u0226\7e\2\2"+
		"\u0226\u0227\7k\2\2\u0227\u0228\7c\2\2\u0228t\3\2\2\2\u0229\u022a\7u\2"+
		"\2\u022a\u022b\7w\2\2\u022b\u022c\7o\2\2\u022c\u022d\7c\2\2\u022dv\3\2"+
		"\2\2\u022e\u022f\7g\2\2\u022f\u0230\7n\2\2\u0230\u0231\7g\2\2\u0231\u0232"+
		"\7i\2\2\u0232\u0233\7k\2\2\u0233\u0234\7t\2\2\u0234x\3\2\2\2\u0235\u0236"+
		"\7e\2\2\u0236\u0237\7w\2\2\u0237\u0238\7g\2\2\u0238\u0239\7p\2\2\u0239"+
		"\u023a\7v\2\2\u023a\u023b\7c\2\2\u023bz\3\2\2\2\u023c\u023d\7w\2\2\u023d"+
		"\u023e\7n\2\2\u023e\u023f\7v\2\2\u023f\u0240\7k\2\2\u0240\u0241\7o\2\2"+
		"\u0241\u0242\7q\2\2\u0242|\3\2\2\2\u0243\u0244\7w\2\2\u0244\u0245\7n\2"+
		"\2\u0245~\3\2\2\2\u0246\u0247\7g\2\2\u0247\u0248\7n\2\2\u0248\u0249\7"+
		"g\2\2\u0249\u024a\7o\2\2\u024a\u024b\7g\2\2\u024b\u024c\7p\2\2\u024c\u024d"+
		"\7v\2\2\u024d\u024e\7q\2\2\u024e\u0080\3\2\2\2\u024f\u0250\7r\2\2\u0250"+
		"\u0251\7t\2\2\u0251\u0252\7k\2\2\u0252\u0253\7o\2\2\u0253\u0254\7g\2\2"+
		"\u0254\u0255\7t\2\2\u0255\u0256\7q\2\2\u0256\u0082\3\2\2\2\u0257\u0258"+
		"\7d\2\2\u0258\u0259\7q\2\2\u0259\u025a\7t\2\2\u025a\u025b\7t\2\2\u025b"+
		"\u025c\7c\2\2\u025c\u025d\7R\2\2\u025d\u025e\7c\2\2\u025e\u025f\7p\2\2"+
		"\u025f\u0260\7v\2\2\u0260\u0261\7c\2\2\u0261\u0262\7n\2\2\u0262\u0263"+
		"\7n\2\2\u0263\u0264\7c\2\2\u0264\u0084\3\2\2\2\u0265\u0266\7-\2\2\u0266"+
		"\u0086\3\2\2\2\u0267\u0268\7/\2\2\u0268\u0088\3\2\2\2\u0269\u026a\7,\2"+
		"\2\u026a\u008a\3\2\2\2\u026b\u026c\7\61\2\2\u026c\u008c\3\2\2\2\u026d"+
		"\u0273\7$\2\2\u026e\u026f\7^\2\2\u026f\u0272\7$\2\2\u0270\u0272\13\2\2"+
		"\2\u0271\u026e\3\2\2\2\u0271\u0270\3\2\2\2\u0272\u0275\3\2\2\2\u0273\u0274"+
		"\3\2\2\2\u0273\u0271\3\2\2\2\u0274\u0276\3\2\2\2\u0275\u0273\3\2\2\2\u0276"+
		"\u0277\7$\2\2\u0277\u008e\3\2\2\2\u0278\u0279\7]\2\2\u0279\u0090\3\2\2"+
		"\2\u027a\u027b\7_\2\2\u027b\u0092\3\2\2\2\u027c\u027d\7*\2\2\u027d\u0094"+
		"\3\2\2\2\u027e\u027f\7+\2\2\u027f\u0096\3\2\2\2\u0280\u0281\7\61\2\2\u0281"+
		"\u0282\7\61\2\2\u0282\u0286\3\2\2\2\u0283\u0285\n\2\2\2\u0284\u0283\3"+
		"\2\2\2\u0285\u0288\3\2\2\2\u0286\u0284\3\2\2\2\u0286\u0287\3\2\2\2\u0287"+
		"\u0098\3\2\2\2\u0288\u0286\3\2\2\2\u0289\u028a\t\3\2\2\u028a\u028b\5\u009f"+
		"P\2\u028b\u028c\5\u009fP\2\u028c\u028d\5\u009fP\2\u028d\u028e\5\u009f"+
		"P\2\u028e\u028f\5\u009fP\2\u028f\u0290\5\u009fP\2\u0290\u0291\5\u009f"+
		"P\2\u0291\u0292\5\u009fP\2\u0292\u0293\5\u009fP\2\u0293\u02c9\3\2\2\2"+
		"\u0294\u0295\t\3\2\2\u0295\u0296\5\u009fP\2\u0296\u0297\5\u009fP\2\u0297"+
		"\u0298\5\u009fP\2\u0298\u0299\5\u009fP\2\u0299\u029a\5\u009fP\2\u029a"+
		"\u029b\5\u009fP\2\u029b\u029c\5\u009fP\2\u029c\u029d\5\u009fP\2\u029d"+
		"\u02c9\3\2\2\2\u029e\u029f\t\3\2\2\u029f\u02a0\5\u009fP\2\u02a0\u02a1"+
		"\5\u009fP\2\u02a1\u02a2\5\u009fP\2\u02a2\u02a3\5\u009fP\2\u02a3\u02a4"+
		"\5\u009fP\2\u02a4\u02a5\5\u009fP\2\u02a5\u02a6\5\u009fP\2\u02a6\u02c9"+
		"\3\2\2\2\u02a7\u02a8\t\3\2\2\u02a8\u02a9\5\u009fP\2\u02a9\u02aa\5\u009f"+
		"P\2\u02aa\u02ab\5\u009fP\2\u02ab\u02ac\5\u009fP\2\u02ac\u02ad\5\u009f"+
		"P\2\u02ad\u02ae\5\u009fP\2\u02ae\u02c9\3\2\2\2\u02af\u02b0\t\3\2\2\u02b0"+
		"\u02b1\5\u009fP\2\u02b1\u02b2\5\u009fP\2\u02b2\u02b3\5\u009fP\2\u02b3"+
		"\u02b4\5\u009fP\2\u02b4\u02b5\5\u009fP\2\u02b5\u02c9\3\2\2\2\u02b6\u02b7"+
		"\t\3\2\2\u02b7\u02b8\5\u009fP\2\u02b8\u02b9\5\u009fP\2\u02b9\u02ba\5\u009f"+
		"P\2\u02ba\u02bb\5\u009fP\2\u02bb\u02c9\3\2\2\2\u02bc\u02bd\t\3\2\2\u02bd"+
		"\u02be\5\u009fP\2\u02be\u02bf\5\u009fP\2\u02bf\u02c0\5\u009fP\2\u02c0"+
		"\u02c9\3\2\2\2\u02c1\u02c2\t\3\2\2\u02c2\u02c3\5\u009fP\2\u02c3\u02c4"+
		"\5\u009fP\2\u02c4\u02c9\3\2\2\2\u02c5\u02c6\t\3\2\2\u02c6\u02c9\5\u009f"+
		"P\2\u02c7\u02c9\t\3\2\2\u02c8\u0289\3\2\2\2\u02c8\u0294\3\2\2\2\u02c8"+
		"\u029e\3\2\2\2\u02c8\u02a7\3\2\2\2\u02c8\u02af\3\2\2\2\u02c8\u02b6\3\2"+
		"\2\2\u02c8\u02bc\3\2\2\2\u02c8\u02c1\3\2\2\2\u02c8\u02c5\3\2\2\2\u02c8"+
		"\u02c7\3\2\2\2\u02c9\u009a\3\2\2\2\u02ca\u02cc\t\4\2\2\u02cb\u02ca\3\2"+
		"\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02cb\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce"+
		"\u009c\3\2\2\2\u02cf\u02d0\7V\2\2\u02d0\u02d1\7T\2\2\u02d1\u02d2\7W\2"+
		"\2\u02d2\u02d9\7G\2\2\u02d3\u02d4\7H\2\2\u02d4\u02d5\7C\2\2\u02d5\u02d6"+
		"\7N\2\2\u02d6\u02d7\7U\2\2\u02d7\u02d9\7G\2\2\u02d8\u02cf\3\2\2\2\u02d8"+
		"\u02d3\3\2\2\2\u02d9\u009e\3\2\2\2\u02da\u02db\t\5\2\2\u02db\u00a0\3\2"+
		"\2\2\u02dc\u02dd\t\6\2\2\u02dd\u02de\3\2\2\2\u02de\u02df\bQ\2\2\u02df"+
		"\u00a2\3\2\2\2\t\2\u0271\u0273\u0286\u02c8\u02cd\u02d8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}