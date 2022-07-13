package hts.backend.model.dto;

import java.util.Date;

public class NomProductoPrestacionDTO {
	private Integer prductoPrestacionId;
	private Integer tipoPrestacion1Id;
	private Integer clasePrestacionId;
	private Integer unidadMedidaPresId;
	private Integer clasificacionFiscalId;
	private String cve;
	private String nombre;
	private String descripcion;
	private Date fechaIncio;
	private Date fechaFin;
	private double precio;
	private String codigoExterno;
	private Integer valorDefault;
	private Integer estatus;
	private Integer grupoPrestacion;
	private Integer desglosaGrupo;
	private Integer prestacionFacturable;
	private Boolean cobroOxigeno;

	private String nombreClasePrestacion;
	private String nombreUnidadMedida;
	private String nombreP1;
	private String nombreP2;
	private String nombreClasFiscal;
	private Float cantidad;
	private Integer prestacionDefault;
	private Integer origenPrestacion;    ///1.- TipoVisita, 2.- ServEspecialidad 3.- cambio de ubicacion

	private Integer admProfSaludGralId;
	private Integer peticionesClinicasId;
	private Integer estudiosPeticionesId;
	private Integer hospitalId;
	private Integer especialidadId;

	public Integer getPrductoPrestacionId() {
		return prductoPrestacionId;
	}

	public void setPrductoPrestacionId(Integer prductoPrestacionId) {
		this.prductoPrestacionId = prductoPrestacionId;
	}

	public Integer getTipoPrestacion1Id() {
		return tipoPrestacion1Id;
	}

	public void setTipoPrestacion1Id(Integer tipoPrestacion1Id) {
		this.tipoPrestacion1Id = tipoPrestacion1Id;
	}

	public Integer getClasePrestacionId() {
		return clasePrestacionId;
	}

	public void setClasePrestacionId(Integer clasePrestacionId) {
		this.clasePrestacionId = clasePrestacionId;
	}

	public Integer getUnidadMedidaPresId() {
		return unidadMedidaPresId;
	}

	public void setUnidadMedidaPresId(Integer unidadMedidaPresId) {
		this.unidadMedidaPresId = unidadMedidaPresId;
	}

	public Integer getClasificacionFiscalId() {
		return clasificacionFiscalId;
	}

	public void setClasificacionFiscalId(Integer clasificacionFiscalId) {
		this.clasificacionFiscalId = clasificacionFiscalId;
	}

	public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaIncio() {
		return fechaIncio;
	}

	public void setFechaIncio(Date fechaIncio) {
		this.fechaIncio = fechaIncio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCodigoExterno() {
		return codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	public Integer getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(Integer valorDefault) {
		this.valorDefault = valorDefault;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getGrupoPrestacion() {
		return grupoPrestacion;
	}

	public void setGrupoPrestacion(Integer grupoPrestacion) {
		this.grupoPrestacion = grupoPrestacion;
	}

	public Integer getDesglosaGrupo() {
		return desglosaGrupo;
	}

	public void setDesglosaGrupo(Integer desglosaGrupo) {
		this.desglosaGrupo = desglosaGrupo;
	}

	public Integer getPrestacionFacturable() {
		return prestacionFacturable;
	}

	public void setPrestacionFacturable(Integer prestacionFacturable) {
		this.prestacionFacturable = prestacionFacturable;
	}

	public String getNombreClasePrestacion() {
		return nombreClasePrestacion;
	}

	public void setNombreClasePrestacion(String nombreClasePrestacion) {
		this.nombreClasePrestacion = nombreClasePrestacion;
	}

	public String getNombreUnidadMedida() {
		return nombreUnidadMedida;
	}

	public void setNombreUnidadMedida(String nombreUnidadMedida) {
		this.nombreUnidadMedida = nombreUnidadMedida;
	}

	public String getNombreP1() {
		return nombreP1;
	}

	public void setNombreP1(String nombreP1) {
		this.nombreP1 = nombreP1;
	}

	public String getNombreP2() {
		return nombreP2;
	}

	public void setNombreP2(String nombreP2) {
		this.nombreP2 = nombreP2;
	}

	public String getNombreClasFiscal() {
		return nombreClasFiscal;
	}

	public void setNombreClasFiscal(String nombreClasFiscal) {
		this.nombreClasFiscal = nombreClasFiscal;
	}

	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getPrestacionDefault() {
		return prestacionDefault;
	}

	public void setPrestacionDefault(Integer prestacionDefault) {
		this.prestacionDefault = prestacionDefault;
	}

	public Integer getOrigenPrestacion() {
		return origenPrestacion;
	}

	public void setOrigenPrestacion(Integer origenPrestacion) {
		this.origenPrestacion = origenPrestacion;
	}

	public Integer getAdmProfSaludGralId() {
		return admProfSaludGralId;
	}

	public void setAdmProfSaludGralId(Integer admProfSaludGralId) {
		this.admProfSaludGralId = admProfSaludGralId;
	}

	public Integer getPeticionesClinicasId() {
		return peticionesClinicasId;
	}

	public void setPeticionesClinicasId(Integer peticionesClinicasId) {
		this.peticionesClinicasId = peticionesClinicasId;
	}

	public Integer getEstudiosPeticionesId() {
		return estudiosPeticionesId;
	}

	public void setEstudiosPeticionesId(Integer estudiosPeticionesId) {
		this.estudiosPeticionesId = estudiosPeticionesId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Boolean getCobroOxigeno() {
		return cobroOxigeno;
	}

	public void setCobroOxigeno(Boolean cobroOxigeno) {
		this.cobroOxigeno = cobroOxigeno;
	}

	public Integer getEspecialidadId() {
		return especialidadId;
	}

	public void setEspecialidadId(Integer especialidadId) {
		this.especialidadId = especialidadId;
	}
}