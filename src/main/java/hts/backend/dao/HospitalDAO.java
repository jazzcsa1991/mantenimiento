package hts.backend.dao;
import hts.backend.dao.impl.BaseDAO;
import hts.backend.entity.AdmHospital;

import java.util.List;
import hts.backend.model.dto.OpcionCatalogoComunDTO;
import hts.backend.model.dto.CatalogosDTO;
import hts.backend.model.dto.HospitalCluesDTO;
import hts.backend.model.dto.HospitalDTO;
import hts.backend.entity.CatEstadoJurisdiccion;
import hts.backend.entity.CatJurisdiccion;
import hts.backend.entity.CatTipoEstablecimiento;
import hts.backend.entity.CatTipoServ;
import hts.backend.entity.CatVialidad;


public interface HospitalDAO extends BaseDAO {
	

	String QRY_CATALOGO_TIPO_ASEN = "SELECT \tTIPO_ASEN_ID as id, \tDESCRIPCION as descripcion, \tVALOR_DEFAULT as indicadefault FROM cat_tipo_asen WHERE ESTATUS = 1";
	String QRY_CATALOGO_HOSPITAL_CONTINUO = "SELECT \tSER_HOSPITAL_CONTINUO_ID as id, \tDESCRIPCION as descripcion, \tVALOR_DEFAULT as indicadefault FROM cat_ser_hospital_continuo WHERE ESTATUS = 1";
	String QRY_CATALOGO_HOSPITAL_PARCIAL = "SELECT \tSER_HOSPITAL_PARCIAL_ID as id, \tDESCRIPCION as descripcion, \tVALOR_DEFAULT as indicadefault FROM cat_ser_hospital_parcial WHERE ESTATUS = 1";
	String QRY_CATALOGO_TIPO_SERVICIOS = "SELECT \tTIPO_SERV_ID as id, \tDESCRIPCION as descripcion, \tVALOR_DEFAULT as indicadefault FROM cat_tipo_serv WHERE ESTATUS = 1";
	String QRY_CATALOGO_TIPO_UNIDAD_PSIQ = "SELECT \tTIPO_UNIDAD_PSIQ_ID as id, \tDESCRIPCION as descripcion, \tVALOR_DEFAULT as indicadefault FROM cat_tipo_unidad_psiq WHERE ESTATUS = 1";
	String QRY_CATALOGO_VIALIDAD = "SELECT \tVIALIDAD_ID as id, \tDESCRIPCION as descripcion, \tVALOR_DEFAULT as indicadefault FROM cat_vialidad WHERE ESTATUS = 1";
	String QRY_CATALOGO_PAIS = "SELECT \tPAIS_ID as id, \tDESCRIPCION as descripcion, \tVALOR_DEFAULT as indicadefault FROM nom_cat_paises WHERE ESTATUS = 1";
	String QRY_CATALOGO_CODIGOPOSTAL = " SELECT CAT_CODIGO_POSTAL_ID as idCatPostal, DESCRIPCION as name,  VALOR_DEFAULT as indicaDefault  FROM nom_cat_codigo_postal COD  WHERE COD.C_MUNICIPIO =( :p_idMunicipio )  AND COD.C_ESTADO =( :p_idEstado )  AND COD.ESTATUS = 1  ORDER BY CAT_CODIGO_POSTAL_ID ";
	String QRY_CATALOGO_COLONIA = " SELECT COL.IDCOLONIA as id,  COL.DESCRIPCION as name, COL.INDICADEFAULT as indicaDefault  FROM nom_cat_colonia COL  WHERE COL.ESTATUS = 1  AND COL.IDCODIGO = (:p_idCodigo) AND COL.IDMUNICIPIO = ( :p_idMunicipio )  AND COL.IDESTADO = ( :p_idEstado ) ";
	String QRY_CATALOGO_ESTADOPAIS = "SELECT EST.CAT_ENTIDADES_ID as idCatPostal, EST.DESCRIPCION as name, EST.VALOR_DEFAULT as indicaDefault FROM nom_cat_entidades EST, nom_cat_paises PA WHERE EST.estatus = 1  AND PA.PAIS_ID = :p_idPais  AND PA.VALOR_DEFAULT = 1  ORDER BY PA.DESCRIPCION";
	String QRY_CATALOGO_JURISDICCION = "SELECT \tJURISDICCION_ID as id, \tDESCRIPCION as name, \tJUR as jur FROM nom_cat_jurisdiccion WHERE ESTATUS = 1 AND (EDO) = :p_idEstado";
	String QRY_CATALOGO_HOSPITAL = "SELECT \tHOSPITAL_ID as hospitalId, \tCLAVE_OID as cve, \tNOMBRE as nombre, \tCLUE_ID as clueId, \tCVE_INST_SALUD as cveInstSalud, \tCVE_CTA_INST_SALUD as cveCtaInstSalud, \tCALLE as calle, \tNO_EXT as noExt, \tNO_INT as noInt, \tESTADO_CVE as estadoCve, \tMUNICIPIO_CVE as municipioCve, \tCOLONIA_CVE as coloniaCve, \tLOCALIDAD_CVE as localidadCve, \tCP_CVE as cpCve, \tTELEFONO as telefono, \tCORREO as correo, \tFECHA_REGISTRO as fechaRegistro, \tUSUARIO_REGISTRO as usuarioCve, \tESTATUS AS estatus, \tCP_CVE as cpcve, \tCLAVE_DEPENDENCIA as tiposervicio, \tID_JURISDICCION as clavedependencia, \tID_TIPO_UNIDAD_MEDICA as idtipoUnidadMedica, \tID_TIPO_VIALIDAD as tipovialidad, \tNOMBRE_VIALIDAD as nombrevialidad, \tTIPO_ASEN as tipoasen, \tCLAVE_OID as claveiod, \tLICENCIA_SANITARIA as licenciasanitaria, \tNOMBRE_ASENTAMIENTO as nombreAsentamiento, \tPAIS as pais, \tID_TIPO_UNIDAD_MEDICA as tipounidad, \tSER_HOSP_CONTINUO_ID as serhospcontinuo, \tSER_HOSP_PARCIAL_ID as serhospparcial, \tID_ESTADO_JURISDICCION as estadoJurisdiccion FROM adm_hospital WHERE ESTATUS = 1";
	String QRY_CATALOGO_TIPO_ESTABLECIMIENTO = "SELECT \tTIPO_ESTABLECIMIENTO_ID as id, \tNOMBRE as name, \tVALOR_DEFAULT as indicadefault FROM cat_tipo_establecimiento WHERE ESTATUS = 1 ";
	String QRY_CATALOGO_ESTADO_JURISDICCION = "SELECT \tESTADO_JURISDICCION_ID as id, \tDESCRIPCION as name, \tVALOR_DEFAULT as indicadefault FROM nom_cat_estado_jurisdiccion WHERE ESTATUS = 1";
	String QRY_CATALOGO_CLUES = "SELECT \tNOMBRE_UNIDAD as nombreUnidad, \tNOMBRE_INSTITUCION_SALUD as nombreInstitucionSalud, \tCVE_CTA_INSTITUCION_SALUD as cveCtaInstitucionSalud, \tID_CLUES as idClues, \tCLUES as clues, \tCVE_INSTITUCION_SALUD as cveInstitucionSalud, \tNUMERO_INTERIOR as numeroInterior, \tNUMERO_EXTERIOR as numeroExterior, \tCVE_ENTIDAD as cveEntidad, \tCVE_MUNICIPIO as cveMunicipio, \tCOLONIA as colonia, \tCVE_LOCALIDAD as cveLocalidad, \tCODIGO_POSTAL as codigoPostal, \tLADA as lada, \tTELEFONO as telefono, \tCORREO_ELECTRONICO as correoElectronico, \tCVE_JURISDICCION as cveJurisdiccion, \tNOMBRE_JURISDICCION as nombreJurisdiccion, \tDOMICILIO as domicilio, \tNOMBRE_TIPO_ESTABLECIMIENTO as nombreTipoEstablecimiento FROM nom_cat_clues WHERE NOMBRE_UNIDAD LIKE '%p_nombreHospital%'";
	String QRY_ID_PERFIL = "SELECT \tPERFIL_ID as idOpcion FROM nom_cat_perfil";
	String QRY_CLAVES = "SELECT COUNT(CVE) FROM ( SELECT us.CVE FROM adm_unidad_servicio us LEFT JOIN adm_piso ps ON us.PISO_ID = ps.PISO_ID LEFT JOIN adm_edificio ed ON ps.EDIFICIO_ID = ed.EDIFICIO_ID LEFT JOIN adm_hospital hs ON ed.HOSPITAL_ID = hs.HOSPITAL_ID WHERE us.CVE IS NOT NULL AND hs.HOSPITAL_ID = :pHospitalId AND us.ESTATUS != 0 UNION ALL SELECT um.CVE FROM adm_unidad_medica um LEFT JOIN adm_unidad_servicio us ON um.UNIDAD_SERVICIO_ID = us.UNIDAD_SERVICIO_ID LEFT JOIN adm_piso ps ON us.PISO_ID = ps.PISO_ID LEFT JOIN adm_edificio ed ON ps.EDIFICIO_ID = ed.EDIFICIO_ID LEFT JOIN adm_hospital hs ON ed.HOSPITAL_ID = hs.HOSPITAL_ID WHERE um.CVE IS NOT NULL AND hs.HOSPITAL_ID = :pHospitalId AND um.ESTATUS != 0 UNION ALL SELECT ue.CVE FROM adm_unidad_enfermeria ue LEFT JOIN adm_unidad_medica um ON ue.UNIDAD_MEDICA_ID = um.UNIDAD_MEDICA_ID LEFT JOIN adm_unidad_servicio us ON um.UNIDAD_SERVICIO_ID = us.UNIDAD_SERVICIO_ID LEFT JOIN adm_piso ps ON us.PISO_ID = ps.PISO_ID LEFT JOIN adm_edificio ed ON ps.EDIFICIO_ID = ed.EDIFICIO_ID LEFT JOIN adm_hospital hs ON ed.HOSPITAL_ID = hs.HOSPITAL_ID WHERE ue.CVE IS NOT NULL AND hs.HOSPITAL_ID = :pHospitalId AND ue.ESTATUS != 0 UNION ALL SELECT ut.CVE FROM adm_unidad_tratamiento ut LEFT JOIN adm_unidad_medica um ON ut.UNIDAD_MEDICA_ID = um.UNIDAD_MEDICA_ID LEFT JOIN adm_unidad_servicio us ON um.UNIDAD_SERVICIO_ID = us.UNIDAD_SERVICIO_ID LEFT JOIN adm_piso ps ON us.PISO_ID = ps.PISO_ID LEFT JOIN adm_edificio ed ON ps.EDIFICIO_ID = ed.EDIFICIO_ID LEFT JOIN adm_hospital hs ON ed.HOSPITAL_ID = hs.HOSPITAL_ID WHERE ut.CVE IS NOT NULL AND hs.HOSPITAL_ID = :pHospitalId AND ut.ESTATUS != 0 UNION ALL SELECT h.NUMERO FROM adm_habitacion h LEFT JOIN adm_unidad_enfermeria ue ON h.UNIDAD_ENFERMERIA_ID = ue.UNIDAD_ENFERMERIA_ID LEFT JOIN adm_unidad_medica um ON ue.UNIDAD_MEDICA_ID = um.UNIDAD_MEDICA_ID LEFT JOIN adm_unidad_servicio us ON um.UNIDAD_SERVICIO_ID = us.UNIDAD_SERVICIO_ID LEFT JOIN adm_piso ps ON us.PISO_ID = ps.PISO_ID LEFT JOIN adm_edificio ed ON ps.EDIFICIO_ID = ed.EDIFICIO_ID LEFT JOIN adm_hospital hs ON ed.HOSPITAL_ID = hs.HOSPITAL_ID WHERE h.NUMERO IS NOT NULL AND hs.HOSPITAL_ID = :pHospitalId AND h.ESTATUS != 0 UNION ALL SELECT c.NUMERO FROM adm_cama c LEFT JOIN adm_habitacion h ON c.HABITACION_ID = h.HABITACION_ID LEFT JOIN adm_unidad_enfermeria ue ON h.UNIDAD_ENFERMERIA_ID = ue.UNIDAD_ENFERMERIA_ID LEFT JOIN adm_unidad_medica um ON ue.UNIDAD_MEDICA_ID = um.UNIDAD_MEDICA_ID LEFT JOIN adm_unidad_servicio us ON um.UNIDAD_SERVICIO_ID = us.UNIDAD_SERVICIO_ID LEFT JOIN adm_piso ps ON us.PISO_ID = ps.PISO_ID LEFT JOIN adm_edificio ed ON ps.EDIFICIO_ID = ed.EDIFICIO_ID LEFT JOIN adm_hospital hs ON ed.HOSPITAL_ID = hs.HOSPITAL_ID WHERE c.NUMERO IS NOT NULL AND hs.HOSPITAL_ID = :pHospitalId AND c.ESTATUS != 0 UNION ALL SELECT s.CVE FROM adm_sala s LEFT JOIN adm_unidad_tratamiento ut ON s.UNIDAD_TRATAMIENTO_ID = ut.UNIDAD_TRATAMIENTO_ID LEFT JOIN adm_unidad_medica um on ut.UNIDAD_MEDICA_ID = um.UNIDAD_MEDICA_ID LEFT JOIN adm_unidad_servicio us ON um.UNIDAD_SERVICIO_ID = us.UNIDAD_SERVICIO_ID LEFT JOIN adm_piso ps ON us.PISO_ID = ps.PISO_ID LEFT JOIN adm_edificio ed ON ps.EDIFICIO_ID = ed.EDIFICIO_ID LEFT JOIN adm_hospital hs ON ed.HOSPITAL_ID = hs.HOSPITAL_ID WHERE s.CVE IS NOT NULL AND hs.HOSPITAL_ID = :pHospitalId AND s.ESTATUS != 0 UNION ALL SELECT cons.CVE FROM adm_consultorio cons LEFT JOIN adm_sala s ON cons.SALA_ID = s.SALA_ID LEFT JOIN adm_unidad_tratamiento ut ON s.UNIDAD_TRATAMIENTO_ID = ut.UNIDAD_TRATAMIENTO_ID LEFT JOIN adm_unidad_medica um on ut.UNIDAD_MEDICA_ID = um.UNIDAD_MEDICA_ID LEFT JOIN adm_unidad_servicio us ON um.UNIDAD_SERVICIO_ID = us.UNIDAD_SERVICIO_ID LEFT JOIN adm_piso ps ON us.PISO_ID = ps.PISO_ID LEFT JOIN adm_edificio ed ON ps.EDIFICIO_ID = ed.EDIFICIO_ID LEFT JOIN adm_hospital hs ON ed.HOSPITAL_ID = hs.HOSPITAL_ID WHERE cons.CVE IS NOT NULL AND hs.HOSPITAL_ID = :pHospitalId AND cons.ESTATUS != 0 UNION ALL SELECT urg.NUMERO FROM adm_ear_urg urg LEFT JOIN adm_sala s ON urg.SALA_ID = s.SALA_ID LEFT JOIN adm_unidad_tratamiento ut ON s.UNIDAD_TRATAMIENTO_ID = ut.UNIDAD_TRATAMIENTO_ID LEFT JOIN adm_unidad_medica um on ut.UNIDAD_MEDICA_ID = um.UNIDAD_MEDICA_ID LEFT JOIN adm_unidad_servicio us ON um.UNIDAD_SERVICIO_ID = us.UNIDAD_SERVICIO_ID LEFT JOIN adm_piso ps ON us.PISO_ID = ps.PISO_ID LEFT JOIN adm_edificio ed ON ps.EDIFICIO_ID = ed.EDIFICIO_ID LEFT JOIN adm_hospital hs ON ed.HOSPITAL_ID = hs.HOSPITAL_ID WHERE urg.NUMERO IS NOT NULL AND hs.HOSPITAL_ID = :pHospitalId AND urg.ESTATUS != 0 UNION ALL SELECT bqr.NUMERO FROM adm_ear_bqr bqr LEFT JOIN adm_sala s ON bqr.SALA_ID = s.SALA_ID LEFT JOIN adm_unidad_tratamiento ut ON s.UNIDAD_TRATAMIENTO_ID = ut.UNIDAD_TRATAMIENTO_ID LEFT JOIN adm_unidad_medica um on ut.UNIDAD_MEDICA_ID = um.UNIDAD_MEDICA_ID LEFT JOIN adm_unidad_servicio us ON um.UNIDAD_SERVICIO_ID = us.UNIDAD_SERVICIO_ID LEFT JOIN adm_piso ps ON us.PISO_ID = ps.PISO_ID LEFT JOIN adm_edificio ed ON ps.EDIFICIO_ID = ed.EDIFICIO_ID LEFT JOIN adm_hospital hs ON ed.HOSPITAL_ID = hs.HOSPITAL_ID WHERE bqr.NUMERO IS NOT NULL AND hs.HOSPITAL_ID = :pHospitalId AND bqr.ESTATUS != 0 ) as CONSULTA WHERE CVE = :pCve";

