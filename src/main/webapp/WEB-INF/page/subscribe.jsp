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
	
	<div class="row">
		<form class="col-12">
		
			<div class="row">
				<div class="input-field col s12">
					<input name="firstname" type="text" class="validate"> <label
						for="firstname">Prénom</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s12">
					<input name="lastname" type="text" class="validate"> <label
						for="lastname">Nom</label>
				</div>
			</div>

			<div class="row">
				<div class="input-field col s12">
					<input name="email" type="email" class="validate"> <label
						for="email">Email</label>
				</div>
			</div>

			<div class="row">
				<div class="input-field col s12">
					<input name="password" type="password" class="validate"> <label
						for="email">password</label>
				</div>
			</div>


		  <button class="btn waves-effect waves-light" type="submit" name="action">
		    <i class="material-icons right">Inscription</i>
		  </button>

		
		</form>
	</div>

	<div align="center">
		<p> Déjà un compte ? </p>
		<a href ="home">Se connecter</a>
	</div>
	
	<%@include file="common/footer.jsp"%>

</body>
</html>