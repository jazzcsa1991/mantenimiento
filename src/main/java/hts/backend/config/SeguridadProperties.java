package hts.backend.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "security")
@Component
public class SeguridadProperties {
	
	private List<String> allowedAdmin;

	public List<String> getAllowedAdmin() {
		return allowedAdmin;
	}

	public void setAllowedAdmin(List<String> allowedAdmin) {
		this.allowedAdmin = allowedAdmin;
	}

}
