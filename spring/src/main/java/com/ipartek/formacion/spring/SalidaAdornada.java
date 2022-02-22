package com.ipartek.formacion.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class SalidaAdornada implements Salida {
	@Override
	public void mostrar(String texto) {
		System.out.println("---" + texto + "---");
	}
}
