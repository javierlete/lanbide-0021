package com.ipartek.formacion.uf2218.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.uf2218.modelos.Usuario;

public class DaoUsuarioMemoria implements DaoUsuario {
	private TreeMap<Long, Usuario> usuarios = new TreeMap<>();
	
	// SINGLETON
	private DaoUsuarioMemoria() {
		usuarios.put(1L, new Usuario(1L, "javier@lete.net", "contra", "Javier Lete"));
		usuarios.put(2L, new Usuario(2L, "pepe@perez.net", "pepe", "Pepe Pérez"));
	}
	private static final DaoUsuarioMemoria INSTANCIA = new DaoUsuarioMemoria();
	public static DaoUsuarioMemoria getInstancia() { return INSTANCIA; }
	// FIN SINGLETON
	
	@Override
	public Usuario obtenerPorEmail(String email) {
		return usuarios.values().stream().filter(usuario -> usuario.getEmail().equals(email)).findFirst().orElse(null);
	}

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}
}
