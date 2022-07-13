package hts.backend.entity;

import hts.backend.entity.CorePceConfirmaciones;
import hts.backend.entity.AdmHospital;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * Created by SASA Desarrollo on 04/08/2017.
 */
@Entity
@Table(name = "adm_turnos")
public class AdmTurnos implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private AdmHospital admHospital;
	private Integer turnosId;
	private String nombre;
	private Integer horaInicio;
	private Integer horaFin;
	private Integer minutosInicio;
	private Integer minutosFin;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Set<CorePceConfirmaciones> corePceConfirmaciones;
	private Integer tipoTurno;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TURNOS_ID") public Integer getTurnosId() {
		return turnosId;
	}

	public void setTurnosId(Integer turnosId) {
		this.turnosId = turnosId;
	}

	@Basic @Column(name = "NOMBRE") public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "HORA_INICIO") public Integer getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Integer horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Basic @Column(name = "HORA_FIN") public Integer getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Integer horaFin) {
		this.horaFin = horaFin;
	}

	@Basic @Column(name = "MINUTOS_INICIO") public Integer getMinutosInicio() {
		return minutosInicio;
	}

	public void setMinutosInicio(Integer minutosInicio) {
		this.minutosInicio = minutosInicio;
	}

	@Basic @Column(name = "MINUTOS_FIN") public Integer getMinutosFin() {
		return minutosFin;
	}

	public void setMinutosFin(Integer minutosFin) {
		this.minutosFin = minutosFin;
	}

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOSPITAL_ID")
	public AdmHospital getAdmHospital() {
		return this.admHospital;
	}

	public void setAdmHospital(AdmHospital admHospital) {
		this.admHospital = admHospital;
	}

	@OneToMany(mappedBy = "admTurnos")
	public Set<CorePceConfirmaciones> getCorePceConfirmaciones() {
		return corePceConfirmaciones;
	}

	public void setCorePceConfirmaciones(Set<CorePceConfirmaciones> corePceConfirmaciones) {
		this.corePceConfirmaciones = corePceConfirmaciones;
	}
	@Basic @Column(name = "TIPO_TURNO")

	public Integer getTipoTurno() {
		return tipoTurno;
	}

	public void setTipoTurno(Integer tipoTurno) {
		this.tipoTurno = tipoTurno;
	}
}
