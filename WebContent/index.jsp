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

<p style="color:green">${success}</p>
<p style="color:red">${fail}</p>


	<table>
		<thead>
			<th>id</th>
			<th>Name</th>
			<th>Email</th>
			<th>City</th>

		</thead>
		<c:forEach var="user" items="${LIST_USERS}">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.city}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>