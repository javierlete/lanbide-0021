<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<td>${a.nombre}</td>
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
				href="admin/index?album=0&artista-seleccionado=${artista.id}">Añadir</a></td>
		</tr>
	</tfoot>
</table>
