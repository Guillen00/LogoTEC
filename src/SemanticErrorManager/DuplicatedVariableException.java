package SemanticErrorManager;

/**
 * DuplicatedVariableException: clase que genera una excepción en caso de que una variable no sea única
 */
public class DuplicatedVariableException extends SemanticException{
    /**
     * Constructor para mostrar el mensaje
     * @param line: línea donde se presentó el error
     * @param caracter: posición del caracter en la línea donde se presentó el error
     * @param variable: nombre de la variable duplicada
     */
    public DuplicatedVariableException(int line, int caracter ,String variable) {
        super("línea " + line + ":" + caracter + " : la variable " + variable + " ya está definida");
    }
}