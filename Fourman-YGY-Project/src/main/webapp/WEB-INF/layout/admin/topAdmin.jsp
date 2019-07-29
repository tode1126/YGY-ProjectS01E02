<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>" />
<link rel="stylesheet" href="${root }/css/layout/topStyle.css" />
<link rel="stylesheet" href="${root }/css/admin/topAdminStyle.css" />
</head>

<body>
	<div class="topText">
		<p class="f-left" align="center">
			<a href="${root}/admin/admin.do">여기요
				관리자 서비스</a>
		</p>
		<c:if test="${not empty sessionScope.userLoginInfo}">
			<p class="f-right">
				Administrator: <strong>${sessionScope.userLoginInfo.user_Email}</strong>
				<a href="${root }/user/logout.do">로그아웃</a>
				<a href="${root }/admin/user/userCheck.do">회원정보</a>
				<a href="${root }/admin/user/userLeave.do">회원탈퇴</a>
			</p>
		</c:if>
		<c:if test="${empty sessionScope.userLoginInfo}">
			<p class="f-right">
				<a href="${root }/main/user/loginform.do">로그인</a>
			</p>
		</c:if>
	</div>
</body>
</html>










