<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <form:form action="/ninjas/${ninja.id}" method="post" modelAttribute="ninja">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name"/></td>
                    <td><form:errors path="name"/></td>
                </tr>
                <tr>
                    <td>Dojo:</td>
                    <td>
                        <form:select path="dojo.id">
                            <c:forEach items="${dojos}" var="dojo">
                                <form:option value="${dojo.id}">${dojo.name}</form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button>Submit</button>
                    </td>
                </tr>
            </table>
        </form:form>

        <form:form action="/ninjas/${ninja.id}/delete" method="post">
            <button>Delete</button>
        </form:form>
    </body>
</html>
