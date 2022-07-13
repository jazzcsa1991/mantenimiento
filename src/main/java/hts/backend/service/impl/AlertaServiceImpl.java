package hts.backend.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import hts.backend.dao.AdminAlertasPacienteDAO;
import hts.backend.dao.HospitalDAO;
import hts.backend.entity.AdmAlertas;
import hts.backend.entity.PacEvento;
import hts.backend.entity.PacEventoAlertas;
import hts.backend.entity.PacPaciente;
import hts.backend.model.EstatusResponse;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.PacEventoAlertaDTO;
import hts.backend.model.dto.PacEventoDTO;
import hts.backend.service.AlertaService;

@Service
public class AlertaServiceImpl implements AlertaService {
	
	@Resource
	private AdminAlertasPacienteDAO adminAlertasPacienteDAO;
	
	@Resource
	private HospitalDAO hospitalDAO;

	private int OK = EstatusResponse.OK.getEstatus();
	private String msjOK = "Servicio ejecutado correctamente";

	@Override
	public RespuestaGenerica guardarEventoAlerta(PacEventoDTO dto) {
		//List<Integer> eventoAlertas = adminAlertasPacienteDAO.listarAlertasByEvento(dto.getEventoId());
		PacEvento evento = adminAlertasPacienteDAO.get(PacEvento.class, dto.getEventoId());
		PacPaciente paciente = adminAlertasPacienteDAO.get(PacPaciente.class, evento.getPacienteId());


		if (dto.getPacEventoAlertaDTOS().size() != 0) {

			for (PacEventoAlertaDTO item : dto.getPacEventoAlertaDTOS()) {
				AdmAlertas alerta = adminAlertasPacienteDAO.get(AdmAlertas.class, item.getAlertaId());
				if (paciente.getSexoId() == alerta.getSexoId() || alerta.getSexoId() == null) {
					PacEventoAlertas entidad = new PacEventoAlertas();
					entidad.setEventoId(dto.getEventoId());
					entidad.setAlertaId(item.getAlertaId());
					if (alerta.getComentario() == 1) {
						entidad.setComentario(item.getComentario());
					}
					entidad.setFechaRegistro(new Date());
					entidad.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());
					List<PacEventoAlertas> existe = adminAlertasPacienteDAO.find("SELECT s FROM PacEventoAlertas s where s.eventoId = ? and s.alertaId=? and s.fechaEliminacion is null", dto.getEventoId(), item.getAlertaId());
					if (existe.size() == 0) {
						adminAlertasPacienteDAO.guardarEntidad(entidad);
					}
				}
			}
		}
		return new RespuestaGenerica(OK, msjOK);
	}

	@Override
	public RespuestaGenerica anularEventoAlerta(PacEventoAlertaDTO dto) {
		PacEventoAlertas entidad = adminAlertasPacienteDAO.get(PacEventoAlertas.class, dto.getEventoAlertaId());
		entidad.setFechaEliminacion(new Date());
		entidad.setUsuarioEliminacion(SecurityContextHolder.getContext().getAuthentication().getName());
		return new RespuestaGenerica(OK, msjOK, "exito", adminAlertasPacienteDAO.actualizarEntidad(entidad));
	}

}
