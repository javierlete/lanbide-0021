package com.ipartek.formacion.ipartekify.dal;

public class FabricaDaoImpl implements FabricaDao {

	private static final DaoArtista artista = new DaoArtistaMySql();
	private static final DaoAlbum album = new DaoAlbumMySql();
	
	@Override
	public DaoArtista getArtista() {
		return artista;
	}

	@Override
	public DaoAlbum getAlbum() {
		return album;
	}

}
