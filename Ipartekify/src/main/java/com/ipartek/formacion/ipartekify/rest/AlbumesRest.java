package com.ipartek.formacion.ipartekify.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.formacion.ipartekify.dal.DaoAlbum;
import com.ipartek.formacion.ipartekify.dal.FabricaDaoImpl;
import com.ipartek.formacion.ipartekify.modelos.Album;

@Path("/albumes")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class AlbumesRest {
	
	private static final DaoAlbum dao = new FabricaDaoImpl().getAlbum();
	
	@GET
	@Path("{id}")
	public Album getAlbum(@PathParam("id") long id) {
		Album album = dao.obtenerPorId(id);
		System.out.println(album);
		return album;
	}
}
