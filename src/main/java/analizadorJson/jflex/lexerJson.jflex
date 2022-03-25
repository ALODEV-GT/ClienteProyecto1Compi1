package analizadorJson.jflex;
import java_cup.runtime.Symbol;
import analizadorJson.cup.sym;
        
%%
%class LexerJson
%type Symbol
%unicode
%public
%cup
%line
%column

%{
    private javax.swing.JTextArea taErrores;
    private boolean errores = false;

    public AnalizadorLexico(java.io.Reader in, javax.swing.JTextArea taErrores){
        this(in);
        this.taErrores = taErrores;
    }

    public boolean isErrores(){
        return errores;
    }

    private Symbol symbol(int type) {
        return new Symbol(type, yycolumn+1, yyline+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yycolumn+1, yyline+1, value);
    }
%}

//PALABRAS RESERVADAS
SCORE = "Score"
CLASES = "Clases"
VARIABLES="Variables"
METODOS="Metodos"
COMENTARIOS="Comentarios"
NOMBRE = "Nombre"
FUNCION = "Funcion"
TIPO = "Tipo"
PARAMETROS = "Parametros"
TEXTO = "Texto"

//SIGNOS DE AGRUPACION
LLAVE_A = "{"
LLAVE_C = "}"
CORCHETE_A = "["
CORCHETE_C = "]"

//SIGNOS DE PUNTUACION
COMA = ","
DOS_PUNTOS = ":"

//utileria
NUMERO = [0-9]
FIN_LINEA = \r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085
ESPACIO = " " | "\t"

//VALORES
LITERAL = "\""~"\""
ENTERO = {NUMERO}{NUMERO}*

%%
<YYINITIAL> {SCORE}                             {return symbol(sym.SCORE, yytext());}
<YYINITIAL> {CLASES}                            {return symbol(sym.CLASES, yytext());}
<YYINITIAL> {VARIABLES}                         {return symbol(sym.VARIABLES, yytext());}
<YYINITIAL> {METODOS}                           {return symbol(sym.METODOS, yytext());}
<YYINITIAL> {COMENTARIOS}                       {return symbol(sym.COMENTARIOS, yytext());}
<YYINITIAL> {NOMBRE}                            {return symbol(sym.NOMBRE, yytext());}
<YYINITIAL> {FUNCION}                           {return symbol(sym.FUNCION, yytext());}
<YYINITIAL> {TIPO}                              {return symbol(sym.TIPO, yytext());}
<YYINITIAL> {PARAMETROS}                        {return symbol(sym.PARAMETROS, yytext());}
<YYINITIAL> {TEXTO}                             {return symbol(sym.TEXTO, yytext());}
<YYINITIAL> {LLAVE_A}                           {return symbol(sym.LLAVE_A, yytext());}
<YYINITIAL> {LLAVE_C}                           {return symbol(sym.LLAVE_C, yytext());}
<YYINITIAL> {CORCHETE_A}                        {return symbol(sym.CORCHETE_A, yytext());}
<YYINITIAL> {CORCHETE_C}                        {return symbol(sym.CORCHETE_C, yytext());}
<YYINITIAL> {COMA}                              {return symbol(sym.COMA, yytext());}
<YYINITIAL> {DOS_PUNTOS}                        {return symbol(sym.DOS_PUNTOS, yytext());}
<YYINITIAL> {LITERAL}                           {return symbol(sym.LITERAL, yytext());}
<YYINITIAL> {ENTERO}                            {return symbol(sym.ENTERO, yytext());}
<YYINITIAL> {FIN_LINEA}                         {}
<YYINITIAL> {ESPACIO}                           {}

<<EOF>>                                     {return symbol(sym.EOF, "FIN");}
<YYINITIAL> .                               {taErrores.append("El simbolo " + yytext() + " no existe en el lenguaje." + " Linea:" + (yyline+1) + " Columna:" + yycolumn + "\n"); errores = true;}