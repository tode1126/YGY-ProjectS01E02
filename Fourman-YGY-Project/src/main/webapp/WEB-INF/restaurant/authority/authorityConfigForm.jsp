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
<form action="menuAdd.do" method="post">
	<table border="1" style="width: 400px;">
		<tr>
			<th width="100">예약 가능 여부</th>
			<td width="200">
				<input type="radio" name="restaurant_authority_res" value="yes" /> 예약 가능
				<input type="radio" name="restaurant_authority_res" value="no" /> 예약 불가능
			</td>
		</tr>
		<tr>
			<th>예약 유예 시간</th>
			<td>
				<input type="text" name="restaurant_authority_res_time" placeholder="60분 이내로 숫자만 적어주세요" value="15">
			</td>
		</tr>
		<tr>
			<th>주문 가능 여부</th>
			<td>
				<input type="radio" name="restaurant_authority_order" value="yes" /> 예약 가능
				<input type="radio" name="restaurant_authority_order" value="no" /> 예약 불가능
			</td>
		</tr>
		<tr>
			<th>결제 가능 여부</th>
			<td>
				<input type="radio" name="restaurant_authority_pay" value="yes" /> 예약 가능
				<input type="radio" name="restaurant_authority_pay" value="no" /> 예약 불가능
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="hidden" name="restaurant_rest_pk" value="${restaurant_rest_pk }">
				<button style="width: 100px;" type="submit">
					저장하기
				</button>
				<button style="width: 100px;" type="button" onclick="history.back();">
					뒤로가기
				</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>