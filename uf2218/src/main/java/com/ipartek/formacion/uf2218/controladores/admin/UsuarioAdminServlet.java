package com.ipartek.formacion.uf2218.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.accesodatos.DaoUsuario;
import com.ipartek.formacion.uf2218.controladores.Globales;
import com.ipartek.formacion.uf2218.modelos.Usuario;

@WebServlet("/admin/usuario")
public class UsuarioAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			Usuario usuario = Globales.DAO_USUARIO.obtenerPorId(Long.parseLong(id));

			request.setAttribute("usuario", usuario);
		}

		request.setAttribute("roles", Globales.DAO_ROL.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recibir datos de formulario con caracteres internacionales
		request.setCharacterEncoding("UTF-8");

		// 1. Recibir información de la petición
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// 2. Empaquetar la información en objetos del modelo
		Long idLong = id.length() == 0 ? null : Long.parseLong(id);

		// TODO Añadir Rol
		Usuario usuarioIntroducido = new Usuario(idLong, email, password, nombre, null);

		// 3. Llamar a la lógica de negocio
		boolean usuarioCorrecto = guardarOModificar(usuarioIntroducido);

		// 4. Dependiendo del resultado...
		if (usuarioCorrecto) {
			// 5. Empaquetar datos para enviar a la siguiente vista

			// 6. Saltar a la siguiente vista
			response.sendRedirect(request.getContextPath() + "/admin/usuarios");
		} else {
			// 5. Empaquetar datos para enviar a la siguiente vista
			request.setAttribute("usuario", usuarioIntroducido);
			// 6. Saltar a la siguiente vista
			request.getRequestDispatcher("/WEB-INF/vistas/admin/usuario.jsp").forward(request, response);
		}
	}

	private boolean guardarOModificar(Usuario usuario) {
		if (usuario.getErrores().size() > 0) {
			return false;
		}

		DaoUsuario dao = Globales.DAO_USUARIO;

		if (usuario.getId() == null) {
			dao.insertar(usuario);
		} else {
			dao.modificar(usuario);
		}

		return true;
	}

}
