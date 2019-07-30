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
<link rel="stylesheet" href="${root }/css/admin/reboardcontentStyle.css">
<link rel="stylesheet" href="${root }/css/reboard/starRev.css" />
<script type="text/javascript"
	src="${root }/js/reboard/reboardcontentJs.js"></script>
</head>
<body>
	<c:if
		test="${empty sessionScope.userLoginInfo or sessionScope.userLoginInfo.user_grade ne 3}">
		<script type="text/javascript">
			adminCheck();
		</script>
	</c:if>
	<c:if
		test="${not empty sessionScope.userLoginInfo and sessionScope.userLoginInfo.user_grade eq '3'}">
		<div class="noticeEditLayer" >
			<div class="noticeEdit" >
				<form action="notice_boardListModified.do" id="insertBoardFrm" method="post" >
					<p>
						<img id="backImg" src="${root }/image/admin/return-to-the-past.png" onclick="history.back();" width="30">
					</p>
					<h2>후기 내용</h2>
					<p>
						<label for="notice_writer" class="floatLabel">작성자</label>
						<input name="notice_writer" type="text" value="${dto.user_info_nickname }" readonly="readonly">
					</p>
					<p>
						<label for="notice_subject" class="floatLabel">제 목</label>
						<input name="notice_subject" type="text" value="${dto.reboard_subject}" readonly="readonly">
					</p>
						<div class="noticeContent">
							${dto.reboard_content }
						</div>
					<c:if test="${ralist ne null }">
						<c:forEach var="radto" items="${ralist }">
						<p class="radtoAnswer">
							<b>${radto.answer_nickname}</b> 
							<span style="color: gray;font-size: 10pt">
							<fmt:formatDate value="${radto.answer_wrtieday }" pattern="yyyy-MM-dd HH:mm" /></span>
							
							&nbsp;&nbsp;
							<a href="${root }/admin/reboardManagement/boardAnswerDelete.do?answer_pk=${radto.answer_pk }&pageNum=${param.pageNum}&reboard_reboard_pk=${radto.reboard_reboard_pk}">삭제</a>
							<br> &nbsp;&nbsp;${radto.answer_content } <br>
						</p>
						</c:forEach>
					</c:if>

				</form>
			</div>
		</div>
	</c:if>
</body>
</html>