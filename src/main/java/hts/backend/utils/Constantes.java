package hts.backend.utils;

import java.util.HashMap;
import java.util.Map;

public class Constantes {

	//Iterfaces aletamientos
	public static final int INTERFAZ_LISTACEX = 1;
	public static final int INTERFAZ_2 = 1;
	public static final int INTERFAZ_3 = 1;
	public static final int INTERFAZ_4 = 1;
	public static final int INTERFAZ_5 = 1;
	public static final int INTERFAZ_6 = 1;
	public static final int INTERFAZ_7 = 1;
	public static final int INTERFAZ_8 = 1;
	public static final int INTERFAZ_9 = 1;
	public static final int INTERFAZ_10 = 1;
	public static final int INTERFAZ_11 = 1;
	public static final int INTERFAZ_12 = 1;
	public static final int INTERFAZ_13 = 1;
	public static final int INTERFAZ_14 = 1;
	public static final int INTERFAZ_15 = 1;
	public static final int INTERFAZ_16 = 1;
	public static final int INTERFAZ_17 = 1;

	//Constantes Generales
	public static final long CLAVE_STATUS_NSE_ASIGNADO = 2;
	public static final Integer CLAVE_STATUS_GENERAL_ASIGNADO = 1;
	public static final Integer CLAVE_STATUS_GENERAL_BORRADO = 0;


	public static final int IDSIGNOVITAL_PESO = 2;
	public static final int IDSIGNOVITAL_TALLA = 5;
	public static final int IDSIGNOVITAL_PD = 6;
	public static final int IDSIGNOVITAL_PS = 4;

	// Constantes de tipo de episodio
	public static final int EPISODIO_CEX = 2;
	public static final int EPISODIO_URG = 3;
	public static final int EPISODIO_HSP = 6;
	public static final int EPISODIO_CRT = 7;

	// Constantes de agentes
	public static final int TIPO_AGENTE_PROFESIONAL = 1;
	public static final int TIPO_AGENTE_PACIENTE = 2;
	public static final int TIPO_AGENTE_EQUIPO = 3;
	public static final int TIPO_AGENTE_ASEGURADORA = 4;
	public static final int TIPO_AGENTE_CONTACTO_PACIENTE = 5;

	// Constantes de foliadores
	public static final int FOLIADOR_EPISODIOS = 1;
	public static final int FOLIADOR_EVENTOS = 2;
	public static final int FOLIADOR_EXPEDIENTES = 4;
	public static final int FOLIADOR_CITAS = 5;
	public static final int FOLIADOR_RECETA = 8;
	public static final int FOLIADOR_PRESCRIPCIONES = 9;
	public static final int FOLIADOR_REFERENCIA_EXTERNA = 11;
	public static final int FOLIADOR_PETICIONES_CLINICAS = 12;
	public static final int FOLIADOR_INTERCONSULTAS = 13;
	public static final int FOLIADOR_NSE_ESTUDIO_SOCIOECONOMICO = 14;
	public static final int FOLIADOR_NSE_UNICA_OCASION = 15;
	public static final int FOLIADOR_NSE_ASIGNACION = 16;
	public static final int FOLIADOR_PACIENTE_DESC = 17;
	public static final int FOLIADOR_CITAS_EQUIPO = 18;

	// Constantes de Prescripciones
	public static final int PRESCRIPCION_MEDICAMENTOS = 1;
	public static final int PRESCRIPCION_DIETAS = 2;
	public static final int PRESCRIPCION_SIGNOS_VITALES = 3;
	public static final int PRESCRIPCION_OXIGENO = 4;
	public static final int PRESCRIPCION_SOLUCIONES = 5;
	public static final int PRESCRIPCION_CUIDADOS = 6;

	// Constantes para tipo de evento
	public static final int EVENTO_CEX = 2;
	public static final int EVENTO_URG = 3;
	public static final int EVENTO_HSP = 6;
	public static final int EVENTO_CRT = 7;

	// Constantes de estatus de cama
	public static final int CAMA_DISPONIBLE = 1;
	public static final int CAMA_OCUPADA = 2;
	public static final int CAMA_BLOQUEADA = 3;

	// Constantes de estatus de EAR
	public static final int EAR_DISPONIBLE = 1;
	public static final int EAR_OCUPADO = 2;
	public static final int EAR_BLOQUEADO = 3;

	// Constantes de bloqueos de cama
	public static final int CAMA_BQ_DESINFECCION = 1;
	public static final int CAMA_BQ_REPARACION = 2;
	public static final int CAMA_BQ_RESERVADA = 3;
	public static final int CAMA_BQ_LIMPIEZA = 4;

