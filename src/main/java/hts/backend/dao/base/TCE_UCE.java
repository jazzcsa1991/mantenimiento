package hts.backend.dao.base;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Timestamp y usuario de creación y eliminación
 */
@MappedSuperclass
public abstract class TCE_UCE extends TCE implements Serializable {
	@Basic
	@Column(name = "us_creacion", nullable = false)
	private Long us_creacion;

	@Basic
	@Column(name = "us_eliminacion")
	private Long us_eliminacion;

	/*@ManyToOne
	@JoinColumn(name = "us_creacion", updatable = false, insertable = false)
	private UsuarioAdmin usuarioCreacion;

	@ManyToOne
	@JoinColumn(name = "us_eliminacion", updatable = false, insertable = false)
	private UsuarioAdmin usuarioEliminacion;*/


//	@PrePersist
//	void usuarioCreacion() {
//		// Obtener usuario autenticado
//		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser")
//			this.us_creacion = ((UsuarioAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuarioAdminId();
//		else
//			this.us_creacion = 1L;
//	}


	public Long getUs_creacion() {
		return us_creacion;
	}

	public void setUs_creacion(Long usCreacion) {
		this.us_creacion = usCreacion;
	}

	public Long getUs_eliminacion() {
		return us_eliminacion;
	}

	public void setUs_eliminacion(Long usEliminacion) {
		this.us_eliminacion = usEliminacion;
	}

	/*public UsuarioAdmin getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(UsuarioAdmin usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public UsuarioAdmin getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(UsuarioAdmin usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}*/
}