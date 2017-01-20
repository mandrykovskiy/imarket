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
	<form action="/admin/productCategory" method="post">
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
			<th>Category name</th>
		</tr>
		<c:forEach items="${productCategories}" var="productCategory">
			<tr>
				<td>${productCategory.name}</td>
				<td><a href="/admin/productCategory/delete/${productCategory.id}">delete</a>
				</td>
				<td><a href="/admin/productCategory/update/${productCategory.id}">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>