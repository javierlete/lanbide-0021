package com.ipartek.formacion.spring.springweb.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.springweb.entidades.Usuario;
import com.ipartek.formacion.spring.springweb.repositorios.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosRestController {
	@Autowired
	private UsuarioRepository repo;

	@GetMapping
	public Iterable<Usuario> getUsuarios() {
		return repo.findAll();
	}

	@GetMapping("{id}")
	public Usuario getUsuarioById(@PathVariable long id) {
		Optional<Usuario> usuario = repo.findById(id);

		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		}
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Usuario postUsuario(@RequestBody Usuario usuario) {
		return repo.save(usuario);
	}

	@PutMapping("{id}")
	public Usuario putUsuario(@RequestBody Usuario usuario) {
		return repo.save(usuario);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteUsuarioById(@PathVariable long id) {
		repo.deleteById(id);
	}
}