	boolean obtenerClaves(Integer var1, String var2);

	List<OpcionCatalogoComunDTO> obtenerCatPerfil();

	List<CatalogosDTO> obtenerCatTipoAsen();

	List<CatalogosDTO> obtenerCatHospitalContinuo();

	List<CatalogosDTO> obtenerCatHospitalParcial();

	List<CatalogosDTO> obtenerCatTipoServ();

	List<CatalogosDTO> obtenerCatTipoUnidadPsiq();

	List<CatalogosDTO> obtenerCatVialidad();

	List<CatalogosDTO> obtenerCatPais();

	List<CatalogosDTO> obtenerCatEstadosJurisdiccion();

	List<HospitalCluesDTO> buscaHospital(HospitalCluesDTO var1);

	int guardarHospital(HospitalDTO var1);

	List<HospitalDTO> obtenerCataHospitalActivos();

	List<HospitalDTO> obtenerCataHospital();

	List<HospitalDTO> obtenerCatHospitalRiss(HospitalDTO var1);

	List<HospitalDTO> obtenerCatHospitalRisses(HospitalDTO var1);

	int editaCatHospital(HospitalDTO var1);

	int estatusHospital(HospitalDTO var1, Integer var2);

	List<CatalogosDTO> obtenerCatJurisdiccion(HospitalDTO var1);

	List<CatalogosDTO> obtenerCatMunicipio(HospitalDTO var1);

	List<CatalogosDTO> obtenerCatLocalidad(HospitalDTO var1);

	List<CatalogosDTO> obtenerCatCodigoPostal(HospitalDTO var1);

	List<CatalogosDTO> obtenerCatColonia(HospitalDTO var1);

	List<CatalogosDTO> obtenerCatEstadosXPais(HospitalDTO var1);

	List<CatalogosDTO> obtenerCatTipoEstablecimiento();

	AdmHospital obtenerEntidadHospital(int var1);

	CatTipoEstablecimiento obtenerCatTipoEstablecimientoPorID(int var1);

	CatEstadoJurisdiccion CatEstadoJurisdiccionPorID(int var1);

	CatTipoServ obtenerCatTipoServPorID(int var1);

	CatVialidad obtenerCatVialidadPorID(int var1);

	CatJurisdiccion obtenerCatJurisdiccionPorID(int var1);

	AdmHospital obtenerHospitalId(Integer var1);

	AdmHospital obtenerIdHospital(Integer var1);

	boolean existeExpediente(int var1, int var2);

}
