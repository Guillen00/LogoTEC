import org.antlr.v4.runtime.*;

import java.util.Collections;
import java.util.List;

/**
 * Nuevo error listener del parseo que da los mensajes en español
 */
public class SyntaxErrorListener extends BaseErrorListener {

    private String errorMessage;
    private boolean errorDetected;

    /**
     * Constructor de clase
     */
    public SyntaxErrorListener() {
        super();
        errorMessage="";
        errorDetected=false;
    }


    /**
     * Método que da el mensaje de error
     * @param recognizer Recognizer
     * @param offendingSymbol Símbolo donde hubo error
     * @param line Linea del error
     * @param charPositionInLine Numero de caracter en la linea
     * @param msg Mensaje de error
     * @param e  Error
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {
        errorDetected=true;
        errorMessage += "linea " + line + ":" + charPositionInLine + ": " + msg + "\n\n";

    }

    /**
     * Metodo para obtener el mensaje de error completo luego del parseo
     * @return Mensaje de error
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Método para saber si hubo algún error
     * @return Booleano que indica si hubo algun error en el parseo
     */
    public boolean isErrorDetected() {
        return errorDetected;
    }
}