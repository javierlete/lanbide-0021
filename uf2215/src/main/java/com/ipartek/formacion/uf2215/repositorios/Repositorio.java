package com.ipartek.formacion.uf2215.repositorios;

public interface Repositorio<T> {
	Iterable<T> getObjetos();
	T getObjeto(long id);
	
	T postObjeto(T objeto);
	T putObjeto(T objeto);
	void deleteObjeto(long id);
}
