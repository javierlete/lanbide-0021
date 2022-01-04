<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/usuario" method="post">
	<input type="hidden" name="id" value="${requestScope.usuario.id}" />
	<div class="row mb-3">
		<label class="col-sm-2 col-form-label text-sm-end" for="nombre">Nombre</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" id="nombre" name="nombre"
				value="${requestScope.usuario.nombre}" />
		</div>
	</div>
	<div class="row mb-3">
		<label class="col-sm-2 col-form-label text-sm-end" for="email">Email</label>
		<div class="col-sm-10">
			<input class="form-control" type="email" id="email" name="email"
				value="${requestScope.usuario.email}" />
		</div>
	</div>
	<div class="row mb-3">
		<label class="col-sm-2 col-form-label text-sm-end" for="password">Contraseña</label>
		<div class="col-sm-10">
			<input class="form-control" type="password" id="password"
				name="password" />
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button class="btn btn-primary">Aceptar</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>