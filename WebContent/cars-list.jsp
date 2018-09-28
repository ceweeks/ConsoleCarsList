<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cars List</title>
</head>
<body>
<form method = "post" action = "editCarsListServlet">
<table>
<c:forEach items="${requestScope.allCars}" var = "currentcar">
<tr>
	<td><input type = "radio" name = "id" value = "${currentcar.id}"></td>
	<td>${currentcar.make}</td>
	<td>${currentcar.model}</td>
	<td>${currentcar.year}</td>
</tr>
</c:forEach>
</table> <br />
<input type = "submit" value = "Edit Selected Car" name = "doThisToCar"> <br />
<input type = "submit" value = "Delete Selected Car" name = "doThisToCar"> <br />
<input type = "submit" value = "Add New Car" name = "doThisToCar"> <br />
</form>
</body>
</html>