package com.ipartek.formacion.poo.pruebas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FicherosPrueba {
	private static final String FICHEROS_PRUEBA_TXT = "FicherosPrueba.txt";

	public static void main(String[] args) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(FICHEROS_PRUEBA_TXT); // "C:\nuevos\trabajos.txt");
			pw = new PrintWriter(fw);

			pw.println("Ahora ya tengo saltos de línea");
			pw.println("YUPIIIIIII");
		} catch (IOException e) {
			System.err.println("Error en la escritura del fichero: " + e.getMessage());
			return;
		} finally {
			if (pw != null) {
				pw.close();
			}
			
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.err.println("No se ha podido cerrar el fichero " + e.getMessage());
					return;
				}
			}
		}

		Scanner sc = null;
		FileReader fr = null;

		try {
			fr = new FileReader(FICHEROS_PRUEBA_TXT);
			sc = new Scanner(fr);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero a leer " + e.getMessage());
			return;
		} catch (NoSuchElementException e) {
			System.err.println("No se ha podido leer una línea " + e.getMessage());
			return;
		} catch (IllegalStateException e) {
			System.err.println("El flujo de lectura estaba cerrado " + e.getMessage());
			return;
		} finally {
			if (sc != null) {
				sc.close();
			}

			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					System.err.println("No se ha podido cerrar el fichero " + e.getMessage());
				}
			}
		}
	}
}
