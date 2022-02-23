package com.ipartek.formacion.spring.springweb.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.springweb.entidades.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	Usuario findByEmail(String email);
	Iterable<Usuario> findByRol(String rol);
}
