<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
    </head>
    <body>
        <h2>New instrument</h2>
        <form:form method="post" modelAttribute="instrument">
            <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <button>Create</button>
        </form:form>
        
        <h2>All instruments</h2>
        <ul>
            <c:forEach items="${instruments}" var="instrument">
                <li>
                    <a href="/instruments/${instrument.id}">${instrument.name}</a>
                </li>
            </c:forEach>
        </ul>
        
        <a href="/musicians">View musicians</a>
    </body>
</html>
