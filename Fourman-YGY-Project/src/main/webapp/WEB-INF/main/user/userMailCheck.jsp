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
<link rel="stylesheet" href="${root }/css/user/userMailCheckStyle.css">
<link rel="stylesheet" href="${root }/css/Ji_Button_Style.css">
</head>
<body>
	<div class="mailCheck">
		<div class="mailCheckform">
			<form action="userMailCheckAction.do" method="post" >
			<h2>${email}</h2>
			<p>메일 인증이 필요합니다.</p>
			<p>발송후 3~5분이 소요 될수 있습니다.</p>
			<p>
				<input type="hidden" name="email" value="${email }">
				<input type="submit" class="blue button" value="Email Send">
			</p>
			</form>
		</div>
	</div>
</body>
</html>