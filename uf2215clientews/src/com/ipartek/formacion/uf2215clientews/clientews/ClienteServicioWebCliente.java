package com.ipartek.formacion.uf2215clientews.clientews;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.ipartek.formacion.uf2215clientews.cliente.Cliente;
import com.ipartek.formacion.uf2215clientews.cliente.ClienteServicio;
import com.ipartek.formacion.uf2215clientews.cliente.ClienteServicioImplService;

public class ClienteServicioWebCliente {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/clienteservicio?wsdl");

		ClienteServicioImplService servicio 
          = new ClienteServicioImplService(url);
        ClienteServicio clienteServicioWeb 
          = servicio.getClienteServicioImplPort();

        List<Cliente> clientes 
          = clienteServicioWeb.getClientes();
        
        for(Cliente cliente: clientes) {
        	System.out.println(cliente.getNombre());
        }
	}

}
