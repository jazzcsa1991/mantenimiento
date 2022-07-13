package hts.backend.service.impl;

import hts.backend.model.CoreConfigAsistencia;
import hts.backend.model.UsuarioAdmin;
import hts.backend.dao.AdminPermisosDAO;
import hts.backend.dao.HospitalDAO;
import hts.backend.service.FoliadorService;
import hts.backend.service.HospitalService;
import hts.backend.model.EstatusResponse;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.AdmLogosDTO;
import hts.backend.model.dto.HospitalCluesDTO;
import hts.backend.model.dto.HospitalDTO;
import hts.backend.entity.AdminLogos;
import hts.backend.entity.CoreAseguradoraHospital;
import hts.backend.entity.PacConvenioAseguradora;
import hts.backend.entity.AdmCatTipoHospital;
import hts.backend.entity.AdmHospital;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*import FoliadorService;*/


@Service("hospitalService")
@Transactional
public class HospitalServiceImpl implements HospitalService {

	private int ERROR = EstatusResponse.ERROR.getEstatus();
	private int OK = EstatusResponse.OK.getEstatus();
	private String msjOK = "Servicio ejecutado correctamente";

	@Resource
	private HospitalDAO hospitalDAO;

	@Resource
	private AdminPermisosDAO adminPermisosDAO;

	@Resource
	private FoliadorService foliadorService;


