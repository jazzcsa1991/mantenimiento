package hts.backend.dao.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Usuario creación y eliminación
 */
@MappedSuperclass
public abstract class UCE extends UC implements Serializable {
	@Column(name = "us_eliminacion")
	private Long us_eliminacion;

	/*@ManyToOne
	@JoinColumn(name = "us_eliminacion", insertable = false, updatable = false)
	private UsuarioAdmin usuarioEliminacion;*/


	public Long getUs_eliminacion() {
		return us_eliminacion;
	}

	public void setUs_eliminacion(Long usEliminacion) {
		this.us_eliminacion = usEliminacion;
	}

	/*public UsuarioAdmin getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(UsuarioAdmin usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}*/
}