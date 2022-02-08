<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table
	class="table table-hovered table-dark table-bordered table-striped">
	<caption>Artistas</caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Información</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${artistas}" var="a">
			<tr>
				<th>${a.id}</th>
				<td>${a.nombre}</td>
				<td>${a.informacion}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>