<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row h-100 bg-dark text-light">
	<div id="lateral-izquierdo" class="h-100 col-2 d-flex flex-column align-items-stretch pt-3 pb-5 mb-5">
		<nav id="menu" class="flex-shrink-1 pb-3 border-bottom">
			<ul class="nav flex-column">
				<li class="nav-item"><a class="nav-link link-light" href="#">Artista1</a></li>
				<li class="nav-item"><a class="nav-link link-light" href="#">Artista1</a></li>
				<li class="nav-item"><a class="nav-link link-light" href="#">Artista1</a></li>
				<li class="nav-item"><a class="nav-link link-light" href="#">Artista1</a></li>
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
			<img src="#" alt="Carátula">
		</div>
	</div>
	<div id="central" class="h-100 col pt-3">
		<h1 class="pb-3 border-bottom">Artista</h1>
		
		<p class="pb-3 border-bottom">
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ligula libero, cursus sit amet lorem sed, fringilla congue eros. Suspendisse lobortis risus ac sapien aliquet tempus. Nam volutpat vestibulum sapien. Donec tempor dignissim consectetur. Donec vestibulum sodales semper. Vivamus aliquam sagittis risus, id porta neque. Vivamus mi urna, consequat non pulvinar vel, aliquam sit amet arcu. Praesent sagittis quam sed metus consectetur, at facilisis ipsum pellentesque. In erat nulla, porta quis pretium non, ultrices ut nunc. Pellentesque finibus tellus in risus tincidunt egestas. Maecenas pellentesque metus id risus accumsan egestas.
		</p>
		
		<table class="table table-borderless table-hover text-light">
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
				<tr>
					<td>1</td>
					<td><img src="#" alt="Álbum1"></td>
					<td>Nombre1</td>
					<td>Año</td>
				</tr>
				<tr>
					<td>1</td>
					<td><img src="#" alt="Álbum1"></td>
					<td>Nombre1</td>
					<td>Año</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="reproductor" class="col-12 fixed-bottom">
		Reproductor
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>