package hts.backend.model.dto;

import java.util.Date;
import java.util.Objects;

public class PacienteDesconocidoDTO {
//    private String noPaciente;
//    private String noExpediente;
//    private String tipoExpediente;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private Integer sexo_id;
    private Float peso;
    private Float talla;
//    private Integer procedencia_id;
//    private String notasPaciente;
    private String telefono;
    private Integer tipoTel_id;

//    public String getNoPaciente() {
//        return noPaciente;
//    }
//
//    public void setNoPaciente(String noPaciente) {
//        this.noPaciente = noPaciente;
//    }
//
//    public String getNoExpediente() {
//        return noExpediente;
//    }

//    public void setNoExpediente(String noExpediente) {
//        this.noExpediente = noExpediente;
//    }
//
//    public String getTipoExpediente() {
//        return tipoExpediente;
//    }
//
//    public void setTipoExpediente(String tipoExpediente) {
//        this.tipoExpediente = tipoExpediente;
//    }

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

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getTalla() {
        return talla;
    }

    public void setTalla(Float talla) {
        this.talla = talla;
    }

//    public Integer getProcedencia_id() {
//        return procedencia_id;
//    }
//
//    public void setProcedencia_id(Integer procedencia_id) {
//        this.procedencia_id = procedencia_id;
//    }
//
//    public String getNotasPaciente() {
//        return notasPaciente;
//    }
//
//    public void setNotasPaciente(String notasPaciente) {
//        this.notasPaciente = notasPaciente;
//    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getTipoTel_id() {
        return tipoTel_id;
    }

    public void setTipoTel_id(Integer tipoTel_id) {
        this.tipoTel_id = tipoTel_id;
    }
    
    

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PacienteDesconocidoDTO)) return false;
//        PacienteDesconocidoDTO that = (PacienteDesconocidoDTO) o;
//        return Objects.equals(getNoPaciente(), that.getNoPaciente()) && Objects.equals(getNoExpediente(), that.getNoExpediente()) && Objects.equals(getTipoExpediente(), that.getTipoExpediente()) && Objects.equals(getNombre(), that.getNombre()) && Objects.equals(getPrimerApellido(), that.getPrimerApellido()) && Objects.equals(getSegundoApellido(), that.getSegundoApellido()) && Objects.equals(getSexo_id(), that.getSexo_id()) && Objects.equals(getPeso(), that.getPeso()) && Objects.equals(getTalla(), that.getTalla()) && Objects.equals(getProcedencia_id(), that.getProcedencia_id()) && Objects.equals(getNotasPaciente(), that.getNotasPaciente()) && Objects.equals(getTelefono(), that.getTelefono()) && Objects.equals(getTipoTel_id(), that.getTipoTel_id());
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(getNoPaciente(), getNoExpediente(), getTipoExpediente(), getNombre(), getPrimerApellido(), getSegundoApellido(), getSexo_id(), getPeso(), getTalla(), getProcedencia_id(), getNotasPaciente(), getTelefono(), getTipoTel_id());
//    }

    public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
    public String toString() {
        return "PacienteDesconocidoDTO{" +
//                "noPaciente='" + noPaciente + '\'' +
//                ", noExpediente='" + noExpediente + '\'' +
//                ", tipoExpediente='" + tipoExpediente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", sexo_id=" + sexo_id +
                ", peso=" + peso +
                ", talla=" + talla +
//                ", procedencia_id=" + procedencia_id +
//                ", notasPaciente='" + notasPaciente + '\'' +
                ", telefono=" + telefono +
                ", tipoTel_id=" + tipoTel_id +
                '}';
    }
}
