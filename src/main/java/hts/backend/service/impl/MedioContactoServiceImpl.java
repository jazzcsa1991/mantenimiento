package hts.backend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import hts.backend.dao.PacienteDAO;
import hts.backend.entity.AgenteCorreo;
import hts.backend.entity.AgenteDireccion;
import hts.backend.entity.AgenteTelefono;
import hts.backend.entity.Correo;
import hts.backend.entity.Direccion;
import hts.backend.entity.PacPaciente;
import hts.backend.entity.Telefono;
import hts.backend.model.EstatusResponse;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.AgenteContactoDTO;
import hts.backend.model.dto.AgenteCorreoDTO;
import hts.backend.model.dto.AgenteDireccionDTO;
import hts.backend.model.dto.AgenteTelefonoDTO;
import hts.backend.model.dto.ContactoDTO;
import hts.backend.model.dto.CorreoDTO;
import hts.backend.model.dto.DireccionDTO;
import hts.backend.model.dto.DomicilioDTO;
import hts.backend.model.dto.TelefonoDTO;
import hts.backend.service.MedioContactoService;

@Service
public class MedioContactoServiceImpl implements MedioContactoService {

	private static final Logger logger = LoggerFactory.getLogger(MedioContactoServiceImpl.class);
	
	@Resource
    private PacienteDAO pacienteDAO;
	
    private final static String REG_DESCONOCIDO = "Desconocido";
    private final static String REG_CORTO = "Corto";
    private final static String REG_COMPLETO = "Completo";
    private int OK = EstatusResponse.OK.getEstatus();
    private int ERR = EstatusResponse.ERROR.getEstatus();
    private String msjOK = "Servicio ejecutado correctamente";

	@Override
	public RespuestaGenerica registrarTelefono(AgenteTelefonoDTO dto) {
        // Registrar telÃ©fono
        Telefono tel = new Telefono(dto.getTelefono().getCatTipoTelefono().getTipoTelefonoId(), dto.getTelefono().getTelefono(), "+(52)+" + dto.getTelefono().getTelefono());

        logger.info("=======TELEFONO:  "+tel.getTelefono());
        
        if (pacienteDAO.guardarEntidad(tel) == 0) {
        	logger.info("=======NOTA I: Revisar validacion de almacenamiento!");
            //return new RespuestaGenerica(ERR, "OcurriÃ³ un error <T0> al registrar el telÃ©fono");
        }
        
        logger.info("=======TELEFONO guardado.  ");
    	
        // Vincular el telÃ©fono registrado con el paciente a travÃ©s del agente
        AgenteTelefono ag = AgenteTelefono.TelefonoPaciente(tel, dto.getAgenteId());

        if (pacienteDAO.guardarEntidad(ag) == 0) {
        	logger.info("=======NOTA J: Revisar validacion de almacenamiento!");
            //return new RespuestaGenerica(ERR, "OcurriÃ³ un error <T1> al registrar el telÃ©fono");
        }
        
        PacPaciente paciente = pacienteDAO.get(PacPaciente.class, dto.getAgenteId());
        paciente.setPacFechaActualizacion(new Date());
        pacienteDAO.actualizarEntidad(paciente);
        return new RespuestaGenerica(OK, msjOK, "telefonoId", tel.getTelefonoId());
	}

	@Override
	public RespuestaGenerica eliminarTelefono(TelefonoDTO dto) {
        Telefono telefono = pacienteDAO.get(Telefono.class, dto.getTelefonoId());
        
        telefono.setStatus(0);

        if (pacienteDAO.actualizarEntidad(telefono) == 0) {
        	logger.info("=======NOTA K: Revisar validacion de almacenamiento!");
            //return new RespuestaGenerica(ERR, "OcurriÃ³ un error al eliminar el telÃ©fono");
        }
        logger.info("=======Telefono actualizado: "+telefono.getStatus());
        
        PacPaciente paciente = pacienteDAO.get(PacPaciente.class, dto.getAgenteId());
        paciente.setPacFechaActualizacion(new Date());
        
        pacienteDAO.actualizarEntidad(paciente);
        return new RespuestaGenerica(OK, "Telefono eliminado", "telefonoId", telefono.getTelefonoId());
	}


