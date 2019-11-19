<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action='Login' method='post'>


		<h3>Login</h3>

		<table class='table table-striped'>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username" value="username">
				</td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" value="password">
				</td>
			</tr>

			<tr>
				<td><input type="submit" name="Login" value="Login"></td>
			</tr>
		</table>
		<a href="Register.jsp"> Register </a>
	</form>
</body>
</html>

