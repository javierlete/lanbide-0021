package com.ipartek.formacion.uf2218.controladores;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelos.Usuario;

@WebServlet("/agregar-equipo")
public class AgregarEquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger LOGGER = Logger.getLogger(AgregarEquipoServlet.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		@SuppressWarnings("unchecked")
		List<Usuario> equipo = (List<Usuario>) request.getSession().getAttribute("equipo");
		
		LOGGER.info(String.valueOf(equipo));
		
		equipo.add(Globales.DAO_USUARIO.obtenerPorId(Long.parseLong(id)));
		
		request.getRequestDispatcher("/equipo").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
