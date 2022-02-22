package com.ipartek.formacion.spring;

import org.springframework.stereotype.Component;

@Component
public class SalidaConsola implements Salida {
	@Override
	public void mostrar(String texto) {
		System.out.println(texto);
	}
}
