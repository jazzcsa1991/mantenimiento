package hts.backend.service.impl;

import hts.backend.model.UsuarioAdmin;
import hts.backend.service.PermisosService;
import hts.backend.dao.AdminPermisosDAO;
import hts.backend.dao.HospitalDAO;
import hts.backend.dao.PermisosDAO;
import hts.backend.model.EstatusResponse;
import hts.backend.model.dto.PerfilDTO;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.RolDTO;
import hts.backend.model.dto.ProfesionalRolDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("permisosService")
@Transactional
public class PermisosServiceImpl implements PermisosService {
	private int OK = EstatusResponse.OK.getEstatus();
	private String msjOK = "Servicio ejecutado correctamente";

	@Resource
	private PermisosDAO permisosDAO;

	@Resource
	private HospitalDAO hospitalDAO;

	@Resource
	private AdminPermisosDAO adminPermisosDAO;


	@Override
	public RespuestaGenerica obtenRoles(PerfilDTO dto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuario = (UsuarioAdmin) auth.getPrincipal();
		if (adminPermisosDAO.validarPermiso(usuario,  7, dto.getIdHospital())) {
			return new RespuestaGenerica(OK, msjOK, "roles", permisosDAO.obtenRoles(dto));
		} else {
			throw new RuntimeException("El usuario no tiene permisos para realizar esta acción");
		}
	}

	@Override
	public RespuestaGenerica obtenPerfiles() {
		return new RespuestaGenerica(OK, msjOK, "perfiles", permisosDAO.obtenPerfiles());
	}

	@Override
	public RespuestaGenerica altaRol(RolDTO dto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuario = (UsuarioAdmin) auth.getPrincipal();
		if (adminPermisosDAO.validarPermiso(usuario,  7, dto.getHospitalId())) {
			dto.setUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
			dto.setFechaRegistro(new Date());
			dto.setEstatus(1);
			return new RespuestaGenerica(OK, msjOK, "exito", permisosDAO.altaRol(dto));
		} else {
			throw new RuntimeException("El usuario no tiene permisos para realizar esta acción");
		}
	}

	@Override
	public RespuestaGenerica actualizaRol(RolDTO dto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioAdmin usuario = (UsuarioAdmin) auth.getPrincipal();
		if (adminPermisosDAO.validarPermiso(usuario,  7, dto.getHospitalId())) {
			dto.setHospital(hospitalDAO.obtenerEntidadHospital(dto.getHospitalId()));
			return new RespuestaGenerica(OK, msjOK, "exito", permisosDAO.actualizaRol(dto));
		} else {
			throw new RuntimeException("El usuario no tiene permisos para realizar esta acción");
		}
	}

	@Override
	public RespuestaGenerica asignaFuncionToRol(RolDTO dto) {
		return new RespuestaGenerica(OK, msjOK, "exito", permisosDAO.asignaFuncionToRol(dto));
	}

	@Override
	public RespuestaGenerica obtenerRolesPorPerfil(RolDTO dto) {
		return new RespuestaGenerica(OK, msjOK, "rolesPerfil", permisosDAO.obtenerRolesPorPerfil(dto));
	}

	@Override
	public RespuestaGenerica obtenerRolesProfesional(ProfesionalRolDTO dto) {
		return new RespuestaGenerica(OK, msjOK, "rolesProfesional", permisosDAO.obtenerRolesProfesional(dto));
	}

	@Override
	public RespuestaGenerica obtenerRolesByHospByPerf(RolDTO dto) {
		return new RespuestaGenerica(OK, msjOK, "roles", permisosDAO.obtenerRolesByHospByPerf(dto));
	}

}
