package com.ipartek.formacion.poo.pruebas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicherosPrueba {
	private static final String FICHEROS_PRUEBA_TXT = "FicherosPrueba.txt";

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(FICHEROS_PRUEBA_TXT); //"C:\nuevos\trabajos.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("Ahora ya tengo saltos de línea");
		pw.println("YUPIIIIIII");
		
		fw.close();
		
		FileReader fr = new FileReader(FICHEROS_PRUEBA_TXT);
		Scanner sc = new Scanner(fr);
		
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
		fr.close();
	}
}
