<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Variables in JSP</title>

        <%--* To add static content, you can create the "css" and "js" folders inside "static"--%>
        <%--* Then just reference them by those folders and the file name--%>
        <link rel="stylesheet" href="css/style.css">
        <script src="js/alert.js"></script>

    </head>

    <body>

        <%--* The variable goes like if it was Java--%>
        <h1>Hello <c:out value="${name}"/>!</h1>

    </body>
</html>
