package analizadorDef.analizador;

import analizadorDef.jflex.LexerDef;
import analizadorDef.tablaSimbolos.TablaSimbolosDef;
import analizadorDef.cup.parser;
import java.io.StringReader;
import javax.swing.JTextArea;

public class Analizar {

    private final String def;
    private final JTextArea taConsola;
    private final TablaSimbolosDef tablaSimbolosDef;

    public Analizar(String json, JTextArea taConsola, TablaSimbolosDef tablaSimbolosDef) {
        this.def = json;
        this.taConsola = taConsola;
        this.tablaSimbolosDef = tablaSimbolosDef;
    }

    public void analizar() {
        StringReader sr = new StringReader(this.def);
        LexerDef lexer = new LexerDef(sr);
        parser par = new parser(lexer, this.tablaSimbolosDef, taConsola);

        try {
            par.parse();
            if (!par.isErrores()) {
                taConsola.append("Analisis del Def correcto");
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
