package com.ipartek.formacion.uf2218.controladores.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.accesodatos.DaoUsuario;
import com.ipartek.formacion.uf2218.accesodatos.DaoUsuarioMemoria;

@WebServlet("/admin/usuarios")
public class UsuariosAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoUsuario dao = DaoUsuarioMemoria.getInstancia();
		
		request.setAttribute("usuarios", dao.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/usuarios.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
