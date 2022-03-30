package analizadorDef.tablaSimbolos;

public class Entero {

    private Integer entero;

    public Entero(int entero) {
        this.entero = entero;
    }

    public int getEntero() {
        return entero;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }

    @Override
    public String toString() {
        return this.entero + "";
    }

}
