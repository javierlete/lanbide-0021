<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form action="admin/usuario" method="post">
	<input type="hidden" name="id" value="${requestScope.usuario.id}" />
	<div>
		<label for="nombre">Nombre</label>
		<input type="text" id="nombre" name="nombre" value="${requestScope.usuario.nombre}" />
	</div>
	<div>
		<label for="email">Email</label>
		<input type="email" id="email" name="email" value="${requestScope.usuario.email}" />
	</div>
	<div>
		<label for="password">Contraseña</label>
		<input type="password" id="password" name="password" />
	</div>
	<div>
		<button>Aceptar</button>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>