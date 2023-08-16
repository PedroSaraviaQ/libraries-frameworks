<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Basics</title>
    </head>
    <body>
        <form action="/basic" method="post">
            <label>Name: <input type="text" name="name"></label>
            <label>Password: <input type="password" name="password"></label>
            <label>Email: <input type="email" name="email"></label>
            <label>Age: <input type="number" name="age"></label>
            <button>Submit</button>
        </form>

        <ul>
            <%--* The elements retrieved from the database are will be displayed here. --%>
            <c:forEach items="${basics}" var="basic">
                <li>
                    I'm <c:out value="${basic.name}"/>.
                    My email is <c:out value="${basic.email}"/>.
                    I'm <c:out value="${basic.age}"/> years old.
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
