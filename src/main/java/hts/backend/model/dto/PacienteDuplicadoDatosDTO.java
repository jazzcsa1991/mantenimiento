package hts.backend.model.dto;

import java.util.Date;
import java.util.List;

public class PacienteDuplicadoDatosDTO {
	private Integer idPaciente;
	private String noPaciente;
	private String noExpediente;
	private String tipoExpediente;
	private Integer tipoExpediente_id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private Date fechaIdTipoSangre;
	private Integer fechaEstimada;
	private Date fechaRegistro;
	private String curp;
	private String nacionalidad;
	private Integer nacionalidad_id;
	private String entidadNacimiento;
	private Integer entidadNacimiento_id;
	private String entidadNacimiento_cve;
	private String municipioNacimiento;
	private Integer municipioNacimiento_id;
	private String municipioNacimiento_cve;
	private Float peso;
	private Float talla;
	private String sexo;
	private Integer sexo_id;
	private String religion;
	private String religion_id;
	private Integer fallecido;
	private String tipoSangre;
	private Integer tipoSangre_id;
	private String procedencia;
	private Integer procedencia_id;
	private String estadoCivil;
	private Integer estadoCivil_id;
	private String escolaridad;
	private Integer escolaridad_id;
	private String indigena;
	private Integer indigena_id;
	private String hablaIndigena;
	private Integer hablaIndigena_id;
	private String hablaEspanol;
	private Integer hablaEspanol_id;
	private String trabajaActualmente;
	private Integer trabajaActualmente_id;
	private String tipoLenguaIndigena;
	private Integer tipoLenguaIndigena_id;
	private String ocupacion;
	private Integer ocupacion_id;
	private String servicioEspRegistro;
	private Integer servicioEspRegistro_id;
	private Integer datosProductoId;
	private Integer tipoEvento;
	private Integer hospitalId;
	private Integer migrante;
	private Integer factorRH;
	private String hospital;
	private String paciente;
	private String calle;
	private String colonia;
	private String municipio;
	private Integer desconoceCurp;
	private Integer confirmarCronico;
	private List<AdmAlertasDTO> listaAlertas;
	private String fotoPaciente;
	
	private List<BiometricosDTO> biometricos;

	public Integer getConfirmarCronico() {
		return confirmarCronico;
	}

	public void setConfirmarCronico(Integer confirmarCronico) {
		this.confirmarCronico = confirmarCronico;
	}

	public Integer getDesconoceCurp() {
		return desconoceCurp;
	}

	public void setDesconoceCurp(Integer desconoceCurp) {
		this.desconoceCurp = desconoceCurp;
	}

	public Integer getFechaEstimada() {
		return fechaEstimada;
	}

