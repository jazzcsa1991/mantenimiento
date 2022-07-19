package hts.backend.dao;

import hts.backend.model.dto.PerfilDTO;
import hts.backend.model.dto.RolDTO;
import hts.backend.model.dto.ProfesionalRolDTO;
import hts.backend.entity.CatRol;
import hts.backend.entity.NomCatPerfil;

import java.util.List;

public interface PermisosDAO {
	List<RolDTO> obtenRoles(PerfilDTO dto);

	List<PerfilDTO> obtenPerfiles();

	int altaRol(RolDTO dto);

	int actualizaRol(RolDTO dto);

	int asignaFuncionToRol(RolDTO dto);

	NomCatPerfil obtenPefilPorId(int id);

	CatRol obtenFRolPorID(int id);

	List<RolDTO> obtenerRolesPorPerfil(RolDTO dto);

	List<ProfesionalRolDTO> obtenerRolesProfesional(ProfesionalRolDTO dto);

	List<RolDTO> obtenerRolesByHospByPerf(RolDTO dto);
}
