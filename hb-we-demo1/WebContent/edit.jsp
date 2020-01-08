<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Students</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<p class="display-4">Student CRUD</p>
		<form action="edit" method="post">
			Name: 
			<input type="text" name="name" required value="${s.name }"/><br>
			Email:<input type="text" name="email" required  value="${s.email }" readonly/><br>
			Phone:<input type="text" name="phone" required  value="${s.phone }"/><br>
			Batch:<select name="batch">
				<option value="Java">Java</option>
				<option value="Testing">Testing</option>
				<option value="Informatica">Informatica</option>
			</select>
			<button class = "btn btn-sm btn-primary"type="submit">Edit</button>
		</form>
		
		
	</div>
</body>
</html>