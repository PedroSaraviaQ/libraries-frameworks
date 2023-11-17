<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
    </head>
    <body>
        <h2>Instrument details</h2>
        <form:form method="put" modelAttribute="instrument">
            <input type="hidden" name="_method" value="put">
            <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <button>Submit</button>
        </form:form>
        
        <form:form method="delete">
            <input type="hidden" name="_method" value="delete">
            <button>Delete Instrument</button>
        </form:form>
        
        <h2>Musicians</h2>
        <ul>
            <c:forEach items="${instrument.musicians}" var="musician">
                <li>${musician.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>
