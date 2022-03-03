package com.ipartek.formacion.spring.ipartekify30.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.ipartekify30.entidades.Lista;

@RepositoryRestResource(collectionResourceRel = "listas", path = "listas")
public interface ListasRepository extends PagingAndSortingRepository<Lista, Long> {

}
