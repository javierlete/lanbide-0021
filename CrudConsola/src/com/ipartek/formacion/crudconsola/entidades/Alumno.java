package com.ipartek.formacion.crudconsola.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {
	private Long id;
	private String nombre;
	private LocalDate fechaNacimiento;
	private Double notaMedia;
	
	public Alumno(Long id, String nombre, LocalDate fechaNacimiento, Double notaMedia) {
		setId(id);
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
		setNotaMedia(notaMedia);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null) {
			throw new EntidadesException("No se admiten nombres nulos");
		}
		
		nombre = nombre.trim();
		
		if(!nombre.matches("[\\p{L} ]{5,50}")) {
			throw new EntidadesException("El nombre debe tener de 5 a 50 caracteres");
		}
		
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento == null) {
			throw new EntidadesException("La fecha de nacimiento es obligatoria");
		}
		
		if(fechaNacimiento.isAfter(LocalDate.now())) {
			throw new EntidadesException("No se aceptan viajeros del futuro");
		}
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public Double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(Double notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, id, nombre, notaMedia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(notaMedia, other.notaMedia);
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", notaMedia="
				+ notaMedia + "]";
	}
	
	
}
