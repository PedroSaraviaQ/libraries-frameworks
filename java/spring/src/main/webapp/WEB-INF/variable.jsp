<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Variables in JSP</title>
    </head>
    
    <body>
        <h1>Hello <c:out value="${name}"/>!</h1>
    </body>
</html>
