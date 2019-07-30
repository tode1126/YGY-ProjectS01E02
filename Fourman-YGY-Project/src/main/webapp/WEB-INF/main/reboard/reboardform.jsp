<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<script type="text/javascript" src="${root }/js/admin/adminRedirectJs.js"></script>
<link rel="stylesheet" href="${root }/css/reboard/starRev.css"/>
<script type="text/javascript" src="${root }/js/reboard/starRev.js"></script>
<script type="text/javascript" src="${root }/js/reboard/reboardformJs.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript" src="${root }/editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
<c:if test="${empty sessionScope.userLoginInfo}">
		<script type="text/javascript">
			adminCheck();
		</script>
</c:if>
<c:if test="${ sessionScope.userLoginInfo ne null}">
<div class="board">
	<form action="reboardInsert.do" id="insertBoardFrm" method="post" onsubmit="return check(this)"  >
		<table style="width: 800px;">
			<caption>글쓰기</caption>
			<tr>
				<th width="100">작성자</th>
				<th width="200">${sessionScope.userLoginInfo.nickname }(${sessionScope.userLoginInfo.user_Email })</th>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="reboard_subject" style="width: 250px;">
				</td>
			</tr>
			<tr>
				<th>별점</th>
				<td>
					<div class="StarRev">
				        <span class="StarR1 on">0.5</span>
				        <span class="StarR2 no">1.0</span>
				        <span class="StarR1 no">1.5</span>
				        <span class="StarR2 no">2.0</span>
				        <span class="StarR1 no">2.5</span>
				        <span class="StarR2 no">3.0</span>
				        <span class="StarR1 no">3.5</span>
				        <span class="StarR2 no">4.0</span>
				        <span class="StarR1 no">4.5</span>
				        <span class="StarR2 no">5.0</span>
			    	</div>
			    	<input type="hidden" name="reboard_rating" id="star_score" value="0.5">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea style="width: 400px; height: 150px;" name="reboard_content" id="reboard_content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<!-- hidden -->
					<input type="hidden" name="user_info_nickname" value="${sessionScope.userLoginInfo.nickname }">
					<input type="hidden" name="user_info_email" value="${sessionScope.userLoginInfo.user_Email }">
					<input type="hidden" name="pageNum" value="${pageNum }">
					
					<c:if test="${reboard_pk !=0 }">
					<!-- 답글인경우에만 보내는 히든 -->
						<input type="hidden" name="reboard_pk" value="${reboard_pk }">
						<input type="hidden" name="groupno" value="${groupno }">
						<input type="hidden" name="restep" value="${restep }">
						<input type="hidden" name="relevel" value="${relevel }">
					</c:if>
					
					<button type="submit" id="insertBoard">게시글저장</button>
					<button type="button" onclick="history.back();">목록가기</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</c:if>
</body>
</html>