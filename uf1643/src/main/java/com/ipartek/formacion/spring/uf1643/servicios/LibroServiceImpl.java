package com.ipartek.formacion.spring.uf1643.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.uf1643.entidades.Libro;
import com.ipartek.formacion.spring.uf1643.repositorios.LibrosRepository;

@Service
public class LibroServiceImpl implements LibroService {
	@Autowired
	private LibrosRepository repo;
	
	@Override
	public Iterable<Libro> listado() {
		return repo.findAll();
	}

	@Override
	public Libro detalle(long id) {
		Optional<Libro> libro = repo.findById(id);
		
		return libro.isPresent() ? libro.get() : null;
	}

	@Override
	public Iterable<Libro> filtroPorNombre(String nombre) {
		return repo.findByTituloContaining(nombre);
	}

	@Override
	public Libro filtroPorIsbn(String isbn) {
		return repo.findByIsbn(isbn);
	}

	@Override
	public Iterable<Libro> filtroCombinado(String termino) {
		return repo.findByTituloContainingOrIsbnContaining(termino, termino);
	}

	@Override
	public void guardar(Libro libro) {
		try {
			repo.save(libro);
		} catch(Exception e) {
			throw new ServiciosException("No se ha podido guardar el libro", e);
		}
	}

}
