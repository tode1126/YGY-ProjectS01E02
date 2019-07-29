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
<link rel="stylesheet" href="${root }/css/user/userGradeStyle.css">
<link rel="stylesheet" href="${root }/css/Ji_Button_Style.css">
</head>
<body>
	<div class="user_area">
		<div class="user_title">
			<strong>여기요 입니다.</strong><br><br><br>
			여기요 회원은 개인회원과 기업회원으로 구분되어지며<br>
			회원가입시 여기요의 모든 서비스를 이용하실수 있습니다.<br><br>
			(* 개인회원과 기업회원은 서로 전환이 불가능합니다.)
		</div>
		<div class="user_box">
			<div class="left">
				<h5>개인회원</h5>
				<p>
					여기요의 다양한 정보와<br>서비스를 모두 이용하실 수 있습니다.
				</p>
				<span> 
					<a href="userform.do?grade=1"> 
					<%-- <img src="${root}/image/Ji_btn_user.gif"> --%>
					<button class="blue button">가입하기</button>
					</a>
				</span>
			</div>
			<div class="right">
				<h5>기업회원</h5>
				<p>
					여기요의 기업지원을 위한<br> 서비스를 모두 이용하실 수 있습니다.
				</p>
				<span> 
					<a href="userform.do?grade=2"> 
					<%-- <img src="${root}/image/Ji_btn_user-1.gif"> --%>
					<button class="red button">가입하기</button>
					</a>
				</span>
			</div>
		</div>
	</div>
</body>
</html>