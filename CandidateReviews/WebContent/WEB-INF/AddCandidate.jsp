<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Candidates</title>

</head>
<body>
	<table border="1">
		<form action='AddCandidate' method='post'>
			<tr>
				<th>Name:</th>
				<td><input type='text' name='name' /></td>
			</tr>
			<tr>
				<th>Specialty:</th>
				<td><input type='text' name='specialty' /></td>
			</tr>
			<tr>
				<th>Presentation:</th>
				<td><input type='text' name='presentation' /></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1"><input type='submit' name='add'
					value='Add' /></td>
			</tr>
		</form>
</body>
</html>