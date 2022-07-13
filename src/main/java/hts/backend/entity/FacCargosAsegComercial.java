package hts.backend.entity;

import hts.backend.entity.PacConvenioDetalleEvento;
import hts.backend.entity.PacEpisodio;
import hts.backend.entity.PacEventoPrestacion;
import hts.backend.entity.PacPaciente;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "fac_cargos_aseg_comercial")
public class FacCargosAsegComercial implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cargoAsegComercialId;
	private BigDecimal cobertura;
	private BigDecimal precio;
	private BigDecimal descuento;
	private BigDecimal iva;
	private BigDecimal importe;
	private BigDecimal impuesto;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Boolean pagado;
	private Boolean modificado;


	private PacPaciente pacPacienteByIdPaciente;
	private PacEpisodio pacEpisodioByEpisodioId;
	private PacConvenioDetalleEvento pacConvenioDetalleEventoByConvenioDetalleEventoId;
	private PacEventoPrestacion pacEventoPrestacionByEventoPrestacionId;

	@Transient
	private BigDecimal pendienteConciliacion;

	private FacBitSeparacionCuenta separacionCuenta;
	private Integer separacionCuentaId;

	private Set<FacBitConcilAsegComercial> facBitConcilAsegComercialsByCargoAsegComercialId;
	private Set<FacConcilAsegComercial> facConcilAsegComercialsByCargoAsegComercialId;


	@Basic @Column(name = "MODIFICADO")
	public Boolean getModificado() {
		return modificado;
	}

	public void setModificado(Boolean modificado) {
		this.modificado = modificado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARGO_ASEG_COMERCIAL_ID", nullable = false, precision = 0)
	public Integer getCargoAsegComercialId() {
		return cargoAsegComercialId;
	}

	public void setCargoAsegComercialId(Integer cargoAsegComercialId) {
		this.cargoAsegComercialId = cargoAsegComercialId;
	}

	@Basic
	@Column(name = "COBERTURA", nullable = false, precision = 0)
	public BigDecimal getCobertura() {
		return cobertura;
	}

	public void setCobertura(BigDecimal cobertura) {
		this.cobertura = cobertura;
	}

	@Basic
	@Column(name = "PRECIO", nullable = false, precision = 0)
	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Basic
	@Column(name = "DESCUENTO", nullable = false, precision = 0)
	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}


	@Basic
	@Column(name = "IVA", nullable = false, precision = 0)
	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}


	@Basic
	@Column(name = "IMPORTE", nullable = false, precision = 0)
	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@Basic
	@Column(name = "IMPUESTO", nullable = false, precision = 0)
	public BigDecimal getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
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

	@ManyToOne
	@JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", nullable = false)
	public PacPaciente getPacPacienteByIdPaciente() {
		return pacPacienteByIdPaciente;
	}

	public void setPacPacienteByIdPaciente(PacPaciente pacPacienteByIdPaciente) {
		this.pacPacienteByIdPaciente = pacPacienteByIdPaciente;
	}

	@ManyToOne
	@JoinColumn(name = "EPISODIO_ID", referencedColumnName = "EPISODIO_ID", nullable = false)
	public PacEpisodio getPacEpisodioByEpisodioId() {
		return pacEpisodioByEpisodioId;
	}

	public void setPacEpisodioByEpisodioId(PacEpisodio pacEpisodioByEpisodioId) {
		this.pacEpisodioByEpisodioId = pacEpisodioByEpisodioId;
	}

	@ManyToOne
	@JoinColumn(name = "CONVENIO_DETALLE_EVENTO_ID", referencedColumnName = "CONVENIO_DETALLE_EVENTO_ID", nullable = false)
	public PacConvenioDetalleEvento getPacConvenioDetalleEventoByConvenioDetalleEventoId() {
		return pacConvenioDetalleEventoByConvenioDetalleEventoId;
	}

	public void setPacConvenioDetalleEventoByConvenioDetalleEventoId(PacConvenioDetalleEvento pacConvenioDetalleEventoByConvenioDetalleEventoId) {
		this.pacConvenioDetalleEventoByConvenioDetalleEventoId = pacConvenioDetalleEventoByConvenioDetalleEventoId;
	}

	@ManyToOne
	@JoinColumn(name = "EVENTO_PRESTACION_ID", referencedColumnName = "EVENTO_PRESTACION_ID", nullable = false)
	public PacEventoPrestacion getPacEventoPrestacionByEventoPrestacionId() {
		return pacEventoPrestacionByEventoPrestacionId;
	}

	public void setPacEventoPrestacionByEventoPrestacionId(PacEventoPrestacion pacEventoPrestacionByEventoPrestacionId) {
		this.pacEventoPrestacionByEventoPrestacionId = pacEventoPrestacionByEventoPrestacionId;
	}

	@OneToMany(mappedBy = "cargoAsegComercial")
	public Set<FacConcilAsegComercial> getFacConcilAsegComercialsByCargoAsegComercialId() {
		return facConcilAsegComercialsByCargoAsegComercialId;
	}

	public void setFacConcilAsegComercialsByCargoAsegComercialId(Set<FacConcilAsegComercial> facConcilAsegComercialsByCargoAsegComercialId) {
		this.facConcilAsegComercialsByCargoAsegComercialId = facConcilAsegComercialsByCargoAsegComercialId;
	}

	@Basic
	@Column(name = "PAGADO", nullable = false, precision = 0)
	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	@OneToMany(mappedBy = "facCargosAsegComercialByCargoAsegComercialId")
	public Set<FacBitConcilAsegComercial> getFacBitConcilAsegComercialsByCargoAsegComercialId() {
		return facBitConcilAsegComercialsByCargoAsegComercialId;
	}

	public void setFacBitConcilAsegComercialsByCargoAsegComercialId(Set<FacBitConcilAsegComercial> facBitConcilAsegComercialsByCargoAsegComercialId) {
		this.facBitConcilAsegComercialsByCargoAsegComercialId = facBitConcilAsegComercialsByCargoAsegComercialId;
	}

	@Transient
	public BigDecimal getPendienteConciliacion() {
		return pendienteConciliacion;
	}

	public void setPendienteConciliacion(BigDecimal pendienteConciliacion) {
		this.pendienteConciliacion = pendienteConciliacion;
	}


	@ManyToOne
	@JoinColumn(name = "SEPARACION_CUENTA_ID", referencedColumnName = "SEPARACION_CUENTA_ID", updatable = false, insertable = false)
	public FacBitSeparacionCuenta getSeparacionCuenta() {
		return separacionCuenta;
	}

	public void setSeparacionCuenta(FacBitSeparacionCuenta separacionCuenta) {
		this.separacionCuenta = separacionCuenta;
	}

	@Basic
	@Column(name = "SEPARACION_CUENTA_ID")
	public Integer getSeparacionCuentaId() {
		return separacionCuentaId;
	}

	public void setSeparacionCuentaId(Integer separacionCuentaId) {
		this.separacionCuentaId = separacionCuentaId;
	}
}
