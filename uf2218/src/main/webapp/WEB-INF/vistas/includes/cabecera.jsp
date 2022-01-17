<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.contextPath}/" />
<title>UF2218</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-icons.css">
<link rel="stylesheet" href="css/dataTables.bootstrap5.min.css">

<link rel="shortcut icon" href="favicon.ico" type="image/png" />

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">UF2218</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="principal">Principal</a></li>
						<c:if test="${sessionScope.usuario.rol.nombre == 'ADMIN'}">
							<li class="nav-item"><a class="nav-link"
								href="admin/usuarios">Administración de usuarios</a></li>
						</c:if>
					</ul>
					<span class="navbar-text">
						${sessionScope.usuario.nombre}
					</span>
					<ul class="navbar-nav mb-2 mb-lg-0">
						<li class="nav-item"><c:if
								test="${sessionScope.usuario == null}">
								<a class="nav-link" href="login"> Iniciar sesión</a>
							</c:if> <c:if test="${sessionScope.usuario != null}">
								<a class="nav-link" href="logout">Desconectarse</a>
							</c:if></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<main class="container mt-5 pt-3">