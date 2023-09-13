<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

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
			<%-- The elements retrieved from the database will be displayed here. --%>
			<c:forEach items="${basics}" var="basic">
				<li>
					I'm <c:out value="${basic.name}"/>.
					My email is <c:out value="${basic.email}"/>.
					I'm <c:out value="${basic.age}"/> years old.

						<%-- Use the "fmt:formatDate" to display the date in a readable format. --%>
					I was created in <fmt:formatDate value="${basic.createdAt}"/>
						<%-- ALthough you can use the "pattern" attribute with like "yyyy-MM-dd" --%>

						<%-- Without the tag, the date displays raw. --%>
					(${basic.createdAt})
					
				</li>
			</c:forEach>
		</ul>
	</body>
</html>
