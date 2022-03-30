package analizadorDef.tablaSimbolos;

public class Cadena {

    private String cadena;

    public Cadena(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public String toString() {
        return cadena;
    }

}
