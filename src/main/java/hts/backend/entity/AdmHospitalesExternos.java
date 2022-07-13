package hts.backend.entity;


import hts.backend.entity.CatTipoUnidadReferencia;
import hts.backend.entity.CoreReferenciasExternas;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by SASA Desarrollo on 20/06/2017.
 */
@Entity
@Table(name = "adm_hospitales_externos")
public class AdmHospitalesExternos implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer hospitalesExternosId;
	private String nombre;
	private String direccion;
	private String estado;
	private String codigoPosta;
	private String telefono1;
	private String telefono2;
	private String correo;
	private CatClues nomCatClues;
	private CatTipoUnidadReferencia catTipoUnidadReferencia;
	private NomCatPaises nomCatPaises;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Set<CoreReferenciasExternas> coreReferenciasExternas = new HashSet<CoreReferenciasExternas>(0);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOSPITAL_EXTERNO_ID") public Integer getHospitalesExternosId() {
		return hospitalesExternosId;
	}

	public void setHospitalesExternosId(Integer hospitalesExternosId) {
		this.hospitalesExternosId = hospitalesExternosId;
	}

	@Basic @Column(name = "NOMBRE") public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DIRECCION") public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Basic @Column(name = "ESTADO")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Basic @Column(name = "CODIGO_POSTA") public String getCodigoPosta() {
		return codigoPosta;
	}

	public void setCodigoPosta(String codigoPosta) {
		this.codigoPosta = codigoPosta;
	}

	@Basic @Column(name = "TELEFONO1") public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	@Basic @Column(name = "TELEFONO2") public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	@Basic @Column(name = "CORREO") public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@ManyToOne @JoinColumn(name = "ID_CLUES")
	public CatClues getNomCatClues() {
		return nomCatClues;
	}

	public void setNomCatClues(CatClues nomCatClues) {
		this.nomCatClues = nomCatClues;
	}

	@ManyToOne @JoinColumn(name = 	"TIPO_UNIDAD_REFERENCIA_ID", referencedColumnName = "TIPO_UNIDAD_REFERENCIA_ID", nullable = false)
	public CatTipoUnidadReferencia getCatTipoUnidadReferencia() {
		return catTipoUnidadReferencia;
	}

	public void setCatTipoUnidadReferencia(CatTipoUnidadReferencia catTipoUnidadReferencia) {
		this.catTipoUnidadReferencia = catTipoUnidadReferencia;
	}

	@ManyToOne @JoinColumn(name = "PAIS_ID", referencedColumnName = "PAIS_ID", nullable = false)
	public NomCatPaises getNomCatPaises() {
		return nomCatPaises;
	}

	public void setNomCatPaises(NomCatPaises nomCatPaises) {
		this.nomCatPaises = nomCatPaises;
	}

	@Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hospitalesExternos")
	public Set<CoreReferenciasExternas> getCoreReferenciasExternas() {
		return coreReferenciasExternas;
	}

	public void setCoreReferenciasExternas(Set<CoreReferenciasExternas> coreReferenciasExternas) {
		this.coreReferenciasExternas = coreReferenciasExternas;
	}
}
