package hts.backend.entity;
// Generated 16/03/2017 01:24:09 PM by Hibernate Tools 5.2.0.Beta1

import java.util.Date;
import javax.persistence.*;

import hts.backend.entity.AdmUsuario;

/**
 * AdmHistorico generated by hbm2java
 */
@Entity
@Table(name = "adm_historico")
public class AdmHistorico implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer historicoId;
	private AdmUsuario admUsuario;
	private String password;
	private Date fechaRegistro;

	public AdmHistorico() {
	}

	public AdmHistorico(Integer historicoId, AdmUsuario admUsuario) {
		this.historicoId = historicoId;
		this.admUsuario = admUsuario;
	}

	public AdmHistorico(Integer historicoId, AdmUsuario admUsuario, String password, Date fechaRegistro) {
		this.historicoId = historicoId;
		this.admUsuario = admUsuario;
		this.password = password;
		this.fechaRegistro = fechaRegistro;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HISTORICO_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getHistoricoId() {
		return this.historicoId;
	}

	public void setHistoricoId(Integer historicoId) {
		this.historicoId = historicoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIO_ID", nullable = false)
	public AdmUsuario getAdmUsuario() {
		return this.admUsuario;
	}

	public void setAdmUsuario(AdmUsuario admUsuario) {
		this.admUsuario = admUsuario;
	}

	@Column(name = "PASSWORD", length = 150)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
