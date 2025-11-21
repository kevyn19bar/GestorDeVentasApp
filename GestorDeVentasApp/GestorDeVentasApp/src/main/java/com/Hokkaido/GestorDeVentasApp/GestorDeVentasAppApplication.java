package com.Hokkaido.GestorDeVentasApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.hokkaido.GestorDeVentasApp")
@EntityScan("com.hokkaido.GestorDeVentasApp.entidades")
public class GestorDeVentasAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorDeVentasAppApplication.class, args);
	}

}
