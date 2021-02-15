package SemanticErrorManager;

/**
 * InvalidColorException: clase que genera una excepción en caso de que el color seleccionado no sea válido
 */
public class InvalidColorException extends SemanticException {

    /**
     * Constructor para mostrar el mensaje
     * @param line: línea donde se presentó el error
     * @param caracter: posición del caracter en la línea donde se presentó el error
     * @param colorInvalido: nombre del color no válido
     */
    public InvalidColorException(int line, int caracter, String colorInvalido) {
        super("línea " + line + ":" + caracter + " : el color "+ colorInvalido + " no es permitido ");
    }
}