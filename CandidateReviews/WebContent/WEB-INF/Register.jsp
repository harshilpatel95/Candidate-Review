<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css' />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegisterResident</title>
</head>
<body>
	<form action='RegisterResident' method='post'>
		<table>
			<table border='1'>
				<table class='table table-striped'>
					<tr>
						<th colspan='2'><h3>
								<p align='left'>Sign Up
							</h3></th>
						</p>
					</tr>
					<tr>
						<td>Username:</td>
						<td><input type='text' name='username' required='required'>
						</td>
					</tr>
					<tr>
						<td>Email ID:</td>
						<td><input type='email' name='emailid' required='required'>
						</td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name='password'
							required='required'></td>
					</tr>
					<tr>
						<td>Occupation:</td>
						<td><input type='radio' name='occupation' value='Student'
							required='required'> Student <br> <input
							type='radio' name='occupation' value='family' required='required'>
							Family <br> <input type='radio' name='occupation'
							value='business' required='required'> Business</td>
					</tr>
					<tr>
						<td>
							<p align='left'>
								<input type='Submit' value='Submit' name='submit'
									class='btn btn-primary'>
							</p>
						</td>
					</tr>
				</table>
			</table>
		</table>
	</form>
</body>
</html>