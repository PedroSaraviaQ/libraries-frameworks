<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home</title>
    </head>
    <body>
        
        <%-- We can just use the session to show or hide items depending on whether it's logged in --%>
        <c:if test="${id==null}">
            
            <h2>Login</h2>
            <form action="/users/login" method="post">
                <p>
                    <label for="email">Email:</label>
                    <input id="email" name="email" type="email" value="${email}"/>
                    <span>${emailError}</span>
                </p>
                <p>
                    <label for="password">Password:</label>
                    <input id="password" name="password" type="password" value="${password}"/>
                    <span>${passwordError}</span>
                </p>
                <button>Submit</button>
            </form>
        </c:if>
        
        <h2>Welcome back!</h2>
        
        <%-- Same here --%>
        <c:if test="${id!=null}">
            
            <a href="/users/me">My info</a>
        </c:if>
    </body>
</html>
