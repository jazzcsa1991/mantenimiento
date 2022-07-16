package hts.backend.service.impl;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import hts.backend.dao.AdmRissesDAO;
import hts.backend.service.AdmRissesService;
import hts.backend.model.dto.DirecctorioDTO;
import hts.backend.model.EstatusResponse;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.CoreRissesDTO;
import hts.backend.model.dto.ResponsableEstadoDTO;
import hts.backend.model.dto.ResponsableHospitalDTO;
import hts.backend.model.dto.ResponsableJurisdiccionDTO;
import hts.backend.model.dto.ResponsableRissDTO;
import hts.backend.entity.CoreRisses;
import hts.backend.entity.ResponsableEstado;
import hts.backend.entity.ResponsableHospital;
import hts.backend.entity.ResponsableJurisdiccion;
import hts.backend.entity.ResponsableRiss;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("admRissesService")
@Transactional
public class AdmRissesServiceImpl implements AdmRissesService {
    @Resource
    private AdmRissesDAO admRissesDAO;
    private int OK;
    private int ERROR;
    private String msjOK;

    public AdmRissesServiceImpl() {
        this.OK = EstatusResponse.OK.getEstatus();
        this.ERROR = EstatusResponse.ERROR.getEstatus();
        this.msjOK = "Servicio ejecutado correctamente";
    }

