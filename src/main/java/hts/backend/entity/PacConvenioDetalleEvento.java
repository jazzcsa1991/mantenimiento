package hts.backend.entity;

import hts.backend.entity.*;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "pac_convenio_detalle_evento")
public class PacConvenioDetalleEvento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int convenioDetalleEventoId;
	private PacConvenioDetalle pacConvenioDetalle;
	private CatTipoEpisodio catTipoEpisodio;
	private int cantidad;
	private Date fechaInicio;
	private Date fechaFin;
	private Double precio;
	private int cobertura;
	private int descuento;
	private int facturable;
	private int valorDefualt;
	private int activo;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private Set<FacBitAbonosAsegComercial> facBitAbonosAsegComercialsByConvenioDetalleEventoId;
	private Set<FacBitCargosAsegComercial> facBitCargosAsegComercialsByConvenioDetalleEventoId;
	private Set<FacCargosAsegComercial> facCargosAsegComercialsByConvenioDetalleEventoId;
	private Set<FacCargosAsegParticular> facCargosAsegParticularsByConvenioDetalleEventoId;
	private Set<FacturacionEvento> facturacionEventosByConvenioDetalleEventoId;


	public PacConvenioDetalleEvento() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONVENIO_DETALLE_EVENTO_ID", unique = true, nullable = false, precision = 22)
	public int getConvenioDetalleEventoId() {
		return this.convenioDetalleEventoId;
	}

	public void setConvenioDetalleEventoId(int convenioDetalleEventoId) {
		this.convenioDetalleEventoId = convenioDetalleEventoId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONVENIO_DETALLE_ID")
	public PacConvenioDetalle getPacConvenioDetalle() {
		return this.pacConvenioDetalle;
	}

	public void setPacConvenioDetalle(PacConvenioDetalle pacConvenioDetalle) {
		this.pacConvenioDetalle = pacConvenioDetalle;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_EPISODIO_ID", nullable = false)
	public CatTipoEpisodio getCatTipoEpisodio() {
		return this.catTipoEpisodio;
	}

	public void setCatTipoEpisodio(CatTipoEpisodio catTipoEpisodio) {
		this.catTipoEpisodio = catTipoEpisodio;
	}


	@Column(name = "CANTIDAD", nullable = false, precision = 22)
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INICIO", nullable = false, length = 7)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_FIN", length = 7)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	@Column(name = "PRECIO", precision = 126)
	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	@Column(name = "COBERTURA", nullable = false, precision = 22)
	public int getCobertura() {
		return this.cobertura;
	}

	public void setCobertura(int cobertura) {
		this.cobertura = cobertura;
	}


	@Column(name = "DESCUENTO", nullable = false, precision = 22)
	public int getDescuento() {
		return this.descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}


	@Column(name = "FACTURABLE", nullable = false, precision = 22)
	public int getFacturable() {
		return this.facturable;
	}

	public void setFacturable(int facturable) {
		this.facturable = facturable;
	}


	@Column(name = "VALOR_DEFAULT", nullable = false, precision = 22)
	public int getValorDefualt() {
		return this.valorDefualt;
	}

	public void setValorDefualt(int valorDefualt) {
		this.valorDefualt = valorDefualt;
	}


	@Column(name = "ACTIVO", nullable = false, precision = 22)
	public int getActivo() {
		return this.activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", nullable = false, length = 7)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name = "USUARIO_REGISTRO", nullable = false, length = 20)
	public String getUsuarioRegistra() {
		return this.usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}


	@OneToMany(mappedBy = "pacConvenioDetalleEventoByConvenioDetalleEventoId")
	public Set<FacturacionEvento> getFacturacionEventosByConvenioDetalleEventoId() {
		return facturacionEventosByConvenioDetalleEventoId;
	}

	public void setFacturacionEventosByConvenioDetalleEventoId(Set<FacturacionEvento> facturacionEventosByConvenioDetalleEventoId) {
		this.facturacionEventosByConvenioDetalleEventoId = facturacionEventosByConvenioDetalleEventoId;
	}


	@OneToMany(mappedBy = "pacConvenioDetalleEventoByConvenioDetalleEventoId")
	public Set<FacBitAbonosAsegComercial> getFacBitAbonosAsegComercialsByConvenioDetalleEventoId() {
		return facBitAbonosAsegComercialsByConvenioDetalleEventoId;
	}

	public void setFacBitAbonosAsegComercialsByConvenioDetalleEventoId(Set<FacBitAbonosAsegComercial> facBitAbonosAsegComercialsByConvenioDetalleEventoId) {
		this.facBitAbonosAsegComercialsByConvenioDetalleEventoId = facBitAbonosAsegComercialsByConvenioDetalleEventoId;
	}


	@OneToMany(mappedBy = "pacConvenioDetalleEventoByConvenioDetalleEventoId")
	public Set<FacBitCargosAsegComercial> getFacBitCargosAsegComercialsByConvenioDetalleEventoId() {
		return facBitCargosAsegComercialsByConvenioDetalleEventoId;
	}

	public void setFacBitCargosAsegComercialsByConvenioDetalleEventoId(Set<FacBitCargosAsegComercial> facBitCargosAsegComercialsByConvenioDetalleEventoId) {
		this.facBitCargosAsegComercialsByConvenioDetalleEventoId = facBitCargosAsegComercialsByConvenioDetalleEventoId;
	}


	@OneToMany(mappedBy = "pacConvenioDetalleEventoByConvenioDetalleEventoId")
	public Set<FacCargosAsegComercial> getFacCargosAsegComercialsByConvenioDetalleEventoId() {
		return facCargosAsegComercialsByConvenioDetalleEventoId;
	}

	public void setFacCargosAsegComercialsByConvenioDetalleEventoId(Set<FacCargosAsegComercial> facCargosAsegComercialsByConvenioDetalleEventoId) {
		this.facCargosAsegComercialsByConvenioDetalleEventoId = facCargosAsegComercialsByConvenioDetalleEventoId;
	}


	@OneToMany(mappedBy = "pacConvenioDetalleEvento")
	public Set<FacCargosAsegParticular> getFacCargosAsegParticularsByConvenioDetalleEventoId() {
		return facCargosAsegParticularsByConvenioDetalleEventoId;
	}

	public void setFacCargosAsegParticularsByConvenioDetalleEventoId(Set<FacCargosAsegParticular> facCargosAsegParticularsByConvenioDetalleEventoId) {
		this.facCargosAsegParticularsByConvenioDetalleEventoId = facCargosAsegParticularsByConvenioDetalleEventoId;
	}
}
