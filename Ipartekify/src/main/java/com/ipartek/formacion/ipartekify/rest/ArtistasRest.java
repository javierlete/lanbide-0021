package com.ipartek.formacion.ipartekify.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.formacion.ipartekify.dal.DaoAlbum;
import com.ipartek.formacion.ipartekify.dal.DaoArtista;
import com.ipartek.formacion.ipartekify.dal.FabricaDaoImpl;
import com.ipartek.formacion.ipartekify.modelos.Album;
import com.ipartek.formacion.ipartekify.modelos.Artista;

@Path("/artistas")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class ArtistasRest {
	
	private static final DaoArtista dao = new FabricaDaoImpl().getArtista();
	private static final DaoAlbum daoAlbum = new FabricaDaoImpl().getAlbum();
	
	@GET
	public Iterable<Artista> getArtistas() {
		return dao.obtenerTodos();
	}
	
	@GET
	@Path("{id}")
	public Artista getArtista(@PathParam("id") long id) {
		return dao.obtenerPorId(id);
	}
	
	@GET
	@Path("{id}/albumes")
	public Iterable<Album> getAlbumes(@PathParam("id") long id) {
		return daoAlbum.obtenerTodos(id);
	}
}
