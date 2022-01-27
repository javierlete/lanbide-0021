package com.ipartek.formacion.uf2218.accesodatos;

import com.ipartek.formacion.uf2218.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	default Usuario obtenerPorEmail(String email) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	default Iterable<Usuario> buscar(String termino) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	default Iterable<Usuario> buscar(String termino, int pagina) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	default Iterable<Usuario> buscar(String termino, int pagina, String orden) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
