<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Usuario</title>
</head>
<body>

<form action="usuario" method="post">
	<input readonly type="text" name="id" value="${usuario.id}" />
	<div>
		<label for="nombre">Nombre</label>
		<input type="text" id="nombre" name="nombre" value="${usuario.nombre}" />
	</div>
	<div>
		<label for="email">Email</label>
		<input type="email" id="email" name="email" value="${usuario.email}" />
	</div>
	<div>
		<label for="password">Contraseña</label>
		<input type="password" id="password" name="password" />
	</div>
	<div>
		<button>Aceptar</button>
	</div>
</form>

</body>
</html>