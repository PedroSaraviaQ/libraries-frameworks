<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Title</title>
	</head>
	<body>

		<form:form action="/ninjas" method="post" modelAttribute="ninja">
			<table>
				<tr>
					<td>Name:</td>
					<td><form:input path="name"/></td>
					<td><form:errors path="name"/></td>
				</tr>
				<tr>
					<td>Dojo:</td>
					<td>

							<%-- To connect the dojo to the ninja, use the dojo's id in "path" and "value" --%>
						<form:select path="dojo.id">
							<c:forEach items="${dojos}" var="dojo">
								<form:option value="${dojo.id}">${dojo.name}</form:option>
							</c:forEach>
						</form:select>

							<%-- You can also use the dojo object itself to do the connection --%>
							<%-- <form:select path="dojo">--%>
							<%-- 	 <c:forEach items="${dojos}" var="dojo">--%>
							<%--		 <form:option value="${dojo}">${dojo.name}</form:option>--%>
							<%--	 </c:forEach>--%>
							<%-- </form:select>--%>

					</td>
				</tr>
				<tr>
					<td>
						<button>Submit</button>
					</td>
				</tr>
			</table>
		</form:form>

		<ul>
			<c:forEach items="${ninjas}" var="ninja">
				<li><a href="/ninjas/${ninja.id}">${ninja.name} - ${ninja.dojo.name}</a></li>
			</c:forEach>
		</ul>
	</body>
</html>
