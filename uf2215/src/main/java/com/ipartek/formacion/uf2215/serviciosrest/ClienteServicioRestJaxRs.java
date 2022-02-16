package com.ipartek.formacion.uf2215.serviciosrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.uf2215.entidades.Cliente;
import com.ipartek.formacion.uf2215.repositorios.ClienteRepositorio;
import com.ipartek.formacion.uf2215.repositorios.ClienteRepositorioMemoria;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class ClienteServicioRestJaxRs {
	private static final ClienteRepositorio repo = new ClienteRepositorioMemoria();
	
	@GET
	public Response getClientes() {     
        return Response.ok(repo.getObjetos()).build();   
    }
	
	@GET
	@Path("{id}")
	public Response getCliente(@PathParam("id") long id) {
		Cliente cliente = repo.getObjeto(id);
		if(cliente == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(cliente).build();
	}
	
	@POST
	public Response postCliente(Cliente cliente) {
		return Response.status(Status.CREATED).entity(repo.postObjeto(cliente)).build();
	}
	
	@PUT
	@Path("{id}")
	public Response putCliente(@PathParam("id") long id, Cliente cliente) {
		if(id != cliente.getId()) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok(repo.putObjeto(cliente)).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteCliente(@PathParam("id") long id) {
		repo.deleteObjeto(id);
		return Response.noContent().build();
	}
}
