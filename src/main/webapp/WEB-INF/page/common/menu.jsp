<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.epsi.entite.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

<% User user = (User) session.getAttribute("user"); %>


  <div class="container-fluid" style="background: linear-gradient(135deg, #FF13F4, #E65B06); height:100px;">
	  <div class="row">
		  <div class="col-9" style="margin-top:18px;">
 		   	<span style="font-size:40px; color:yellow;"><i class="fas fa-lightbulb"></i></span>&nbsp&nbsp&nbsp&nbsp
		    <a class="navbar-brand text-white" href="#">Topaidi - La création sans limite !</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>

	      	<c:if test="${user.mail != null}">
			    <a href="list-ideas"><button type="button" class="btn btn-light">Section Idees</button></a>
			</c:if>
			&nbsp&nbsp&nbsp&nbsp
	      	<c:if test="${user.rank == 1}">
			    <a href="admin"><button type="button" class="btn btn-light">Administration des candidatures</button></a>
			</c:if>

		  </div>
		  <div class="col-3" style="margin-top:25px; color:white;">
 		  	<c:if test="${user.mail != null}">
		  		<c:out value="${ user.mail }"></c:out><a class="nav-link" href="home?disconnect=true"><button class="btn btn-primary">Se déconnecter</button></a>
		  	</c:if>
		  	<c:if test="${user.mail == null}">
		  		<button type="button" class="btn btn-primary btn-sm"><a class="nav-link text-white" href="home">Connexion</a></button>
		  	</c:if>
		  </div>
	  </div>
  </div>

</body>
</html>