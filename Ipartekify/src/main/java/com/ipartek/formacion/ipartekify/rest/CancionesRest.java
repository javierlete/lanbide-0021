package com.ipartek.formacion.ipartekify.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ipartek.formacion.ipartekify.dal.DaoCancion;
import com.ipartek.formacion.ipartekify.dal.FabricaDaoImpl;
import com.ipartek.formacion.ipartekify.modelos.Cancion;

@Path("/canciones")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class CancionesRest {
	
	private static final DaoCancion dao = new FabricaDaoImpl().getCancion();
	
	@GET
	@Path("{id}")
	public Cancion getCancion(@PathParam("id") long id) {
		return dao.obtenerPorId(id);
	}
}
