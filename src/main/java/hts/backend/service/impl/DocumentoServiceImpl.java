package hts.backend.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import hts.backend.dao.PacienteDAO;
import hts.backend.entity.AgenteDocumento;
import hts.backend.entity.Documento;
import hts.backend.entity.PacNota;
import hts.backend.entity.PacPaciente;
import hts.backend.model.EstatusResponse;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.AgenteDocumentoDTO;
import hts.backend.model.dto.DocumentoDTO;
import hts.backend.model.dto.PacNotaDTO;
import hts.backend.service.DocumentoService;

@Service
public class DocumentoServiceImpl implements DocumentoService {
	
	@Resource
    private PacienteDAO pacienteDAO;
	
    private final static String REG_DESCONOCIDO = "Desconocido";
    private final static String REG_CORTO = "Corto";
    private final static String REG_COMPLETO = "Completo";
    private int OK = EstatusResponse.OK.getEstatus();
    private int ERR = EstatusResponse.ERROR.getEstatus();
    private String msjOK = "Servicio ejecutado correctamente";

	@Override
	public RespuestaGenerica registrarDocumento(AgenteDocumentoDTO dto) {
        // Registrar documento
        Documento documento = new Documento(dto.getDocumento().getCatDocumentoIdentificacion().getDocumentoIdentificacionId(), dto.getDocumento().getNumero());

        if (pacienteDAO.guardarEntidad(documento) == 1) {
            // Vincular el documento registrado con el paciente a través del agente
            AgenteDocumento ag = AgenteDocumento.DocumentoPaciente(documento, dto.getAgenteId());

            if (pacienteDAO.guardarEntidad(ag) == 1) {
                PacPaciente paciente = pacienteDAO.get(PacPaciente.class, dto.getAgenteId());
                paciente.setPacFechaActualizacion(new Date());
                pacienteDAO.actualizarEntidad(paciente);
                return new RespuestaGenerica(OK, msjOK);
            } else {
                return new RespuestaGenerica(ERR, "Ocurrió un error <D1> al registrar el documento");
            }
        } else {
            return new RespuestaGenerica(ERR, "Ocurrió un error <D0> al registrar el documento");
        }
	}

	@Override
	public RespuestaGenerica eliminarDocumento(DocumentoDTO dto) {
        Documento documento = pacienteDAO.get(Documento.class, dto.getDocumentoId());

        documento.setStatus(0);

        if (pacienteDAO.actualizarEntidad(documento) == 1) {
            return new RespuestaGenerica(OK, msjOK);
        } else {
            return new RespuestaGenerica(ERR, "Ocurrió un error al eliminar el documento");
        }
	}

	@Override
	public RespuestaGenerica registrarNota(PacNotaDTO dto) {
        PacNota nota = new PacNota(
                dto.getPacPaciente().getIdPaciente(),
                dto.getDescripcion()
        );

        return new RespuestaGenerica(pacienteDAO.guardarEntidad(nota), msjOK);
	}

	@Override
	public RespuestaGenerica eliminarNota(PacNotaDTO dto) {
        PacNota nota = pacienteDAO.get(PacNota.class, dto.getNotaId());

        if (nota.getUsuarioRegistra().equals(SecurityContextHolder.getContext().getAuthentication().getName())) {

            nota.setStatus(0);

            if (pacienteDAO.actualizarEntidad(nota) == 1) {
                return new RespuestaGenerica(OK, msjOK);
            } else {
                return new RespuestaGenerica(ERR, "Ocurrió un error al eliminar la nota");
            }
        } else {
            return new RespuestaGenerica(ERR, "No cuenta con permisos para realizar la acción solicitada");
        }
	}

}
