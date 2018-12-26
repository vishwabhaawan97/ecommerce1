<%@page import="impl.CategoryDAOImpl"%>
<%@page import="DAO.CategoryDAO"%>
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
	CategoryDAO cdao = new CategoryDAOImpl();


	request.setAttribute("list", cdao.getCategory());
%>

</head>
<body style="margin: auto; width: 80%;">

	<h1>View Categories:</h1>

	<table class="table table-striped">

		<thead>

			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Description</td>
				
				
				<c:if
					test="${not empty sessionScope.username and sessionScope.usernameRole=='ROLE_ADMIN'}">
					<td>Update</td>
					<td>Delete</td>
				</c:if>
				
				
			</tr>

		</thead>

		<tbody>

			<c:forEach items="${list}" var="x">

				<tr>
					<td>${x.getId()}</td>
					<td>${x.getName()}</td>
					<td>${x.getDescription()}</td>
						
						
						<c:if
						test="${not empty sessionScope.username and sessionScope.usernameRole=='ROLE_ADMIN'}">
					
					
					
					<td><a href="UpdateCategory.jsp?id=${x.getId()}"
					     class ="btn btn-success"> update</a></td>
					 <td><a href="DeleteCategoryFromDB?id=${x.getId()}"
					     class ="btn btn-danger"> delete</a></td>
					     
					     </c:if>
					    
				</tr>

			</c:forEach>


		</tbody>

	</table>

</body>
</html>