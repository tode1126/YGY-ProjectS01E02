<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th width=80>분류</th>
			<th width=200>상호명</th>
			<th width=120>전화번호</th>
			<th width=300>주소</th>
			<th width=200>영업시간</th>
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
			<td align="center">
				${dto.rest_category }
			</td>
			<td align="center">
				<a href="./restaurantMain.do?select=${dto.rest_pk }">${dto.rest_name }</a> 
			</td>
			<td align="center">${dto.rest_phone }</td>
			<td align="center">${dto.rest_addr }</td>
			<td align="center">
				${dto.rest_start } ~ ${dto.rest_end }
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>