<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="card mb-3 text-white bg-dark">
	<div class="row g-0">
		<%-- Si es un album normal su id será mayor que 0 --%>
		<c:if test="${album.id > 0}">
			<div class="col-md-4">
				<img src="${album.foto}" class="img-fluid rounded-start" alt="">
			</div>
		</c:if>
		<div class="col-md-auto">
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
					
					<%-- Si el id es menor que cero significa que es una lista --%>	
					<c:if test="${album.id < 0}">
						<%-- Al pasar el album id en negativo, lo volvemos positivo --%>
						<a href="index?quitar-cancion=${c.id}&amp;para-lista=${-album.id}" class="elevado btn btn-sm btn-outline-danger"
						onclick="javascript:return confirm('¿Estás seguro de que quieres quitar ${c.nombre} de la lista ${album.nombre}?')">Quitar de lista</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>