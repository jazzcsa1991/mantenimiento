package hts.backend.dao.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Timestamp creación
 */
@MappedSuperclass
public abstract class TC implements Serializable {
	@Column(name = "ts_creacion", nullable = false)
	private Timestamp ts_creacion;


	@PrePersist
	void timestampCreacion() {
		// Obtener timestamp
		this.ts_creacion = new Timestamp(new Date().getTime());
	}


	public Timestamp getTs_creacion() {
		return ts_creacion;
	}

	public void setTs_creacion(Timestamp _creacion) {
		this.ts_creacion = _creacion;
	}
}