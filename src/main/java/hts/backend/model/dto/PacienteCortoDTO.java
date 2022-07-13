package hts.backend.model.dto;

import java.util.Date;
import java.util.Objects;

public class PacienteCortoDTO {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer sexo_id;
    private Date fechaNacimiento;
    private Integer entidadNacimiento_id;
    private Integer municipioNacimiento_id;
    private String curp;
    private String telCasa;
    private String telCelular;
    private String email;
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getTelCasa() {
        return telCasa;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFotoPaciente() {
		return fotoPaciente;
	}

	public void setFotoPaciente(String fotoPaciente) {
		this.fotoPaciente = fotoPaciente;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PacienteCortoDTO)) return false;
        PacienteCortoDTO that = (PacienteCortoDTO) o;
        return Objects.equals(getNombre(), that.getNombre()) && Objects.equals(getPrimerApellido(), that.getPrimerApellido()) && Objects.equals(getSegundoApellido(), that.getSegundoApellido()) && Objects.equals(getSexo_id(), that.getSexo_id()) && Objects.equals(getFechaNacimiento(), that.getFechaNacimiento()) && Objects.equals(getEntidadNacimiento_id(), that.getEntidadNacimiento_id()) && Objects.equals(getMunicipioNacimiento_id(), that.getMunicipioNacimiento_id()) && Objects.equals(getCurp(), that.getCurp()) && Objects.equals(getTelCasa(), that.getTelCasa()) && Objects.equals(getTelCelular(), that.getTelCelular()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getPrimerApellido(), getSegundoApellido(), getSexo_id(), getFechaNacimiento(), getEntidadNacimiento_id(), getMunicipioNacimiento_id(), getCurp(), getTelCasa(), getTelCelular(), getEmail());
    }

    @Override
    public String toString() {
        return "PacienteCortoDTO{" +
                "nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", sexo_id=" + sexo_id +
                ", fechaNacimiento=" + fechaNacimiento +
                ", entidadNacimiento_id=" + entidadNacimiento_id +
                ", municipioNacimiento_id=" + municipioNacimiento_id +
                ", curp='" + curp + '\'' +
                ", telCasa='" + telCasa + '\'' +
                ", telCelular='" + telCelular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
