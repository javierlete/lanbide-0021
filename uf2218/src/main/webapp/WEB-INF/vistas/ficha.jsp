<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2 class="lead">${seleccionado.nombre}</h2>

<div class="card mb-3">
	<div class="row g-0">
		<div class="col-md-4">
			<img src="https://placeimg.com/640/640/people"
				class="img-fluid rounded-start" alt="...">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h5 class="card-title">${seleccionado.nombre}</h5>
				<p class="card-text">${seleccionado.email}</p>
				<p class="card-text" style="white-space: break-spaces">Lorem ipsum dolor sit amet, consectetur adipiscing elit.

Maecenas tempus lacinia risus non convallis. </p>
				<p class="card-text"><small class="text-muted">${seleccionado.rol.nombre}:
					${seleccionado.rol.descripcion}</small></p>
				<a href="equipo?op=agregar&id=${seleccionado.id}" class="btn btn-primary">Añadir al equipo</a>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>