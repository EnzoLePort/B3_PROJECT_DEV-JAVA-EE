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
	
	<p style="color:red"> <c:out value="${ error }"></c:out> </p>
	
	<form method="POST" action="#">
	  <div class="mb-3">
	    <label class="form-label">Email</label>
	    <input type="email" name="email" class="form-control">
	  </div>
	  <div class="mb-3">
	    <label class="form-label">Mot de passe</label>
	    <input type="password" name="password" class="form-control">
	  </div>
	  <button type="submit" class="btn btn-primary">Connexion</button>
	</form>

	<div align="center">
		<p> Pas encore de compte ? </p>
		<a href="subscribe">S'inscrire</a>
	</div>

	<%@include file="common/footer.jsp"%>

</body>
</html>