package hts.backend.model.dto;

import java.util.Date;
import java.util.Objects;

public class PacienteLargoDTO {

    private Integer idPaciente;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer sexo_id;
    private Date fechaNacimiento;
    private String curp;
    private Integer desconoceCurp;
    private Integer nacionalidad_id;
    private Integer migrante;
    private Integer entidadNacimiento_id;
    private Integer municipioNacimiento_id;
    private String entidadNacimiento_cve;
    private String municipioNacimiento_cve;
    private Integer procedencia_id;
    private Integer religion_id;
    private Integer estadoCivil_id;
    private Integer ocupacion_id;
    private Integer escolaridad_id;
    private Integer trabajaActualmente_id;
    private Integer indigena_id;
    private Integer tipoLenguaIndigena_id;
    private Integer hablaIndigena_id;
    private Integer hablaEspanol_id;
    private String tipoSangre;
    private Integer factorRH;
    private Date fechaIdTipoSangre;
    
    private String fotoPaciente;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getSexo_id() {
        return sexo_id;
    }

    public void setSexo_id(Integer sexo_id) {
        this.sexo_id = sexo_id;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Integer getDesconoceCurp() {
        return desconoceCurp;
    }

    public void setDesconoceCurp(Integer desconoceCurp) {
        this.desconoceCurp = desconoceCurp;
    }

    public Integer getNacionalidad_id() {
        return nacionalidad_id;
    }

    public void setNacionalidad_id(Integer nacionalidad_id) {
        this.nacionalidad_id = nacionalidad_id;
    }

    public Integer getMigrante() {
        return migrante;
    }

    public void setMigrante(Integer migrante) {
        this.migrante = migrante;
    }

    public Integer getEntidadNacimiento_id() {
        return entidadNacimiento_id;
    }

    public void setEntidadNacimiento_id(Integer entidadNacimiento_id) {
        this.entidadNacimiento_id = entidadNacimiento_id;
    }

    public Integer getMunicipioNacimiento_id() {
        return municipioNacimiento_id;
    }

    public void setMunicipioNacimiento_id(Integer municipioNacimiento_id) {
        this.municipioNacimiento_id = municipioNacimiento_id;
    }

    public Integer getProcedencia_id() {
        return procedencia_id;
    }

    public void setProcedencia_id(Integer procedencia_id) {
        this.procedencia_id = procedencia_id;
    }

    public Integer getReligion_id() {
        return religion_id;
    }

    public void setReligion_id(Integer religion_id) {
        this.religion_id = religion_id;
    }

    public Integer getEstadoCivil_id() {
        return estadoCivil_id;
    }

    public void setEstadoCivil_id(Integer estadoCivil_id) {
        this.estadoCivil_id = estadoCivil_id;
    }

    public Integer getOcupacion_id() {
        return ocupacion_id;
    }

    public void setOcupacion_id(Integer ocupacion_id) {
        this.ocupacion_id = ocupacion_id;
    }

    public Integer getEscolaridad_id() {
        return escolaridad_id;
    }

    public void setEscolaridad_id(Integer escolaridad_id) {
        this.escolaridad_id = escolaridad_id;
    }

    public Integer getTrabajaActualmente_id() {
        return trabajaActualmente_id;
    }

    public void setTrabajaActualmente_id(Integer trabajaActualmente_id) {
        this.trabajaActualmente_id = trabajaActualmente_id;
    }

    public Integer getIndigena_id() {
        return indigena_id;
    }

    public void setIndigena_id(Integer indigena_id) {
        this.indigena_id = indigena_id;
    }

    public Integer getTipoLenguaIndigena_id() {
        return tipoLenguaIndigena_id;
    }

    public void setTipoLenguaIndigena_id(Integer tipoLenguaIndigena_id) {
        this.tipoLenguaIndigena_id = tipoLenguaIndigena_id;
    }

    public Integer getHablaIndigena_id() {
        return hablaIndigena_id;
    }

    public void setHablaIndigena_id(Integer hablaIndigena_id) {
        this.hablaIndigena_id = hablaIndigena_id;
    }

    public Integer getHablaEspanol_id() {
        return hablaEspanol_id;
    }

    public void setHablaEspanol_id(Integer hablaEspanol_id) {
        this.hablaEspanol_id = hablaEspanol_id;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Integer getFactorRH() {
        return factorRH;
    }

    public void setFactorRH(Integer factorRH) {
        this.factorRH = factorRH;
    }

    public Date getFechaIdTipoSangre() {
        return fechaIdTipoSangre;
    }

    public void setFechaIdTipoSangre(Date fechaIdTipoSangre) {
        this.fechaIdTipoSangre = fechaIdTipoSangre;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PacienteLargoDTO)) return false;
        PacienteLargoDTO that = (PacienteLargoDTO) o;
        return Objects.equals(getIdPaciente(), that.getIdPaciente()) && Objects.equals(getNombre(), that.getNombre()) && Objects.equals(getPrimerApellido(), that.getPrimerApellido()) && Objects.equals(getSegundoApellido(), that.getSegundoApellido()) && Objects.equals(getSexo_id(), that.getSexo_id()) && Objects.equals(getFechaNacimiento(), that.getFechaNacimiento()) && Objects.equals(getCurp(), that.getCurp()) && Objects.equals(getDesconoceCurp(), that.getDesconoceCurp()) && Objects.equals(getNacionalidad_id(), that.getNacionalidad_id()) && Objects.equals(getMigrante(), that.getMigrante()) && Objects.equals(getEntidadNacimiento_id(), that.getEntidadNacimiento_id()) && Objects.equals(getMunicipioNacimiento_id(), that.getMunicipioNacimiento_id()) && Objects.equals(getProcedencia_id(), that.getProcedencia_id()) && Objects.equals(getReligion_id(), that.getReligion_id()) && Objects.equals(getEstadoCivil_id(), that.getEstadoCivil_id()) && Objects.equals(getOcupacion_id(), that.getOcupacion_id()) && Objects.equals(getEscolaridad_id(), that.getEscolaridad_id()) && Objects.equals(getTrabajaActualmente_id(), that.getTrabajaActualmente_id()) && Objects.equals(getIndigena_id(), that.getIndigena_id()) && Objects.equals(getTipoLenguaIndigena_id(), that.getTipoLenguaIndigena_id()) && Objects.equals(getHablaIndigena_id(), that.getHablaIndigena_id()) && Objects.equals(getHablaEspanol_id(), that.getHablaEspanol_id()) && Objects.equals(getTipoSangre(), that.getTipoSangre()) && Objects.equals(getFactorRH(), that.getFactorRH()) && Objects.equals(getFechaIdTipoSangre(), that.getFechaIdTipoSangre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPaciente(), getNombre(), getPrimerApellido(), getSegundoApellido(), getSexo_id(), getFechaNacimiento(), getCurp(), getDesconoceCurp(), getNacionalidad_id(), getMigrante(), getEntidadNacimiento_id(), getMunicipioNacimiento_id(), getProcedencia_id(), getReligion_id(), getEstadoCivil_id(), getOcupacion_id(), getEscolaridad_id(), getTrabajaActualmente_id(), getIndigena_id(), getTipoLenguaIndigena_id(), getHablaIndigena_id(), getHablaEspanol_id(), getTipoSangre(), getFactorRH(), getFechaIdTipoSangre());
    }
   

    public String getFotoPaciente() {
		return fotoPaciente;
	}

	public void setFotoPaciente(String fotoPaciente) {
		this.fotoPaciente = fotoPaciente;
	}
	
	

	public String getEntidadNacimiento_cve() {
		return entidadNacimiento_cve;
	}

	public void setEntidadNacimiento_cve(String entidadNacimiento_cve) {
		this.entidadNacimiento_cve = entidadNacimiento_cve;
	}

	public String getMunicipioNacimiento_cve() {
		return municipioNacimiento_cve;
	}

	public void setMunicipioNacimiento_cve(String municipioNacimiento_cve) {
		this.municipioNacimiento_cve = municipioNacimiento_cve;
	}


}
