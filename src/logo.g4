grammar logo;

//Condiciones minimas par ala ejecucion del programa las cuales son un comentario y la
//iniciasion de una una variable
programa
    : comment codigo haz codigo EOF
    ;


codigo
    : (comment | instrucciones | procedimiento)*
    ;


instrucciones
    : instruccion+
    ;


instruccion
    :haz
    |inic
    |inc
    |avanza
    |retrocede
    |girarderecha
    |girarizquierda
    |ocultartortuga
    |aparecertortuga
    |ponpos
    |ponrumbo
    |ponx
    |pony
    |poncolor
    |goma
    |bajalapiz
    |subelapiz
    |borrarPantalla
    |centro
    |espera
    |ejecuta
    |repite
    |hasHasta
    |haz
    |hazMientras
    |mientras
    |hasta
    |si
    |sisino
    |imprimir
    |llamar
    ;

llamar
    : variable lista
    ;

//Gramatica en la cual se incialisan los procedimientos
//de forma tal que se inicialisa con  para el nombre de la funcion y las variables
//y luego las intruciones que se a aplican hasta llegar al fin de la funcion
procedimiento//Declara un procedimiento
    :'para' variable listaParametros
      instrucciones
      'fin'
    ;

//Gramatica aplicada para incialisar una variable
haz
    :'haz' variable token
    ;

//La gramatica aplicada a la funcion inic espera la palabra inic la variable y
//estring = y un token por el cual cambiara su valor
inic
    :'inic' variable '=' token
    ;

//Resguarda los diferentes tipos de expresiones tanto strings
//como expresiones matematicas o expresiones logicas
token
    : PAR_OPEN token PAR_CLOSE
    | expresionIndeterminada
    | expresionLogica
    | string
    | expresionNumerica
    ;



//La funcion inic sin ningun token numerico aumenta uno a uno cada valor
//si tiene 2 o mas tokens numericos aumentan esos valores
inc
    :'inc' BRACKET_OPEN variable tokenNumerico BRACKET_CLOSE
    |'inc' BRACKET_OPEN variable BRACKET_CLOSE
    ;

//La intruccion avanza recibe un token numerico luego de esto dibuja una linea recta de de token
//numerico introducido
avanza
    :'avanza' tokenNumerico
    |'av' tokenNumerico
    ;

//La intruccion retrocede recibe un token numerico luego de esto dibuja una linea recta de de token
//numerico introducido
retrocede
    :'retrocede' tokenNumerico
    |'re' tokenNumerico
    ;

//La instruccion girar derecha reciben un token numerico el cual tomara el valor del angulo al que se mueve
girarderecha
    :'giraDerecha' tokenNumerico
    |'gd' tokenNumerico
    ;
//La instruccion girar izquierda reciben un token numerico el cual tomara el valor del angulo al que se mueve
girarizquierda //Gira a la izquierda n angulos
    :'giraIzquierda' tokenNumerico
    |'gi' tokenNumerico
    ;

//Cuando esta instruccion aparece se oculta la tortuga
ocultartortuga //Oculta el avatar
    :'ocultatortuga'
    |'ot'
    ;

//Cuando esta instruccion aparece se aparece la tortuga
aparecertortuga
    :'aparecetortuga'
    |'at'
    ;

//Coloca a la tortuga en una posicion de cordenadas XY introducidos por el token numerico
//Dependiendo de si se utiliza ponpos o ponxy estos valores deveran de estar detro de parentesis cuadrados
ponpos
    :'ponpos' BRACKET_OPEN tokenNumerico tokenNumerico BRACKET_CLOSE
    |'ponxy' tokenNumerico tokenNumerico
    ;

//La gramatica aplicada toma el valor del token numerico cambia el valor numerico del angulo
ponrumbo
    :'ponrumbo' tokenNumerico
    ;

//Muestra el valor del angulo actual
rumbo
    :'rumbo'
    ;
 //La gramatica de esta funcion recibe un token numerico el cual cambia el valor de la posicion X
ponx
    :'ponx' tokenNumerico
    ;

//La gramatica de esta funcion recibe un token numerico el cual cambia el valor de la posicion y
pony
    :'pony' tokenNumerico
    ;


imprimir
    : 'imprimir' token
    ;

//Esta funcion se utiliza para borrar
goma
    :'goma'
    ;

//El lapiz inicia a dibujar
bajalapiz
    :'bajalapiz'
    |'bl'
    ;
