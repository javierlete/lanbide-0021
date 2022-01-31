package com.ipartek.formacion.ipartekify.modelos;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario {
	private Long id;
	private String email, password;
	private String rol;
	
	private Set<Lista> biblioteca = new LinkedHashSet<>();
	
	private Set<Cancion> cancionesFavoritas = new HashSet<>();
	private Set<Album> albumesFavoritos = new HashSet<>();
	private Set<Artista> artistasFavoritos = new HashSet<>();
}
