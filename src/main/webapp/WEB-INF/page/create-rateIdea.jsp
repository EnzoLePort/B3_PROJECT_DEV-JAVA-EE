<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Noter une idée</title>
<%@include file="common/header.jsp"%>
</head>
<body>
	<%@include file="common/menu.jsp"%>
	
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h2>Postez un commentaire pour cette idée !</h2>
			</div>
			<div class="col-3">
				<c:if test="${note == 0}">
					<span style="font-size: 3em; color: red;">
						<i class="fas fa-thumbs-down"></i>
					</span>
				</c:if>
				<c:if test="${note == 1}">
					<span style="font-size: 3em; color: green;">
						<i class="fas fa-thumbs-up"></i>
					</span>
				</c:if>
			</div>
			<div class="col-9">
				<!-- Redirection vers la page de la liste des commentaires et notes de l'idée -->
				<form method="POST" action="">
					<input type="hidden" name="idIdea" value="${ id }"/>
					<input type="hidden" name="note" value="${ note }"/>
				  <div class="mb-3">
				    <label class="form-label">Commentaire</label>
				    <textarea name="comment" class="form-control"></textarea>
				  </div>
				  <button type="submit" class="btn btn-success">Publier !</button>
				</form>
			</div>
		</div>
	</div>
	
	
	



	<%@include file="common/footer.jsp"%>

</body>
</html>