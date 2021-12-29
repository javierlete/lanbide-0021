package com.ipartek.formacion.uf2218;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leer-cookies")
public class LeerCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String tema = leerCookie(request, "tema");

		if (tema == null) {
			tema = "claro";
		}

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='css/estilos.css' />");
		out.println("</head>");
		out.print("<body class='");
		out.print(tema);
		out.print("'>");
		out.println("<h1>Tema " + tema + "</h1>");
		out.println("</body>");
		out.println("</html>");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
