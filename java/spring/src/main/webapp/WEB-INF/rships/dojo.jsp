<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form:form action="/dojos/${dojo.id}" method="put" modelAttribute="dojo">
            <input type="hidden" name="_method" value="put">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name"/></td>
                    <td><form:errors path="name"/></td>
                </tr>
                <tr>
                    <td>
                        <button>Submit</button>
                    </td>
                </tr>
            </table>
        </form:form>

        <form:form action="/dojos/${dojo.id}" method="delete">
            <input type="hidden" name="_method" value="delete">
            <button>Delete</button>
        </form:form>
    </body>
</html>
