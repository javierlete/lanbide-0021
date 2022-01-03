package com.ipartek.formacion.uf2218.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.accesodatos.DaoUsuario;
import com.ipartek.formacion.uf2218.accesodatos.DaoUsuarioMemoria;
import com.ipartek.formacion.uf2218.modelos.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibir información de la petición
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// 2. Empaquetar la información en objetos del modelo
		Usuario usuarioIntroducido = new Usuario(null, email, password, null);
		
		// 3. Llamar a la lógica de negocio
		Usuario usuarioValido = validarUsuario(usuarioIntroducido);
		
		// 4. Dependiendo del resultado...
		if(usuarioValido != null) {
			// 5. Empaquetar datos para enviar a la siguiente vista
			request.getSession().setAttribute("usuario", usuarioValido);
			
			// 6. Saltar a la siguiente vista
			// request.getRequestDispatcher("/WEB-INF/vistas/principal.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/principal");
		} else {
			// 5. Empaquetar datos para enviar a la siguiente vista
			request.setAttribute("usuario", usuarioIntroducido);
			request.setAttribute("error", "El email o la contraseña son incorrectos");
			
			// 6. Saltar a la siguiente vista
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}

	private Usuario validarUsuario(Usuario usuario) {
		DaoUsuario dao = DaoUsuarioMemoria.getInstancia();
		Usuario usuarioCompleto = dao.obtenerPorEmail(usuario.getEmail());
		
		if(usuarioCompleto != null && usuario.getPassword().equals(usuario.getPassword())) {
			return usuarioCompleto;
		}
		return null; 
	}
	
	

}
