package hts.backend.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "adm_usuario_profesional")
public class AdmUsuarioProfesional implements java.io.Serializable {
	private static final long serialVersionUID  = 1L;

	private Integer userProfesionalId;
	private AdmPersonal admPersonal;
	private AdmUsuario admUsuario;
	private Date fechaRegistro;
	private String usuario;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_PROFESIONAL_ID", unique = true, nullable = false, precision = 22)
	public Integer getUserProfesionalId() {
		return this.userProfesionalId;
	}

	public void setUserProfesionalId(Integer userProfesionalId) {
		this.userProfesionalId = userProfesionalId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSONAL_ID")
	public AdmPersonal getAdmPersonal() {
		return this.admPersonal;
	}

	public void setAdmPersonal(AdmPersonal admPersonal) {
		this.admPersonal = admPersonal;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public AdmUsuario getAdmUsuario() {
		return this.admUsuario;
	}

	public void setAdmUsuario(AdmUsuario admUsuario) {
		this.admUsuario = admUsuario;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name = "USUARIO", length = 30)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
