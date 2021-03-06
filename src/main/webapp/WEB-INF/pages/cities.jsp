<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CITIES</title>
</head>
<body>

<h1>list of all cities</h1>

<table>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Latitude</th>
        <th>Longitude</th>
        <th>action</th>
    </tr>
    <c:forEach var="city" items="${citiesList}">
        <tr>
            <td>${city.id}</td>
            <td>${city.name}</td>
            <td>${city.latitude}</td>
            <td>${city.longitude}</td>
            <td>
                <a href="/edit/${city.id}">edit</a>
                <a href="/delete/${city.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/calculator">distance calculator</a>
<a href="/add">Add new city</a>
<a href="/addxml">Add your file</a>
</body>
</html>