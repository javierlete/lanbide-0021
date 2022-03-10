package com.ipartek.formacion.spring.ipartekify30.modelos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistaDTO {
	private Long id;
	@NotNull
	@NotBlank
	@Size(max=45)
	private String nombre;
	private String informacion;
}
