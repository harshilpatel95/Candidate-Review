<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Candidate</title>

</head>
<body>
	<table border="1">
		<form action='EditCandidate' method='post'>
			<tr>
				<th>Id:</th>
				<td>${ entry.getId()}</td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input type="text" name="name" value="${ entry.getName()}" />
				</td>
			</tr>
			<tr>
				<th>Specialty:</th>
				<td><input type="text" name="specialty"
					value="${ entry.getSpecialty()}" /></td>
			</tr>
			<tr>
				<th>Presentation:</th>
				<td><input type="text" name="presentation"
					value="${ entry.getPresentation() }" /></td>
			</tr>
			<input type="hidden" name="id" value="${ id}" />
			<tr>
				<td colspan="2" rowspan="1"><input type='submit' name='save'
					value='Save' /></td>
			</tr>
		</form>
</body>
</html>