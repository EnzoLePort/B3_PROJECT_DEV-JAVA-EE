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
	
	<% String email = (String) session.getAttribute("email");  %>
	<c:out value="${ email }"></c:out>

	<div class="row">
		<form class="col s12" method="POST" action="#">

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
		    <i class="material-icons right">Connexion</i>
		  </button>

		
		</form>
	</div>

	<div align="center">
		<p> Pas encore de compte ? </p>
		<a href="subscribe">S'inscrire</a>
	</div>

	<%@include file="common/footer.jsp"%>

</body>
</html>