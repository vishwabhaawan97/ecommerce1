<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



</head>
<body>

	<c:import url="header.jsp"></c:import>
	<h1>Add Category</h1>

	<form action="AddCategorytoDB" method="post">

		<input type="text" name="name" placeholder="Enter Category Name"
			class="form-control"> <br>

		<textarea name="desc" placeholder="Enter Category Description"
			class="form-control"></textarea>

		<br> <input type="submit" value="Submit" class="btn btn-success">

	</form>

</body>
</html>