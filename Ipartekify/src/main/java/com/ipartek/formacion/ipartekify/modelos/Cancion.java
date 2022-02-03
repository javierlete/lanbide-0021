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
	private Boolean favorito;
	
	private Album album;
	
	public long getMinutos() {
		return tiempo.toMinutes();
	}
	
	public long getSegundos() {
		return tiempo.getSeconds() % 60;
	}
	
	public String getTiempoFormateado() {
		return String.format("%d:%02d", getMinutos(), getSegundos());
	}
}
