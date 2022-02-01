package com.ipartek.formacion.ipartekify.dal;

public class FabricaDaoImpl implements FabricaDao {

	private static final DaoArtista artista = new DaoArtistaMySql();
	
	@Override
	public DaoArtista getArtista() {
		return artista;
	}

}
