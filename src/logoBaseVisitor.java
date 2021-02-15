import SemanticErrorManager.*;
import org.antlr.v4.runtime.tree.*;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * El presente visitor se encarga de la ejecución del código a partir del árbol AST
 * generado en paso anteriores del compilador. Además se encarga del análisis semántico.
 *
 */

public class logoBaseVisitor  implements logoVisitor<List<Dato>> {
	/**
	 * Se definen los mapas que funcionan como tablas para almacenar los valores de las variables
	 */
	private Map<String, Integer> integerMap = new HashMap<>();
	private Map<String, String> stringStringMap = new HashMap<>();
	private Map<String, Boolean> booleanMap = new HashMap<>();

	/**
	 * Se definen los colores disponibles para el lapiz
	 */
	private static ArrayList<String> colores = new ArrayList<>(
			Arrays.asList("Blanco", "Azul", "Marron", "Cian", "Amarillo", "Rojo", "Verde"));

	/**
	 * Se define el mapa de funciones, que almacena las firmas e información de los procedimientos definidos
	 */
	private final Map<String, ArrayList<Funcion>> funcionMap = new HashMap<>();


	/**
	 * Método para visitar la definición de programa en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacio
	 */
	@Override public List<Dato> visitPrograma(logoParser.ProgramaContext ctx) {
		visitChildren(ctx);
		return new ArrayList<>();
	}

	/**
	 * Método para visitar la definición de código en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacio
	 */
	@Override public List<Dato> visitCodigo(logoParser.CodigoContext ctx) {
		visitChildren(ctx);
		return new ArrayList<>();
	}

	/**
	 * Método para visitar la definición de instrucciones en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacio
	 */
	@Override public List<Dato> visitInstrucciones(logoParser.InstruccionesContext ctx) {
		visitChildren(ctx);
		return new ArrayList<>();
	}

	/**
	 * Método para visitar el nodo de instrucción
	 * @param ctx the parse tree
	 * @return Arraylist vacio
	 */
	@Override public List<Dato> visitInstruccion(logoParser.InstruccionContext ctx) {
		visitChildren(ctx);
		return new ArrayList<>();
	}

