package SemanticErrorManager;

/**
 * DuplicatedMethodSignatureException: clase que genera una excepción en caso de que la firma de un método no sea único
 */
public class DuplicatedMethodSignatureException extends SemanticException{

    /**
     * Constructor para mostrar el mensaje
     * @param line: línea donde se presentó el error
     * @param caracter: posición del caracter en la línea donde se presentó el error
     * @param variable: nombre del método con esa firma
     * @param cantParam: cantidad de parámetros del método ya existente con esa firma
     */
    public DuplicatedMethodSignatureException(int line, int caracter ,String variable, int cantParam) {
        super("línea " + line + ":" + caracter + " : el procedimiento " + variable + " con " + cantParam +" parámetros ya está definido.");
    }
}
