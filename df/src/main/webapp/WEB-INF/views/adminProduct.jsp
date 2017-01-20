<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form:form action="/admin/product" method="post" modelAttribute="form">
		<form:errors path="*" />
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:select path="productCountry">
				<option value="0">ProductCountry</option>
						<c:forEach items="${productcountries}" var="productCountry">
							<c:choose>
								<c:when test="${productCountry.id eq form.productCountry.id}">
									<option value="${productCountry.id}" selected="selected">${productCountry.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${productCountry.id}">${productCountry.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:select path="productCategory">
				<option value="0">ProductCategory</option>
						<c:forEach items="${productCategories}" var="productCategory">
							<c:choose>
								<c:when test="${productCategory.id eq form.productCategory.id}">
									<option value="${productCategory.id}" selected="selected">${productCategory.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${productCategory.id}">${productCategory.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:select path="productCreator">
				<option value="0">ProductCreator</option>
						<c:forEach items="${productCreators}" var="productCreator">
							<c:choose>
								<c:when test="${productCreator.id eq form.productCreator.id}">
									<option value="${productCreator.id}" selected="selected">${productCreator.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${productCreator.id}">${productCreator.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><form:input path="name" placeholder="Product name" /></td>
			</tr>
			<tr>
				<td><form:input path="price" placeholder="*.00" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<th>Product name</th>
			<th>productCategory </th>
			<th>productCreator </th>
			<th>productCountry </th>
			
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.name}</td>
				<td>${product.productCategory.name}</td>
				<td>${product.productCreator.name}</td>
				<td>${product.productCountry.name}</td>
	
				<td><a href="/admin/product/delete/${product.id}">delete</a></td>
				<td><a href="/admin/product/update/${product.id}">update</a></td>
			
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>