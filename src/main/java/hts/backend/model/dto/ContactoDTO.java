package hts.backend.model.dto;

import java.util.Date;

public class ContactoDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer contactoId;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private Integer respLegal;
	private String curp;
	private String usuarioRegistro;
	private Integer status;

	private NomCatEstadoCivilDTO nomCatEstadoCivil;
	private NomCatSexoDTO nomCatSexo;
	private NomCatEscolaridadDTO nomCatEscolaridad;
	private NomCatOcupacionDTO nomCatOcupacion;
	private NomCatParentescoDTO nomCatParentesco;

	private DocumentoDTO documento;
	private TelefonoDTO telefono;
	private CorreoDTO correo;
	private DireccionDTO direccion;

//	private Integer idPaciente;
//	private Set<AgenteContactoDTO> agenteContactos = new HashSet<AgenteContactoDTO>(0);

	public ContactoDTO() {
	}


	public Integer getContactoId() {
		return this.contactoId;
	}

	public void setContactoId(Integer contactoId) {
		this.contactoId = contactoId;
	}

	public NomCatEstadoCivilDTO getNomCatEstadoCivil() {
		return this.nomCatEstadoCivil;
	}

	public void setNomCatEstadoCivil(NomCatEstadoCivilDTO nomCatEstadoCivil) {
		this.nomCatEstadoCivil = nomCatEstadoCivil;
	}

	public NomCatSexoDTO getNomCatSexo() {
		return this.nomCatSexo;
	}

	public void setNomCatSexo(NomCatSexoDTO nomCatSexo) {
		this.nomCatSexo = nomCatSexo;
	}

	public NomCatEscolaridadDTO getNomCatEscolaridad() {
		return this.nomCatEscolaridad;
	}

	public void setNomCatEscolaridad(NomCatEscolaridadDTO nomCatEscolaridad) {
		this.nomCatEscolaridad = nomCatEscolaridad;
	}

	public NomCatOcupacionDTO getNomCatOcupacion() {
		return this.nomCatOcupacion;
	}

	public void setNomCatOcupacion(NomCatOcupacionDTO nomCatOcupacion) {
		this.nomCatOcupacion = nomCatOcupacion;
	}

	public NomCatParentescoDTO getNomCatParentesco() {
		return this.nomCatParentesco;
	}

	public void setNomCatParentesco(NomCatParentescoDTO nomCatParentesco) {
		this.nomCatParentesco = nomCatParentesco;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getRespLegal() {
		return this.respLegal;
	}

	public void setRespLegal(Integer respLegal) {
		this.respLegal = respLegal;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	/*public Set<AgenteContactoDTO> getAgenteContactos() {
		return this.agenteContactos;
	}

	public void setAgenteContactos(Set<AgenteContactoDTO> agenteContactos) {
		this.agenteContactos = agenteContactos;
	}*/

	public TelefonoDTO getTelefono() {
		return telefono;
	}

	public void setTelefono(TelefonoDTO telefono) {
		this.telefono = telefono;
	}

	public DocumentoDTO getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoDTO documento) {
		this.documento = documento;
	}

	public CorreoDTO getCorreo() {
		return correo;
	}

	public void setCorreo(CorreoDTO correo) {
		this.correo = correo;
	}

	public DireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/*public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}*/

}
