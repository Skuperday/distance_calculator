<%@ page import="calculator.service.CityService" %>
<%@ page import="calculator.service.CityServiceImpl" %>
<%@ page import="org.hibernate.tuple.CreationTimestampGeneration" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CALCULATOR</title>
</head>
<body>
<div align="center">
<form action="${calculator}" method="POST">
    From City: <input type = "text" name = "fromCity">
    To City: <input type = "text" name = "toCity">
    Option: <input type = "text" name = "option">
    <input type="submit" value ="Submit"/>
</form>
</div>
<div align="center">
<form action="${calculator}" method="GET">
    From City: <%= request.getParameter("fromCity")%>
    To City: <%= request.getParameter("toCity")%>
    Option: <%= request.getParameter("option")%>
    Distance:<%= request.getAttribute("result")%>
</form>
    <a href="/">Back to cities list</a>
</div>
</body>
</html>
