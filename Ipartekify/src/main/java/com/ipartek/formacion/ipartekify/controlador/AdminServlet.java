package com.ipartek.formacion.ipartekify.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ipartekify.dal.DaoArtista;
import com.ipartek.formacion.ipartekify.dal.FabricaDao;
import com.ipartek.formacion.ipartekify.dal.FabricaDaoImpl;
import com.ipartek.formacion.ipartekify.modelos.Artista;

@WebServlet("/admin/index")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final FabricaDao fabrica = new FabricaDaoImpl();
	private static final DaoArtista daoArtista = fabrica.getArtista();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String borrar = request.getParameter("borrar");

		if (id != null) {
			Artista artista = daoArtista.obtenerPorId(Long.parseLong(id));
			request.setAttribute("artista", artista);

			request.getRequestDispatcher("/WEB-INF/vistas/admin/artista.jsp").forward(request, response);
			return;
		}

		if (borrar != null) {
			daoArtista.borrar(Long.parseLong(borrar));
		}

		request.setAttribute("artistas", daoArtista.obtenerTodos());

		request.getRequestDispatcher("/WEB-INF/vistas/admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String informacion = request.getParameter("informacion");
		
		Long idArtista = id != null && id.trim().length() > 0 ? Long.parseLong(id) : null;
		
		Artista artista = new Artista(idArtista, nombre, informacion);
		
		if(idArtista != null) {
			daoArtista.modificar(artista);
		} else {
			daoArtista.insertar(artista);
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/index");
	}

}
