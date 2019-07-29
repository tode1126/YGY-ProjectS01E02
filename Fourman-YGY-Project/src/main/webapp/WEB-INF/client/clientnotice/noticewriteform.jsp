<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="noticeWrite.do" method="post">

	<table class="table table-striped" style="width: 400px;">
	
		<caption><b>공지사항 쓰기</b></caption>
		
		<tr>
			<th style="width: 100px;">작성자</th>
			<td>
				${admin }
			</td>
		</tr>
		
		<tr>
			<th style="width: 100px;">제 목</th>
			<td>
				<input type="text" name="notice_subject">
			</td>
		</tr>
		
		<tr>			
			<td colspan="2">
				<textarea rows="5" cols="40" name="notice_content"></textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button type="submit">저장하기</button>
			</td>
		</tr>
		
	</table>
	
</form>

</body>
</html>