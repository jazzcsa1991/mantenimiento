package hts.backend.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
        name = "nom_cat_clues"
)
public class CatClues implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idClues;
    private String clues;
    private String cveInstitucionSalud;
    private String nombreInstitucionSalud;
    private String cveEntidad;
    private String nombreEntidad;
    private String cveJurisdiccion;
    private String nombreJurisdiccion;
    private String cveMunicipio;
    private String nombreMunicipio;
    private String cveLocalidad;
    private String nombreLocalidad;
    private String cvercve;
    private String cinscve;
    private String ctuncve;
    private String ccomcve;
    private String cveTipoEstablecimiento;
    private String nombreTipoEstablecimiento;
    private String cveTipologia;
    private String nombreTipologia;
    private String nombreUnidad;
    private String domicilio;
    private String colonia;
    private String numeroInterior;
    private String numeroExterior;
    private String codigoPostal;
    private String cortaEstancia;
    private String cveEstatusUnidad;
    private String estatusUnidad;
    private String cveNivelAtencion;
    private String nivelAtencion;
    private String lada;
    private String telefono;
    private String correoElectronico;
    private Set<AdmPersonalDatos> admProfSaludDataprofsForCluesAdscripNominaId = new HashSet(0);
    private Set<AdmPersonalDatos> admProfSaludDataprofsForCluesAdscripRealId = new HashSet(0);

    public CatClues() {
    }

    public CatClues(String idClues) {
        this.idClues = idClues;
    }

    @Id
    @Column(
            name = "ID_CLUES",
            unique = true,
            nullable = false,
            length = 20
    )
    public String getIdClues() {
        return this.idClues;
    }

    public void setIdClues(String idClues) {
        this.idClues = idClues;
    }

    @Column(
            name = "CLUES",
            length = 20
    )
    public String getClues() {
        return this.clues;
    }

    public void setClues(String clues) {
        this.clues = clues;
    }

    @Column(
            name = "CVE_INSTITUCION_SALUD",
            length = 13
    )
    public String getCveInstitucionSalud() {
        return this.cveInstitucionSalud;
    }

    public void setCveInstitucionSalud(String cveInstitucionSalud) {
        this.cveInstitucionSalud = cveInstitucionSalud;
    }

    @Column(
            name = "NOMBRE_INSTITUCION_SALUD",
            length = 100
    )
    public String getNombreInstitucionSalud() {
        return this.nombreInstitucionSalud;
    }

    public void setNombreInstitucionSalud(String nombreInstitucionSalud) {
        this.nombreInstitucionSalud = nombreInstitucionSalud;
    }

    @Column(
            name = "CVE_ENTIDAD",
            length = 5
    )
    public String getCveEntidad() {
        return this.cveEntidad;
    }

    public void setCveEntidad(String cveEntidad) {
        this.cveEntidad = cveEntidad;
    }

    @Column(
            name = "NOMBRE_ENTIDAD",
            length = 100
    )
    public String getNombreEntidad() {
        return this.nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    @Column(
            name = "CVE_JURISDICCION",
            length = 5
    )
    public String getCveJurisdiccion() {
        return this.cveJurisdiccion;
    }

    public void setCveJurisdiccion(String cveJurisdiccion) {
        this.cveJurisdiccion = cveJurisdiccion;
    }

    @Column(
            name = "NOMBRE_JURISDICCION",
            length = 100
    )
    public String getNombreJurisdiccion() {
        return this.nombreJurisdiccion;
    }

    public void setNombreJurisdiccion(String nombreJurisdiccion) {
        this.nombreJurisdiccion = nombreJurisdiccion;
    }

    @Column(
            name = "CVE_MUNICIPIO",
            length = 5
    )
    public String getCveMunicipio() {
        return this.cveMunicipio;
    }

    public void setCveMunicipio(String cveMunicipio) {
        this.cveMunicipio = cveMunicipio;
    }

    @Column(
            name = "NOMBRE_MUNICIPIO",
            length = 100
    )
    public String getNombreMunicipio() {
        return this.nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    @Column(
            name = "CVE_LOCALIDAD",
            length = 5
    )
    public String getCveLocalidad() {
        return this.cveLocalidad;
    }

    public void setCveLocalidad(String cveLocalidad) {
        this.cveLocalidad = cveLocalidad;
    }

    @Column(
            name = "NOMBRE_LOCALIDAD",
            length = 100
    )
    public String getNombreLocalidad() {
        return this.nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    @Column(
            name = "CVE_TIPO_ESTABLECIMIENTO",
            length = 5
    )
    public String getCveTipoEstablecimiento() {
        return this.cveTipoEstablecimiento;
    }

    public void setCveTipoEstablecimiento(String cveTipoEstablecimiento) {
        this.cveTipoEstablecimiento = cveTipoEstablecimiento;
    }

    @Column(
            name = "NOMBRE_TIPO_ESTABLECIMIENTO",
            length = 100
    )
    public String getNombreTipoEstablecimiento() {
        return this.nombreTipoEstablecimiento;
    }

    public void setNombreTipoEstablecimiento(String nombreTipoEstablecimiento) {
        this.nombreTipoEstablecimiento = nombreTipoEstablecimiento;
    }

    @Column(
            name = "CVE_TIPOLOGIA",
            length = 5
    )
    public String getCveTipologia() {
        return this.cveTipologia;
    }

    public void setCveTipologia(String cveTipologia) {
        this.cveTipologia = cveTipologia;
    }

    @Column(
            name = "NOMBRE_TIPOLOGIA",
            length = 150
    )
    public String getNombreTipologia() {
        return this.nombreTipologia;
    }

    public void setNombreTipologia(String nombreTipologia) {
        this.nombreTipologia = nombreTipologia;
    }

    @Column(
            name = "NOMBRE_UNIDAD",
            length = 150
    )
    public String getNombreUnidad() {
        return this.nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    @Column(
            name = "VIALIDAD",
            length = 500
    )
    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Column(
            name = "ASENTAMIENTO",
            length = 150
    )
    public String getColonia() {
        return this.colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Column(
            name = "NUMERO_INTERIOR",
            length = 50
    )
    public String getNumeroInterior() {
        return this.numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    @Column(
            name = "NUMERO_EXTERIOR",
            length = 50
    )
    public String getNumeroExterior() {
        return this.numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    @Column(
            name = "CODIGO_POSTAL",
            length = 5
    )
    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Column(
            name = "CVE_ESTATUS_OPERACION",
            length = 5
    )
    public String getCveEstatusUnidad() {
        return this.cveEstatusUnidad;
    }

    public void setCveEstatusUnidad(String cveEstatusUnidad) {
        this.cveEstatusUnidad = cveEstatusUnidad;
    }

    @Column(
            name = "ESTATUS_OPERACION",
            length = 100
    )
    public String getEstatusUnidad() {
        return this.estatusUnidad;
    }

    public void setEstatusUnidad(String estatusUnidad) {
        this.estatusUnidad = estatusUnidad;
    }

    @Column(
            name = "CVE_NIVEL_ATENCION",
            length = 5
    )
    public String getCveNivelAtencion() {
        return this.cveNivelAtencion;
    }

    public void setCveNivelAtencion(String cveNivelAtencion) {
        this.cveNivelAtencion = cveNivelAtencion;
    }

    @Column(
            name = "NIVEL_ATENCION",
            length = 50
    )
    public String getNivelAtencion() {
        return this.nivelAtencion;
    }

    public void setNivelAtencion(String nivelAtencion) {
        this.nivelAtencion = nivelAtencion;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "catCluesByCluesAdscripNominaId"
    )
    public Set<AdmPersonalDatos> getAdmProfSaludDataprofsForCluesAdscripNominaId() {
        return this.admProfSaludDataprofsForCluesAdscripNominaId;
    }

    public void setAdmProfSaludDataprofsForCluesAdscripNominaId(Set<AdmPersonalDatos> admProfSaludDataprofsForCluesAdscripNominaId) {
        this.admProfSaludDataprofsForCluesAdscripNominaId = admProfSaludDataprofsForCluesAdscripNominaId;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "catCluesByCluesAdscripRealId"
    )
    public Set<AdmPersonalDatos> getAdmProfSaludDataprofsForCluesAdscripRealId() {
        return this.admProfSaludDataprofsForCluesAdscripRealId;
    }

    public void setAdmProfSaludDataprofsForCluesAdscripRealId(Set<AdmPersonalDatos> admProfSaludDataprofsForCluesAdscripRealId) {
        this.admProfSaludDataprofsForCluesAdscripRealId = admProfSaludDataprofsForCluesAdscripRealId;
    }
}
