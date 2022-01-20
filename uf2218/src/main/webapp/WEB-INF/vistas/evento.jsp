<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>${evento.nombre}</h2>

<h3>${evento.fecha}</h3>

<p class="lead">${evento.responsable.nombre}</p>

<table class="table table-striped table-hover table-bordered">
		<thead class="table-dark">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Contraseña</th>
				<th>Rol</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${evento.participantes}" var="usuario">
				<tr>
					<th>${usuario.id}</th>
					<td>${usuario.nombre}</td>
					<td>${usuario.email}</td>
					<td>${usuario.password}</td>
					<td>${usuario.rol.nombre}</td>
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
			</tr>
		</tfoot>
	</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>