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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<script type="text/javascript" src="${root }/js/admin/adminRedirectJs.js"></script>
<script type="text/javascript" src="${root }/js/admin/mainAdminJs.js"></script>
<link rel="stylesheet" href="${root }/css/admin/mainAdminStyle.css"/>
<link rel="stylesheet" href="${root }/css/Ji_Button_style.css"/>
</head>
<body>
	<c:if test="${sessionScope.userLoginInfo.user_grade ne 3}">
		<script type="text/javascript">
			adminCheck();
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.userLoginInfo and sessionScope.userLoginInfo.user_grade eq '3'}">
	<div class="mainLayouts">
		<div class="userContainer">
			<div class="conetionUser">
				<h2>현재 접속자수</h2>
				<p class="userCount">0</p>
			</div>

			<div class="userList">
				<h2>현재 접속 중인 회원</h2>
				<div class="userListContent"></div>
			</div>
			<div style="clear:both;"></div>
		</div>
	</div>
	</c:if>
</body>
</html>