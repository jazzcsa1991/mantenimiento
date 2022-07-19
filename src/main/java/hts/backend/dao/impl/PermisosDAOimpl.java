package hts.backend.dao.impl;

import hts.backend.dao.PermisosDAO;
import hts.backend.model.dto.PerfilDTO;
import hts.backend.model.dto.RolDTO;
import hts.backend.model.dto.ProfesionalRolDTO;
import hts.backend.model.dto.AdmFuncionDTO;
import hts.backend.entity.AdmPersonalRol;
import hts.backend.entity.CatRol;
import hts.backend.entity.NomCatPerfil;
import hts.backend.entity.AdmHospital;
import hts.backend.entity.AdmFuncion;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository("permisosDAO")
public class PermisosDAOimpl extends BaseDAOImpl implements PermisosDAO {
	private static final Logger logger = LoggerFactory.getLogger(PermisosDAOimpl.class);

	@Override
	public List<RolDTO> obtenRoles(PerfilDTO perfilDTO) {

		Criteria ct = session().createCriteria(CatRol.class);
		ct.add(Restrictions.eq("admHospital.hospitalId", perfilDTO.getIdHospital()));
		List<CatRol> lstTmp = ct.list();
		logger.info("Tamaño de la tabla Roles = " + lstTmp.size());
		List<RolDTO> lstRol = new ArrayList<RolDTO>();

		if (null != lstTmp && !lstTmp.isEmpty()) {
			for (CatRol rol : lstTmp) {
				RolDTO dto = new RolDTO();
				dto.setId(rol.getRolId());
				dto.setPerfilId(rol.getNomCatPerfil().getPerfilId());
				dto.setNombre(rol.getNombre());
				dto.setDescripcion(rol.getDescripcion());
				dto.setEstatus(rol.getStatus());
				dto.setFechaRegistro(rol.getFechaRegistro());
				dto.setUsuario(rol.getUsuarioRegistra());
				dto.setPerfilNombre(rol.getNomCatPerfil().getNombre());
				dto.setHospitalId(rol.getAdmHospital().getHospitalId());
				lstRol.add(dto);
			}
		}

		return lstRol;
	}


	@Override
	public List<PerfilDTO> obtenPerfiles() {
		// language=MySQL
		Query query = session().createSQLQuery("" +
				"SELECT " +
				"	pr.PERFIL_ID as idPerfil, " +
				"	pr.cve as cve, " +
				"	pr.nombre as nombre, " +
				"	pr.descripcion as descripcion, " +
				"	pr.VALOR_DEFAULT as valorDefault, " +
				"	pr.ESTATUS as statusOpcion, " +
				"	pr.FECHA_REGISTRO as fechaRegistro, " +
				"	pr.MEDICO as medico, " +
				"	USUARIO_REGISTRO as usuarioRegistro " +
				"FROM nom_cat_perfil pr " +
				"ORDER BY pr.PERFIL_ID ASC"
		)
				.addScalar("idPerfil", StandardBasicTypes.INTEGER)
				.addScalar("cve", StandardBasicTypes.STRING)
				.addScalar("nombre", StandardBasicTypes.STRING)
				.addScalar("fechaRegistro", StandardBasicTypes.DATE)
				.addScalar("usuarioRegistro", StandardBasicTypes.STRING)
				.addScalar("medico", StandardBasicTypes.BOOLEAN);

		query.setResultTransformer(Transformers.aliasToBean(PerfilDTO.class));

		return query.list();
	}


	@Override
	public int altaRol(RolDTO dto) {
		int exito = 0;
		try {
			CatRol rolEntidad = this.obtenEntidadRol(dto);
			rolEntidad.setNomCatPerfil(super.get(NomCatPerfil.class, dto.getPerfilId()));
			rolEntidad.setAdmHospital(super.get(AdmHospital.class, dto.getHospitalId()));
			this.save(rolEntidad);
			this.flush();
			exito = 1;
		} catch (Exception e) {
			logger.info("########### Ocurrio un error al guardar el rol accion", e);
			exito = 0;
		}

		return exito;
	}


	@Override
	public int actualizaRol(RolDTO dto) {
		int exito = 0;
		try {
			Criteria ct = session().createCriteria(CatRol.class);
			ct.add(Restrictions.eq("rolId", dto.getId()));
			CatRol rolEn = (CatRol) ct.uniqueResult();
			rolEn.setDescripcion(dto.getDescripcion());
			rolEn.setNombre(dto.getNombre());
			rolEn.setStatus(dto.getEstatus());
			if (!rolEn.getNomCatPerfil().getPerfilId().equals(dto.getPerfilId())) {
				rolEn.setNomCatPerfil(this.obtenPefilPorId(dto.getPerfilId()));
			}
			rolEn.setAdmHospital(dto.getHospital());
			this.merge(rolEn);
			this.flush();
			exito = 1;
			logger.info("########### SE ACTUALIZO DE FORMA CORRECTA EL ROL");
		} catch (Exception e) {
			logger.info("########### Ocurrio un error al guardar el rol accion", e);
			exito = 0;
		}
		return exito;
	}


