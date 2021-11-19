package com.ipartek.formacion.mf0967.uf2216;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase para demostrar la sintaxis básica de Java
 * 
 * @author JavierLete
 *
 */
public class Sintaxis {
	/**
	 * Método de entrada de la aplicación
	 * 
	 * @param args argumentos recibidos por consola
	 */
	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String[] args) {
		// Comentario de línea

		/*
		 * Comentario multi línea
		 */

		// TIPOS PRIMITIVOS
		byte b;
		short s;
		int i = 5;
		long l = 5L;

		float f = 0.3F;
		double d = 0.3;

		char c = '\n'; // 'g'; \n, \t, \r...

		boolean bl = true;

		// TIPOS REFERENCIA

		// Tipos primitivos encapsulados
		Byte be = null;
		Short se = null;
		Integer ie = null;
		Long le = null;

		Float fe = null;
		Double de = null;

		Character ce = null;
		Boolean ble = null;
		
		// Cadena de texto
		String nombre1 = new String("Javier");
		String nombre2 = new String("Javier");

		System.out.println(nombre1 == nombre2);
		System.out.println(nombre1.equals(nombre2));
		
		// Métodos de String
		
		System.out.println("Este es un texto".toUpperCase());

		StringBuffer log = new StringBuffer();

		log.append("línea1\n");
		log.append("línea2\n");

		String logS = log.toString();

		System.out.println(logS);

		// Conversiones de String a otro tipo
		String texto = "5";
		int enteroPrimitivo = Integer.parseInt(texto);
		
		// Conversiones de otro tipo a String
		enteroPrimitivo = 5;
		texto = String.valueOf(enteroPrimitivo);
		
		Integer enteroEncapsulado = 5;
		texto = enteroEncapsulado.toString();
		
		// Fechas
		// Java 1.0
		Date fecha10 = new Date(); //new Date(2021 - 1900, 11 - 1, 19, 20, 29, 00);
		System.out.println(fecha10.toLocaleString());
		
		// Java 1.1
		Calendar cal = new GregorianCalendar();
		DateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(formato.format(cal.getTime()));
		
		// Java 1.8 (java.time)
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println(ldt.format(dtf));
		
		String fechaTexto = "18-12-2020 17:18:19";
		ldt =  LocalDateTime.parse(fechaTexto, dtf);
		System.out.println(ldt);
		
		
	}

}
