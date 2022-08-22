<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
th, td {
	padding: 20px
}
</style>
<body>
	<h2>Search a user</h2>
	<form method="post" action="${pageContext.request.contextPath}/search">
		Enter user ID <input type="text" name="id"> <input
			type="submit" value="search">
	</form>
	<form method="post" action="${pageContext.request.contextPath}/edit">

		<table>
			<thead>
				<th>id</th>
				<th>Name</th>
				<th>Email</th>
				<th>City</th>

			</thead>

			<c:forEach var="user" items="${LIST_USERS}">
				<tr>
					<td><input type="hidden" name="id" value="${user.id}">
						<input type="text" value="${user.id}" disabled></td>

					<td><input type="text" name="name" value="${user.name}"
						required></td>
					<td><input type="email" name="email" value="${user.email}"
						required></td>
					<td><input type="text" name="city" value="${user.city}"
						required></td>
					<td><input type="submit" value="update">
				</tr>
			</c:forEach>

		</table>
	</form>

</body>
</html>