<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.uf2218.modelos.Usuario"%>
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
			</tr>
		</thead>
		<tbody>
			<%
			for (Usuario usuario : (Iterable<Usuario>) request.getAttribute("usuarios")) {
			%>
			<tr>
				<th><%=usuario.getId()%></th>
				<td><%=usuario.getNombre()%></td>
				<td><%=usuario.getEmail()%></td>
				<td><%=usuario.getPassword()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>