package hts.backend.service.impl;

import hts.backend.model.Globales;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.AdminPermisos;
import hts.backend.model.UsuarioAdmin;
import hts.backend.model.dto.AdminPermisosDTO;
import hts.backend.service.AdminPermisosService;
import hts.backend.dao.AdminPermisosDAO;
import hts.backend.entity.AdmHospital;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service("AdminPermisosService")
@Transactional
public class AdminPermisosServiceImpl implements AdminPermisosService {

	@Resource
	private AdminPermisosDAO adminPermisosDAO;


	@Override
	@Transactional
	public RespuestaGenerica guardarPermisos(Map<String, Object> mapa) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuarioRegistra = (UsuarioAdmin) auth.getPrincipal();
		if(Integer.parseInt(String.valueOf(usuarioRegistra.getPermisos().charAt(3))) != 1 && usuarioRegistra.getRoot() != 1){
			return new RespuestaGenerica(0, "No cuenta con los permisos para realizar esta acción");
		}
		UsuarioAdmin usuario = adminPermisosDAO.get(UsuarioAdmin.class, Integer.parseInt(mapa.get("personalId").toString()));
		if (usuario != null) {
			if (mapa.get("lista") != null) {
				for (Object lista : (List) mapa.get("lista")) {
					AdmHospital hospital = adminPermisosDAO.get(AdmHospital.class, Integer.parseInt(((LinkedHashMap) lista).get("hosp").toString()));

					if (hospital != null) {
						List<Integer> listaPermisos = (List<Integer>) ((LinkedHashMap) lista).get("arr");
						int x = 0;
						String permisoUsuario = "";
						for (Integer permiso : listaPermisos) {
							x += permiso;
							permisoUsuario += permiso.toString();
						}
						Map<String, Object> permisosHosp = adminPermisosDAO.listarPermisosUsuarioHospital(usuario.getUsuarioAdminId(), hospital.getHospitalId());

						if (x > 0) {
							AdminPermisos adminPermisos = new AdminPermisos();
							if (permisosHosp != null) {
								adminPermisos = adminPermisosDAO.get(AdminPermisos.class, Integer.parseInt(permisosHosp.get("adminPermisosAdminId").toString()));
								adminPermisos.setPermisos(permisoUsuario);
								adminPermisos.setFechaRegistro(new Date());
								adminPermisos.setUsuarioRegistro(usuarioRegistra.getNumeroEmpleado());
								if (adminPermisosDAO.actualizarEntidad(adminPermisos) != 1) {
									throw new RuntimeException("Hospital no encontrado");
								}
							} else {
								adminPermisos.setHospitalId(hospital.getHospitalId());
								adminPermisos.setUsuarioAdminId(usuario.getUsuarioAdminId());
								adminPermisos.setPermisos(permisoUsuario);
								adminPermisos.setFechaRegistro(new Date());
								adminPermisos.setUsuarioRegistro(usuarioRegistra.getNumeroEmpleado());

								if (adminPermisosDAO.guardarEntidad(adminPermisos) != 1) {
									throw new RuntimeException("Hospital no encontrado");
								}
							}
						} else if (permisosHosp != null) {
							AdminPermisos adminPermisos = adminPermisosDAO.get(AdminPermisos.class, Integer.parseInt(permisosHosp.get("adminPermisosAdminId").toString()));

							adminPermisosDAO.eliminarEntidad(adminPermisos);
						}
					} else {
						throw new RuntimeException("Hospital no encontrado");


					}
				}
			} else {
				throw new RuntimeException("Permisos no encontrados");
			}
			String permisos = "";
			if (mapa.get("permisosUs") != null) {

				for (Object objeto : (List) mapa.get("permisosUs")) {
					if (objeto != null) {
						permisos = permisos + ((LinkedHashMap) objeto).get("act").toString();
					}
				}
				usuario.setPermisos(permisos);
				if (adminPermisosDAO.actualizarEntidad(usuario) != 1) {
					throw new RuntimeException("Error a guardar los permisos del sistema");
				}
			}

		} else {
			throw new RuntimeException("Usuario no encontrado");
		}

		return new RespuestaGenerica(1, Globales.msjOK, "exito", 1);


	}

	@Override
	@Transactional
	public RespuestaGenerica editarPermisos(AdminPermisosDTO adminPermisosDTO) {

		AdminPermisos permisos = adminPermisosDAO.get(AdminPermisos.class, adminPermisosDTO.getAdminPermisosAdminId());
		AdmHospital hospital = adminPermisosDAO.get(AdmHospital.class, adminPermisosDTO.getHospitalId());
		UsuarioAdmin usuario = adminPermisosDAO.get(UsuarioAdmin.class, adminPermisosDTO.getUsuarioAdminId());
		if (permisos != null) {
			if (hospital != null) {
				if (usuario != null) {


					permisos.setPermisos(adminPermisosDTO.getPermisos());
					permisos.setHospitalId(adminPermisosDTO.getHospitalId());
					permisos.setUsuarioAdminId(adminPermisosDTO.getUsuarioAdminId());

					adminPermisosDAO.actualizarEntidad(permisos);

				} else {
					return new RespuestaGenerica(0, "el usuario no existe");
				}
			} else {
				return new RespuestaGenerica(0, "el hospital no existe");
			}
		} else {
			return new RespuestaGenerica(0, "el permiso no existe");
		}


		return new RespuestaGenerica(1, Globales.msjOK);
	}

	@Override
	@Transactional
	public RespuestaGenerica eliminarPermisos(AdminPermisosDTO adminPermisosDTO) {
		AdminPermisos permisos = adminPermisosDAO.get(AdminPermisos.class, adminPermisosDTO.getAdminPermisosAdminId());
		if (permisos != null) {


			adminPermisosDAO.eliminarEntidad(permisos);


		} else {

			return new RespuestaGenerica(0, "el permiso no existe");

		}


		return new RespuestaGenerica(1, Globales.msjOK);
	}

	@Override
	@Transactional
	public RespuestaGenerica consultarPermisos(Integer usuarioId) {
		return new RespuestaGenerica(1, Globales.msjOK, "listaPermisos", adminPermisosDAO.listarPermisosByUsuario(usuarioId));
	}
}
