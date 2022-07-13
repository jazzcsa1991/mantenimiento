package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nom_cat_tipo_foliador")
public class NomCatTipoFoliador implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tipoFoliadorId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer idiomaAppId;
	private Integer valorDefault;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_FOLIADOR_ID", nullable = false, precision = 0) public Integer getTipoFoliadorId() {
		return tipoFoliadorId;
	}

	public void setTipoFoliadorId(Integer tipoFoliadorId) {
		this.tipoFoliadorId = tipoFoliadorId;
	}

	@Basic @Column(name = "CVE", nullable = false, length = 20) public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "NOMBRE", nullable = false, length = 50) public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DESCRIPCION", nullable = true, length = 100) public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Basic @Column(name = "IDIOMA_APP_ID", nullable = false, precision = 0) public Integer getIdiomaAppId() {
		return idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}

	@Basic @Column(name = "VALOR_DEFAULT", nullable = true, precision = 0) public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

}
