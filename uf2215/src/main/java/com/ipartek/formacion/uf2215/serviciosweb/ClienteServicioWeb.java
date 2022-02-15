package com.ipartek.formacion.uf2215.serviciosweb;

import javax.xml.ws.Endpoint;

public class ClienteServicioWeb {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/clienteservicio", new ClienteServicioImpl());
		System.out.println("Servidor arrancado en http://localhost:8080/clienteservicio");
	}

}
