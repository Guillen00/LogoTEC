package SemanticErrorManager;

/**
 * MethodNotFoundException: clase que genera una excepción en caso de que no se encuentre el método buscado
 */
public class MethodNotFoundException extends SemanticException{

    /**
     * Constructor para mostrar el mensaje
     * @param line: línea donde se presentó el error
     * @param caracter: posición del caracter en la línea donde se presentó el error
     * @param variable: nombre del método no existente
     * @param cantParam: cantidad de parámetros del método buscado pero no existente
     */
    public MethodNotFoundException(int line, int caracter ,String variable, int cantParam) {
        super("línea " + line + ":" + caracter + " : el procedimiento " + variable + " con " + cantParam + " parámetros no existe");
    }
}
