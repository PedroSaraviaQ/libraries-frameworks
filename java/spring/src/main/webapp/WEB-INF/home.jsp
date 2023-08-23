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

        <%-- Use the "c:out" tag to include Java code with its "value" attribute --%>
        <%-- It should be with a "$" and between curly braces --%>
        <h2><c:out value="${2+2}"/></h2>

        <%--* Use "c:if" to render the content if the "test" attribute is true --%>
        <c:if test="${1+1 == 2}">
            <h3>1 + 1 is 2!</h3>
        </c:if>

        <%-- "c:forEach" is used to iterate over a collection --%>
        <%-- "items" is the collection and "var" is the element name --%>
        <c:forEach items="${{1,2,3,4,5}}" var="i">
            <p>Iteration <c:out value="${i}"/></p>
        </c:forEach>

        <%-- While "c:out" is not mandatory, it is recommended to prevent XSS attacks --%>
        <%-- Specially when working with user input, dynamic content, and links --%>
        <p>${10+1}</p>

        <%-- Use the "include" tag to implement Template Inheritance --%>
        <%-- This is specially used with static content --%>
        <%@include file="template.jsp" %>

    </body>
</html>
