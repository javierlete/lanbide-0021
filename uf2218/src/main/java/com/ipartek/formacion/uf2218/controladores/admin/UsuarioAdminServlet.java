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
		doGet(request, response);
	}

}
