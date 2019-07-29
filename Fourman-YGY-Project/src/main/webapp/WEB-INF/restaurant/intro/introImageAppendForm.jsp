<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="../js/restaurant/intro/introImageAppendFormJs.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="./introImageAppend.do" method="post" enctype="multipart/form-data">
		<table width="600">
			<tr>
				<td>
					사진
				</td>
			</tr>
			<tr>
				<td>
					<input type="file" name="upfile" class="menu-insert-upfile" style="width: 200px;">
					<div class="select_img"><img src="" /></div>
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="restaurant_rest_pk" value="${restaurant_rest_pk }">
					<button style="width: 100px;" type="submit">
						저장하기
					</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>