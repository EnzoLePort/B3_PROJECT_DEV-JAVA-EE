<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<%@include file="common/header.jsp"%>
</head>
<body>
	<%@include file="common/menu.jsp"%>
	
	
	<div class="container-fluid">
	  <div class="row" style="margin-top:30px;">
		  <div class="col-4">
		  </div>
		  <div class="col-4">
		  		<h2 align="center">Inscription</h2>
		  		
				<p style="color:green"> <c:out value="${ success }"></c:out> </p>
				
				<form method="POST" action="">
				  <div class="mb-3">
				    <label class="form-label"><i class="fas fa-user"></i> Prénom</label>
				    <input type="text" name="firstname" class="form-control">
				  </div>
  				  <div class="mb-3">
				    <label class="form-label"><i class="fas fa-user"></i> Nom</label>
				    <input type="text" name="lastname" class="form-control">
				  </div>
				  <div class="mb-3">
				    <label class="form-label"><i class="fas fa-user"></i> Email</label>
				    <input type="email" name="email" class="form-control">
				  </div>
				  <div class="mb-3">
				    <label class="form-label"><i class="fas fa-lock"></i> Mot de passe</label>
				    <input type="password" name="password" class="form-control">
				  </div>
				  <div align="center">
		  			  <button class="btn btn-primary" type="submit">
					    <i class="fas fa-sign-in-alt"></i> Inscription
					  </button>
				  </div>
				</form>
			
				<div align="center">
					<p> Déjà un compte ? </p>
					<a href ="home">Se connecter</a>
				</div>
			</div>
		  <div class="col-4">
		  </div>
		</div>
	</div>

	<%@include file="common/footer.jsp"%>

</body>
</html>