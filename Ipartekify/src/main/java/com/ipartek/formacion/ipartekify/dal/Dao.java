package com.ipartek.formacion.ipartekify.dal;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new DalException("NO ESTÁ IMPLEMENTADO");
	}
	
	default T obtenerPorId(long id) {
		throw new DalException("NO ESTÁ IMPLEMENTADO");
	}
	
	default T insertar(T objeto) {
		throw new DalException("NO ESTÁ IMPLEMENTADO");
	}
	
	default T modificar(T objeto) {
		throw new DalException("NO ESTÁ IMPLEMENTADO");
	}
	
	default void borrar(long id) {
		throw new DalException("NO ESTÁ IMPLEMENTADO");
	}
}
