package com.ipartek.formacion.uf2218.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelos.Usuario;

@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String buscar = request.getParameter("buscar");
		String orden = request.getParameter("orden");
		
		Iterable<Usuario> usuarios;
		
		int pagina = obtenerPagina(request);
		
		if(buscar == null || buscar.trim().length() == 0) {
			usuarios = Globales.DAO_USUARIO.obtenerTodos(pagina, orden);
		} else {
			usuarios = Globales.DAO_USUARIO.buscar(buscar, pagina, orden);
		}
		
		request.setAttribute("orden", orden);
		request.setAttribute("buscar", buscar);
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("/WEB-INF/vistas/principal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private int obtenerPagina(HttpServletRequest request) {
		String pagina = request.getParameter("pagina");
		int pag;
		
		if(pagina == null) {
			pag = 1;
		} else {
			pag = Integer.parseInt(pagina);
		}
		
		request.setAttribute("pagina", pag);
		
		return pag;
	}

}
