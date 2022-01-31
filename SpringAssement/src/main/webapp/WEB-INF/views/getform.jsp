<%@page import="com.te.SpringAssement.bean.ProductDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="navbar.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
ProductDetails details = (ProductDetails) request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Product</title>
</head>
<br>
<br>
<br>
<body>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: green;">
		<%=msg%>
	</h1>
	<%
	}
	%>
	<%
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red;">
		<%=errMsg%>
	</h1>
	<%
	}
	%>
	<form action="./getdata" method="post">
		<label>Enter the id:</label> <input type="number" name="id">
		<input type="Submit" value="search">
	</form>
	<%
	if (details != null) {
	%>
	<h1>
		Your Id is:<%=details.getId()%></h1>
	<h1>
		Your Name is:<%=details.getName()%></h1>
	<h1>
		Your Brand is:<%=details.getBrand()%></h1>
		<h1>
		Your Price is:<%=details.getPrice()%></h1>
	<h1>
		Your id password:<%=details.getPassword()%></h1>


	<%
	}
	%>
</body>
</html>