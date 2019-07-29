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
<script type="text/javascript"
	src="${root }/js/admin/adminRedirectJs.js"></script>
<script type="text/javascript" src="${root }/js/admin/allMailSendJs.js"></script>
<link rel="stylesheet" href="${root }/css/user/userMailCheckStyle.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<c:if test="${sessionScope.userLoginInfo.user_grade ne 3}">
		<script type="text/javascript">
			adminCheck();
		</script>
	</c:if>
	<c:if test="${not empty param.send }">
		<script type="text/javascript">
			sendSuccess();
		</script>
	</c:if>
	<c:if test="${not empty param.sendFalse }">
		<script type="text/javascript">
			sendError();
		</script>
	</c:if>
	<c:if
		test="${not empty sessionScope.userLoginInfo and sessionScope.userLoginInfo.user_grade eq '3'}">
		<div class="mailCheck">
			<div class="mailCheckform">
				<form action="allMailSendAction.do" method="post">
					<h2>일괄 전송</h2>
					<p>
						<input type="radio" name="target" value="1">일반회원 
						<input type="radio" name="target" value="2">기업회원 
						<input type="radio" name="target" value="3">관리자
					</p>
					<p>
						<textarea name="content" style="height: 212px; width: 386px;"></textarea>
					</p>
					<p>
						<input type="submit" value="Email Send">
					</p>
				</form>
			</div>
		</div>
	</c:if>
</body>
</html>