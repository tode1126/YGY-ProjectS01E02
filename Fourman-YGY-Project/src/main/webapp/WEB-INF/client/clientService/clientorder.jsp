<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/client/serviceStyle.css"/>

</head>
<body>

<h4>주문 과정 1</h4>

<div class="Order">

<br>
test2

</div>

<div class="Order">
<br>
메뉴 선택
</div>

<div class="Order">
<br>
예약 버튼
</div>

<div class="Order">
<br>
예약 완료
</div>

<br><br>

<h4>주문 과정 2</h4>

<div class="Order">
<br>
테이블 선택
</div>

<div class="Order">
<br>
메뉴 선택
</div>

<div class="Order">
<br>
주문 버튼
</div>

<div class="Order">
<br>
주문 완료
</div>

</body>
</html>
