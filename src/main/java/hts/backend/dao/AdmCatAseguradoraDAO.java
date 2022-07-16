package hts.backend.dao;

import hts.backend.model.dto.AdmCatAseguradoraDTO;
import hts.backend.model.dto.AgenteDireccionDTO;
import hts.backend.model.dto.DireccionDTO;
import hts.backend.entity.AdmCatAseguradora;
import hts.backend.entity.CatTipoAseguradora;
import hts.backend.entity.NomCatMonedas;
import hts.backend.dao.impl.BaseDAO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface AdmCatAseguradoraDAO extends BaseDAO {
	//----------- aseguradora-----------//

	List<AdmCatAseguradoraDTO> listaCatAseguradora();

	int altaAseguradora(AdmCatAseguradora cAseguradora) throws IllegalAccessException, InvocationTargetException;

	int modificarAseguradora(AdmCatAseguradora cAseguradora) throws IllegalAccessException, InvocationTargetException;

	int eliminarAseguradora(AdmCatAseguradoraDTO dto);

	List<AdmCatAseguradoraDTO> listaCatAseguradoraPorHospital(Integer hospitalId);

	AdmCatAseguradoraDTO direccionAseguradora(Integer aseguradoraId);

	CatTipoAseguradora tipoAseguradoraById(Integer tipoAseguradoraId);

	NomCatMonedas tipoMonedaById(Integer tipoMonedaId);

	AdmCatAseguradora aseguradoraById(Integer aseguradoraId);

	//----------- direcciones-----------//

	int altaDireccion(AgenteDireccionDTO dto);

	int modificaDireccion(AgenteDireccionDTO dto);

	int eliminaDireccion(AgenteDireccionDTO dto);

	List<DireccionDTO> listaDireccion(AgenteDireccionDTO dto);
}
