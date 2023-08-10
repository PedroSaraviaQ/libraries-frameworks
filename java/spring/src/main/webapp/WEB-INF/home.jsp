<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--* You should add this line of code in order to work with JSTL --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Working with JSP</title>
    </head>
	
    <body>
        <h1>2+2 is:</h1>

        <%--* To start, you can add a "c:out" tag to print a message --%>
        <%--* Then, use the "value" attribute to include the Java code --%>
        <%--* It should be with a "$" and between curly braces --%>
        <h2><c:out value="${2+2}"/></h2>

    </body>
</html>
