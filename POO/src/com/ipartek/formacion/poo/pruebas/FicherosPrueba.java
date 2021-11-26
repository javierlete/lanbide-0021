package com.ipartek.formacion.poo.pruebas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicherosPrueba {
	private static final String FICHEROS_PRUEBA_TXT = "FicherosPrueba.txt";

	public static void main(String[] args) {
		try (FileWriter fw = new FileWriter(FICHEROS_PRUEBA_TXT); PrintWriter pw = new PrintWriter(fw);) {
			pw.println("Ahora ya tengo saltos de línea");
			pw.println("YUPIIIIIII");
		} catch (IOException e) {
			System.err.println("No se ha podido escribir el fichero " + e.getMessage());
			return;
		}

		try (FileReader fr = new FileReader(FICHEROS_PRUEBA_TXT); Scanner sc = new Scanner(fr)) {
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.err.println("No se ha podido leer el fichero " + e.getMessage());
			return;
		}

	}
}
