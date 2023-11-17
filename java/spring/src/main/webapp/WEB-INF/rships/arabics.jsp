<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Title</title>
	</head>
	<body>
		<form:form action="/arabics" method="post" modelAttribute="arabic">
			<p>
				<form:label path="name">Name:</form:label>
				<form:input path="name"/>
				<form:errors path="name"/>
			</p>
			<p>
				<form:label path="roman.name">Roman:</form:label>
				<form:input path="roman.name"/>
				<form:errors path="roman.name"/>
			</p>
			<button>Submit</button>
		</form:form>

		<ul>
			<c:forEach items="${arabics}" var="arabic">
				<li><a href="/arabics/${arabic.id}">${arabic.name}</a>: ${arabic.roman.name}</li>
			</c:forEach>
		</ul>
	</body>
</html>
