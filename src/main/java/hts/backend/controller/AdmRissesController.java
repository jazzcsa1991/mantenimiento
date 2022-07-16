package hts.backend.controller;

import java.util.List;
import hts.backend.service.AdmRissesService;
import hts.backend.model.dto.DirecctorioDTO;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.CoreRissesDTO;
import hts.backend.model.dto.ResponsableEstadoDTO;
import hts.backend.model.dto.ResponsableHospitalDTO;
import hts.backend.model.dto.ResponsableJurisdiccionDTO;
import hts.backend.model.dto.ResponsableRissDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/riss"})
public class AdmRissesController {
    private static final Log logger = LogFactory.getLog(AdmRissesController.class);
    private final AdmRissesService admRissesService;

    @Autowired
    public AdmRissesController(AdmRissesService admRissesService) {
        this.admRissesService = admRissesService;
    }

    @ResponseBody
    @RequestMapping(
            value = {"/agregar"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica altaRiss(@RequestBody CoreRissesDTO dto) {
        return this.admRissesService.agregar(dto);
    }

    @RequestMapping(
            value = {"/listar"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    @ResponseBody
    public RespuestaGenerica obtenhospitales(@RequestBody CoreRissesDTO dto) {
        return this.admRissesService.obtenerEstabl(dto);
    }

    @RequestMapping(
            value = {"/obtenerDirectorio"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    @ResponseBody
    public RespuestaGenerica obtenerDirectorio(@RequestBody DirecctorioDTO dto) {
        return this.admRissesService.ListaBusquedaProf(dto);
    }

    @RequestMapping(
            value = {"/jurisdiccion/responsable"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    @ResponseBody
    public RespuestaGenerica responsableJurisdiccion(@RequestBody List<ResponsableJurisdiccionDTO> dto) {
        return this.admRissesService.responsableJurisdiccion(dto);
    }

    @RequestMapping(
            value = {"/hospital/responsable"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    @ResponseBody
    public RespuestaGenerica responsableHospital(@RequestBody List<ResponsableHospitalDTO> dto) {
        return this.admRissesService.responsableHospital(dto);
    }

    @RequestMapping(
            value = {"/estado/responsable"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    @ResponseBody
    public RespuestaGenerica responsableEstado(@RequestBody List<ResponsableEstadoDTO> dto) {
        return this.admRissesService.responsableEstado(dto);
    }

    @RequestMapping(
            value = {"/riss/responsable"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    @ResponseBody
    public RespuestaGenerica responsableRiss(@RequestBody List<ResponsableRissDTO> dto) {
        return this.admRissesService.responsableRiss(dto);
    }

    @RequestMapping(
            value = {"/responsable/listar"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    @ResponseBody
    public RespuestaGenerica listarResponsable(@RequestBody CoreRissesDTO dto) {
        return this.admRissesService.listarResponsable(dto);
    }

    @RequestMapping(
            value = {"/responsable/eliminar"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    @ResponseBody
    public RespuestaGenerica eliminarResponsable(@RequestBody CoreRissesDTO dto) {
        return this.admRissesService.eliminarResponsable(dto);
    }
}
