import java.util.ArrayList;

/**
 * Clase dato que almacena los datos transmitidos a traves del visitor, junto con un entero que indica su tipo
 */
public class Dato {
    /**
     * Dato almacenado
     */
    private Object dato;
    /**
     * Tipo de dato almacenado
     */
    private int tipo;
    /**
     * Constante de los dato tipo string
     */
    public static final int TYPE_STRING=0;
    /**
     * Constante de los dato tipo bool
     */
    public static final int TYPE_BOOL=1;
    /**
     * Constante de los dato tipo int
     */
    public static final int TYPE_INT=2;

    /**
     * Metodo que retorna el dato
     * @return El dato almacenado
     */
    public Object getDato() {
        return dato;
    }

    /**
     * Metodo que retorna el tipo de dato
     * @return El tipo de dato (como int)
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Metodo constructor
     * @param dato El dato a almacenar
     * @param tipo El tipo de dato
     */
    public Dato(Object dato, int tipo) {
        this.dato = dato;
        this.tipo = tipo;
    }

    /**
     * Método para obtener el dato casteado a strinG
     * @return El dato casteado a string
     */
    public String getDatoAsString(){
        return (String )dato;
    }

    /**
     * Método para obtener el dato casteado a Integer
     * @return El dato casteado a Integer
     */
    public Integer getDatoAsInteger(){
        return (Integer) dato;
    }

    /**
     * Método para obtener el dato casteado a Boolean
     * @return El dato casteado a Boolean
     */
    public Boolean getDatoAsBoolean(){
        return (Boolean) dato;
    }

    /**
     * Método para crear un arraylist cuyo unico el elemento es el dato
     * @return Arraylist cuyo unico el elemento es el dato
     */
    public ArrayList<Dato> toSingleArraylist(){
        ArrayList<Dato> retval=new ArrayList<>();
        retval.add(this);
        return retval;
    }

    /**
     * Método para devolver la informacion del dato actual en forma de string
     * @return Retorna la informacion del dato actual en forma de string
     */
    @Override
    public String toString() {
        String datoStr="";
        switch (this.tipo){
            case Dato.TYPE_STRING:
                datoStr=this.getDatoAsString();
                break;
            case Dato.TYPE_BOOL:
                datoStr=this.getDatoAsBoolean().toString();
                break;
            case Dato.TYPE_INT:
                datoStr=this.getDatoAsInteger().toString();
                break;
        }
        return  datoStr;
    }

    /**
     * Método para obtener el tipo del dato como string
     * @return El tipo del dato como string
     */
    public String getTypeAsString() {
        String tipoStr = "";
        switch (this.tipo) {
            case Dato.TYPE_STRING:
                tipoStr = "Hilera";
                break;
            case Dato.TYPE_BOOL:
                tipoStr = "Booleano";
                break;
            case Dato.TYPE_INT:
                tipoStr = "Entero";
                break;
        }
        return tipoStr;
    }

}
