<%@page import="com.te.SpringAssement.bean.ProductDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="navbar.jsp"%>
<%
List<ProductDetails> list = (List<ProductDetails>) request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Product data</title>
<style type="text/css">
table, td, th, tr {
	border: 2px solid rgba(0, 0, 0, 0.5);
	border-collapse: collapse;
}
</style>
</head>
<body>
		<h1>Products Details</h1>
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Price</th>
				<th>Password</th>

			</tr>
			<%
			for (ProductDetails details : list) {
			%>
			<tr>
				<td><%=details.getId()%></td>
				<td><%=details.getName()%></td>
				<td><%=details.getBrand()%></td>
				<td><%=details.getPrice() %></td>
				<td><%=details.getPassword()%></td>
			</tr>
			<%
			}
			%>
		</table>
</body>
</html>