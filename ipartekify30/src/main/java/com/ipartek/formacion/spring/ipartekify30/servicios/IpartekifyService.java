package com.ipartek.formacion.spring.ipartekify30.servicios;

import com.ipartek.formacion.spring.ipartekify30.entidades.Album;
import com.ipartek.formacion.spring.ipartekify30.entidades.Artista;
import com.ipartek.formacion.spring.ipartekify30.entidades.Cancion;
import com.ipartek.formacion.spring.ipartekify30.entidades.Lista;
import com.ipartek.formacion.spring.ipartekify30.entidades.Usuario;

public interface IpartekifyService {

	Iterable<Artista> obtenerArtistas();

	Artista obtenerArtista(long id);

	Album obtenerAlbum(long id);

	Cancion obtenerCancion(long id);

	void artistaAgregar(Artista artista);

	void artistaModificar(Artista artista);

	void artistaBorrar(long id);

	Usuario obtenerUsuarioPorEmail(String email);
	
	void guardarUsuario(Usuario usuario);
	
	void nuevaLista(Lista lista, Usuario usuario);
	
	void nuevaLista(String nombre, Usuario usuario);

	void agregarCancionLista(long idLista, long idCancion);

	Lista obtenerLista(long idLista);
}