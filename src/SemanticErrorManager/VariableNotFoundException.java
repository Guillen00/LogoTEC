package SemanticErrorManager;

/**
 * VariableNotFoundException: clase que genera una excepción en caso de que una variable buscada no exista
 */

public class VariableNotFoundException extends SemanticException{

    /**
     * Constructor para mostrar el mensaje
     * @param line: línea donde se presentó el error
     * @param caracter: posición del caracter en la línea donde se presentó el error
     * @param variable: nombre de la variable encontrada
     */
    public VariableNotFoundException(int line, int caracter ,String variable) {
        super("línea " + line + ":" + caracter + " : la variable " + variable + " no existe");
    }

}
