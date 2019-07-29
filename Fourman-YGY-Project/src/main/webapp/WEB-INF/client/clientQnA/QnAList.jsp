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
<link rel="stylesheet" href="${root }/css/admin/allUserListStyle.css">
<link rel="stylesheet"
	href="${root }/css/admin/notic_boardListStyle.css">
<script type="text/javascript"
	src="${root }/js/admin/adminRedirectJs.js"></script>
</head>
<body>
	<c:if test="${empty sessionScope.userLoginInfo }">
		<script type="text/javascript">
			adminCheck();
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.userLoginInfo  }">
		<div id="userListLayout">
			<button class="blue button" id="editButton"
				onclick="location.href='${root}/question/questionWrite.do?pageNum=${currentPage }'">문의
				작성</button>
			<h2>QnA 목록</h2>
			<div class="page">
				<table id="userList">
					<tr>
						<th width="80">번호</th>
						<th width="180">제목</th>
						<th width="100">작성자</th>
						<th width="180">작성일</th>
					</tr>
					<c:if test="${not empty list }">
						<c:forEach items="${list }" var="dto" varStatus="i">
							<c:if test="${dto.qna_ref eq '0'}">
								<tr>
									<td align="center">${no - i.index }</td>
									<td><a
										href="questionContent.do?qna_pk=${dto.qna_pk }&pageNum=${currentPage}">${dto.qna_subject }</a></td>
									<td align="center">${dto.qna_writer }</td>
									<fmt:formatDate var="date" value="${dto.qna_writeday }"
										pattern="yyyy년 MM월 dd일 HH시 mm분" />
									<td align="center">${date }</td>
								</tr>
							</c:if>
							<c:forEach items="${list }" var="dto2" varStatus="z">
								<c:if test="${dto2.qna_ref eq dto.qna_pk }">
									<tr>
										<td align="right">&nbsp;&nbsp;답변</td>
										<td><a
											href="questionContent.do?qna_pk=${dto2.qna_pk }&pageNum=${currentPage}">&nbsp;&nbsp;&nbsp;${dto2.qna_subject }</a></td>
										<td align="center">${dto2.qna_writer }</td>
										<fmt:formatDate var="date" value="${dto2.qna_writeday }"
											pattern="yyyy년 MM월 dd일 HH시 mm분" />
										<td align="center">${date }</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>
					</c:if>
				</table>
			</div>
			<div class="pageNum">
				<c:if test="${not empty list }">
					<c:if test="${startPage > 1 }">
						<div>
							<a href="questionList.do?pageNum=${startPage-1 }">◀</a>
						</div>
					</c:if>

					<c:forEach var="pp" begin="${startPage }" end="${endPage }">
						<c:if test="${pp eq currentPage }">
							<div>
								<a href="questionList.do?pageNum=${pp }"
									style="color: red; font-size: bold;">${pp }</a>
							</div>
						</c:if>
						<c:if test="${pp ne currentPage }">
							<div>
								<a href="questionList.do?pageNum=${pp }" style="color: black;">${pp }</a>
							</div>
						</c:if>
					</c:forEach>

					<c:if test="${endPage<totalPage }">
						<div>
							<a href="questionList.do?pageNum=${endPage+1 }">▶</a>
						</div>
					</c:if>
				</c:if>
			</div>
		</div>
	</c:if>
</body>
</html>