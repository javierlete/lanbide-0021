<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mantenimiento de usuarios</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Contraseña</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<th>${usuario.id}</th>
					<td>${usuario.nombre}</td>
					<td>${usuario.email}</td>
					<td>${usuario.password}</td>
					<td>
						<a href="usuario?id=${usuario.id}">Editar</a>
						<a href="borrar?id=${usuario.id}">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<a href="usuario">Añadir</a>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>