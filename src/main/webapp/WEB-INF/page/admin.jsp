<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administration</title>
<%@include file="common/header.jsp"%>
</head>
<body>
	<%@include file="common/menu.jsp"%>
	
	<div class="container-fluid">
	  <div class="row" style="margin-top:30px;">
		  <div class="col-4">
		  </div>
		  <div class="col-4">
		  		<h2 align="center">Administration des candidatures</h2>
	  			<table class="table table-striped">
				  <th>Nom</th>
				  <th>Prénom</th>
				  <th>Email</th>
				  <th>Validé</th>
				  	<c:forEach items="${ listSubscribes }" var="subscribe">
						<tr>
							<td><c:out value="${ subscribe.name }"></c:out></td>
							<td><c:out value="${ subscribe.firstName }"></c:out></td>
							<td><c:out value="${ subscribe.mail }"></c:out></td>
							<td>
								<form method="POST">
									<input type="hidden" name="id" value="${ subscribe.id }" />
									<button type="submit" class="btn btn-success">Valider</button>
								</form>
							</td>
						</tr>
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