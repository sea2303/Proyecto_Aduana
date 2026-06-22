package com.example.pdi_service;

import com.example.pdi_service.model.Cruce;
import com.example.pdi_service.repository.CruceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdiServiceApplication implements CommandLineRunner {

	private final CruceRepository repository;

	public PdiServiceApplication(CruceRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PdiServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {

		if (repository.count() == 0) {

			Cruce cruce = new Cruce();

			cruce.setRut("12345678-9");
			cruce.setNombreCompleto("Juan Pérez");
			cruce.setNacionalidad("Chilena");
			cruce.setDestino("Argentina");
			cruce.setFechaIngreso("2026-06-20");
			cruce.setEstadoMigratorio("APROBADO");

			repository.save(cruce);
		}
	}
}