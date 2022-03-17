package com.ipartek.formacion.spring.ipartekify30.controladores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.ipartek.formacion.spring.ipartekify30.entidades.Album;
import com.ipartek.formacion.spring.ipartekify30.entidades.Artista;
import com.ipartek.formacion.spring.ipartekify30.entidades.Cancion;

@SpringBootTest
class IndexControllerTest {
	@Autowired
	private IndexController indexController;
	
	@Test
	void index() {
		Model modelo = new ExtendedModelMap();
		
		String vista = indexController.index(modelo);
		assertEquals("index", vista);
		
		Object objArtistas = modelo.getAttribute("artistas");
		assertNotNull(objArtistas, "Debe existir un objeto artistas");
		assertInstanceOf(Iterable.class, objArtistas);
		
		@SuppressWarnings("unchecked")
		Iterable<Artista> artistas = (Iterable<Artista>) objArtistas;
		
		Artista artista = artistas.iterator().next();
		
		assertEquals(new Artista(1L, "Fundación Tony Manero", "Disco Funk"), artista);
	}
	
	@Test
	void artista() {
		Model modelo = new ExtendedModelMap();
		
		String vista = indexController.artista(1L, modelo);
		assertEquals("index", vista);
		
		Object objArtistas = modelo.getAttribute("artistas");
		assertNotNull(objArtistas, "Debe existir un objeto artistas");
		assertInstanceOf(Iterable.class, objArtistas);
		
		Object objArtista = modelo.getAttribute("artista");
		assertNotNull(objArtista, "Debe devolver un artista");
		assertInstanceOf(Artista.class, objArtista);
		
		Artista artista = (Artista) objArtista;
		assertEquals(1L, artista.getId());
		assertEquals(new Artista(1L, "Fundación Tony Manero", "Disco Funk"), artista);
		
		modelo = new ExtendedModelMap();
		vista = indexController.artista(-1L, modelo);
		assertEquals("index", vista);
		
		objArtistas = modelo.getAttribute("artistas");
		assertNotNull(objArtistas, "Debe existir un objeto artistas");
		assertInstanceOf(Iterable.class, objArtistas);
		
		objArtista = modelo.getAttribute("artista");
		assertNull(objArtista, "NO debe devolver un artista");
	}
	
	@Test
	void cancion() {
		long idCancion = 2L;
		Model modelo = new ExtendedModelMap();
		String favoritas = null;
		
		String vista = indexController.cancion(idCancion, modelo, favoritas);
		assertEquals("index", vista);
		
		Object objArtista = modelo.getAttribute("artista");
		assertNotNull(objArtista);
		assertInstanceOf(Artista.class, objArtista);

		Artista artista = (Artista) objArtista;
		assertEquals(new Artista(3L, "Yes", "Rock Progresivo"), artista);
		
		Object objAlbum = modelo.getAttribute("album");
		assertNotNull(objAlbum);
		assertInstanceOf(Album.class, objAlbum);

		Album album = (Album) objAlbum;
		assertEquals(new Album(2L, "Relayer", 1974, "https://i.ytimg.com/vi/YXnj64o198A/mqdefault.jpg", null, artista), album);
		
		Object objCancion = modelo.getAttribute("cancion");
		assertNotNull(objCancion);
		assertInstanceOf(Cancion.class, objCancion);
		
		Cancion cancion = (Cancion) objCancion;
		assertEquals(new Cancion(2L, "The Gates of Delirium", "00:21:16", "EdmUAsU2eXI", album), cancion);
	}
	
	@Test
	void lista() {
		Model modelo = new ExtendedModelMap();
		
		String vista = indexController.lista(1L, modelo);
		vista = indexController.artista(-1L, modelo);
		assertEquals("index", vista);
		
		Object objAlbum = modelo.getAttribute("album");
		assertNotNull(objAlbum, "Se debe recibir un album");
		assertInstanceOf(Album.class, objAlbum);
		
		Album album = (Album) objAlbum;
		assertEquals(-1L, album.getId());
		assertEquals("Prueba", album.getNombre());
		assertNotNull(album.getCanciones(), "Debe existir una lista de canciones");
	}
}
