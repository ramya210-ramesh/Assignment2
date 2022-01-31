<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="navbar.jsp"%>
<%
String string = (String) request.getAttribute("msg");
String string2 = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add the details</title>
</head>
<br>
<br>
<body>
	<%if(string!=null && !string.isEmpty()){
	%>
	<h1 style="color: green">
		<%=string %>
	</h1>
	<% }%>
	
	<%if(string2!=null && !string2.isEmpty()){
	%>
	<h1 style="color: red">
		<%=string2 %>
	</h1>
	<% }%>

	<fieldset>
		<legend>Product Details</legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td><label>Enter Product Id</label></td>
					<td><input type="number" name="id"></td>
				</tr>

				<tr>
					<td><label>Enter Product name</label></td>
					<td><input type="String" name="name"></td>
				</tr>

				<tr>
					<td><label>Enter Product Brand</label></td>
					<td><input type="String" name="brand"></td>
				</tr>
				
				<tr>
					<td><label>Enter Product Price</label></td>
					<td><input type="String" name="price"></td>
				</tr>

				<tr>
					<td><label>Enter Product password</label></td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<button input type="submit">submit</button>
		</form>
	</fieldset>

</body>
</html>