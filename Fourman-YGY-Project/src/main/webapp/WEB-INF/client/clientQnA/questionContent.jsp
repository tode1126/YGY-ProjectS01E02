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
				${qdto.qna_subject}
				<span>
					<fmt:formatDate value="${qdto.qna_writeday}"
						pattern="yyyy-MM-dd HH:mm"/>
				</span>		
			</th>

		</tr>

		<tr>

			<td>
				작성자 : ${qdto.qna_writer}

				<br><br>

				<span>
				<textarea readonly="readonly">${qdto.qna_content}</textarea>
				</span>	

			</td>

		</tr>

	</table>

	<div> 	
		<button type="button"
			onclick="location.href='questionList.do?pageNum=${pageNum}'">목록</button>

		<button type="button"
		  onclick="location.href='questionWriteForm.do'">글쓰기</button>

		 <button type="button"
		  onclick="location.href='questionAnswerForm.do?qna_pk=${qdto.qna_pk}&pageNum=${pageNum}'">답글쓰기</button>  

		<button type="button"
		  onclick="location.href='questionUpdate.do?num=${qdto.qna_pk}&pageNum=${pageNum}'">수정</button>

		<button type="button"
		  onclick="location.href='questionDelete.do?num=${qdto.qna_pk}&pageNum=${pageNum}'">삭제</button>  		
	</div>
</div>

</body>
</html> 