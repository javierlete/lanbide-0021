package com.ipartek.formacion.poo.pruebas;

import java.util.Scanner;

import com.ipartek.formacion.poo.entidades.EntidadesException;
import com.ipartek.formacion.poo.entidades.Persona;

public class ExcepcionesObjetosPrueba {
	public static void main(String[] args) {
		Scanner sc = null;

		try {
			sc = new Scanner(System.in);

			Persona p = new Persona();

			try {
				System.out.print("Introduce el id: ");
				p.setId(sc.nextLong());
			} catch (EntidadesException ee) {
				System.err.println("Error en el ID: " + ee.getMessage());
			} finally {
				sc.nextLine();
			}

			try {
				System.out.print("Introduce el nombre: ");
				p.setNombre(sc.nextLine());
			} catch (EntidadesException ee) {
				System.err.println("Error en el nombre: " + ee.getMessage());
			}
		} catch (Exception e) {
			System.err.println("Error no controlado");
			System.err.println(e.getMessage());
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}
	}
}
