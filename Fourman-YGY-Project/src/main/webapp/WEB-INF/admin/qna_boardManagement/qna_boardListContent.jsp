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
	<c:if test="${empty sessionScope.userLoginInfo or sessionScope.userLoginInfo.user_grade ne 3}">
		<script type="text/javascript">
			adminCheck();
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.userLoginInfo and sessionScope.userLoginInfo.user_grade eq '3'}">
		<div class="noticeEditLayer" >
			<div class="noticeEdit" >
					<h2>QnA 내용</h2>
					<p>
						<label for="notice_writer" class="floatLabel">작성자</label>
						<input name="notice_writer" type="text" value="${dto.qna_writer }" readonly="readonly">
					</p>
					<p>
						<label for="notice_subject" class="floatLabel">제 목</label>
						<input name="notice_subject" type="text" value="${dto.qna_subject}" readonly="readonly">
					</p>
						<div class="noticeContent">
							${dto.qna_content }
						</div>
					<p>	
						<input type="hidden" name="pageNum" value="${pageNum }"> 
					</p>
			</div>
		</div>
	</c:if>
</body>
</html>