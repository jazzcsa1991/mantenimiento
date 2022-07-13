package hts.backend.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "adm_funciones_rol")
public class AdmFuncionesRol implements Serializable{

	private Integer funcionRolId;
	private Integer gusFuncionId;
	private Integer rolId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	
	
	public AdmFuncionesRol() {
	}


	public AdmFuncionesRol(Integer funcionRolId, Integer gusFuncionId, Integer rolId, Date fechaRegistro,
			String usuarioRegistro) {
		super();
		this.funcionRolId = funcionRolId;
		this.gusFuncionId = gusFuncionId;
		this.rolId = rolId;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
	}


	@Id
	@Column(name = "FUNCION_ROL_ID", unique = true, nullable = false)
	public Integer getFuncionRolId() {
		return funcionRolId;
	}


	public void setFuncionRolId(Integer funcionRolId) {
		this.funcionRolId = funcionRolId;
	}


	@Column(name = "GUS_FUNCION_ID", nullable = false)
	public Integer getGusFuncionId() {
		return gusFuncionId;
	}


	public void setGusFuncionId(Integer gusFuncionId) {
		this.gusFuncionId = gusFuncionId;
	}


	@Column(name = "ROL_ID", nullable = false)
	public Integer getRolId() {
		return rolId;
	}


	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}


	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
	
	
	
	
}
