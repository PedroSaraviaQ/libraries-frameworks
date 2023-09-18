<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
    </head>
    <body>
        <a href="/musicians">View musicians</a>
        
        <h2>Student details</h2>
        
        <%-- The instruments field is not even included when updating a musician. --%>
        <form:form method="put" modelAttribute="musician">
            <input type="hidden" name="_method" value="put">
            <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <button>Submit</button>
        </form:form>
        
        <form:form method="delete">
            <input type="hidden" name="_method" value="delete">
            <button>Delete student</button>
        </form:form>
        
        <h2>Student's instruments</h2>
        
        <%-- The form for adding an instrument to the musician doesn't use modelAttribute --%>
        <%-- But rather works by sending only the instrument's id as a field. --%>
        <form:form action="/musicians/${musician.id}/instruments" method="put">
            <input type="hidden" name="_method" value="put">
            <select name="instrumentId" id="instrument">
                <c:forEach items="${instruments}" var="instrument">
                    <option value="${instrument.id}">${instrument.name}</option>
                </c:forEach>
            </select>
            <button>Add instrument</button>
        </form:form>
        
        <ul>
            <c:forEach items="${musician.instruments}" var="instrument">
                <li>
                    <a href="/instruments/${instrument.id}">${instrument.name}</a>
                        
                        <%-- The same goes for the delete form, we just send it as a hidden field. --%>
                    <form:form action="/musicians/${musician.id}/instruments" method="delete" style="display: inline">
                        <input type="hidden" name="_method" value="delete">
                        <input type="hidden" name="instrumentId" value="${instrument.id}">
                        <button>x</button>
                    </form:form>
                
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
