<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Est�s registrado</title>
</head>
<body>
	<p>Enhorabuena, te has registrado <%= session.getAttribute("nombre") %>, comprueba en phpmyadmin tu id de sesi�n actual.</p>
	<a href="closeSession" id="close">
		<p>Cerrar sesi�n</p>
	</a>
</body>
</html>