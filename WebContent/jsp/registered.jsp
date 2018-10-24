<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Estás registrado</title>
</head>
<body>
	<p>Enhorabuena, te has registrado <%= session.getAttribute("nombre") %>, comprueba en phpmyadmin tu id de sesión actual.</p>
	<a href="closeSession" id="close">
		<p>Cerrar sesión</p>
	</a>
</body>
</html>