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
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/layout/topmenuStyle.css"/>
</head>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<body>

<div class="menu">
	<ul class="menu">
		<li><button class="btn-topmenu" onclick="location.href='${root }/admin/admin.do'">한식</button></li>
		<li><button class="btn-topmenu" onclick="">양식</button></li>
		<li><button class="btn-topmenu" onclick="">중식</button></li>
		<li><button class="btn-topmenu" onclick="">일식</button></li>
		<li><button class="btn-topmenu" onclick="">남미음식</button></li>
		<li><button class="btn-topmenu" onclick="location.href='${root }/reboard/reboardlist.do'">후기게시판</button></li>
	</ul>
</div>
<div class="menu-btn-wrap">
	<ul class="menu-btn">
		<li>
			<button class="btn-topmenu" onclick="location.href='${root }/client/main/list.do' ">
				고객 센터
			</button>
		</li>
		<c:if test="${empty sessionScope.userLoginInfo}">
			<li>
				<button class="btn-topmenu" onclick="location.href='${root }/main/user/loginform.do' ">
					로그인
				</button>
			</li>
		</c:if>
		<c:if test="${not empty sessionScope.userLoginInfo}">
			<li>이메일 : ${sessionScope.userLoginInfo.user_Email} 
			<a href="${root }/user/logout.do">로그아웃</a></li>
			<li><a href="${root }/main/user/userCheck.do">회원정보</a></li>
			<li><a href="${root }/main/user/userLeave.do">회원탈퇴</a></li>
		</c:if>
	</ul>
</div>
</body>
</html>