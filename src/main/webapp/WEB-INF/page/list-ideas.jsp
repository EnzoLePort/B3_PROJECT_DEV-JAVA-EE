<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des idées</title>
<%@include file="common/header.jsp"%>
</head>
<body>

	<%@include file="common/menu.jsp"%>

	<h2>Liste des idées !</h2>
	
	<table class="table table-striped">
	  <th>Nom</th>
	  <th>Par</th>
	  <th>Description</th>
	  <th>Date</th>
	  <th>Catégorie</th>
	  <th>Note</th>
	  <th>Voir les commentaires</th>
	  	<c:forEach items="${ listIdeas }" var="idea">
			<tr>
				<td><c:out value="${ idea.title }"></c:out></td>
				<td><c:out value="${ idea.user.mail }"></c:out></td>
				<td><c:out value="${ idea.description }"></c:out></td>
				<td><c:out value="${ idea.date }"></c:out></td>
				<td><c:out value="${ idea.type }"></c:out></td>
				<td>
					<a href="create-rateIdea?id=${ idea.id }&note=1"><button class="btn btn-success"><i class="fas fa-thumbs-up"></i></button></a>
					<a href="create-rateIdea?id=${ idea.id }&note=0"><button class="btn btn-danger"><i class="fas fa-thumbs-down"></i></button></a>
				</td>
				<td><a href="rates-idea?id=${ idea.id }"><i class="fas fa-eye"></i></a></td>
			</tr>
		</c:forEach>
	</table>
	
	
	<div align="center">
		<a href="leaderboard"><button class="btn btn-primary">Découvrir tous les classements !</button></a>
		<br /><br/>
		<a href="create-idea"> 
		 <button class="btn btn-success"><i class="fas fa-plus-circle"></i> Publier une idée !</button>
		</a>
	 </div>
	
	<%@include file="common/footer.jsp"%>

</body>
</html>