import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.misc.Pair;

/**
 * Clase que detecta los errores y los da en español, creado a partir de los archivos de antlr,
 * solo se modifican los mensajes de error
 */
public class StrictErrorStrategySpanish extends DefaultErrorStrategy {


    /**
     * Metodo para analizar y reportar errores
     * @param recognizer Reconocedor
     * @param e Error
     */
    @Override
    public void reportError(Parser recognizer, RecognitionException e) {
        if (!this.inErrorRecoveryMode(recognizer)) {
            this.beginErrorCondition(recognizer);
            if (e instanceof NoViableAltException) {
                this.reportNoViableAlternative(recognizer, (NoViableAltException)e);
            } else if (e instanceof InputMismatchException) {
                this.reportInputMismatch(recognizer, (InputMismatchException)e);
            } else if (e instanceof FailedPredicateException) {
                this.reportFailedPredicate(recognizer, (FailedPredicateException)e);
            } else {
                System.err.println("error de reconocimiento de tipo desconocido: " + e.getClass().getName());
                recognizer.notifyErrorListeners(e.getOffendingToken(), e.getMessage(), e);
            }

        }
    }

    /**
     * Método para reportar errores desconocidos
     * @param recognizer Recognizer
     * @param e Error a reportar
     */
    @Override
    protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
        TokenStream tokens = recognizer.getInputStream();
        String input;
        if (tokens != null) {
            if (e.getStartToken().getType() == -1) {
                input = "<FIN DE ARCHIVO>";
            } else {
                input = tokens.getText(e.getStartToken(), e.getOffendingToken());
            }
        } else {
            input = "<entrada desconocida>";
        }

        String msg = "no hay alternativas viables para la entrada : " + e.getOffendingToken().getText();
        recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }

    /**
     * Método para reportar errores de ¨mismath¨
     * @param recognizer Recognizer
     * @param e Error a reportar
     */
    @Override
    protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
        String msg = "entrada incompatible " + this.getTokenErrorDisplay(e.getOffendingToken());
        recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }

    /**
     * Método para reportar errores de fallo del predicado
     * @param recognizer Recognizer
     * @param e Error a reportar
     */
    @Override
    protected void reportFailedPredicate(Parser recognizer, FailedPredicateException e) {
        String ruleName = recognizer.getRuleNames()[recognizer.getContext().getRuleIndex()];
        String msg = "regla " + ruleName + " " + e.getMessage();
        recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }

    /**
     * Método para reportar errores de tokens inesperados
     * @param recognizer Recognizer
     */
    @Override
    protected void reportUnwantedToken(Parser recognizer) {
        if (!this.inErrorRecoveryMode(recognizer)) {
            this.beginErrorCondition(recognizer);
            Token t = recognizer.getCurrentToken();
            String tokenName = this.getTokenErrorDisplay(t);
            IntervalSet expecting = this.getExpectedTokens(recognizer);
            String msg = "entrada desconocida " + tokenName;
            recognizer.notifyErrorListeners(t, msg, (RecognitionException)null);
        }
    }

    /**
     * Método para reportar errores de token faltante
     * @param recognizer Recognizer
     */
    @Override
    protected void reportMissingToken(Parser recognizer) {
        if (!this.inErrorRecoveryMode(recognizer)) {
            this.beginErrorCondition(recognizer);
            Token t = recognizer.getCurrentToken();
            IntervalSet expecting = this.getExpectedTokens(recognizer);
            String msg = "falta " + expecting.toString(recognizer.getVocabulary()) + " en " + this.getTokenErrorDisplay(t);
            recognizer.notifyErrorListeners(t, msg, (RecognitionException)null);
        }
    }

    /**
     * Método para obtener el símbolo faltante
     * @param recognizer Recognizer
     * @return Símbolo faltante
     */
    @Override
    protected Token getMissingSymbol(Parser recognizer) {
        Token currentSymbol = recognizer.getCurrentToken();
        IntervalSet expecting = this.getExpectedTokens(recognizer);
        int expectedTokenType = 0;
        if (!expecting.isNil()) {
            expectedTokenType = expecting.getMinElement();
        }

        String tokenText;
        if (expectedTokenType == -1) {
            tokenText = "<falta Fin de Archivo>";
        } else {
            tokenText = "<falta " + recognizer.getVocabulary().getDisplayName(expectedTokenType) + ">";
        }

        Token current = currentSymbol;
        Token lookback = recognizer.getInputStream().LT(-1);
        if (currentSymbol.getType() == -1 && lookback != null) {
            current = lookback;
        }

        return recognizer.getTokenFactory().create(new Pair(current.getTokenSource(), current.getTokenSource().getInputStream()), expectedTokenType, tokenText, 0, -1, -1, current.getLine(), current.getCharPositionInLine());
    }

    /**
     * Método para obtener el token faltante en forma de strinf
     * @param t Token faltante
     * @return Token faltante en forma de string
     */
    @Override
    protected String getTokenErrorDisplay(Token t) {
        if (t == null) {
            return "<no hay token>";
        } else {
            String s = this.getSymbolText(t);
            if (s == null) {
                if (this.getSymbolType(t) == -1) {
                    s = "<Fin de Archivo>";
                } else {
                    s = "<" + this.getSymbolType(t) + ">";
                }
            }

            return this.escapeWSAndQuote(s);
        }
    }

    /**
     * Metodo que evita recuperarse de los errores encontrados y más bien tira una exepción
     * @param recognizer Recognizer
     * @param e Error reportado
     */
    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        this.reportError(recognizer,e);
        throw new RuntimeException(e);
    }

    /**
     * Metodo que evita recuperarse de los errores encontrados y más bien tira una exepción
     * @param recognizer Recognizer
     * @return No retorna
     * @throws RecognitionException Error de parseo
     */
    @Override
    public Token recoverInline(Parser recognizer)
            throws RecognitionException
    {
        throw new InputMismatchException(recognizer);
    }


    /**
     * Metodo en blanco para evitar recuperarse de errores
     * @param recognizer Recognizer
     */
    @Override
    public void sync(Parser recognizer){
    }

}

