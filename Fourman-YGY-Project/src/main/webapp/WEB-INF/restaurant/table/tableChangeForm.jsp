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
	<form action="./tableChange.do" method="post">
		<table width="600">
			<tr>
				<th>
					식당 테이블 수
				</th>
			</tr>
			<tr>
				<td>
					<input type="text" name="number-of-table" style="width: 590px;">
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="restaurant_rest_pk" value="${restaurant_rest_pk }">
					<button style="width: 100px;" type="submit">
						저장하기
					</button>
					<button style="width: 100px;" type="button" onclick="history.go(-1)">
						취소
					</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>