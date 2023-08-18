<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%--* You must add this tag in order to use these types of forms --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="/css/model.css">
    </head>
    <body>

        <%--* The form and other used tags have "form:" before them --%>
        <%--* The form tag has a model attribute that takes the parameter from the controller --%>
        <form:form action="/model" method="post" modelAttribute="basic">

            <%--? Each field goes inside a paragraph tag --%>
            <p>
                    <%--* Each tag has a "path" attribute that takes the name of the field --%>
                    <%--* The "for" and "id" attributes are not needed --%>
                <form:label path="name">Name:</form:label>
                <form:input type="text" path="name"/>

                    <%--* An "errors" is provided by the form taglib to display errors --%>
                    <%--* You can customize it with "class" or "cssClass" --%>
                <form:errors cssClass="error" path="name"/>
            </p>
            <p>
                <form:label path="email">Email:</form:label>
                <form:input type="email" path="email"/>
                <form:errors cssClass="error" path="email"/>
            </p>
            <p>
                <form:label path="password">Password:</form:label>
                <form:input type="password" path="password"/>
                <form:errors cssClass="error" path="password"/>
            </p>
            <p>
                <form:label path="age">Age:</form:label>
                <form:input type="number" path="age"/>
                <form:errors cssClass="error" path="age"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>

        <ul>
            <c:forEach items="${basics}" var="basic">
                <li><c:out value="${basic.name}"/></li>
            </c:forEach>
        </ul>
    </body>
</html>
