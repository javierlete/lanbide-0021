package com.ipartek.formacion.ipartekify.modelos;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor
public class Lista {
	private Long id;
	private String nombre;
	private String descripcion;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private final Set<Cancion> canciones = new LinkedHashSet<>();
}
