package analizadorJson.tablaSimbolos;

import java.util.ArrayList;

public class TablaSimbolosJson {

    private TerminoJson score;
    private final ArrayList<TerminoJson> clases = new ArrayList<>();
    private final ArrayList<TerminoJson> variables = new ArrayList<>();
    private final ArrayList<TerminoJson> metodos = new ArrayList<>();
    private final ArrayList<TerminoJson> comentarios = new ArrayList<>();

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

    public String getScore() {
        return this.score.getNombre();
    }

    public String getClases() {
        String clasesStr = "Clases[";
        for (int i = 0; i < this.clases.size(); i++) {
            TerminoJson termino = this.clases.get(i);
            clasesStr += "{Nombre:" + termino.getNombre() + "}";
            if (i != this.clases.size() - 1) {
                clasesStr += ",";
            }
        }
        return clasesStr + "]";
    }

    public String getVariables() {
        String variablesStr = "Variables[";
        for (int i = 0; i < this.variables.size(); i++) {
            TerminoJson termino = this.variables.get(i);
            variablesStr += "{Nombre:" + termino.getNombre() + ",Tipo:" + termino.getTipo() + ",Funcion:" + termino.getFuncion() + "}";
            if (i != this.variables.size() - 1) {
                variablesStr += ",";
            }
        }
        return variablesStr + "]";
    }

    public String getMetodos() {
        String metodosStr = "Metodos[";
        for (int i = 0; i < this.metodos.size(); i++) {
            TerminoJson termino = this.metodos.get(i);
            metodosStr += "{Nombre:" + termino.getNombre() + ",Tipo:" + termino.getTipo() + ",Parametros" + termino.getParametros() + "}";
            if (i != this.metodos.size() - 1) {
                metodosStr += ",";
            }
        }
        return metodosStr + "]";
    }

    public String getComentarios() {
        String comentariosStr = "Comentarios[";
        for (int i = 0; i < this.comentarios.size(); i++) {
            TerminoJson termino = this.comentarios.get(i);
            comentariosStr += "{Nombre:" + termino.getNombre() + "}";
            if (i != this.comentarios.size() - 1) {
                comentariosStr += ",";
            }
        }
        return comentariosStr + "]";
    }

    public TerminoJson encontrarTermino(RolJson rol, int indice) {
        TerminoJson termino = null;
        try {
            switch (rol) {
                case CLASE:
                    termino = this.clases.get(indice);
                    break;
                case COMENTARIO:
                    termino = this.comentarios.get(indice);
                    break;
                case METODO:
                    termino = this.metodos.get(indice);
                    break;
                case VARIABLE:
                    termino = this.variables.get(indice);
                    break;
            }
        } catch (Exception ex) {
            //Indice no valido, retornar un null
        }
        return termino;
    }

    public String getClase(int indice) {
        String descripcion = "";
        try {
            TerminoJson termino = this.clases.get(indice);
            descripcion += "{Nombre:" + termino.getNombre() + "}";
        } catch (Exception ex) {
            descripcion = null;
        }
        return descripcion;
    }

    public String getVariable(int indice) {
        String descripcion = "";
        try {
            TerminoJson termino = this.variables.get(indice);
            descripcion += "{Nombre:" + termino.getNombre() + ",Tipo:" + termino.getTipo() + ",Funcion:" + termino.getFuncion() + "}";
        } catch (Exception ex) {
            descripcion = null;
        }
        return descripcion;
    }

    public String getMetodo(int indice) {
        String descripcion = "";
        try {
            TerminoJson termino = this.metodos.get(indice);
            descripcion += "{Nombre:" + termino.getNombre() + ",Tipo:" + termino.getTipo() + ",Parametros" + termino.getParametros() + "}";
        } catch (Exception ex) {
            descripcion = null;
        }
        return descripcion;
    }

    public String getComentario(int indice) {
        String descripcion = "";
        try {
            TerminoJson termino = this.comentarios.get(indice);
            descripcion += "{Nombre:" + termino.getNombre() + "}";
        } catch (Exception ex) {
            descripcion = null;
        }
        return descripcion;
    }
}
