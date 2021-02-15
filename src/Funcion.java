import java.util.List;

public class Funcion {
    private String nombre;
    private List<String> parametros;
    private logoParser.InstruccionesContext instrucciones;

    public Funcion(String nombre, List<String> parametros, logoParser.InstruccionesContext instrucciones) {
        this.nombre = nombre;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getParametros() {
        return parametros;
    }

    public void setParametros(List<String> parametros) {
        this.parametros = parametros;
    }

    public logoParser.InstruccionesContext getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(logoParser.InstruccionesContext instrucciones) {
        this.instrucciones = instrucciones;
    }
}
