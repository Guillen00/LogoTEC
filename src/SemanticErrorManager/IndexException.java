package SemanticErrorManager;

/**
 * IndexException: clase que genera una excepción en caso de que se busque un elemento fuera de rango existente
 */
public class IndexException extends SemanticException{

    /**
     * Constructor para mostrar el mensaje
     * @param line: línea donde se presentó el error
     * @param caracter: posición del caracter en la línea donde se presentó el error
     */
    public IndexException(int line, int caracter) {
        super("línea " + line + ":" + caracter + " : el elemento buscado no existe");
    }
}
