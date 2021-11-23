package com.ipartek.formacion.poo.pruebas;

import com.ipartek.formacion.poo.entidades.Local;
import com.ipartek.formacion.poo.entidades.Persona;

public class LocalPrueba {
	public static void main(String[] args) {
		Local local = new Local("Ipartek", "Santutxu");
		
		local.agregarPersona(new Persona("Javier Lete"));
		local.agregarPersona(new Persona("Pepe Pérez"));
		//local.agregarPersona(null);
		
		//local.getPersonas().add(null);
		//local.getPersonas().remove(1);
		
		local.getPersonas().get(1).setNombre("MODIFICADO");
		
		for(Persona persona: local.getPersonas()) {
			System.out.println(persona.aTexto());
		}
	}
}
