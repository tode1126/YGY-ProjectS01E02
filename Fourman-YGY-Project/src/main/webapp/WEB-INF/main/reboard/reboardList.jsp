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
<link rel="stylesheet" href="${root }/css/reboard/reboardlistStyle.css">
<link rel="stylesheet" href="${root }/css/Ji_Button_Style.css">
<link rel="stylesheet" href="${root }/css/reboard/starRev.css" />
<script type="text/javascript"
	src="${root }/js/admin/adminRedirectJs.js"></script>
</head>
<body>
	<div id="reboardListLayout">
		<h2 align="center">후기 목록</h2>
<!-- 		<div id="searchUser">
			<form action="#" method="post">
				<input id="targetSubject" name="targetSubject" type="text"
					placeholder="제목 검색" size="30">&nbsp;&nbsp;
				<button class="blue button">검색</button>
			</form>
		</div> -->
		<button class="green button" id="editButton"
			onclick="location.href='${root}/reboard/reboardform.do?pageNum=${currentPage }'">후기
			작성</button>
		<form method="post" action="allUserList/userMultiDisable.do">
			<div class="page">
				<table id="reboardList">
					<tr style="background: #f5ftdc;">
						<th width="70px">번호</th>
						<th width="100px">별점</th>
						<th width="200px">제목</th>
						<th width="70px">작성자</th>
						<th width="100px">작성일</th>
						<th width="50px">조회</th>
					</tr>
					<c:if test="${not empty list }">
						<c:forEach items="${list }" var="dto" varStatus="i">
							<tr>
								<td align="center">${no}</td>
								<c:set var="no" value="${no-1}" />
								<td align="center">
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
								<td>
								
									<c:forEach var="sp" begin="1" end="${dto.relevel }">
									&nbsp;&nbsp;
									</c:forEach> 
									<c:if test="${dto.relevel>0 }">
										<img width="15"
											src="${root }/image/reboard/iconmonstr-arrow-54-64.png">
									</c:if>
									<c:if test="${dto.state ne 1 }">
									<a href="reboardListSelectContent.do?reboard_pk=${dto.reboard_pk}&pageNum=${currentPage}">
										${dto.reboard_subject}</a>
									</c:if>
									<c:if test="${dto.state eq 1 }">
										${dto.reboard_subject}
									</c:if>
									<c:if test="${dto.answerCount ne 0 }">
										<a href="#" style="color: red; text-decoration: none;">[${dto.answerCount }]</a>
									</c:if> 
									
								</td>
								<td align="center">${dto.user_info_nickname}</td>
								<td align="center"><fmt:formatDate
										value="${dto.reboard_writedate}" pattern="yyyy-MM-dd" /></td>
								<td align="center">${dto.readcount}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>

			</div>
		</form>
		<div class="pageNum">
			<c:if test="${not empty list }">
				<c:if test="${startPage > 1 }">
					<div>
						<a href="reboardList.do?pageNum=${startPage-1 }">◀</a>
					</div>
				</c:if>

				<c:forEach var="pp" begin="${startPage }" end="${endPage }">
					<c:if test="${pp eq currentPage }">
						<div>
							<a href="reboardList.do?pageNum=${pp }"
								style="color: red; font-size: bold;">${pp }</a>
						</div>
					</c:if>
					<c:if test="${pp ne currentPage }">
						<div>
							<a href="reboardList.do?pageNum=${pp }" style="color: black;">${pp }</a>
						</div>
					</c:if>
				</c:forEach>

				<c:if test="${endPage<totalPage }">
					<div>
						<a href="reboardList.do?pageNum=${endPage+1 }">▶</a>
					</div>
				</c:if>
			</c:if>
		</div>
	</div>
</body>
</html>