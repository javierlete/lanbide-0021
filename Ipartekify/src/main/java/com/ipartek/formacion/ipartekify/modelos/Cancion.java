package com.ipartek.formacion.ipartekify.modelos;

import java.time.Duration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Cancion {
	private Long id;
	private String nombre;
	private Duration tiempo;
	private String mp3;
	
	private Album album;
}
