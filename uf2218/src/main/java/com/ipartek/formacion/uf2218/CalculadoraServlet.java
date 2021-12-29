package com.ipartek.formacion.uf2218;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		String op = request.getParameter("op");

		if (op1 == null || op2 == null || op == null) {
			out.println("No se han recibido los datos a operar");
			return;
		}

		double n1 = Double.parseDouble(op1);
		double n2 = Double.parseDouble(op2);
		double res;

		switch (op) {
		case "+":
			res = n1 + n2;
			break;
		case "-":
			res = n1 - n2;
			break;
		case "x":
			res = n1 * n2;
			break;
		case "/":
			res = n1 / n2;
			break;
		default:
			out.println("No se dispone de esa operación");
			return;
		}

		out.println(res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
