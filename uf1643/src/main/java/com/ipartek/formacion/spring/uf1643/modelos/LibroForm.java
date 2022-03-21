package com.ipartek.formacion.spring.uf1643.modelos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class LibroForm {
	private Long id;
	@NotNull
	private String titulo;
	@Size(min=10, max=13)
	private String isbn;
	private String descripcion;
}
