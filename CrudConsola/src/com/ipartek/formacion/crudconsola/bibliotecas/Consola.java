package com.ipartek.formacion.crudconsola.bibliotecas;

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
	
	public static String leerString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine();
	}
	
	public static Long leerLong(String mensaje) {
		return Long.parseLong(leerString(mensaje));
	}
	
	public static Integer leerInt(String mensaje) {
		return Integer.parseInt(leerString(mensaje));
	}
	
	public static Double leerDouble(String mensaje) {
		return Double.parseDouble(leerString(mensaje));
	}
	
	public static LocalDate leerLocalDate(String mensaje) {
		return LocalDate.parse(leerString(mensaje + " (aaaa-mm-dd)"), DateTimeFormatter.ISO_DATE);
	}
}
