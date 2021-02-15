// Generated from C:/Users/alfab/Desktop/Practica Para el Examen 2/Logo/src\logo.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link logoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface logoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link logoParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(logoParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#codigo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodigo(logoParser.CodigoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(logoParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(logoParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#llamar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamar(logoParser.LlamarContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#procedimiento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedimiento(logoParser.ProcedimientoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#haz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHaz(logoParser.HazContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#inic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInic(logoParser.InicContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken(logoParser.TokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#inc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInc(logoParser.IncContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#avanza}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvanza(logoParser.AvanzaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#retrocede}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetrocede(logoParser.RetrocedeContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#girarderecha}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGirarderecha(logoParser.GirarderechaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#girarizquierda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGirarizquierda(logoParser.GirarizquierdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#ocultartortuga}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOcultartortuga(logoParser.OcultartortugaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#aparecertortuga}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAparecertortuga(logoParser.AparecertortugaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#ponpos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPonpos(logoParser.PonposContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#ponrumbo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPonrumbo(logoParser.PonrumboContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#rumbo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRumbo(logoParser.RumboContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#ponx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPonx(logoParser.PonxContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#pony}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPony(logoParser.PonyContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#imprimir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImprimir(logoParser.ImprimirContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#goma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoma(logoParser.GomaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#bajalapiz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBajalapiz(logoParser.BajalapizContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#subelapiz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubelapiz(logoParser.SubelapizContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#poncolor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoncolor(logoParser.PoncolorContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#centro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCentro(logoParser.CentroContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#espera}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEspera(logoParser.EsperaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#ejecuta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEjecuta(logoParser.EjecutaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#repite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepite(logoParser.RepiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#si}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSi(logoParser.SiContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#sisino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSisino(logoParser.SisinoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#hasHasta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHasHasta(logoParser.HasHastaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#hasta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHasta(logoParser.HastaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#hazMientras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHazMientras(logoParser.HazMientrasContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#mientras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMientras(logoParser.MientrasContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#booleanos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanos(logoParser.BooleanosContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#iguales}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIguales(logoParser.IgualesContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#yLogico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYLogico(logoParser.YLogicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#oLogico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOLogico(logoParser.OLogicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#tokenLogico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenLogico(logoParser.TokenLogicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#expresionLogica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionLogica(logoParser.ExpresionLogicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#expresionLogicaSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionLogicaSimple(logoParser.ExpresionLogicaSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#operadorCondicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperadorCondicional(logoParser.OperadorCondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#mayorque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMayorque(logoParser.MayorqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#menorque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorque(logoParser.MenorqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#operacionAritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperacionAritmetica(logoParser.OperacionAritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#redondea}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedondea(logoParser.RedondeaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#azar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAzar(logoParser.AzarContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#menos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenos(logoParser.MenosContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#producto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProducto(logoParser.ProductoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#potencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPotencia(logoParser.PotenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#division}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(logoParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#resto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResto(logoParser.RestoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#diferencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiferencia(logoParser.DiferenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#suma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuma(logoParser.SumaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#expresionIndeterminada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionIndeterminada(logoParser.ExpresionIndeterminadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#elegir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElegir(logoParser.ElegirContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#cuenta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuenta(logoParser.CuentaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#ultimo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUltimo(logoParser.UltimoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#elemento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemento(logoParser.ElementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#primero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimero(logoParser.PrimeroContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#borrarPantalla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBorrarPantalla(logoParser.BorrarPantallaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#tokenNumerico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenNumerico(logoParser.TokenNumericoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#expresionNumerica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionNumerica(logoParser.ExpresionNumericaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#expresionMultiplicativa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionMultiplicativa(logoParser.ExpresionMultiplicativaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#expresionConSigno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionConSigno(logoParser.ExpresionConSignoContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#expresionNumericaCompleja}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionNumericaCompleja(logoParser.ExpresionNumericaComplejaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#numero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero(logoParser.NumeroContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(logoParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#listaParametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaParametros(logoParser.ListaParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#lista}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista(logoParser.ListaContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(logoParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link logoParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(logoParser.StringContext ctx);
}