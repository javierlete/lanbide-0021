package com.ipartek.formacion.poo.entidades;

import java.util.Objects;

public class Persona {
	// Constantes
	private static final Long ID_MINIMO = 0L;
	private static final Long ID_POR_DEFECTO = 0L;

	// Variables de instancia
	private Long id;
	private String nombre;
	private Dni dni;

	// Constructores
	public Persona(Long id, String nombre, Dni dni) {
		setId(id);
		setNombre(nombre);
		setDni(dni);
	}

	public Persona(Long id, String nombre) {
		this(id, nombre, null);
	}

	// "Constructor de copia"
	public Persona(Persona persona) {
		this(persona.getId(), persona.getNombre());
	}

	public Persona(String nombre) {
		this(ID_POR_DEFECTO, nombre);
	}

	public Persona() {
		this(ID_POR_DEFECTO, "DESCONOCIDO");
	}

	// Métodos de instancia propios
	public String aTexto() {
		// return "Persona[" + getId() + ", " + getNombre() + "]" + getDni() != null ? getDni().getTexto() : "SIN DNI";
		return String.format("Persona[%s, %s, %s]", getId(), getNombre(),
				getDni() != null ? getDni().getTexto() : "SIN DNI");
		
//		if(getDni() != null) {
//			return getDni().getTexto();
//		} else {
//			return "SIN DNI";
//		}
	}

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id < ID_MINIMO) {
			throw new RuntimeException("No se admiten valores menores que 0");
		}
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres vacíos o nulos");
		}
		this.nombre = nombre;
	}

	public Dni getDni() {
		return dni;
	}

	public void setDni(Dni dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", dni=" + dni + "]";
	}

	
}
