package com.ipartek.formacion.ipartekify.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ipartekify.dal.DaoAlbum;
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
		DaoArtista daoArtista = fabrica.getArtista();
		DaoAlbum daoAlbum = fabrica.getAlbum();
		
		String strIdArtista = request.getParameter("artista");
		String strIdAlbum = request.getParameter("album");
		
		if(strIdArtista != null && strIdArtista.trim().length() > 0) {
			long idArtista = Long.parseLong(strIdArtista);
			Artista artista = daoArtista.obtenerPorId(idArtista);
			
			request.setAttribute("artista", artista);
			
			Iterable<Album> albumes = daoAlbum.obtenerTodos(idArtista);
			
			request.setAttribute("albumes", albumes);
		}
		
		if(strIdAlbum != null && strIdAlbum.trim().length() > 0) {
			long idAlbum = Long.parseLong(strIdAlbum);
			Album album = daoAlbum.obtenerPorId(idAlbum);
			
			request.setAttribute("album", album);
		}
		
		Iterable<Artista> artistas = daoArtista.obtenerTodos();

		request.setAttribute("artistas", artistas);

		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
