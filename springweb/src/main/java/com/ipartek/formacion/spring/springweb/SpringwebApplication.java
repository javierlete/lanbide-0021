package com.ipartek.formacion.spring.springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.springweb.entidades.Usuario;
import com.ipartek.formacion.spring.springweb.repositorios.UsuarioDao;

@SpringBootApplication
public class SpringwebApplication implements CommandLineRunner {

	@Autowired
	private UsuarioDao dao; 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringwebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		listar();
		
		System.out.println(dao.obtenerPorId(1));
		
		Usuario usuario = dao.insertar(new Usuario(null, "aaaa@bbbb.cccc", "asdfasdf", "PRUEBA"));
		
		listar();
		
		usuario.setRol("MODIFICADO");
		
		dao.modificar(usuario);
		
		listar();
		
		dao.borrar(usuario.getId());
		
		listar();
	}

	private void listar() {
		for(Usuario usuario : dao.obtenerTodos()) {
			System.out.println(usuario);
		}
	}

}
