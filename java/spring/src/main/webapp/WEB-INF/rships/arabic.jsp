<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Title</title>
	</head>
	<body>
		<form:form method="put" modelAttribute="arabic">
			<input type="hidden" name="_method" value="put">
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

		<form:form method="delete">
			<input type="hidden" name="_method" value="delete">
			<button>Delete</button>
		</form:form>
	</body>
</html>
