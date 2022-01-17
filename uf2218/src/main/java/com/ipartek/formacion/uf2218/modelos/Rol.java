package com.ipartek.formacion.uf2218.modelos;

import java.util.ArrayList;
import java.util.Objects;

public class Rol {
	private Long id;
	private String nombre, descripcion;
	
	private Iterable<Usuario> usuarios = new ArrayList<>();
	
	public Rol(Long id, String nombre, String descripcion) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Iterable<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Iterable<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
}
