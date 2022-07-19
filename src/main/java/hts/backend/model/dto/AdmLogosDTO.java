package hts.backend.model.dto;


import java.util.Date;
//import java.util.Date;
//import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AdmLogosDTO {

    private Integer logosId;

    private String nombre;

    private String imagen;

    private Integer posicion;

    private Integer estatus;

    private Integer hospitalId;

    private Date fechaRegistro;

    private String usuarioRegistro;

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
    public Integer getLogosId() {
        return logosId;
    }

    public void setLogosId(Integer logosId) {
        this.logosId = logosId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;

    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


}
