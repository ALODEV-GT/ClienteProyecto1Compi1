package analizadorJson.analizador;

import analizadorJson.cup.parser;
import analizadorJson.jflex.LexerJson;
import analizadorJson.tablaSimbolos.TablaSimbolosJson;
import java.io.StringReader;
import javax.swing.JTextArea;

public class Analizar {

    private final String json;
    private final JTextArea taConsola;
    private final TablaSimbolosJson tablaSimbolosJson;

    public Analizar(String json, JTextArea taConsola, TablaSimbolosJson tablaSimbolosJson) {
        this.json = json;
        this.taConsola = taConsola;
        this.tablaSimbolosJson = tablaSimbolosJson;
    }

    public void analizar() {
        StringReader sr = new StringReader(this.json);
        LexerJson lexer = new LexerJson(sr);
        parser par = new parser(lexer, this.tablaSimbolosJson, taConsola);

        try {
            par.parse();
            if (!par.isErrores()) {
                taConsola.append("Analisis del Json correcto");
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
