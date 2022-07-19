package hts.backend.model;

public abstract class Globales {

	// Mensajes genéricos para respuesta de servicios
	public static final String msjOK = "OK";
	public static final String msjErr = "Error";
	public static final String err_ParametrosInsuficientes = "Parámetros insuficientes";
	public static final String err_RecursoInexistente = "El recurso solicitado no existe";

	// Constantes para configuración de seguridad
	public static final Long seg_MilisegundosExpiracionSesion = ( 1000L * 60L * 60L * 2 ) ; // 2 Horas
	public static final String seg_Header = "Authorization";

}
