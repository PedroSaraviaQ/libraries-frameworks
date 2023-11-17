<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
    </head>
    <body>
        <h2>New Musician</h2>
        
        <%-- The musician form doesn't include the instruments field. --%>
        <form:form method="post" modelAttribute="musician">
            <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <button>Create</button>
        </form:form>
        
        <h2>All musicians</h2>
        <ul>
            <c:forEach items="${musicians}" var="musician">
                <li>
                    <a href="/musicians/${musician.id}">${musician.name}</a>
                </li>
            </c:forEach>
        </ul>
        
        <a href="/instruments">View instruments</a>
    </body>
</html>