	@Override
	public RespuestaGenerica registrarCorreo(AgenteCorreoDTO dto) {
        // Registrar correo
        Correo correo = new Correo(dto.getCorreo().getCorreo());
        
        logger.info("=======CORREO:  "+correo.getCorreo());
        
        //=====> AUNQUE SE ALMACENA EN BD DEVUELVE VALOR 0

        
        logger.info("=======Almacenando Entidad Correo...");
        if (pacienteDAO.guardarEntidad(correo)==0) {
        	logger.info("=======NOTA F: Revisar validacion de almacenamiento!");
        	//return new RespuestaGenerica(ERR, "OcurriÃ³ un error <C0> al registrar el correo");
        } 
        
        logger.info("=======Entidad Correo almacenada. "+correo.getCorreoId());
   	 
        // Vincular el correo registrado con el paciente a travÃ©s del agente
        AgenteCorreo ag = AgenteCorreo.CorreoPaciente(correo.getCorreoId(), dto.getAgenteId());
        logger.info("=======AGENTE ID:  "+dto.getAgenteId());
        
       
        PacPaciente paciente = pacienteDAO.get(PacPaciente.class, dto.getAgenteId());
        paciente.setPacFechaActualizacion(new Date());
        
        logger.info("=======PACIENTE:  "+paciente.getNombre());
        
        pacienteDAO.actualizarEntidad(paciente);
        
        if (pacienteDAO.guardarEntidad(ag) == 0) {
        	logger.info("=======NOTA G: Revisar validacion de almacenamiento!");
            //return new RespuestaGenerica(ERR, "OcurriÃ³ un error <C1> al registrar el correo");
        }
        
        return new RespuestaGenerica(OK, msjOK, "correoId", correo.getCorreoId());
	}

	@Override
	public RespuestaGenerica eliminarCorreo(CorreoDTO dto) {
        Correo correo = pacienteDAO.get(Correo.class, dto.getCorreoId());
        correo.setStatus(0);
        
        logger.info("=======CORREO:  "+correo.getCorreo());

        if (pacienteDAO.actualizarEntidad(correo) == 0) {
        	logger.info("=======NOTA H: Revisar validacion de almacenamiento!");
            //return new RespuestaGenerica(ERR, "OcurriÃ³ un error al eliminar el correo");
        }
        logger.info("=======ESTATUS:  "+correo.getStatus());
        
        PacPaciente paciente = pacienteDAO.get(PacPaciente.class, dto.getAgenteId());
        paciente.setPacFechaActualizacion(new Date());
        pacienteDAO.actualizarEntidad(paciente);
        
        return new RespuestaGenerica(OK, "Correo eliminado", "correoId", correo.getCorreoId());
	}

	@Override
	public RespuestaGenerica registrarDireccionPaciente(AgenteDireccionDTO dto, String clave) {
        
		//VALIDAR EXISTENCIA UNICA DE DOMICILIO ACTUAL Y ALTERNATIVO UNICOS
		List<DomicilioDTO> domicilios = pacienteDAO.consultaDomiciliosPaciente(dto.getAgenteId());
		
		for (DomicilioDTO domicilio: domicilios) {
			if(clave.compareTo("Normal")==0) 
				if(domicilio.getIsDomicilioAlternativo()!=null)
					if (domicilio.getIsDomicilioAlternativo()==false) 
		                return new RespuestaGenerica(ERR, "Ocurrio un error: El paciente ya cuenta con un domicilio actual.", "direccionId", domicilio.getDireccionId());
			
			if(clave.compareTo("Otra")==0) 
				if(domicilio.getIsDomicilioAlternativo()!=null)
					if (domicilio.getIsDomicilioAlternativo()==true) 
						return new RespuestaGenerica(ERR, "Ocurrio un error: El paciente ya cuenta con un domicilio alternativo.", "direccionId", domicilio.getDireccionId());
		}
		
		
		// Registrar direcciÃ³n
        Direccion direccion = new Direccion(
                dto.getDireccion().getCalle(),
                clave,
                (null != dto.getDireccion().getNomCatEntidades()) ? dto.getDireccion().getNomCatEntidades().getCatEntidadesId() : null,
                (null != dto.getDireccion().getNomCatMunicipio()) ? dto.getDireccion().getNomCatMunicipio().getCatMunicipioId() : null,
                (null != dto.getDireccion().getNomCatLocalidad()) ? dto.getDireccion().getNomCatLocalidad().getCatLocalidadId() : null,
                (null != dto.getDireccion().getNomCatCodigoPostal()) ? dto.getDireccion().getNomCatCodigoPostal().getCatCodigoPostalId() : null,
                (null != dto.getDireccion().getCatTipoAsen()) ? dto.getDireccion().getCatTipoAsen().getTipoAsenId() : null,
                (null != dto.getDireccion().getNomCatPaises()) ? dto.getDireccion().getNomCatPaises().getPaisId() : null,
                (null != dto.getDireccion().getCatVialidad()) ? dto.getDireccion().getCatVialidad().getVialidadId() : null,
                dto.getDireccion().getNoExt(),
                dto.getDireccion().getNoExtLetra(),
                dto.getDireccion().getNoInt(),
                dto.getDireccion().getNoIntLetra(),
                dto.getDireccion().getNombreVialidad(),
                dto.getDireccion().getNombreAsentamiento()
        );
        
        
        direccion.setIsDomicilioAlternativo(true);
        if(clave.compareTo("Normal")==0)
        	direccion.setIsDomicilioAlternativo(false);
        

        if (pacienteDAO.guardarEntidad(direccion) == 1) {
            // Vincular la direcciÃ³n registrada con el paciente a travÃ©s del agente
            AgenteDireccion ag = AgenteDireccion.DireccionPaciente(direccion, dto.getAgenteId());

            PacPaciente paciente = pacienteDAO.get(PacPaciente.class, dto.getAgenteId());

            paciente.setPacFechaActualizacion(new Date());

            pacienteDAO.actualizarEntidad(paciente);


            if (pacienteDAO.guardarEntidad(ag) == 1) {
                return new RespuestaGenerica(OK, msjOK, "direccionId", direccion.getDireccionId());
            } else {
                return new RespuestaGenerica(ERR, "Ocurrio un error: ID Paciente no encontrado.");
            }


        } else {
            return new RespuestaGenerica(ERR, "Ocurrio un error <D0> al registrar la direccion");
        }
	}

