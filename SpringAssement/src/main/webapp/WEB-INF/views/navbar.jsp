<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
nav {
	border: 2px solid gray;
	padding: 5px;
	background: gray;
	text-align: center;
}

a {
	margin: 20px;
	font-family: sans-serif;
	color: white;
	text-decoration: none;
}

a:hover {
	color: orange;
}
</style>
</head>
<body>
	<nav>
		<a href="./add">Add Product</a> 
		<a href="./delete">delete Product</a> 
		<a href="./update">update Product</a> 
		<a href="./getdata">See Product details</a> 
		<a href="./getall">See All Product</a>
		 <a href="./logout">logOut</a>
	</nav>
</body>
</html>