//El lapiz deja de dibujar cuando se mueve
subelapiz
    :'subelapiz'
    |'sb'
    ;

//La gramatica de esta funcion permite cambiar el colo al dibujar reciviendo un string determinado
poncolor
    :'poncolorlapiz' string
    |'poncl' string
    ;

//Escribe la posicion XY en el centro de la grmatica
centro
    :'centro'
    ;
//la funcion espera recibe un token numerico en el cual ese valor se dibidira entre 60 para seguir ejecutandose
espera
    :'espera' tokenNumerico
    ;

//La gramatica de esta funcion ejecuta una insturccion de forma directa
ejecuta
    :'ejecuta' BRACKET_OPEN instrucciones BRACKET_CLOSE
    ;

//La gramatica de esta funcion ejecuta una instruccion segun el token numerico veces
repite
    :'repite' tokenNumerico BRACKET_OPEN instrucciones BRACKET_CLOSE
    ;

//La gramatica aplica una comparacion logica dentro de los parentesis circulares si esta no se da
//se aplican las intrucciones establecidas dentro de los parentesis cuadrados
si
    :'si' PAR_OPEN tokenLogico PAR_CLOSE
     BRACKET_OPEN instrucciones BRACKET_CLOSE
    ;
//Realiza las primeras instrucciones si la condición
  //expresada se cumple, y realiza el otro grupo de
  //instrucciones sino se cumple la condición.
sisino
    :'sisino' PAR_OPEN tokenLogico PAR_CLOSE
     BRACKET_OPEN instrucciones BRACKET_CLOSE
     BRACKET_OPEN instrucciones BRACKET_CLOSE
    ;
//Repite la lista de instrucciones tantas veces hasta
  //que se cumpla la condicion. Primero lee el conjunto
  //de instrucciones, de esta forma se asegura que las
  //instrucciones se ejecutan al menos una vez antes de
  //comprobar la condición
hasHasta
    :'haz.hasta'
      BRACKET_OPEN
            instrucciones
      BRACKET_CLOSE
      BRACKET_OPEN  tokenLogico  BRACKET_CLOSE
    ;

//Repite la lista de instrucciones tanta veces
  //hasta que se cumpla la condición. Si la
  //condición expresada se cumple no se ejecutan
  //las instrucciones ni una sola vez.
hasta
    :'hasta' BRACKET_OPEN  tokenLogico  BRACKET_CLOSE
     BRACKET_OPEN
            instrucciones
     BRACKET_CLOSE
    ;
//Repite la lista de instrucciones tantas veces
  //como se de la condición expresada. Primero
  //lee el conjunto de instrucciones, de esta forma
  //se asegura que las instrucciones se ejecutan al
  //menos una vez antes de comprobar la
  //condición.
hazMientras
    :'haz.mientras'
      BRACKET_OPEN
            instrucciones
      BRACKET_CLOSE
      BRACKET_OPEN  tokenLogico  BRACKET_CLOSE
    ;
//Repite la lista de instrucciones tanta veces
//como se de la condición. Si la condición
//expresada no se cumple no se ejecutan las
//instrucciones ni una sola vez.
mientras
    :'mientras' BRACKET_OPEN  tokenLogico  BRACKET_CLOSE
      BRACKET_OPEN
            instrucciones
      BRACKET_CLOSE
    ;

booleanos
    : iguales
    | yLogico
    | oLogico
    ;

//Devuelve TRUE si token1 y y token2 son iguales, de lo
  //contario devuelve FALSO.
iguales
    :'iguales?' tokenNumerico  tokenNumerico
    ;

//Devuelve TRUE si tanto la condición token1 como token2
//son ciertos.
yLogico
    :'y' tokenLogico  tokenLogico
    ;

//Devuelve CIERTO si al menos una de las
  //condiciones es cierta.
oLogico
    :'o' tokenLogico  tokenLogico
    ;

tokenLogico
    : PAR_OPEN tokenLogico PAR_CLOSE
    | expresionLogica
    | expresionIndeterminada
    ;

expresionLogica
    : expresionLogicaSimple
    | booleanos
    | BOOL
    ;

expresionLogicaSimple
    : tokenNumerico operadorCondicional tokenNumerico
    | mayorque
    | menorque
    ;

operadorCondicional
    : '<'
    | '>'
    | '='
    ;
//Devuelve verdadero si token1 es mayor que token2
mayorque
    : 'mayorque?' tokenNumerico  tokenNumerico
    ;
