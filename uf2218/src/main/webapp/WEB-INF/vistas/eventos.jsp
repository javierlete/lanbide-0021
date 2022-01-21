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
			<th>Responsable</th>
			<th>Rol</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${eventos}" var="e">
			<tr>
				<th>${e.id}</th>
				<td>${e.nombre}</td>
				<td>${e.fechaFormatoCompleto}</td>
				<td>${e.responsable.nombre}</td>
				<td>${e.responsable.rol.nombre}</td>
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