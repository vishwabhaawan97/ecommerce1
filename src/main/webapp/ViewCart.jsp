<%@page import="impl.CartDAOImpl"%>
<%@page import="DAO.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<c:import url="header.jsp"></c:import>


<%
	CartDAO cdao = new CartDAOImpl();


	request.setAttribute("list", cdao.getCart( request.getSession().getAttribute("username").toString() ));
%>

</head>
<body style="margin: auto; width: 80%;">

	<h1>View Cart</h1>	

	<a href="ConfirmAddresses.jsp" class="btn btn-primary" style="float: right;"> ConfirmAddresses </a>
	<br><br>

	<table class="table table-striped">

		<thead>

			<tr>
				
				<td>Product Name</td>
				<td>Product Image</td>
				<td>Product Price</td>
				<td>Quantity</td>
				<td>Delete</td>
				
			</tr>

		</thead>

		<tbody>

			<c:forEach items="${list}" var="x">

				<tr>
					<td>${x.getProduct().getName()}</td>
					<td><img src="${x.getProduct().getImageUrl()}" class="img img-thumbnail" style="max-width: 200px;"></td>
					<td>${x.getProduct().getPrice()}</td>
					<td>${x.getQuantity()}</td>
					
					
					
					 <td><a href="DeleteCartFromDB?id=${x.getId()}"
					     class ="btn btn-danger"> delete</a></td>
					    
				</tr>

			</c:forEach>


		</tbody>

	</table>

</body>
</html>