<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="styles/main.css">
	<title>Product Maintenance</title>
</head>

<body>
	<h1>Products</h1>

	<table>
		<tr>
			<th style="width:75px">Code</th>
			<th style="width:500px">Description</th>
			<th style="width:75px;text-align:right">Price</th>
            <th></th>
            <th></th>
		</tr>
		
		<c:forEach items="${products}" var="product">
        <tr>
            <td>${product.code}</td>
            <td>${product.description}</td>
            <td style="text-align:right">${product.price}</td>
            <td><a href="EditProduct?productCode=${product.code}">Edit</a></form></td>
            <td><a href="DeleteProduct?productCode=${product.code}">Delete</a></td>
        </tr>
        </c:forEach>

	</table>

	<form action="EditProduct" method="get">
		<input type="submit" value="Add Product" />
	</form>
</body>

</html>