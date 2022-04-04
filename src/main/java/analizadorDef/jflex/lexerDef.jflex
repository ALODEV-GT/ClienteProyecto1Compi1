package analizadorDef.jflex;
import java_cup.runtime.Symbol;
import analizadorDef.cup.sym;
        
%%
%class LexerDef
%type Symbol
%unicode
%public
%cup
%line
%column
%ignorecase

%{
    private javax.swing.JTextArea taErrores;
    private boolean errores = false;

    public LexerDef(java.io.Reader in, javax.swing.JTextArea taErrores){
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

//SECCION DE DECLARACION DE VARIABLES
//Palabras reservadas
RESULT = "RESULT"
SCORE = "Score"
CLASES = "Clases"
VARIABLES = "Variables"
NOMBRE = "Nombre"
TIPO = "Tipo"
FUNCION = "Funcion"
METODOS = "Metodos"
PARAMETROS = "Parametros"
COMENTARIOS = "Comentarios"
INTEGER = "Integer"
STRING  = "String"
//FOR = "for"
ITERADOR = "iterador"
HASTA = "hasta"
TEXTO = "Texto"


//utileria
NUMERO = [0-9]
FIN_LINEA = \r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085
ESPACIO = " " | "\t"
GUION_BAJO = "_"
LETRA = [a-zA-Z]

//Valores
ID = ({GUION_BAJO} | {LETRA})({GUION_BAJO} | {LETRA} | {NUMERO})*
CADENA = "\""~"\""
ENTERO = {NUMERO}{NUMERO}*

//Operadores relacionales
ASIGNACION = "="

//Signos de puntuacion
P_COMA = ";"
PUNTO = "."
COMA = ","
DOS_PUNTOS = ":"

//Signos de agrupacion
PARENTESIS_A = "("
PARENTESIS_C = ")"
CORCHETE_A = "["
CORCHETE_C = "]"

//Operadores aritmeticos
MAS = "+"
MENOS = "-"
POR = "*"
DIVISION = "/"

//Comentarios
INICIO_ETIQUETA = "</"
FIN_COMENTARIO = "/>"
COMENTARIO_BLOQUE = {INICIO_ETIQUETA} ~ {FIN_COMENTARIO}

//Otros simbolos
MAYOR_QUE = ">"
MENOR_QUE = "<"
INICIO_ACCESO = "$$("
FIN_ACCESO = ")$$"


//SECCION LENGUAJE HTML

//Palabras reservadas
HTML = "html"
H1 = "h1"
H2 = "h2"
TABLE = "table"
TR = "tr"
TH = "th"
TD = "td"
BR = "br"

%%
<YYINITIAL> {RESULT}                {return symbol(sym.RESULT, yytext());}
<YYINITIAL> {SCORE}                 {return symbol(sym.SCORE, yytext());}
<YYINITIAL> {CLASES}                {return symbol(sym.CLASES, yytext());}
<YYINITIAL> {VARIABLES}             {return symbol(sym.VARIABLES, yytext());}
<YYINITIAL> {NOMBRE}                {return symbol(sym.NOMBRE, yytext());}
<YYINITIAL> {TIPO}                  {return symbol(sym.TIPO, yytext());}
<YYINITIAL> {FUNCION}               {return symbol(sym.FUNCION, yytext());}
<YYINITIAL> {METODOS}               {return symbol(sym.METODOS, yytext());}
<YYINITIAL> {PARAMETROS}            {return symbol(sym.PARAMETROS, yytext());}
<YYINITIAL> {COMENTARIOS}           {return symbol(sym.COMENTARIOS, yytext());}
<YYINITIAL> {TEXTO}                 {return symbol(sym.TEXTO, yytext());}
<YYINITIAL> {INTEGER}               {return symbol(sym.INTEGER, yytext());}
<YYINITIAL> {STRING}                {return symbol(sym.STRING, yytext());}
//<YYINITIAL> {FOR}                   {return symbol(sym.FOR, yytext());}
<YYINITIAL> {ITERADOR}              {return symbol(sym.ITERADOR, yytext());}
<YYINITIAL> {HASTA}                 {return symbol(sym.HASTA, yytext());}
<YYINITIAL> {HTML}                  {return symbol(sym.HTML, yytext());}
<YYINITIAL> {H1}                    {return symbol(sym.H1, yytext());}
<YYINITIAL> {H2}                    {return symbol(sym.H2, yytext());}
<YYINITIAL> {TABLE}                 {return symbol(sym.TABLE, yytext());}
<YYINITIAL> {TR}                    {return symbol(sym.TR, yytext());}
<YYINITIAL> {TH}                    {return symbol(sym.TH, yytext());}
<YYINITIAL> {TD}                    {return symbol(sym.TD, yytext());}
<YYINITIAL> {BR}                    {return symbol(sym.BR, yytext());}
<YYINITIAL> {ID}                    {return symbol(sym.ID, yytext());}
<YYINITIAL> {CADENA}                {return symbol(sym.CADENA, yytext());}
<YYINITIAL> {ENTERO}                {return symbol(sym.ENTERO, yytext());}
<YYINITIAL> {ASIGNACION}            {return symbol(sym.ASIGNACION, yytext());}
<YYINITIAL> {P_COMA}                {return symbol(sym.P_COMA, yytext());}
<YYINITIAL> {PUNTO}                 {return symbol(sym.PUNTO, yytext());}
<YYINITIAL> {COMA}                  {return symbol(sym.COMA, yytext());}
<YYINITIAL> {DOS_PUNTOS}            {return symbol(sym.DOS_PUNTOS, yytext());}
<YYINITIAL> {PARENTESIS_A}          {return symbol(sym.PARENTESIS_A, yytext());}
<YYINITIAL> {PARENTESIS_C}          {return symbol(sym.PARENTESIS_C, yytext());}
<YYINITIAL> {CORCHETE_A}            {return symbol(sym.CORCHETE_A, yytext());}
<YYINITIAL> {CORCHETE_C}            {return symbol(sym.CORCHETE_C, yytext());}
<YYINITIAL> {MAS}                   {return symbol(sym.MAS, yytext());}
<YYINITIAL> {MENOS}                 {return symbol(sym.MENOS, yytext());}
<YYINITIAL> {POR}                   {return symbol(sym.POR, yytext());}
<YYINITIAL> {DIVISION}              {return symbol(sym.DIVISION, yytext());}
<YYINITIAL> {MENOR_QUE}             {return symbol(sym.MENOR_QUE, yytext());}
<YYINITIAL> {MAYOR_QUE}             {return symbol(sym.MAYOR_QUE, yytext());}
<YYINITIAL> {COMENTARIO_BLOQUE}     {}
<YYINITIAL> {INICIO_ETIQUETA}       {return symbol(sym.INICIO_ETIQUETA, yytext());}
<YYINITIAL> {INICIO_ACCESO}         {return symbol(sym.INICIO_ACCESO, yytext());}
<YYINITIAL> {FIN_ACCESO}            {return symbol(sym.FIN_ACCESO, yytext());}
<YYINITIAL> {FIN_LINEA}             {}
<YYINITIAL> {ESPACIO}               {}
<<EOF>>                             {return symbol(sym.EOF, "FIN");}
<YYINITIAL> .                       {taErrores.append("El simbolo " + yytext() + " no existe en el lenguaje." + " Linea:" + (yyline+1) + " Columna:" + yycolumn + "\n"); errores = true;}