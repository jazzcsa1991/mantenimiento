package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Lenovo3 on 08/06/2017.
 */
@Entity
@Table(name = "estudios_peticiones")
public class EstudiosPeticiones implements java.io.Serializable  {
	private Integer estudiosPeticionesId;
	private Date fechaRegistro;
	private PeticionesClinicas peticionesClinicasId;
	private NomPrductoPrestacion prductoPrestacionId;
	private String usuarioRegistro;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESTUDIOS_PETICIONES_ID", nullable = false, precision = 0) public Integer getEstudiosPeticionesId() {
		return estudiosPeticionesId;
	}

	public void setEstudiosPeticionesId(Integer estudiosPeticionesId) {
		this.estudiosPeticionesId = estudiosPeticionesId;
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


	@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "PETICIONES_CLINICAS_ID")
	public PeticionesClinicas getPeticionesClinicasId() {
		return peticionesClinicasId;
	}

	public void setPeticionesClinicasId(PeticionesClinicas peticionesClinicasId) {
		this.peticionesClinicasId = peticionesClinicasId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCTO_PRESTACION_ID")
	public NomPrductoPrestacion getPrductoPrestacionId() {
		return prductoPrestacionId;
	}

	public void setPrductoPrestacionId(NomPrductoPrestacion prductoPrestacionId) {
		this.prductoPrestacionId = prductoPrestacionId;
	}
}
