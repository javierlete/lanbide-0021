package com.ipartek.formacion.uf2215.serviciosweb;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.ipartek.formacion.uf2215.entidades.Cliente;

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
