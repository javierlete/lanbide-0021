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
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${artistas}" var="a">
			<tr  ${a.id == artista.id ? 'class="table-secondary"' : ''}>
				<th>${a.id}</th>
				<td>${a.nombre}</td>
				<td>${a.informacion}</td>
				<td><a class="btn btn-outline-primary"
					href="admin/index?id=${a.id}">Editar</a> <a
					class="btn btn-outline-danger"
					onclick="return confirm('¿Estás seguro de que quieres borrar ${a.nombre}?')"
					href="admin/index?borrar=${a.id}">Borrar</a> <a
					class="btn btn-outline-primary"
					href="admin/index?artista-seleccionado=${a.id}">Seleccionar</a></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td><a class="btn btn-outline-primary" href="admin/index?id=0">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<c:if test="${artista != null}">

	<h1 class="pb-3 border-bottom">${artista.nombre}</h1>

	<p class="pb-3 border-bottom">${artista.informacion}</p>

	<table
		class="table table-hovered table-dark table-bordered table-striped">
		<caption>Álbumes</caption>
		<thead>
			<tr>
				<th>Id</th>
				<th>Foto</th>
				<th>Nombre</th>
				<th>Año</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${albumes}" var="a">
				<tr class="position-relative">
					<td>${a.id}</td>
					<td><img class="img-thumbnail" width="100" src="${a.foto}"
						alt=""></td>
					<td><a class="text-light stretched-link text-decoration-none"
						href="index?album=${a.id}">${a.nombre}</a></td>
					<td>${a.anno}</td>
					<td><a class="btn btn-outline-primary"
						href="admin/index?album=${a.id}">Editar</a> <a
						class="btn btn-outline-danger"
						onclick="return confirm('¿Estás seguro de que quieres borrar ${a.nombre}?')"
						href="admin/index?borrar-album=${a.id}">Borrar</a> <a
						class="btn btn-outline-primary"
						href="admin/index?album-seleccionado=${a.id}">Seleccionar</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a class="btn btn-outline-primary"
					href="admin/index?album=0">Añadir</a></td>
			</tr>
		</tfoot>
	</table>

</c:if>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>