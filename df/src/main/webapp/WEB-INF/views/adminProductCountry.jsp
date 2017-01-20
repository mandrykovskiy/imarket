<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/admin/productCountry" method="post" modelAttribute="productCountry">
	<form:hidden path="id"/>
		<table>
			<tr>
				<td><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<th>Country name</th>
		</tr>
		<c:forEach items="${productCountries}" var="productCountry">
			<tr>
				<td>${productCountry.name}</td>
				<td><a href="/admin/productCountry/delete/${productCountry.id}">delete</a>
				</td>
				<td><a href="/admin/productCountry/update/${productCountry.id}">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>