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
<link href="https://fonts.googleapis.com/css?family=Cute+Font" rel="stylesheet">
<link rel="stylesheet" href="${root }/css/reboard/starRev.css" />
<script type="text/javascript" src="${root }/js/reboard/reboardcontentJs.js"></script>
</head>
<body>
	<div class="BoardContent">
		<table>
			<tr>
				<td>${dto.reboard_subject} 
				<span> <fmt:formatDate value="${dto.reboard_writedate}" pattern="yyyy-MM-dd HH:mm" /></span>
				</td>
			</tr>
			<tr height="250">
				<td valign="top">작성자 : ${dto.user_info_nickname}
					(${dto.user_info_email}) 
					<span> 조회 ${dto.readcount}</span>
				<br>
				<br> 
				<span>별점 :</span>
				<div class="StarRev">
						<c:if test="${dto.reboard_rating eq 0.5 }">
							<span class="StarR1 on">0.5</span>
						</c:if>

						<c:if test="${dto.reboard_rating eq 1.0 }">
							<span class="StarR1 on">0.5</span>
							<span class="StarR2 on">1.0</span>
						</c:if>

						<c:if test="${dto.reboard_rating eq 1.5 }">
							<span class="StarR1 on">0.5</span>
							<span class="StarR2 on">1.0</span>
							<span class="StarR1 on">1.5</span>
						</c:if>

						<c:if test="${dto.reboard_rating eq 2.0 }">
							<span class="StarR1 on">0.5</span>
							<span class="StarR2 on">1.0</span>
							<span class="StarR1 on">1.5</span>
							<span class="StarR2 on">2.0</span>
						</c:if>

						<c:if test="${dto.reboard_rating eq 2.5 }">
							<span class="StarR1 on">0.5</span>
							<span class="StarR2 on">1.0</span>
							<span class="StarR1 on">1.5</span>
							<span class="StarR2 on">2.0</span>
							<span class="StarR1 on">2.5</span>
						</c:if>

						<c:if test="${dto.reboard_rating eq 3.0 }">
							<span class="StarR1 on">0.5</span>
							<span class="StarR2 on">1.0</span>
							<span class="StarR1 on">1.5</span>
							<span class="StarR2 on">2.0</span>
							<span class="StarR1 on">2.5</span>
							<span class="StarR2 on">3.0</span>
						</c:if>

						<c:if test="${dto.reboard_rating eq 3.5 }">
							<span class="StarR1 on">0.5</span>
							<span class="StarR2 on">1.0</span>
							<span class="StarR1 on">1.5</span>
							<span class="StarR2 on">2.0</span>
							<span class="StarR1 on">2.5</span>
							<span class="StarR2 on">3.0</span>
							<span class="StarR1 on">3.5</span>
						</c:if>

						<c:if test="${dto.reboard_rating eq 4.0 }">
							<span class="StarR1 on">0.5</span>
							<span class="StarR2 on">1.0</span>
							<span class="StarR1 on">1.5</span>
							<span class="StarR2 on">2.0</span>
							<span class="StarR1 on">2.5</span>
							<span class="StarR2 on">3.0</span>
							<span class="StarR1 on">3.5</span>
							<span class="StarR2 on">4.0</span>
						</c:if>

						<c:if test="${dto.reboard_rating eq 4.5 }">
							<span class="StarR1 on">0.5</span>
							<span class="StarR2 on">1.0</span>
							<span class="StarR1 on">1.5</span>
							<span class="StarR2 on">2.0</span>
							<span class="StarR1 on">2.5</span>
							<span class="StarR2 on">3.0</span>
							<span class="StarR1 on">3.5</span>
							<span class="StarR2 on">4.0</span>
							<span class="StarR1 on">4.5</span>
						</c:if>

						<c:if test="${dto.reboard_rating eq 5.0 }">
							<span class="StarR1 on">0.5</span>
							<span class="StarR2 on">1.0</span>
							<span class="StarR1 on">1.5</span>
							<span class="StarR2 on">2.0</span>
							<span class="StarR1 on">2.5</span>
							<span class="StarR2 on">3.0</span>
							<span class="StarR1 on">3.5</span>
							<span class="StarR2 on">4.0</span>
							<span class="StarR1 on">4.5</span>
							<span class="StarR2 on">5.0</span>
						</c:if>
					</div> 
				<span>좋아요 
					<span class="reboard_happy" reboard_pk="${dto.reboard_pk}">${dto.reboard_happy}</span>
				</span> 
				<span>싫어요 
					<span class="reboard_unhappy" reboard_pk="${dto.reboard_pk}">${dto.reboard_unhappy}</span>
				</span>
					<div>${dto.reboard_content}</div>
				</td>
			</tr>
			<tr>
				<td>
				<c:if test="${ralist ne null }">
						<c:forEach var="radto" items="${ralist }">
							<b>${radto.answer_nickname}</b> 
							<span style="color: gray;font-size: 10pt">
							<fmt:formatDate value="${radto.answer_wrtieday }" pattern="yyyy-MM-dd HH:mm" /></span>
							
							<c:if test="${sessionScope.userLoginInfo ne null && sessionScope.userLoginInfo.nickname eq radto.answer_nickname  }">
							&nbsp;&nbsp;
							<a href="${root }/reboard/boardAnswerDelete.do?answer_pk=${radto.answer_pk }&pageNum=${param.pageNum}&reboard_reboard_pk=${radto.reboard_reboard_pk}">삭제</a>
							</c:if>
							<br> &nbsp;&nbsp;${radto.answer_content } <br>
						</c:forEach>
				</c:if>
				<!-- 로그인한경우에만 -->
				<c:if test="${sessionScope.userLoginInfo ne null }">
					<form action="${root }/reboard/boardAnswerInsert.do" method="post">
						<textarea name="answer_content"></textarea>
						<!-- hidden -->
						<input type="hidden" name="answer_nickname" value="${sessionScope.userLoginInfo.nickname }">
						<input type="hidden" name="pageNum" value="${param.pageNum }">
						<input type="hidden" name="reboard_reboard_pk" value="${dto.reboard_pk}">
						<button type="submit">등록</button>
					</form>
				</c:if>
				</td>
			</tr>
		</table>
		<div>
			<button type="button" onclick="location.href='reboardList.do?pageNum=${param.pageNum }'">목록</button>
			<c:if test="${sessionScope.userLoginInfo ne null }">
			<button type="button" onclick="location.href='reboardform.do?reboard_pk=${dto.reboard_pk}&groupno=${dto.groupno}&restep=${dto.restep}&relevel=${dto.relevel}&pageNum=${pageNum}'">답글</button>
			</c:if>
			<c:if test="${dto.user_info_email eq sessionScope.userLoginInfo.user_Email }">
			<button type="button" onclick="location.href='reboardListUpdateform.do?reboard_pk=${dto.reboard_pk}&pageNum=${param.pageNum }'">수정</button>
			<button type="button" onclick="location.href='reboardListDelete.do?reboard_pk=${dto.reboard_pk}&pageNum=${param.pageNum }'">삭제</button>
			</c:if>
		</div>
	</div>
</body>
</html>