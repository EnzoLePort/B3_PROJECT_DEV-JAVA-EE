<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% String email = (String) session.getAttribute("email");  %>
	<c:out value="${ email }"></c:out>

	<c:forEach items="${ listIdeas }" var="idea">
		-> <c:out value="${ idea.title }"></c:out>
	</c:forEach>

</body>
</html>