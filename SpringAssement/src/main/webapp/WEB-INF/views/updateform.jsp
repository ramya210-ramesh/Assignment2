<%@page import="com.te.SpringAssement.bean.ProductDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="navbar.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
%>
<%
ProductDetails details = (ProductDetails) request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE FORM</title>
</head>
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
	<h1>Update the Data....</h1>
	<fieldset>

		<form action="./update" method="post">
			<table>
				<tr>
					<td><label>Enter your id:</label></td>
					<td><input type="number" name="id" value="<%=details.getId()%>" disabled="disabled"></td>
				</tr>

				<tr>
					<td><label>Enter your Name:</label></td>
					<td><input type="text" name="name" value="<%=details.getName()%>"></td>
				</tr>

				<tr>
					<td><label>Enter your Brand:</label></td>
					<td><input type="text" name="address" value="<%=details.getBrand()%>"></td>
				</tr>
				
				<tr>
					<td><label>Enter your Password:</label></td>
					<td><input type="password" name="password" value="<%=details.getPassword()%>"></td>
				</tr>

			</table>
			<input type="Submit" value="Update">
		</form>

	</fieldset>

</body>
</html>