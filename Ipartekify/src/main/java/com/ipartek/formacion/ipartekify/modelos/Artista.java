package com.ipartek.formacion.ipartekify.modelos;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Artista {
	private Long id;
	private String nombre;
	private String informacion;
	
	private final Set<Album> albumes = new LinkedHashSet<>();
	
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres vacíos");
		}
		
		this.nombre = nombre;
	}
}
