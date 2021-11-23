package com.ipartek.formacion.poo.pruebas;

import com.ipartek.formacion.poo.entidades.Dni;

public class DniPrueba {

	public static void main(String[] args) {
		Dni dni = new Dni("Y2345678Z");
		
		System.out.println(dni.getTexto());
		System.out.println(dni.getNumero());
		System.out.println(dni.getLetra());
		
		System.out.println(Dni.getLetra("87654321"));
		
		System.out.println(new Dni("87654321X").getTexto());
	}

}
