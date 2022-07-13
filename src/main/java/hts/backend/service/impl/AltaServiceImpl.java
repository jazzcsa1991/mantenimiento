package hts.backend.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hts.backend.dao.AccesoRolesDAO;
import hts.backend.dao.CoreDefuncionDAO;
import hts.backend.dao.HospitalDAO;
import hts.backend.dao.PacAseguradoraDAO;
import hts.backend.dao.PacienteDAO;
import hts.backend.entity.AgenteCorreo;
import hts.backend.entity.AgenteTelefono;
import hts.backend.entity.CatServEspecialidad;
import hts.backend.entity.CatTipoExpediente;
import hts.backend.entity.CatTipoTelefono;
import hts.backend.entity.Correo;
import hts.backend.entity.NomCatMunicipio;
import hts.backend.entity.PacBiometricosPaciente;
import hts.backend.entity.PacBiometricosRepresentanteLegal;
import hts.backend.entity.PacExpediente;
import hts.backend.entity.PacPaciente;
import hts.backend.entity.PacRepresentanteLegal;
import hts.backend.entity.Telefono;
import hts.backend.model.EstatusResponse;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.BiometricosDTO;
import hts.backend.model.dto.CatalogosDTO;
import hts.backend.model.dto.PacPacienteDTO;
import hts.backend.model.dto.PacienteCortoDTO;
import hts.backend.model.dto.PacienteDesconocidoDTO;
import hts.backend.model.dto.PacienteLargoDTO;
import hts.backend.model.dto.PacientePreRegistroDTO;
import hts.backend.service.AltaService;
import hts.backend.service.FoliadorService;
import hts.backend.service.MedioContactoService;
import hts.backend.utils.Constantes;
import hts.backend.utils.SecurityUtil;
import hts.backend.entity.AdmHospital;

/**
 * 
 * @author rafaelnagano
 *
 */
@Service("pacienteService")
@Transactional
public class AltaServiceImpl implements AltaService {

	@Resource
	private PacienteDAO pacienteDAO;

	@Resource
	private AccesoRolesDAO accesoRolesDAO;

	@Resource
	private HospitalDAO hospitalDAO;

	@Resource
	private PacAseguradoraDAO pacAsegradoraDAO;

	@Resource
	private FoliadorService foliadorService;

	@Resource
	private CoreDefuncionDAO coreDefuncionDAO;

	@Resource
	private MedioContactoService medioContactoService;

	private final static String REG_DESCONOCIDO = "Desconocido";
	private final static String REG_CORTO = "Corto";
	private final static String REG_COMPLETO = "Completo";
	private int OK = EstatusResponse.OK.getEstatus();
	private int ERR = EstatusResponse.ERROR.getEstatus();
	private String msjOK = "Servicio ejecutado correctamente";

	private static final Logger logger = LoggerFactory.getLogger(AltaServiceImpl.class);

