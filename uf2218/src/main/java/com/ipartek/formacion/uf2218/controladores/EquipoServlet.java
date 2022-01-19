package com.ipartek.formacion.uf2218.controladores;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelos.Usuario;

@WebServlet("/equipo")
public class EquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(EquipoServlet.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String op = request.getParameter("op");

		if (id != null) {

			@SuppressWarnings("unchecked")
			Map<Long, Usuario> equipo = (Map<Long, Usuario>) request.getSession().getAttribute("equipo");

			LOGGER.info(String.valueOf(equipo));

			long longId = Long.parseLong(id);
			
			switch(op) {
			case "agregar": 
				equipo.put(longId, Globales.DAO_USUARIO.obtenerPorId(longId));
				break;
			case "quitar":
				equipo.remove(longId);
				break;
			default:
				throw new ServletException("No existe la operación " + op);
			}

			// request.getRequestDispatcher("/equipo").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/equipo");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/equipo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
