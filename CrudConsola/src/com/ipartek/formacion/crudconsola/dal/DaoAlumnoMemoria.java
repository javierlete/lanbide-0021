package com.ipartek.formacion.crudconsola.dal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.function.Predicate;

import com.ipartek.formacion.crudconsola.entidades.Alumno;

public class DaoAlumnoMemoria implements DaoAlumno {
	private TreeMap<Long, Alumno> alumnos = new TreeMap<>();

	// Singleton
	private DaoAlumnoMemoria() {
		alumnos.put(1L, new Alumno(1L, "Javier Lete", LocalDate.of(1980, 10, 10), 7.5));
		alumnos.put(2L, new Alumno(2L, "Pepe Pérez", LocalDate.of(1981, 10, 10), 6.3));
	}

	private static final DaoAlumnoMemoria INSTANCIA = new DaoAlumnoMemoria();

	public static DaoAlumnoMemoria obtenerInstancia() {
		return INSTANCIA;
	}
	// Fin Singleton

	@Override
	public Iterable<Alumno> obtenerTodos() {
		return alumnos.values();
	}

	@Override
	public Alumno obtenerPorId(Long id) {
		return alumnos.get(id);
	}

	@Override
	public Alumno insertar(Alumno alumno) {
		Long id = alumnos.size() > 0 ? alumnos.lastKey() + 1L : 1L;
		alumno.setId(id);
		alumnos.put(id, alumno);
		return alumno;
	}

	@Override
	public Alumno modificar(Alumno alumno) {
		alumnos.put(alumno.getId(), alumno);
		return alumno;
	}

	@Override
	public void borrar(Long id) {
		alumnos.remove(id);
	}

	@Override
	public Iterable<Alumno> buscarPorNombre(String nombre) {
		ArrayList<Alumno> encontrados = new ArrayList<>();

		for (Alumno alumno : alumnos.values()) {
			if (alumno.getNombre().contains(nombre)) {
				encontrados.add(alumno);
			}
		}

		return encontrados;
	}

	// Ejemplos de Streams
	public Iterable<Alumno> buscarPorNombreStream(String nombre) {
		return () -> alumnos.values().stream().filter(alumno -> alumno.getNombre().contains(nombre)).iterator();
	}
	
	public Alumno buscarPorNombreStreamId(Long id) {
		return alumnos.values().stream().filter(alumno -> alumno.getId() == id).findFirst().orElse(null);
	}
	
	public Iterable<Alumno> buscarPorNombreStreamDesglosado(String nombre) {

		Predicado predicado = new Predicado(nombre);
		IterableAlumno iterable = new IterableAlumno(alumnos.values().stream().filter(predicado).iterator());
		return iterable;
	}
	
	
	static class Predicado implements Predicate<Alumno> {

		private String nombre;
		
		public Predicado(String nombre) {
			this.nombre = nombre;
		}
		@Override
		public boolean test(Alumno alumno) {
			return alumno.getNombre().contains(nombre);
		}
		
	}
	
	static class IterableAlumno implements Iterable<Alumno> {

		private Iterator<Alumno> iterator;
		
		public IterableAlumno(Iterator<Alumno> iterator) {
			this.iterator = iterator;
		}
		@Override
		public Iterator<Alumno> iterator() {
			return iterator;
		}
		
	}

}
