package com.ipartek.formacion.uf2218.controladores;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.uf2218.modelos.Evento;
import com.ipartek.formacion.uf2218.modelos.Usuario;

@WebServlet("/guardar-evento")
public class GuardarEventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/guardar-evento.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String fecha = request.getParameter("fecha");
		
		HttpSession session = request.getSession();
		
		Usuario responsable = (Usuario) session.getAttribute("usuario");
		@SuppressWarnings("unchecked")
		Map<Long, Usuario> equipo = (Map<Long, Usuario>) session.getAttribute("equipo");
		
		Evento evento = new Evento(null, nombre, LocalDateTime.parse(fecha), responsable);
		
		for(Usuario participante: equipo.values()) {
			evento.getParticipantes().add(participante);
		}
		
		Globales.DAO_EVENTO.insertar(evento);
	}
}
