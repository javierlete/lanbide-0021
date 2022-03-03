package com.ipartek.formacion.spring.ipartekify30.entidades;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "artistas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max=45)
	private String nombre;
	@Lob
	private String informacion;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "artista")
	private final Set<Album> albumes = new LinkedHashSet<>();

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() == 0) {
			throw new EntidadesException("No se admiten nombres vacíos");
		}

		this.nombre = nombre.trim();
	}
}
