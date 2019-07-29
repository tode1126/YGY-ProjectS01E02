<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/admin/allUserListStyle.css">
<script type="text/javascript" src="${root }/js/admin/adminRedirectJs.js"></script>
</head>
<body>
	<c:if test="${empty sessionScope.userLoginInfo or sessionScope.userLoginInfo.user_grade ne 3 }">
		<script type="text/javascript">
			adminCheck();
		</script>
	</c:if>
<c:if test="${not empty sessionScope.userLoginInfo and sessionScope.userLoginInfo.user_grade eq '3'  }">
<div id="userListLayout">
<h2>회원 목록</h2>
<div id="searchUser">
		<form action="searchFoodUser.do" method="post">
			<input id="targetEmail"name="targetEmail" type="text" placeholder="회원 이메일" size="30">&nbsp;&nbsp;
			<button class="blue button">회원 검색</button>
		</form>
</div>
<form method="post" action="allFoodUserList/userMultiDisable.do">
<div id="multipleButton">
	<input type="hidden" name="pageNum" value="${currentPage }">
	<button class="green button">다중 처리</button>
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
  				<th width="80">다중처리</th>
			</tr>
<c:if test ="${not empty list }">			
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
				<fmt:formatDate var="date" value="${dto.regday }" pattern="yyyy년 MM월 dd일"/>
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
				<td align="center"><input type="button" value="비활성화" class="red button" onclick="location.href='${root}/admin/userManagement/allFoodUserList/userDisable.do?targetEmail=${dto.email }&pageNum=${currentPage }'"></td>
				<td align="center"><input type="checkbox" name="multipleAction" value="${dto.email }"></td>
			</tr>
		</c:forEach>
</c:if>		
	</table>
</div> 
</form>
	<div class="pageNum">
<c:if test ="${not empty list }">	
			<c:if test="${startPage > 1 }">
				<div><a href="allFoodUserList.do?pageNum=${startPage-1 }">◀</a></div>
			</c:if>
			
			<c:forEach var="pp" begin="${startPage }" end="${endPage }">
				<c:if test="${pp eq currentPage }">
					<div><a href="allFoodUserList.do?pageNum=${pp }" style="color: red;font-size: bold;">${pp }</a></div>
				</c:if>
				<c:if test="${pp ne currentPage }">
					<div><a href="allFoodUserList.do?pageNum=${pp }" style="color: black;">${pp }</a></div>
				</c:if>
			</c:forEach>
			
			<c:if test="${endPage<totalPage }">
				<div><a href="allFoodUserList.do?pageNum=${endPage+1 }">▶</a></div>
			</c:if>
</c:if>			
	</div>
</div>
</c:if>
</body>
</html>