	public void setFechaEstimada(Integer fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public List<AdmAlertasDTO> getListaAlertas() {
		return listaAlertas;
	}

	public void setListaAlertas(List<AdmAlertasDTO> listaAlertas) {
		this.listaAlertas = listaAlertas;
	}

	public Integer getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(Integer tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Integer getDatosProductoId() {
		return datosProductoId;
	}

	public void setDatosProductoId(Integer datosProductoId) {
		this.datosProductoId = datosProductoId;
	}

	public String getNoPaciente() {
		return noPaciente;
	}

	public void setNoPaciente(String noPaciente) {
		this.noPaciente = noPaciente;
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEntidadNacimiento() {
		return entidadNacimiento;
	}

	public void setEntidadNacimiento(String entidadNacimiento) {
		this.entidadNacimiento = entidadNacimiento;
	}

	public String getMunicipioNacimiento() {
		return municipioNacimiento;
	}

	public void setMunicipioNacimiento(String municipioNacimiento) {
		this.municipioNacimiento = municipioNacimiento;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getTalla() {
		return talla;
	}

	public void setTalla(Float talla) {
		this.talla = talla;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public Integer getFallecido() {
		return fallecido;
	}

	public void setFallecido(Integer fallecido) {
		this.fallecido = fallecido;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	public String getIndigena() {
		return indigena;
	}

	public void setIndigena(String indigena) {
		this.indigena = indigena;
	}

	public String getHablaIndigena() {
		return hablaIndigena;
	}

	public void setHablaIndigena(String hablaIndigena) {
		this.hablaIndigena = hablaIndigena;
	}

	public String getHablaEspanol() {
		return hablaEspanol;
	}

	public void setHablaEspanol(String hablaEspanol) {
		this.hablaEspanol = hablaEspanol;
	}

	public String getTrabajaActualmente() {
		return trabajaActualmente;
	}

	public void setTrabajaActualmente(String trabajaActualmente) {
		this.trabajaActualmente = trabajaActualmente;
	}

	public String getTipoLenguaIndigena() {
		return tipoLenguaIndigena;
	}

	public void setTipoLenguaIndigena(String tipoLenguaIndigena) {
		this.tipoLenguaIndigena = tipoLenguaIndigena;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getNoExpediente() {
		return noExpediente;
	}

	public void setNoExpediente(String noExpediente) {
		this.noExpediente = noExpediente;
	}

	public String getTipoExpediente() {
		return tipoExpediente;
	}

	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
	}

	public String getServicioEspRegistro() {
		return servicioEspRegistro;
	}

	public void setServicioEspRegistro(String servicioEspRegistro) {
		this.servicioEspRegistro = servicioEspRegistro;
	}

	public Integer getTipoExpediente_id() {
		return tipoExpediente_id;
	}

	public void setTipoExpediente_id(Integer tipoExpediente_id) {
		this.tipoExpediente_id = tipoExpediente_id;
	}

	public Integer getNacionalidad_id() {
		return nacionalidad_id;
	}

	public void setNacionalidad_id(Integer nacionalidad_id) {
		this.nacionalidad_id = nacionalidad_id;
	}

	public Integer getEntidadNacimiento_id() {
		return entidadNacimiento_id;
	}

	public void setEntidadNacimiento_id(Integer entidadNacimiento_id) {
		this.entidadNacimiento_id = entidadNacimiento_id;
	}

	public Integer getMunicipioNacimiento_id() {
		return municipioNacimiento_id;
	}

	public void setMunicipioNacimiento_id(Integer municipioNacimiento_id) {
		this.municipioNacimiento_id = municipioNacimiento_id;
	}

	public Integer getSexo_id() {
		return sexo_id;
	}

	public void setSexo_id(Integer sexo_id) {
		this.sexo_id = sexo_id;
	}

	public String getReligion_id() {
		return religion_id;
	}

	public void setReligion_id(String religion_id) {
		this.religion_id = religion_id;
	}

	public Integer getTipoSangre_id() {
		return tipoSangre_id;
	}

	public void setTipoSangre_id(Integer tipoSangre_id) {
		this.tipoSangre_id = tipoSangre_id;
	}

	public Integer getProcedencia_id() {
		return procedencia_id;
	}

	public void setProcedencia_id(Integer procedencia_id) {
		this.procedencia_id = procedencia_id;
	}

	public Integer getEstadoCivil_id() {
		return estadoCivil_id;
	}

	public void setEstadoCivil_id(Integer estadoCivil_id) {
		this.estadoCivil_id = estadoCivil_id;
	}

	public Integer getEscolaridad_id() {
		return escolaridad_id;
	}

	public void setEscolaridad_id(Integer escolaridad_id) {
		this.escolaridad_id = escolaridad_id;
	}

	public Integer getIndigena_id() {
		return indigena_id;
	}

	public void setIndigena_id(Integer indigena_id) {
		this.indigena_id = indigena_id;
	}

	public Integer getHablaIndigena_id() {
		return hablaIndigena_id;
	}

	public void setHablaIndigena_id(Integer hablaIndigena_id) {
		this.hablaIndigena_id = hablaIndigena_id;
	}

	public Integer getHablaEspanol_id() {
		return hablaEspanol_id;
	}

	public void setHablaEspanol_id(Integer hablaEspanol_id) {
		this.hablaEspanol_id = hablaEspanol_id;
	}

	public Integer getTrabajaActualmente_id() {
		return trabajaActualmente_id;
	}

	public void setTrabajaActualmente_id(Integer trabajaActualmente_id) {
		this.trabajaActualmente_id = trabajaActualmente_id;
	}

	public Integer getTipoLenguaIndigena_id() {
		return tipoLenguaIndigena_id;
	}

	public void setTipoLenguaIndigena_id(Integer tipoLenguaIndigena_id) {
		this.tipoLenguaIndigena_id = tipoLenguaIndigena_id;
	}

	public Integer getOcupacion_id() {
		return ocupacion_id;
	}

	public void setOcupacion_id(Integer ocupacion_id) {
		this.ocupacion_id = ocupacion_id;
	}

	public Integer getServicioEspRegistro_id() {
		return servicioEspRegistro_id;
	}

	public void setServicioEspRegistro_id(Integer servicioEspRegistro_id) {
		this.servicioEspRegistro_id = servicioEspRegistro_id;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getEntidadNacimiento_cve() {
		return entidadNacimiento_cve;
	}

	public void setEntidadNacimiento_cve(String entidadNacimiento_cve) {
		this.entidadNacimiento_cve = entidadNacimiento_cve;
	}

	public String getMunicipioNacimiento_cve() {
		return municipioNacimiento_cve;
	}

	public void setMunicipioNacimiento_cve(String municipioNacimiento_cve) {
		this.municipioNacimiento_cve = municipioNacimiento_cve;
	}


	public Integer getMigrante() {
		return migrante;
	}

	public void setMigrante(Integer migrante) {
		this.migrante = migrante;
	}

	public Integer getFactorRH() {
		return factorRH;
	}

	public void setFactorRH(Integer factorRH) {
		this.factorRH = factorRH;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public Date getFechaIdTipoSangre() {
		return fechaIdTipoSangre;
	}

	public void setFechaIdTipoSangre(Date fechaIdTipoSangre) {
		this.fechaIdTipoSangre = fechaIdTipoSangre;
	}

	public String getFotoPaciente() {
		return fotoPaciente;
	}

	public void setFotoPaciente(String fotoPaciente) {
		this.fotoPaciente = fotoPaciente;
	}

	public List<BiometricosDTO> getBiometricos() {
		return biometricos;
	}

	public void setBiometricos(List<BiometricosDTO> biometricos) {
		this.biometricos = biometricos;
	}	
	
}