	@Override
	public RespuestaGenerica registrarPaciente(PacienteLargoDTO dto) throws RuntimeException {
		if (!accesoRolesDAO.validarFS(289)) // registrar Paciente- FS 289
			throw new RuntimeException("No cuenta con permisos para realizar la accion solicitada.");

		Integer idRol = Integer
				.valueOf(new SecurityUtil().getRole(SecurityContextHolder.getContext().getAuthentication().getName()));
	        AdmHospital hospital = hospitalDAO.obtenerIdHospital(idRol);
	        NomCatMunicipio municipio = new NomCatMunicipio();
	        if (dto.getNacionalidad_id().equals(73)) {
	        	logger.info("=======RECUPERANDO MUNICIPIO======: "+dto.getEntidadNacimiento_cve()+"-"+dto.getMunicipioNacimiento_cve());
	            municipio = pacienteDAO.obtenerMunicipioByEdo(dto.getEntidadNacimiento_cve(), dto.getMunicipioNacimiento_cve());
	        }
	        List<CatalogosDTO> lstNacionalidad = pacienteDAO.getNacionalidadByDefault();

		PacPaciente paciente = new PacPaciente(dto.getNombre(), dto.getPrimerApellido(), dto.getSegundoApellido(),
				dto.getFechaNacimiento(), 0, dto.getCurp(), dto.getDesconoceCurp(), null, null, 0, // fallecido
				dto.getOcupacion_id(), dto.getEstadoCivil_id(), dto.getEscolaridad_id(), dto.getNacionalidad_id(), 2,
				dto.getProcedencia_id(), dto.getSexo_id(), null, null, dto.getReligion_id(), dto.getIndigena_id(),
				dto.getHablaIndigena_id(), dto.getHablaEspanol_id(), dto.getTrabajaActualmente_id(),
				dto.getTipoLenguaIndigena_id(), pacienteDAO.getTipoRegistrobyDesc(REG_COMPLETO),
				dto.getMunicipioNacimiento_id(), dto.getMigrante(), dto.getFactorRH(), dto.getFechaIdTipoSangre());

		paciente.setEntidadCve("" + dto.getEntidadNacimiento_id());
		paciente.setMunicipioCve("" + dto.getMunicipioNacimiento_id());

		paciente.setNomCatEntidades(null);

		paciente.setProcedenciaId(1);
		paciente.setFotoPaciente(dto.getFotoPaciente());
		paciente.setPacFechaActualizacion(new Date());

		if (pacienteDAO.guardarEntidad(paciente) != 1) {
			throw new RuntimeException("Ocurrio un error <P0> al registrar el paciente");
		}

		logger.info("=======ID PACIENTE======: " + paciente.getIdPaciente());
		
		String folioExp = foliadorService.obtenSecuencia(Constantes.FOLIADOR_EXPEDIENTES, hospital.getHospitalId());
        if (folioExp == null) {
            throw new RuntimeException("Error al generar la secuencia");
        }

        CatTipoExpediente tipoExpediente = pacienteDAO.obtenerTipoExpedienteDefault();

        if (tipoExpediente == null) {
            throw new RuntimeException("Error al registrar Paciente. El hospital no cuenta con un tipo de expediente predeterminado");
        }

        //if (dto.getServicioEspRegistro_id() == null) {
        //    throw new RuntimeException("Error al registrar paciente. El usuario no tiene un servicio especialidad asociado");
        //}

        PacExpediente expediente = PacExpediente.NuevoExpediente(
                paciente.getIdPaciente(),
                folioExp,
                tipoExpediente,
                pacienteDAO.get(CatServEspecialidad.class, 79), //79=ADMISION
                pacienteDAO.obterCatUbicacionExpediente(1),
                pacienteDAO.obtenerCatEstatusExpediente(1),
                hospital.getHospitalId()
        );


        if (pacienteDAO.guardarEntidad(expediente) != 1) {
            return new RespuestaGenerica(ERR, "Ocurrio un error <P2> al registrar el paciente");
        }

        Map<String, Object> informacion = new HashMap<>();
		informacion.put("idPaciente", paciente.getIdPaciente());
		informacion.put("expediente", expediente.getNoExpediente()); 

		return new RespuestaGenerica(OK, "Paciente registrado", informacion);
	}

