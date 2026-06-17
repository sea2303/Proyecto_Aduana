package com.example.ayuda_service;

import com.example.ayuda_service.model.Ayuda;
import com.example.ayuda_service.repository.AyudaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AyudaServiceApplication implements CommandLineRunner {

	private final AyudaRepository repository;

	public AyudaServiceApplication(AyudaRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AyudaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {

		if(repository.count() == 0){

			Ayuda ayuda = new Ayuda();

			ayuda.setTitulo("Ingreso de Vehículos");
			ayuda.setDescripcion("Debe presentar padrón, licencia y seguro internacional.");

			repository.save(ayuda);
		}
	}
}