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
<c:if test="${isRestaurantIntro == 0 }">
<a href="./introAddForm.do">식당 소개 쓰기</a>
</c:if>

<c:if test="${isRestaurantIntro > 0 }">
<a>식당 소개 수정</a> <br>
<div class="restaurant-intro restaurant-intro-text">
	<span>${intro_text }</span><br>
	<a href="./introTextUpdateForm.do">식당 소개글 수정</a> <br>
	<a href="./introImageAppendForm.do">식당 소개 이미지 추가하기</a> <br>
	<c:forEach var="dto" items="${imageList}" varStatus="status">
		
		<img src="../save/restaurant/intro/${dto.restaurant_rest_pk }/${dto.restaurant_intro_image_realname }" 
			style="width:400px;" />
		<%-- <c:set var="root" value="<%=request.getContextPath() %>"/>
		<img src="${root }/../save/restaurant/intro/1/4968055c-186f-4950-baec-181e8ca06f61.jpg"
			style="width:400px;" /> --%>
			<%-- <c:out value="${dto.restaurant_rest_pk }"/>
			<c:out value="${dto.restaurant_intro_image_realname }"/> --%>
		<c:if test="${status.count % 2 == 0 }">
			<br>
		</c:if>
	</c:forEach>
	<a href="./introText">식당 소개 이미지 삭제하기</a> <br>
</div>
</c:if>
</body>
</html>