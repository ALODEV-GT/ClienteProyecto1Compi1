package analizadorDef.tablaSimbolos;

import java.util.ArrayList;

public class TablaSimbolosDef {

    private ArrayList<TerminoDef> variables = new ArrayList<>();

    public TablaSimbolosDef() {
    }

    public void agregarTermino(TerminoDef termino) {
        this.variables.add(termino);
    }
    
    public void imprimirVariables(){
        for (int i = 0; i < this.variables.size(); i++) {
            System.out.println(variables.get(i));
        }
    }

    public void limpiar() {
        this.variables.clear();
    }
}
