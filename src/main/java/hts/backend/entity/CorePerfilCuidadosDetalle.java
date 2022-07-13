package hts.backend.entity;


import hts.backend.entity.CatCuidadosClinicosTipo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "core_perfil_cuidados_detalle")
public class CorePerfilCuidadosDetalle  implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer perfilCuidadosDetalleId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CorePerfilesCuidados corePerfilesCuidadosByPerfilId;
	private CoreCuidadosClinicos cuidadoClinicoId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERFIL_CUIDADOS_DETALLE_ID", nullable = false, precision = 0) public Integer getPerfilCuidadosDetalleId() {
		return perfilCuidadosDetalleId;
	}

	public void setPerfilCuidadosDetalleId(Integer perfilCuidadosDetalleId) {
		this.perfilCuidadosDetalleId = perfilCuidadosDetalleId;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 50) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	@ManyToOne @JoinColumn(name = "PERFIL_ID", referencedColumnName = "PERFIL_ID", nullable = false) public CorePerfilesCuidados getCorePerfilesCuidadosByPerfilId() {
		return corePerfilesCuidadosByPerfilId;
	}

	public void setCorePerfilesCuidadosByPerfilId(CorePerfilesCuidados corePerfilesCuidadosByPerfilId) {
		this.corePerfilesCuidadosByPerfilId = corePerfilesCuidadosByPerfilId;
	}

	@ManyToOne @JoinColumn(name = "CUIDADO_CLINICO_ID", referencedColumnName = "CUIDADO_CLINICO_ID", nullable = false)

	public CoreCuidadosClinicos getCuidadoClinicoId() {
		return cuidadoClinicoId;
	}

	public void setCuidadoClinicoId(CoreCuidadosClinicos cuidadoClinicoId) {
		this.cuidadoClinicoId = cuidadoClinicoId;
	}
}
