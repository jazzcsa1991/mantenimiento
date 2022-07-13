package hts.backend.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "cat_instrucion_cita")
public class InstruccionCita implements java.io.Serializable {

	/**
	 *
	 */
	private static long serialVersionUID = 1L;

	private Integer instruccionCItaId;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private Date fechaRegistro;
	private String usurarioRegistro;
	private String clave;
	private Set<InstruccionVisita> instruccionVisita = new HashSet<InstruccionVisita>(0);
	public InstruccionCita() {

	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INSTRUCION_CITA_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getInstruccionCItaId() {
		return instruccionCItaId;
	}

	public void setInstruccionCItaId(Integer instruccionCItaId) {
		this.instruccionCItaId = instruccionCItaId;
	}

	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION", length = 50)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "ESTATUS", precision = 1, scale = 0)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO", length = 20)
	public String getUsurarioRegistro() {
		return usurarioRegistro;
	}

	public void setUsurarioRegistro(String usurarioRegistro) {
		this.usurarioRegistro = usurarioRegistro;
	}

	@Column(name = "CVE", precision = 1, scale = 0)
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instruccionCita")
	public Set<InstruccionVisita> getInstruccionVisita() {
		return instruccionVisita;
	}

	public void setInstruccionVisita(Set<InstruccionVisita> instruccionVisita) {
		this.instruccionVisita = instruccionVisita;
	}

}
