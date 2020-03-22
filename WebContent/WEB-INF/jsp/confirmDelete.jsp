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
		<tr><td><b>Code:</b></td><td>8601</td></tr>
		<tr><td><b>Description:</b></td><td>86 (the band) - True Life Songs and Pictures</td></tr>
	    <tr><td><b>Price:</b></td><td>$14.95</td></tr>
	</table>

    <form>
        <input type="submit" value="Yes" />
    </form>
    <form action="productMaint" method="get">
        <input type="submit" value="No" />
    </form>
    
</body>

</html>