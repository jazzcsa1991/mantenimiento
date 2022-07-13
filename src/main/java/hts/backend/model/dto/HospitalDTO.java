package hts.backend.model.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import hts.backend.entity.*;

import java.util.Date;
import java.util.List;


public class HospitalDTO {
    private Integer hospitalId;
    private String nombreCorto;
    private String nombre;
    private String clueId;
    private String cveInstSalud;
    private String cveCtaInstSalud;
    private String calle;
    private String noExt;
    private String noInt;
    private String estadoCve;
    private String municipioCve;
    private String coloniaCve;
    private String localidadCve;
    private String cpCve;
    private String lada;
    private String telefono;
    private String correo;
    private Date fechaRegistro;
    private String usuarioCve;
    private Integer estatus;
    private Integer tiposervicio;	// catTipoServ
    private String tiposervicioNombre;	// catTipoServ
    private String claveDependencia;
    private Integer idjurisdiccion; // catJurisdiccion
    private Integer idEstadoJurisdiccion; // CatEstadoJurisdiccion
    private Integer idtipoUnidadMedica; // admUnidadMedica
    private Integer idvialidad; // catVialidad
    private String nombreVialidad;
    private Integer tipoAsen;
    private String claveOid;
    private String licenciaSanitaria;
    private String nombreAsentamiento;
    private String pais;
    private Integer idTipoUnidadPsiq;
    private Integer idTipoHospsital;
    private Integer nseTipoHospital;

    private List<AdmLogosDTO> admLogosDTO;

    private Integer serHospContinuoId;
    private Integer serHospParcialId;
    private String nombrejurisdiccion;
    private String cveJurisdiccion;
    private String jurisdiccion;
    private Integer configuraciones;




    //Encabezado
    private String nombreUnidad;
    private String nombreInstitucion;
    private Integer idClues;
    private String clues;
    private String calleUnidad;
    private String tipoAsentamiento;
    private String coloniaUnidad;
    private String numeroExtU;
    private String numeroIntI;
    private String direccionEstado;
    private String entidadU;
    private String municipioU;
    private String localidadU;
    private String codigopostal;
    private String nombreJurisdiccion;
    private String tipoEstablecimientoU;
    private String nivelAtencion;
    private String telefonoU;
    private String correoU;
    private String licenciaSanitariaU;

    private int imagenId;
    private String imagen;

    //Risses
    private Integer rissId;

    @JsonIgnore
    private CatEstadoJurisdiccion catEstadoJurisdiccion;
    @JsonIgnore
    private CatTipoEstablecimiento catTipoEstablecimiento;
    @JsonIgnore
    private CatTipoServ catTipoServ;
    @JsonIgnore
    private CatVialidad catVialidad;
    @JsonIgnore
    private CatJurisdiccion catJurisdiccion;
    @JsonIgnore
    private AdmEdificio admEdificio;

    private Integer idTipoEstablecimiento;
    private String jurisdiccionCve;
    private String noExtLetra;
    private String noIntLetra;

    public String getJurisdiccion() {
        return jurisdiccion;
    }

    public void setJurisdiccion(String jurisdiccion) {
        this.jurisdiccion = jurisdiccion;
    }

    public Integer getRissId() {
        return rissId;
    }

