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

	<table>
	
		<tr>
		
			<th>
				${ndto.notice_subject}
				<span>
					<fmt:formatDate value="${ndto.notice_writedate}"
						pattern="yyyy-MM-dd HH:mm"/>
				</span>		
			</th>
			
		</tr>
		
		<tr>
		
			<td>
				작성자 : ${admin}
				
				<span>
				조회 ${ndto.notice_readcount}
				</span>
				
				<br><br>

				<span>
				<pre>${ndto.notice_content}</pre>
				</span>	
					
			</td>
			
		</tr>
		
	</table>
	
	<div> 	
		<button type="button"
			onclick="location.href='noticemain.do?pageNum=${pageNum}'">목록</button>
			
		<button type="button"
		  onclick="location.href='noticeWriteForm.do'">글쓰기</button>  
		
		<button type="button"
		  onclick="location.href='noticeUpdate.do?num=${ndto.notice_pk}&pageNum=${pageNum}'">수정</button>
		
		<button type="button"
		  onclick="location.href='noticeDelete.do?num=${ndto.notice_pk}&pageNum=${pageNum}'">삭제</button>  		
	</div>
</div>

</body>
</html>