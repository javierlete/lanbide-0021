<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1 class="display-1">Principal</h1>

<h2 class="lead">Bienvenido ${usuario.nombre}</h2>

<div class="d-flex">
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item ${pagina - 1 < 1 ? 'disabled': ''}"><a
				class="page-link"
				href="?pagina=${pagina-1}&buscar=${buscar}&orden=${orden}">Anterior</a></li>
			<li class="page-item active"><a class="page-link"
				href="?pagina=${pagina}&buscar=${buscar}&orden=${orden}">${pagina}</a></li>
			<li class="page-item ${empty usuarios ? 'disabled': ''}"><a
				class="page-link"
				href="?pagina=${pagina+1}&buscar=${buscar}&orden=${orden}">Siguiente</a></li>
		</ul>
	</nav>
	<ul class="nav nav-pills ms-3">
		<li class="nav-item"><a class="nav-link ${orden == 'nombre' ? 'active': ''}" href="?pagina=1&buscar=${buscar}&orden=nombre">Nombre</a></li>
		<li class="nav-item"><a class="nav-link ${orden == 'rol' ? 'active': ''}" href="?pagina=1&buscar=${buscar}&orden=rol">Rol</a></li>
	</ul>
</div>
<div
	class="row row-cols-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 g-4">
	<c:forEach items="${usuarios}" var="u">
		<div class="col">
			<div class="card h-100">
				<img src="https://placeimg.com/320/320/people?${u.id}"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${u.nombre}</h5>
					<p class="card-text">${u.email}</p>
					<a href="ficha?id=${u.id}" class="btn btn-primary stretched-link">Ver
						en detalle</a>
				</div>
				<div class="card-footer">
					<small class="text-muted">${u.rol.nombre}:
						${u.rol.descripcion}</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>