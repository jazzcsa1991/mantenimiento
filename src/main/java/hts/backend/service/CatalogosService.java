package hts.backend.service;


import hts.backend.model.dto.OpcionCatalogoComunDTO;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.ServicioEspecialidadDTO;
import hts.backend.model.dto.*;

public interface CatalogosService {


	public RespuestaGenerica obtenerCatalogoIdioma();

	/**
	 * Metodo para obtener las opciones con estatus de activadas(1) del catalogo de TIPO PACIENTE
	 * @return
	 */


	/**
	 * Metodo para obtener las opciones con estatus de activadas(1) del catalogo de IMPEDIMENTOS FISICOS
	 * @return
	 */
	public RespuestaGenerica obtenerCatalogoImpedimentos();

	public RespuestaGenerica obtenerServicios();
	public RespuestaGenerica obtenerEspecialidad(ServicioEspecialidadDTO servicio);

	public RespuestaGenerica obtenerCatalogoPais();
	public RespuestaGenerica obtenerCatalogoEstadoPais();
	public RespuestaGenerica listaMotivoBloqueo();
	public RespuestaGenerica obtenerMotivoAnulacionCirugia();



	/**********************************************************************************************
	 ************************ CATALOGOS RELACIONADOS CON DIRECCION ********************************
	 **********************************************************************************************/

	public RespuestaGenerica listaPaises() ;
	public RespuestaGenerica listaEntidadesByPaisID(NomCatPaisesDTO dto) ;
	public RespuestaGenerica listaMunicipiosByCveEntidad(NomCatEntidadesDTO dto) ;
	public RespuestaGenerica listaLocalidadesByCveEntMun(NomCatMunicipioDTO dto) ;
	public RespuestaGenerica listaCodPostalByCveEntMun(NomCatMunicipioDTO dto) ;
	public RespuestaGenerica listaNacionalidades() ;
	public RespuestaGenerica listaTipoAsentamiento() ;
	public RespuestaGenerica listaVialidad() ;


	/**********************************************************************************************
	 ************************ CATALOGOS RELACIONADOS CON PACIENTE ********************************
	 **********************************************************************************************/


	public RespuestaGenerica listaSexo() ;
	public RespuestaGenerica listaTipoSangre() ;
	public RespuestaGenerica listaReligion() ;
	public RespuestaGenerica listaEstadoCivil(NomCatEstadoCivilDTO dto) ;
	public RespuestaGenerica listaOcupacion() ;
	public RespuestaGenerica listaNivelEscolaridad() ;
	public RespuestaGenerica listaTipoLenguaIndigena(NomCatTipoLenguaIndigenaDTO dto);
	public RespuestaGenerica listaProcedencia();
	public RespuestaGenerica listaSiNo(NomCatSinoDTO dto);

	public RespuestaGenerica listaTipoExpediente() ;

	public RespuestaGenerica listaPrestacion3();
	public RespuestaGenerica obtenerPrestacion3Id(Integer tipoPrestacion3Id);

	public RespuestaGenerica listaTipoMoneda();
	public RespuestaGenerica obtenCatMetodoPago();
	public RespuestaGenerica obtenCatBanco();
	public RespuestaGenerica listaTipoAseguradora();
	public RespuestaGenerica listaCFiscal();

	public RespuestaGenerica listaCatEpisodios();

	RespuestaGenerica obtenerAlergiasActivas(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerImpedimentosActivos(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerContraIndActivas(OpcionCatalogoComunDTO dto);

	RespuestaGenerica obtenerCatFormaFarmaceutica(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatMedicamentoPresentaciones(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatGrupoTerapeutico(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatViaAdministracion(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatUnidadMedidaDosis(OpcionCatalogoComunDTO dto);

	RespuestaGenerica obtenerCatSituacionEconomica(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatDondeSeAtiende(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatTipoEvento(OpcionCatalogoComunDTO dto);

	RespuestaGenerica obtenerCatDestinoPrestamoExp (OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatUbicacionExpediente(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatEstatusPeticion(OpcionCatalogoComunDTO dto);

	RespuestaGenerica obtenerCatTipoPrescripciones(OpcionCatalogoComunDTO dto);

	RespuestaGenerica obtenerCatTipoUnidadReferencia(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatTipoTrasladoReferencia(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatMotivoEnvioReferencia(OpcionCatalogoComunDTO dto);

	RespuestaGenerica obtenerCatMotivoAnulacionNse(OpcionCatalogoComunDTO dto);
	RespuestaGenerica obtenerCatMotivoDescuento(OpcionCatalogoComunDTO dto);

	RespuestaGenerica obtenerCatTipoArchivo(OpcionCatalogoComunDTO dto);

//	RespuestaGenerica obtenerCatAnestesia(OpcionCatalogoComunDTO dto);
//	RespuestaGenerica obtenerCatBeneficiosAnestesia(OpcionCatalogoComunDTO dto);

	RespuestaGenerica obtenerGusModulos();

	RespuestaGenerica obtenerOpcionesCatalogoGenerico(OpcionCatalogoComunDTO dto);

	RespuestaGenerica listarCatPreIngresoPrioridad(OpcionCatalogoComunDTO dto);
	RespuestaGenerica listarCatMotivoIngreso(OpcionCatalogoComunDTO dto);
	RespuestaGenerica listarCatTipoIngresoHosp(OpcionCatalogoComunDTO dto);
	RespuestaGenerica listarCatHspProcedencia(OpcionCatalogoComunDTO dto);


	RespuestaGenerica listarEstadoProc();
	RespuestaGenerica listarOpcionesProNac();
	RespuestaGenerica listarHepatitisB();
	RespuestaGenerica listarVitaminaK();
	RespuestaGenerica listarVitaminaA();
	RespuestaGenerica listarTamizAuditivo();
	RespuestaGenerica listarVacunaBcg();

	RespuestaGenerica listarNomCatAtencionPrenatal();
	RespuestaGenerica listarNomCatViveMadre();
	RespuestaGenerica listarCircunDefun();

	RespuestaGenerica listarTipoVisita(OpcionCatalogoComunDTO dto);

}
