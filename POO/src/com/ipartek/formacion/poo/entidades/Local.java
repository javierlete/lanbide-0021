package com.ipartek.formacion.poo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Local implements Serializable {

	private static final long serialVersionUID = -4309803955819589903L;
	
	private Long id;
	private String nombre;
	private String direccion;
	
	private ArrayList<Persona> personas = new ArrayList<>();

	public Local(String nombre, String direccion) {
		setNombre(nombre);
		setDireccion(direccion);
	}

	public void agregarPersona(Persona persona) {
		if(persona == null) {
			throw new RuntimeException("Se debe pasar una persona");
		}
		personas.add(persona);
	}
	
	public List<Persona> getPersonas() {
		return Collections.unmodifiableList(personas);
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
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}	
}
