package com.ipartek.formacion.uf2218.accesodatos;

import com.ipartek.formacion.uf2218.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	default Usuario obtenerPorEmail(String email) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
