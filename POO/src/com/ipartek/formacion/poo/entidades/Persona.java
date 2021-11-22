package com.ipartek.formacion.poo.entidades;

public class Persona {
	// Constantes
	private static final Long ID_MINIMO = 0L;
	private static final Long ID_POR_DEFECTO = 0L;
	
	// Variables de instancia
	private Long id;
	private String nombre;
	
	// Constructores
	public Persona(Long id, String nombre) {
		setId(id);
		setNombre(nombre);
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
		//return "Persona[" + getId() + ", " + getNombre() + "]";
		return String.format("Persona[%s, %s]", getId(), getNombre());
	}
	
	// Getters y Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id < ID_MINIMO) {
			throw new RuntimeException("No se admiten valores menores que 0");
		}
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres vacíos o nulos");
		}
		this.nombre = nombre;
	}
	
}
