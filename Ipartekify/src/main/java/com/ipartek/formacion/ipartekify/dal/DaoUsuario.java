package com.ipartek.formacion.ipartekify.dal;

import com.ipartek.formacion.ipartekify.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	void favoritoCancion(Long idUsuario, Long idCancion);
}
