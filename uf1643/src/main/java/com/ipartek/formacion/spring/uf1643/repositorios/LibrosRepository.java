package com.ipartek.formacion.spring.uf1643.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.uf1643.entidades.Libro;

public interface LibrosRepository extends CrudRepository<Libro, Long> {
	Iterable<Libro> findByTituloContaining(String titulo);
	Libro findByIsbn(String isbn);
	
	Iterable<Libro> findByTituloContainingOrIsbnContaining(String titulo, String isbn);
}
