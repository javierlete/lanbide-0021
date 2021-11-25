package com.ipartek.formacion.poo.entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class EmpleadoIndefinido extends Empleado {
	private BigDecimal sueldoAnual;
	private int numeroPagas;

	public EmpleadoIndefinido(Long id, String nombre, Dni dni, String numeroSeguridadSocial, BigDecimal sueldoAnual, int numeroPagas) {
		super(id, nombre, dni, numeroSeguridadSocial);
		setSueldoAnual(sueldoAnual);
		setNumeroPagas(numeroPagas);
	}

	public BigDecimal getSueldoAnual() {
		return sueldoAnual;
	}

	public void setSueldoAnual(BigDecimal sueldoAnual) {
		this.sueldoAnual = sueldoAnual;
	}

	public int getNumeroPagas() {
		return numeroPagas;
	}

	public void setNumeroPagas(int numeroPagas) {
		this.numeroPagas = numeroPagas;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(numeroPagas), RoundingMode.HALF_EVEN);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroPagas, sueldoAnual);
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
		EmpleadoIndefinido other = (EmpleadoIndefinido) obj;
		return numeroPagas == other.numeroPagas && Objects.equals(sueldoAnual, other.sueldoAnual);
	}

	@Override
	public String toString() {
		return "EmpleadoIndefinido [sueldoAnual=" + sueldoAnual + ", numeroPagas=" + numeroPagas + ", toString()="
				+ super.toString() + "]";
	}
}
