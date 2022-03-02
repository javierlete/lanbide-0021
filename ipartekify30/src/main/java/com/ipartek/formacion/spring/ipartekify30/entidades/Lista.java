package com.ipartek.formacion.spring.ipartekify30.entidades;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "listas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;

	@ManyToOne
	private Usuario usuario;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany
	private final Set<Cancion> canciones = new LinkedHashSet<>();
}
