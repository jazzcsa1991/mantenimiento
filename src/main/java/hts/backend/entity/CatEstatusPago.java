package hts.backend.entity;



import hts.backend.entity.CexCitaPaciente;
import hts.backend.entity.FacturacionEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Francisco Toscano on 19/04/2017.
 */

@Entity
@Table(name = "nom_cat_estatus_pago")
public class CatEstatusPago implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer estatusPagoId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Integer valorDefault;
	private Integer estatus;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Set<CexCitaPaciente> cexCitaPacientes = new HashSet<CexCitaPaciente>(0);
	private Set<FacturacionEvento> facturacionEventosByEstatusPagoId;

	public CatEstatusPago() {
	}

	public CatEstatusPago(Integer estatusPagoId) {
		this.estatusPagoId = estatusPagoId;
	}

	@Id
	@Column(name = "ESTATUS_PAGO_ID")
	public Integer getEstatusPagoId() {
		return estatusPagoId;
	}

	public void setEstatusPagoId(Integer estatusPagoId) {
		this.estatusPagoId = estatusPagoId;
	}

	@Basic @Column(name = "CVE")
	public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	@Basic @Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic @Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic @Column(name = "VALOR_DEFAULT")
	public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	@Basic @Column(name = "ESTATUS")
	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Basic @Column(name = "FECHA_REGISTRO")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO")
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@OneToMany(mappedBy = "catEstatusPago")
	public Set<CexCitaPaciente> getCexCitaPacientes() {
		return cexCitaPacientes;
	}

	public void setCexCitaPacientes(Set<CexCitaPaciente> cexCitaPacientes) {
		this.cexCitaPacientes = cexCitaPacientes;
	}

	@OneToMany(mappedBy = "catEstatusPagoByEstadoPagoId") public Set<FacturacionEvento> getFacturacionEventosByEstatusPagoId() {
		return facturacionEventosByEstatusPagoId;
	}

	public void setFacturacionEventosByEstatusPagoId(Set<FacturacionEvento> facturacionEventosByEstatusPagoId) {
		this.facturacionEventosByEstatusPagoId = facturacionEventosByEstatusPagoId;
	}

}
