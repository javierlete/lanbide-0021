package com.ipartek.formacion.ipartekify.dal;

import com.ipartek.formacion.ipartekify.modelos.Lista;
import com.ipartek.formacion.ipartekify.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario buscarPorEmail(String email);
	void favoritoCancion(Long idUsuario, Long idCancion);
	void insertarLista(Long idUsuario, Lista nuevaLista);
	Iterable<Lista> obtenerListas(Long id);
}
