<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1 class="pb-3 border-bottom">${artista.nombre}</h1>

<p class="pb-3 border-bottom">${artista.informacion}</p>

<table class="table table-borderless table-hover table-dark">
	<caption>Álbumes</caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Foto</th>
			<th>Nombre</th>
			<th>Año</th>
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
			</tr>
		</c:forEach>
	</tbody>
</table>