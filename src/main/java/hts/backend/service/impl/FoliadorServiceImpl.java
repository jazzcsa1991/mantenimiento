package hts.backend.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hts.backend.entity.NomCatTipoFoliador;
import hts.backend.dao.FoliadorDAO;
import hts.backend.entity.Foliador;
import hts.backend.model.EstatusResponse;
import hts.backend.model.dto.FoliadorDTO;
import hts.backend.service.FoliadorService;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;


@Service("foliadorService")
public class FoliadorServiceImpl implements FoliadorService {

	private int OK = EstatusResponse.OK.getEstatus();
	private int ERROR = EstatusResponse.ERROR.getEstatus();
	private String msjOK = "Servicio ejecutado correctamente";

	private static final Logger logger = LoggerFactory.getLogger(FoliadorServiceImpl.class);

	@Resource
	private FoliadorDAO foliadorDAO;
	
	
	@Override
	@Transactional
	public String obtenSecuencia(Integer tipo, Integer HospitalId) {
		FoliadorDTO registro = foliadorDAO.obtenSecuencia(tipo, HospitalId);
		String seq = String.format("%0" + registro.getCeros() + "d",  Integer.parseInt(registro.getSecuencia()) + 1);
		Foliador foliador = foliadorDAO.get(Foliador.class, registro.getId());
		String sequencia = registro.getClave() + seq;
		foliador.setFechaActualizacion(new Date());
		foliador.setSecuencia(seq);
		if (foliadorDAO.actualizarEntidad(foliador) == 1) {
			return sequencia;
		} else {
			return null;
		}
	}


	@Override
	@Transactional
	public Integer guardarFoliadores(Integer hospitalId) {
		Integer count = 0;
		List<NomCatTipoFoliador> tiposFoliador = foliadorDAO.findAll(NomCatTipoFoliador.class);
		for (NomCatTipoFoliador tipoFoliador : tiposFoliador) {
			Foliador foliador = new Foliador();
			foliador.setTipoFoliadorId(tipoFoliador.getTipoFoliadorId());
			foliador.setSecuencia("0");
			foliador.setFechaActualizacion(new Date());
			foliador.setUsuarioRegistra(SecurityContextHolder.getContext().getAuthentication().getName());
			foliador.setHospitalId(hospitalId);
			foliador.setCeros(5);
			foliador.setCve(tipoFoliador.getCve());
			if (foliadorDAO.guardarEntidad(foliador) == 1) {
				count++;
			}
		}
		if (count == tiposFoliador.size()) {
			return 1;
		} else {
			throw new RuntimeException("Error al generar las sequencias para el hospital");
		}
	}


}