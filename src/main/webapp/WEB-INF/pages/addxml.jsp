<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPLOAD</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/addxml">
    Upload  <input type="file" name="file">
    Name    <input type="text" name="name">
            <input type="submit" value="upload">
</form>
<a href="/">Back to cities list</a>
</body>
</html>
