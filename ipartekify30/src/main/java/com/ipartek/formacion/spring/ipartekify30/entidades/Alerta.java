package com.ipartek.formacion.spring.ipartekify30.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Alerta {
	private String texto;
	private String tipo;
}
