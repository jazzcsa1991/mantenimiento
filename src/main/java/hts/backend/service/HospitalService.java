package hts.backend.service;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import java.lang.reflect.InvocationTargetException;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.HospitalCluesDTO;
import hts.backend.model.dto.HospitalDTO;

public interface HospitalService {
    RespuestaGenerica buscaHospital(HospitalCluesDTO var1);

    /** @deprecated */
    @Deprecated
    RespuestaGenerica obtenerCatPerfil();

    RespuestaGenerica obtenerCatTipoAsen();

    RespuestaGenerica obtenerCatJurisdiccion(HospitalDTO var1);

    RespuestaGenerica obtenerCatHospitalContinuo();

    RespuestaGenerica obtenerCatHospitalParcial();

    RespuestaGenerica obtenerCatTipoServ();

    RespuestaGenerica obtenerCatTipoUnidadPsiq();

    RespuestaGenerica obtenerCatVialidad();

    RespuestaGenerica obtenerCatPais();

    RespuestaGenerica guardarHospital(HospitalDTO var1);

    RespuestaGenerica obtenerCataHospitalActivos(Integer var1);

    RespuestaGenerica obtenerHospitalesActivosSP();

    RespuestaGenerica obtenerCataHospital();

    RespuestaGenerica obtenerCatHospitalRiss(HospitalDTO var1);

    RespuestaGenerica obtenerCatHospitalRisses(HospitalDTO var1);

    RespuestaGenerica editaCatHospital(HospitalDTO var1);

    RespuestaGenerica desactivaHospital(HospitalDTO var1);

    RespuestaGenerica activaHospital(HospitalDTO var1);

    /** @deprecated */
    @Deprecated
    RespuestaGenerica obtenerCatEdificio();

    RespuestaGenerica obtenerCatMunicipio(HospitalDTO var1);

    RespuestaGenerica obtenerCatLocalidad(HospitalDTO var1);

    RespuestaGenerica obtenerCatCodigoPostal(HospitalDTO var1);

    RespuestaGenerica obtenerCatColonia(HospitalDTO var1);

    RespuestaGenerica obtenerCatEstadosXPais(HospitalDTO var1);

    RespuestaGenerica obtenerCatTipoEstablecimiento();

    RespuestaGenerica obtenerCatEstadosJurisdiccion();

    RespuestaGenerica validarClaves(Integer var1, String var2);

    RespuestaGenerica obtenerHospitalId(HospitalDTO var1) throws IllegalAccessException, InvocationTargetException;

    RespuestaGenerica obtenerConfiguracionAsistencia();
}
