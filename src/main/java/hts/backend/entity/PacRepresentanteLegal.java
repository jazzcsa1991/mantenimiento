package hts.backend.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.context.SecurityContextHolder;

@Entity
@Table(name = "pac_representante_legal")
public class PacRepresentanteLegal implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idRepresentante;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private String curp;
	private Integer sexoId;
	private Integer nacionalidadId;	
	private Integer telefonoId;
	private Integer correoId;
	private Integer parentescoId;
	
	private Integer entidadNacId;
	private Integer municipioNacId;
	private String codigoPostal;
	
	
	private String fotoPaciente;
	private Boolean banValidacion;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REPRESENTANTE", unique = true, nullable = false, precision = 22)
	public Integer getIdRepresentante() {
		return this.idRepresentante;
	}

	public void setIdRepresentante(Integer idRepresentante) {
		this.idRepresentante = idRepresentante;
	}

	@Column(name = "NOMBRE", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "PRIMER_APELLIDO", nullable = false, length = 20)
	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}


	@Column(name = "SEGUNDO_APELLIDO", length = 20)
	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO", nullable = false, length = 7)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	@Column(name = "CURP", length = 20, unique = true)
	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	@Column(name = "NACIONALIDAD_ID")
	public Integer getNacionalidadId() {
		return nacionalidadId;
	}

	public void setNacionalidadId(Integer nacionalidadId) {
		this.nacionalidadId = nacionalidadId;
	}

	@Column(name = "SEXO_ID")
	public Integer getSexoId() {
		return sexoId;
	}

	public void setSexoId(Integer sexoId) {
		this.sexoId = sexoId;
	}

	@Column(name = "FOTO_PACIENTE")
	public String getFotoPaciente() {
		return fotoPaciente;
	}

	public void setFotoPaciente(String fotoPaciente) {
		this.fotoPaciente = fotoPaciente;
	}

	@Column(name = "BAN_VALIDACION")
	public Boolean getBanValidacion() {
		return banValidacion;
	}

	public void setBanValidacion(Boolean banValidacion) {
		this.banValidacion = banValidacion;
	}

	@Column(name = "TELEFONO_ID")
	public Integer getTelefonoId() {
		return telefonoId;
	}

	public void setTelefonoId(Integer telefonoId) {
		this.telefonoId = telefonoId;
	}

	@Column(name = "CORREO_ID")
	public Integer getCorreoId() {
		return correoId;
	}

	public void setCorreoId(Integer correoId) {
		this.correoId = correoId;
	}

	@Column(name = "PARENTESCO_ID")
	public Integer getParentescoId() {
		return parentescoId;
	}

	public void setParentescoId(Integer parentescoId) {
		this.parentescoId = parentescoId;
	}

	@Column(name = "ENTIDAD_NAC_ID")
	public Integer getEntidadNacId() {
		return entidadNacId;
	}

	public void setEntidadNacId(Integer entidadNacId) {
		this.entidadNacId = entidadNacId;
	}

	@Column(name = "MUNICIPIO_NAC_ID")
	public Integer getMunicipioNacId() {
		return municipioNacId;
	}

	public void setMunicipioNacId(Integer municipioNacId) {
		this.municipioNacId = municipioNacId;
	}

	@Column(name = "CODIGO_POSTAL")
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


}
