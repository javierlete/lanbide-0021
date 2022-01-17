package com.ipartek.formacion.uf2218.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.uf2218.modelos.Rol;
import com.ipartek.formacion.uf2218.modelos.Usuario;

public class DaoUsuarioMemoria implements DaoUsuario {
	private TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	// SINGLETON
	private DaoUsuarioMemoria() {
		usuarios.put(1L,
				new Usuario(1L, "javier@lete.net", "contra", "Javier Lete", new Rol(1L, "ADMIN", "Administrador")));
		usuarios.put(2L, new Usuario(2L, "pepe@perez.net", "pepe", "Pepe Pérez", new Rol(2L, "USER", "Usuario")));
	}

	private static final DaoUsuarioMemoria INSTANCIA = new DaoUsuarioMemoria();

	public static DaoUsuarioMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Usuario obtenerPorEmail(String email) {
		return usuarios.values().stream().filter(usuario -> usuario.getEmail().equals(email)).findFirst().orElse(null);
	}

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}

	@Override
	public Usuario obtenerPorId(long id) {
		return usuarios.get(id);
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		Long id = usuarios.size() != 0 ? usuarios.lastKey() + 1L : 1L;
		usuario.setId(id);
		modificar(usuario);

		return usuario;
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);

		return usuario;
	}

	@Override
	public void borrar(long id) {
		usuarios.remove(id);
	}

}
