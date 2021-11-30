package com.ipartek.formacion.crudconsola.dal;

import com.ipartek.formacion.crudconsola.entidades.Alumno;

public interface DaoAlumno extends Dao<Alumno> {
	Iterable<Alumno> buscarPorNombre(String nombre);
}
