<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Franklin Music - Your Cart</title>
	<link href="styles/main.css" rel="stylesheet" />
</head>

<body>
    <h1>Your Cart</h1>
    <table>
        <tr>
            <th style="width:200px">Description</th>
            <th style="width:50px">Price</th>
            <th>Qty</th>
            <th></th>
        </tr>
        
        <c:forEach items="${cart}" var="cartEntry">
        <tr>
            <td>${cartEntry.product.description}</td>
            <td>${cartEntry.product.price}</td>
            <td style="text-align:right">${cartEntry.qty}</td>
            <td><form><input type="submit" value="Update"></input></form></td>
        </tr>
        </c:forEach>
        
        <tr class="no-border">
            <td>Total:</td>
            <td>${cartTotal}</td>
            <td colspan="2"></td>
        </tr>
        <tr class="no-border">
            <td align="right" colspan="3"><form action="SearchResults" method="get"><input type="submit" value="Continue Shopping"></input></form></td>
            <td><form><input type="submit" value="Checkout"></input></form></td>
        </tr>
    </table>
</body>

</html>