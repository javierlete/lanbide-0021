package com.ipartek.formacion.poo.entidades;

import java.io.Serializable;
import java.util.Objects;

public class Dni implements Serializable {
	
	private static final long serialVersionUID = -1881832278459821439L;
	
	private static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
	private static final String REGEX_NUMERO = "^[XYZ\\d]\\d{7}$";
	private static final String REGEX_DNI = "^[XYZ\\d]\\d{7}[TRWAGMYFPDXBNJZSQVHLCKE]$";
	
	private String numero;

	public Dni(String dni) {
		setTexto(dni);
	}
	
	public String getNumero() {
		return numero;
	}

	private void setNumero(String numero) {
		if(!numero.matches(REGEX_NUMERO)) {
			throw new RuntimeException("Número de DNI incorrecto");
		}
		
		this.numero = numero;
	}

	public Character getLetra() {
		return getLetra(numero); 
	}
	
	// Método estático ("de clase")
	public static Character getLetra(String numero) {
		String numeroLimpio = numero.replace('X', '0').replace('Y', '1').replace('Z', '2');
		
		return LETRAS.charAt(Integer.parseInt(numeroLimpio) % 23);
	}
	
	public String getTexto() {
		return getNumero() + getLetra();
	}
	
	private void setTexto(String dni) {
		if(!dni.matches(REGEX_DNI)) {
			throw new RuntimeException("Formato DNI incorrecto");
		}
		
		String numero = dni.substring(0,8);
		
		if(dni.charAt(8) != getLetra(numero)) {
			throw new RuntimeException("La letra de DNI no concuerda");
		}
		
		setNumero(numero);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dni other = (Dni) obj;
		return Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Dni [numero=" + numero + "]";
	}
}
