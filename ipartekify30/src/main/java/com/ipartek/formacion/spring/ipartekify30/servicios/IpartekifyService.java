package com.ipartek.formacion.spring.ipartekify30.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ipartekify30.entidades.Album;
import com.ipartek.formacion.spring.ipartekify30.entidades.Artista;
import com.ipartek.formacion.spring.ipartekify30.repositorios.ArtistasRepository;

import lombok.extern.java.Log;

@Log
@Service
public class IpartekifyService {
	@Autowired
	private ArtistasRepository repoArtistas;
	
	public Iterable<Artista> obtenerArtistas() {
		log.info("Se han pedido todos los artistas");
		return repoArtistas.findAll();
	}
	
	public Iterable<Album> obtenerAlbumesPorIdArtista(long id) {
		log.info("Se han pedido los albumes del artista " + id);
		
		Optional<Artista> artista = repoArtistas.findById(id);
		
		if(artista.isPresent()) {
			return artista.get().getAlbumes();
		} else {
			log.warning("El artista " + id + " no existe");
			return null;
		}
				
	}
}
