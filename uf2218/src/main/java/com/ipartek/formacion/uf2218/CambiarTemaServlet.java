package com.ipartek.formacion.uf2218;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CambiarTemaServlet")
public class CambiarTemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String tema;
		
		tema = request.getParameter("tema");
		
		if(tema == null) {
			tema = leerCookie(request, "tema");
		}
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang='es'>");
		out.println("<head>");
		out.println("    <meta charset='UTF-8'>");
		out.println("    <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
		out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("    <link rel='stylesheet' href='css/estilos.css'>");
		out.println("    <title>Cambiar tema</title>");
		out.println("</head>");
		out.print("<body class='");
		
		out.print(tema);
		
		out.println("'>");
		out.println("    <form method='post'>");
		out.println("        <select name='tema'>");
		out.println("            <option value=''>Seleccione un tema</option>");
		out.println("            <option value='claro'>Claro</option>");
		out.println("            <option value='oscuro'>Oscuro</option>");
		out.println("        </select>");
		out.println("        <button>Aceptar</button>");
		out.println("    </form>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tema = request.getParameter("tema");
		
		Cookie cookie = new Cookie("tema", tema);
		cookie.setMaxAge(366*24*60*60);
		
		response.addCookie(cookie);
		
		doGet(request, response);
	}
	
	private String leerCookie(HttpServletRequest request, String nombre) {
		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			return null;
		}

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(nombre)) {
				return cookie.getValue();
			}
		}

		return null;
	}

}
