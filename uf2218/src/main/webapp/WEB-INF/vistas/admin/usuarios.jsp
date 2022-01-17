<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
	<table class="table table-striped table-hover table-bordered">
		<thead class="table-dark">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Contraseña</th>
				<th>Rol</th>
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
					<td>${usuario.rol.nombre}</td>
					<td>
						<a class="btn btn-primary" href="admin/usuario?id=${usuario.id}">Editar</a>
						<a class="btn btn-danger" href="admin/borrar?id=${usuario.id}">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<a class="btn btn-primary" href="admin/usuario">Añadir</a>
				</td>
			</tr>
		</tfoot>
	</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>