package hts.backend.dao;

import hts.backend.model.dto.DirecctorioDTO;
import hts.backend.model.dto.*;
import hts.backend.dao.impl.BaseDAO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


public interface AdmRissesDAO  extends BaseDAO {


	List<DirecctorioDTO> ListaBusquedaProf(DirecctorioDTO dto);

	List<CoreRissesDTO> listarEstabl (CoreRissesDTO dto);
	List<ResponsableEstadoDTO> listarResponsablesEstado (CoreRissesDTO dto);
	List<ResponsableJurisdiccionDTO> listarResponsablesJurisdiccion (CoreRissesDTO dto);
	List<ResponsableRissDTO> listarResponsablesRiss (CoreRissesDTO dto);
	List<ResponsableHospitalDTO> listarResponsablesHospital (CoreRissesDTO dto);
}
