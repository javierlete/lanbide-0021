package com.ipartek.formacion.spring;

public class SalidaConsola implements Salida {
	@Override
	public void mostrar(String texto) {
		System.out.println(texto);
	}
}