menorque //Devuelve si N1 es menor que N2
    : 'menorque?' tokenNumerico  tokenNumerico
    ;

operacionAritmetica
    :redondea
    |diferencia
    |azar
    |menos
    |producto
    |potencia
    |division
    |resto
    |suma
    ;

redondea//aproxima un decimal n hasta al entero mas positivo
    :'redondea' tokenNumerico
    ;

azar//Genera un numero decimal n hasta el numero proximo
    :'azar' tokenNumerico
    ;

menos //cambia el signo de de n
    :'menos' tokenNumerico
    ;

producto //Multiplicar n numeros
    :'producto' tokenNumerico (tokenNumerico)+
    ;

potencia //Calcula una potencia, dos numeors
    :'potencia' tokenNumerico  tokenNumerico
    ;

division //division de dos numeros
    :'division' tokenNumerico tokenNumerico
    ;

resto //El residuo de una division entera, dos numeros
    :'resto' tokenNumerico  tokenNumerico
    ;

diferencia//Diferencia (n1-n2-n3...)
    :'diferencia' tokenNumerico (tokenNumerico)+
    ;

suma //Suma de numeros-Revisar como tener n-numeros
    :'suma' tokenNumerico (tokenNumerico)+
    ;

expresionIndeterminada
    : elegir
    | ultimo
    | elemento
    | primero
    | variable
    ;


elegir //Devuelve un elemento al azar de la lista.
    :'elegir' lista
    ;

cuenta//Cuenta el numero de elementos
    :'cuenta' lista
    ;
ultimo //Devuelve el ultimo elemento de la lista
    :'ultimo' lista
    |'ul' lista
    ;
elemento//Devuelve el n-esimo elemento de lista
    :'elemento' tokenNumerico lista
    ;
primero //Devuelve el primer elemento de la lista
    : 'primero' lista
    ;

borrarPantalla //Limpia completamente el liezo
    :'borraPantalla'
    ;

tokenNumerico
    : PAR_OPEN tokenNumerico PAR_CLOSE
    | expresionNumerica
    ;

expresionNumerica
   : expresionMultiplicativa (('+' | '-') expresionMultiplicativa)*
   ;

expresionMultiplicativa
   : expresionConSigno (('*' | '/') expresionConSigno)*
   | PAR_OPEN expresionMultiplicativa PAR_CLOSE
   ;

expresionConSigno
   : (('+' | '-'))* expresionNumericaCompleja
   | PAR_OPEN expresionConSigno PAR_CLOSE
   ;

expresionNumericaCompleja
    : PAR_OPEN expresionNumericaCompleja PAR_CLOSE
    | PAR_OPEN expresionNumerica PAR_CLOSE
    | operacionAritmetica
    | expresionIndeterminada
    | cuenta
    | rumbo
    | numero
    ;

numero
   : NUMERO
   ;

comment
   : COMMENT
   ;

listaParametros
   : BRACKET_OPEN  (variable)* BRACKET_CLOSE
   ;

lista
    : BRACKET_OPEN (token)* BRACKET_CLOSE
    ;

variable
   : NOMBRE
   ;

string
   : STRING
   | expresionIndeterminada
   ;

STRING : '"' ( '\\"' | . )*? '"' ;

BRACKET_OPEN: '[';
BRACKET_CLOSE: ']';

PAR_OPEN: '(';
PAR_CLOSE: ')';

COMMENT
   : '//' ~ [\r\n]*
   ;

NOMBRE
   :  [a-z] CARACTER CARACTER CARACTER CARACTER CARACTER CARACTER CARACTER CARACTER CARACTER
   |  [a-z] CARACTER CARACTER CARACTER CARACTER CARACTER CARACTER CARACTER CARACTER
   |  [a-z] CARACTER CARACTER CARACTER CARACTER CARACTER CARACTER CARACTER
   |  [a-z] CARACTER CARACTER CARACTER CARACTER CARACTER CARACTER
   |  [a-z] CARACTER CARACTER CARACTER CARACTER CARACTER
   |  [a-z] CARACTER CARACTER CARACTER CARACTER
   |  [a-z] CARACTER CARACTER CARACTER
   |  [a-z] CARACTER CARACTER
   |  [a-z] CARACTER
   |  [a-z]
   ;

NUMERO
   : [0-9] +
   ;

BOOL
   : 'TRUE'
   | 'FALSE'
   ;

CARACTER
   : [a-zA-Z0-9&@_-]
   ;

WS
   : [ \t\r\n] -> skip
   ;
