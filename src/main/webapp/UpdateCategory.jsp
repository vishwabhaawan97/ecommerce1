<%@page import="impl.CategoryDAOImpl"%>
<%@page import="DAO.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<c:import url="header.jsp"></c:import>

<%
	int id = Integer.parseInt( request.getParameter("id") );

	CategoryDAO cdao = new CategoryDAOImpl();
	
	request.setAttribute("cat", cdao.getCategory(id));
%>

</head>
<body style="margin: auto; width: 80%;">

<h1>Update Category</h1>

<form action="UpdateCategoryFromDB" method="post">

	<input type="hidden" name="Id" value="${cat.getId()}">	

	<input type="text" name="name" placeholder ="Enter Category Name" class="form-control" 
	<c:if test="${not empty cat}"> value="${cat.getName()}" </c:if> />

	<br>
	
	<textarea name="description" placeholder="Enter Category Description" class="form-control">
	<c:if test="${not empty cat}">${cat.getDescription()}</c:if></textarea>

	<br>
	
	<input type="submit" value="Submit" class="btn btn-success">

</form>


</body>
</html>