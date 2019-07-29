<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="./introTextUpdate.do" method="post">
		<table width="600">
			<tr>
				<th>
					식당 소개란
				</th>
			</tr>
			<tr>
				<td>
					내용
				</td>
			</tr>
			<tr>
				<td>
					<textarea name="intro_text" style="width: 590px; height: 300px;">${ridto.intro_text }</textarea>
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="restaurant_rest_pk" value="${ridto.restaurant_rest_pk }">
					<button style="width: 100px;" type="submit">
						저장하기
					</button>
					<button type="button" style="width: 100px;" onclick="history.back()">
						취소
					</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>