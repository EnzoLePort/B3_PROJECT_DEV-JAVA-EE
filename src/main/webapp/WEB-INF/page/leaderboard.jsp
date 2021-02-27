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
				<h2>Top 3 id�es les mieux not�es !</h2>
			</div>
			<div class="col-4">
				<h2>Top 3 utilisateurs qui ont post�s le plus d'id�es !</h2>
			</div>
			<div class="col-4">
				<h2>Top 3 id�es qui ont g�n�r�e le plus de votes !</h2>
			</div>
		</div>
	</div>

	<%@include file="common/footer.jsp"%>

</body>
</html>