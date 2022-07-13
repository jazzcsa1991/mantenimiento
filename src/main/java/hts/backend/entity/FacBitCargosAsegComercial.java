package hts.backend.entity;

import hts.backend.entity.*;
import hts.backend.entity.CoreEventoAseguradoraConcepto;
import hts.backend.entity.PacPaciente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lenovo2 on 30/06/2017.
 */
@Entity
@Table(name = "fac_bit_cargos_aseg_comercial")
public class FacBitCargosAsegComercial implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer bitCargosAsegComercialId;
	private String usuarioCancela;
	private Date fechaCancela;
	private Integer cargoAsegComercialId;
	private Integer cobertura;
	private Float precio;
	private Float descuento;
	private Float iva;
	private Float importe;
	private Float impuesto;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private CatMotivoAnulacionPrest catMotivoAnulacionPrestByMotivoCancelacionCargoId;
	private PacPaciente pacPacienteByIdPaciente;
	private PacEpisodio pacEpisodioByEpisodioId;
	private PacConvenioDetalleEvento pacConvenioDetalleEventoByConvenioDetalleEventoId;
	private Boolean pagado;
	private FacBitSeparacionCuenta separacionCuenta;
	private Integer separacionCuentaId;
	private PacEvento pacEvento;
	private NomPrductoPrestacion nomPrductoPrestacion;
	private Integer eventoId;
	private Integer productoPrestacionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BIT_CARGOS_ASEG_COMERCIAL_ID", nullable = false, precision = 0) public Integer getBitCargosAsegComercialId() {
		return bitCargosAsegComercialId;
	}

	public void setBitCargosAsegComercialId(Integer bitCargosAsegComercialId) {
		this.bitCargosAsegComercialId = bitCargosAsegComercialId;
	}

	@Basic @Column(name = "USUARIO_CANCELA", nullable = false, length = 20) public String getUsuarioCancela() {
		return usuarioCancela;
	}

	public void setUsuarioCancela(String usuarioCancela) {
		this.usuarioCancela = usuarioCancela;
	}

	@Basic @Column(name = "FECHA_CANCELA", nullable = false) public Date getFechaCancela() {
		return fechaCancela;
	}

	public void setFechaCancela(Date fechaCancela) {
		this.fechaCancela = fechaCancela;
	}

	@Basic @Column(name = "CARGO_ASEG_COMERCIAL_ID", nullable = false, precision = 0) public Integer getCargoAsegComercialId() {
		return cargoAsegComercialId;
	}

	public void setCargoAsegComercialId(Integer cargoAsegComercialId) {
		this.cargoAsegComercialId = cargoAsegComercialId;
	}


	@Basic @Column(name = "COBERTURA", nullable = false, precision = 0) public Integer getCobertura() {
		return cobertura;
	}

	public void setCobertura(Integer cobertura) {
		this.cobertura = cobertura;
	}

	@Basic @Column(name = "PRECIO", nullable = false, precision = 0) public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Basic @Column(name = "DESCUENTO", nullable = false, precision = 0) public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	@Basic @Column(name = "IVA", nullable = false, precision = 0) public Float getIva() {
		return iva;
	}

	public void setIva(Float iva) {
		this.iva = iva;
	}

	@Basic @Column(name = "IMPORTE", nullable = false, precision = 0) public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
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

	@ManyToOne @JoinColumn(name = "MOTIVO_CANCELACION_CARGO_ID", referencedColumnName = "MOTIVO_ANULACION_PREST_ID", nullable = false) public CatMotivoAnulacionPrest getCatMotivoAnulacionPrestByMotivoCancelacionCargoId() {
		return catMotivoAnulacionPrestByMotivoCancelacionCargoId;
	}

	public void setCatMotivoAnulacionPrestByMotivoCancelacionCargoId(CatMotivoAnulacionPrest catMotivoAnulacionPrestByMotivoCancelacionCargoId) {
		this.catMotivoAnulacionPrestByMotivoCancelacionCargoId = catMotivoAnulacionPrestByMotivoCancelacionCargoId;
	}

	@ManyToOne @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", nullable = false) public PacPaciente getPacPacienteByIdPaciente() {
		return pacPacienteByIdPaciente;
	}

	public void setPacPacienteByIdPaciente(PacPaciente pacPacienteByIdPaciente) {
		this.pacPacienteByIdPaciente = pacPacienteByIdPaciente;
	}

	@ManyToOne @JoinColumn(name = "EPISODIO_ID", referencedColumnName = "EPISODIO_ID", nullable = false) public PacEpisodio getPacEpisodioByEpisodioId() {
		return pacEpisodioByEpisodioId;
	}

	public void setPacEpisodioByEpisodioId(PacEpisodio pacEpisodioByEpisodioId) {
		this.pacEpisodioByEpisodioId = pacEpisodioByEpisodioId;
	}

	@ManyToOne @JoinColumn(name = "CONVENIO_DETALLE_EVENTO_ID", referencedColumnName = "CONVENIO_DETALLE_EVENTO_ID", nullable = false) public PacConvenioDetalleEvento getPacConvenioDetalleEventoByConvenioDetalleEventoId() {
		return pacConvenioDetalleEventoByConvenioDetalleEventoId;
	}

	public void setPacConvenioDetalleEventoByConvenioDetalleEventoId(PacConvenioDetalleEvento pacConvenioDetalleEventoByConvenioDetalleEventoId) {
		this.pacConvenioDetalleEventoByConvenioDetalleEventoId = pacConvenioDetalleEventoByConvenioDetalleEventoId;
	}


	@Basic @Column(name = "PAGADO", nullable = false, precision = 0)
	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	@ManyToOne
	@JoinColumn(name = "SEPARACION_CUENTA_ID", referencedColumnName = "SEPARACION_CUENTA_ID", updatable = false , insertable = false)
	public FacBitSeparacionCuenta getSeparacionCuenta() {
		return separacionCuenta;
	}

	public void setSeparacionCuenta(FacBitSeparacionCuenta separacionCuenta) {
		this.separacionCuenta = separacionCuenta;
	}

	@Basic @Column(name = "SEPARACION_CUENTA_ID")
	public Integer getSeparacionCuentaId() {
		return separacionCuentaId;
	}

	public void setSeparacionCuentaId(Integer separacionCuentaId) {
		this.separacionCuentaId = separacionCuentaId;
	}

	@Basic @Column(name = "IMPUESTO", nullable = false)
	public Float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	@ManyToOne
	@JoinColumn(name = "EVENTO_ID", updatable = false , insertable = false)
	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEvento) {
		this.pacEvento = pacEvento;
	}

	@ManyToOne
	@JoinColumn(name = "PRODUCTO_PRESTACION_ID", updatable = false , insertable = false)
	public NomPrductoPrestacion getNomPrductoPrestacion() {
		return nomPrductoPrestacion;
	}

	public void setNomPrductoPrestacion(NomPrductoPrestacion nomPrductoPrestacion) {
		this.nomPrductoPrestacion = nomPrductoPrestacion;
	}

	@Column(name = "EVENTO_ID")
	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	@Column(name = "PRODUCTO_PRESTACION_ID")
	public Integer getProductoPrestacionId() {
		return productoPrestacionId;
	}

	public void setProductoPrestacionId(Integer productoPrestacionId) {
		this.productoPrestacionId = productoPrestacionId;
	}

}
