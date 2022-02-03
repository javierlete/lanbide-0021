package com.ipartek.formacion.ipartekify.dal;

public interface FabricaDao {
	DaoArtista getArtista();
	
	DaoAlbum getAlbum();
	
	DaoCancion getCancion();
	
	DaoUsuario getUsuario();
}
