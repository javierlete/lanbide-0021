package com.ipartek.formacion.spring.ipartekify30.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ipartekify30.entidades.Album;
import com.ipartek.formacion.spring.ipartekify30.entidades.Artista;
import com.ipartek.formacion.spring.ipartekify30.entidades.Cancion;
import com.ipartek.formacion.spring.ipartekify30.entidades.Usuario;
import com.ipartek.formacion.spring.ipartekify30.repositorios.AlbumesRepository;
import com.ipartek.formacion.spring.ipartekify30.repositorios.ArtistasRepository;
import com.ipartek.formacion.spring.ipartekify30.repositorios.CancionesRepository;
import com.ipartek.formacion.spring.ipartekify30.repositorios.UsuariosRepository;

import lombok.extern.java.Log;

@Log
@Service
class IpartekifyServiceImpl implements IpartekifyService {
	@Autowired
	private ArtistasRepository repoArtistas;
	@Autowired
	private AlbumesRepository repoAlbumes;
	@Autowired
	private CancionesRepository repoCanciones;
	@Autowired
	private UsuariosRepository repoUsuarios;

	@Override
	public Iterable<Artista> obtenerArtistas() {
		log.info("Se han pedido todos los artistas");
		return repoArtistas.findAll();
	}

	@Override
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
	
	@Override
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
	
	@Override
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

	@Override
	public void artistaAgregar(Artista artista) {
		repoArtistas.save(artista);
	}

	@Override
	public void artistaModificar(Artista artista) {
		repoArtistas.save(artista);
	}

	@Override
	public void artistaBorrar(long id) {
		repoArtistas.deleteById(id);
	}

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		return repoUsuarios.findByEmail(email);
	}
}
