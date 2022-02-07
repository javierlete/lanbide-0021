<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="card mb-3 text-white bg-dark">
	<div class="row g-0">
		<div class="col-md-4">
			<img src="${album.foto}" class="img-fluid rounded-start" alt="">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h5 class="card-title">${album.nombre}</h5>
				<p class="card-text">${album.anno}</p>
				<p class="card-text">
					<small class="text-muted">${album.artista.nombre}</small>
				</p>
			</div>
		</div>
	</div>
</div>

<table class="table table-borderless table-hover table-dark">
	<caption>Canciones</caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Tiempo</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${album.canciones}" var="c">
			<tr class="position-relative">
				<td>${c.id}</td>
				<td><a class="text-light stretched-link text-decoration-none"
					href="index?cancion=${c.id}">${c.nombre}</a></td>
				<td>${c.tiempoFormateado}<a
					class="text-success text-decoration-none elevado"
					href="index?cancion=${c.id}&favorito"> <i
						class="bi bi-heart${c.favorito ? '-fill': ''}"></i>
				</a>
					<div class="dropdown d-inline">
						<button class="btn btn-dark dropdown-toggle elevado" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">...</button>
						<ul class="dropdown-menu bg-dark">
							<c:forEach items="${listas}" var="l">
								<li><a class="dropdown-item link-light" href="index?nueva-cancion=${c.id}&amp;para-lista=${l.id}">${l.nombre}</a></li>
							</c:forEach>
						</ul>
					</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>