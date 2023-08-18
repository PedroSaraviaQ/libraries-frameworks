<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Variables in JSP</title>

        <%-- To add static content, you can create the "/css" and "/js" folders inside "static"--%>
        <%-- Then just reference them by those folders and the file name--%>
        <%-- The "/" at the beginning is important when visiting different pages--%>
        <link rel="stylesheet" href="/css/style.css">
        <script src="/js/alert.js"></script>

    </head>

    <body>

        <%-- The variable goes like if it was Java--%>
        <h1>Hello <c:out value="${name}"/>!</h1>

        <%-- When you're calling the property of an object, you're actually calling the getter--%>
        <h2>My <c:out value="${animal.name}"/> is <c:out value="${animal.color}"/>.</h2>
        <%-- You can even call methods--%>
        <p><c:out value="${animal.introduce()}"/></p>

        <%-- The "action" attribute takes the value of the POST request's URL--%>
        <form action="/register" method="post">

            <%-- The "name" attribute is the name of the variable that will be sent as a parameter--%>
            <label>Username: <input type="text" name="username"></label>
            <label>Password: <input type="password" name="password"></label>

            <button>Submit</button>
        </form>

    </body>
</html>
