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
<script type="text/javascript" src="${root }/js/user/userSearchJs.js"></script>
<link rel="stylesheet" href="${root }/css/user/userSearchStyle.css">
</head>
<body>
<div class="idfo">
		<form action="userSearchAction.do" method="post" onsubmit="return check(this)">
		 	<h2>pw 찾기</h2>
			<p>
				<label for="email" class="floatLabel">Email</label>
				<input type="text" name="email" required="required" autofocus="autofocus">
				<span>가입시 입력하신 이메일로 메일이 발송됩니다</span>
			</p>
			<p>
				<input type="submit" value="Email Send" id="idck">
			</p>
		</form>
	</div>
</body>
</html>