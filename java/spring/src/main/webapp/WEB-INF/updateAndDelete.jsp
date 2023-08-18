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

        <%-- The form is the same, just change the action to the correct url --%>
        <form:form action="/model/${basic.id}" method="post" modelAttribute="basic">
            <p>
                <form:label path="name">Name:</form:label>
                <form:input type="text" path="name"/>
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

        <form:form action="/model/${basic.id}/delete" method="post" modelAttribute="basic">
            <button>Delete</button>
        </form:form>

    </body>
</html>
