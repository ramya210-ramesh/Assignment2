<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String string = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>	
<%
	if (string != null && !string.isEmpty()) {
	%>
	<p style="color: red">
	<%=string%>
	<%
	}
	%>
	
	<fieldset>
		<legend>Product Login form</legend>
		<form action="./welcome" method="post">
			<table>
				<tr>
					<td><label>Enter your id:</label></td>
					<td><input type="number" name="id"></td>
				</tr>

				<tr>
					<td><label>Enter your Password:</label></td>
					<td><input type="password" name="password"></td>
				</tr>

			</table>
			<button type="submit" value="login">login</button>

		</form>

	</fieldset>
</body>
</html>