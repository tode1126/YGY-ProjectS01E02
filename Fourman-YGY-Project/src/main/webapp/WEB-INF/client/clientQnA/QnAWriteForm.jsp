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

<form action="questionWrite.do" method="post">

	<table>

		<caption><b> 1:1 문의 </b></caption>

		<tr>
			<th style="width: 100px;">작성자</th>
			<td>
				<input type="text" name="qna_writer">
			</td>
		</tr>

		<tr>
			<th style="width: 100px;">제 목</th>
			<td>
				<input type="text" name="qna_subject">
			</td>
		</tr>

		<tr>
		    <th style="width: 100px;">내 용</th>			
			<td colspan="2">
				<textarea rows="5" cols="40" name="qna_content"></textarea>
			</td>
		</tr>

		<tr>

		<input type="hidden" name="pna_pk" value="${qdto.qna_pk}">


			<td colspan="2" align="center">
				<button type="submit">저장하기</button>
			</td>
		</tr>

	</table>

</form>

</body>
</html> 