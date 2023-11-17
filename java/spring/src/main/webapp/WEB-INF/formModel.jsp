<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%--* Add this tag to use this type of form --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="/css/model.css">
    </head>
    <body>

        <%-- This special kind of form supports error validation, just add the "form:" prefix to the tags --%>

        <%-- "modelAttribute" takes the name of the object that will be validated --%>
        <form:form action="/model" method="post" modelAttribute="basic">
            <p>
                    <%-- Each tag uses "path" which takes the name of the property --%>
                <form:label path="name">Name:</form:label>

                    <%-- "for" and "id" are not needed, and "name" is replaced by "path" --%>
                <form:input type="text" path="name"/>

                    <%-- An additional "errors" tag displays the constraint errors --%>
                <form:errors class="error" path="name"/>
            </p>
            <p>
                <form:label path="email">Email:</form:label>
                <form:input type="email" path="email"/>
                <form:errors class="error" path="email"/>
            </p>
            <p>
                <form:label path="password">Password:</form:label>
                <form:input type="password" path="password"/>
                <form:errors class="error" path="password"/>
            </p>
            <p>
                <form:label path="age">Age:</form:label>
                <form:input type="number" path="age"/>
                <form:errors class="error" path="age"/>
            </p>
            <%-- The object is automatically added to the model, and you don't need "@RequestParam" --%>
            <button>Submit</button>
        </form:form>

        <ul>
            <c:forEach items="${basics}" var="basic">
                <li><a href="/model/${basic.id}"><c:out value="${basic.name}"/>!</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
