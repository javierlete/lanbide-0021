<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row h-100 bg-dark text-light">
	<div id="lateral-izquierdo"
		class="h-100 col-2 d-flex flex-column align-items-stretch pt-3 pb-5 mb-5">
		<nav id="menu" class="flex-shrink-1 pb-3 border-bottom">
			<ul class="nav flex-column">
				<c:forEach items="${artistas}" var="a">
					<li class="nav-item"><a class="nav-link link-light"
						href="?artista=${a.id}">${a.nombre}</a></li>
				</c:forEach>
			</ul>
		</nav>
		<nav id="listas" class="nav flex-grow-1 pt-3">
			<ul class="nav flex-column">
				<li class="nav-item"><a class="nav-link link-light" href="#">Lista1</a></li>
				<li class="nav-item"><a class="nav-link link-light" href="#">Lista1</a></li>
				<li class="nav-item"><a class="nav-link link-light" href="#">Lista1</a></li>
				<li class="nav-item"><a class="nav-link link-light" href="#">Lista1</a></li>
			</ul>
		</nav>
		<div id="caratula" class="flex-shrink-1">
			<div class="card bg-dark text-white">
				<img src="${album.foto}" class="card-img" alt="">
				<div class="card-img-overlay">
					<h5 class="card-title">${cancion.nombre}</h5>
					<p class="card-text">${cancion.tiempo}</p>
				</div>
			</div>
		</div>
	</div>
	<div id="central" class="h-100 col pt-3">
		<c:if test="${artista != null}">
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
							<td><img src="${a.foto}" alt=""></td>
							<td><a
								class="text-light stretched-link text-decoration-none"
								href="?album=${a.id}">${a.nombre}</a></td>
							<td>${a.anno}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${album != null}">
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
							<td><a
								class="text-light stretched-link text-decoration-none"
								href="?cancion=${c.id}">${c.nombre}</a></td>
							<td>${c.tiempo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	<div id="reproductor" class="col-12 fixed-bottom">
		<c:if test="${cancion.mp3 != null}">
			<iframe class="w-100" src="https://www.youtube-nocookie.com/embed/${cancion.mp3}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</c:if>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>