package com.ipartek.formacion.uf2215.serviciosweb;

import java.util.ArrayList;

import com.ipartek.formacion.uf2215.entidades.Cliente;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface ClienteServicio {
	@WebMethod
	ArrayList<Cliente> getClientes();
	@WebMethod
	Cliente getCliente(long id);
	
	@WebMethod
	Cliente postCliente(Cliente cliente);
	@WebMethod
	Cliente putCliente(Cliente cliente);
	@WebMethod
	void deleteCliente(long id);
}
