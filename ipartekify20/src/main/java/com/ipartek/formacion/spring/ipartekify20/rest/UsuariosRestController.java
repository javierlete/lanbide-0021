package com.ipartek.formacion.spring.ipartekify20.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.ipartekify20.entidades.Usuario;
import com.ipartek.formacion.spring.ipartekify20.repositorios.UsuariosRepository;

import lombok.extern.java.Log;

@Log
@RestController
public class UsuariosRestController {
	
	// private static final Logger log = Logger.getLogger(UsuariosRestController.class.getName());
	
	@Autowired
	private UsuariosRepository repo;
	
	@GetMapping("/usuarios")
	public Iterable<Usuario> getUsuarios() {
		log.info("Se han pedido todos los usuarios");
		return repo.findAll(); 
	}
}
