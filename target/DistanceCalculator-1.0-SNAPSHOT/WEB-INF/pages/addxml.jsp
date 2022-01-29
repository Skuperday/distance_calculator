<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPLOAD</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/uploadDistance">
    Upload xml file here <input type="file" name="file">
    <input type="submit" value="Upload">
</form>
<form method="POST" enctype="multipart/form-data" action="/uploadCities">
    Upload xml file here <input type="file" name="file">
    <input type="submit" value="Upload">
</form>
<a href="/">Back to cities list</a>
</body>
</html>
