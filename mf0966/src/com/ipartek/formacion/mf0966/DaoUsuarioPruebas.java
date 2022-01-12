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
		
		System.out.println(dao.insertar(new Usuario(null, "nuevo@nuevez.net", "nueva", "Nuevo Nuevez")));
		
		System.out.println(dao.modificar(new Usuario(6L, "modificado@modificadez.net", "modificado", "Modificado Modificadez")));
		
		dao.borrar(6L);
	}

}
