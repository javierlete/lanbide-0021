<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

	<form action="login" method="post">
		<input type="email" name="email" placeholder="Email" value="${usuario.email}" />
		<input type="password" name="password" placeholder="Contraseña" />
		<button>Iniciar sesión</button>
	</form>
	
	<div>${error}</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>