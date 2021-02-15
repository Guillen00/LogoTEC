package SemanticErrorManager;

/**
 * UnexpectedTypeException: clase que genera una excepción en caso de que los tipos de dato esperado y recibido no coincidan
 */

public class UnexpectedTypeException extends SemanticException{

    /**
     * Constructor para mostrar el mensaje
     * @param line: línea donde se presentó el error
     * @param caracter: posición del caracter en la línea donde se presentó el error
     * @param esperado: tipo de dato esperado
     * @param recibido: tipo de dato que fue recibido
     */
    public UnexpectedTypeException(int line, int caracter, String esperado, String recibido) {
        super("línea " + line + ":" + caracter + " : tipo de dato erróneo; tipo esperado: " + esperado + " ; tipo recibido: "+ recibido);
    }


}
