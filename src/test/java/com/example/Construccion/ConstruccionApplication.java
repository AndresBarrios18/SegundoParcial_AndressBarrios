package com.example.Construccion;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = {
		"com.example.auditoria.entity",
		"com.example.commons.entity",
		"com.example.habitaciones.entity",
		"com.example.historia.entity",
		"com.example.persistencia.entity",
		"com.example.preferenciaestudiante.entity",
		"com.example.seguridad.entity",
		"com.example.universidadamenidad.entity",
		"com.example.usuariospropietario.entity"
})
public class ConstruccionApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConstruccionApplication.class, args);
	}
}
