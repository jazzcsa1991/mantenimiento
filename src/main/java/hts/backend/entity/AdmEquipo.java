package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "adm_equipo")
public class AdmEquipo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer equipoId;
	private CatTipoEquipo catTipoEquipo;
	private AdmCentroCosto admCentroCosto;
	private AdmSala admSala;
	private String cve;
	private String noSerie;
	private String nombre;
	private String ncorto;
	private String telefono;
	private String correo;
	private Integer interno;
	private Integer agendaStatus;
	private Integer status;
	private AdmHospital hospitalId;
	private Date fechaRegistro;
	private String usuarioRegistro;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EQUIPO_ID", unique = true, nullable = false)
	public Integer getEquipoId() {
		return this.equipoId;
	}

	public void setEquipoId(Integer equipoId) {
		this.equipoId = equipoId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_EQUIPO_ID")
	public CatTipoEquipo getCatTipoEquipo() {
		return this.catTipoEquipo;
	}

	public void setCatTipoEquipo(CatTipoEquipo catTipoEquipo) {
		this.catTipoEquipo = catTipoEquipo;
	}

	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "CENTRO_COSTO_ID")
	public AdmCentroCosto getAdmCentroCosto() { return this.admCentroCosto; }

	public void setAdmCentroCosto(AdmCentroCosto admCentroCosto) { this.admCentroCosto = admCentroCosto; }

	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "SALA_ID")
	public AdmSala getAdmSala() { return this.admSala; }

	public void setAdmSala(AdmSala admSala) { this.admSala = admSala; }


	@Basic @Column(name = "CVE", length = 20)
	public String getCve() {
		return this.cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}


	@Basic @Column(name = "NO_SERIE", length = 50)
	public String getNoSerie() {
		return this.noSerie;
	}

	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}


	@Basic @Column(name = "NOMBRE", length = 250)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Basic @Column(name = "NCORTO", length = 30)
	public String getNcorto() {
		return this.ncorto;
	}

	public void setNcorto(String ncorto) {
		this.ncorto = ncorto;
	}


	@Basic @Column(name = "TELEFONO", length = 20)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Basic @Column(name = "CORREO", length = 60)
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Basic @Column(name = "INTERNO")
	public Integer getInterno() {
		return this.interno;
	}

	public void setInterno(Integer interno) {
		this.interno = interno;
	}


	@Basic @Column(name = "AGENDA_STATUS")
	public Integer getAgendaStatus() {
		return this.agendaStatus;
	}

	public void setAgendaStatus(Integer agendaStatus) {
		this.agendaStatus = agendaStatus;
	}


	@Basic @Column(name = "ESTATUS")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name = "USUARIO_REGISTRO", nullable = false)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITAL_ID")
	public AdmHospital getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(AdmHospital hospitalId) {
		this.hospitalId = hospitalId;
	}


}
