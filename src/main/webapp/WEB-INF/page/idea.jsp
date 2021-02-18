<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="common/header.jsp"%>
</head>
<body>

	<%@include file="common/menu.jsp"%>

	<h2>Liste des idées !</h2>
	
	<table class="table table-striped">
	  <th>Nom</th>
	  <th>Description</th>
	  <th>Date</th>
	  <th>Catégorie</th>
	  <th>Note</th>
	  	<c:forEach items="${ listIdeas }" var="idea">
			<tr>
				<td><c:out value="${ idea.title }"></c:out></td>
				<td><c:out value="${ idea.description }"></c:out></td>
				<td><c:out value="${ idea.date }"></c:out></td>
				<td><c:out value="${ idea.type }"></c:out></td>
				<td>
					<button class="btn btn-success"><i class="fas fa-thumbs-up"></i></button>
					<button class="btn btn-danger"><i class="fas fa-thumbs-down"></i></button>
				</td>
			</tr>
		</c:forEach>
	</table>


	  
	
	  <a href="create-idea"> 
		  <button class="btn btn-success"><i class="fas fa-plus-circle"></i> Publier une idée !</button>
	  </a>
	
	<%@include file="common/footer.jsp"%>

</body>
</html>