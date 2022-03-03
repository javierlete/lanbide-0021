package com.ipartek.formacion.spring.ipartekify30.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.ipartekify30.entidades.Album;

@RepositoryRestResource(collectionResourceRel = "albumes", path = "albumes")
public interface AlbumesRepository extends PagingAndSortingRepository<Album, Long> {

}
