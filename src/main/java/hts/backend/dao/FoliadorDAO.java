package hts.backend.dao;

import hts.backend.model.dto.FoliadorDTO;

public interface FoliadorDAO extends GenericHibernateDAO {
	
	FoliadorDTO obtenSecuencia(Integer tipoFolio, Integer hospitalId);

}