	@Override
	public RespuestaGenerica editaCatHospital(HospitalDTO hospitaldto) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuario = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuario.getPermisos().charAt(0))) != 1 && usuario.getRoot() != 1) {
			return new RespuestaGenerica(ERROR, "No cuenta con los permisos para realizar esta acción");
		}

		if (hospitaldto.getAdmLogosDTO() != null) {
			for (AdmLogosDTO logos : hospitaldto.getAdmLogosDTO()) {
				AdminLogos admLogos = hospitalDAO.get(AdminLogos.class, logos.getLogosId());

				admLogos.setEstatus(logos.getEstatus());

				hospitalDAO.actualizarEntidad(admLogos);
			}
		}

		hospitaldto.setCatTipoEstablecimiento(hospitalDAO.obtenerCatTipoEstablecimientoPorID(hospitaldto.getIdTipoEstablecimiento()));
		hospitaldto.setCatEstadoJurisdiccion(hospitalDAO.CatEstadoJurisdiccionPorID(hospitaldto.getIdEstadoJurisdiccion()));
		hospitaldto.setCatTipoServ(hospitalDAO.obtenerCatTipoServPorID(hospitaldto.getTiposervicio()));
		hospitaldto.setCatVialidad(hospitalDAO.obtenerCatVialidadPorID(hospitaldto.getIdvialidad()));
		hospitaldto.setCatJurisdiccion(hospitalDAO.obtenerCatJurisdiccionPorID(hospitaldto.getIdjurisdiccion()));

		return new RespuestaGenerica(OK, msjOK, "exito", hospitalDAO.editaCatHospital(hospitaldto));
	}


	@Override
	public RespuestaGenerica desactivaHospital(HospitalDTO hospitaldto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuario = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuario.getPermisos().charAt(0))) != 1 && usuario.getRoot() != 1) {
			return new RespuestaGenerica(ERROR, "No cuenta con los permisos para realizar esta acción");
		}
		return new RespuestaGenerica(OK, msjOK, "exito", hospitalDAO.estatusHospital(hospitaldto, 0));
	}


	@Override
	public RespuestaGenerica activaHospital(HospitalDTO hospitaldto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuario = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuario.getPermisos().charAt(0))) != 1 && usuario.getRoot() != 1) {
			return new RespuestaGenerica(ERROR, "No cuenta con los permisos para realizar esta acción");
		}
		return new RespuestaGenerica(OK, msjOK, "exito", hospitalDAO.estatusHospital(hospitaldto, 1));
	}


	@Override
	@Deprecated
	public RespuestaGenerica obtenerCatEdificio() {
		return null;
	}


	@Override
	public RespuestaGenerica obtenerCatTipoAsen() {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatTipoAsen());
	}


	@Override
	public RespuestaGenerica obtenerCatHospitalContinuo() {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatHospitalContinuo());
	}


	@Override
	public RespuestaGenerica obtenerCatHospitalParcial() {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatHospitalParcial());
	}


	@Override
	public RespuestaGenerica obtenerCatTipoServ() {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatTipoServ());
	}


	@Override
	public RespuestaGenerica obtenerCatTipoUnidadPsiq() {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatTipoUnidadPsiq());
	}


	@Override
	public RespuestaGenerica obtenerCatVialidad() {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatVialidad());
	}


	@Override
	public RespuestaGenerica obtenerCatMunicipio(HospitalDTO hospitaldto) {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatMunicipio(hospitaldto));
	}


	@Override
	public RespuestaGenerica obtenerCatLocalidad(HospitalDTO hospitaldto) {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatLocalidad(hospitaldto));
	}


	@Override
	public RespuestaGenerica obtenerCatCodigoPostal(HospitalDTO hospitaldto) {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatCodigoPostal(hospitaldto));
	}


	@Override
	public RespuestaGenerica obtenerCatColonia(HospitalDTO hospitaldto) {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatColonia(hospitaldto));
	}


	@Override
	public RespuestaGenerica obtenerCatEstadosXPais(HospitalDTO hospitaldto) {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatEstadosXPais(hospitaldto));
	}


	@Override
	public RespuestaGenerica obtenerCatJurisdiccion(HospitalDTO hospitaldto) {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatJurisdiccion(hospitaldto));
	}


	@Override
	public RespuestaGenerica obtenerCatPais() {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatPais());
	}


	@Override
	public RespuestaGenerica obtenerCatTipoEstablecimiento() {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatTipoEstablecimiento());
	}


	@Override
	public RespuestaGenerica obtenerCatEstadosJurisdiccion() {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.obtenerCatEstadosJurisdiccion());
	}


	@Override
	public RespuestaGenerica guardarHospital(HospitalDTO hospitaldto) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuario = (UsuarioAdmin) auth.getPrincipal();
		if (Integer.parseInt(String.valueOf(usuario.getPermisos().charAt(0))) != 1 && usuario.getRoot() != 1) {
			return new RespuestaGenerica(ERROR, "No cuenta con los permisos para realizar esta acción");
		}
		AdmCatTipoHospital tipoHospital = hospitalDAO.get(AdmCatTipoHospital.class, hospitaldto.getIdTipoHospsital());


		hospitaldto.setCatTipoEstablecimiento(hospitalDAO.obtenerCatTipoEstablecimientoPorID(hospitaldto.getIdTipoEstablecimiento()));
		hospitaldto.setCatEstadoJurisdiccion(hospitalDAO.CatEstadoJurisdiccionPorID(hospitaldto.getIdEstadoJurisdiccion()));
		hospitaldto.setCatTipoServ(hospitalDAO.obtenerCatTipoServPorID(hospitaldto.getTiposervicio()));
		hospitaldto.setCatVialidad(hospitalDAO.obtenerCatVialidadPorID(hospitaldto.getIdvialidad()));
		hospitaldto.setCatJurisdiccion(hospitalDAO.obtenerCatJurisdiccionPorID(hospitaldto.getIdjurisdiccion()));
		hospitaldto.setIdTipoHospsital(tipoHospital.getTipoHospitalId());
		hospitaldto.setEstatus(1);


		Integer hospital = hospitalDAO.guardarHospital(hospitaldto);

		for (AdmLogosDTO logos : hospitaldto.getAdmLogosDTO()) {

			AdminLogos admLogos = new AdminLogos();
			admLogos.setIdHospital(hospital);
			admLogos.setImagen(logos.getImagen());
			admLogos.setNombre(logos.getNombre());
			admLogos.setPosicion(logos.getPosicion());
			admLogos.setFechaRegistro(new Date());
			admLogos.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());
			admLogos.setEstatus(logos.getEstatus());

			hospitalDAO.guardarEntidad(admLogos);
		}

		if (hospital != 0) {
			if (foliadorService.guardarFoliadores(hospital) == 1) {
				CoreAseguradoraHospital entidad = new CoreAseguradoraHospital();
				entidad.setAseguradoraId(0);
				entidad.setHospitalId(hospital);
				entidad.setFechaRegistro(new Date());
				entidad.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());
				entidad.setEstatus(1);
				if (hospitalDAO.guardarEntidad(entidad) == 1) {


					if (hospitaldto.getIdTipoHospsital() != 1) {

						int nseTipoHospital = hospitaldto.getNseTipoHospital();
						for (int i = 0; i < nseTipoHospital; i++) {


							PacConvenioAseguradora convenioAseguradora = new PacConvenioAseguradora();
							if (i == 0) {
								convenioAseguradora.setValorDefault(1);

							} else {

								convenioAseguradora.setValorDefault(0);
							}

							convenioAseguradora.setCoreAseguradoraHospital(entidad);
							convenioAseguradora.setNombre("NSE" + (i + 1));
							convenioAseguradora.setCve("NSE" + (i + 1));
							convenioAseguradora.setDescripcion("NSE" + (i + 1));
							convenioAseguradora.setEstatus(1);
							convenioAseguradora.setFechaInicio(new Date());
							convenioAseguradora.setFechaFin(null);
							convenioAseguradora.setUsuarioRegistra(SecurityContextHolder.getContext().getAuthentication().getName());
							convenioAseguradora.setFechaRegistro(new Date());


							if (hospitalDAO.guardarEntidad(convenioAseguradora) != 1) {

								return new RespuestaGenerica(ERROR, "Ocurrió un error al intentar generar el convenio NSE");


							}


						}
						return new RespuestaGenerica(OK, msjOK, "exito", 1);
					} else {


						PacConvenioAseguradora convenioAseguradora = new PacConvenioAseguradora();


						convenioAseguradora.setCoreAseguradoraHospital(entidad);
						convenioAseguradora.setNombre("Particular");
						convenioAseguradora.setCve("Particular");
						convenioAseguradora.setDescripcion("Particular");
						convenioAseguradora.setEstatus(1);
						convenioAseguradora.setFechaInicio(new Date());
						convenioAseguradora.setFechaFin(null);
						convenioAseguradora.setUsuarioRegistra(SecurityContextHolder.getContext().getAuthentication().getName());
						convenioAseguradora.setFechaRegistro(new Date());
						convenioAseguradora.setValorDefault(0);

						if (hospitalDAO.guardarEntidad(convenioAseguradora) != 1) {

							return new RespuestaGenerica(ERROR, "Ocurrió un error al intentar generar el convenio NSE");


						}


						return new RespuestaGenerica(OK, msjOK, "exito", 1);
					}


				} else {
					return new RespuestaGenerica(ERROR, "Ocurrió un error al intentar generar la aseguradora particular");
				}
			} else {
				return new RespuestaGenerica(ERROR, "Ocurrió un error al intentar generar los foliadores");
			}

		} else {
			return new RespuestaGenerica(ERROR, "Ocurrió un error al intentar guardar el hospital");
		}
	}


	@Override
	public RespuestaGenerica obtenerCataHospitalActivos(Integer accion) {
		List<HospitalDTO> hospitales = hospitalDAO.obtenerCataHospitalActivos();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List permisos = adminPermisosDAO.listarPermisosByUsuario(usuarioRegistra.getUsuarioAdminId());

		if (usuarioRegistra.getRoot() == 1) {
			return new RespuestaGenerica(OK, msjOK, "hospitales", hospitales);
		} else {
			if (permisos.size() < 1) {
				return new RespuestaGenerica(ERROR, "No cuenta con permisos para la acción solicitada.");
			} else {
				for (int i = hospitales.size() - 1; i >= 0; i--) {
					Boolean eliminar = true;

					for (Object permiso : permisos) {
						if (((HashMap) permiso).get("hospitalId").equals(hospitales.get(i).getHospitalId())) {
							if (((HashMap) permiso).get("permisos").toString().charAt(accion) == '1') {
								eliminar = false;
							}
						}
					}

					if (eliminar) {
						hospitales.remove(i);
					}
				}
			}
		}

		if (hospitales.size() > 0) {
			return new RespuestaGenerica(OK, msjOK, "hospitales", hospitales);
		} else {
			return new RespuestaGenerica(ERROR, "No cuenta con permisos para la acción solicitada.");
		}
	}

	@Override
	public RespuestaGenerica obtenerHospitalesActivosSP() {
		return new RespuestaGenerica(OK, msjOK, "hospitales", hospitalDAO.obtenerCataHospitalActivos());
	}


	@Override
	public RespuestaGenerica obtenerCataHospital() {
		return new RespuestaGenerica(OK, msjOK, "hospitales", hospitalDAO.obtenerCataHospital());
	}

	@Override
	public RespuestaGenerica obtenerCatHospitalRiss(HospitalDTO hospitaldto) {
		return new RespuestaGenerica(OK, msjOK, "hospitales", hospitalDAO.obtenerCatHospitalRiss(hospitaldto));
	}

	@Override
	public RespuestaGenerica obtenerCatHospitalRisses(HospitalDTO hospitaldto) {
		return new RespuestaGenerica(OK, msjOK, "hospitales", hospitalDAO.obtenerCatHospitalRisses(hospitaldto));
	}


	@Override
	public RespuestaGenerica obtenerHospitalId(HospitalDTO hospitaldto) throws IllegalAccessException, InvocationTargetException {
		AdmHospital admHospital = hospitalDAO.obtenerHospitalId(hospitaldto.getHospitalId());
		HospitalDTO dest = new HospitalDTO();
		Map<String, Object> informacion = new HashMap<>();

		if (admHospital != null) {
			dest.setHospitalId(admHospital.getHospitalId());
			dest.setNombreCorto(admHospital.getNombreCorto());
			dest.setNombre(admHospital.getNombre());
			dest.setClueId(admHospital.getClueId());
			dest.setCveInstSalud(admHospital.getCveInstSalud());
			dest.setCveCtaInstSalud(admHospital.getCveCtaInstSalud());
			dest.setCalle(admHospital.getCalle());
			dest.setNoExt(admHospital.getNoExt());
			dest.setNoInt(admHospital.getNoInt());
			dest.setNoExtLetra(admHospital.getNoExtLetra());
			dest.setNoIntLetra(admHospital.getNoIntLetra());
			dest.setEstadoCve(admHospital.getEstadoCve());
			dest.setMunicipioCve(admHospital.getMunicipioCve());
			dest.setColoniaCve(admHospital.getColoniaCve());
			dest.setLocalidadCve(admHospital.getLocalidadCve());
			dest.setCpCve(admHospital.getCpCve());
			dest.setLada(admHospital.getLada());
			dest.setTelefono(admHospital.getTelefono());
			dest.setCorreo(admHospital.getCorreo());
			dest.setClaveDependencia(admHospital.getClaveDependencia());

			dest.setNombreVialidad(admHospital.getNombreVialidad());
			dest.setTipoAsen(admHospital.getTipoAsen());
			dest.setClaveOid(admHospital.getClaveOid());
			dest.setLicenciaSanitaria(admHospital.getLicenciaSanitaria());
			dest.setNombreAsentamiento(admHospital.getNombreAsentamiento());
			dest.setPais(admHospital.getPais());
			dest.setIdTipoUnidadPsiq(admHospital.getIdTipoUnidadPsiq());
			dest.setSerHospContinuoId(admHospital.getSerHospContinuoId());
			dest.setSerHospParcialId(admHospital.getSerHospParcialId());
			dest.setIdTipoHospsital(admHospital.getTipoHospitalId());

			dest.setEstatus(admHospital.getEstatus());

			if (admHospital.getCatEstadoJurisdiccion() != null && admHospital.getCatEstadoJurisdiccion().getIdEstadoJurisdiccion() != null)
				dest.setIdEstadoJurisdiccion(admHospital.getCatEstadoJurisdiccion().getIdEstadoJurisdiccion());

			if (admHospital.getCatJurisdiccion() != null && admHospital.getCatJurisdiccion().getCatJurisdiccionId() != null) {
				dest.setIdjurisdiccion(admHospital.getCatJurisdiccion().getCatJurisdiccionId());
				dest.setJurisdiccionCve(admHospital.getCatJurisdiccion().getJur());
			}

			if (admHospital.getCatTipoEstablecimiento() != null && admHospital.getCatTipoEstablecimiento().getIdTipoEstablecimiento() != null)
				dest.setIdTipoEstablecimiento(admHospital.getCatTipoEstablecimiento().getIdTipoEstablecimiento());

			if (admHospital.getCatTipoServ() != null && admHospital.getCatTipoServ().getIdtiposerv() != null)
				dest.setTiposervicio(admHospital.getCatTipoServ().getIdtiposerv());

			if (admHospital.getCatVialidad() != null && admHospital.getCatVialidad().getVialidadId() != null)
				dest.setIdvialidad(admHospital.getCatVialidad().getVialidadId());
		}

		informacion.put("hospital", dest);

		return new RespuestaGenerica(OK, msjOK, informacion);
	}


	@Override
	public RespuestaGenerica buscaHospital(HospitalCluesDTO nombreInstitucionSalud) {
		return new RespuestaGenerica(OK, msjOK, "opciones", hospitalDAO.buscaHospital(nombreInstitucionSalud));
	}


	@Override
	@Deprecated
	public RespuestaGenerica obtenerCatPerfil() {
		return null;
	}


	@Override
	public RespuestaGenerica validarClaves(Integer hospitalId, String cve) {
		return new RespuestaGenerica(OK, msjOK, "claves", hospitalDAO.obtenerClaves(hospitalId, cve));
	}

	@Override
	public RespuestaGenerica obtenerConfiguracionAsistencia() {
		return new RespuestaGenerica(OK, msjOK, "asistencia", hospitalDAO.findAll(CoreConfigAsistencia.class));
	}

}