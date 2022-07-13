package hts.backend.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "nom_cat_religion")
public class NomCatReligionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String religionid;
	private String descripcion;
	private Date fecharegistro;
	private Integer indicadefault;
	private Integer estatus;
	private String nousuario;


	public NomCatReligionDTO(){

	}

	public NomCatReligionDTO(String religionid, String descripcion, Date fecharegistro, Integer indicadefault, Integer estatus, String nousuario){

		this.religionid = religionid;
		this.descripcion = descripcion;
		this.fecharegistro = fecharegistro;
		this.indicadefault = indicadefault;
		this.estatus = estatus;
		this.nousuario = nousuario;

	}

	@Id
	@Column(name = "RELIGION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public String getReligionid() {
		return this.religionid;
	}

	public void setReligionid(String religionid) {
		this.religionid = religionid;
	}

	@Column(name = "DESCRIPCION", length = 250)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", length = 7)
	public Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	@Column(name = "INDICA_DEFAULT", precision = 22, scale = 0)
	public Integer getIndicadefault() {
		return indicadefault;
	}

	public void setIndicadefault(Integer indicadefault) {
		this.indicadefault = indicadefault;
	}

	@Column(name = "ESTATUS", precision = 22, scale = 0)
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Column(name = "NO_USUARIO", precision = 22, scale = 0)
	public String getNousuario() {
		return nousuario;
	}

	public void setNousuario(String nousuario) {
		this.nousuario = nousuario;
	}




}