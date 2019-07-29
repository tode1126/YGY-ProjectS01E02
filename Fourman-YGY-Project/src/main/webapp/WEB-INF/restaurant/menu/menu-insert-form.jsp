<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="../js/restaurant/menu/menu-insert-formJS.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="menuAdd.do" method="post" enctype="multipart/form-data">
	<table border="1" style="width: 400px;">
		<tr>
			<th width="100">카테고리명</th>
			<td width="200">
				<input type="text" name="menu_category">
			</td>
		</tr>
		<tr>
			<th>메뉴명</th>
			<td>
				<input type="text" name="menu_name">
			</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>
				<input type="text" name="menu_price">
			</td>
		</tr>
		<tr>
			<th colspan="2">메뉴 설명</th>			
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="menu_desc" class="menu_desc"></textarea>
			</td>
		</tr>
		<tr>
			<th>메뉴 사진</th>
			<td>
				<input type="file" name="upfile" class="menu-insert-upfile" style="width: 200px;">
				<div class="select_img"><img src="" /></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
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