<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="styles/main.css">
	<title>Product Maintenance</title>
</head>

<body>
<h1>Product Maintenance</h1>

<form>
    <label for="code">Code:</label><input type="text" name="code" size="10" value="${product.code}" /><br />
    <label for="description">Description:</label><input type="text" name="description" size="50" value="${product.description}" /><br />
    <label for="price">Price:</label><input type="text" name="price" size="10" value="${product.price}" /><br />
    <input type="submit" value="Update Product" />
</form>

<form action="ProductList" method="get">
    <input type="submit" value="View Products" />
</form>
</body>

</html>