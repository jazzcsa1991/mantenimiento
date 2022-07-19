package hts.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class AdministrativoApplication {

	public static void main(String[] args) {

		//System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(AdministrativoApplication.class, args);
	}

}
