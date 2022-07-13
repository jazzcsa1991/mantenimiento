package hts.backend.model.dto;

import java.util.Date;

public class CoreDefuncionDTO {

	private Integer defuncionId;
	private Integer eventoId;
	private Integer circunstanciaDefuncionId;
	private String  descCircunstanciaDefuncion;
	private String  descUnidadMedica;
	private String  nombreProfesional;
	private String certificado;
	private String observaciones;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private Date fechaDefuncion;
	private Integer estatus;
	private Integer pacienteId;
	private Integer cie10Id;
	private String descCie10;
	private Integer camaId;
	private Integer consultorioId;
	private Integer earBqrId;
	private Integer earUrgId;
	private Integer cirugiaId;

	public Integer getEarBqrId() {
		return earBqrId;
	}

	public void setEarBqrId(Integer earBqrId) {
		this.earBqrId = earBqrId;
	}

	public Integer getEarUrgId() {
		return earUrgId;
	}

	public void setEarUrgId(Integer earUrgId) {
		this.earUrgId = earUrgId;
	}

	public Integer getCamaId() {
		return camaId;
	}

	public void setCamaId(Integer camaId) {
		this.camaId = camaId;
	}

	public Integer getConsultorioId() {
		return consultorioId;
	}

	public void setConsultorioId(Integer consultorioId) {
		this.consultorioId = consultorioId;
	}

	public Integer getCie10Id() {
		return cie10Id;
	}

	public void setCie10Id(Integer cie10Id) {
		this.cie10Id = cie10Id;
	}

	public String getDescCie10() {
		return descCie10;
	}

	public void setDescCie10(String descCie10) {
		this.descCie10 = descCie10;
	}

	public String getDescCircunstanciaDefuncion() {
		return descCircunstanciaDefuncion;
	}

	public void setDescCircunstanciaDefuncion(String descCircunstanciaDefuncion) {
		this.descCircunstanciaDefuncion = descCircunstanciaDefuncion;
	}

	public String getDescUnidadMedica() {
		return descUnidadMedica;
	}

	public void setDescUnidadMedica(String descUnidadMedica) {
		this.descUnidadMedica = descUnidadMedica;
	}

	public String getNombreProfesional() {
		return nombreProfesional;
	}

	public void setNombreProfesional(String nombreProfesional) {
		this.nombreProfesional = nombreProfesional;
	}

	public Integer getDefuncionId() {
		return defuncionId;
	}

	public void setDefuncionId(Integer defuncionId) {
		this.defuncionId = defuncionId;
	}

	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	public Integer getCircunstanciaDefuncionId() {
		return circunstanciaDefuncionId;
	}

	public void setCircunstanciaDefuncionId(Integer circunstanciaDefuncionId) {
		this.circunstanciaDefuncionId = circunstanciaDefuncionId;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaDefuncion() {
		return fechaDefuncion;
	}

	public void setFechaDefuncion(Date fechaDefuncion) {
		this.fechaDefuncion = fechaDefuncion;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Integer getCirugiaId() {
		return cirugiaId;
	}

	public void setCirugiaId(Integer cirugiaId) {
		this.cirugiaId = cirugiaId;
	}
}
