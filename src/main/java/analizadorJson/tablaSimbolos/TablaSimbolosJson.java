package analizadorJson.tablaSimbolos;

import java.util.ArrayList;

public class TablaSimbolosJson {

    private TerminoJson score;
    private ArrayList<TerminoJson> clases = new ArrayList<>();
    private ArrayList<TerminoJson> variables = new ArrayList<>();
    private ArrayList<TerminoJson> metodos = new ArrayList<>();
    private ArrayList<TerminoJson> comentarios = new ArrayList<>();

    public TablaSimbolosJson() {

    }

    public void agregarTermino(TerminoJson termino) {
        switch (termino.getRol()) {
            case SCORE:
                this.score = termino;
                break;
            case CLASE:
                this.clases.add(termino);
                break;
            case VARIABLE:
                this.variables.add(termino);
                break;
            case METODO:
                this.metodos.add(termino);
                break;
            case COMENTARIO:
                this.comentarios.add(termino);
        }
    }

    public void imprimirTabla() {
        System.out.println("SCORE");
        System.out.println(score);
        iterador(clases, "CLASES");
        iterador(variables, "VARIABLES");
        iterador(metodos, "METODOS");
        iterador(comentarios, "COMENTARIOS");

    }

    private void iterador(ArrayList<TerminoJson> lista, String nombre) {
        System.out.println("----------------------" + nombre + "----------------------");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + "-> " + lista.get(i));
        }
    }

    public void limpiar() {
        this.score = null;
        this.clases.clear();
        this.variables.clear();
        this.metodos.clear();
        this.comentarios.clear();
    }

}
