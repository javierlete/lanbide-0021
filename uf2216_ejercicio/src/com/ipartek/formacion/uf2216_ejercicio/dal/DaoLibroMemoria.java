package com.ipartek.formacion.uf2216_ejercicio.dal;

import java.util.TreeMap;

import com.ipartek.formacion.uf2216_ejercicio.entidades.Libro;

public class DaoLibroMemoria implements DaoLibro {

	private TreeMap<Long, Libro> libros = new TreeMap<>();

	// Singleton
	private DaoLibroMemoria() {
		libros.put(1L, new Libro(1L, "El Señor de los Pardillos", "1234567890", 5000, Libro.FORMATO_PAPEL));
		libros.put(2L, new Libro(2L, "El pequeñajo", "0987654321", 3000, Libro.FORMATO_DIGITAL));
	}

	private static final DaoLibroMemoria INSTANCIA = new DaoLibroMemoria();

	public static DaoLibroMemoria obtenerInstancia() {
		return INSTANCIA;
	}
	// Fin singleton

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro obtenerPorId(Long id) {
		throw new DalException("NO IMPLEMENTADO TODAVÍA");
	}

	@Override
	public Libro insertar(Libro libro) {
		Long id = libros.size() > 0 ? libros.lastKey() + 1L : 1L;
		libro.setId(id);
		libros.put(id, libro);
		return libro;
	}

	@Override
	public Libro modificar(Libro objeto) {
		throw new DalException("NO IMPLEMENTADO TODAVÍA");
	}

	@Override
	public void borrar(Long id) {
		throw new DalException("NO IMPLEMENTADO TODAVÍA");
	}

}
