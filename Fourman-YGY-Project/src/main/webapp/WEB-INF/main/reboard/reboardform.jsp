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
<div class="BoardWrite">
	<form action="write.do" method="post">
		<table class="table-table-striped" style="width: 400px;">
			<caption style="text-align: center"><b>게시판 글쓰기</b></caption>
			<tr>
				<th style="width: 100px;">별점</th>
				<td>
					<input type="text" class="form-Control" name="reboard_rating">
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">제목</th>
				<td>
					<input type="text" class="form-Control" name="reboard_subject">
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">작성자</th>
				<td>
					<input type="text" class="form-Control" name="user_info_nickname">
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">이메일</th>
				<td>
					<input type="text" class="form-Control" name="user_info_email">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="5" cols="40" class="form-Control" name="reboard_content"></textarea>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button class="btn btn-default btn-lg"
				style="width: 100px;" type="submit">저장하기</button>
			</tr>
		</table>
	</form>
</div>
</body>
</html>