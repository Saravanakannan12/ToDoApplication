<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<div>
		<a href="/addToDoItems">Add Todo Items</a>
	</div>
	<br>
	<div>
		<div>
			<h3>TODO Lists</h3>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th width="20%">Status</th>
						<th width="20%">Description</th>
						<th width="20%">Target Date</th>
						<th width="20%">Created Date</th>
						<th width="20%">Updated Date</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todoTable}" var="todo">
						<tr>
							<td><input type="checkbox" value ="isChecked" name = "status">
							<td>${todo.description}</td>
							<td><fmt:formatDate value="${todo.endDate}"
									pattern="dd/MM/yyyy" /></td>
							<td>${todo.createDate}</td>
							<td>${todo.modifiedDate}</td>
							<td><a type="button" class="btn btn-success"
								href="/update-todo?id=${todo.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete-todo?id=${todo.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

</body>
</html>