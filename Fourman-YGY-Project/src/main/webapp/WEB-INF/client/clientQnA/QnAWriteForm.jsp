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
<script type="text/javascript" src="${root }/js/qna/QnAWriteFormJs.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="${root }/css/admin/notic_boardListEditStyle.css">
<script type="text/javascript" src="${root }/editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
	<c:if test="${empty sessionScope.userLoginInfo }">
		<script type="text/javascript">
			adminCheck();
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.userLoginInfo}">
		<div class="noticeEditLayer" >
			<div class="noticeEdit" >
				<form action="questionWriteAction.do" id="insertBoardFrm" method="post" onsubmit="return check(this)" name="frm" >
					<p>
						<img id="backImg" src="${root }/image/admin/return-to-the-past.png" onclick="history.back();" width="30">
					</p>
					<h2>문의 작성</h2>
					<p>
						<label for="qna_writer" class="floatLabel">작성자</label>
						<input name="qna_writer" type="text" value="${qna_writer }" readonly="readonly">
					</p>
					<p>
						<label for="qna_subject" class="floatLabel">제 목</label>
						<input name="qna_subject" type="text">
					</p>
					<p>
						<textarea name="qna_content" id="qna_content"></textarea>
					</p>
					<p>	
						<input type="hidden" name="pageNum" value="${pageNum }">
						<input type="submit" id="insertBoard" value="Notic Edit">
					</p>
				</form>
			</div>
		</div>
	</c:if>
</body>
</html>