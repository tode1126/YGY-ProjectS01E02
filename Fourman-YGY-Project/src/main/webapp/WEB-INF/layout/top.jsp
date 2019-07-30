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
<c:set var="root" value="<%=request.getContextPath() %>"/>
<link rel="stylesheet" href="${root }/css/layout/topStyle.css"/>
</head>
<body>
<c:if test="${sessionScope.userLoginInfo == null }">
	<a style="text-decoration: none;" href="${root}/main.do">
		<img src="${root}/image/LOGO.png" align="middle" class="logo">
	</a>
</c:if>
<c:if test="${sessionScope.userLoginInfo != null }">
	<c:if test="${sessionScope.userLoginInfo.user_grade == 1 }">
		<a style="text-decoration: none;" href="${root}/main.do">
			<img src="${root}/image/LOGO.png" align="middle" class="logo">
		</a>
	</c:if>
	<c:if test="${sessionScope.userLoginInfo.user_grade == 2 }">
		<a style="text-decoration: none;" href="${root}/restaurant/main.do">
			<img src="${root}/image/LOGO.png" align="middle" class="logo">
		</a>
	</c:if>
	<c:if test="${sessionScope.userLoginInfo.user_grade == 3 }">
		<a style="text-decoration: none;" href="${root}/admin/admin.do">
			<img src="${root}/image/LOGO.png" align="middle" class="logo">
		</a>
	</c:if>
</c:if>

<%-- <a style="text-decoration: none;" href="${root}/main.do">
<img src="${root}/image/LOGO.png" align="middle" class="logo">
</a> --%>
<div class="etc">

</div>
</body>
</html>