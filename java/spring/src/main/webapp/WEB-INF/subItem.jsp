<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Sub Item</title>
        <link rel="stylesheet" href="/css/model.css">
    </head>
    <body>

        <form:form action="/sub/${sub.id}" method="put" modelAttribute="sub">
            <input type="hidden" name="_method" value="put"/>
            <p>
                <form:label path="name">Name:</form:label>
                <form:input type="text" path="name"/>
                <form:errors cssClass="error" path="name"/>
            </p>
            <p>
                <form:label path="code">Code:</form:label>
                <form:input type="text" path="code"/>
                <form:errors cssClass="error" path="code"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>

        <form:form action="/sub/${sub.id}" method="delete">
            <input type="hidden" name="_method" value="delete">
            <button>Delete</button>
        </form:form>

    </body>
</html>
