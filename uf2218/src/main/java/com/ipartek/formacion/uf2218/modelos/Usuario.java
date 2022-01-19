package com.ipartek.formacion.uf2218.modelos;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class Usuario {
	private Long id;
	private String email, password;
	private String nombre;
	
	private Rol rol;
	
	private Set<Evento> eventos = new HashSet<>();
	
	private Map<String, String> errores = new TreeMap<>();
	
	public Usuario(Long id, String email, String password, String nombre, Rol rol) {
		setId(id);
		setEmail(email);
		setPassword(password);
		setNombre(nombre);
		setRol(rol);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email == null || email.trim().length() == 0) {
			errores.put("email", "El email debe estar rellenado");
		}
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password == null || password.trim().length() == 0) {
			errores.put("password", "La contraseña debe estar rellenada");
		}
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() < 3) {
			errores.put("nombre", "El nombre debe tener al menos 3 caracteres y es obligatorio");
		}
		this.nombre = nombre;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		if(rol == null) {
			errores.put("rol", "Es obligatorio rellenar el Rol");
		}
		this.rol = rol;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nombre, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", nombre=" + nombre + "]";
	}
	
	
}
