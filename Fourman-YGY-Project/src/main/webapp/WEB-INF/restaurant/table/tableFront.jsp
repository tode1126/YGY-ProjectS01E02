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
<c:if test="${isRestaurantTable == 0 }">
	<button type="button" onclick="location.href='./tableCheck.do'">테이블 정보 추가하기</button>
</c:if>

<c:if test="${isRestaurantTable > 0 }">
	<button type="button" onclick="location.href='./tableCheck.do'">테이블 정보 수정하기</button>
	<br><br>
	<div class="table-wrap">
		<c:set var="cnt" value="0"/>
		<c:forEach var="dto" items="${tableList }">
			<c:set var="cnt" value="${cnt + 1 }"/>
			<button type="button" class="table ${restaurant_table_status }">${dto.restaurant_table_no }</button>
			<c:if test="${cnt%4==0 }"><br></c:if>
		</c:forEach>
		
	</div>
</c:if>



</body>
</html>