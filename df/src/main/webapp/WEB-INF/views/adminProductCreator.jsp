<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/admin/productCreator" method="post">
		<table>
			<tr>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>Creator name</th>
		</tr>
		<c:forEach items="${productCreators}" var="productCreator">
			<tr>
				<td>${productCreator.name}</td>
				<td><a href="/admin/productCreator/delete/${productCreator.id}">delete</a>
				</td>
				<td><a href="/admin/productCreator/update/${productCreator.id}">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>