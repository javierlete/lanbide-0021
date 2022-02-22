package com.ipartek.formacion.spring;

public class SalidaAdornada implements Salida {
	@Override
	public void mostrar(String texto) {
		System.out.println("---" + texto + "---");
	}
}
