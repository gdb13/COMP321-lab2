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

	<h1>Are you sure you want to delete this product?</h1>

	<table>
		<tr><td><b>Code:</b></td><td>${product.code}</td></tr>
		<tr><td><b>Description:</b></td><td>${product.description}</td></tr>
	    <tr><td><b>Price:</b></td><td>${product.price}</td></tr>
	</table>

    <form action="DeleteProduct" method="post">
    	<input type="hidden" name="productCode" value="${product.code}" />
        <input type="submit" name="confirmedDelete" value="Yes" />
    </form>
    <form action="DeleteProduct" method="post">
        <input type="submit" name="confirmedDelete" value="No" />
    </form>
    
</body>

</html>