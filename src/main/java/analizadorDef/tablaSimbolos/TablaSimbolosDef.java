package analizadorDef.tablaSimbolos;

import java.util.ArrayList;

public class TablaSimbolosDef {

    private final ArrayList<TerminoDef> variables = new ArrayList<>();

    public TablaSimbolosDef() {
    }

    public boolean agregarTermino(TerminoDef termino) {
        boolean agregado = false;
        if (!this.existe(termino.getId())) {
            this.variables.add(termino);
            agregado = true;
        }
        return agregado;
    }

    public boolean existe(String id) {
        boolean existe = false;
        for (TerminoDef td : variables) {
            if (td.getId().equals(id)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public TerminoDef getTermino(String id) {
        TerminoDef termino = null;
        for (TerminoDef td : variables) {
            if (td.getId().equals(id)) {
                termino = td;
                break;
            }
        }
        return termino;
    }

    public void imprimir() {
        for (int i = 0; i < this.variables.size(); i++) {
            System.out.println(variables.get(i));
        }
    }

    public void limpiar() {
        this.variables.clear();
    }
}
