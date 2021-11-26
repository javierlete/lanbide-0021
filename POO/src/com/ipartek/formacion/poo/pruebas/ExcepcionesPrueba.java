package com.ipartek.formacion.poo.pruebas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcepcionesPrueba {

	public static void main(String[] args) {
		int div = Integer.MIN_VALUE, a, b;

		a = 5;
		b = 0;

		System.out.println("Antes");
		Scanner sc = new Scanner(System.in);

		boolean error;

		do {
			error = false;

			try {
				int[] arr = new int[2];

				arr[2] = 10;

				System.out.print("Introduce un número para divisor: ");
				b = sc.nextInt();
				sc.nextLine();

				div = a / b;

				System.out.println("Después de la división");

			} catch (ArithmeticException ae) {
				System.err.println("Error aritmético");
				error = true;
			} catch (InputMismatchException ime) {
				System.err.println("No has introducido un número");
				sc.nextLine();
				error = true;
//			} catch(RuntimeException re) {
//				System.err.println("Introduce un número distinto de 0");
//				error = true;
			} catch (Exception e) {
				System.err.println("Error no esperado");
//				System.err.println(e.getClass().getName());
//				System.err.println(e.getLocalizedMessage());
//				e.printStackTrace(System.err);
				return;
			} finally {
				System.out.println("Me ejecuto SIEMPRE");
			}
		} while (error);

		System.out.println(div);

		System.out.println("Fin");

		if (sc != null) {
			sc.close();
		}
	}

}
