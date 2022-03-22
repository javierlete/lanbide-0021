package com.ipartek.formacion.spring.uf1643.entidades;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "libros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String titulo;

	@Column(unique = true)
	@Size(min = 10, max = 13)
	private String isbn;

	@Lob
	private String descripcion;

	@OneToOne(mappedBy = "libro", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private LibroExtras libroExtras;

	@ManyToOne
	private Autor autor;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "libro")
	private final Set<Capitulo> capitulos = new LinkedHashSet<>();

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany
	private final Set<Categoria> categorias = new HashSet<>();

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "libro")
	private final Set<Resena> resenas = new HashSet<>();
}
