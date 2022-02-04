package com.ipartek.formacion.ipartekify.modelos;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario {
	private Long id;
	private String email, password;
	private String rol;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private final Set<Lista> biblioteca = new LinkedHashSet<>();
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private final Set<Cancion> cancionesFavoritas = new HashSet<>();
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private final Set<Album> albumesFavoritos = new HashSet<>();
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private final Set<Artista> artistasFavoritos = new HashSet<>();
}
