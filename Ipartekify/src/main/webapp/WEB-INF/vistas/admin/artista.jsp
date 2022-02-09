<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/index" method="post" class="container mt-5">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" id="id" name="id" value="${artista.id}" readonly>
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre" name="nombre" value="${artista.nombre}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="informacion" class="col-sm-2 col-form-label">Información</label>
		<div class="col-sm-10">
			<textarea rows="10" class="form-control" id="informacion" name="informacion">${artista.informacion}</textarea>
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/admin/includes/albumes.jsp" %>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>