package com.ipartek.formacion.spring.ipartekify30.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.ipartekify30.entidades.Cancion;

@RepositoryRestResource(collectionResourceRel = "canciones", path = "canciones")
public interface CancionesRepository extends PagingAndSortingRepository<Cancion, Long> {

}
