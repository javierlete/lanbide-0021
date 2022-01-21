<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Listado de Eventos</h2>

<table class="table table-striped table-hover table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Fecha</th>
			<c:if test="${usuario.rol.nombre == 'ADMIN'}">
				<th>Responsable</th>
				<th>Rol</th>
			</c:if>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${eventos}" var="e">
			<tr>
				<th>${e.id}</th>
				<td>${e.nombre}</td>
				<td>${e.fechaFormatoCompleto}</td>
				<c:if test="${usuario.rol.nombre == 'ADMIN'}">
					<td>${e.responsable.nombre}</td>
					<td>${e.responsable.rol.nombre}</td>
				</c:if>
				<td>
					<a class="btn btn-primary" href="evento?id=${e.id}">Detalles</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>