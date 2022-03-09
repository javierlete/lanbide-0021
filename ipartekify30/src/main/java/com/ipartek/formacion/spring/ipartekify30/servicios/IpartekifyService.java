package com.ipartek.formacion.spring.ipartekify30.servicios;

import com.ipartek.formacion.spring.ipartekify30.entidades.Album;
import com.ipartek.formacion.spring.ipartekify30.entidades.Artista;
import com.ipartek.formacion.spring.ipartekify30.entidades.Cancion;

public interface IpartekifyService {

	Iterable<Artista> obtenerArtistas();

	Artista obtenerArtista(long id);

	Album obtenerAlbum(long id);

	Cancion obtenerCancion(long id);

}