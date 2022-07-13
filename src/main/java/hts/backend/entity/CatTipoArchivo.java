package hts.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Lenovo3 on 18/07/2017.
 */
@Entity
@Table(name = "cat_tipo_archivo")
public class CatTipoArchivo {
	private Integer tipoArchivoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;

	private CatIdiomaApp catIdiomaAppByIdiomaAppId;


	@Id

	@Column(name = "TIPO_ARCHIVO_ID", nullable = false, precision = 0) public Integer getTipoArchivoId() {
		return tipoArchivoId;
	}

	public void setTipoArchivoId(Integer tipoArchivoId) {
		this.tipoArchivoId = tipoArchivoId;
	}

	@Basic @Column(name = "CVE", nullable = false, length = 20) public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "NOMBRE", nullable = false, length = 100) public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DESCRIPCION", nullable = true, length = 150) public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "VALOR_DEFAULT", nullable = false, precision = 0) public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Basic @Column(name = "ESTATUS", nullable = false, precision = 0) public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "FECHA_REGISTRO", nullable = false) public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO", nullable = false, length = 20) public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}




	@ManyToOne @JoinColumn(name = "IDIOMA_APP_ID", referencedColumnName = "IDIOMA_APP_ID", nullable = false)


	public CatIdiomaApp getCatIdiomaAppByIdiomaAppId() {
		return catIdiomaAppByIdiomaAppId;
	}

	public void setCatIdiomaAppByIdiomaAppId(CatIdiomaApp catIdiomaAppByIdiomaAppId) {
		this.catIdiomaAppByIdiomaAppId = catIdiomaAppByIdiomaAppId;
	}

}
