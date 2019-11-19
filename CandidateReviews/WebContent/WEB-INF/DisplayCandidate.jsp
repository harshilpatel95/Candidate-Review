<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Candidate</title>
</head>
<body>
	<c:if test="${user==null && admin==null}">

		<h3>
			<a href="./Login">Login</a>
		</h3>
	</c:if>


	<c:if test="${user != null || admin != null }">
		<h3>
			<a href="./Logout">Logout</a>
		</h3>
	</c:if>

	<table border='1'>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Specialties</th>
			<th>Presentation</th>
			<th>Rating</th>
			<th>Operation</th>
			<c:forEach items="${entry}" var="c">
		</tr>

		<tr>
			<td>${c.getId()}</td>
			<td><a href='ViewFeedback?id=${c.getId()}'>${c.getName()}</a></td>
			<td>${c.getSpecialty()}</td>
			<td>${c.getPresentation()}</td>
			<td>${c.getRating()}</td>
			<td><a href='EditCandidate?id=${c.getId()}'>Edit</a></td>
		</tr>
		</c:forEach>
	</table>
	<p>
		<a href='./AddCandidate'>Add Candidate</a>
	</p>

</body>
</html>