	@Override
	public RespuestaGenerica actualizarPaciente(PacienteLargoDTO dto) throws RuntimeException {

		if (!accesoRolesDAO.validarFS(290)) // actualizar Paciente- FS 290
			throw new RuntimeException("No cuenta con permisos para realizar la acciÃ³n solicitada.");

		PacPaciente paciente = pacienteDAO.get(PacPaciente.class, dto.getIdPaciente());

		if (paciente == null) {
			throw new RuntimeException("Paciente no encontrado");
		}

		logger.info(" " + dto.toString());
		logger.info("=======ACTUALIZACION PACIENTE======: " + paciente.getIdPaciente());

		// Campos requeridos
		if (dto.getNombre() != null)
			paciente.setNombre(dto.getNombre());

		if (dto.getPrimerApellido() != null)
			paciente.setPrimerApellido(dto.getPrimerApellido());

		if (dto.getSexo_id() != null)
			paciente.setSexoId(dto.getSexo_id());

		if (dto.getFechaNacimiento() != null)
			paciente.setFechaNacimiento(dto.getFechaNacimiento());

		if (dto.getNacionalidad_id() != null)
			paciente.setNacionalidadId(dto.getNacionalidad_id());

		if (dto.getProcedencia_id() != null)
			paciente.setProcedenciaId(dto.getProcedencia_id());

		// Campos no requeridos
		paciente.setSegundoApellido(dto.getSegundoApellido());
		paciente.setCurp(dto.getCurp());
		paciente.setOcupacionId(dto.getOcupacion_id());
		paciente.setEstadoCivilId(dto.getEstadoCivil_id());
		paciente.setEscolaridadId(dto.getEscolaridad_id());

		paciente.setReligionId(dto.getReligion_id());
		paciente.setIndigenaId(dto.getIndigena_id());
		paciente.setHablaIndigenaId(dto.getHablaIndigena_id());
		paciente.setHablaEspanolId(dto.getHablaEspanol_id());
		paciente.setTrabajaActualmenteId(dto.getTrabajaActualmente_id());
		paciente.setTipoLenguaIndigenaId(dto.getTipoLenguaIndigena_id());
		paciente.setMigrante(dto.getMigrante());
		paciente.setDesconoceCurp(dto.getDesconoceCurp());

		paciente.setPacFechaActualizacion(new Date());
		paciente.setNacionalidadId(dto.getNacionalidad_id());

		paciente.setProcedenciaId(1);
		paciente.setFotoPaciente(dto.getFotoPaciente());

		paciente.setEntidadCve("" + dto.getEntidadNacimiento_id());
		paciente.setMunicipioCve("" + dto.getMunicipioNacimiento_id());

		int result = pacienteDAO.actualizarEntidad(paciente);
		if (result != 1) {
			throw new RuntimeException("Paciente no actualizado");
		}
		logger.info("=======ID PACIENTE ACTUALIZADO======: " + paciente.getIdPaciente());

		Map<String, Object> informacion = new HashMap<>();
		informacion.put("idPaciente", paciente.getIdPaciente());

		return new RespuestaGenerica(OK, "Paciente actualizado", informacion);
	}

	@Override
	public RespuestaGenerica pacienteByCurp(PacPacienteDTO dto) {
		PacPacienteDTO pac = pacienteDAO.pacienteByCurp(dto);

		Map<String, Object> informacion = new HashMap<>();
		informacion.put("paciente", pac);
		if (pac == null) {
			return new RespuestaGenerica(OK, "Paciente con CURP " + dto.getCurp() + " no encontrado", informacion);
		}
		return new RespuestaGenerica(OK, msjOK, informacion);
	}

	@Override
	public RespuestaGenerica registrarPacienteCorto(PacienteCortoDTO dto) {

		if (dto.getCurp() == null) {
			throw new RuntimeException("formato de Curp Incorrecto");
		}
		PacPaciente pacPaciente1 = new PacPaciente();

		pacPaciente1.setNombre(dto.getNombre());
		pacPaciente1.setPrimerApellido(dto.getPrimerApellido());
		pacPaciente1.setSegundoApellido(dto.getSegundoApellido());
		pacPaciente1.setFechaNacimiento(dto.getFechaNacimiento());
		pacPaciente1.setCurp(dto.getCurp());
		pacPaciente1.setUsuarioRegistra(SecurityContextHolder.getContext().getAuthentication().getName());
		pacPaciente1.setSexoId(dto.getSexo_id());
		pacienteDAO.getTipoRegistrobyDesc(REG_CORTO);

		pacPaciente1.setFechaRegistro(new Date());
		pacPaciente1.setIdPacientePadre(null);
		pacPaciente1.setEstatus(1);
		pacPaciente1.setDesconocido(0);
		pacPaciente1.setTipoRegistroId(2);
		pacPaciente1.setFallecido(0);
		pacPaciente1.setNacionalidadId(73);
		pacPaciente1.setProcedenciaId(2);
		pacPaciente1.setDesconoceCurp(0);

		if (pacienteDAO.guardarEntidad(pacPaciente1) != 1) {
			throw new RuntimeException("Ocurrió un error <P0> al registrar el paciente");
		}

		Map<String, Object> informacion = new HashMap<>();
		informacion.put("idPaciente", pacPaciente1.getIdPaciente());

		return new RespuestaGenerica(OK, "Paciente corto registrado", informacion);
	}

