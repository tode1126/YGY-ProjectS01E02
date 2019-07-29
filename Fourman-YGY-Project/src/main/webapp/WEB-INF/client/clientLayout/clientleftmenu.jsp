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
<link rel="stylesheet" href="${root }/css/client/clientMenuStyle.css"/>

<body>


<ul class="ClientMenu">

	<li>
		<a href="${root}/client/service.do"><b>이용 안내</b></a><br>
		
		&nbsp;<a href="${root}/client/cancle.do" class="ServiceDetail">- 취소</a><br>
	
		&nbsp;<a href="${root}/client/order.do" class="ServiceDetail">- 주문/결제</a>	
	</li>
	
	<li>
		<a href="${root}/answer/main.do"><b>자주묻는 질문</b></a>
	</li>
	
	<li>
		<a href="${root}/member/form.do"><b>Q&A</b></a>
	</li>
	
	<li>
		<a href="${root}/notice/noticemain.do"><b>공지사항</b></a>
	</li>	


</body>
</html>









