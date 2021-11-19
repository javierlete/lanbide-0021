package com.ipartek.formacion.mf0967.uf2216;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeMap;

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
		
		b = 127;
		System.out.println(b);
		b++;
		System.out.println(b);
		
//		for(b = 1; b < 300; b++) {
//			System.out.println(b);
//		}

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
		
		// Arrays ó Arreglos
		// Conjunto de elementos de tamaño predefinido
		// El objeto de tipo array NUNCA cambia de tamaño una vez establecido
		// Es INMUTABLE (el objeto de array en cuanto a tamaño, no su contenido)
		// Todos los elementos son contiguos
		int tam = 2;
		int[] arr = new int[tam];
		
		arr[0] = 7;
		arr[1] = 5;
		// arr[2] = 8; //
		
		// arr.length = 6; //
		
		for(int indice = 0; indice < arr.length; indice++) {
			System.out.println(arr[indice]);
		}
		
		char[][] tablero = new char[8][8];
		
		tablero[0][0] = 't';
		tablero[0][1] = 'c';
		tablero[1][0] = 'p';
		
		tablero[6][0] = 'P';
		tablero[6][1] = 'P';
		tablero[7][0] = 'T';
		
		for(int x = 0; x < tablero.length; x++) {
			for (int y = 0; y < tablero[x].length; y++) {
				if(tablero[x][y] == '\0') {
					System.out.print('.');
				} else {
					System.out.print(tablero[x][y]);
				}
			}
			System.out.println();
		}
		
		// Colecciones (mutables)
		// Java 5 <Tipo>
		// Java 8 <>
		// Java 5 for
		
		ArrayList<Integer> al = new ArrayList<>();
		
		al.add(5);
		al.add(7);
		al.add(10);
		
		for(Integer dato: al) {
			System.out.println(dato);
		}
		
		System.out.println(al.get(1));
		
		TreeMap<String, String> diccionario = new TreeMap<>();
		
		diccionario.put("casa", "house");
		diccionario.put("coche", "car");
		
		System.out.println(diccionario.get("coche"));
	}

}