	@Override
	public RespuestaGenerica registrarPacienteDesconocido(PacienteDesconocidoDTO dto) {
		CatalogosDTO nacionalidad = null;
		CatalogosDTO procedencia = null;
		CatalogosDTO sexo = null;
		CatalogosDTO entidad = null;

		List<CatalogosDTO> lstNacionalidad = pacienteDAO.getNacionalidadByDefault();
		List<CatalogosDTO> lstProcedencia = pacienteDAO.getProcedenciaByDefault();
		List<CatalogosDTO> lstSexo = pacienteDAO.getSexoByDefault();
		List<CatalogosDTO> lstEntidad = pacienteDAO.getEntidadByDefault();

		if (lstNacionalidad != null && !lstNacionalidad.isEmpty()) {
			nacionalidad = lstNacionalidad.get(0);
		}

		if (lstProcedencia != null && !lstProcedencia.isEmpty()) {
			procedencia = lstProcedencia.get(0);
		} else {
			throw new RuntimeException(
					"No se encontró un valor predeterminado para el catálogo Lugares de procedencia de pacientes");
		}

		if (lstSexo != null && !lstSexo.isEmpty()) {
			sexo = lstSexo.get(0);
		}

		if (lstEntidad != null && !lstEntidad.isEmpty()) {
			entidad = lstEntidad.get(0);
		}

		// Constructor para registro desconocido
		Integer idRol = Integer
				.valueOf(new SecurityUtil().getRole(SecurityContextHolder.getContext().getAuthentication().getName()));
		AdmHospital hospital = hospitalDAO.obtenerIdHospital(idRol);

		logger.info(" HOSPITAL ID: :::: " + hospital.getHospitalId());
		logger.info(" CONSTANTE: :::: " + Constantes.FOLIADOR_PACIENTE_DESC);

		String folioDesc = foliadorService.obtenSecuencia(Constantes.FOLIADOR_PACIENTE_DESC, hospital.getHospitalId());
		logger.info(" FOLIO DESC: :::: " + folioDesc);

		if (folioDesc == null) {
			throw new RuntimeException("Error al generar la secuencia 1");
		}

		PacPaciente paciente = new PacPaciente();

		paciente.setNombre(dto.getNombre());
		paciente.setPrimerApellido(dto.getPrimerApellido());
		paciente.setSegundoApellido(dto.getSegundoApellido());
		paciente.setPeso(dto.getPeso());
		paciente.setTalla(dto.getTalla());
		paciente.setSexoId(dto.getSexo_id());
		paciente.setFechaNacimiento(dto.getFechaNacimiento());

		pacienteDAO.getTipoRegistrobyDesc(REG_DESCONOCIDO);
		paciente.setDesconoceCurp(0);
		paciente.setUsuarioRegistra(SecurityContextHolder.getContext().getAuthentication().getName());
		paciente.setFechaRegistro(new Date());
		paciente.setIdPacientePadre(null);
		paciente.setEstatus(1);
		paciente.setDesconocido(0);
		paciente.setFallecido(0);
		paciente.setTipoRegistroId(3);

		// Requeridos en base de datos
		paciente.setNacionalidadId(73);
		paciente.setProcedenciaId(1);

		if (pacienteDAO.guardarEntidad(paciente) != 1) {
			throw new RuntimeException("Ocurrió un error <P0> al registrar el paciente");
		}

		Map<String, Object> informacion = new HashMap<>();
		informacion.put("idPaciente", paciente.getIdPaciente());

		return new RespuestaGenerica(OK, "Paciente desconocido registrado", informacion);

	}

