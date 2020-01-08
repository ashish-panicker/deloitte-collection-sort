<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Age: ${age}</h2>
	<c:if test="${age ge 18 }">
		<h3>You can vote.</h3>
	</c:if>
	<c:if test="${age le 18 }">
		<h3>You cannot vote.</h3>
	</c:if>
</body>
</html>