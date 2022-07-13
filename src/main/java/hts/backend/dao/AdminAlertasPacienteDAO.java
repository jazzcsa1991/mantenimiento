package hts.backend.dao;

import java.util.List;

import hts.backend.model.dto.AdmAlertasDTO;

public interface AdminAlertasPacienteDAO extends GenericHibernateDAO {
	
	List<AdmAlertasDTO> obtenerAlertasCapturadas(Integer rolId, Integer eventoId);

}
