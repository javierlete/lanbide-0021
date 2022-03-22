package com.ipartek.formacion.spring.uf1643.entidades;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="libro_extras")
@Data @AllArgsConstructor @NoArgsConstructor
public class LibroExtras {
	@Lob
	private String comentarios;
	
	@Lob
	private String dedicatoria;
	
	// Normalmente no lo pondría, pero en el caso de hacerlo lo haria así
	@NotNull
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne
	@MapsId
	private Libro libro;
}
