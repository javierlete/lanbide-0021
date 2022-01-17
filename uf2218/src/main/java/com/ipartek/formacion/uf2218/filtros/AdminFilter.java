package com.ipartek.formacion.uf2218.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.uf2218.modelos.Usuario;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null && usuario.getRol().getNombre().equals("ADMIN")) {
			chain.doFilter(request, response);
		} else {
			// httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
			httpRequest.setAttribute("error", "Debes ser administrador para entrar en principal");
			httpRequest.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(httpRequest, httpResponse);
		}
	}
}
