<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback</title>
</head>
<body>
	<h3>
		<a href="DisplayCandidate">Back to Candidates</a>
	</h3>

	<table border='1'>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Specialties</th>
			<th>Presentation</th>
			<th>Rating</th>



		</tr>
		<tr>
			<td>${entry.getId()}</td>
			<td>${entry.getName()}</td>
			<td>${entry.getSpecialty()}</td>
			<td>${entry.getPresentation()}</td>
			<td>${entry.rating}</td>

		</tr>

	</table>

	<h3>Comments:</h3>

	<table border='1'>
		<c:forEach items="${feedback}" var="c">

			<tr>
				<td>Rating ${c.getRate()}</td>
				<td align="right">Posted by ${c.getName1()} on ${c.getDate()}</td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1">${c.getComment()}</td>
			</tr>

		</c:forEach>
	</table>

	<h3>Please give you feedback:</h3>

	<table border='1'>
		<form action='ViewFeedback?id=${entry.getId()}' method="post">

			<tr>
				<th>Rating</th>
				<td>1 <input type='radio' name='rate' value='1' required /><input
					type='radio' name='rate' value='2' required /><input type='radio'
					name='rate' value='3' required /><input type='radio' name='rate'
					value='4' required /><input type='radio' name='rate' value='5'
					required />5
				</td>
			</tr>

			<tr>
				<th>Name</th>
				<td><input type="text" name="name1" required /></td>
			</tr>

			<tr>
				<th>Comments</th>
				<td><input type="text" name="comment" required /></td>
			</tr>

			<tr>
				<td colspan="2" rowspan="1"><input type="submit" name="submit"
					value="submit" /></td>
			</tr>

		</form>
	</table>



</body>
</html>