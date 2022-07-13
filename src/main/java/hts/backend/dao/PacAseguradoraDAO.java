package hts.backend.dao;

import java.util.List;

import hts.backend.entity.CatCoaseguro;
import hts.backend.entity.PacConvenioAseguradora;
import hts.backend.model.dto.PacAseguradoraDTO;

public interface PacAseguradoraDAO extends GenericHibernateDAO {

	List<PacConvenioAseguradora> obtenerConvenioDefaultAseguradoraParticularWOF(int idHospital);
	
	CatCoaseguro obtenerCatCoaseguroDefault();
	
	List<PacAseguradoraDTO> obtenerAseguradoraXPaciente(Integer pacienteId, Integer hospitalId);
	
}
