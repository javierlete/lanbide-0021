package com.ipartek.formacion.spring.uf1643.servicios;

import com.ipartek.formacion.spring.uf1643.entidades.Libro;

public interface LibroService {
	Iterable<Libro> listado();
	Libro detalle(long id);
	Iterable<Libro> filtroPorNombre(String nombre);
	Libro filtroPorIsbn(String isbn);
	Iterable<Libro> filtroCombinado(String termino);
	void guardar(Libro libro);
}
