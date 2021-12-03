package com.ipartek.formacion.uf2216_ejercicio.bibliotecas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);
	
	public static void pl(Object objeto) {
		System.out.println(objeto);
	}
	
	public static void p(Object objeto) {
		System.out.print(objeto);
	}
	
	public static void el(Object objeto) {
		System.out.println("* " + objeto + " *");
	}
	
	public static String leerString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine().trim();
	}
	
	public static Long leerLong(String mensaje) {
		Long entero = null;
		
		boolean esCorrecto = false;
		
		do {
			try {
				entero = Long.parseLong(leerString(mensaje));
				esCorrecto = true;
			} catch (NumberFormatException e) {
				el("Introduce un número entero");
			}
		} while(!esCorrecto);
		
		return entero;
	}
	
	public static Integer leerInt(String mensaje) {
		Integer entero = null;
		
		boolean esCorrecto = false;
		
		do {
			try {
				entero = Integer.parseInt(leerString(mensaje));
				esCorrecto = true;
			} catch (NumberFormatException e) {
				el("Introduce un número entero");
			}
		} while(!esCorrecto);
		
		return entero;
	}
	
	public static Double leerDouble(String mensaje) {
		Double doble = null;
		
		boolean esCorrecto = false;
		
		do {
			try {
				doble = Double.parseDouble(leerString(mensaje));
				esCorrecto = true;
			} catch (NumberFormatException e) {
				el("Introduce un número decimal");
			}
		} while(!esCorrecto);
		
		return doble;
	}
	
	public static LocalDate leerLocalDate(String mensaje) {
		LocalDate fecha = null;
		
		boolean esCorrecto = false;
		
		do {
			try {
				fecha = LocalDate.parse(leerString(mensaje + " (aaaa-mm-dd)"), DateTimeFormatter.ISO_DATE);
				esCorrecto = true;
			} catch (Exception e) {
				el("El formato para la fecha debe ser aaaa-mm-dd");
			}
		} while(!esCorrecto);
		
		return fecha;
	}
	
	public static Boolean leerBoolean(String mensaje) {
		Boolean booleano = null;
		
		boolean esCorrecto = false;
		
		do {
			try {
				booleano = Boolean.parseBoolean(leerString(mensaje));
				esCorrecto = true;
			} catch (NumberFormatException e) {
				el("Introduce true o false");
			}
		} while(!esCorrecto);
		
		return booleano;
	}
}
