package com.ipartek.formacion.crudconsola.presentacion;

import static com.ipartek.formacion.crudconsola.bibliotecas.Consola.*;

import java.time.LocalDate;

import com.ipartek.formacion.crudconsola.dal.DaoAlumno;
import com.ipartek.formacion.crudconsola.dal.DaoAlumnoMemoria;
import com.ipartek.formacion.crudconsola.entidades.Alumno;

public class PresentacionConsola {

	private static final int SALIR = 0;
	
	private static final DaoAlumno dao = DaoAlumnoMemoria.obtenerInstancia();

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);

		pl("Gracias por usar la aplicación");
	}

	private static void mostrarMenu() {
		pl("MENU");
		pl("----");
		pl("1. Listar todos");
		pl("2. Obtener por Id");
		pl("3. Insertar");
		pl("4. Modificar");
		pl("5. Borrar");
		pl("0. SALIR");
	}

	private static int pedirOpcion() {
		return leerInt("Dime la opción deseada");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			listarTodos();
			break;
		case 2:
			obtenerPorId();
			break;
		case 3:
			insertar();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		case 0:
			pl("Se ha seleccionado salir");
			break;
		default:
			pl("Opción no reconocida");
		}
	}

	private static void listarTodos() {
		for(Alumno alumno: dao.obtenerTodos()) {
			mostrar(alumno);
		}
	}

	private static void mostrar(Alumno alumno) {
		p("Id: ");
		pl(alumno.getId());
		p("Nombre: ");
		pl(alumno.getNombre());
		p("Fecha de Nacimiento: ");
		pl(alumno.getFechaNacimiento());
		p("Nota media: ");
		pl(alumno.getNotaMedia());
		pl("");
	}

	private static void obtenerPorId() {
		Long id = leerLong("Dime el id que buscas");
		
		mostrar(dao.obtenerPorId(id));
	}

	private static void insertar() {
		String nombre = leerString("Nombre");
		LocalDate fechaNacimiento = leerLocalDate("Fecha de nacimiento");
		Double notaMedia = leerDouble("Nota media");
		
		Alumno alumno = new Alumno(null, nombre, fechaNacimiento, notaMedia);
		
		mostrar(dao.insertar(alumno));
	}

	private static void modificar() {
		Long id = leerLong("Id");
		String nombre = leerString("Nombre");
		LocalDate fechaNacimiento = leerLocalDate("Fecha de nacimiento");
		Double notaMedia = leerDouble("Nota media");
		
		Alumno alumno = new Alumno(id, nombre, fechaNacimiento, notaMedia);
		
		mostrar(dao.modificar(alumno));
	}

	private static void borrar() {
		Long id = leerLong("Dime el id que quieres borrar");
		
		dao.borrar(id);
	}

}
