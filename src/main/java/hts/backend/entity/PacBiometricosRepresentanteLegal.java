package hts.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pac_biometricos_representante_legal")
public class PacBiometricosRepresentanteLegal implements Serializable{

	private Integer biometricoRepresentanteId;
	private Integer representanteId;
	private String tokenBiometrico;
	
	public PacBiometricosRepresentanteLegal(String tokenBiometrico, Integer idRepresentante) {
		this.representanteId = idRepresentante;
		this.tokenBiometrico = tokenBiometrico;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BIOMETRICO_REPRESENTANTE", nullable = false)
	public Integer getBiometricoRepresentanteId() {
		return biometricoRepresentanteId;
	}

	public void setBiometricoRepresentanteId(Integer biometricoRepresentanteId) {
		this.biometricoRepresentanteId = biometricoRepresentanteId;
	}

	@Column(name = "ID_REPRESENTANTE", nullable = false)
	public Integer getRepresentanteId() {
		return representanteId;
	}

	public void setRepresentanteId(Integer representanteId) {
		this.representanteId = representanteId;
	}

	@Column(name = "TOKEN_BIOMETRICO", nullable = false)
	public String getTokenBiometrico() {
		return tokenBiometrico;
	}

	public void setTokenBiometrico(String tokenBiometrico) {
		this.tokenBiometrico = tokenBiometrico;
	}
}
