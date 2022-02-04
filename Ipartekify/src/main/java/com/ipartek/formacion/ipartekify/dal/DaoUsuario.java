package com.ipartek.formacion.ipartekify.dal;

import com.ipartek.formacion.ipartekify.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario buscarPorEmail(String email);
	void favoritoCancion(Long idUsuario, Long idCancion);
}
