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
<link rel="stylesheet" href="${root }/css/layout/reboardStyle.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Cute+Font" rel="stylesheet">
</head>
<body>
<div class="Point">
	전체 총<strong>${totalCount}</strong>건
</div>
<div>
	<button class="btn btn-info btn-sm" 
  		onclick="location.href='reboardform.do'">글쓰기</button>
</div>
<form name="quickSrchForm" id="quickSrchForm" method="post" action onsubmit="return false;">
	<div class="QuickSrch">
		<input type="text" name="TTL" id="TTl" value placeholder="제목 검색"
			onkeypress="if(event.keyCode==13) {quickSearch(); return false;}">
		<button title="검색" onclick="quickSearch();">
			<img src="../image/Seo_btn_search.png" alt="검색">
		</button>
	</div>
</form>

<div class="Boardlist">
	<table class="table table-bordered">
		<br>
		<tr style="background: #f5ftdc;">
			<th style="width: 70px; text-align: center">번호</th>
			<th style="width: 100px; text-align: center">별점</th>
			<th style="width: 200px; text-align: center">제목</th>
			<th style="width: 70px; text-align: center">작성자</th>
			<th style="width: 100px; text-align: center">작성일</th>
			<th style="width: 50px; text-align: center">조회</th>		
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td align="center">${no}</td>
				<c:set var="no" value="${no-1}"/>
				<td align="center">${dto.reboard_rating}</td>
				<td>
				<a href="content.do?num=${dto.reboard_pk}&pageNum=${currentPage}">
					${dto.reboard_subject}</a>
				</td>
				<td align="center">${dto.user_info_nickname}</td>
				<td align="center">
					<fmt:formatDate value="${dto.reboard_writedate}"
					   pattern="yyyy-MM-dd"/>
				</td>
				<td align="center">${dto.readcount}</td>
			</tr>
		</c:forEach>	
	</table>
	
	<!-- 페이지 번호 출력 -->
<div class="PageNum" style="width: 600px;text-align: center;">
	<ul class="Pagination">
		<c:if test="${startPage>1}">
			<li>
				<a href="reboardlist.do?pageNum=${startPage-1}">◀</a>
			</li>
		</c:if>
		<c:forEach var="pp" begin="${startPage}" end="${endPage}">
			<li>
			  <c:if test="${pp==currentPage}">
				<a href="reboardlist.do?pageNum=${pp}" style="color: red;">${pp}</a>
			  </c:if>
			  <c:if test="${pp!=currentPage}">
				<a href="reboardlist.do?pageNum=${pp}" style="color: black;">${pp}</a>
			  </c:if>	
			</li>
		</c:forEach>
		<c:if test="${endPage<totalPage}">	
			<li>
				<a href="reboardlist.do?pageNum=${endPage+1}">▶</a>
			</li>
		</c:if>
	</ul>
</div>
</div>
</body>
</html>