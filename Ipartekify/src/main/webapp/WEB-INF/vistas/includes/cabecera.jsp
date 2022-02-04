<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.contextPath}/" />
<title>Ipartekify</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-icons.css">
<link rel="stylesheet" href="css/dataTables.bootstrap5.min.css">
<link rel="stylesheet" href="css/ipartekify.css">

<link rel="shortcut icon" href="favicon.ico" type="image/png" />

</head>
<body class="h-100 bg-dark text-light pt-5">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Ipartekify</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<span class="ms-auto navbar-text">${sessionScope.usuario.email}</span>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<li class="nav-item"><c:choose>
							<c:when test="${sessionScope.usuario != null}">
								<a class="nav-link" href="logout">Logout</a>
							</c:when>
							<c:otherwise>
								<a class="nav-link" href="login">Login</a>
							</c:otherwise>
						</c:choose></li>
				</ul>
			</div>
		</div>
	</nav>
	<main class="container-fluid h-100">