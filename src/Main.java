import SemanticErrorManager.SemanticException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create a CharStream that reads from standard input
        String texto = "//comentario\n" +
                "poncl \"Azul\""+
                "\n" +
                "para funcion1 [var]\n" +
                "    imprimir 2\n" +
                "fin\n" +
                "\n" +
                "para funcion1 []\n" +
                "    imprimir 1\n" +
                "    funcion1 [2]\n" +
                "fin\n" +
                "\n" +
                "funcion1 []\n" +
                "\n" +
                "haz var 1\n" +
                "borrarPantalla\n" +
                "imprimir primero [1]\n" +
                "imprimir elemento 1 [1 2 3]\n" +
                "imprimir ultimo [1 2 3 \"hola\"]\n" +
                "imprimir ul [1 2 3 \"hola\"]\n" +
                "imprimir cuenta [1 2 3]\n" +
                "imprimir elegir [TRUE FALSE 1]\n" +
                "haz var0 suma 1 1\n" +
                "haz var3 var0\n"+
                "haz var2 TRUE\n" +
                "inic var2 = primero [FALSE 2 3]\n" +
                "\n" +
                "haz x 0\n" +
                "mientras [x <1] [ imprimir x inic x = x+1]\n" +
                "\n" +
                "haz cond TRUE\n" +
                "si (y cond mayorque? 5 4) [ imprimir \"f\"]\n" +
                "sisino (mayorque? 5 4) [ imprimir \"c\"] [imprimir \"f\"]\n" +
                "\n" +
                "ejecuta [imprimir \"hola\"]\n" +
                "espera 3\n" +
                "centro\n" +
                "poncl \"Azul\"\n" +
                "poncolorlapiz \"Azul\"\n" +
                "subelapiz sb bajalapiz bj goma pony 1 ponx 1 rumbo ponrumbo 1\n" +
                "ponpos [1 1]\n" +
                "ponposxy 1 1\n" +
                "aparecetortuga at\n" +
                "ocultartortuga ot\n" +
                "girarIzquierda 1 gi 1\n" +
                "girarDerecha 1 gd 1 \n" +
                "retrocede 1 re 1\n" +
                "avanza 1 av 1\n" +
                "\nimprimir var2 imprimir var3 " +
                "inc [var3 3]\n" +
                "imprimir var2";

        //texto="//sdas\nhaz var 1\nsisino (FALSE) [imprimir 1] [imprimir 2]";
        ANTLRInputStream input = new ANTLRInputStream(texto);
        //Se crea el error listener
        SyntaxErrorListener errorListener = new SyntaxErrorListener();

        // create a lexer that feeds off of input CharStream
        logoLexer lexer = new logoLexer(input);

        //Agregar error listener al lexer
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener); // add ours

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        logoParser parser = new logoParser(tokens);

        parser.removeErrorListeners(); // remove ConsoleErrorListener
        //Se agrega el error listener
        parser.addErrorListener(errorListener); // add ours
        parser.setErrorHandler(new StrictErrorStrategySpanish());

        try {
            ParseTree tree = parser.programa();

            // begin parsing at init rule

            //Checking for syntax errors
            if(!errorListener.isErrorDetected()){
                //System.out.println(tree.toStringTree());

                // print LISP-style tree
                logoBaseVisitor extractor = new logoBaseVisitor();
                try {
                    List<Dato> datos = extractor.visit(tree);
                    for(Dato dato: datos){
                        System.out.println(dato.toString());
                    }
                }catch (SemanticException e){
                    System.out.println(e.getMessage());
                }
            }else {
                //Error de Syntaxis
                System.out.println(errorListener.getErrorMessage());
            }
        }catch (RuntimeException e){
            System.out.println(errorListener.getErrorMessage());
        }

    }
}