	// Constantes de bloqueos de EAR
	public static final int EAR_BQ_DESINFECCION = 1;
	public static final int EAR_BQ_REPARACION = 2;
	public static final int EAR_BQ_RESERVADO = 3;
	public static final int EAR_BQ_LIMPIEZA = 4;

	// Constantes de ubicaciÃ³n
	public static final int UBICACION_EXTERNA = 0;
	public static final int UBICACION_CONSULTORIO = 1;
	public static final int UBICACION_CAMA = 2;
	public static final int UBICACION_EQUIPO = 3;
	public static final int UBICACION_EAR_URG = 4;
	public static final int UBICACION_EAR_BQR = 5;
	public static final int UBICACION_NO_DISPONIBLE = 6;

	// Constantes para centro de reportes
	public static final int CENTRO_REPORTES_TODOS = 2;
	public static final int CENTRO_REPORTES_VIGENTES = 1;
	public static final int CENTRO_REPORTES_ANULADOS = 0;

	// Constantes para tipos de cargo
	public static final int CARGO_PRESTACION = 1;
	public static final int CARGO_COASEGURO = 2;
	public static final int GASTOS_MEDICOS = 3;
	public static final int CARGO_DETALLE_PAQUETE = 4;
	public static final int CARGO_NO_FACTURABLE = 5;

	// Constantes para estatus de cirugÃ­a
	public static final int BQR_CIRUGIA_SOLICITADA = 1;
	public static final int BQR_CIRUGIA_PROGRAMADA = 2;
	public static final int BQR_CIRUGIA_ANULADA = 3;
	public static final int BQR_CIRUGIA_EN_CURSO = 4;
	public static final int BQR_CIRUGIA_ATENDIDA = 5;
	public static final int BQR_CIRUGIA_CERRADA = 6;
	public static final int BQR_CIRUGIA_FINALIZADA = 7;

	// Constantes para estatus de solicitud de pacientes para cirugÃ­a
	public static final int BQR_CX_PACIENTE_PENDIENTE = 1;
	public static final int BQR_CX_PACIENTE_SOLICITADO = 2;
	public static final int BQR_CX_PACIENTE_EN_QUIROFANO = 3;
	public static final int BQR_CX_PACIENTE_SALIDA = 4;
	public static final int BQR_CX_PACIENTE_ANULADO = 5;

	// Contantes para mÃ³dulos del sistema
	public static final int GUS_MODULO_SASA = 0;
	public static final int GUS_MODULO_CORE = 1;
	public static final int GUS_MODULO_CEX = 2;
	public static final int GUS_MODULO_HSP = 3;
	public static final int GUS_MODULO_URG = 4;
	public static final int GUS_MODULO_BQR = 5;

	//Contantes para estatus Preingreso
	public static final int HSP_ESTATUS_PREINGRESO_REGISTRADO = 1;
	public static final int HSP_ESTATUS_PREINGRESO_PREINGRESADO = 2;
	public static final int HSP_ESTATUS_PREINGRESO_INGRESADO = 3;
	public static final int HSP_ESTATUS_PREINGRESO_ALTA_MEDICA = 4;
	public static final int HSP_ESTATUS_PREINGRESO_ALTA_ADMINISTRATIVA = 5;
	public static final int HSP_ESTATUS_PREINGRESO_ANULACION = 6;
	public static final int HSP_ESTATUS_PREINGRESO_CONSULTA = 7;

	// Contante de estatus de consutorio.
	public static final Map<String, Integer> ESTATUS_CONSULTORIO_OCUPADO = new HashMap<String, Integer>() {{
		put("DISPONIBLE", 0);
		put("NDISPONIBLE", 1);
	}};

	// Constantes de estatus de ingreso de urgencia.
	public static final Map<String, Integer> ESTATUS_INGRESO_URGENCIA = new HashMap<String, Integer>() {{
		put("INGRESADO", 3);
		put("AMEDICA", 4);
		put("AADMINISTRATIVA", 5);
		put("ANULADA", 6);
		put("CONSULTA", 7);
	}};

	// Constantes del tipo de agente ubicaciÃ³n
	public static final Map<String, Integer> TIPO_AGENTE_UBICACION = new HashMap<String, Integer>() {{
		put("EXTERNA", 0);
		put("CONSULTORIO", 1);
		put("CAMA", 2);
		put("EQUIPO", 3);
	}};


	public static final Map<String, Integer> CLAVE_STATUS_PCE = new HashMap<String, Integer>() {{
		put("ACTIVO", 1);
		put("INTERRUMPIDO", 2);
	}};

	public static final Map<String, Integer> CLAVE_STATUS_URG_INGRESO = new HashMap<String, Integer>() {{
		put("INGRESADO", 3);
		put("ALTA MEDICA", 4);
		put("ALTA ADMINISTRATIVA", 5);
		put("ANULADA", 6);
	}};
}
