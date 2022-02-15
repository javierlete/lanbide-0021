package com.ipartek.formacion.uf2215.repositorios;

import java.util.TreeMap;

import com.ipartek.formacion.uf2215.entidades.Cliente;

public class ClienteRepositorioMemoria implements ClienteRepositorio {
	
	private static final TreeMap<Long, Cliente> clientes = new TreeMap<>() {
		private static final long serialVersionUID = 7591428676121822742L;
		{
			put(1L, new Cliente(1L, "Javier", "Lete"));
			put(2L, new Cliente(2L, "Pepe", "Pérez"));
		}
	};
	
	@Override
	public Iterable<Cliente> getObjetos() {
		return clientes.values();
	}

	@Override
	public Cliente getObjeto(long id) {
		return clientes.get(id);
	}

	@Override
	public Cliente postObjeto(Cliente cliente) {
		Long id = clientes.size() > 0 ? clientes.lastKey() + 1L : 1L;
		cliente.setId(id);
		clientes.put(id, cliente);
		
		return cliente;
	}

	@Override
	public Cliente putObjeto(Cliente cliente) {
		clientes.put(cliente.getId(), cliente);
		
		return cliente;
	}

	@Override
	public void deleteObjeto(long id) {
		clientes.remove(id);
	}

}
