package hts.backend.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hts.backend.dao.AdminAlertasPacienteDAO;
import hts.backend.dao.HospitalDAO;
import hts.backend.dao.PacAseguradoraDAO;
import hts.backend.dao.PacienteDAO;
import hts.backend.model.CurpRequest;
import hts.backend.model.EstatusResponse;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.AdmAlertasDTO;
import hts.backend.model.dto.PacienteDTO;
import hts.backend.model.dto.PacienteDuplicadoDatosDTO;
import hts.backend.service.ConsultaService;
import hts.backend.utils.SecurityUtil;
import hts.backend.entity.AdmHospital;


@Service("consultaService")
@Transactional
public class ConsultaServiceImpl implements ConsultaService {
	
    private final static String REG_DESCONOCIDO = "Desconocido";
    private final static String REG_CORTO = "Corto";
    private final static String REG_COMPLETO = "Completo";
    private int OK = EstatusResponse.OK.getEstatus();
    private int ERR = EstatusResponse.ERROR.getEstatus();
    private String msjOK = "Servicio ejecutado correctamente";
    
	@Resource
    private PacienteDAO pacienteDAO;
	
    @Resource
    private HospitalDAO hospitalDAO;
    
    @Resource
    private PacAseguradoraDAO pacAsegradoraDAO;
    
    @Resource
    private AdminAlertasPacienteDAO adminAlertasPacienteDAO;
    
    @Override
    public RespuestaGenerica ListaBusquedaPaciente(PacienteDTO dto) {
        // Realizar la búsqueda de paciente
        List<PacienteDTO> listaResultadosBusqueda = pacienteDAO.ListaBusquedaPaciente(dto);

        // Obtener el hospital del usuario activo
        AdmHospital hospitalUsuario = hospitalDAO.obtenerIdHospital(Integer.valueOf(new SecurityUtil().getRole(SecurityContextHolder.getContext().getAuthentication().getName())));

//        if (listaResultadosBusqueda != null && !listaResultadosBusqueda.isEmpty()) {
//            // Obtener la aseguradora con prioridad más alta en el hospital de la búsqueda
//            for (PacienteDTO paciente : listaResultadosBusqueda) {
//                // Obtener aseguradoras del paciente
//                List<PacAseguradoraDTO> aseguradorasPaciente = pacAsegradoraDAO.obtenerAseguradoraXPaciente(paciente.getIdPaciente(), hospitalUsuario.getHospitalId());
//
//                // Si existe aseguradora, asignar sus datos al DTO de salida
//                if (aseguradorasPaciente != null && !aseguradorasPaciente.isEmpty()) {
//                    paciente.setVigencia(aseguradorasPaciente.get(0).getFechaFin());
//                    paciente.setNombreAseguradora(aseguradorasPaciente.get(0).getCatAseguradoraNombre());
//                    paciente.setConvenio(aseguradorasPaciente.get(0).getConvenioAseguradoraId());
//                    paciente.setNombreConvenio(aseguradorasPaciente.get(0).getConvenioAseguradoraNombre());
//                }
//            }
//        }

        return new RespuestaGenerica(OK, msjOK, "pacientes", listaResultadosBusqueda);
    }

    @Override
    public RespuestaGenerica consultarDatosPaciente(Integer idPaciente) {
        Map<String, Object> informacion = new HashMap<>();
        Integer idRol = Integer.valueOf(new SecurityUtil().getRole(SecurityContextHolder.getContext().getAuthentication().getName()));
        AdmHospital hospital = hospitalDAO.obtenerIdHospital(idRol);
        
        PacienteDuplicadoDatosDTO paciente = pacienteDAO.consultarDatosPaciente(idPaciente);
        if(paciente.getIdPaciente()==null)
        	return new RespuestaGenerica(ERR, "El Paciente no existe", "paciente", null);
        
        List<Integer> eventos = pacienteDAO.obtenerEventoAcitivoPaciente(paciente.getIdPaciente());
        List<AdmAlertasDTO> lista = new ArrayList<>();

        // interfaz cintillo
        for (Integer item : eventos) {
            lista.addAll(adminAlertasPacienteDAO.obtenerAlertasCapturadas(idRol, item));
        }
        paciente.setListaAlertas(lista);

        informacion.put("paciente", paciente);
//        informacion.put("aseguradora", pacienteDAO.obtenerAseguradoraByPaciente(idPaciente, hospital.getHospitalId()));

        return new RespuestaGenerica(OK, msjOK, "paciente", informacion);
    }

    @Override
    public RespuestaGenerica consultarDatosPacienteQR(Integer idPaciente) {
        Map<String, Object> informacion = new HashMap<>();
        PacienteDuplicadoDatosDTO paciente = pacienteDAO.consultarDatosPacienteQR(idPaciente);

        informacion.put("paciente", paciente);

        return new RespuestaGenerica(OK, msjOK, "paciente", informacion);
    }

    @Override
    public RespuestaGenerica consultarDatosPacienteCURP(Integer idPaciente, String curp) {
        Map<String, Object> informacion = new HashMap<>();
        PacienteDuplicadoDatosDTO paciente = pacienteDAO.consultarDatosPacienteCURP(idPaciente);
        String curpVal = "";
        String curps = paciente.getCurp();
        String msj = "";

        if (curps.length() > 4) {
            curpVal = curps.substring(curps.length() - 4);
        }

        String auxCurp = curpVal;

        if (curp.compareTo(auxCurp)==0) {
            msj = "COMPROBADO";
        }

        informacion.put("paciente", msj);
        return new RespuestaGenerica(OK, msjOK, "paciente", informacion);
    }

	@Override
	public RespuestaGenerica consultarDatosPacientePorExpediente(String expediente) {
		Integer idPaciente = pacienteDAO.consultaIdPacientePorExpediente(expediente);
		if(idPaciente==null)
			return new RespuestaGenerica(ERR, "El expediente "+expediente+" no existe", "paciente", null);
		return this.consultarDatosPaciente(idPaciente);
	}
	
    public RespuestaGenerica validaExistenciaCurp(CurpRequest curp) {
        return new RespuestaGenerica(OK, msjOK, "exito", pacienteDAO.validaExistenciaCurp(curp));
    }

	@Override
	public RespuestaGenerica consultarDatosPacientePorBiometricos(String token) {
		Integer idPaciente = pacienteDAO.consultaIdPacientePorBiometricos(token);
		return this.consultarDatosPaciente(idPaciente);
	}

	@Override
	public RespuestaGenerica consultarDomiciliosPaciente(Integer idPaciente) {
		PacienteDuplicadoDatosDTO paciente = pacienteDAO.consultarDatosPaciente(idPaciente);
		if(paciente.getIdPaciente() == null)
			return new RespuestaGenerica(ERR, "El paciente "+idPaciente+" no existe en la base de datos.", "domicilios", null);
		return new RespuestaGenerica(OK, msjOK, "domicilios", pacienteDAO.consultaDomiciliosPaciente(idPaciente));
	}

}
