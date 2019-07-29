<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="../js/restaurant/menu/menu-update-formJS.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="menuUpdate.do" method="post" enctype="multipart/form-data">
	<table border="1" style="width: 400px;">
		<tr>
			<th width="100">카테고리명</th>
			<td width="200">
				<input type="text" name="menu_category" value="${dto.menu_category }">
			</td>
		</tr>
		<tr>
			<th>메뉴명</th>
			<td>
				<input type="text" name="menu_name" value="${dto.menu_name }">
			</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>
				<input type="text" name="menu_price" value="${dto.menu_price }">
			</td>
		</tr>
		<tr>
			<th colspan="2">메뉴 설명</th>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="menu_desc" class="menu_desc">${dto.menu_desc }</textarea>
			</td>
		</tr>
		<tr>
			<th>메뉴 사진</th>
			<td>
				<input type="file" name="upfile" class="menu-update-upfile" style="width: 200px;">
				<div class="select_img">
					<%-- <img src="${dto.menu_image_realpath+dto.menu_image_realname }" /> --%>
					<img src="<c:out value='../save/restaurant/menu/${dto.restaurant_rest_pk }/${dto.menu_image_realname}'/>" 
						style="width:300px;" />
					<%-- <c:out value="${dto.menu_image_realpath}\\${dto.menu_image_realname}" /> --%>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="hidden" name="menu_pk" value="${dto.menu_pk }">
				<input type="hidden" name="restaurant_rest_pk" value="${dto.restaurant_rest_pk }">
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