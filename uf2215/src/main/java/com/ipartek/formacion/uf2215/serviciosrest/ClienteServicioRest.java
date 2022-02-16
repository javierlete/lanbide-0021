package com.ipartek.formacion.uf2215.serviciosrest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.uf2215.entidades.Cliente;
import com.ipartek.formacion.uf2215.repositorios.ClienteRepositorio;
import com.ipartek.formacion.uf2215.repositorios.ClienteRepositorioMemoria;

@WebServlet("/clientes/*")
public class ClienteServicioRest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final ClienteRepositorio repo = new ClienteRepositorioMemoria();
	
	private static final Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter(); 
		
		Long id = obtenerId(request);
		
		if(id == null) {
			out.println(gson.toJson(repo.getObjetos()));
		} else {
			out.println(gson.toJson(repo.getObjeto(id)));
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Cliente cliente = gson.fromJson(request.getReader(), Cliente.class);
		
		cliente = repo.postObjeto(cliente);
		
		response.getWriter().println(gson.toJson(cliente));
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Cliente cliente = gson.fromJson(request.getReader(), Cliente.class);
		
		repo.putObjeto(cliente);
		
		response.getWriter().println(gson.toJson(cliente));
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		repo.deleteObjeto(obtenerId(request));
		
		response.getWriter().println("{}");
	}

	private Long obtenerId(HttpServletRequest request) {
		return request.getPathInfo() == null || request.getPathInfo().length() <= 1 ? null : Long.parseLong(request.getPathInfo().substring(1));
	}
}
