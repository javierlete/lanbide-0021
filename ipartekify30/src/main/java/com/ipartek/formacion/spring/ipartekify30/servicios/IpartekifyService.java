package com.ipartek.formacion.spring.ipartekify30.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ipartekify30.entidades.Album;
import com.ipartek.formacion.spring.ipartekify30.entidades.Artista;
import com.ipartek.formacion.spring.ipartekify30.entidades.Cancion;
import com.ipartek.formacion.spring.ipartekify30.repositorios.AlbumesRepository;
import com.ipartek.formacion.spring.ipartekify30.repositorios.ArtistasRepository;
import com.ipartek.formacion.spring.ipartekify30.repositorios.CancionesRepository;

import lombok.extern.java.Log;

@Log
@Service
public class IpartekifyService {
	@Autowired
	private ArtistasRepository repoArtistas;
	@Autowired
	private AlbumesRepository repoAlbumes;
	@Autowired
	private CancionesRepository repoCanciones;

	public Iterable<Artista> obtenerArtistas() {
		log.info("Se han pedido todos los artistas");
		return repoArtistas.findAll();
	}

	public Artista obtenerArtista(long id) {
		log.info("Se ha pedido el artista " + id);

		Optional<Artista> artista = repoArtistas.findById(id);

		if (artista.isPresent()) {
			return artista.get();
		} else {
			log.warning("El artista " + id + " no existe");
			return null;
		}
	}
	
	public Album obtenerAlbum(long id) {
		log.info("Se ha pedido el album " + id);

		Optional<Album> album = repoAlbumes.findById(id);

		if (album.isPresent()) {
			return album.get();
		} else {
			log.warning("El album " + id + " no existe");
			return null;
		}
	}
	
	public Cancion obtenerCancion(long id) {
		log.info("Se ha pedido la canción " + id);

		Optional<Cancion> cancion = repoCanciones.findById(id);

		if (cancion.isPresent()) {
			return cancion.get();
		} else {
			log.warning("La canción " + id + " no existe");
			return null;
		}
	}
}
