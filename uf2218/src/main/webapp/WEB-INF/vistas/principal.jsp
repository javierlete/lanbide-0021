<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.contextPath}/"/>
<title>Principal</title>
</head>
<body>

	<h1>Principal</h1>
	
	<h2>Bienvenido ${usuario.nombre}</h2>
	
	<p>
		<c:if test="${usuario.id == 1}">
			<a href="admin/usuarios">Administración de usuarios</a>
		</c:if>
		<a href="logout">Desconectarse</a>
	</p>
</body>
</html>