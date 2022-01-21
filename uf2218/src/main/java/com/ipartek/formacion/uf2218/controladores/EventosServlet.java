package com.ipartek.formacion.uf2218.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelos.Evento;
import com.ipartek.formacion.uf2218.modelos.Usuario;

@WebServlet("/eventos")
public class EventosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		Iterable<Evento> eventos;
		
		if(usuario.getRol().getNombre().equals("ADMIN")) {
			eventos = Globales.DAO_EVENTO.obtenerTodos();
		} else {
			eventos = Globales.DAO_EVENTO.obtenerTodos(usuario.getId());
		}
		
		request.setAttribute("eventos", eventos);
		request.getRequestDispatcher("/WEB-INF/vistas/eventos.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
