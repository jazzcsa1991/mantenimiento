package hts.backend.controller;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.HospitalCluesDTO;
import hts.backend.model.dto.HospitalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import hts.backend.service.HospitalService;

@RestController
@RequestMapping({"/hospital"})
public class HospitalController {
    private final HospitalService hospitalService;

    @Autowired
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @ResponseBody
    @RequestMapping(
            value = {"/busca"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica buscaHospital(@RequestBody HospitalCluesDTO nombreInstitucionSalud) {
        return this.hospitalService.buscaHospital(nombreInstitucionSalud);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerCatEdificio"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatEdificio() {
        return this.hospitalService.obtenerCatEdificio();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/editaCatHospital"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica editaCatHospital(@RequestBody HospitalDTO hospital) {
        return this.hospitalService.editaCatHospital(hospital);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/desactivaHospital"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica desactivaHospital(@RequestBody HospitalDTO hospital) {
        return this.hospitalService.desactivaHospital(hospital);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/activaHospital"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica activaHospital(@RequestBody HospitalDTO hospital) {
        return this.hospitalService.activaHospital(hospital);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenCatTipoAsent"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatTipoAsen() {
        return this.hospitalService.obtenerCatTipoAsen();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenCatHospitalContinuo"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerHospitalContinuo() {
        return this.hospitalService.obtenerCatHospitalContinuo();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenCatHospitalParcial"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica CatHospitalParcial() {
        return this.hospitalService.obtenerCatHospitalParcial();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenCatCatTipoServ"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatTipoServ() {
        return this.hospitalService.obtenerCatTipoServ();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenCatTipoUnidadPsiq"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatTipoUnidadPsiq() {
        return this.hospitalService.obtenerCatTipoUnidadPsiq();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenCatCatVialidad"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatVialidad() {
        return this.hospitalService.obtenerCatVialidad();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerCatMunicipio"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatMunicipio(@RequestBody HospitalDTO hospitaldto) {
        return this.hospitalService.obtenerCatMunicipio(hospitaldto);
    }


    @ResponseBody
    @RequestMapping(
            value = {"/obtenerCatLocalidad"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatLocalidad(@RequestBody HospitalDTO hospitaldto) {
        return this.hospitalService.obtenerCatLocalidad(hospitaldto);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerCatCodigoPostal"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatCodigoPostal(@RequestBody HospitalDTO hospitaldto) {
        return this.hospitalService.obtenerCatCodigoPostal(hospitaldto);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerCatColonia"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatColonia(@RequestBody HospitalDTO hospitaldto) {
        return this.hospitalService.obtenerCatColonia(hospitaldto);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerCatEstadosXPais"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatEstadosXPais(@RequestBody HospitalDTO hospitaldto) {
        return this.hospitalService.obtenerCatEstadosXPais(hospitaldto);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenCatCatPais"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatPais() {
        return this.hospitalService.obtenerCatPais();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenCatJurisdiccion"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenCatJurisdiccion(@RequestBody HospitalDTO hospitaldto) {
        return this.hospitalService.obtenerCatJurisdiccion(hospitaldto);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenCatEstadosJurisdiccion"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenCatEstadosJurisdiccion() {
        return this.hospitalService.obtenerCatEstadosJurisdiccion();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/guardarHospital"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica guardarHospital(@RequestBody HospitalDTO hospitaldto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        hospitaldto.setUsuarioCve(auth.getName());
        return this.hospitalService.guardarHospital(hospitaldto);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerCatHospital"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCataHospital() {
        return this.hospitalService.obtenerCataHospital();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/hospitalesLista"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatHospitalRiss(@RequestBody HospitalDTO hospitaldto) {
        return this.hospitalService.obtenerCatHospitalRiss(hospitaldto);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerCatHospitalRisses"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatHospitalRisses(@RequestBody HospitalDTO hospitaldto) {
        return this.hospitalService.obtenerCatHospitalRisses(hospitaldto);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerHospitalesActivos"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerHospitalesActivos(@RequestBody Integer accion) {
        return this.hospitalService.obtenerCataHospitalActivos(accion);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerHospitalesActivosSP"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerHospitalesActivosSP() {
        return this.hospitalService.obtenerHospitalesActivosSP();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerCatTipoEstablecimiento"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerCatTipoEstablecimiento() {
        return this.hospitalService.obtenerCatTipoEstablecimiento();
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerHospitalXId"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerHospitalXId(@RequestBody HospitalDTO hospitaldto) {
        RespuestaGenerica respuesta = null;

        try {
            respuesta = this.hospitalService.obtenerHospitalId(hospitaldto);
        } catch (Exception var4) {
            var4.getMessage();
        }

        return respuesta;
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerClaves"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerClaves(@RequestBody HospitalDTO hospitaldto) {
        return this.hospitalService.validarClaves(hospitaldto.getHospitalId(), hospitaldto.getCpCve());
    }

    @ResponseBody
    @RequestMapping(
            value = {"/obtenerConfiguracionAsisencia"},
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    public RespuestaGenerica obtenerConfiguracionAsisencia() {
        return this.hospitalService.obtenerConfiguracionAsistencia();
    }
}
