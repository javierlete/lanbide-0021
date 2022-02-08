package com.ipartek.formacion.ipartekify.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ipartekify.modelos.Usuario;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");

		if (usuario != null && usuario.getRol().equals("ADMIN")) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
