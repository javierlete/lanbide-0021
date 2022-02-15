package com.ipartek.formacion.uf2215.serviciosweb;

import java.util.ArrayList;

import com.ipartek.formacion.uf2215.entidades.Cliente;
import com.ipartek.formacion.uf2215.repositorios.ClienteRepositorio;
import com.ipartek.formacion.uf2215.repositorios.ClienteRepositorioMemoria;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(endpointInterface = "com.ipartek.formacion.uf2215.serviciosweb.ClienteServicio")
public class ClienteServicioImpl implements ClienteServicio {

	private static final ClienteRepositorio repositorio = new ClienteRepositorioMemoria();
	
	@WebMethod
	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		for(Cliente cliente: repositorio.getObjetos()) {
			clientes.add(cliente);
		}
		
		return clientes;
	}

	@WebMethod
	public Cliente getCliente(long id) {
		return repositorio.getObjeto(id);
	}

	@WebMethod
	public Cliente postCliente(Cliente cliente) {
		return repositorio.postObjeto(cliente);
	}

	@WebMethod
	public Cliente putCliente(Cliente cliente) {
		return repositorio.putObjeto(cliente);
	}

	@WebMethod
	public void deleteCliente(long id) {
		repositorio.deleteObjeto(id);
	}

}
