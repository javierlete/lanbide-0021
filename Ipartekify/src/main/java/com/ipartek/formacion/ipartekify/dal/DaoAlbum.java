package com.ipartek.formacion.ipartekify.dal;

import com.ipartek.formacion.ipartekify.modelos.Album;

public interface DaoAlbum extends Dao<Album> {
	Iterable<Album> obtenerTodos(long idArtista);
	
	Album obtenerPorId(long idUsuario, long idAlbum);
}
