<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang='es'>
<head>
    <meta charset='UTF-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    
    <base href="/uf2218/">
    
    <link rel='stylesheet' href='css/estilos.css'>
    <title>Cambiar tema</title>
</head>
<body class='${cookie.tema.value}'>
	<p>${cookie.tema.value}</p>
    <form action="tema" method='post'>
        <select name='tema'>
            <option value=''>Seleccione un tema</option>
            <option value='claro'>Claro</option>
            <option value='oscuro'>Oscuro</option>
        </select>
        <button>Aceptar</button>
    </form>
</body>
</html>
