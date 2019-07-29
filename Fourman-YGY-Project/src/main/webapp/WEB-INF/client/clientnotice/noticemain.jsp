<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
  총 <b>${totalCount }</b> 개의 글이 있습니다.
</div>
<br><br>

<div align="right">
  <button type="button" id="btndel">선택한글 삭제</button>
  
  <button 
  onclick="location.href='noticeWriteForm.do'">글쓰기</button>
  </div>

  <div>
  
	<table>
	
		<br>
		
		<tr style="background: #f5ftdc;">
			<th style="width: 70px; text-align: center">번호</th>
			<th style="width: 200px; text-align: center">제목</th>
			<th style="width: 70px; text-align: center">작성자</th>
			<th style="width: 100px; text-align: center">작성일</th>
			<th style="width: 50px; text-align: center">조회</th>		
		</tr>

		<c:forEach var="ndto" items="${list}">
		
			<tr>
				<td align="center">${no}</td>
				
				<c:set var="no" value="${no-1}"/>
				
				<td>
				<a href="noticeContent.do?num=${ndto.notice_pk}&pageNum=${currentPage}">
					${ndto.notice_subject}</a>
				</td>
				
				<td align="center">${admin}</td>
				
				<td align="center">
					<fmt:formatDate value="${ndto.notice_writedate}"
					   pattern="yyyy-MM-dd"/>
				</td>
				
				<td align="center">${ndto.notice_readcount}</td>
				
			</tr>
			
		</c:forEach>	
		
	</table>
	
	<!-- 페이지 번호 출력 -->
<div class="PageNum" style="width: 600px;text-align: center;">
	<ul class="Pagination">
		<c:if test="${startPage>1}">
			<li>
				<a href="noticemain.do?pageNum=${startPage-1}">◀</a>
			</li>
		</c:if>
		<c:forEach var="pp" begin="${startPage}" end="${endPage}">
			<li>
			  <c:if test="${pp==currentPage}">
				<a href="noticemain.do?pageNum=${pp}" style="color: red;">${pp}</a>
			  </c:if>
			  <c:if test="${pp!=currentPage}">
				<a href="noticemain.do?pageNum=${pp}" style="color: black;">${pp}</a>
			  </c:if>	
			</li>
		</c:forEach>
		<c:if test="${endPage<totalPage}">	
			<li>
				<a href="noticemain.do?pageNum=${endPage+1}">▶</a>
			</li>
		</c:if>
	</ul>
</div>

</div>

</body>
</html>

