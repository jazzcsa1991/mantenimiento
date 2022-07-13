package hts.backend.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "cat_tipo_beneficiario")
public class CatTipoBeneficiario implements Serializable{

	private Integer tipoBeneficiarioId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer status;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Integer idiomaAppId;
	
	public CatTipoBeneficiario() {
		super();
	}

	public CatTipoBeneficiario(Integer tipoBeneficiarioId, String cve, String nombre, String descripcion,
			Integer valorDefault, Integer status, Date fechaRegistro, String usuarioRegistro, Integer idiomaAppId) {
		super();
		this.tipoBeneficiarioId = tipoBeneficiarioId;
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorDefault = valorDefault;
		this.status = status;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.idiomaAppId = idiomaAppId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_BENEFICIARIO_ID", unique = true, nullable = false)
	public Integer getTipoBeneficiarioId() {
		return tipoBeneficiarioId;
	}

	public void setTipoBeneficiarioId(Integer tipoBeneficiarioId) {
		this.tipoBeneficiarioId = tipoBeneficiarioId;
	}

	@Column(name = "CVE")
	public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "VALOR_DEFAULT")
	public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Column(name = "STATUS")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Column(name = "IDIOMA_APP")
	public Integer getIdiomaAppId() {
		return idiomaAppId;
	}

	public void setIdiomaAppId(Integer idiomaAppId) {
		this.idiomaAppId = idiomaAppId;
	}
	
	
}
