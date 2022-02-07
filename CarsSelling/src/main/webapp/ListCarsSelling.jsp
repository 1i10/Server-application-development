<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cars Selling</title>
</head>
<body>
<h2>Cars Selling List</h2>
<p><a href='<c:url value="/insert"/>'>Insert new position</a></p>

<style>  
table {
	border-collapse: collapse;
    font-family: Tahoma, Geneva, sans-serif;
}
table td {
	padding: 5px;
}
table thead td {
	font-weight: bold;
	font-size: 13px;
	border: 1px solid #54585d;
}
table tbody td {
	color: #636363;
	border: 1px solid #dddfe1;
}
table tbody tr {
	background-color: #f9fafb;
}
table tbody tr:nth-child(odd) {
	background-color: #ffffff;
}              
</style>   

<table>
<thead>
  <tr>
    <td>code</td>
    <td>manufacturer</td>
    <td>model</td>
    <td>color</td>
    <td>transmission</td>
    <td>body_type</td>
    <td>price</td>
    <td>action</td>
  </tr>
</thead>
<c:forEach var="position" items="${carsSelling}">
 <tr><td>${position.code}</td>
 	<td>${position.manufacturer}</td>
    <td>${position.model}</td>
    <td>${position.color}</td>
    <td>${position.transmission}</td>
    <td>${position.body_type}</td>
    <td>${position.price}</td>
    <td>
    <a href='<c:url value="/update?code=${position.code}"/>'><button>Update</button></a> /
    <form method="post" action='<c:url value="/delete"/>' style="display:inline;">
        <input type="hidden" name="code" value="${position.code}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>