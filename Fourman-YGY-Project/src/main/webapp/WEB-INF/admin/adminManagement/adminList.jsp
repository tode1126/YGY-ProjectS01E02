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
<link rel="stylesheet" href="${root }/css/admin/adminListStyle.css">
<link rel="stylesheet" href="${root }/css/admin/allUserListStyle.css">
<script type="text/javascript"
	src="${root }/js/admin/adminRedirectJs.js"></script>
</head>
<body>
	<c:if test="${empty sessionScope.userLoginInfo or sessionScope.userLoginInfo.user_grade ne 3}">
		<script type="text/javascript">
			adminCheck();
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.userLoginInfo and sessionScope.userLoginInfo.user_grade eq '3' and not empty list}">
		<div id="userListLayout">
			<h2>관리자 목록</h2>
			<div id="addAdmin">
				<form action="adminUpdate.do" method="post">
					<input  id="targetEmail" name="targetEmail" type="text" placeholder="관리자 추가 이메일"
						size="30">&nbsp;&nbsp;
					<button class="blue button">관리자 추가</button>
				</form>
			</div>
			<div style="clear: both;">
			</div>
			<div class="page">
				<table id="userList">
					<tr>
						<th width="80">번호</th>
						<th width="150">이메일</th>
						<th width="150">닉네임</th>
						<th width="150">휴대폰</th>
						<th width="80">회원상태</th>
						<th width="180">가입일</th>
						<th width="80">회원등급</th>
						<th width="80">비활성화</th>
					</tr>
					<c:forEach items="${list }" var="dto" varStatus="i">
						<tr>
							<td align="center">${no - i.index }</td>
							<td>${dto.email }</td>
							<td>${dto.nickName }</td>
							<td align="center">${dto.hp }</td>
							<c:if test="${dto.state eq 1 }">
								<td align="center">인증</td>
							</c:if>
							<c:if test="${dto.state eq 0 }">
								<td align="center">대기</td>
							</c:if>
							<c:if test="${dto.state eq 2 }">
								<td align="center">탈퇴</td>
							</c:if>
							<fmt:formatDate var="date" value="${dto.regday }"
								pattern="yyyy년 MM월 dd일" />
							<td align="center">${date }</td>
							<c:if test="${dto.grade eq 1 }">
								<td align="center">일반</td>
							</c:if>
							<c:if test="${dto.grade eq 2 }">
								<td align="center">식당</td>
							</c:if>
							<c:if test="${dto.grade eq 3 }">
								<td align="center">관리자</td>
							</c:if>
							<td align="center">
							<input type="button" value="일반회원전환" class="red button" onclick="location.href='${root}/admin/adminManagement/userUpdate.do?targetEmail=${dto.email }&pageNum=${currentPage }'">
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="pageNum">
				<c:if test="${startPage > 1 }">
					<div>
						<a href="adminList.do?pageNum=${startPage-1 }">◀</a>
					</div>
				</c:if>

				<c:forEach var="pp" begin="${startPage }" end="${endPage }">
					<c:if test="${pp eq currentPage }">
						<div>
							<a href="adminList.do?pageNum=${pp }"
								style="color: red; font-size: bold;">${pp }</a>
						</div>
					</c:if>
					<c:if test="${pp ne currentPage }">
						<div>
							<a href="adminList.do?pageNum=${pp }" style="color: black;">${pp }</a>
						</div>
					</c:if>
				</c:forEach>

				<c:if test="${endPage<totalPage }">
					<div>
						<a href="adminList.do?pageNum=${endPage+1 }">▶</a>
					</div>
				</c:if>
			</div>
		</div>
	</c:if>
</body>
</html>