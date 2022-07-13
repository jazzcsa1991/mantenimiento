package hts.backend.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;

public abstract class CorePceGrupoEvento {

	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public abstract void setEstatus(Integer estatus) ;

	public abstract void setUsuarioEliminacion(String usuarioEliminacion);

	public abstract void setFechaEliminacion(Date fechaEliminacion);


}
