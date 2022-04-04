package analizadorDef.tablaSimbolos;

public class TerminoDef {

    private RolDef rol;
    private String id;
    private String tipo;
    private String valor;

    public TerminoDef(RolDef rol, String id, String tipo, String valor) {
        this.rol = rol;
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }

    public TerminoDef() {
    }

    public TerminoDef(String tipo) {
        this.tipo = tipo;
    }

    public RolDef getRol() {
        return rol;
    }

    public void setRol(RolDef rol) {
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor.replace("\"","");
    }

    @Override
    public String toString() {
        return "TerminoDef{" + "rol=" + rol + ", id=" + id + ", tipo=" + tipo + ", valor=" + valor + '}';
    }

}
