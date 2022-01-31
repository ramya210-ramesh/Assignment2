<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="navbar.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Form</title>
</head>
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
	<form action="./delete" method="post">
		<label>Enter the id:</label> <input type="number" name="id">
		<button input type="delete" name="delete">Delete</button>
	</form>
</body>
</html>