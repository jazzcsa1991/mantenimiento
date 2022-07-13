package hts.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "pac_biometricos_paciente")
public class PacBiometricosPaciente implements Serializable {
	
	private Integer biometricoPacienteId;
	private Integer pacienteId;
	private String tokenBiometrico;
	
	
	public PacBiometricosPaciente(String tokenBiometrico, Integer idPaciente) {
		this.pacienteId = idPaciente;
		this.tokenBiometrico = tokenBiometrico;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BIOMETRICO_PACIENTE", nullable = false)
	public Integer getBiometricoPacienteId() {
		return biometricoPacienteId;
	}

	public void setBiometricoPacienteId(Integer biometricoPacienteId) {
		this.biometricoPacienteId = biometricoPacienteId;
	}

	@Column(name = "ID_PACIENTE", nullable = false)
	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}

	@Column(name = "TOKEN_BIOMETRICO", nullable = false)
	public String getTokenBiometrico() {
		return tokenBiometrico;
	}

	public void setTokenBiometrico(String tokenBiometrico) {
		this.tokenBiometrico = tokenBiometrico;
	}
	
	
}
