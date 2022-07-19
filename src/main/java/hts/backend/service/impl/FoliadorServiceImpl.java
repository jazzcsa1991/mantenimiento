package hts.backend.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import hts.backend.controller.CatalogosController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

	private static final Log logger = LogFactory.getLog(CatalogosController.class);

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
		logger.info(count);
		List<NomCatTipoFoliador> tiposFoliador = foliadorDAO.findAll(NomCatTipoFoliador.class);
		for (NomCatTipoFoliador tipoFoliador : tiposFoliador) {
			Foliador foliador = new Foliador();
			logger.info(tipoFoliador.getTipoFoliadorId());
			foliador.setTipoFoliadorId(tipoFoliador.getTipoFoliadorId());
			foliador.setSecuencia("0");
			foliador.setFechaActualizacion(new Date());
			logger.info("PLP");
			logger.info(SecurityContextHolder.getContext().getAuthentication().getName());
			foliador.setUsuarioRegistra(SecurityContextHolder.getContext().getAuthentication().getName());
			logger.info(hospitalId);
			foliador.setHospitalId(hospitalId);
			foliador.setCeros(5);
			logger.info(tipoFoliador.getCve());
			foliador.setCve(tipoFoliador.getCve());
			logger.info(foliador);
			var r = foliadorDAO.guardarEntidad(foliador);
			logger.info(r);
			if (r == 1) {
				count++;
			}
		}
		logger.info("asldkjlaksjdlkasjdlkasjl");
		logger.info(count);
		logger.info(tiposFoliador.size());

		if (count == tiposFoliador.size()) {
			return 1;
		} else {
			throw new RuntimeException("Error al generar las sequencias para el hospital");
		}
	}


}