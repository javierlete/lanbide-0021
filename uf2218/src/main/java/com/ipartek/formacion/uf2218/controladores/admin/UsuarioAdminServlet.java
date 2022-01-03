package com.ipartek.formacion.uf2218.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.accesodatos.DaoUsuario;
import com.ipartek.formacion.uf2218.accesodatos.DaoUsuarioMemoria;
import com.ipartek.formacion.uf2218.modelos.Usuario;

@WebServlet("/admin/usuario")
public class UsuarioAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			DaoUsuario dao = DaoUsuarioMemoria.getInstancia();

			Usuario usuario = dao.obtenerPorId(Long.parseLong(id));

			request.setAttribute("usuario", usuario);
		}

		request.getRequestDispatcher("/WEB-INF/vistas/admin/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Recibir información de la petición
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// 2. Empaquetar la información en objetos del modelo
		Long idLong = id.length() == 0 ? null : Long.parseLong(id);

		Usuario usuarioIntroducido = new Usuario(idLong, email, password, nombre);

		// 3. Llamar a la lógica de negocio
		guardarOModificar(usuarioIntroducido);

		// 4. Dependiendo del resultado...

		// 5. Empaquetar datos para enviar a la siguiente vista

		// 6. Saltar a la siguiente vista
		response.sendRedirect(request.getContextPath() + "/admin/usuarios");
	}

	private void guardarOModificar(Usuario usuario) {
		DaoUsuario dao = DaoUsuarioMemoria.getInstancia();

		if (usuario.getId() == null) {
			dao.insertar(usuario);
		} else {
			dao.modificar(usuario);
		}
	}

}
