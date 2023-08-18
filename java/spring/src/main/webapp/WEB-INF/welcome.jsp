<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Post Route</title>
    </head>
    <body>

        <%-- You just add the session variables like they were model variables. --%>
        <h1>Registration Complete, <c:out value="${username}"/></h1>

        <%-- The same goes for the flash attributes. --%>
        <h2><c:out value="${message}"/></h2>

    </body>
</html>
