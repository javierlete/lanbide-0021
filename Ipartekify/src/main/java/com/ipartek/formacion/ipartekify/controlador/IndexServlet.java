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
import com.ipartek.formacion.ipartekify.modelos.Album;
import com.ipartek.formacion.ipartekify.modelos.Artista;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FabricaDao fabrica = new FabricaDaoImpl();
		DaoArtista dao = fabrica.getArtista();
		
		String id = request.getParameter("artista");
		
		if(id != null && id.trim().length() > 0) {
			long idArtista = Long.parseLong(id);
			Artista artista = dao.obtenerPorId(idArtista);
			
			request.setAttribute("artista", artista);
			
			Iterable<Album> albumes = fabrica.getAlbum().obtenerTodos(idArtista);
			
			request.setAttribute("albumes", albumes);
		}
		
		Iterable<Artista> artistas = dao.obtenerTodos();

		request.setAttribute("artistas", artistas);

		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
