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
		<form action="create" method="post">
			Name: 
			<input type="text" name="name" required /><br>
			Email:<input type="text" name="email" required /><br>
			Phone:<input type="text" name="phone" required /><br>
			Batch:<select name="batch">
				<option value="Java">Java</option>
				<option value="Testing">Testing</option>
				<option value="Informatica">Informatica</option>
			</select>
			<button class = "btn btn-sm btn-dark"type="submit">Save</button>
		</form>
		
		<c:if test="${not empty students }">
			<h3>Student List</h3>
			<table class="table table-striped">
			<thead>
					<tr>
						<th>Name</th><th>Email</th><th>Phone</th><th>Batch</th><th></th>
					</tr>
				</thead>
				<c:forEach var="s" items="${students }">
					<tr>
						<td>${s.name}</td><td>${s.email}</td>
						<td>${e.phone}</td><td>${s.batch}</td>
						<td><a class="btn btn-sm btn-warning" href="edit?id=${s.email }">Edit</a> | 
						<a class="btn btn-sm btn-danger" href="delete?id=${s.email }">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>