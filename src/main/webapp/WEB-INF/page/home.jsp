<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>
<%@include file="common/header.jsp"%>
</head>
<body>
	<%@include file="common/menu.jsp"%>
	
	<div class="container-fluid">
	  <div class="row" style="margin-top:30px;">
		  <div class="col-4">
		  </div>
		  <div class="col-4">
		  		<h2 align="center">Veuillez vous authentifier...</h2>
		  		
				<p style="color:red"> <c:out value="${ error }"></c:out> </p>
				
				<form method="POST" action="j_security_check">
				  <div class="mb-3">
				    <label class="form-label"><i class="fas fa-user"></i> Email</label>
				    <input type="email" name="j_username" class="form-control">
				  </div>
				  <div class="mb-3">
				    <label class="form-label"><i class="fas fa-lock"></i> Mot de passe</label>
				    <input type="password" name="j_password" class="form-control">
				  </div>
				  <div align="center">
				  	<button type="submit" class="btn btn-primary btn-lg btn-block"><i class="fas fa-sign-in-alt"></i> Connexion</button>
				  </div>
				</form>
			
				<div align="center" style="margin-top:30px;">
					<p> Pas encore de compte ? </p>
					<a href="subscribe"><button class="btn btn-secondary">S'inscrire</button></a>
				</div>
			</div>
		  <div class="col-4">
		  </div>
		</div>
	</div>

	<%@include file="common/footer.jsp"%>

</body>
</html>