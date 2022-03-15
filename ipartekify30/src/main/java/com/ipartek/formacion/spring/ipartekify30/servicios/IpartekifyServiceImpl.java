package com.ipartek.formacion.spring.ipartekify30.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ipartekify30.entidades.Album;
import com.ipartek.formacion.spring.ipartekify30.entidades.Artista;
import com.ipartek.formacion.spring.ipartekify30.entidades.Cancion;
import com.ipartek.formacion.spring.ipartekify30.entidades.Lista;
import com.ipartek.formacion.spring.ipartekify30.entidades.Usuario;
import com.ipartek.formacion.spring.ipartekify30.repositorios.AlbumesRepository;
import com.ipartek.formacion.spring.ipartekify30.repositorios.ArtistasRepository;
import com.ipartek.formacion.spring.ipartekify30.repositorios.CancionesRepository;
import com.ipartek.formacion.spring.ipartekify30.repositorios.ListasRepository;
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
	@Autowired
	private ListasRepository repoListas;

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

	@Override
	public void guardarUsuario(Usuario usuario) {
		repoUsuarios.save(usuario);
	}

	@Override
	public void nuevaLista(Lista lista, Usuario usuario) {
		lista.setUsuario(usuario);

		repoListas.save(lista);

		usuario.getBiblioteca().add(lista);
		
		guardarUsuario(usuario);
	}

	@Override
	public void nuevaLista(String nombre, Usuario usuario) {
		Lista lista = new Lista();
		lista.setNombre(nombre);
		
		nuevaLista(lista, usuario);
	}

	@Override
	public void agregarCancionLista(long idLista, long idCancion) {
		Lista lista = repoListas.findById(idLista).get();
		Cancion cancion = repoCanciones.findById(idCancion).get();
		
		lista.getCanciones().add(cancion);
		
		repoListas.save(lista);
	}

	@Override
	public Lista obtenerLista(long idLista) {
		return repoListas.findById(idLista).get();
	}
}
