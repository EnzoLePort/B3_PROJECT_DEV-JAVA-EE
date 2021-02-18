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
	
	<h2>Publication d'une idée</h2>
	
	<form method="POST" action="#">
	  <div class="mb-3">
	    <label class="form-label">Nom de l'idée</label>
	    <input type="text" name="title" class="form-control">
	  </div>
  	  <div class="mb-3">
	    <label class="form-label">Description</label>
	    <input type="text" name="description" class="form-control">
	  </div>
   	  <div class="mb-3">
	    <label class="form-label">Catégorie</label>
	    <input type="text" name="type" class="form-control">
	  </div>
   	  <div class="mb-3">
	    <label class="form-label">Image</label>
	    <input type="text" name="picture" class="form-control">
	  </div>
	  <button type="submit" class="btn btn-primary">Publier !</button>
	</form>

	<%@include file="common/footer.jsp"%>

</body>
</html>