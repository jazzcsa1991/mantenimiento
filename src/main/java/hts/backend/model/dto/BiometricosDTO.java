package hts.backend.model.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class BiometricosDTO implements Serializable {
	
	private String tokenBiometrico;


	public String getTokenBiometrico() {
		return tokenBiometrico;
	}

	public void setTokenBiometrico(String tokenBiometrico) {
		this.tokenBiometrico = tokenBiometrico;
	}
	
	
}
