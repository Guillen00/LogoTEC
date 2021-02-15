// Generated from C:/Users/alfab/Desktop/Practica Para el Examen 2/Logo/src\logo.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link logoParser}.
 */
public interface logoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link logoParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(logoParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(logoParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#codigo}.
	 * @param ctx the parse tree
	 */
	void enterCodigo(logoParser.CodigoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#codigo}.
	 * @param ctx the parse tree
	 */
	void exitCodigo(logoParser.CodigoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(logoParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(logoParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(logoParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(logoParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#llamar}.
	 * @param ctx the parse tree
	 */
	void enterLlamar(logoParser.LlamarContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#llamar}.
	 * @param ctx the parse tree
	 */
	void exitLlamar(logoParser.LlamarContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#procedimiento}.
	 * @param ctx the parse tree
	 */
	void enterProcedimiento(logoParser.ProcedimientoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#procedimiento}.
	 * @param ctx the parse tree
	 */
	void exitProcedimiento(logoParser.ProcedimientoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#haz}.
	 * @param ctx the parse tree
	 */
	void enterHaz(logoParser.HazContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#haz}.
	 * @param ctx the parse tree
	 */
	void exitHaz(logoParser.HazContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#inic}.
	 * @param ctx the parse tree
	 */
	void enterInic(logoParser.InicContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#inic}.
	 * @param ctx the parse tree
	 */
	void exitInic(logoParser.InicContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(logoParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(logoParser.TokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#inc}.
	 * @param ctx the parse tree
	 */
	void enterInc(logoParser.IncContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#inc}.
	 * @param ctx the parse tree
	 */
	void exitInc(logoParser.IncContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#avanza}.
	 * @param ctx the parse tree
	 */
	void enterAvanza(logoParser.AvanzaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#avanza}.
	 * @param ctx the parse tree
	 */
	void exitAvanza(logoParser.AvanzaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#retrocede}.
	 * @param ctx the parse tree
	 */
	void enterRetrocede(logoParser.RetrocedeContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#retrocede}.
	 * @param ctx the parse tree
	 */
	void exitRetrocede(logoParser.RetrocedeContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#girarderecha}.
	 * @param ctx the parse tree
	 */
	void enterGirarderecha(logoParser.GirarderechaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#girarderecha}.
	 * @param ctx the parse tree
	 */
	void exitGirarderecha(logoParser.GirarderechaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#girarizquierda}.
	 * @param ctx the parse tree
	 */
	void enterGirarizquierda(logoParser.GirarizquierdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#girarizquierda}.
	 * @param ctx the parse tree
	 */
	void exitGirarizquierda(logoParser.GirarizquierdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#ocultartortuga}.
	 * @param ctx the parse tree
	 */
	void enterOcultartortuga(logoParser.OcultartortugaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#ocultartortuga}.
	 * @param ctx the parse tree
	 */
	void exitOcultartortuga(logoParser.OcultartortugaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#aparecertortuga}.
	 * @param ctx the parse tree
	 */
	void enterAparecertortuga(logoParser.AparecertortugaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#aparecertortuga}.
	 * @param ctx the parse tree
	 */
	void exitAparecertortuga(logoParser.AparecertortugaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#ponpos}.
	 * @param ctx the parse tree
	 */
	void enterPonpos(logoParser.PonposContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#ponpos}.
	 * @param ctx the parse tree
	 */
	void exitPonpos(logoParser.PonposContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#ponrumbo}.
	 * @param ctx the parse tree
	 */
	void enterPonrumbo(logoParser.PonrumboContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#ponrumbo}.
	 * @param ctx the parse tree
	 */
	void exitPonrumbo(logoParser.PonrumboContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#rumbo}.
	 * @param ctx the parse tree
	 */
	void enterRumbo(logoParser.RumboContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#rumbo}.
	 * @param ctx the parse tree
	 */
	void exitRumbo(logoParser.RumboContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#ponx}.
	 * @param ctx the parse tree
	 */
	void enterPonx(logoParser.PonxContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#ponx}.
	 * @param ctx the parse tree
	 */
	void exitPonx(logoParser.PonxContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#pony}.
	 * @param ctx the parse tree
	 */
	void enterPony(logoParser.PonyContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#pony}.
	 * @param ctx the parse tree
	 */
	void exitPony(logoParser.PonyContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#imprimir}.
	 * @param ctx the parse tree
	 */
	void enterImprimir(logoParser.ImprimirContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#imprimir}.
	 * @param ctx the parse tree
	 */
	void exitImprimir(logoParser.ImprimirContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#goma}.
	 * @param ctx the parse tree
	 */
	void enterGoma(logoParser.GomaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#goma}.
	 * @param ctx the parse tree
	 */
	void exitGoma(logoParser.GomaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#bajalapiz}.
	 * @param ctx the parse tree
	 */
	void enterBajalapiz(logoParser.BajalapizContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#bajalapiz}.
	 * @param ctx the parse tree
	 */
	void exitBajalapiz(logoParser.BajalapizContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#subelapiz}.
	 * @param ctx the parse tree
	 */
	void enterSubelapiz(logoParser.SubelapizContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#subelapiz}.
	 * @param ctx the parse tree
	 */
	void exitSubelapiz(logoParser.SubelapizContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#poncolor}.
	 * @param ctx the parse tree
	 */
	void enterPoncolor(logoParser.PoncolorContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#poncolor}.
	 * @param ctx the parse tree
	 */
	void exitPoncolor(logoParser.PoncolorContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#centro}.
	 * @param ctx the parse tree
	 */
	void enterCentro(logoParser.CentroContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#centro}.
	 * @param ctx the parse tree
	 */
	void exitCentro(logoParser.CentroContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#espera}.
	 * @param ctx the parse tree
	 */
	void enterEspera(logoParser.EsperaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#espera}.
	 * @param ctx the parse tree
	 */
	void exitEspera(logoParser.EsperaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#ejecuta}.
	 * @param ctx the parse tree
	 */
	void enterEjecuta(logoParser.EjecutaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#ejecuta}.
	 * @param ctx the parse tree
	 */
	void exitEjecuta(logoParser.EjecutaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#repite}.
	 * @param ctx the parse tree
	 */
	void enterRepite(logoParser.RepiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#repite}.
	 * @param ctx the parse tree
	 */
	void exitRepite(logoParser.RepiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#si}.
	 * @param ctx the parse tree
	 */
	void enterSi(logoParser.SiContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#si}.
	 * @param ctx the parse tree
	 */
	void exitSi(logoParser.SiContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#sisino}.
	 * @param ctx the parse tree
	 */
	void enterSisino(logoParser.SisinoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#sisino}.
	 * @param ctx the parse tree
	 */
	void exitSisino(logoParser.SisinoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#hasHasta}.
	 * @param ctx the parse tree
	 */
	void enterHasHasta(logoParser.HasHastaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#hasHasta}.
	 * @param ctx the parse tree
	 */
	void exitHasHasta(logoParser.HasHastaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#hasta}.
	 * @param ctx the parse tree
	 */
	void enterHasta(logoParser.HastaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#hasta}.
	 * @param ctx the parse tree
	 */
	void exitHasta(logoParser.HastaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#hazMientras}.
	 * @param ctx the parse tree
	 */
	void enterHazMientras(logoParser.HazMientrasContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#hazMientras}.
	 * @param ctx the parse tree
	 */
	void exitHazMientras(logoParser.HazMientrasContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#mientras}.
	 * @param ctx the parse tree
	 */
	void enterMientras(logoParser.MientrasContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#mientras}.
	 * @param ctx the parse tree
	 */
	void exitMientras(logoParser.MientrasContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#booleanos}.
	 * @param ctx the parse tree
	 */
	void enterBooleanos(logoParser.BooleanosContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#booleanos}.
	 * @param ctx the parse tree
	 */
	void exitBooleanos(logoParser.BooleanosContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#iguales}.
	 * @param ctx the parse tree
	 */
	void enterIguales(logoParser.IgualesContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#iguales}.
	 * @param ctx the parse tree
	 */
	void exitIguales(logoParser.IgualesContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#yLogico}.
	 * @param ctx the parse tree
	 */
	void enterYLogico(logoParser.YLogicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#yLogico}.
	 * @param ctx the parse tree
	 */
	void exitYLogico(logoParser.YLogicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#oLogico}.
	 * @param ctx the parse tree
	 */
	void enterOLogico(logoParser.OLogicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#oLogico}.
	 * @param ctx the parse tree
	 */
	void exitOLogico(logoParser.OLogicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#tokenLogico}.
	 * @param ctx the parse tree
	 */
	void enterTokenLogico(logoParser.TokenLogicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#tokenLogico}.
	 * @param ctx the parse tree
	 */
	void exitTokenLogico(logoParser.TokenLogicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#expresionLogica}.
	 * @param ctx the parse tree
	 */
	void enterExpresionLogica(logoParser.ExpresionLogicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#expresionLogica}.
	 * @param ctx the parse tree
	 */
	void exitExpresionLogica(logoParser.ExpresionLogicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#expresionLogicaSimple}.
	 * @param ctx the parse tree
	 */
	void enterExpresionLogicaSimple(logoParser.ExpresionLogicaSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#expresionLogicaSimple}.
	 * @param ctx the parse tree
	 */
	void exitExpresionLogicaSimple(logoParser.ExpresionLogicaSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#operadorCondicional}.
	 * @param ctx the parse tree
	 */
	void enterOperadorCondicional(logoParser.OperadorCondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#operadorCondicional}.
	 * @param ctx the parse tree
	 */
	void exitOperadorCondicional(logoParser.OperadorCondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#mayorque}.
	 * @param ctx the parse tree
	 */
	void enterMayorque(logoParser.MayorqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#mayorque}.
	 * @param ctx the parse tree
	 */
	void exitMayorque(logoParser.MayorqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#menorque}.
	 * @param ctx the parse tree
	 */
	void enterMenorque(logoParser.MenorqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#menorque}.
	 * @param ctx the parse tree
	 */
	void exitMenorque(logoParser.MenorqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#operacionAritmetica}.
	 * @param ctx the parse tree
	 */
	void enterOperacionAritmetica(logoParser.OperacionAritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#operacionAritmetica}.
	 * @param ctx the parse tree
	 */
	void exitOperacionAritmetica(logoParser.OperacionAritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#redondea}.
	 * @param ctx the parse tree
	 */
	void enterRedondea(logoParser.RedondeaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#redondea}.
	 * @param ctx the parse tree
	 */
	void exitRedondea(logoParser.RedondeaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#azar}.
	 * @param ctx the parse tree
	 */
	void enterAzar(logoParser.AzarContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#azar}.
	 * @param ctx the parse tree
	 */
	void exitAzar(logoParser.AzarContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#menos}.
	 * @param ctx the parse tree
	 */
	void enterMenos(logoParser.MenosContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#menos}.
	 * @param ctx the parse tree
	 */
	void exitMenos(logoParser.MenosContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#producto}.
	 * @param ctx the parse tree
	 */
	void enterProducto(logoParser.ProductoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#producto}.
	 * @param ctx the parse tree
	 */
	void exitProducto(logoParser.ProductoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#potencia}.
	 * @param ctx the parse tree
	 */
	void enterPotencia(logoParser.PotenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#potencia}.
	 * @param ctx the parse tree
	 */
	void exitPotencia(logoParser.PotenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#division}.
	 * @param ctx the parse tree
	 */
	void enterDivision(logoParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#division}.
	 * @param ctx the parse tree
	 */
	void exitDivision(logoParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#resto}.
	 * @param ctx the parse tree
	 */
	void enterResto(logoParser.RestoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#resto}.
	 * @param ctx the parse tree
	 */
	void exitResto(logoParser.RestoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#diferencia}.
	 * @param ctx the parse tree
	 */
	void enterDiferencia(logoParser.DiferenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#diferencia}.
	 * @param ctx the parse tree
	 */
	void exitDiferencia(logoParser.DiferenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#suma}.
	 * @param ctx the parse tree
	 */
	void enterSuma(logoParser.SumaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#suma}.
	 * @param ctx the parse tree
	 */
	void exitSuma(logoParser.SumaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#expresionIndeterminada}.
	 * @param ctx the parse tree
	 */
	void enterExpresionIndeterminada(logoParser.ExpresionIndeterminadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#expresionIndeterminada}.
	 * @param ctx the parse tree
	 */
	void exitExpresionIndeterminada(logoParser.ExpresionIndeterminadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#elegir}.
	 * @param ctx the parse tree
	 */
	void enterElegir(logoParser.ElegirContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#elegir}.
	 * @param ctx the parse tree
	 */
	void exitElegir(logoParser.ElegirContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#cuenta}.
	 * @param ctx the parse tree
	 */
	void enterCuenta(logoParser.CuentaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#cuenta}.
	 * @param ctx the parse tree
	 */
	void exitCuenta(logoParser.CuentaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#ultimo}.
	 * @param ctx the parse tree
	 */
	void enterUltimo(logoParser.UltimoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#ultimo}.
	 * @param ctx the parse tree
	 */
	void exitUltimo(logoParser.UltimoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#elemento}.
	 * @param ctx the parse tree
	 */
	void enterElemento(logoParser.ElementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#elemento}.
	 * @param ctx the parse tree
	 */
	void exitElemento(logoParser.ElementoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#primero}.
	 * @param ctx the parse tree
	 */
	void enterPrimero(logoParser.PrimeroContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#primero}.
	 * @param ctx the parse tree
	 */
	void exitPrimero(logoParser.PrimeroContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#borrarPantalla}.
	 * @param ctx the parse tree
	 */
	void enterBorrarPantalla(logoParser.BorrarPantallaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#borrarPantalla}.
	 * @param ctx the parse tree
	 */
	void exitBorrarPantalla(logoParser.BorrarPantallaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#tokenNumerico}.
	 * @param ctx the parse tree
	 */
	void enterTokenNumerico(logoParser.TokenNumericoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#tokenNumerico}.
	 * @param ctx the parse tree
	 */
	void exitTokenNumerico(logoParser.TokenNumericoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#expresionNumerica}.
	 * @param ctx the parse tree
	 */
	void enterExpresionNumerica(logoParser.ExpresionNumericaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#expresionNumerica}.
	 * @param ctx the parse tree
	 */
	void exitExpresionNumerica(logoParser.ExpresionNumericaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#expresionMultiplicativa}.
	 * @param ctx the parse tree
	 */
	void enterExpresionMultiplicativa(logoParser.ExpresionMultiplicativaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#expresionMultiplicativa}.
	 * @param ctx the parse tree
	 */
	void exitExpresionMultiplicativa(logoParser.ExpresionMultiplicativaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#expresionConSigno}.
	 * @param ctx the parse tree
	 */
	void enterExpresionConSigno(logoParser.ExpresionConSignoContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#expresionConSigno}.
	 * @param ctx the parse tree
	 */
	void exitExpresionConSigno(logoParser.ExpresionConSignoContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#expresionNumericaCompleja}.
	 * @param ctx the parse tree
	 */
	void enterExpresionNumericaCompleja(logoParser.ExpresionNumericaComplejaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#expresionNumericaCompleja}.
	 * @param ctx the parse tree
	 */
	void exitExpresionNumericaCompleja(logoParser.ExpresionNumericaComplejaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#numero}.
	 * @param ctx the parse tree
	 */
	void enterNumero(logoParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#numero}.
	 * @param ctx the parse tree
	 */
	void exitNumero(logoParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(logoParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(logoParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#listaParametros}.
	 * @param ctx the parse tree
	 */
	void enterListaParametros(logoParser.ListaParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#listaParametros}.
	 * @param ctx the parse tree
	 */
	void exitListaParametros(logoParser.ListaParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#lista}.
	 * @param ctx the parse tree
	 */
	void enterLista(logoParser.ListaContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#lista}.
	 * @param ctx the parse tree
	 */
	void exitLista(logoParser.ListaContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(logoParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(logoParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link logoParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(logoParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link logoParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(logoParser.StringContext ctx);
}