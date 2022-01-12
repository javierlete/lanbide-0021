package com.ipartek.formacion.mf0966.accesodatos;

import com.ipartek.formacion.mf0966.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario obtenerPorEmail(String email);
}
