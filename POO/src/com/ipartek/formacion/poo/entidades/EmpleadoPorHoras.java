package com.ipartek.formacion.poo.entidades;

import java.math.BigDecimal;
import java.util.Objects;

public class EmpleadoPorHoras extends Empleado {

	private static final long serialVersionUID = 4874255501092760143L;

	private BigDecimal precioHora;
	private int numeroHorasMensuales;
	
	public EmpleadoPorHoras(Long id, String nombre, Dni dni, String numeroSeguridadSocial, BigDecimal precioHora,
			int numeroHorasMensuales) {
		super(id, nombre, dni, numeroSeguridadSocial);
		setPrecioHora(precioHora);
		setNumeroHorasMensuales(numeroHorasMensuales);
	}
	
	public BigDecimal getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(BigDecimal precioHora) {
		this.precioHora = precioHora;
	}

	public int getNumeroHorasMensuales() {
		return numeroHorasMensuales;
	}

	public void setNumeroHorasMensuales(int numeroHorasMensuales) {
		this.numeroHorasMensuales = numeroHorasMensuales;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return precioHora.multiply(new BigDecimal(numeroHorasMensuales));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroHorasMensuales, precioHora);
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
		EmpleadoPorHoras other = (EmpleadoPorHoras) obj;
		return numeroHorasMensuales == other.numeroHorasMensuales && Objects.equals(precioHora, other.precioHora);
	}

	@Override
	public String toString() {
		return "EmpleadoPorHoras [precioHora=" + precioHora + ", numeroHorasMensuales=" + numeroHorasMensuales
				+ ", toString()=" + super.toString() + "]";
	}
	
}
