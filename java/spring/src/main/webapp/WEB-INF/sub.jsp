<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Inheriting</title>
    </head>
    <body>
        <form action="/sub" method="post">
            <label>Name: <input type="text" name="name"></label>
            <label>Code: <input type="text" name="code"></label>
            <button>Submit</button>
        </form>

        <ul>
            <c:forEach items="${subs}" var="sub">
                <li>
                    <c:out value="${sub.name}: ${sub.code}"/>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
