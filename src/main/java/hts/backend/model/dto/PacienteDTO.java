package hts.backend.model.dto;

import java.util.Date;

public class PacienteDTO {

	private Integer idPaciente;
	private Integer tipoExpedienteId;
	private String tipoExpediente;
	private String noPaciente;
	private String noExpediente;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private Integer fechaEstimada;
	private String curp;
	private Integer sexoId;
	private Integer fallecido;
	private Date vigencia;
	private Integer AseguradoraNSE;
	private Integer convenio;
	private Integer Duplicado;
	private String nombreConvenio;
	private String usuarioRegistra;
	private String nombreAseguradora;
	private Integer idAseg;
	private Integer idEvento;
	private Integer nacionalidad;
	private String telefono;
	private Integer tipoTel;
	private Integer defuncionId;
	private Integer expedienteId;
	private Integer hospitalId;
	private String hospital;
	private String fotoPaciente;

	public Integer getFechaEstimada() {
		return fechaEstimada;
	}

	public void setFechaEstimada(Integer fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getTipoTel() {
		return tipoTel;
	}

	public void setTipoTel(Integer tipoTel) {
		this.tipoTel = tipoTel;
	}

	public Integer getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Integer nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getUsuarioRegistra() {
		return usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Integer getTipoExpedienteId() {
		return tipoExpedienteId;
	}

	public void setTipoExpedienteId(Integer tipoExpedienteId) {
		this.tipoExpedienteId = tipoExpedienteId;
	}

	public String getNoPaciente() {
		return noPaciente;
	}

	public void setNoPaciente(String noPaciente) {
		this.noPaciente = noPaciente;
	}

	public String getNoExpediente() {
		return noExpediente;
	}

	public void setNoExpediente(String noExpediente) {
		this.noExpediente = noExpediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Integer getSexoId() {
		return sexoId;
	}

	public void setSexoId(Integer sexoId) {
		this.sexoId = sexoId;
	}

	public Integer getFallecido() {
		return fallecido;
	}

	public void setFallecido(Integer fallecido) {
		this.fallecido = fallecido;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public Integer getAseguradoraNSE() {
		return AseguradoraNSE;
	}

	public void setAseguradoraNSE(Integer aseguradoraNSE) {
		AseguradoraNSE = aseguradoraNSE;
	}

	public Integer getConvenio() {
		return convenio;
	}

	public void setConvenio(Integer convenio) {
		this.convenio = convenio;
	}

	public Integer getDuplicado() {
		return Duplicado;
	}

	public void setDuplicado(Integer duplicado) {
		Duplicado = duplicado;
	}

	public String getNombreAseguradora() {
		return nombreAseguradora;
	}

	public void setNombreAseguradora(String nombreAseguradora) {
		this.nombreAseguradora = nombreAseguradora;
	}

	public String getNombreConvenio() {
		return nombreConvenio;
	}

	public void setNombreConvenio(String nombreConvenio) {
		this.nombreConvenio = nombreConvenio;
	}


	public Integer getIdAseg() {
		return idAseg;
	}

	public void setIdAseg(Integer idAseg) {
		this.idAseg = idAseg;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getTipoExpediente() {
		return tipoExpediente;
	}

	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
	}

	public Integer getDefuncionId() {
		return defuncionId;
	}

	public void setDefuncionId(Integer defuncionId) {
		this.defuncionId = defuncionId;
	}

	public Integer getExpedienteId() {
		return expedienteId;
	}

	public void setExpedienteId(Integer expedienteId) {
		this.expedienteId = expedienteId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getFotoPaciente() {
		return fotoPaciente;
	}

	public void setFotoPaciente(String fotoPaciente) {
		this.fotoPaciente = fotoPaciente;
	}
	
	
}
