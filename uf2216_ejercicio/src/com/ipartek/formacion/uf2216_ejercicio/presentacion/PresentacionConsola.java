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

		leerTitulo(libro);
		leerIsbn(libro);
		leerNumeroPaginas(libro);
		leerFormato(libro);

		mostrarLibro(libro);

		if (leerString("¿Quieres guardarlo (s/N)?").equalsIgnoreCase("S")) {
			DAO.insertar(libro);
		}

	}

	private static void leerFormato(Libro libro) {
		libro.setFormato(leerString("Formato (digital/PAPEL)").equalsIgnoreCase("digital"));
	}

	private static void leerTitulo(Libro libro) {
		boolean esCorrecto = false;

		do {
			try {
				libro.setTitulo(leerString("Título"));
				esCorrecto = true;
			} catch (Exception e) {
				el(e.getMessage());
			}
		} while (!esCorrecto);
	}

	private static void leerIsbn(Libro libro) {
		boolean esCorrecto = false;

		do {
			try {
				libro.setIsbn(leerString("ISBN"));
				esCorrecto = true;
			} catch (Exception e) {
				el(e.getMessage());
			}
		} while (!esCorrecto);
	}

	private static void leerNumeroPaginas(Libro libro) {
		boolean esCorrecto = false;

		do {
			try {
				libro.setNumeroPaginas(leerInt("Número de páginas"));
				esCorrecto = true;
			} catch (Exception e) {
				el(e.getMessage());
			}
		} while (!esCorrecto);
	}
}
