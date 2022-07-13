package hts.backend.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lenovo2 on 27/07/2017.
 */
@Entity
@Table(name = "fac_validacion_evento")
public class FacValidacionEvento implements Serializable {
	private Integer validacionEventoId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private PacConvenioAseguradora pacConvenioAseguradoraByConvenioAseguradoraId;
	private PacEvento pacEventoByEventoId;
	private AdmCatAseguradora admCatAseguradoraByAseguradoraId;
	private String usuarioAnulacion;
	private Date fechaAnulacion;
	private Integer cargoAsegParticularId;
	private Integer estatus;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VALIDACION_EVENTO_ID", nullable = false, precision = 0)
	public Integer getValidacionEventoId() {
		return validacionEventoId;
	}

	public void setValidacionEventoId(Integer validacionEventoId) {
		this.validacionEventoId = validacionEventoId;
	}

	@Basic
	@Column(name = "FECHA_REGISTRO", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic
	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FacValidacionEvento that = (FacValidacionEvento) o;

		if (validacionEventoId != null ? !validacionEventoId.equals(that.validacionEventoId) : that.validacionEventoId != null)
			return false;
		if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
			return false;
		if (usuarioRegistro != null ? !usuarioRegistro.equals(that.usuarioRegistro) : that.usuarioRegistro != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = validacionEventoId != null ? validacionEventoId.hashCode() : 0;
		result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
		result = 31 * result + (usuarioRegistro != null ? usuarioRegistro.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "CONVENIO_ASEGURADORA_ID", referencedColumnName = "CONVENIO_ASEGURADORA_ID", nullable = false)
	public PacConvenioAseguradora getPacConvenioAseguradoraByConvenioAseguradoraId() {
		return pacConvenioAseguradoraByConvenioAseguradoraId;
	}

	public void setPacConvenioAseguradoraByConvenioAseguradoraId(PacConvenioAseguradora pacConvenioAseguradoraByConvenioAseguradoraId) {
		this.pacConvenioAseguradoraByConvenioAseguradoraId = pacConvenioAseguradoraByConvenioAseguradoraId;
	}

	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", referencedColumnName = "EVENTO_ID", nullable = false)
	public PacEvento getPacEventoByEventoId() {
		return pacEventoByEventoId;
	}

	public void setPacEventoByEventoId(PacEvento pacEventoByEventoId) {
		this.pacEventoByEventoId = pacEventoByEventoId;
	}

	@ManyToOne
	@JoinColumn(name = "ASEGURADORA_ID", referencedColumnName = "ASEGURADORA_ID", nullable = false)
	public AdmCatAseguradora getAdmCatAseguradoraByAseguradoraId() {
		return admCatAseguradoraByAseguradoraId;
	}

	public void setAdmCatAseguradoraByAseguradoraId(AdmCatAseguradora admCatAseguradoraByAseguradoraId) {
		this.admCatAseguradoraByAseguradoraId = admCatAseguradoraByAseguradoraId;
	}

	@Basic
	@Column(name = "USUARIO_ANULACION", nullable = true, length = 20)
	public String getUsuarioAnulacion() {
		return usuarioAnulacion;
	}

	public void setUsuarioAnulacion(String usuarioAnulacion) {
		this.usuarioAnulacion = usuarioAnulacion;
	}

	@Basic
	@Column(name = "FECHA_ANULACION", nullable = true)
	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	@Basic
	@Column(name = "CARGO_ASEG_PARTICULAR_ID", nullable = true)
	public Integer getCargoAsegParticularId() {
		return cargoAsegParticularId;
	}

	public void setCargoAsegParticularId(Integer cargoAsegParticularId) {
		this.cargoAsegParticularId = cargoAsegParticularId;
	}

	@Basic
	@Column(name = "ESTATUS", nullable = false)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
}
