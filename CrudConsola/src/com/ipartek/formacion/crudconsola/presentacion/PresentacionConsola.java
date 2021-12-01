package com.ipartek.formacion.crudconsola.presentacion;

import static com.ipartek.formacion.crudconsola.bibliotecas.Consola.*;

import com.ipartek.formacion.crudconsola.dal.DalException;
import com.ipartek.formacion.crudconsola.dal.DaoAlumno;
import com.ipartek.formacion.crudconsola.dal.DaoAlumnoMemoria;
import com.ipartek.formacion.crudconsola.entidades.Alumno;
import com.ipartek.formacion.crudconsola.entidades.EntidadesException;

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
		pl("6. Buscar por nombre");
		pl("0. SALIR");
	}

	private static int pedirOpcion() {
		pl("");
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
		case 6:
			buscarPorNombre();
			break;
		case 0:
			pl("Se ha seleccionado salir");
			break;
		default:
			el("Opción no reconocida");
		}
	}

	private static void buscarPorNombre() {
		String nombre = leerString("Introduce el patrón de nombre a buscar");
		
		for (Alumno alumno : dao.buscarPorNombre(nombre)) {
			mostrar(alumno);
		}
	}

	private static void listarTodos() {
		for (Alumno alumno : dao.obtenerTodos()) {
			mostrar(alumno);
		}
	}

	private static void mostrar(Alumno alumno) {
		if (alumno == null) {
			el("No se ha encontrado el alumno");
			return;
		}

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
		Alumno alumno = new Alumno();

		leerNombre(alumno);
		leerFechaNacimiento(alumno);
		alumno.setNotaMedia(leerDouble("Nota media"));

		mostrar(dao.insertar(alumno));
	}

	private static void modificar() {
		try {
			Alumno alumno = new Alumno();
			
			alumno.setId(leerLong("Id"));
			leerNombre(alumno);
			leerFechaNacimiento(alumno);
			alumno.setNotaMedia(leerDouble("Nota media"));

			mostrar(dao.modificar(alumno));
		} catch (DalException e) {
			el("No se ha podido hacer la operación: " + e.getMessage());
		}
	}

	private static void borrar() {
		try {
			Long id = leerLong("Dime el id que quieres borrar");

			dao.borrar(id);
		} catch (DalException e) {
			el("No se ha podido hacer la operación: " + e.getMessage());
		}
	}

	private static void leerFechaNacimiento(Alumno alumno) {
		boolean esCorrecto = false;

		do {
			try {
				alumno.setFechaNacimiento(leerLocalDate("Fecha de nacimiento"));
				esCorrecto = true;
			} catch (EntidadesException e) {
				el("La fecha de nacimiento no es correcta: " + e.getMessage());
			}
		} while (!esCorrecto);
		
	}

	private static void leerNombre(Alumno alumno) {
		boolean esCorrecto = false;

		do {
			try {
				alumno.setNombre(leerString("Nombre"));
				esCorrecto = true;
			} catch (EntidadesException e) {
				el("El nombre no es correcto: " + e.getMessage());
			}
		} while (!esCorrecto);
	}

	
}
