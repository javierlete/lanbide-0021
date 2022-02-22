package com.ipartek.formacion.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// DI: Dependency Injection
// IoC: Inversion of Control

@SpringBootApplication
public class App implements CommandLineRunner {
	@Autowired
	private Salida salida;
	@Autowired
	private Entrada entrada;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		salida.mostrar(entrada.recibir());
	}
}
