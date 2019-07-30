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
	<c:set var="no" value="1"/>
	<table border="1">
		<thead>
		<tr>
			<th width="50">no</th>
			<th width="200">미리보기</th>
			<th width="300">파일이름</th>
			<th width="100">사이즈</th>
			<th width="100">관리</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${no }</td>
				<c:set var="no" value="${no + 1 }"/>
				<td align="center">
					<img src="../save/restaurant/intro/${dto.restaurant_rest_pk }/${dto.restaurant_intro_image_realname}" style="width:190px;">
				</td>
				<td>${dto.restaurant_intro_image }</td>
				<td>
					<fmt:formatNumber value="${dto.restaurant_intro_image_size/1024 }" pattern="#,###.##KB"/>
				</td>
				<td>
					<button type="button" onclick="location.href='./introImageDelete.do?image_pk=${dto.restaurant_intro_image_pk}' ">
						삭제하기
					</button>
				</td>
			</tr>
		</c:forEach>
		<tbody>
	</table><br>
	<button type="button" onclick="history.back();" style="width: 100%;">돌아가기</button>
</body>
</html>