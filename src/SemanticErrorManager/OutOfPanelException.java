package SemanticErrorManager;

/**
 * OutOfPanelException: clase que genera una excepción en caso de que el dibujo
 * sobresalga del panel de dibujo
 */
public class OutOfPanelException extends SemanticException{

    /**
     * Constructor para mostrar el mensaje
     * @param line: línea donde se presentó el error
     * @param caracter: posición del caracter en la línea donde se presentó el error
     */
    public OutOfPanelException(int line, int caracter) {
        super("línea " + line + ":" + caracter + " :  El valor ingresado sobresale el panel de dibujo");
    }
}
