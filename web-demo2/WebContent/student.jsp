<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL demos</title>
</head>
<body>

	<h1>Expression language demos</h1>
	
	${5 + 2}
	
	${5 lt 2}
	
	<c:set var="number1" value="10" />
	<c:set var="number2" value="5" />
	
	<h2>Comparisons</h2>
	<h3>${number1 } > ${number2 } = ${number1 gt number2 }</h3>
	<h3>${number1 } == ${number2 } = ${number1 eq number2 }</h3>
	<h3>${number1 } < ${number2 } = ${number1 lt number2 }</h3>
	
	<h2>Arithematic</h2>
	<h3>${number1 } + ${number2 } = ${number1 + number2 }</h3>
	<h3>${number1 } - ${number2 } = ${number1 - number2 }</h3>
	<h3>${number1 } / ${number2 } = ${number1 div number2 }</h3>
	<h3>${number1 } x ${number2 } = ${number1 * number2 }</h3>
	
	
	<c:set var="age" value="27" scope="session"></c:set>
	<a href="page2.jsp">Check Age</a>
	
	<h2>Students</h2>
	
	<c:forEach items="${students}" var="student">
		${student} <br>
		<%-- ${student.name } - ${student.email } - ${student.phone } - ${student.batch }<br> --%>
	</c:forEach>
	
	
	<c:set var="grade" value="E"></c:set>
	<h3>Grade: ${grade }</h3>
	<c:choose>
		<c:when test="${grade eq 'A' }">Excellent</c:when>
		<c:when test="${grade eq 'B' }">Good</c:when>
		<c:when test="${grade eq 'C' }">Average</c:when>
		<c:when test="${grade eq 'D' }">Poor</c:when>
		<c:otherwise>Fail</c:otherwise>
	</c:choose>
	
</body>
</html>