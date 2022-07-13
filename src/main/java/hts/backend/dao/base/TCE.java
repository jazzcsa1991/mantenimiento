package hts.backend.dao.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Timestamp creación y eliminación
 */
@MappedSuperclass
public abstract class TCE extends TC implements Serializable {
	@Column(name = "ts_eliminacion")
	private Timestamp ts_eliminacion;


	public Timestamp getTs_eliminacion() {
		return ts_eliminacion;
	}

	public void setTs_eliminacion(Timestamp _eliminacion) {
		this.ts_eliminacion = _eliminacion;
	}
}