	@Override
	public RespuestaGenerica preRegistrarPaciente(PacientePreRegistroDTO dto) {
		if (!accesoRolesDAO.validarFS(289)) // registrar Paciente- FS 289
			throw new RuntimeException("No cuenta con permisos para realizar la acción solicitada.");

		Integer idRol = Integer
				.valueOf(new SecurityUtil().getRole(SecurityContextHolder.getContext().getAuthentication().getName()));
		AdmHospital hospital = hospitalDAO.obtenerIdHospital(idRol);
		NomCatMunicipio municipio = new NomCatMunicipio();
		if (dto.getNacionalidad_id().equals(73)) {
			municipio = pacienteDAO.obtenerMunicipioByEdo(dto.getEntidadNacimiento_cve(),
					dto.getMunicipioNacimiento_cve());
		}

		PacPaciente paciente = new PacPaciente();
		paciente.setNombre(dto.getNombre());
		paciente.setPrimerApellido(dto.getPrimerApellido());
		paciente.setSegundoApellido(dto.getSegundoApellido());
		paciente.setCurp(dto.getCurp());
		paciente.setFechaNacimiento(dto.getFechaNacimiento());
		paciente.setNacionalidadId(dto.getNacionalidad_id());
		paciente.setSexoId(dto.getSexo_id());

		// Campos requeridos en BD.......................
		paciente.setDesconoceCurp(0);
		paciente.setUsuarioRegistra(SecurityContextHolder.getContext().getAuthentication().getName());
		paciente.setFechaRegistro(new Date());
		paciente.setIdPacientePadre(null);
		paciente.setEstatus(1);
		paciente.setDesconocido(0);
		paciente.setFallecido(0);
		paciente.setTipoRegistroId(1); // 4 -> PreRegistro
		// ..............................................

		paciente.setNomCatMunicipio(municipio);
		paciente.setNacionalidadId(dto.getNacionalidad_id());
		paciente.setProcedenciaId(1);

        paciente.setFotoPaciente(dto.getFotoPaciente());

		paciente.setPacFechaActualizacion(new Date());
		if (pacienteDAO.guardarEntidad(paciente) != 1) {
			return new RespuestaGenerica(ERR, "Ocurrió un error <P0> al registrar el paciente");
		}

		// Falta: CODIGO POSTAL*******
		paciente.setCodigoPostal(dto.getCodigo_postal());

		// Telefono
		CatTipoTelefono tipoTel = new CatTipoTelefono();
		tipoTel.setTipoTelefonoId(1); // Por default 1:CASA

		Telefono telefono = new Telefono();
		telefono.setTelefono(dto.getTelefono());
		telefono.setFechaRegistro(new Date());
		telefono.setStatus(1);
		telefono.setTipoTelefonoId(3);
		telefono.setUsuarioCve("Pre-Reg");

		if (pacienteDAO.guardarEntidad(telefono) == 1) {
			// Vincular el teléfono registrado con el paciente a través del agente
			AgenteTelefono ag = AgenteTelefono.TelefonoPaciente(telefono, paciente.getIdPaciente());

			if (pacienteDAO.guardarEntidad(ag) != 1) {
				return new RespuestaGenerica(ERR, "Ocurrió un error <T1> al registrar el teléfono");
			}
		} else {
			return new RespuestaGenerica(ERR, "Ocurrió un error <T0> al registrar el teléfono");
		}

		// Correo
		Correo correo = new Correo(dto.getCorreo());
		correo.setStatus(1);
		if (pacienteDAO.guardarEntidad(correo) == 1) {
			// Vincular el correo registrado con el paciente a través del agente
			AgenteCorreo ag = AgenteCorreo.CorreoPaciente(correo.getCorreoId(), paciente.getIdPaciente());

			if (pacienteDAO.guardarEntidad(ag) != 1) {
				return new RespuestaGenerica(ERR, "Ocurrió un error <C1> al registrar el correo");
			}
		} else {
			return new RespuestaGenerica(ERR, "Ocurrió un error <C0> al registrar el correo");
		}

		// Representante Legal
		if (dto.getRepresentanteLegal() != null) {
			PacRepresentanteLegal pacRepresentante = new PacRepresentanteLegal();
			pacRepresentante.setNombre(dto.getRepresentanteLegal().getNombre());
			pacRepresentante.setPrimerApellido(dto.getRepresentanteLegal().getPrimerApellido());
			pacRepresentante.setSegundoApellido(dto.getRepresentanteLegal().getSegundoApellido());
			pacRepresentante.setCurp(dto.getRepresentanteLegal().getCurp());
			pacRepresentante.setFechaNacimiento(dto.getRepresentanteLegal().getFechaNacimiento());
			pacRepresentante.setSexoId(dto.getRepresentanteLegal().getSexoId());
			pacRepresentante.setNacionalidadId(dto.getRepresentanteLegal().getNacionalidadId());
			pacRepresentante.setParentescoId(dto.getRepresentanteLegal().getParentescoId());
			pacRepresentante.setEntidadNacId(dto.getRepresentanteLegal().getEntidadId());
			pacRepresentante.setFotoPaciente(dto.getRepresentanteLegal().getFotoRepresentante());

			if (dto.getRepresentanteLegal().getNacionalidadId().equals(73)) {
				municipio = pacienteDAO.obtenerMunicipioByEdo(dto.getRepresentanteLegal().getEntidadNacimientoCve(),
						dto.getRepresentanteLegal().getMunicipioNacimientoCve());
			}

			pacRepresentante.setCodigoPostal(dto.getRepresentanteLegal().getCodigoPostal());

			// Telefono
			telefono = new Telefono();
			telefono.setTelefono(dto.getTelefono());
			telefono.setFechaRegistro(new Date());
			telefono.setCatTipoTelefono(tipoTel);
			telefono.setStatus(1);
			telefono.setTipoTelefonoId(3);
			telefono.setUsuarioCve("Pre-Reg");

			if (pacienteDAO.guardarEntidad(telefono) != 1) {
				return new RespuestaGenerica(ERR, "Ocurrió un error <T0> al registrar el teléfono de representante");
			}
			// Vincular el teléfono registrado con el paciente a través del agente
			pacRepresentante.setTelefonoId(telefono.getTelefonoId());

			// Correo
			correo = new Correo(dto.getCorreo());
			if (pacienteDAO.guardarEntidad(correo) != 1) {
				return new RespuestaGenerica(ERR, "Ocurrió un error <C0> al registrar el correo de representante");
			}
			// Vincular el correo registrado con el paciente a través del agente
			pacRepresentante.setCorreoId(correo.getCorreoId());

			// Guardar representante legal
			if (pacienteDAO.guardarEntidad(pacRepresentante) != 1) {
				return new RespuestaGenerica(ERR,
						"Ocurrió un error <P0> al registrar representante legal del paciente");
			}

			// Biometricos Representante Legal
			PacBiometricosRepresentanteLegal biometricoRepresentante = null;
			if (dto.getRepresentanteLegal().getBiometricos() != null)
				for (BiometricosDTO biometrico : dto.getRepresentanteLegal().getBiometricos()) {
					biometricoRepresentante = new PacBiometricosRepresentanteLegal(biometrico.getTokenBiometrico(),
							pacRepresentante.getIdRepresentante());
					logger.info(" BIOMETRICO REP: :::: " + biometricoRepresentante);
					if (pacienteDAO.guardarEntidad(biometricoRepresentante) != 1)
						return new RespuestaGenerica(ERR,
								"Ocurrió un error <B0> al registrar biometricos del representante");

				}

		}

		// Biometricos Paciente
		PacBiometricosPaciente pacBiometrico = null;
		if (dto.getBiometricos() != null)
			for (BiometricosDTO biometrico : dto.getBiometricos()) {
				pacBiometrico = new PacBiometricosPaciente(biometrico.getTokenBiometrico(), paciente.getIdPaciente());
				if (pacienteDAO.guardarEntidad(pacBiometrico) != 1)
					return new RespuestaGenerica(ERR, "Ocurrió un error <B0> al registrar biometricos del paciente");
			}

		Map<String, Object> informacion = new HashMap<>();
		informacion.put("idPaciente", paciente.getIdPaciente());
		informacion.put("estatus", paciente.getEstatus());
//        informacion.put("noExpediente", expediente.getNoExpediente());
//        informacion.put("expediente", expediente);

		return new RespuestaGenerica(OK, "Paciente registrado", informacion);
	}

}
