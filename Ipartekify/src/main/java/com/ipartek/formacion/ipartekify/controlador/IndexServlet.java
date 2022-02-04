package com.ipartek.formacion.ipartekify.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ipartekify.dal.DaoAlbum;
import com.ipartek.formacion.ipartekify.dal.DaoArtista;
import com.ipartek.formacion.ipartekify.dal.DaoCancion;
import com.ipartek.formacion.ipartekify.dal.DaoUsuario;
import com.ipartek.formacion.ipartekify.dal.FabricaDao;
import com.ipartek.formacion.ipartekify.dal.FabricaDaoImpl;
import com.ipartek.formacion.ipartekify.modelos.Album;
import com.ipartek.formacion.ipartekify.modelos.Artista;
import com.ipartek.formacion.ipartekify.modelos.Cancion;
import com.ipartek.formacion.ipartekify.modelos.Usuario;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final FabricaDao fabrica = new FabricaDaoImpl();
	
	private static final DaoArtista daoArtista = fabrica.getArtista();
	private static final DaoAlbum daoAlbum = fabrica.getAlbum();
	private static final DaoCancion daoCancion = fabrica.getCancion();
	private static final DaoUsuario daoUsuario = fabrica.getUsuario();
	
	private HttpServletRequest request;
	private Usuario usuario;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strIdArtista = request.getParameter("artista");
		String strIdAlbum = request.getParameter("album");
		String strIdCancion = request.getParameter("cancion");
		
		String favoritas = request.getParameter("favoritas");
		String favorito = request.getParameter("favorito");
		
		this.usuario = (Usuario)request.getSession().getAttribute("usuario");
		
		this.request = request;
		
		if(strIdArtista != null && strIdArtista.trim().length() > 0) {
			artista(strIdArtista);
		}
		
		if(strIdCancion != null && strIdCancion.trim().length() > 0) {
			strIdAlbum = cancion(strIdCancion, favorito);
		}
		
		if(strIdAlbum != null && strIdAlbum.trim().length() > 0) {
			album(strIdAlbum);
		}
		
		if(favoritas != null) {
			favoritas();
		}
		
		Iterable<Artista> artistas = daoArtista.obtenerTodos();

		request.setAttribute("artistas", artistas);

		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	private void favoritas() {
		Iterable<Cancion> canciones = daoCancion.buscarFavoritas(usuario.getId());
		
		Album album = new Album(0L, "Canciones favoritas", null, null, null);
		
		for(Cancion cancion: canciones) {
			album.getCanciones().add(cancion);
		}
		
		request.setAttribute("album", album);
	}

	private void album(String strIdAlbum) {
		long idAlbum = Long.parseLong(strIdAlbum);
		Album album = daoAlbum.obtenerPorId(usuario.getId(), idAlbum);
		
		request.setAttribute("album", album);
	}

	private String cancion(String strIdCancion, String favorito) {
		long idCancion = Long.parseLong(strIdCancion);
		Cancion cancion = daoCancion.obtenerPorId(idCancion);
		
		request.setAttribute("cancion", cancion);
		
		if(favorito != null) {
			daoUsuario.favoritoCancion(usuario.getId(), idCancion);
		}
		
		return cancion.getAlbum().getId().toString();
	}

	private void artista(String strIdArtista) {
		long idArtista = Long.parseLong(strIdArtista);
		Artista artista = daoArtista.obtenerPorId(idArtista);
		
		request.setAttribute("artista", artista);
		
		Iterable<Album> albumes = daoAlbum.obtenerTodos(idArtista);
		
		request.setAttribute("albumes", albumes);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
