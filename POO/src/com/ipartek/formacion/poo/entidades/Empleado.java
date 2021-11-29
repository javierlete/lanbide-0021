package com.ipartek.formacion.poo.entidades;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Empleado extends Persona {

	private static final long serialVersionUID = -839819615556057077L;
	
	private String numeroSeguridadSocial;

	public Empleado(Long id, String nombre, Dni dni, String numeroSeguridadSocial) {
		super(id, nombre, dni);
		setNumeroSeguridadSocial(numeroSeguridadSocial);
	}

	public abstract BigDecimal getSueldoMensual();
	
	@Override
	public void setDni(Dni dni) {
		if(dni == null) {
			throw new RuntimeException("No se puede dejar sin rellenar el DNI de un empleado");
		}
		super.setDni(dni);
	}

	public String getNumeroSeguridadSocial() {
		return numeroSeguridadSocial;
	}

	public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
		this.numeroSeguridadSocial = numeroSeguridadSocial;
	}

	@Override
	public String aTexto() {
		return "Empleado[" + super.aTexto() + ", " + getNumeroSeguridadSocial() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroSeguridadSocial);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(numeroSeguridadSocial, other.numeroSeguridadSocial);
	}

	@Override
	public String toString() {
		return "Empleado [numeroSeguridadSocial=" + numeroSeguridadSocial + ", getSueldoMensual()=" + getSueldoMensual()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
