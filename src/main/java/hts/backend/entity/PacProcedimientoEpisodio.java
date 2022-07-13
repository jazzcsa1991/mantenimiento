package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by SASA Desarrollo on 17/04/2017.
 */
@Entity
@Table(name = "pac_procedimiento_episodio")
public class PacProcedimientoEpisodio implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer procedimientoEpisodioId;
	private Integer cie9Id;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private PacEpisodio pacEpisodioByEpisodioId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROCEDIMIENTO_EPISODIO_ID") public Integer getProcedimientoEpisodioId() {
		return procedimientoEpisodioId;
	}

	public void setProcedimientoEpisodioId(Integer procedimientoEpisodioId) {
		this.procedimientoEpisodioId = procedimientoEpisodioId;
	}

	@Basic @Column(name = "CIE_9_ID") public Integer getCie9Id() {
		return cie9Id;
	}

	public void setCie9Id(Integer cie9Id) {
		this.cie9Id = cie9Id;
	}

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PacProcedimientoEpisodio that = (PacProcedimientoEpisodio) o;

		if (procedimientoEpisodioId != that.procedimientoEpisodioId) return false;
		if (cie9Id != that.cie9Id) return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
			return false;
		if (usuarioRegistro != null ? !usuarioRegistro.equals(that.usuarioRegistro) : that.usuarioRegistro != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = (int) (procedimientoEpisodioId ^ (procedimientoEpisodioId >>> 32));
		result = 31 * result + (int) (cie9Id ^ (cie9Id >>> 32));
		result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
		result = 31 * result + (usuarioRegistro != null ? usuarioRegistro.hashCode() : 0);
		return result;
	}

	@ManyToOne @JoinColumn(name = "EPISODIO_ID", referencedColumnName = "EPISODIO_ID", nullable = false)
	public PacEpisodio getPacEpisodioByEpisodioId() {
		return pacEpisodioByEpisodioId;
	}

	public void setPacEpisodioByEpisodioId(PacEpisodio pacEpisodioByEpisodioId) {
		this.pacEpisodioByEpisodioId = pacEpisodioByEpisodioId;
	}
}
