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
<script type="text/javascript" src="${root }/js/user/userformJs.js"></script>
<script type="text/javascript" src="${root }/js/user/sha-256.js"></script>
<link rel="stylesheet" href="${root }/css/user/userformStyle.css">
</head>
<body>
	<div class="member" align="center">
		<form action="userAction.do" method="post" onsubmit="return check(this)" name="frm">
			<!-- onsubmit 을 이용(액션폼 이동전에 검사하기위해)하여 리드 온니도 체크한다 위에 check 함수와 연결됨 -->
 			 <h2>회원가입</h2>
			<p>
			<label for="email" class="floatLabel">Email</label>
			<input id="email" name="email" type="text">
			</p>
			<p>
			<label for="password" class="floatLabel">Password</label>
			<input id="password" name="password" type="password">
			<span>비밀번호는 영어,숫자,특수문자 조합의 6글자 이상 20자 이하로 입력해주세요</span>
			</p>
			<p>
			<label for="password2" class="floatLabel">Confirm Password</label>
			<input id="password2" name="password2" type="password">
			</p>
			<p>
			<label for="hp" class="floatLabel">Hp</label>
			<input type="text" id="hp1" name="hp1" style="width: 105px;" maxlength="3" required="required"> 
			<b>-</b>
			<input type="text" id="hp2" name="hp2" style="width: 105px;" maxlength="4" required="required">
			<b>-</b> 
			<input type="text" id="hp3" name="hp3" style="width: 105px;" maxlength="4" required="required">
			</p>
			<p>
			<label for="nick" class="floatLabel">NickName</label>
			<input id="nickName" name="nickName" type="text">
			<span>닉네임은 영어,숫자,특수문자 조합의 4글자 이상 20자 이하로 입력해주세요</span>
			</p>
			<p>
			<input type="hidden" name="pass" id="pass" value="">
			<input type="hidden" name="grade" value="${grade }">
			<input type="submit" value="Create My Account" id="submit">
			</p>
		</form>
	</div>
</body>
</html>