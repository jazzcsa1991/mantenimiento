package hts.backend.service;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.List;
import hts.backend.model.dto.DirecctorioDTO;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.CoreRissesDTO;
import hts.backend.model.dto.ResponsableEstadoDTO;
import hts.backend.model.dto.ResponsableHospitalDTO;
import hts.backend.model.dto.ResponsableJurisdiccionDTO;
import hts.backend.model.dto.ResponsableRissDTO;

public interface AdmRissesService {
    RespuestaGenerica agregar(CoreRissesDTO var1);

    RespuestaGenerica obtenerEstabl(CoreRissesDTO var1);

    RespuestaGenerica listarResponsable(CoreRissesDTO var1);

    RespuestaGenerica eliminarResponsable(CoreRissesDTO var1);

    RespuestaGenerica responsableEstado(List<ResponsableEstadoDTO> var1);

    RespuestaGenerica responsableRiss(List<ResponsableRissDTO> var1);

    RespuestaGenerica responsableJurisdiccion(List<ResponsableJurisdiccionDTO> var1);

    RespuestaGenerica responsableHospital(List<ResponsableHospitalDTO> var1);

    RespuestaGenerica ListaBusquedaProf(DirecctorioDTO var1);
}
