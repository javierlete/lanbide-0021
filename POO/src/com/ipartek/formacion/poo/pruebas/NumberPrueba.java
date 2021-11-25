package com.ipartek.formacion.poo.pruebas;

public class NumberPrueba {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Number[] numeros = new Number[2];
		
		numeros[0] = 5; //new Integer(5);
		numeros[1] = 8.6; //new Double(8.6);
		
		for(Number numero: numeros) {
			System.out.println(numero.intValue());
		}
	}

}