	@Override
	public int asignaFuncionToRol(RolDTO dto) {
		int exito = 0;
		try {
			Criteria ct = session().createCriteria(CatRol.class);
			ct.add(Restrictions.eq("rolId", dto.getId()));
			CatRol entRol = (CatRol) ct.uniqueResult();


			for (AdmFuncionDTO funcDto : new ArrayList<AdmFuncionDTO>(dto.getAdmFuncions())) {

				Criteria ct2 = session().createCriteria(AdmFuncion.class);
				ct2.add(Restrictions.eq("funcionId", funcDto.getId()));
				AdmFuncion entFunc = (AdmFuncion) ct2.uniqueResult();

//				Set<CatRol> temp = entFunc.getCatRols();
//				temp.add(entRol);
//
//				entFunc.setCatRols(temp);

				entFunc.getCatRols().add(entRol);

				this.merge(entFunc);
				this.flush();
				logger.info("########### FUNCION " + funcDto.getId() + " ROL " + dto.getId());
			}

			exito = 1;
			logger.info("########### SE ASIGNO DE FORMA CORRECTA LA FUNCION AL ROL");
		} catch (Exception e) {
			logger.info("########### Ocurrio un error al asignar el rol accion", e);
			exito = 0;
		}
		return exito;
	}


	public CatRol obtenEntidadRol(RolDTO dto) {
		CatRol rolEntidad = new CatRol();
		rolEntidad.setNomCatPerfil(dto.getPerfil());
		rolEntidad.setNombre(dto.getNombre());
		rolEntidad.setDescripcion(dto.getDescripcion());
		rolEntidad.setFechaRegistro(new Date());
		rolEntidad.setUsuarioRegistra(dto.getUsuario());
		rolEntidad.setStatus(dto.getEstatus());
		rolEntidad.setAdmHospital(dto.getHospital());

		return rolEntidad;
	}


	public NomCatPerfil obtenPefilPorId(int id) {
		Criteria ct = session().createCriteria(NomCatPerfil.class);
		ct.add(Restrictions.eq("perfilId", id));

		return (NomCatPerfil) ct.uniqueResult();
	}


	@Override
	public List<RolDTO> obtenerRolesPorPerfil(RolDTO dto) {
		Criteria ct = session().createCriteria(CatRol.class, "rol").setProjection(Projections
				.projectionList()
				.add(Projections.property("rol.rolId"), "id")
				.add(Projections.property("rol.nombre"), "nombre")
				.add(Projections.property("catPerfil.nombre"), "perfilNombre")
				.add(Projections.property("nomCatPerfil.perfilId"), "perfilId"));
		ct.add(Restrictions.eq("nomCatPerfil.perfilId", dto.getPerfilId()));
		ct.add(Restrictions.eq("rol.status", 1));

		ct.createAlias("rol.catPerfil", "catPerfil");

		ct.setResultTransformer(Transformers.aliasToBean(RolDTO.class));

		return ct.list();
	}


	@Override
	public List<RolDTO> obtenerRolesByHospByPerf(RolDTO dto) {
		Criteria ct = session().createCriteria(CatRol.class, "rol").setProjection(Projections.projectionList()
				.add(Projections.property("rol.rolId"), "id")
				.add(Projections.property("rol.nombre"), "nombre")
				.add(Projections.property("catPerfil.nombre"), "perfilNombre")
				.add(Projections.property("nomCatPerfil.perfilId"), "perfilId"));

		ct.add(Restrictions.eq("nomCatPerfil.perfilId", dto.getPerfilId()));
		ct.add(Restrictions.eq("admHospital.hospitalId", dto.getHospitalId()));
		ct.add(Restrictions.eq("rol.status", 1));

		ct.createAlias("rol.nomCatPerfil", "catPerfil");
		ct.createAlias("rol.admHospital", "admHospital");

		ct.setResultTransformer(Transformers.aliasToBean(RolDTO.class));

		return ct.list();
	}


	@Override
	public List<ProfesionalRolDTO> obtenerRolesProfesional(ProfesionalRolDTO dto) {

		Criteria ct = session().createCriteria(AdmPersonalRol.class, "profRol").setProjection(Projections
				.projectionList()
				.add(Projections.property("profRol.profRolId"), "idProfesionalRol")
				.add(Projections.property("profRol.profesionalId"), "idProfesional")
				.add(Projections.property("profRol.hospitalId"), "idHospital")
				.add(Projections.property("profRol.perfilId"), "idPerfil")
				.add(Projections.property("profRol.rolId"), "idRol"));

		ct.add(Restrictions.eq("profRol.profesionalId", dto.getIdProfesional()));
		ct.setResultTransformer(Transformers.aliasToBean(ProfesionalRolDTO.class));

		return ct.list();
	}


	public CatRol obtenFRolPorID(int id) {
		Criteria ct = session().createCriteria(CatRol.class);
		ct.add(Restrictions.eq("rolId", id));
		return (CatRol) ct.uniqueResult();
	}

}
