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

        <%--* You can use "c:if" to print a message if the "test" attribute is true --%>
        <c:if test="${1+1 == 2}">
            <h3>1 + 1 is 2!</h3>
        </c:if>

        <%--* And you can use "c:forEach" to iterate over a collection --%>
        <%--* The "items" attribute is the collection that will be iterated --%>
        <%--* The "var" attribute is the name of the variable of the current iteration --%>
        <c:forEach var="i" items="${{1,2,3,4,5}}">
            <p>Iteration <c:out value="${i}"/></p>
        </c:forEach>

    </body>
</html>
