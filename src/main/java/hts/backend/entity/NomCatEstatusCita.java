package hts.backend.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "nom_cat_estatus_cita")
public class NomCatEstatusCita implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer estatusCitaId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer indicaDefault;
	private Integer estatus;
	private String usuarioRegistro;
	private Date fechaRegistro;

	public NomCatEstatusCita() {
	}

	public NomCatEstatusCita(Integer estatusCitaId) {
		this.estatusCitaId = estatusCitaId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESTATUS_CITA_ID", unique = true, nullable = false, precision = 22)
	public Integer getEstatusCitaId() {
		return this.estatusCitaId;
	}

	public void setEstatusCitaId(Integer estatusCitaId) {
		this.estatusCitaId = estatusCitaId;
	}


	@Basic
	@Column(name = "CVE", nullable = false, length = 10)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Basic
	@Column(name = "NOMBRE", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Basic
	@Column(name = "DESCRIPCION", length = 30)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Basic
	@Column(name = "VALOR_DEFAULT", nullable = false)
	public Integer getIndicaDefault() {
		return this.indicaDefault;
	}

	public void setIndicaDefault(Integer indicaDefault) {
		this.indicaDefault = indicaDefault;
	}


	@Basic
	@Column(name = "ESTATUS", nullable = false)
	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	@Basic
	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistra) {
		this.usuarioRegistro = usuarioRegistra;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Basic
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}
