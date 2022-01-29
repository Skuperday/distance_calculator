<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty city.name}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty city.name}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty city.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty city.name}">
    <c:url value="/edit" var="var"/>
</c:if>

<form action="${var}" method="POST">
    <c:if test="${!empty city.name}">
        <input type="hidden" name="id" value="${city.id}">
    </c:if>
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="latitude">Latitude</label>
    <input type="text" name="latitude" id="latitude">
    <label for="longitude">Longitude</label>
    <input type="text" name="longitude" id="longitude">

    <c:if test="${empty city.name}">
        <input type="submit" value="Add new city">
    </c:if>
    <c:if test="${!empty city.name}">
        <input type="submit" value="Edit city">
    </c:if>
</form>
</body>
</html>
