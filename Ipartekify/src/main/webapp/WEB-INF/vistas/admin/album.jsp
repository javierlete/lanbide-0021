<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/index" method="post" class="container mt-5">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" id="album-id" name="album-id" value="${album.id}" readonly>
		</div>
	</div>
	<div class="row mb-3">
		<label for="artista" class="col-sm-2 col-form-label">Id artista</label>
		<div class="col-sm-10">
			<select class="form-select" id="album-artista" name="album-artista">
				<c:forEach items="${artistas}" var="a">
					<option value="${a.id}" ${a.id == album.artista.id ? 'selected': ''}>${a.nombre}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="album-nombre" name="album-nombre" value="${album.nombre}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="anno" class="col-sm-2 col-form-label">Año</label>
		<div class="col-sm-10">
			<input type="number" min="1800" max="2100" class="form-control" id="album-anno" name="album-anno" value="${album.anno}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="foto" class="col-sm-2 col-form-label">Foto</label>
		<div class="col-sm-10">
			<input type="file" class="form-control" id="album-foto" name="album-foto" value="${album.foto}">
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>