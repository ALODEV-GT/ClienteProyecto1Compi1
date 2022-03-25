package analizadorJson.tablaSimbolos;

public class TerminoJson {

    private RolJson rol;
    private String nombre;
    private String tipo;
    private String funcion;
    private int parametros;

    public TerminoJson(RolJson rol, String nombre, String tipo, String funcion, int parametros) {
        this.rol = rol;
        this.nombre = nombre;
        this.tipo = tipo;
        this.funcion = funcion;
        this.parametros = parametros;
    }

    public TerminoJson(RolJson rol, String nombre) {
        this.rol = rol;
        this.nombre = nombre;
    }

    public TerminoJson() {

    }

    public RolJson getRol() {
        return rol;
    }

    public void setRol(RolJson rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public int getParametros() {
        return parametros;
    }

    public void setParametros(int parametros) {
        this.parametros = parametros;
    }

    @Override
    public String toString() {
        return "TerminoJson{" + "rol=" + rol + ", nombre=" + nombre + ", tipo=" + tipo + ", funcion=" + funcion + ", parametros=" + parametros + '}';
    }
}
