package hts.backend.service;

import hts.backend.model.dto.ReporteDatosHospitalDTO;
import hts.backend.model.dto.PresupuestoConsultaDTO;

import java.util.Date;
import java.util.List;

public interface EmailService {
	boolean send();

	boolean sendPasswordRecovery(String destinatario, String clave, String nombre);

	boolean sendPasswordRecoveryConfirm(String destinatario, Date fecha);

	boolean enviarPresupuesto(ReporteDatosHospitalDTO hospital, String paciente, String usuario, String tipoEvento, PresupuestoConsultaDTO mapa, List<String> correos, Integer presupuestoId);
}
