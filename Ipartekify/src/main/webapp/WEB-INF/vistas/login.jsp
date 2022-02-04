<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form class="container" action="login" method="post">
	<fieldset>
		<legend>Login</legend>
		<div class="row mb-3">
			<label for="email" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="email" name="email">
			</div>
		</div>
		<div class="row mb-3">
			<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password"
					name="password">
			</div>
		</div>

		<div class="text-danger">${error}</div>

		<button type="submit" class="btn btn-primary">Login</button>
	</fieldset>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>