    public RespuestaGenerica agregar(CoreRissesDTO dto) {
        CoreRisses coreRisses;
        if (dto.getRissId() != null) {
            coreRisses = (CoreRisses)this.admRissesDAO.get(CoreRisses.class, dto.getRissId());
            coreRisses.setNombre(dto.getNombre());
            return this.admRissesDAO.guardarEntidad(coreRisses) != 1 ? new RespuestaGenerica(this.ERROR, "Ocurrió un error al intentar actualizar") : new RespuestaGenerica(this.OK, this.msjOK, "exito", 1);
        } else {
            coreRisses = new CoreRisses();
            coreRisses.setNombre(dto.getNombre());
            coreRisses.setEstadoId(dto.getEstadoId());
            coreRisses.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());
            coreRisses.setFechaRegistro(new Date());
            return this.admRissesDAO.guardarEntidad(coreRisses) != 1 ? new RespuestaGenerica(this.ERROR, "Ocurrió un error al intentar guardar") : new RespuestaGenerica(this.OK, this.msjOK, "exito", 1);
        }
    }

    public RespuestaGenerica obtenerEstabl(CoreRissesDTO dto) {
        return new RespuestaGenerica(this.OK, this.msjOK, "listaEstabl", this.admRissesDAO.listarEstabl(dto));
    }

    public RespuestaGenerica listarResponsable(CoreRissesDTO dto) {
        List admlista = null;
        switch (dto.getIdentificador()) {
            case 1:
                admlista = this.admRissesDAO.listarResponsablesEstado(dto);
                break;
            case 2:
                admlista = this.admRissesDAO.listarResponsablesRiss(dto);
                break;
            case 3:
                admlista = this.admRissesDAO.listarResponsablesJurisdiccion(dto);
                break;
            case 4:
                admlista = this.admRissesDAO.listarResponsablesHospital(dto);
                break;
            default:
                return new RespuestaGenerica(this.ERROR, "Ocurrió un error");
        }

        return new RespuestaGenerica(this.OK, this.msjOK, "lista", admlista);
    }

    public RespuestaGenerica ListaBusquedaProf(DirecctorioDTO dto) {
        return new RespuestaGenerica(EstatusResponse.OK.getEstatus(), "datos obtenidos correctamente", "listaProf", this.admRissesDAO.ListaBusquedaProf(dto));
    }

    public RespuestaGenerica eliminarResponsable(CoreRissesDTO dto) {
        int itsOk;
        switch (dto.getIdentificador()) {
            case 1:
                ResponsableEstado responsableEstado = (ResponsableEstado)this.admRissesDAO.get(ResponsableEstado.class, dto.getResponsableId());
                if (responsableEstado == null) {
                    return new RespuestaGenerica(this.ERROR, "Usuario Responsable no encontrado");
                }

                itsOk = this.admRissesDAO.eliminarEntidad(responsableEstado);
                break;
            case 2:
                ResponsableRiss responsableRiss = (ResponsableRiss)this.admRissesDAO.get(ResponsableRiss.class, dto.getResponsableId());
                itsOk = this.admRissesDAO.eliminarEntidad(responsableRiss);
                break;
            case 3:
                ResponsableJurisdiccion responsableJurisdiccion = (ResponsableJurisdiccion)this.admRissesDAO.get(ResponsableJurisdiccion.class, dto.getResponsableId());
                itsOk = this.admRissesDAO.eliminarEntidad(responsableJurisdiccion);
                break;
            case 4:
                ResponsableHospital responsableHospital = (ResponsableHospital)this.admRissesDAO.get(ResponsableHospital.class, dto.getResponsableId());
                itsOk = this.admRissesDAO.eliminarEntidad(responsableHospital);
                break;
            default:
                return new RespuestaGenerica(this.ERROR, "Ocurrió un error");
        }

        return itsOk != 1 ? new RespuestaGenerica(this.ERROR, "Ocurrió un error al intentar eliminar") : new RespuestaGenerica(this.OK, this.msjOK, "exito", 1);
    }

    public RespuestaGenerica responsableEstado(List<ResponsableEstadoDTO> dto) {
        for(int i = 0; i < dto.size(); ++i) {
            if (((ResponsableEstadoDTO)dto.get(i)).getResponsableEstadoId() == null) {
                ResponsableEstado responsableEstado = new ResponsableEstado();
                responsableEstado.setFechaRegistro(new Date());
                responsableEstado.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());
                responsableEstado.setEstadoId(((ResponsableEstadoDTO)dto.get(i)).getEstadoId());
                responsableEstado.setUsuarioId(((ResponsableEstadoDTO)dto.get(i)).getUsuarioId());
                if (this.admRissesDAO.guardarEntidad(responsableEstado) != 1) {
                    return new RespuestaGenerica(this.ERROR, "Ocurrió un error al intentar guardar");
                }
            }
        }

        return new RespuestaGenerica(this.OK, this.msjOK);
    }

    public RespuestaGenerica responsableRiss(List<ResponsableRissDTO> dto) {
        for(int i = 0; i < dto.size(); ++i) {
            if (((ResponsableRissDTO)dto.get(i)).getResponsableRissId() == null) {
                ResponsableRiss responsableRiss = new ResponsableRiss();
                responsableRiss.setFechaRegistro(new Date());
                responsableRiss.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());
                responsableRiss.setEstadoId(((ResponsableRissDTO)dto.get(i)).getEstadoId());
                responsableRiss.setUsuarioId(((ResponsableRissDTO)dto.get(i)).getUsuarioId());
                responsableRiss.setRissId(((ResponsableRissDTO)dto.get(i)).getRissId());
                if (this.admRissesDAO.guardarEntidad(responsableRiss) != 1) {
                    return new RespuestaGenerica(this.ERROR, "Ocurrió un error al intentar guardar");
                }
            }
        }

        return new RespuestaGenerica(this.OK, this.msjOK);
    }

    public RespuestaGenerica responsableJurisdiccion(List<ResponsableJurisdiccionDTO> dto) {
        for(int i = 0; i < dto.size(); ++i) {
            if (((ResponsableJurisdiccionDTO)dto.get(i)).getResponsableJurisdiccionId() == null) {
                ResponsableJurisdiccion responsableJurisdiccion = new ResponsableJurisdiccion();
                responsableJurisdiccion.setFechaRegistro(new Date());
                responsableJurisdiccion.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());
                responsableJurisdiccion.setEstadoId(((ResponsableJurisdiccionDTO)dto.get(i)).getEstadoId());
                responsableJurisdiccion.setUsuarioId(((ResponsableJurisdiccionDTO)dto.get(i)).getUsuarioId());
                responsableJurisdiccion.setRissId(((ResponsableJurisdiccionDTO)dto.get(i)).getRissId());
                if (this.admRissesDAO.guardarEntidad(responsableJurisdiccion) != 1) {
                    return new RespuestaGenerica(this.ERROR, "Ocurrió un error al intentar guardar");
                }
            }
        }

        return new RespuestaGenerica(this.OK, this.msjOK);
    }

    public RespuestaGenerica responsableHospital(List<ResponsableHospitalDTO> dto) {
        for(int i = 0; i < dto.size(); ++i) {
            if (((ResponsableHospitalDTO)dto.get(i)).getResponsableHospitalId() == null) {
                ResponsableHospital responsableHospital = new ResponsableHospital();
                responsableHospital.setFechaRegistro(new Date());
                responsableHospital.setUsuarioRegistro(SecurityContextHolder.getContext().getAuthentication().getName());
                responsableHospital.setEstadoId(((ResponsableHospitalDTO)dto.get(i)).getEstadoId());
                responsableHospital.setUsuarioId(((ResponsableHospitalDTO)dto.get(i)).getUsuarioId());
                responsableHospital.setRissId(((ResponsableHospitalDTO)dto.get(i)).getRissId());
                responsableHospital.setIdClues(((ResponsableHospitalDTO)dto.get(i)).getIdClues());
                responsableHospital.setHospitalId(((ResponsableHospitalDTO)dto.get(i)).getHospitalId());
                responsableHospital.setJurisdiccionId(((ResponsableHospitalDTO)dto.get(i)).getJurisdiccionId());
                if (this.admRissesDAO.guardarEntidad(responsableHospital) != 1) {
                    return new RespuestaGenerica(this.ERROR, "Ocurrió un error al intentar guardar");
                }
            }
        }

        return new RespuestaGenerica(this.OK, this.msjOK);
    }
}

