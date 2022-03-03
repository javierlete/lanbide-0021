package com.ipartek.formacion.spring.ipartekify30.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.ipartekify30.entidades.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuariosRepository extends PagingAndSortingRepository<Usuario, Long> {

}
