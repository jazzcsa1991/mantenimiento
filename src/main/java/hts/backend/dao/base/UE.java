package hts.backend.dao.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Usuario eliminación
 */
@MappedSuperclass
public abstract class UE implements Serializable {
	@Column(name = "us_eliminacion")
	private Long usuario_eliminacion;

	/*@ManyToOne
	@JoinColumn(name = "us_eliminacion", insertable = false, updatable = false)
	private UsuarioAdmin usuarioEliminacion;*/


	public Long getUsuario_eliminacion() {
		return usuario_eliminacion;
	}

	public void setUsuario_eliminacion(Long usEliminacion) {
		this.usuario_eliminacion = usEliminacion;
	}

	/*public UsuarioAdmin getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(UsuarioAdmin usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}*/
}