<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Dojos</title>
    </head>
    <body>
        <form:form action="/dojos" method="post" modelAttribute="dojo">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name"/></td>
                    <td><form:errors path="name"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add Dojo"/></td>
                </tr>
            </table>
        </form:form>

        <ul>
            <c:forEach items="${dojos}" var="dojo">
                <li>
                    <a href="/dojos/${dojo.id}">${dojo.name}</a>: <c:forEach items="${dojo.ninjas}" var="ninja">
                    <a href="/ninjas/${ninja.id}">${ninja.name}</a> - </c:forEach>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
