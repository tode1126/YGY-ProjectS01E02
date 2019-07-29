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
<script type="text/javascript" src="${root }/js/admin/adminRedirectJs.js"></script>
<script type="text/javascript" src="${root }/js/admin/allFoodListJs.js"></script>
</head>
<body>
	<c:if
		test="${empty sessionScope.userLoginInfo or sessionScope.userLoginInfo.user_grade ne 3 }">
		<script type="text/javascript">
			adminCheck();
		</script>
	</c:if>
	<c:if
		test="${not empty sessionScope.userLoginInfo and sessionScope.userLoginInfo.user_grade eq '3'  }">
		<div id="userListLayout">
			<h2>식당 목록</h2>
			<div id="searchUser">
				<form action="searchLeaveFoodList.do" method="post">
					<input id="targetEmail" name="targetEmail" type="text"
						placeholder="회원 이메일" size="30">&nbsp;&nbsp;
					<button class="blue button">식당 검색</button>
				</form>
			</div>
			<div style="clear: both;"></div>
			<div class="page">
				<table id="userList">
					<tr>
						<th width="80">번호</th>
						<th width="150">이메일</th>
						<th width="150">식당명</th>
						<th width="80">분류</th>
						<th width="150">휴대폰</th>
						<th width="180">주소</th>
						<th width="80">여는시간</th>
						<th width="80">닫는시간</th>
						<th width="80">상태</th>
						<th width="150">가입일</th>
					</tr>
					<c:if test="${not empty list }">
						<c:forEach items="${list }" var="dto" varStatus="i">
							<tr>
								<td align="center">${no - i.index }</td>
								<td>${dto.user_info_email }</td>
								<td>${dto.rest_name }</td>
								<td>${dto.rest_category}</td>
								<td align="center">${dto.rest_phone }</td>
								<td>${dto.rest_addr }</td>
								<td>${dto.rest_start }</td>
								<td>${dto.rest_end }</td>
								<td>
								<select class="state" rest_pk="${dto.rest_pk }" pageNum="${currentPage }">
									<option <c:if test="${dto.state eq 0 }">selected</c:if> value="0">정상</option>
									<option <c:if test="${dto.state eq 1 }">selected</c:if> value="1">휴무</option>
									<option <c:if test="${dto.state eq 2 }">selected</c:if> value="2">탈퇴</option>
								</select></td>
								<fmt:formatDate var="date" value="${dto.regday }" pattern="yyyy년 MM월 dd일" />
								<td align="center">${date }</td>
						</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
			<div class="pageNum">
				<c:if test="${not empty list }">
					<c:if test="${startPage > 1 }">
						<div>
							<a href="leaveFoodList.do?pageNum=${startPage-1 }">◀</a>
						</div>
					</c:if>

					<c:forEach var="pp" begin="${startPage }" end="${endPage }">
						<c:if test="${pp eq currentPage }">
							<div>
								<a href="leaveFoodList?pageNum=${pp }"
									style="color: red; font-size: bold;">${pp }</a>
							</div>
						</c:if>
						<c:if test="${pp ne currentPage }">
							<div>
								<a href="leaveFoodList?pageNum=${pp }"
									style="color: black;">${pp }</a>
							</div>
						</c:if>
					</c:forEach>

					<c:if test="${endPage<totalPage }">
						<div>
							<a href="leaveFoodList?pageNum=${endPage+1 }">▶</a>
						</div>
					</c:if>
				</c:if>
			</div>
		</div>
	</c:if>
</body>
</html>