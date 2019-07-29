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
<script type="text/javascript" src="${root }/js/admin/notic_boardListEditJs.js"></script>
<link rel="stylesheet" href="${root }/css/admin/notic_boardListEditStyle.css">
</head>
<body>
	<div class="noticeEditLayer">
		<div class="noticeEdit">
			<form action="notice_boardListModified.do" id="insertBoardFrm"
				method="post">
				<p>
					<img id="backImg" src="${root }/image/admin/return-to-the-past.png"
						onclick="history.back();" width="30">
				</p>
				<h2>공지 내용</h2>
				<p>
					<label for="notice_writer" class="floatLabel">작성자</label> <input
						name="notice_writer" type="text" value="공지사항 관리자"
						readonly="readonly">
				</p>
				<p>
					<label for="notice_subject" class="floatLabel">제 목</label> <input
						name="notice_subject" type="text" value="${dto.notice_subject}"
						readonly="readonly">
				</p>
				<div class="noticeContent">${dto.notice_content }</div>
			</form>
		</div>
	</div>
</body>
</html>