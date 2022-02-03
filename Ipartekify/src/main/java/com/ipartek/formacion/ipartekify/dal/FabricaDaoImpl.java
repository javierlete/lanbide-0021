package com.ipartek.formacion.ipartekify.dal;

public class FabricaDaoImpl implements FabricaDao {

	private static final DaoArtista artista = new DaoArtistaMySql();
	private static final DaoAlbum album = new DaoAlbumMySql();
	private static final DaoCancion cancion = new DaoCancionMySql();
	private static final DaoUsuario usuario = new DaoUsuarioMySql();
	
	@Override
	public DaoArtista getArtista() {
		return artista;
	}

	@Override
	public DaoAlbum getAlbum() {
		return album;
	}

	@Override
	public DaoCancion getCancion() {
		return cancion;
	}
	
	@Override
	public DaoUsuario getUsuario() {
		return usuario;
	}
}
