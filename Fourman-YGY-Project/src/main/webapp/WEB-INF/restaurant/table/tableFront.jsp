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
<a>테이블 정보 추가하기</a>
</c:if>
<c:if test="${isRestaurantTable > 0 }">
<a>테이블 정보 수정하기</a>
</c:if>
</body>
</html>