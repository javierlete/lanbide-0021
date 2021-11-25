package com.ipartek.formacion.poo.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.poo.entidades.Dni;
import com.ipartek.formacion.poo.entidades.Empleado;
import com.ipartek.formacion.poo.entidades.EmpleadoIndefinido;
import com.ipartek.formacion.poo.entidades.EmpleadoPorHoras;
import com.ipartek.formacion.poo.entidades.Local;
import com.ipartek.formacion.poo.entidades.Persona;

public class EmpleadoPrueba {

	public static void main(String[] args) {
		Empleado empleado = new EmpleadoIndefinido(2L, "Pepe", new Dni("12345678Z"), "192387469817235", new BigDecimal(20000), 14);
		
		System.out.println(empleado.aTexto());
		
		empleado.setId(1L);
		empleado.setNombre("Javier");
		empleado.setDni(new Dni("12345678Z"));
		empleado.setNumeroSeguridadSocial("1234628648376483");
		
		System.out.println(empleado.aTexto());
		
		Persona persona = empleado;
		
		System.out.println(persona.getNombre());
		
		System.out.println("Datos de persona: " + persona.aTexto());
		
		System.out.println(persona instanceof Empleado);
		
		Empleado empleadoJavier = (Empleado) persona;
		
		System.out.println(empleadoJavier.getNumeroSeguridadSocial());
		
		Persona persona2 = new Persona();
		
		System.out.println(persona2 instanceof Empleado);
		
//		Empleado empleado2 = (Empleado) persona2;
//		
//		System.out.println(empleado2.getNumeroSeguridadSocial());
		
		Local local = new Local("Ipartek", "Santutxu");
		
		local.agregarPersona(new Persona("Javier Lete"));
		local.agregarPersona(new Persona("Pepe Pérez"));
		local.agregarPersona(empleadoJavier);
		
		for(Persona p: local.getPersonas()) {
			System.out.println(p.aTexto());
		}
		
		Object o = persona;
		
		System.out.println(o.getClass().getName());
		System.out.println(Integer.toHexString(o.hashCode()));
		
		System.out.println(o.toString());
		
		System.out.println(o);
		
		Empleado e1 = new EmpleadoPorHoras(1L, "Javier", new Dni("12345678Z"), "12345", new BigDecimal(10), 40);
		Empleado e2 = new EmpleadoPorHoras(1L, "Javier", new Dni("12345678Z"), "12345", new BigDecimal(10), 40);
		
		System.out.println(e1 == e2);
		System.out.println(e1.equals(e2));
		
		System.out.println(e1);
		System.out.println(e2);
		
		local = new Local("Ipartek", "Dirección");
		
		local.agregarPersona(empleado);
		local.agregarPersona(e2);
		
		BigDecimal totalNominasMensuales = BigDecimal.ZERO; //.setScale(0, RoundingMode.HALF_EVEN);
		
		for(Persona p: local.getPersonas()) {
			System.out.println(p);
			
			if(p instanceof Empleado) {
				Empleado e = (Empleado)p;
				totalNominasMensuales = totalNominasMensuales.add(e.getSueldoMensual());
			}
		}
		
		System.out.println(totalNominasMensuales);
	}

}