	/**
	 *  Método para llamar y ejecutar un procedimiento
	 * @param ctx the parse tree
	 * @return Arraylist vació
	 * @throws SemanticException Excepción en caso de que no se encuentre el procedimiento llamado
	 */
	@Override public List<Dato> visitLlamar(logoParser.LlamarContext ctx) throws SemanticException {
		String variable = ctx.variable().getText();
		List<Dato> lista = visitLista(ctx.lista());

		ArrayList<Funcion> funcionesActuales = funcionMap.get(variable);

		Funcion funcionActual = null;
		if (funcionesActuales != null){
			for (Funcion funcion : funcionesActuales){
				if (funcion.getParametros().size() == lista.size()){
					funcionActual = funcion;
					break;
				}
			}
			if (funcionActual != null){

				Map<String, Integer> currentIntegerMap = integerMap;
				Map<String, String> currentStringStringMap = stringStringMap;
				Map<String, Boolean> currentBooleanMap = booleanMap;

				integerMap = new HashMap<>();
				stringStringMap = new HashMap<>();
				booleanMap = new HashMap<>();

				for (int i=0; i < funcionActual.getParametros().size(); i++){
					Dato dato =lista.get(i);
					if (dato.getTipo() == Dato.TYPE_STRING) {
						stringStringMap.put(funcionActual.getParametros().get(i), dato.getDatoAsString());
					} else if (dato.getTipo() == Dato.TYPE_INT) {
						integerMap.put(funcionActual.getParametros().get(i), dato.getDatoAsInteger());
					} else {
						booleanMap.put(funcionActual.getParametros().get(i), dato.getDatoAsBoolean());
					}
				}

				visitInstrucciones(funcionActual.getInstrucciones());

				integerMap = currentIntegerMap;
				stringStringMap = currentStringStringMap;
				booleanMap = currentBooleanMap;

			} else {
				throw new MethodNotFoundException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), variable, lista.size());

			}
		}else {
			throw new MethodNotFoundException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), variable, lista.size());
		}

		return new ArrayList<>();
	}


	/**
	 * Método para definir un procedimiento
	 * @param ctx the parse tree
	 * @return Arraylist vacio
	 * @throws SemanticException Excepción en caso de que ya exista el procedimiento
	 */
	@Override public List<Dato> visitProcedimiento(logoParser.ProcedimientoContext ctx) throws SemanticException {
		String variable = ctx.variable().getText();
		List<Dato> parametros = visitListaParametros(ctx.listaParametros());
		List<String> stringParam = new ArrayList<>();

		for (Dato parametro : parametros) {
			stringParam.add(parametro.getDatoAsString());
		}

		ArrayList<Funcion> listaFunciones = funcionMap.get(variable);
		if (listaFunciones != null){
			for (Funcion funcion : listaFunciones){
				if (funcion.getParametros().size() == parametros.size()){
					throw new DuplicatedMethodSignatureException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), variable, parametros.size());
				}
			}
			listaFunciones.add(new Funcion(variable, stringParam, ctx.instrucciones()));
		}else {
			ArrayList<Funcion> newArray = new ArrayList<>();
			newArray.add(new Funcion(variable, stringParam, ctx.instrucciones()));
			funcionMap.put(variable, newArray);
		}
		return new ArrayList<>();

	}

	/**
	 * Método para definir una variable
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 * @throws SemanticException Excepción en caso de que ya exista la variable
	 */
	@Override public List<Dato> visitHaz(logoParser.HazContext ctx) throws SemanticException {
		String variable = ctx.variable().getText();
		Dato token = visitToken(ctx.token()).get(0);

		if (stringStringMap.get(variable) == null && integerMap.get(variable) == null && booleanMap.get(variable) == null){
			if (token.getTipo() == Dato.TYPE_STRING){
				stringStringMap.put(variable,token.getDatoAsString());
			}else if(token.getTipo() == Dato.TYPE_INT){
				integerMap.put(variable,token.getDatoAsInteger());
			}else{
				booleanMap.put(variable,token.getDatoAsBoolean());
			}
		} else {
			throw new DuplicatedVariableException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), variable);
		}

		return new ArrayList<>();
	}

	/**
	 * Método para cambiar el valor de una variable
	 * @param ctx the parse tree
	 * @return Arraylist vacio
	 * @throws SemanticException Error en caso de que la variable no exista o de que sea del tipo incorrecto
	 */
	@Override public List<Dato> visitInic(logoParser.InicContext ctx) throws SemanticException {
		String variable = ctx.variable().getText();
		Dato currentDato = visitVariable(ctx.variable()).get(0);
		Dato token = visitToken(ctx.token()).get(0);

		if (token.getTipo() == Dato.TYPE_STRING && currentDato.getTipo() == Dato.TYPE_STRING){
			stringStringMap.replace(variable,token.getDatoAsString());
		}else if(token.getTipo() == Dato.TYPE_INT && currentDato.getTipo() == Dato.TYPE_INT){
			integerMap.replace(variable,token.getDatoAsInteger());
		}else if(token.getTipo() == Dato.TYPE_BOOL && currentDato.getTipo() == Dato.TYPE_BOOL){
			booleanMap.replace(variable,token.getDatoAsBoolean());
		} else {
			throw new UnexpectedTypeException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
					currentDato.getTypeAsString(), token.getTypeAsString());
		}
		return new ArrayList<>();
	}

	/**
	 * Método para obtener el valor de un token
	 * @param ctx the parse tree
	 * @return Un arraylist con el dato del token
	 * @throws SemanticException
	 */
	@Override public List<Dato> visitToken(logoParser.TokenContext ctx) throws SemanticException {
		List<Dato> retval;
		if(ctx.expresionIndeterminada()!=null) {
			retval = visitExpresionIndeterminada(ctx.expresionIndeterminada());
		}else if(ctx.expresionNumerica()!=null){
			retval=visitExpresionNumerica(ctx.expresionNumerica());
		}else if(ctx.expresionLogica()!=null){
			retval=visitExpresionLogica(ctx.expresionLogica());
		}else if(ctx.string()!=null){
			retval=visitString(ctx.string());
		}else{
			retval= visitToken(ctx.token());
		}
		return retval;
	}

	/**
	 * Método para aumentar el valor de una variable
	 * @param ctx the parse tree
	 * @return El valor de la variable aumentado en uno, o en el número indicado en el AST, si hubiera uno
	 * @throws SemanticException
	 */
	@Override public List<Dato> visitInc(logoParser.IncContext ctx) throws SemanticException {
		String variable = ctx.variable().getText();
		Dato currentDato = visitVariable(ctx.variable()).get(0);

		if (currentDato.getTipo() == Dato.TYPE_INT) {
			int incVar;
			int currentVar = currentDato.getDatoAsInteger();
			if (ctx.tokenNumerico() == null) {
				incVar = currentVar + 1;
			} else {
				int incremento = visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
				incVar = currentVar + incremento;
			}
			integerMap.replace(variable, incVar);
		}else {
			throw new UnexpectedTypeException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
					"Entero", currentDato.getTypeAsString());
		}
		return new ArrayList<>();
	}

	/**
	 * Método para mover la tortuga hacia adelante
	 * @param ctx the parse tree
	 * @return Un arraylist vacío
	 */
	public List<Dato> visitAvanza(logoParser.AvanzaContext ctx) {
		int pasos= visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
		Window.tortuga.OcCoor((Graphics2D) Window.getGraphics2d());
		try {
			Window.tortuga.avanzar((Graphics2D) Window.getGraphics2d(), pasos);

		}catch (SemanticException e){
				throw new OutOfPanelException(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		}
		//Window.getInstance().tortuga.avanzar((Graphics2D) Window.getInstance().getGraphics2d(), pasos);

		return new ArrayList<>();
	}

	/**
	 * Método para hacer que la tortuga retroceda en el panel
	 * @param ctx the parse tree
	 * @return Un arraylist vacío
	 */
	public List<Dato> visitRetrocede(logoParser.RetrocedeContext ctx) {
		int pasos= visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
		Window.tortuga.OcCoor((Graphics2D) Window.getGraphics2d());

		try {
			Window.tortuga.retroceder((Graphics2D) Window.getGraphics2d(), pasos);
		}catch (SemanticException e){
			throw new OutOfPanelException(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		}
		return new ArrayList<>();
	}

	/**
	 * Método para hacer que la tortuga gire hacia la derecha, según el ángulo indicado en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitGirarderecha(logoParser.GirarderechaContext ctx) {
		int angulo= visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
		Window.tortuga.girar_derecha(angulo);
		Window.tortuga.OcTortuga((Graphics2D) Window.dibujo.getGraphics());
		Window.tortuga.OcTortuga((Graphics2D) Window.dibujo.getGraphics());

		return new ArrayList<>();
	}

	/**
	 * Método para hacer que la tortuga gire hacia la izquierda, según el ángulo indicado en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitGirarizquierda(logoParser.GirarizquierdaContext ctx) {
		int angulo= visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
		Window.getInstance().tortuga.girar_izquierda(angulo);
		Window.tortuga.OcTortuga((Graphics2D) Window.dibujo.getGraphics());
		Window.tortuga.OcTortuga((Graphics2D) Window.dibujo.getGraphics());

		return new ArrayList<>();
	}

	/**
	 * Método para ocultar la tortuga del panel
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitOcultartortuga(logoParser.OcultartortugaContext ctx) {
		Window.tortuga.visTort = false;
		Window.tortuga.OcTortuga((Graphics2D) Window.dibujo.getGraphics());
		Window.tortuga.OcTortuga((Graphics2D) Window.dibujo.getGraphics());

		return new ArrayList<>();

	}

	/**
	 * Método para hacer aparecer la tortuga en el panel de dibujo
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitAparecertortuga(logoParser.AparecertortugaContext ctx) {
		Window.tortuga.visTort = true;
		return new ArrayList<>();
	}

	/**
	 * Método para cambiar la posición de la tortuga según se indique en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitPonpos(logoParser.PonposContext ctx) {
		int posX = visitTokenNumerico(ctx.tokenNumerico(0)).get(0).getDatoAsInteger();
		int posY = visitTokenNumerico(ctx.tokenNumerico(1)).get(0).getDatoAsInteger();
		Window.tortuga.ponpos(posX, posY);
		return new ArrayList<>();
	}

	/**
	 * Método para cambiar el ángulo de la tortuga según se indique en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitPonrumbo(logoParser.PonrumboContext ctx) {
		int rumbo= visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
		Window.tortuga.pon_rumbo(rumbo);
		Window.tortuga.OcTortuga((Graphics2D) Window.dibujo.getGraphics());
		Window.tortuga.OcTortuga((Graphics2D) Window.dibujo.getGraphics());
		return new ArrayList<>();
	}

	/**
	 * Método para obtener el ángulo actual de la tortuga
	 * @param ctx the parse tree
	 * @return El ángulo actual de la tortuga en forma de dato en un arraylist
	 */
	@Override public List<Dato> visitRumbo(logoParser.RumboContext ctx) {
		return new Dato(Window.tortuga.rumbo(), Dato.TYPE_INT).toSingleArraylist();
	}

	/**
	 * Método para cambiar la posición x de la tortuga según se indica en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitPonx(logoParser.PonxContext ctx) {
		int orientacionX= visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
		Window.tortuga.ponx(orientacionX);
		return new ArrayList<>();
	}

	/**
	 * Método para cambiar la posición y de la tortuga según se indica en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitPony(logoParser.PonyContext ctx) {
		int orientacionY= visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
		Window.tortuga.pony(orientacionY);
		return new ArrayList<>();
	}

	/**
	 * Método para imprimir lo indicado en el AST en la consola
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override
	public List<Dato> visitImprimir(logoParser.ImprimirContext ctx) {
		Dato textoDato=visitToken(ctx.token()).get(0);
		System.out.println(textoDato.getDato());
		Window.getInstance().getErrores().setText(Window.getInstance().getErrores().getText() +"\n"
				+ textoDato.toString());
		return new ArrayList<>();
	}

	/**
	 * Método para que la tortuga no dibuje, sino que más bien borre por donde pase
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitGoma(logoParser.GomaContext ctx) {
		Window.tortuga.goma();
		return new ArrayList<>();
	}

	/**
	 * Método para bajar el lapiz y que el usuario pueda dibujar
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitBajalapiz(logoParser.BajalapizContext ctx) {
		Window.dibujo.addMouseListener(Window.mouse);
		Window.dibujo.addMouseMotionListener(Window.adapter);
		return new ArrayList<>();
	}

	/**
	 * Método para subir el lapiz y que el usuario no pueda dibujar
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitSubelapiz(logoParser.SubelapizContext ctx) {
		Window.getInstance().mouseDraw_not();
		return new ArrayList<>();
	}

	/**
	 * Método para cambiar el color de acuerdo al índicado en el AST, genera una excepcion si el color no
	 * se encuentra en los disponibles
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitPoncolor(logoParser.PoncolorContext ctx) {
		String color = visitString(ctx.string()).get(0).getDatoAsString();

		if (color.equalsIgnoreCase("blanco")){
			Window.tortuga.poncolor(Color.white);
		}
		else if (color.equalsIgnoreCase("azul")){
			Window.tortuga.poncolor(Color.BLUE);
		}
		else if (color.equalsIgnoreCase("marron")){
			Window.tortuga.poncolor(Color.getHSBColor(128, 64, 0));
		}
		else if (color.equalsIgnoreCase("cian")){
			Window.tortuga.poncolor(Color.CYAN);
		}
		else if (color.equalsIgnoreCase("gris")){
			Window.tortuga.poncolor(Color.GRAY);
		}
		else if (color.equalsIgnoreCase("amarillo")){
			Window.tortuga.poncolor(Color.YELLOW);
		}
		else if (color.equalsIgnoreCase("negro")){
			Window.tortuga.poncolor(Color.black);
		}
		else if (color.equalsIgnoreCase("rojo")){
			Window.tortuga.poncolor(Color.RED);
		}
		else if (color.equalsIgnoreCase("verde")){
			Window.tortuga.poncolor(Color.GREEN);
		}else{
			throw new InvalidColorException(ctx.start.getLine(),ctx.start.getCharPositionInLine(),color);
		}
		return new ArrayList<>();
	}

	/**
	 * Método para poner la tortuga en el centro del panel de dibujo
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitCentro(logoParser.CentroContext ctx) {
		Window.tortuga.centro();
		return new ArrayList<>();
	}

	/**
	 * Método para esperar la cantidad de segundos indicados en el AST /60 para dibujar
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitEspera(logoParser.EsperaContext ctx) {
		int espera= visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
		try {
			Thread.sleep(espera*1000/60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	/**
	 * Método para entrar en un contexto de ejecutar,
	 * Se ejecutan las instrucciones indicadas en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitEjecuta(logoParser.EjecutaContext ctx) {
		visitInstrucciones(ctx.instrucciones());
		return new ArrayList<>();
	}

	/**
	 * Método para repetir las instrucciones indicadas por el AST
	 * de acuerdo a la cantidad de veces indicada por el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitRepite(logoParser.RepiteContext ctx)  {
		Integer rango=visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
		for(int i = 0;i < rango; i++){
			visitInstrucciones(ctx.instrucciones());
		}
		return new ArrayList<>();
	}

	/**
	 * Método para visitar una instrucción condicional
	 * La condición y el bloque a ejecutar se indica en el AST
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitSi(logoParser.SiContext ctx)  {
		Boolean condicion=visitTokenLogico(ctx.tokenLogico()).get(0).getDatoAsBoolean();
		if(condicion){
			visitInstrucciones(ctx.instrucciones());
		}
		return new ArrayList<>();
	}

	/**
	 * Método para visitar un bloque condicional
	 * El AST indica la condición y los blqoues a ejecutar
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitSisino(logoParser.SisinoContext ctx)  {
		Boolean condicion=visitTokenLogico(ctx.tokenLogico()).get(0).getDatoAsBoolean();
		if(condicion){
			visitInstrucciones(ctx.instrucciones(0));
		}else{
			visitInstrucciones(ctx.instrucciones(1));
		}
		return new ArrayList<>();
	}

	/**
	 * Método para visitar el ciclo haz.hasta, el cual ejecuta ciertas instrucciones
	 * hasta que se cumpla la condición. Ademas, siempre se ejecutan las instrucciones
	 * al menos una vez.
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitHasHasta(logoParser.HasHastaContext ctx) {
		Boolean condicion;
		do{
			visitInstrucciones(ctx.instrucciones());
			condicion=visitTokenLogico(ctx.tokenLogico()).get(0).getDatoAsBoolean();
		}while (!condicion);
		return new ArrayList<>();
	}

	/**
	 * Método para visitar el ciclo hasta, el cual ejecuta ciertas instrucciones
	 * hasta que se cumpla la condición
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitHasta(logoParser.HastaContext ctx)  {
		Boolean condicion = visitTokenLogico(ctx.tokenLogico()).get(0).getDatoAsBoolean();
		while(!condicion){
			visitInstrucciones(ctx.instrucciones());
			condicion=visitTokenLogico(ctx.tokenLogico()).get(0).getDatoAsBoolean();
		}
		return new ArrayList<>();

	}

	/**
	 * Método para visitar el ciclo Haz Mientras, el cual ejecuta ciertas instrucciones
	 * mientras se cumpla una condición. Siempre se ejecutan las instrucciones al menos una vez.
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitHazMientras(logoParser.HazMientrasContext ctx)  {
		Boolean condicion;
		do{
			visitInstrucciones(ctx.instrucciones());
			condicion=visitTokenLogico(ctx.tokenLogico()).get(0).getDatoAsBoolean();
		}while (condicion);
		return new ArrayList<>();

	}

	/**
	 * Método para visitar el ciclo  Mientras, el cual ejecuta ciertas instrucciones
	 * mientras se cumpla una condición.
	 * @param ctx the parse tree
	 * @return Arraylist vacío
	 */
	@Override public List<Dato> visitMientras(logoParser.MientrasContext ctx) throws SemanticException {
		Boolean condicion = visitTokenLogico(ctx.tokenLogico()).get(0).getDatoAsBoolean();
		while(condicion){
			visitInstrucciones(ctx.instrucciones());
			condicion=visitTokenLogico(ctx.tokenLogico()).get(0).getDatoAsBoolean();
		}
		return new ArrayList<>();
	}

	/**
	 * Método para visitar las funciones booleanas
	 * @param ctx the parse tree
	 * @return Un arraylist con el valor booleano dentro de un dato
	 */
	@Override public List<Dato> visitBooleanos(logoParser.BooleanosContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * Método para comparar la igualdad de dos números dados por el AST
	 * @param ctx the parse tree
	 * @return Retorna el valor booleano dentro de un Dato dentro de un arraylist
	 */
	@Override public List<Dato> visitIguales(logoParser.IgualesContext ctx)  {
		List<Dato> returnVal= new ArrayList<>();

		Integer n1 =visitTokenNumerico( ctx.tokenNumerico().get(0)).get(0).getDatoAsInteger();
		Integer n2 =visitTokenNumerico( ctx.tokenNumerico().get(1)).get(0).getDatoAsInteger();

		if (n1.equals(n2)){
			returnVal.add(new Dato(true,Dato.TYPE_BOOL));
		}
		else{
			returnVal.add(new Dato(false,Dato.TYPE_BOOL));
		}
		return returnVal;
	}

	/**
	 * Método para utilizar el operador lógico Y para compara dos expresiones booleanas
	 * dadas por el AST
	 * @param ctx the parse tree
	 * @return Retorna el valor booleano dentro de un Dato dentro de un arraylist
	 */
	@Override public List<Dato> visitYLogico(logoParser.YLogicoContext ctx) {
		List<Dato> returnVal= new ArrayList<>();

		Boolean condicion1 =visitTokenLogico( ctx.tokenLogico().get(0)).get(0).getDatoAsBoolean();
		Boolean condicion2 =visitTokenLogico( ctx.tokenLogico().get(1)).get(0).getDatoAsBoolean();

		if (condicion1 && condicion2){
			returnVal.add(new Dato(true,Dato.TYPE_BOOL));
		}
		else{
			returnVal.add(new Dato(false,Dato.TYPE_BOOL));
		}
		return returnVal;
	}

	/**
	 * Método para utilizar el operador lógico O para compara dos expresiones booleanas
	 * dadas por el AST
	 * @param ctx the parse tree
	 * @return Retorna el valor booleano dentro de un Dato dentro de un arraylist
	 */
	@Override public List<Dato> visitOLogico(logoParser.OLogicoContext ctx)  {
		List<Dato> returnVal= new ArrayList<>();

		Boolean condicion1 =visitTokenLogico( ctx.tokenLogico().get(0)).get(0).getDatoAsBoolean();
		Boolean condicion2 =visitTokenLogico( ctx.tokenLogico().get(1)).get(0).getDatoAsBoolean();

		if (condicion1 || condicion2){
			returnVal.add(new Dato(true,Dato.TYPE_BOOL));
		}
		else{
			returnVal.add(new Dato(false,Dato.TYPE_BOOL));
		}
		return returnVal;
	}

	/**
	 * Método para visitar la definición de un token lógico, el cual analiza su
	 * hijo para obtener el valor booleano
	 * @param ctx the parse tree
	 * @return Retorna el valor booleano dentro de un Dato dentro de un arraylist
	 * @throws SemanticException Se genera una excepción si el valor del hijo no es booleano
	 */
	@Override public List<Dato> visitTokenLogico(logoParser.TokenLogicoContext ctx) throws SemanticException {
		List<Dato> retlist = new ArrayList<>();
		if(ctx.expresionLogica()!=null){
			retlist=visitExpresionLogica(ctx.expresionLogica());
		}else if(ctx.expresionIndeterminada()!=null){
			Dato indeterminado = visitExpresionIndeterminada(ctx.expresionIndeterminada()).get(0);
			if (indeterminado.getTipo() == Dato.TYPE_BOOL) {
				retlist.add(indeterminado);
			}else{
				throw new UnexpectedTypeException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
						"Booleano", indeterminado.getTypeAsString());
			}
		}else{
			retlist=visitTokenLogico(ctx.tokenLogico());
		}
		return retlist;
	}
	/**
	 * Método para visitar la definición de una expresión lógica, el cual analiza su
	 * hijo para obtener su expresión
	 * @param ctx the parse tree
	 * @return Retorna el valor dentro de un Dato dentro de un arraylist
	 */
	@Override public List<Dato> visitExpresionLogica(logoParser.ExpresionLogicaContext ctx)  {
		List<Dato> returnVal = new ArrayList<>();
		if(ctx.expresionLogicaSimple()!=null){
			returnVal = visitExpresionLogicaSimple(ctx.expresionLogicaSimple());
		}else if(ctx.booleanos()!=null){
			returnVal = visitBooleanos(ctx.booleanos());
		}else if(ctx.BOOL()!=null){
			String symbol=ctx.BOOL().getSymbol().getText();
			if(symbol.equals("TRUE")){
				returnVal.add(new Dato(true, Dato.TYPE_BOOL));
			}else{
				returnVal.add(new Dato(false, Dato.TYPE_BOOL));
			}
		}
		return returnVal;
	}
	/**
	 * Método para visitar la definición de una expresión lógica simple, el cual analiza su
	 * hijo para obtener su expresión simple
	 * @param ctx the parse tree
	 * @return Retorna el valor dentro de un Dato dentro de un arraylist
	 */
	@Override public List<Dato> visitExpresionLogicaSimple(logoParser.ExpresionLogicaSimpleContext ctx)  {
		List<Dato> retlist=new ArrayList<>();
		if(ctx.mayorque()!=null){
			retlist= visitMayorque(ctx.mayorque());
		}else if(ctx.menorque()!= null){
			retlist= visitMenorque(ctx.menorque());
		}else{
			int num1 = visitTokenNumerico(ctx.tokenNumerico(0)).get(0).getDatoAsInteger();
			int num2 = visitTokenNumerico(ctx.tokenNumerico(1)).get(0).getDatoAsInteger();
			String operador= visitOperadorCondicional(ctx.operadorCondicional()).get(0).getDatoAsString();
			Boolean result=null;
			switch(operador){
				case ">":
					result= num1>num2;
					break;
				case "<":
					result= num1<num2;
					break;
				case "=":
					result = num1==num2;
					break;
			}
			retlist.add(new Dato(result, Dato.TYPE_BOOL));
		}
		return retlist;
	}
	/**
	 * Método para visitar la definición de un operador condicional, el cual analiza su
	 * hijo para obtener su valor
	 * @param ctx the parse tree
	 * @return Retorna el llamado a analizar sus hijos
	 */
	@Override public List<Dato> visitOperadorCondicional(logoParser.OperadorCondicionalContext ctx) {
		return visitChildren(ctx);
	}
	/**
	 * Método para comparar si entre dos números dados por el AST,
	 * el primero es mayor que el segundo
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor booleano de la comparación
	 */
	@Override public List<Dato> visitMayorque(logoParser.MayorqueContext ctx)  {
		List<Dato> returnVal= new ArrayList<>();

		Integer n1 =visitTokenNumerico( ctx.tokenNumerico(0)).get(0).getDatoAsInteger();
		Integer n2 =visitTokenNumerico( ctx.tokenNumerico(1)).get(0).getDatoAsInteger();

		if (n1 > n2){
			returnVal.add(new Dato(true,Dato.TYPE_BOOL));
		}
		else{
			returnVal.add(new Dato(false,Dato.TYPE_BOOL));
		}
		return returnVal;
	}
	/**
	 * Método para comparar si entre dos números dados por el AST,
	 * el primero es menor que el segundo
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor booleano de la comparación
	 */
	@Override public List<Dato> visitMenorque(logoParser.MenorqueContext ctx)  {
		List<Dato> returnVal= new ArrayList<>();

		Integer n1 =visitTokenNumerico( ctx.tokenNumerico().get(0)).get(0).getDatoAsInteger();
		Integer n2 =visitTokenNumerico( ctx.tokenNumerico().get(1)).get(0).getDatoAsInteger();

		if (n1 < n2){
			returnVal.add(new Dato(true,Dato.TYPE_BOOL));
		}
		else{
			returnVal.add(new Dato(false,Dato.TYPE_BOOL));
		}
		return returnVal;
	}
	/**
	 * Método para visitar la definición de una operación aritmética, el cual analiza su
	 * hijo para obtener su valor
	 * @param ctx the parse tree
	 * @return Retorna el llamado a analizar sus hijos
	 */
	@Override public List<Dato> visitOperacionAritmetica(logoParser.OperacionAritmeticaContext ctx) {
		return visitChildren(ctx);
	}
	/**
	 * Método para redondear un número dado por el AST
	 * hacia el número entero más cercano
	 * @param ctx the parse tree
	 * @return Retorna el valor booleano de la comparación
	 */
	@Override public List<Dato> visitRedondea(logoParser.RedondeaContext ctx)  {
		List<Dato> returnVal= new ArrayList<>();

		float n1 =visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();
		Integer result = Math.round(n1);

		returnVal.add(new Dato(result,Dato.TYPE_INT));
		return returnVal;
	}
	/**
	 * Método para calcular la diferencia entre dos o más números dados por el AST
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor entero de la diferencia
	 */
	@Override public List<Dato> visitDiferencia(logoParser.DiferenciaContext ctx)  {
		List<Dato> dato = new ArrayList<>();
		List<logoParser.TokenNumericoContext> listaContext = ctx.tokenNumerico();

		for(logoParser.TokenNumericoContext tokenNumericoContext: listaContext){
			dato.addAll(visitTokenNumerico(tokenNumericoContext));
		}

		int resultado=dato.get(0).getDatoAsInteger();
		int contador=1;
		while (dato.size()>contador){
			resultado-=dato.get(contador).getDatoAsInteger();
			contador++;
		}
		List<Dato> returnVal= new ArrayList<>();
		returnVal.add(new Dato(resultado,Dato.TYPE_INT));
		return returnVal;
	}
	/**
	 * Método para obtener un número al azar dado un rango
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor entero al azar
	 */
	@Override public List<Dato> visitAzar(logoParser.AzarContext ctx)  {
		List<Dato> returnVal= new ArrayList<>();
		Integer rango =visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();

		Random rand= new Random();
		Integer randVal = rand.nextInt(rango+1);

		returnVal.add(new Dato(randVal,Dato.TYPE_INT));

		return returnVal;
	}
	/**
	 * Método para calcular el inverso aditivo de un número dado por el AST
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor entero
	 */
	@Override public List<Dato> visitMenos(logoParser.MenosContext ctx)  {
		List<Dato> returnVal= new ArrayList<>();

		Integer n1 =visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();

		Integer result = n1*-1;

		returnVal.add(new Dato(result,Dato.TYPE_INT));
		return returnVal;
	}
	/**
	 * Método para calcular el producto entre dos o más números dados por el AST
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor entero del producto
	 */
	@Override public List<Dato> visitProducto(logoParser.ProductoContext ctx)  {
		List<Dato> dato = new ArrayList<>();
		List<logoParser.TokenNumericoContext> listaContext = ctx.tokenNumerico();

		for(logoParser.TokenNumericoContext tokenNumericoContext: listaContext){
			dato.addAll(visitTokenNumerico(tokenNumericoContext));
		}

		int resultado=dato.get(0).getDatoAsInteger();
		int contador=1;
		while (dato.size()>contador){
			resultado *= dato.get(contador).getDatoAsInteger();
			contador++;
		}

		List<Dato> returnVal= new ArrayList<>();
		returnVal.add(new Dato(resultado,Dato.TYPE_INT));
		return returnVal;
	}
	/**
	 * Método para calcular la potencia de un número dada la base y el exponente por el AST
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor entero de la potencia
	 */
	@Override public List<Dato> visitPotencia(logoParser.PotenciaContext ctx)  {
		List<Dato> returnVal= new ArrayList<>();

		Integer num =visitTokenNumerico(ctx.tokenNumerico(0)).get(0).getDatoAsInteger();
		Integer exp =visitTokenNumerico(ctx.tokenNumerico(1)).get(0).getDatoAsInteger();

		int result = (int) Math.round(Math.pow(num, exp));
		returnVal.add(new Dato(result,Dato.TYPE_INT));

		return returnVal;
	}
	/**
	 * Método para calcular la división de dos números dados por el AST
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor de la división
	 */
	@Override public List<Dato> visitDivision(logoParser.DivisionContext ctx)  {
		List<Dato> returnVal= new ArrayList<>();

		float num = (float) visitTokenNumerico(ctx.tokenNumerico(0)).get(0).getDatoAsInteger();
		float denom = (float) visitTokenNumerico(ctx.tokenNumerico(1)).get(0).getDatoAsInteger();

		if(denom!=0){
			Integer result = Math.round(num/denom);
			returnVal.add(new Dato(result,Dato.TYPE_INT));
		}
		return returnVal;
	}
	/**
	 * Método para calcular el residuo de la división de dos números dados por el AST
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor
	 */
	@Override public List<Dato> visitResto(logoParser.RestoContext ctx)  {
		List<Dato> returnVal= new ArrayList<>();

		Integer num =visitTokenNumerico(ctx.tokenNumerico(0)).get(0).getDatoAsInteger();
		Integer denom =visitTokenNumerico(ctx.tokenNumerico(1)).get(0).getDatoAsInteger();

		if(!denom.equals(0)){
			Integer result = num%denom;
			returnVal.add(new Dato(result,Dato.TYPE_INT));
		}
		return returnVal;
	}
	/**
	 * Método para calcular la suma de dos o más números dados por el AST
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor de la suma
	 */
	@Override public List<Dato> visitSuma(logoParser.SumaContext ctx)  {
		List<Dato> dato = new ArrayList<>();
		List<logoParser.TokenNumericoContext> listaContext = ctx.tokenNumerico();

		for(logoParser.TokenNumericoContext tokenNumericoContext: listaContext){
			dato.addAll(visitTokenNumerico(tokenNumericoContext));
		}

		int resultado=dato.get(0).getDatoAsInteger();
		int contador=1;
		while (dato.size()>contador){
			resultado+=dato.get(contador).getDatoAsInteger();
			contador++;
		}
		Dato retval= new Dato(resultado,Dato.TYPE_INT);
		return retval.toSingleArraylist();
	}
	/**
	 * Método para visitar la definición de una expresión indeterminada, el cual analiza su
	 * hijo para obtener su valor
	 * @param ctx the parse tree
	 * @return Retorna el llamado a analizar sus hijos
	 */
	@Override public List<Dato> visitExpresionIndeterminada(logoParser.ExpresionIndeterminadaContext ctx) {
		return visitChildren(ctx);
	}
	/**
	 * Método para obtener un elemento al azar de una lista
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor que se va a retornar
	 */
	@Override public List<Dato> visitElegir(logoParser.ElegirContext ctx) throws SemanticException{
		List<Dato> returnVal = new ArrayList<>();
		List<Dato> lista = visitLista(ctx.lista());
		Random rand= new Random();
		if (lista.isEmpty()){
			throw new IndexException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
		}else {
			returnVal.add(lista.get(rand.nextInt(lista.size())));
		}
		return returnVal;
	}
	/**
	 * Método para contar los elementos de una lista
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor que se va a retornar
	 */
	@Override public List<Dato> visitCuenta(logoParser.CuentaContext ctx) {
		List<Dato> returnVal = new ArrayList<>();
		List<Dato> lista = visitLista(ctx.lista());
		returnVal.add(new Dato(lista.size(),Dato.TYPE_INT));
		return returnVal;
	}
	/**
	 * Método para obtener el último elemento de una lista
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor que se va a retornar
	 * @throws SemanticException Excepción en caso de que se busque un elemento fuera del rango posible
	 */
	@Override public List<Dato> visitUltimo(logoParser.UltimoContext ctx) throws SemanticException {
		List<Dato> returnVal = new ArrayList<>();
		List<Dato> lista = visitLista(ctx.lista());
		if (lista.isEmpty()){
			throw new IndexException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
		}else {
			returnVal.add(lista.get(lista.size()-1));
		}
		return returnVal;
	}
	/**
	 * Método para obtener el n-ésimo elemento de una lista siendo n un número dado por el AST
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor que se va a retornar
	 * @throws SemanticException Excepción en caso de que se busque un elemento fuera del rango posible
	 */
	@Override public List<Dato> visitElemento(logoParser.ElementoContext ctx) throws SemanticException {
		List<Dato> returnVal= new ArrayList<>();
		List<Dato> lista = visitLista(ctx.lista());
		Integer elemento = visitTokenNumerico(ctx.tokenNumerico()).get(0).getDatoAsInteger();

		if (lista.size() <= elemento || elemento<0){
			throw new IndexException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
		}else {
			returnVal.add(lista.get(elemento));
		}
		return returnVal;
	}
	/**
	 * Método para obtener el primer elemento de una lista
	 * @param ctx the parse tree
	 * @return Retorna un arrayList con un Dato que contiene el valor que se va a retornar
	 * @throws SemanticException Excepción en caso de que se busque un elemento fuera del rango posible
	 */
	@Override public List<Dato> visitPrimero(logoParser.PrimeroContext ctx) throws SemanticException {
		List<Dato> returnVal = new ArrayList<>();
		List<Dato> lista = visitLista(ctx.lista());
		if (lista.isEmpty()){
			throw new IndexException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
		}else {
			returnVal.add(lista.get(0));
		}
		return returnVal;
	}
	/**
	 * Método para limpiar por completo la pantalla de dibujo
	 * @param ctx the parse tree
	 * @return Retorna un arrayList vacío
	 */
	@Override public List<Dato> visitBorrarPantalla(logoParser.BorrarPantallaContext ctx) {
		Window.tortuga.borrar_pantalla((Graphics2D) Window.getGraphics2d());
		return new ArrayList<>(); }

	/**
	 * Método para visitar la definición de un token numérico, el cual analiza su
	 * hijo para obtener el valor entero
	 * @param ctx the parse tree
	 * @return Retorna el valor entero dentro de un Dato dentro de un arraylist
	 */
	@Override public List<Dato> visitTokenNumerico(logoParser.TokenNumericoContext ctx)  {
		List<Dato> retlist;
		if(ctx.tokenNumerico()!=null) {
			retlist = visitTokenNumerico(ctx.tokenNumerico());
		}else{
			retlist=visitChildren(ctx);
		}
		return retlist;
	}
	/**
	 * Método para visitar la definición de una expresión numérica, el cual analiza su
	 * hijo para obtener el valor entero
	 * @param ctx the parse tree
	 * @return Retorna el valor entero dentro de un Dato dentro de un arraylist
	 */
	@Override public List<Dato> visitExpresionNumerica(logoParser.ExpresionNumericaContext ctx) {
		List<Dato> datos = visitChildren(ctx);
		int result = datos.get(0).getDatoAsInteger();
		String operador= null;
		for(int i=1; i<datos.size();i++){
			Dato dato= datos.get(i);
			if(i%2==0){
				int nextNum= dato.getDatoAsInteger();
				switch (operador) {
					case "+":
						result+=nextNum;
						break;
					case "-":
						result-=nextNum;
						break;
				}
			}else{
				operador= dato.getDatoAsString();
			}
		}
		Dato retval= new Dato(result,Dato.TYPE_INT);
		return retval.toSingleArraylist();
	}
	/**
	 * Método para visitar la definición de una expresión multiplicativa, el cual analiza su
	 * hijo para obtener el valor entero
	 * @param ctx the parse tree
	 * @return Retorna el valor entero dentro de un Dato dentro de un arraylist
	 */
	@Override public List<Dato> visitExpresionMultiplicativa(logoParser.ExpresionMultiplicativaContext ctx) {
		List<Dato> retval;
		if(ctx.expresionMultiplicativa()!=null){
			retval= visitExpresionMultiplicativa(ctx.expresionMultiplicativa());
		}else{
			List<Dato> datos = visitChildren(ctx);
			float result = datos.get(0).getDatoAsInteger();
			String operador = null;
			for (int i = 1; i < datos.size(); i++) {
				Dato dato = datos.get(i);
				if (i % 2 == 0) {
					int nextNum = dato.getDatoAsInteger();
					switch (operador) {
						case "*":
							result *= nextNum;
							break;
						case "/":
							result /= nextNum;
							break;
					}
				} else {
					operador = dato.getDatoAsString();
				}
			}
			Dato retvalDato = new Dato(Math.round(result), Dato.TYPE_INT);
			retval= retvalDato.toSingleArraylist();
		}
		return retval;
	}
	/**
	 * Método para visitar la definición de una expresión con signo, el cual analiza su
	 * hijo para obtener el valor entero
	 * @param ctx the parse tree
	 * @return Retorna el valor entero dentro de un Dato dentro de un arraylist
	 */
	@Override public List<Dato> visitExpresionConSigno(logoParser.ExpresionConSignoContext ctx) {
		List<Dato> retval;
		if(ctx.expresionConSigno()!=null){
			retval=visitExpresionConSigno(ctx.expresionConSigno());
		}else {
			List<Dato> datos = visitChildren(ctx);

			int signo = 1;
			for (int i = 0; i < datos.size() - 1; i++) {
				Dato signoDato = datos.get(i);
				String signoStr = signoDato.getDatoAsString();
				if (signoStr.equals("-")) {
					signo *= -1;
				}
			}

			int numero = datos.get(datos.size() - 1).getDatoAsInteger();
			Dato retvalDato = new Dato(numero * signo, Dato.TYPE_INT);
			retval=retvalDato.toSingleArraylist();
		}
		return retval;
	}

	/**
	 * Método para visitar la definición de una expresión numérica compleja, el cual analiza su
	 * hijo para obtener el valor entero
	 * @param ctx the parse tree
	 * @return Retorna el valor entero dentro de un Dato dentro de un arraylist
	 * @throws SemanticException Excepción en caso de que se el tipo recibido sea distinto al esperado
	 */
	@Override
	public List<Dato> visitExpresionNumericaCompleja(logoParser.ExpresionNumericaComplejaContext ctx) throws SemanticException {
		List<Dato> retlist;
		if(ctx.expresionNumericaCompleja()!=null) {
			retlist = visitExpresionNumericaCompleja(ctx.expresionNumericaCompleja());
		}else if(ctx.expresionIndeterminada()!=null){
			Dato indeterminado = visitExpresionIndeterminada(ctx.expresionIndeterminada()).get(0);
			retlist=new ArrayList<>();
			if (indeterminado.getTipo() == Dato.TYPE_INT) {
				retlist.add(indeterminado);
			}else{
				throw new UnexpectedTypeException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
						"Entero", indeterminado.getTypeAsString());
			}
		}else if(ctx.expresionNumerica()!=null){
			retlist=visitExpresionNumerica(ctx.expresionNumerica());
		}
		else{
			retlist=visitChildren(ctx);
		}
		return retlist;
	}

	/**
	 * Método para visitar un número, el cual analiza su
	 * hijo para obtener el valor entero a partir del String
	 * @param ctx the parse tree
	 * @return Retorna el valor entero dentro de un Dato dentro de un arraylist
	 */
	@Override public List<Dato> visitNumero(logoParser.NumeroContext ctx) {
		String numeroInt = ctx.NUMERO().getSymbol().getText();
		Dato numeroDato = new Dato(Integer.parseInt(numeroInt), Dato.TYPE_INT);
		return numeroDato.toSingleArraylist();
	}
	/**
	 * Método para visitar la definición de un comentario
	 * @param ctx the parse tree
	 * @return Retorna un arraylist vacío
	 */
	@Override public List<Dato> visitComment(logoParser.CommentContext ctx) { return new ArrayList<>(); }

	/**
	 * Método para visitar la definición de una lista de parámetros, obtiene los nombres de las variables
	 * @param ctx the parse tree
	 * @return Retorna un arraylist con el nombre de los parámetros
	 */
	@Override public List<Dato> visitListaParametros(logoParser.ListaParametrosContext ctx) {
		List<Dato> datos = new ArrayList<>();
		for(logoParser.VariableContext varCtx :ctx.variable()){
			datos.addAll(visitTerminal(varCtx.NOMBRE()));
		}
		return datos;
	}

	/**
	 * Método para visitar la definición de una lista, el cual obtiene los elementos que contiene
	 * @param ctx the parse tree
	 * @return Retorna un arraylist con los elementos de la lista
	 */
	@Override public List<Dato> visitLista(logoParser.ListaContext ctx) {
		List<Dato> datos = visitChildren(ctx);
		datos.remove(0);
		datos.remove(datos.size()-1);
		return datos;
	}

	/**
	 * Método para visitar la definición de una variable, el cual analiza su
	 * hijo para obtener el valor de la variable dentro de los mapas que las contienen
	 * @param ctx the parse tree
	 * @return Retorna un arraylist con el valor de la variable, si esta existe
	 * @throws SemanticException Excepción en caso de que la variable no pueda ser encontrada
	 */
	@Override public List<Dato> visitVariable(logoParser.VariableContext ctx) throws VariableNotFoundException {
		String key = ctx.NOMBRE().getSymbol().getText();
		Integer integerValue = integerMap.get(key);
		String stringValue=stringStringMap.get(key);
		Boolean boolValue=booleanMap.get(key);
		Dato dato = null;
		if(integerValue != null){
			dato= new Dato(integerValue,Dato.TYPE_INT);
		}else if(stringValue!=null){
			dato= new Dato(stringValue,Dato.TYPE_STRING);
		}else if(boolValue!=null){
			dato= new Dato(boolValue,Dato.TYPE_BOOL);
		}else{
			throw new VariableNotFoundException(ctx.NOMBRE().getSymbol().getLine(), ctx.NOMBRE().getSymbol().getCharPositionInLine(), key);
		}
		List<Dato> retval= new ArrayList<>();
		retval.add(dato);
		return retval;
	}

	/**
	 * Método para visitar la definición de un String, el cual analiza su
	 * hijo para obtener el valor del string
	 * @param ctx the parse tree
	 * @return Retorna un arraylist con un Dato que contiene el valor del String
	 * @throws SemanticException Excepción en caso de que se el tipo recibido sea distinto al esperado
	 */
	@Override public List<Dato> visitString(logoParser.StringContext ctx) throws SemanticException {
		if (ctx.expresionIndeterminada()!=null){
			Dato indeterminado = visitExpresionIndeterminada(ctx.expresionIndeterminada()).get(0);
			if (indeterminado.getTipo() == Dato.TYPE_STRING) {
				return indeterminado.toSingleArraylist();
			}else{
				throw new UnexpectedTypeException(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
						"Hilera", indeterminado.getTypeAsString());
			}
		}else{
			String string= visitTerminal(ctx.STRING()).get(0).getDatoAsString();
			string=string.substring(1,string.length()-1);
			return new Dato(string, Dato.TYPE_STRING).toSingleArraylist();
		}
	}


	/**
	 * Método para visitar un árbol o nodo del árbol
	 * @param parseTree Árbol a visitar
	 * @return Un arraylist con los resultados de visitar el árbol
	 */
	@Override
	public List<Dato> visit(ParseTree parseTree) {
		return parseTree.accept(this);
	}

	/**
	 * Método para visitar los hijos de un nodo
	 * @param ruleNode Nodo padre
	 * @return Un arraylist con los resultados de visitar a los hijos
	 */
	@Override
	public List<Dato> visitChildren(RuleNode ruleNode) {
		List<Dato> result = new ArrayList<>();

		int n = ruleNode.getChildCount();

		for(int i = 0; i < n; ++i) {
			ParseTree c = ruleNode.getChild(i);
			List<Dato> childDato = c.accept(this);
			result.addAll(childDato);
		}

		return result;
	}

	/**
	 * Nodo que retorna el valor de un terminal en texto
	 * @param terminalNode Nodoterminal
	 * @return El valor en string dentro de un dato dentro de un arraylist
	 */
	@Override
	public List<Dato> visitTerminal(TerminalNode terminalNode) {
		List<Dato> returnVal= new ArrayList<>();
		returnVal.add(new Dato(terminalNode.getSymbol().getText(),Dato.TYPE_STRING));
		return returnVal;
	}

	/**
	 * Método que determina el comportamiento en caso de error
	 * @param errorNode Nodo del error
	 * @return Arraylist vacio
	 */
	@Override
	public List<Dato> visitErrorNode(ErrorNode errorNode) {
		return new ArrayList<>();
	}


}