    public void setRissId(Integer rissId) {
        this.rissId = rissId;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public Integer getIdClues() {
        return idClues;
    }

    public void setIdClues(Integer idClues) {
        this.idClues = idClues;
    }

    public String getClues() {
        return clues;
    }

    public void setClues(String clues) {
        this.clues = clues;
    }

    public String getCalleUnidad() {
        return calleUnidad;
    }

    public void setCalleUnidad(String calleUnidad) {
        this.calleUnidad = calleUnidad;
    }

    public String getTipoAsentamiento() {
        return tipoAsentamiento;
    }

    public void setTipoAsentamiento(String tipoAsentamiento) {
        this.tipoAsentamiento = tipoAsentamiento;
    }

    public String getColoniaUnidad() {
        return coloniaUnidad;
    }

    public void setColoniaUnidad(String coloniaUnidad) {
        this.coloniaUnidad = coloniaUnidad;
    }

    public String getNumeroExtU() {
        return numeroExtU;
    }

    public void setNumeroExtU(String numeroExtU) {
        this.numeroExtU = numeroExtU;
    }

    public String getNumeroIntI() {
        return numeroIntI;
    }

    public void setNumeroIntI(String numeroIntI) {
        this.numeroIntI = numeroIntI;
    }

    public String getDireccionEstado() {
        return direccionEstado;
    }

    public void setDireccionEstado(String direccionEstado) {
        this.direccionEstado = direccionEstado;
    }

    public String getEntidadU() {
        return entidadU;
    }

    public void setEntidadU(String entidadU) {
        this.entidadU = entidadU;
    }

    public String getMunicipioU() {
        return municipioU;
    }

    public void setMunicipioU(String municipioU) {
        this.municipioU = municipioU;
    }

    public String getLocalidadU() {
        return localidadU;
    }

    public void setLocalidadU(String localidadU) {
        this.localidadU = localidadU;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getNombreJurisdiccion() {
        return nombreJurisdiccion;
    }

    public void setNombreJurisdiccion(String nombreJurisdiccion) {
        this.nombreJurisdiccion = nombreJurisdiccion;
    }

    public String getTipoEstablecimientoU() {
        return tipoEstablecimientoU;
    }

    public void setTipoEstablecimientoU(String tipoEstablecimientoU) {
        this.tipoEstablecimientoU = tipoEstablecimientoU;
    }

    public String getNivelAtencion() {
        return nivelAtencion;
    }

    public void setNivelAtencion(String nivelAtencion) {
        this.nivelAtencion = nivelAtencion;
    }

    public String getTelefonoU() {
        return telefonoU;
    }

    public void setTelefonoU(String telefonoU) {
        this.telefonoU = telefonoU;
    }

    public String getCorreoU() {
        return correoU;
    }

    public void setCorreoU(String correoU) {
        this.correoU = correoU;
    }

    public String getLicenciaSanitariaU() {
        return licenciaSanitariaU;
    }

    public void setLicenciaSanitariaU(String licenciaSanitariaU) {
        this.licenciaSanitariaU = licenciaSanitariaU;
    }

    public Integer getIdTipoHospsital() {
        return idTipoHospsital;
    }

    public void setIdTipoHospsital(Integer idTipoHospsital) {
        this.idTipoHospsital = idTipoHospsital;
    }

    public Integer getNseTipoHospital() {
        return nseTipoHospital;
    }

    public void setNseTipoHospital(Integer nseTipoHospital) {
        this.nseTipoHospital = nseTipoHospital;
    }

    public CatEstadoJurisdiccion getCatEstadoJurisdiccion() {
        return catEstadoJurisdiccion;
    }

    public void setCatEstadoJurisdiccion(CatEstadoJurisdiccion catEstadoJurisdiccion) {
        this.catEstadoJurisdiccion = catEstadoJurisdiccion;
    }

    public CatTipoEstablecimiento getCatTipoEstablecimiento() {
        return catTipoEstablecimiento;
    }

    public void setCatTipoEstablecimiento(CatTipoEstablecimiento catTipoEstablecimiento) {
        this.catTipoEstablecimiento = catTipoEstablecimiento;
    }

    public CatTipoServ getCatTipoServ() {
        return catTipoServ;
    }

    public void setCatTipoServ(CatTipoServ catTipoServ) {
        this.catTipoServ = catTipoServ;
    }

    public CatVialidad getCatVialidad() {
        return catVialidad;
    }

    public void setCatVialidad(CatVialidad catVialidad) {
        this.catVialidad = catVialidad;
    }

    public CatJurisdiccion getCatJurisdiccion() {
        return catJurisdiccion;
    }

    public void setCatJurisdiccion(CatJurisdiccion catJurisdiccion) {
        this.catJurisdiccion = catJurisdiccion;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }


    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClueId() {
        return clueId;
    }

    public void setClueId(String clueId) {
        this.clueId = clueId;
    }

    public String getCveInstSalud() {
        return cveInstSalud;
    }

    public void setCveInstSalud(String cveInstSalud) {
        this.cveInstSalud = cveInstSalud;
    }

    public String getCveCtaInstSalud() {
        return cveCtaInstSalud;
    }

    public void setCveCtaInstSalud(String cveCtaInstSalud) {
        this.cveCtaInstSalud = cveCtaInstSalud;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoExt() {
        return noExt;
    }

    public void setNoExt(String noExt) {
        this.noExt = noExt;
    }

    public String getNoInt() {
        return noInt;
    }

    public void setNoInt(String noInt) {
        this.noInt = noInt;
    }

    public String getEstadoCve() {
        return estadoCve;
    }

    public void setEstadoCve(String estadoCve) {
        this.estadoCve = estadoCve;
    }

    public String getMunicipioCve() {
        return municipioCve;
    }

    public void setMunicipioCve(String municipioCve) {
        this.municipioCve = municipioCve;
    }

    public String getColoniaCve() {
        return coloniaCve;
    }

    public void setColoniaCve(String coloniaCve) {
        this.coloniaCve = coloniaCve;
    }

    public String getLocalidadCve() {
        return localidadCve;
    }

    public void setLocalidadCve(String localidadCve) {
        this.localidadCve = localidadCve;
    }

    public String getCpCve() {
        return cpCve;
    }

    public void setCpCve(String cpCve) {
        this.cpCve = cpCve;
    }

    public String getLada() {
        return lada;
    }

    public void setLada(String lada) {
        this.lada = lada;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioCve() {
        return usuarioCve;
    }

    public void setUsuarioCve(String usuarioCve) {
        this.usuarioCve = usuarioCve;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Integer getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(Integer tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public String getClaveDependencia() {
        return claveDependencia;
    }

    public void setClaveDependencia(String claveDependencia) {
        this.claveDependencia = claveDependencia;
    }

    public Integer getIdjurisdiccion() {
        return idjurisdiccion;
    }

    public void setIdjurisdiccion(Integer idjurisdiccion) {
        this.idjurisdiccion = idjurisdiccion;
    }

    public Integer getIdEstadoJurisdiccion() {
        return idEstadoJurisdiccion;
    }

    public void setIdEstadoJurisdiccion(Integer idEstadoJurisdiccion) {
        this.idEstadoJurisdiccion = idEstadoJurisdiccion;
    }

    public Integer getIdtipoUnidadMedica() {
        return idtipoUnidadMedica;
    }

    public void setIdtipoUnidadMedica(Integer idtipoUnidadMedica) {
        this.idtipoUnidadMedica = idtipoUnidadMedica;
    }



    public Integer getIdvialidad() {
        return idvialidad;
    }

    public void setIdvialidad(Integer idvialidad) {
        this.idvialidad = idvialidad;
    }

    public String getNombreVialidad() {
        return nombreVialidad;
    }

    public void setNombreVialidad(String nombreVialidad) {
        this.nombreVialidad = nombreVialidad;
    }

    public Integer getTipoAsen() {
        return tipoAsen;
    }

    public void setTipoAsen(Integer tipoAsen) {
        this.tipoAsen = tipoAsen;
    }

    public String getClaveOid() {
        return claveOid;
    }

    public void setClaveOid(String claveOid) {
        this.claveOid = claveOid;
    }

    public String getLicenciaSanitaria() {
        return licenciaSanitaria;
    }

    public void setLicenciaSanitaria(String licenciaSanitaria) {
        this.licenciaSanitaria = licenciaSanitaria;
    }

    public String getNombreAsentamiento() {
        return nombreAsentamiento;
    }

    public void setNombreAsentamiento(String nombreAsentamiento) {
        this.nombreAsentamiento = nombreAsentamiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public Integer getIdTipoUnidadPsiq() {
        return idTipoUnidadPsiq;
    }

    public void setIdTipoUnidadPsiq(Integer idTipoUnidadPsiq) {
        this.idTipoUnidadPsiq = idTipoUnidadPsiq;
    }

    public Integer getSerHospContinuoId() {
        return serHospContinuoId;
    }

    public void setSerHospContinuoId(Integer serHospContinuoId) {
        this.serHospContinuoId = serHospContinuoId;
    }

    public Integer getSerHospParcialId() {
        return serHospParcialId;
    }

    public void setSerHospParcialId(Integer serHospParcialId) {
        this.serHospParcialId = serHospParcialId;
    }


    public AdmEdificio getAdmEdificio() {
        return admEdificio;
    }

    public void setAdmEdificio(AdmEdificio admEdificio) {
        this.admEdificio = admEdificio;
    }

    public String getNombrejurisdiccion() {
        return nombrejurisdiccion;
    }

    public void setNombrejurisdiccion(String nombrejurisdiccion) {
        this.nombrejurisdiccion = nombrejurisdiccion;
    }

    public String getCveJurisdiccion() {
        return cveJurisdiccion;
    }

    public void setCveJurisdiccion(String cveJurisdiccion) {
        this.cveJurisdiccion = cveJurisdiccion;
    }

    public Integer getIdTipoEstablecimiento() {
        return idTipoEstablecimiento;
    }

    public void setIdTipoEstablecimiento(Integer idTipoEstablecimiento) {
        this.idTipoEstablecimiento = idTipoEstablecimiento;
    }

    public String getJurisdiccionCve() {
        return jurisdiccionCve;
    }

    public void setJurisdiccionCve(String jurisdiccionCve) {
        this.jurisdiccionCve = jurisdiccionCve;
    }


    public String getTiposervicioNombre() {
        return tiposervicioNombre;
    }

    public void setTiposervicioNombre(String tiposervicioNombre) {
        this.tiposervicioNombre = tiposervicioNombre;
    }

    public String getNoExtLetra() {
        return noExtLetra;
    }

    public void setNoExtLetra(String noExtLetra) {
        this.noExtLetra = noExtLetra;
    }

    public String getNoIntLetra() {
        return noIntLetra;
    }

    public void setNoIntLetra(String noIntLetra) {
        this.noIntLetra = noIntLetra;
    }

    public Integer getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(Integer configuraciones) {
        this.configuraciones = configuraciones;
    }

    public List<AdmLogosDTO> getAdmLogosDTO() {
        return admLogosDTO;
    }

    public void setAdmLogosDTO(List<AdmLogosDTO> admLogosDTO) {
        this.admLogosDTO = admLogosDTO;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
