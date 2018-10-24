<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prueba de registro</title>
</head>
<body>
	<form action="logIn" method="post">
		<h1>Regístrate</h1>
		<input type="text" name="nombre" placeholder="Nombre de usuario"/>
		<input type="password" name="password"/>
		<input type="submit" value="Registrarse"/>
	</form>
	<form action="signIn" method="post">
		<h1>Iniciar sesión</h1>
		<input type="text" name="nombre" placeholder="Nombre de usuario"/>
		<input type="password" name="password"/>
		<input type="submit" value="Iniciar sesión"/>
	</form>
</body>
</html>