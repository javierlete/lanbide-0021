package com.ipartek.formacion.uf2218.modelos;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Evento {
	private Long id;
	private String nombre;
	private LocalDateTime fecha;
	
	private Usuario responsable;
	
	private Set<Usuario> participantes = new HashSet<>();

	public Evento(Long id, String nombre, LocalDateTime fecha, Usuario responsable, Set<Usuario> participantes) {
		setId(id);
		setNombre(nombre);
		setFecha(fecha);
		setResponsable(responsable);
		setParticipantes(participantes);
	}

	public Evento(Long id, String nombre, LocalDateTime fecha, Usuario responsable) {
		this(id, nombre, fecha, responsable, new HashSet<>());
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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Usuario getResponsable() {
		return responsable;
	}

	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}

	public Set<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Usuario> participantes) {
		this.participantes = participantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, id, nombre, participantes, responsable);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(participantes, other.participantes)
				&& Objects.equals(responsable, other.responsable);
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", responsable=" + responsable
				+ ", participantes=" + participantes + "]";
	}

	
}
