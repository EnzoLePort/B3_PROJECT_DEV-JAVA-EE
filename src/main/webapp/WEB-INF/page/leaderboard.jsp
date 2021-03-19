<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classements</title>
<%@include file="common/header.jsp"%>
</head>
<body>
	<%@include file="common/menu.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-4">
			</div>
			<div class="col-4">
				<br/><br/><br/>
				<h2>Top 3 idées les mieux notées !</h2>
				<table class="table table-dark">
				  <th>Titre</th>
	  				<c:forEach items="${ listIdeasTopRating }" var="idea">
						<tr><td><b><c:out value="${ idea.title }"></c:out></b><br /><br /></td></tr>
					</c:forEach>
				</table>
				<br/><br/><br/>
				<h2>Top 3 utilisateurs qui ont postés le plus d'idées !</h2>
				<table class="table table-dark">
				  <th>Prénom</th>
	  				<c:forEach items="${ listUsersBestRating }" var="user">
						<tr><td><b><c:out value="${ user.firstName }"></c:out></b><br /><br /></td></tr>
					</c:forEach>
				</table>
				<br/><br/><br/>
				<h2>Top 3 idées qui ont générée le plus de votes !</h2>
				<table class="table table-dark">
				  <th>Titre</th>
	  				<c:forEach items="${ listIdeasBestRating }" var="idea">
						<tr><td><b><c:out value="${ idea.title }"></c:out></b><br /><br /></td></tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-4">
			</div>
		</div>
	</div>

	<%@include file="common/footer.jsp"%>

</body>
</html>