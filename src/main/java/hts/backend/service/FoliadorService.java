package hts.backend.service;

public interface FoliadorService {
	
	String obtenSecuencia (Integer tipo, Integer hospitalId);
	Integer guardarFoliadores(Integer hospitalId);

}
