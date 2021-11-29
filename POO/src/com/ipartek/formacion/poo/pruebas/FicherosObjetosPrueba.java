package com.ipartek.formacion.poo.pruebas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

import com.ipartek.formacion.poo.entidades.Dni;
import com.ipartek.formacion.poo.entidades.EmpleadoIndefinido;
import com.ipartek.formacion.poo.entidades.EmpleadoPorHoras;
import com.ipartek.formacion.poo.entidades.Local;
import com.ipartek.formacion.poo.entidades.Persona;

public class FicherosObjetosPrueba {
	private static final String FICHEROS_OBJETOS_PRUEBA_DAT = "FicherosObjetosPrueba.dat";

	public static void main(String[] args) {
		Local local = new Local("Bilbao", "Mi casa");
		
		local.agregarPersona(new Persona(1L, "Javier", new Dni("12345678Z")));
		local.agregarPersona(new EmpleadoIndefinido(2L, "Pepe", new Dni("87654321X"), "12341234", new BigDecimal(20000), 14));
		local.agregarPersona(new EmpleadoPorHoras(3L, "Juan", new Dni("18452736" + Dni.getLetra("18452736")), "12346128346", new BigDecimal(20), 40));

		try (FileOutputStream fos = new FileOutputStream(FICHEROS_OBJETOS_PRUEBA_DAT);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(local);
		} catch (IOException e) {
			System.err.println("No se ha podido escribir el fichero");
			e.printStackTrace();
			return;
		}
		
		try (FileInputStream fis = new FileInputStream(FICHEROS_OBJETOS_PRUEBA_DAT);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			Local localLeido = (Local) ois.readObject();
			
			System.out.println(localLeido);
			
			for(Persona persona: localLeido.getPersonas()) {
				System.out.println(persona);
			}
		} catch (ClassNotFoundException e) {
			System.err.println("No se ha encontrado la clase: " + e.getMessage());
			return;
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.err.println("No se ha podido leer el fichero: " + e.getMessage());
			return;
		}
	}
}
