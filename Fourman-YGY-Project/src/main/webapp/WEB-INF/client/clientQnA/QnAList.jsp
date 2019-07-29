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
</head>
<body>

<div>
  총 <b>${totalCount }</b> 개의 글이 있습니다.
</div>
<br><br>

<a href="${root}/question/questionWriteForm.do">문의하기</a>

  <div>

	<table>

		<br>

		<tr style="background: #f5ftdc;">
			<th style="width: 70px; text-align: center">번호</th>
			<th style="width: 200px; text-align: center">제목</th>
			<th style="width: 70px; text-align: center">작성자</th>
			<th style="width: 100px; text-align: center">작성일</th>		
		</tr>

		<c:forEach var="qdto" items="${list}">

			<tr>
				<td align="center">${no}</td>

				<c:set var="no" value="${no-1}"/>

				<td>
				<a href="questionContent.do?qna_pk=${qdto.qna_pk}&pageNum=${currentPage}">
					${qdto.qna_subject}</a>
				</td>

				<td align="center">${qdto.qna_writer}</td>

				<td align="center">
					<fmt:formatDate value="${qdto.qna_writeday}"
					   pattern="yyyy-MM-dd"/>
				</td>

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
				<a href="questionList.do?pageNum=${pp}" style="color: red;">${pp}</a>
			  </c:if>
			  <c:if test="${pp!=currentPage}">
				<a href="questionList.do?pageNum=${pp}" style="color: black;">${pp}</a>
			  </c:if>	
			</li>
		</c:forEach>
		<c:if test="${endPage<totalPage}">	
			<li>
				<a href="questionList.do?pageNum=${endPage+1}">▶</a>
			</li>
		</c:if>
	</ul>
</div>

</div>


</body>
</html> 