package com.ipartek.formacion.uf2216_ejercicio.bibliotecas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Supplier;

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

	private static <T> T leer(String mensaje, Supplier<T> funcion, String mensajeError) {
		T dato = null;

		boolean esCorrecto = false;

		do {
			try {
				dato = funcion.get();
				esCorrecto = true;
			} catch (Exception e) {
				el(mensajeError);
			}
		} while (!esCorrecto);

		return dato;
	}

	public static String leerString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine().trim();
	}

	public static Long leerLong(String mensaje) {
		return Consola.<Long>leer(mensaje, () -> Long.parseLong(leerString(mensaje)),
				"Debes introducir un número entero");
	}

	public static Integer leerInt(String mensaje) {
		return Consola.<Integer>leer(mensaje, () -> Integer.parseInt(leerString(mensaje)),
				"Debes introducir un número entero");
	}

	public static Double leerDouble(String mensaje) {
		return Consola.<Double>leer(mensaje, () -> Double.parseDouble(leerString(mensaje)),
				"Debes introducir un número decimal");
	}

	public static LocalDate leerLocalDate(String mensaje) {
		return Consola.<LocalDate>leer(mensaje,
				() -> LocalDate.parse(leerString(mensaje + " (aaaa-mm-dd)"), DateTimeFormatter.ISO_DATE),
				"Debes introducir una fecha con formato aaaa-mm-dd");
	}

	public static Boolean leerBoolean(String mensaje) {
		return Consola.<Boolean>leer(mensaje, () -> Boolean.parseBoolean(leerString(mensaje)),
				"Debes introducir un true o false");
	}
}
