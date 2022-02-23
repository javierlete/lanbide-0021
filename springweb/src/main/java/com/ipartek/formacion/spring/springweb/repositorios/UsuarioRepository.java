package com.ipartek.formacion.spring.springweb.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.springweb.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Usuario findByEmail(String email);
	Iterable<Usuario> findByRol(String rol);
}
