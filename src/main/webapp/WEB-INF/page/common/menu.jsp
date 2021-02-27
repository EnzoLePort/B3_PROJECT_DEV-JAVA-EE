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

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Menu</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
       	<% User user = (User) session.getAttribute("user"); %>
      	<c:if test="${user.mail != null}">
		    <a class="nav-link" href="home"><c:out value="${ user.mail }"></c:out></a>
		</c:if>
      	<c:if test="${user.mail == null}">
		    <a class="nav-link" href="home">Connexion</a>
		</c:if>
		<a class="nav-link" href="list-ideas">Section Idees</a>
      </div>
    </div>
  </div>
</nav>

</body>
</html>