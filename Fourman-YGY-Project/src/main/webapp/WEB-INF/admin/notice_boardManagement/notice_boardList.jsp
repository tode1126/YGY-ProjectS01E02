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
<link rel="stylesheet" href="${root }/css/admin/notic_boardListStyle.css">
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
<h2>공지 목록</h2>
<button class="blue button" id="editButton" onclick="location.href='${root}/admin/notice_boardManagement/notice_boardListEdit.do?pageNum=${currentPage }'">공지 작성</button>
<div class="page">
		  <table id="userList">
 			 <tr>
 			 	<th width="80">번호</th>
				<th width="180">제목</th>
				<th width="100">작성자</th>
				<th width="80">조회수</th>
				<th width="180">작성일</th>
				<th width="80">삭제</th>
			</tr>
<c:if test ="${not empty list }">			
  	<c:forEach items="${list }" var="dto" varStatus="i">
			<tr>
				<td align="center">${no - i.index }</td>
				<td><a href="notice_boardListContent.do?notice_pk=${dto.notice_pk }&pageNum=${currentPage}">${dto.notice_subject }</a></td>
				<td align="center">${dto.notice_writer }</td>
				<td align="center">${dto.notice_readcount }</td>
				<fmt:formatDate var="date" value="${dto.notice_writedate }" pattern="yyyy년 MM월 dd일 HH시 mm분"/>
				<td align="center">${date }</td>
				<td align="center"><input type="button" value="삭제" class="red button" onclick="location.href='${root}/admin/notice_boardManagement/notice_boardListDelete.do?notice_pk=${dto.notice_pk }&pageNum=${currentPage }'"></td>
			</tr>
		</c:forEach>
</c:if>		
	</table>
</div> 
	<div class="pageNum">
<c:if test ="${not empty list }">	
			<c:if test="${startPage > 1 }">
				<div><a href="notice_boardList.do?pageNum=${startPage-1 }">◀</a></div>
			</c:if>
			
			<c:forEach var="pp" begin="${startPage }" end="${endPage }">
				<c:if test="${pp eq currentPage }">
					<div><a href="notice_boardList.do?pageNum=${pp }" style="color: red;font-size: bold;">${pp }</a></div>
				</c:if>
				<c:if test="${pp ne currentPage }">
					<div><a href="notice_boardList.do?pageNum=${pp }" style="color: black;">${pp }</a></div>
				</c:if>
			</c:forEach>
			
			<c:if test="${endPage<totalPage }">
				<div><a href="notice_boardList.do?pageNum=${endPage+1 }">▶</a></div>
			</c:if>
</c:if>			
	</div>
</div>
</c:if>
</body>
</html>