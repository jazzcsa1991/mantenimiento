package hts.backend.dao.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Usuario creación
 */
@MappedSuperclass
public abstract class UC implements Serializable {
	@Column(name = "us_creacion", nullable = false)
	private Long us_creacion;

	/*@ManyToOne
	@JoinColumn(name = "us_creacion", insertable = false, updatable = false)
	private UsuarioAdmin usuarioCreacion;*/

//
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

	/*public UsuarioAdmin getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(UsuarioAdmin usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}*/
}