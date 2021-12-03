package com.ipartek.formacion.uf2216_ejercicio.presentacion;

import static com.ipartek.formacion.uf2216_ejercicio.bibliotecas.Consola.*;

import com.ipartek.formacion.uf2216_ejercicio.dal.DaoLibro;
import com.ipartek.formacion.uf2216_ejercicio.dal.DaoLibroMemoria;
import com.ipartek.formacion.uf2216_ejercicio.entidades.Libro;

public class PresentacionConsola {

	private static final DaoLibro DAO = DaoLibroMemoria.obtenerInstancia();

	public static void main(String[] args) {
		nuevoLibro();

		listarLibros();
	}

	private static void listarLibros() {
		for (Libro libro : DAO.obtenerTodos()) {
			mostrarLibro(libro);
		}
	}

	private static void mostrarLibro(Libro libro) {
		pl("");
		if (libro.getId() != null) {
			pl("Id:\t\t" + libro.getId());
		}
		pl("Título:\t\t" + libro.getTitulo());
		pl("ISBN:\t\t" + libro.getIsbn());
		pl("Páginas:\t" + libro.getNumeroPaginas());
		pl("Formato:\t" + (libro.getFormato() ? "digital" : "papel"));
		pl("");
	}

	private static void nuevoLibro() {
		Libro libro = new Libro();

		// leerTitulo(libro);
		validarPropiedad(() -> libro.setTitulo(leerString("Título")));
		validarPropiedad(() -> libro.setIsbn(leerString("ISBN")));
		validarPropiedad(() -> libro.setNumeroPaginas(leerInt("Número de páginas")));
		libro.setFormato(leerString("Formato (digital/PAPEL)").equalsIgnoreCase("digital"));

		mostrarLibro(libro);

		if (leerString("¿Quieres guardarlo (s/N)?").equalsIgnoreCase("S")) {
			DAO.insertar(libro);
		}

	}

	private static void validarPropiedad(Runnable asignacion) {
		boolean esCorrecto = false;

		do {
			try {
				asignacion.run();
				esCorrecto = true;
			} catch (Exception e) {
				el(e.getMessage());
			}
		} while (!esCorrecto);
	}
}
