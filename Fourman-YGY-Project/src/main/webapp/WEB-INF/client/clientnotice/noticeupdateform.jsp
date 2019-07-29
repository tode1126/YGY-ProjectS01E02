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
	<form action="noticeUpdateSuccess.do" method="post">
		<table>
		
			<caption><b>공지사항 수정</b></caption>
		
			<tr>
				<th style="width: 100px;">제목</th>
				<td>
					<input type="text" name="notice_subject" 
						value="${ndto.notice_subject}">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
				<textarea rows="50" cols="40" name="notice_content">${ndto.notice_content}</textarea>
			</tr>
			
			<tr>
				<td colspan="2">
				
					<!-- hidden list -->
					<input type="hidden" name="notice_pk" value="${ndto.notice_pk}">
					<input type="hidden" name="pageNum" value="${pageNum}">
					
					<button type="submit">수정하기</button>
					
					<button type="button"
						onclick="location.href='noticemain.do?pageNum=${pageNum}'">목록</button>
					
					<button type="button"
					onclick="history.back()">취소</button>
				</td>
				
			</tr>
			
		</table>
		
	</form>
	
</div>	

</body>
</html>