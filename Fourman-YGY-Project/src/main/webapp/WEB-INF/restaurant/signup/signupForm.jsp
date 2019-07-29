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
<form action="signup.do" method="post">
	<table style="width: 400px;">
		<tr>
			<th>상호명</th>
			<td>
				<input type="text" name="rest_name">
			</td>
		</tr>
		<tr>
			<th>식당 분류</th>
			<td>
				<input type="text" name="rest_category">
			</td>
		</tr>
		<tr>
			<th>식당 번호</th>
			<td>
				<input type="text" name="rest_phone">
			</td>
		</tr>
		<tr>
			<th>식당 주소</th>
			<td>
				<input type="text" name="rest_addr">
			</td>
		</tr>
		<tr>
			<th>식당 시작 시간</th>
			<td>
				<input type="text" name="rest_start">
			</td>
		</tr>
		<tr>
			<th>식당 종료 시간</th>
			<td>
				<input type="text" name="rest_end">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="hidden" name="user_info_email" value="asdf@asd.com">
				<input type="hidden" name="rest_state" value=0>
				<button style="width: 100px;" type="submit">
					저장하기
				</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>