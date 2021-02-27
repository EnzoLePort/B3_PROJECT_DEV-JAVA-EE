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

	<h2>Liste des commentaires pour l'idée : {{idee}} !</h2>
	
	<table class="table table-striped">
	  <th>Nom</th>
	  <th>Par</th>
	  <th>Description</th>
	  <th>Date</th>
	  <th>Catégorie</th>
	  <th>Note</th>
	  	<c:forEach items="${ listRateIdea }" var="rateIdea">
			<tr>
				<td><c:out value="${ rateIdea.user.name }"></c:out></td>
				<td><c:out value="${ rateIdea.user.firstName }"></c:out></td>				
				<td><c:out value="${ rateIdea.comment }"></c:out></td>
				<td><c:out value="${ rateIdea.rate.name }"></c:out></td>


			</tr>
		</c:forEach>
	</table>
	
	
	<%@include file="common/footer.jsp"%>	

</body>
</html>