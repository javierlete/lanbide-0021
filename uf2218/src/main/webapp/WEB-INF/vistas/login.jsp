<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar sesión</title>
</head>
<body>

	<form action="login" method="post">
		<input type="email" name="email" placeholder="Email" value="${usuario.email}" />
		<input type="password" name="password" placeholder="Contraseña" />
		<button>Iniciar sesión</button>
	</form>
	
	<div>${error}</div>

</body>
</html>