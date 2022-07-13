package hts.backend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;


/**
 * Created by Lenovo3 on 08/06/2017.
 */
@Entity
@Table(name = "cat_tipo_prueba")
public class CatTipoPrueba {
	private Integer tipoPruebaId;
	private String claveTipoPrueba;
	private String nombreTipoPrueba;
	private String descTipoPrueba;
	private Integer defaultTipoPrueba;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;

	private Set<Interconsulta> catTipoPrueba = new HashSet<Interconsulta>(0);



	@OneToMany(mappedBy = "catTipoPrueba")
	public Set<Interconsulta> getCatTipoPrueba() {
		return catTipoPrueba;
	}

	public void setCatTipoPrueba(Set<Interconsulta> catTipoPrueba) {
		this.catTipoPrueba = catTipoPrueba;
	}






	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPO_PRUEBA_ID", nullable = false, precision = 0) public Integer getTipoPruebaId() {
		return tipoPruebaId;
	}

	public void setTipoPruebaId(Integer tipoPruebaId) {
		this.tipoPruebaId = tipoPruebaId;
	}

	@Basic @Column(name = "CVE", nullable = false, precision = 0) public String getClaveTipoPrueba() {
		return claveTipoPrueba;
	}

	public void setClaveTipoPrueba(String claveTipoPrueba) {
		this.claveTipoPrueba = claveTipoPrueba;
	}

	@Basic @Column(name = "NOMBRE", nullable = false, length = 100) public String getNombreTipoPrueba() {
		return nombreTipoPrueba;
	}

	public void setNombreTipoPrueba(String nombreTipoPrueba) {
		this.nombreTipoPrueba = nombreTipoPrueba;
	}

	@Basic @Column(name = "DESCRIPCION", nullable = false, length = 150) public String getDescTipoPrueba() {
		return descTipoPrueba;
	}

	public void setDescTipoPrueba(String descTipoPrueba) {
		this.descTipoPrueba = descTipoPrueba;
	}

	@Basic @Column(name = "VALOR_DEFAULT", nullable = false, precision = 0) public Integer getDefaultTipoPrueba() {
		return defaultTipoPrueba;
	}

	public void setDefaultTipoPrueba(Integer defaultTipoPrueba) {
		this.defaultTipoPrueba = defaultTipoPrueba;
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




}
