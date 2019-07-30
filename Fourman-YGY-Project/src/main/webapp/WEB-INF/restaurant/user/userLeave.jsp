<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/user/userCheckStyle.css">
<script type="text/javascript" src="${root }/js/user/sha-256.js"></script>
<script type="text/javascript" src="${root }/js/user/userCheckJs.js"></script>
</head>
<body>
<c:if test="${not empty param.profalse}">
	<script type="text/javascript">
	passError();
	</script>
</c:if>
<c:if test="${empty sessionScope.userLoginInfo}">
	<script type="text/javascript">
	userCheck();
	</script>
</c:if>
<c:if test="${not empty sessionScope.userLoginInfo}">
<div class="pwfo">
		<form action="userleaveAction.do" method="post" onsubmit="return check(this)">
		 	<h2>회원 탈퇴</h2>
			<p>
				<label for="password" class="floatLabel">pass</label>
				<input type="password" name="password" required="required" autofocus="autofocus">
				<span>패스워드를 한번더 입력해주세요</span>
			</p>
			<p>
				<input type="hidden" value="" name="pass">
				<input type="submit" value="user Leave" id="idck">
			</p>
		</form>
	</div>
</c:if>
</body>
</html>