package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Lenovo3 on 09/06/2017.
 */
@Entity
@Table(name = "nom_cat_estatus_peticion_clinica")
public class CatEstatusPeticionClinica {
	private Integer estatusPeticionClinicaId;
	private Integer claveEstatusPeticionClinica;
	private String nomEstatusPeticionClinica;
	private String descEstatusPeticionClinica;
	private Integer defaultEstPeticonClinica;
	private Integer estatusEstPeticionClinica;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Set<Interconsulta> catEstatusPeticionClinica = new HashSet<Interconsulta>(0);
	private Set<PeticionesClinicas> estatus = new HashSet<PeticionesClinicas>(0);



	@OneToMany(mappedBy = "catEstatusPeticionClinica")
	public Set<Interconsulta> getCatEstatusPeticionClinica() {
		return catEstatusPeticionClinica;
	}

	public void setCatEstatusPeticionClinica(Set<Interconsulta> catEstatusPeticionClinica) {
		this.catEstatusPeticionClinica = catEstatusPeticionClinica;
	}


	@OneToMany(mappedBy = "estatus")
	public Set<PeticionesClinicas> getEstatus() {
		return estatus;
	}

	public void setEstatus(Set<PeticionesClinicas> estatus) {
		this.estatus = estatus;
	}



	@Id @Column(name = "ESTATUS_PETICION_CLINICA_ID", nullable = false, precision = 0) public Integer getEstatusPeticionClinicaId() {
		return estatusPeticionClinicaId;
	}

	public void setEstatusPeticionClinicaId(Integer estatusPeticionClinicaId) {
		this.estatusPeticionClinicaId = estatusPeticionClinicaId;
	}

	@Basic @Column(name = "CVE", nullable = false, precision = 0) public Integer getClaveEstatusPeticionClinica() {
		return claveEstatusPeticionClinica;
	}

	public void setClaveEstatusPeticionClinica(Integer claveEstatusPeticionClinica) {
		this.claveEstatusPeticionClinica = claveEstatusPeticionClinica;
	}

	@Basic @Column(name = "NOMBRE", nullable = false, length = 50) public String getNomEstatusPeticionClinica() {
		return nomEstatusPeticionClinica;
	}

	public void setNomEstatusPeticionClinica(String nomEstatusPeticionClinica) {
		this.nomEstatusPeticionClinica = nomEstatusPeticionClinica;
	}

	@Basic @Column(name = "DESCRIPCION", nullable = false, length = 50) public String getDescEstatusPeticionClinica() {
		return descEstatusPeticionClinica;
	}

	public void setDescEstatusPeticionClinica(String descEstatusPeticionClinica) {
		this.descEstatusPeticionClinica = descEstatusPeticionClinica;
	}

	@Basic @Column(name = "VALOR_DEFAULT", nullable = false, precision = 0) public Integer getDefaultEstPeticonClinica() {
		return defaultEstPeticonClinica;
	}

	public void setDefaultEstPeticonClinica(Integer defaultEstPeticonClinica) {
		this.defaultEstPeticonClinica = defaultEstPeticonClinica;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatusEstPeticionClinica() {
		return estatusEstPeticionClinica;
	}

	public void setEstatusEstPeticionClinica(Integer estatusEstPeticionClinica) {
		this.estatusEstPeticionClinica = estatusEstPeticionClinica;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = true) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = true, length = 50) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


}
