package com.ipartek.formacion.ipartekify.modelos;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Lista {
	private Long id;
	private String nombre;
	private String descripcion;
	
	private Set<Cancion> canciones = new LinkedHashSet<>();
}
