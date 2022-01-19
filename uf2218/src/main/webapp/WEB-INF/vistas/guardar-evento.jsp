<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="guardar-evento" method="post">
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre" name="nombre">
		</div>
	</div>
	<div class="row mb-3">
		<label for="fecha" class="col-sm-2 col-form-label">Fecha</label>
		<div class="col-sm-10">
			<input type="datetime-local" class="form-control" id="fecha" name="fecha">
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col-sm-10 offset-sm-2">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
	</div>
	
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>