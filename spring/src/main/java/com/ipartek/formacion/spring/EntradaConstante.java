package com.ipartek.formacion.spring;

import org.springframework.stereotype.Component;

@Component
public class EntradaConstante implements Entrada {
	@Override
	public String recibir() {
		return "Hola a todos";
	}
}
