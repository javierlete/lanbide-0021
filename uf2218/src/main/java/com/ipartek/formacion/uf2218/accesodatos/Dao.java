package com.ipartek.formacion.uf2218.accesodatos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default Iterable<T> obtenerTodos(int pagina) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	default Iterable<T> obtenerTodos(int pagina, String orden) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T obtenerPorId(long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T insertar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T modificar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default void borrar(long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
