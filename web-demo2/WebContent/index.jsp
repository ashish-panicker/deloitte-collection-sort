<%@page import="web.demo.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index JSP</title>
</head>
<body>
	
	<%-- <form action="index.jsp" method="get">
		Number 1: <input type="number" min="1" name="num1" /><br>
		Number 2: <input type="number" min="1" name="num2" /><br>
		<button type="submit">Multiply</button>
	</form>
	
	<h2>Result</h2>
	<%
	
	if(request.getParameter("num1")!= null && request.getParameter("num2") != null){
		int num1 = Integer.parseInt(request.getParameter("num1").trim());
		int num2 = Integer.parseInt(request.getParameter("num2").trim());
		
		for(int i = 1; i <= num2; i++){
			out.write("<p>" + num2 + " x " + i + " = " + (num1 * i) + "</p>");
		}
	}
	
	
	%> --%>
	
	
	<form action="process" method="post">
		Name: <input type="text" name="name" required /><br>
		Email:<input type="text" name="email" required /><br>
		Phone:<input type="text" name="phone" required /><br>
		Batch:<select name="batch">
			<option value="Java">Java</option>
			<option value="Testing">Testing</option>
			<option values="Informatica">Informatica</option>
		</select>
		<button type="submit">Save</button>
	</form>
	
	<h2>Student List</h2>
	
	<table>
		<thead>
			<tr>
				<th>Name</th><th>Email</th><th>Phone</th><th>Batch</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${sessionScope.students }" var="s">
			<tr>
				<td>${s.name }</td> <td>${e.email }</td> 
				<td>${s.phone }</td> <td>${s.batch }</td>
			</tr>
		</c:forEach>
			<%-- <%
				List<Student> students = null;
				students =  (List<Student>) request.getSession().getAttribute("students");
				if(students != null){
					for(Student s : students){
						out.print("<tr>");
						out.print("<td>" + s.getName() + "</td>");
						out.print("<td>" + s.getEmail() + "</td>");
						out.print("<td>" + s.getPhone() + "</td>");
						out.print("<td>" + s.getBatch() + "</td>");
						out.print("</tr>");
					}
				}
				
			%> --%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4" style="text-align:center;"> Student details </td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>
