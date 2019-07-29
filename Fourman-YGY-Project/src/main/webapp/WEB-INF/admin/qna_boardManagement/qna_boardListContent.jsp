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
<link rel="stylesheet" href="${root }/css/admin/qna_boardListEditStyle.css">
</head>
<body>
	<c:if test="${empty sessionScope.userLoginInfo or sessionScope.userLoginInfo.user_grade ne 3}">
		<script type="text/javascript">
			adminCheck();
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.userLoginInfo and sessionScope.userLoginInfo.user_grade eq '3'}">
		<div class="qnaEditLayer" >
			<div class="qnaEdit" >
				<form action="qna_boardListReplyInsert.do" id="insertBoardFrm" method="post" >
					<p>
						<img id="backImg" src="${root }/image/admin/return-to-the-past.png" onclick="history.back();" width="30">
					</p>
					<c:if test="${dto.qna_ref eq '0' }">
						<h2>문의 내용</h2>
					</c:if>
					<c:if test="${dto.qna_ref ne '0' }">
						<h2>답변 내용</h2>
					</c:if>
					<p>
						<label for="qna_writer" class="floatLabel">작성자</label>
						<input name="qna_writer" type="text" value="${dto.qna_writer }" readonly="readonly">
					</p>
					<p>
						<label for="qna_subject" class="floatLabel">제 목</label>
						<input name="qna_subject" type="text" value="${dto.qna_subject}" readonly="readonly">
					</p>
						<div class="qna_content">
							${dto.qna_content }
						</div>
					<p>	
						<input type="hidden" name="qna_pk" value="${dto.qna_pk }">
						<input type="hidden" name="pageNum" value="${pageNum }"> 
						<c:if test="${dto.qna_ref eq '0' }">
						<input type="submit" id="insertBoard" value="QnA Reply">
						</c:if>
					</p>
				</form>
			</div>
		</div>
	</c:if>
</body>
</html>