package com.ipartek.formacion.ipartekify.controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import com.ipartek.formacion.ipartekify.modelos.Lista;
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
	private HttpServletResponse response;
	private Usuario usuario;
	
	private static final Logger LOGGER = Logger.getLogger(IndexServlet.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String strIdArtista = request.getParameter("artista");
			String strIdAlbum = request.getParameter("album");
			String strIdCancion = request.getParameter("cancion");
			
			String favoritas = request.getParameter("favoritas");
			String favorito = request.getParameter("favorito");
			String nuevaLista = request.getParameter("nueva-lista");
			String lista = request.getParameter("lista");
			String nuevaCancion = request.getParameter("nueva-cancion");
			String quitarCancion = request.getParameter("quitar-cancion");
			String paraLista = request.getParameter("para-lista");
			
			this.usuario = (Usuario)request.getSession().getAttribute("usuario");
			
			this.request = request;
			this.response = response;
			
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
			
			if(lista != null) {
				lista(lista);
			}
			
			if(nuevaLista != null) {
				crearLista(usuario, nuevaLista);
			}
			
			if(nuevaCancion != null && paraLista != null) {
				insertarCancionLista(nuevaCancion, paraLista);
				return;
			}
			
			if(quitarCancion != null && paraLista != null) {
				quitarCancionLista(quitarCancion, paraLista);
				return;
			}
			
			Iterable<Artista> artistas = daoArtista.obtenerTodos();
			Iterable<Lista> listas = daoUsuario.obtenerListas(usuario.getId());
			
			request.setAttribute("artistas", artistas);
			request.setAttribute("listas", listas);

			request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
		} catch (Exception e) {
			// LOGGER.throwing(getServletName(), getServletInfo(), e);
			LOGGER.log(Level.SEVERE, "Ha habido un error en doGet", e);
			
			request.setAttribute("error", e.getMessage());
			
			request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
		}
	}

	private void quitarCancionLista(String quitarCancion, String paraLista) throws IOException {
		Long idCancion = Long.parseLong(quitarCancion);
		Long idLista = Long.parseLong(paraLista);
		
		daoUsuario.quitarCancionLista(idCancion, idLista);
		
		response.sendRedirect(request.getContextPath() + "/index?lista=" + idLista);
	}

	private void insertarCancionLista(String nuevaCancion, String paraLista) throws IOException {
		Long idCancion = Long.parseLong(nuevaCancion);
		Long idLista = Long.parseLong(paraLista);
		
		daoUsuario.insertarCancionLista(idCancion, idLista);
		
		response.sendRedirect(request.getContextPath() + "/index?cancion=" + idCancion);
	}

	private void lista(String idListaString) {
		Long id = Long.parseLong(idListaString);
		Lista lista = daoUsuario.obtenerListaPorId(id);
		
		// Indicamos que es una lista utilizando su id en negativo en lugar de positivo
		Album album = new Album(-id, lista.getNombre(), null, null, null);
		
		for(Cancion cancion: daoUsuario.obtenerCancionesLista(id)) {
			album.getCanciones().add(cancion);
		}
		
		request.setAttribute("album", album);
	}

	private void crearLista(Usuario usuario, String nuevaLista) {
		daoUsuario.insertarLista(usuario.getId(), new Lista(null, nuevaLista, null));
	}

	private void favoritas() {
		Iterable<Cancion> canciones = daoCancion.buscarFavoritas(usuario.getId());
		
		// Indicamos con el 0L que lo que hemos mandado son los favoritos
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
