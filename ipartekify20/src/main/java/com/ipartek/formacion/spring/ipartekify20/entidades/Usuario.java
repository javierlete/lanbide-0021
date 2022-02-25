package com.ipartek.formacion.spring.ipartekify20.entidades;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "usuarios")
@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email, password;
	private String rol;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "usuario")
	private final Set<Lista> biblioteca = new LinkedHashSet<>();
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany
	private final Set<Cancion> cancionesFavoritas = new HashSet<>();
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany
	private final Set<Album> albumesFavoritos = new HashSet<>();
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany
	private final Set<Artista> artistasFavoritos = new HashSet<>();
}
