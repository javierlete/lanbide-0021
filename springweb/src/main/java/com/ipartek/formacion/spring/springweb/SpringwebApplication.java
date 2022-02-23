package com.ipartek.formacion.spring.springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.springweb.entidades.Usuario;
import com.ipartek.formacion.spring.springweb.repositorios.UsuarioDao;
import com.ipartek.formacion.spring.springweb.repositorios.UsuarioRepository;

@SpringBootApplication
public class SpringwebApplication {

	@Autowired
	private UsuarioDao dao;
	
	@Autowired
	private UsuarioRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringwebApplication.class, args);
	}

	public void runJpa(String... args) throws Exception {
		listado();
		
		System.out.println(repo.findById(2L).get());
		
		Usuario usuario = repo.save(new Usuario(null, "jpa@bbbb.cccc", "asdfasdf", "PRUEBA"));
		
		listado();
		
		usuario.setRol("MODIFICADOJPA");
		
		repo.save(usuario);
		
		listado();
		
		repo.deleteById(usuario.getId());
		
		listado();
		
		System.out.println(repo.count());
		
		System.out.println(repo.findByEmail("javier@lete.net"));
		
		for(Usuario u: repo.findByRol("USER")) {
			System.out.println(u);
		}
	}

	private void listado() {
		for(Usuario usuario: repo.findAll()) {
			System.out.println(usuario);
		}
	}
	
	public void runAnterior(String... args) throws Exception {
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
