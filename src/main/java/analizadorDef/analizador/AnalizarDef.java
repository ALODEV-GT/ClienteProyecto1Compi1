package analizadorDef.analizador;

import analizadorDef.jflex.LexerDef;
import analizadorDef.cup.parser;
import analizadorJson.tablaSimbolos.TablaSimbolosJson;
import java.io.StringReader;
import javax.swing.JTextArea;

public class AnalizarDef {

    private final String def;
    private final JTextArea taConsola;
    private final TablaSimbolosJson tablaSimbolosJson;
    private StringBuilder html ;

    public AnalizarDef(String json, JTextArea taConsola, TablaSimbolosJson tablaSimbolosJson) {
        this.def = json;
        this.taConsola = taConsola;
        this.tablaSimbolosJson = tablaSimbolosJson;
    }

    public void analizar() {
        StringReader sr = new StringReader(this.def);
        LexerDef lexer = new LexerDef(sr);
        parser par = new parser(lexer, this.tablaSimbolosJson, taConsola);

        try {
            par.parse();
            System.out.println("Tabla de simbolos final---------->");
            par.imprimirTablaSimbolosoDef();
            if (!par.isErrores()) {
                taConsola.append("Analisis del Def correcto\n");
                this.html = par.getCodigoHtml();
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    public StringBuilder getCodigoHTML(){
        return this.html;
    }
}
