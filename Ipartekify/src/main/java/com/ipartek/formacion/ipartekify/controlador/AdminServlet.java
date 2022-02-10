package com.ipartek.formacion.ipartekify.controlador;

import java.io.IOException;
import java.time.Year;

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

import lombok.extern.java.Log;

@Log
@WebServlet("/admin/index")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private static Logger LOGGER = Logger.getLogger(AdminServlet.class.getName());
	
	private HttpServletRequest request;
	
	private static final FabricaDao fabrica = new FabricaDaoImpl();
	private static final DaoArtista daoArtista = fabrica.getArtista();
	private static final DaoAlbum daoAlbum = fabrica.getAlbum();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String borrar = request.getParameter("borrar");
		String artistaSeleccionado = request.getParameter("artista-seleccionado");
		String borrarAlbum = request.getParameter("borrar-album");
		String album = request.getParameter("album");

		Long idArtista = null;

		if (album != null) {
			Long idAlbum = Long.parseLong(album);

			log.info(artistaSeleccionado);
			
			request.setAttribute("artistaSeleccionado", artistaSeleccionado);
			request.setAttribute("album", daoAlbum.obtenerPorId(idAlbum));

			request.getRequestDispatcher("/WEB-INF/vistas/admin/album.jsp").forward(request, response);
			return;
		}

		if (borrarAlbum != null) {
			Long idAlbum = Long.parseLong(borrarAlbum);
			idArtista = daoAlbum.obtenerPorId(idAlbum).getArtista().getId();
			daoAlbum.borrar(idAlbum);
		}

		if (artistaSeleccionado != null) {
			idArtista = Long.parseLong(artistaSeleccionado);
		}

		if (id != null) {
			idArtista = Long.parseLong(id);
		}

		if (idArtista != null) {
			Artista artista = daoArtista.obtenerPorId(idArtista);
			request.setAttribute("artista", artista);

			Iterable<Album> albumes = daoAlbum.obtenerTodos(artista.getId());
			request.setAttribute("albumes", albumes);
		}

		if (id != null) {
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
		this.request = request;
		
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String idAlbum = request.getParameter("album-id");

		if (id != null) {
			postArtista(id);
		}
		
		if (idAlbum != null) {
			postAlbum(idAlbum);
		}

		response.sendRedirect(request.getContextPath() + "/admin/index");
	}

	private void postAlbum(String id) {
		String artista = request.getParameter("album-artista");
		String nombre = request.getParameter("album-nombre");
		String anno = request.getParameter("album-anno");
		String foto = request.getParameter("album-foto");
		
		Long idAlbum = idALong(id);
		Long idArtista = idALong(artista);
		
		Album album = new Album(idAlbum, nombre, Year.parse(anno), foto, new Artista(idArtista, null, null));
		
		if(idAlbum != null) {
			daoAlbum.modificar(album);
		} else {
			daoAlbum.insertar(album);
		}
	}

	private Long idALong(String id) {
		return id != null && id.trim().length() > 0 ? Long.parseLong(id) : null;
	}

	private void postArtista(String id) {
		String nombre = request.getParameter("nombre");
		String informacion = request.getParameter("informacion");

		Long idArtista = idALong(id);

		Artista artista = new Artista(idArtista, nombre, informacion);

		if (idArtista != null) {
			daoArtista.modificar(artista);
		} else {
			daoArtista.insertar(artista);
		}
	}

}
