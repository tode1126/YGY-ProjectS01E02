<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="../js/restaurant/menu/menuListJS.js"></script>
<title>Insert title here</title>
</head>
<body>
<a href="./menuAddForm.do">메뉴 추가하기</a>
<br>
<button>전체</button>
<button>요리</button>
<button>음료</button>
<button>사이드</button><br>
<table border="1">
	<tr>
		<th width="100">카테고리</th>
		<th width="200">메뉴명</th>
		<th width="100">가격</th>
		<th width="200">설명</th>
		<th width="150">관리</th>
	<tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<%-- <td align="center">${no }</td>
				<c:set var="no" value="${no-1 }"/> --%>
			<td align="center">
				${dto.menu_category }
			</td>
			<td align="center"> ${dto.menu_name } </td>
			<td align="center">${dto.menu_price }</td>
			<td align="center">${dto.menu_desc }</td>
			<td align="center">
				<button type="button" onclick="location.href='./menuUpdateForm.do?m=${dto.menu_pk}'">수정</button>&nbsp;&nbsp;
				<button type="button" onclick="" class="btn-delete" menu_pk="${dto.menu_pk }">삭제</button>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>