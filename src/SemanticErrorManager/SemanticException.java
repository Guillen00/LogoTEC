package SemanticErrorManager;

/**
 * SemanticException: súper clase padre de todas las excepciones de tipo senmánticas
 */
public class SemanticException extends RuntimeException {
    /**
     * Constructor de SemanticException
     * @param msg: mensaje de la excepción por mostrar
     */
    public SemanticException(String msg) {
        super(msg);
    }
}