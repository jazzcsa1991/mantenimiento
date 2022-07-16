package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "nom_cat_circun_defuncion")
public class NomCatCircunDefuncion implements Serializable {

	private Integer circunstaciaDefuncionId;
	private String nombre;
	private String descripcion;
	private Boolean valorDefault;
	private Integer estatus;
	private String cve;
	private String usuarioRegistro;
	private Date fechaRegistro;

	@Id @Column(name = "CIRCUNSTANCIA_DEFUNCION_ID", nullable = false) public Integer getCircunstaciaDefuncionId() {
		return circunstaciaDefuncionId;
	}

	public void setCircunstaciaDefuncionId(Integer circunstaciaDefuncionId) {
		this.circunstaciaDefuncionId = circunstaciaDefuncionId;
	}

	@Basic @Column(name = "NOMBRE", nullable = false, length = 50) public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DESCRIPCION", length = 60) public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "VALOR_DEFAULT", nullable = false) public Boolean getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Boolean valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Basic @Column(name = "ESTATUS", nullable = false) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "CVE", nullable = false, length = 20) public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
