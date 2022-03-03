package com.ipartek.formacion.spring.ipartekify30.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.ipartekify30.entidades.Artista;

@RepositoryRestResource(collectionResourceRel = "artistas", path = "artistas")
public interface ArtistasRepository extends PagingAndSortingRepository<Artista, Long> {

}
