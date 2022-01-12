package com.ipartek.formacion.mf0966;

import com.ipartek.formacion.mf0966.accesodatos.DaoUsuario;
import com.ipartek.formacion.mf0966.accesodatos.DaoUsuarioMySql;
import com.ipartek.formacion.mf0966.modelos.Usuario;

public class DaoUsuarioPruebas {

	public static void main(String[] args) {
		DaoUsuario dao = DaoUsuarioMySql.getInstancia();
		
		for(Usuario usuario: dao.obtenerTodos()) {
			System.out.println(usuario);
		}
		
		System.out.println(dao.obtenerPorId(1L));
		System.out.println(dao.obtenerPorEmail("pepe@perez.net"));
		
		Usuario usuario = dao.insertar(new Usuario(null, "nuevo@nuevez.net", "nueva", "Nuevo Nuevez"));
		System.out.println(usuario);
		
		usuario.setEmail("modificado@modificadez.net");
		usuario.setNombre("Modificado Modificadez");
		usuario.setPassword("modificada");
		
		System.out.println(dao.modificar(usuario));
		
		dao.borrar(usuario.getId());
	}

}
