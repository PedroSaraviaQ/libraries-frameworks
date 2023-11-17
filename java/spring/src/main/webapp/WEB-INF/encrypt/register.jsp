<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Register</title>
    </head>
    <body>
        <h2>Register</h2>
        <form:form method="post" modelAttribute="user">
            <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <p>
                <form:label path="email">Email:</form:label>
                <form:input path="email" type="email"/>
                <form:errors path="email"/>
            </p>
            <p>
                <form:label path="password">Password:</form:label>
                <form:input path="password" type="password"/>
                <form:errors path="password"/>
            </p>
            <p>
                <form:label path="confirmPassword">Confirm Password:</form:label>
                <form:input path="confirmPassword" type="password"/>
                    
                    <%-- This is for the password match validation --%>
                <form:errors path="confirmPassword"/>
            
            </p>
            <button>Create</button>
        </form:form>
    </body>
</html>
