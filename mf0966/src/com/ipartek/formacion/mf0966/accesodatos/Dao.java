package com.ipartek.formacion.mf0966.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(long id);
	
	T insertar(T objeto);
	T modificar(T objeto);
	void borrar(long id);
}