	@Override
	public RespuestaGenerica actualizarDireccionPaciente(DireccionDTO dto, Integer pacienteId, String clave) {
					
		
        Direccion direccion = pacienteDAO.get(Direccion.class, dto.getDireccionId());
        direccion.setNomCatEntidadesId((null != dto.getNomCatEntidades()) ? dto.getNomCatEntidades().getCatEntidadesId() : null);
        direccion.setNomCatMunicipioId((null != dto.getNomCatMunicipio()) ? dto.getNomCatMunicipio().getCatMunicipioId() : null);
        direccion.setNomCatLocalidadId((null != dto.getNomCatLocalidad()) ? dto.getNomCatLocalidad().getCatLocalidadId() : null);
        direccion.setNomCatCodigoPostalId((null != dto.getNomCatCodigoPostal()) ? dto.getNomCatCodigoPostal().getCatCodigoPostalId() : null);
        direccion.setCatTipoAsenId((null != dto.getCatTipoAsen()) ? dto.getCatTipoAsen().getTipoAsenId() : null);
        direccion.setNomCatPaisesId((null != dto.getNomCatPaises()) ? dto.getNomCatPaises().getPaisId() : null);
        direccion.setCatVialidadId((null != dto.getCatVialidad()) ? dto.getCatVialidad().getVialidadId() : null);
        direccion.setNoExt(dto.getNoExt());
        direccion.setNoExtLetra(dto.getNoExtLetra());
        direccion.setNoInt(dto.getNoInt());
        direccion.setNoIntLetra(dto.getNoIntLetra());
        direccion.setNombreVialidad(dto.getNombreVialidad());
        direccion.setNombreAsentamiento(dto.getNombreAsentamiento());
        direccion.setCalle(dto.getCalle());
        
        direccion.setIsDomicilioAlternativo(true);
        if(clave.compareTo("Normal")==0)
        	direccion.setIsDomicilioAlternativo(false);

        if (pacienteDAO.actualizarEntidad(direccion) == 1) {

            PacPaciente paciente = pacienteDAO.get(PacPaciente.class, pacienteId);
            paciente.setPacFechaActualizacion(new Date());
            pacienteDAO.actualizarEntidad(paciente);

            return new RespuestaGenerica(OK, msjOK, "direccionId", direccion.getDireccionId());
        } else {
            return new RespuestaGenerica(ERR, "Ocurrio un error <D0> al actualizar la direccion");
        }
	}

	@Override
	public RespuestaGenerica guardaContactoPaciente(AgenteContactoDTO dto) {
        return new RespuestaGenerica(OK, msjOK, "exito", pacienteDAO.guardaContactoPaciente(dto));
	}

	@Override
	public RespuestaGenerica eliminaContactoPaciente(ContactoDTO dto) {
        return new RespuestaGenerica(OK, msjOK, "exito", pacienteDAO.eliminaContactoPaciente(dto));
	}


}
