<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Franklin Music - Search Results</title>
	<link href="styles/main.css" rel="stylesheet" />
</head>

<body>

    <h1>Search Results</h1>

    <table>
        <tr>
            <th style="width:75px">Code</th>
            <th style="width:500px">Description</th>
            <th style="width:75px;text-align:right">Price</th>
            <th></th>
        </tr>


		<c:forEach items="${products}" var="product">
        <tr>
            <td>${product.code}</td>
            <td>${product.description}</td>
            <td style="text-align:right">${product.price}</td>
            <td><form action="Cart" method="post"><input type="hidden" name="productCode" value="${product.code}"><input type="submit" value="Add To Cart"></input></form></td>
        </tr>
        </c:forEach>

        <tr>
            <td colspan="3"></td>
            <td>
                <form action="Cart" method="get">
                    <input type="submit" value="View Cart"></input>
                </form>
            </td>
        </tr>
    </table>
    
</body>
</html>