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
<script type="text/javascript" src="${root }/js/admin/adminRedirectJs.js"></script>
<script type="text/javascript" src="${root }/js/admin/allMailSendJs.js"></script>
<link rel="stylesheet" href="${root }/css/admin/allMailSendStyle.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript" src="${root }/editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
	<c:if test="${empty sessionScope.userLoginInfo or sessionScope.userLoginInfo.user_grade ne 3}">
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
		<div class="mailCheck" >
			<div class="mailCheckform" >
				<form action="allMailSendAction.do" id="insertBoardFrm"
					method="post" >
					<h2>일괄 전송</h2>
					<p>
						<input type="radio" name="target" value="1" checked="checked">일반회원 
						<input type="radio" name="target" value="2">기업회원 
						<input type="radio" name="target" value="3">관리자
					</p>
					<p>
						<textarea name="editor" id="editor"></textarea>
					</p>
					<p>
						<input type="submit" id="insertBoard" value="Email Send">
					</p>
				</form>
			</div>
		</div>
	</c:if>
</body>
</html>