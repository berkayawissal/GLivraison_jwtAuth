package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
public class GestionDeLivraisonApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeLivraisonApplication .class, args);
	}

}
