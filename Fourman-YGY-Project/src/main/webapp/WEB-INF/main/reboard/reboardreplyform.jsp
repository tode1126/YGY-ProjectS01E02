<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/layout/reboardStyle.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Cute+Font" rel="stylesheet">

<!-- <script type="text/javascript">
	$(document).ready(function() {
		$("#btnSave").click(function(){
			var reboard_subject = $("#reboard_subject").val();
			var user_info_nickname = $("#user_info_nickname").val();
			var user_info_email = $("#user_info_email").val();
			var reboard_content = $("#reboard_content").val();
			
			if(reboard_subject == ""){
				alert("제목을 입력하세요");
				document.form1.reboard_subject.focus();
				return;
			}
			if(user_info_nickname == ""){
				alert("이름을 입력하세요");
				document.form1.user_info_nickname.focus();
				return;
			}
			if(user_info_email == ""){
				alert("이메일을 입력하세요");
				document.form1.user_info_email.focus();
				return;
			}
			if(reboard_content == ""){
				alert("내용을 입력하세요");
				document.form1.reboard_content.focus();
				return;
			}
			// 폼에 입력한 데이터를 서버로 전송
			document.form1.submit();
		});
	});
</script> -->

</head>
<body>
<div class="BoardReply">
	<form name="form1" action="reply.do" method="post">
		<table class="table-table-striped" style="width: 400px;">
			<caption style="text-align: center"><b>게시판 글쓰기</b></caption>
			<tr>
				<th style="width: 100px;">제목</th>
				<td>
					<input type="text" class="form-Control" name="reboard_subject" id="reboard_subject">
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">작성자</th>
				<!-- 로그인했을 경우 게시판의 이름 부분의 닉네임을 세팅한다 -->
				<c:if test="${sessionScope.userLoginInfo!=null}">
					<td>
						${sessionScope.userLoginInfo!=null}	
						<input type="hidden" class="form-Control" name="user_info_nickname" 
						id="user_info_nickname" value="${empty sessionScope.userLoginInfo}">
					</td>
				</c:if>
				<c:if test="${sessionScope.userLoginInfo!=null}"> 
					<td>
						<input type="hidden" class="form-Control" name="user_info_nickname" 
							id="user_info_nickname">
					</td>
				</c:if>
			</tr>
			<tr>
				<th style="width: 100px;">이메일</th>
				<td>
					<input type="text" class="form-Control" name="user_info_email" id="user_info_email">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="5" cols="40" class="form-Control" name="reboard_content" id="reboard_content"></textarea>
			</tr>
			<tr>
				<td colspan="2" align="center">			
				<button type="submit" id="btnSave">등록</button>
				<button type="reset" 
					onclick="location.href='reboardlist.do?pageNum=${pageNum}'">취소</button>
			</tr>
		</table>
	</form>
</div>
</body>
</html>