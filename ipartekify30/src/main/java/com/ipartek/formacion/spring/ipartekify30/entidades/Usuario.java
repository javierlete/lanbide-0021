package com.ipartek.formacion.spring.ipartekify30.entidades;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max=45)
	@Email
	@Column(unique=true)
	private String email;
	@NotNull
	@Size(max=60)
	@Column(length=60) // columnDefinition="CHAR(60)")
	private String password;
	@NotNull
	@Size(max=45)
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
	private Set<Artista> artistasFavoritos = new HashSet<>();
}
