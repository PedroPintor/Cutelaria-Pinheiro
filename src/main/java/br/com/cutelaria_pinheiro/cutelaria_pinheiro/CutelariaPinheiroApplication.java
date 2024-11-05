package br.com.cutelaria_pinheiro.cutelaria_pinheiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CutelariaPinheiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CutelariaPinheiroApplication.class, args);
	}

}
