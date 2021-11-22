package com.ipartek.formacion.poo.pruebas;

import java.util.Scanner;

import com.ipartek.formacion.poo.entidades.Persona;

public class PersonaPrueba {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Persona p;
		
		p = new Persona();
		
		System.out.println(p.getId());
		System.out.println(p.getNombre());
		
		System.out.println(p.aTexto());
		
		p.setId(1L);
		
		System.out.print("Introduce el nombre: ");
		//String nombre = sc.nextLine();
		String nombre = "Javier Lete";
		
		p.setNombre(nombre);
		
		System.out.println(p.aTexto());
		
		Persona p2 = new Persona(2L, "Pepe Pérez");

		System.out.println(p2.aTexto());
		
		Persona copia = new Persona(p2);
		
		System.out.println("ORIGINAL: " + p2.aTexto());
		System.out.println("COPIA: " + copia.aTexto());
		
		copia.setNombre("Modificado");

		System.out.println("ORIGINAL: " + p2.aTexto());
		System.out.println("COPIA: " + copia.aTexto());

		sc.close();
	}

}
