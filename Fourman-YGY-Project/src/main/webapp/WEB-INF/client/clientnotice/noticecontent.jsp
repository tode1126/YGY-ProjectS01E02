<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/admin/notic_boardListEditStyle.css">
<style type="text/css">

div.noticeEdit {
	font-family: sans-serif;
	font-size: 10px;
}

#notice_content {
	width: 96%;
	height: 300px;
	resize: none;
}

#backImg {
	cursor: pointer;
}

div.noticeEdit form {
	background: #fff;
	padding: 4em 4em 2em;
	max-width: 600px;
	height: 800px;
	max-height: 880px;
	margin: 50px auto 0;
	margin-bottom: 50px;
	box-shadow: 0 0 1em #222;
	border-radius: 2px;
}

div.noticeEdit form h2 {
	margin: 0 0 50px 0;
	padding: 10px;
	text-align: center;
	font-size: 30px;
	color: #666666;
	border-bottom: solid 1px #e5e5e5;
}

div.noticeEdit form p {
	margin: 0 0 3em 0;
	position: relative;
}

div.noticeEdit form input {
	display: block;
	box-sizing: border-box;
	width: 97%;
	outline: none;
	margin: 0;
}

div.noticeContent {
	display: block;
	box-sizing: border-box;
	width: 97%;
	outline: none;
	margin: 0;
	height: 300px;
	background: #fff;
	border: 1px solid #dbdbdb;
	font-size: 1.6em;
	padding: .8em .5em;
	border-radius: 2px;
	overflow-y: scroll;
}

div.noticeEdit form input[type="text"] {
	background: #fff;
	border: 1px solid #dbdbdb;
	font-size: 1.6em;
	padding: .8em .5em;
	border-radius: 2px;
}

div.noticeEdit form input[type="text"]:focus {
	background: #fff;
}

div.noticeEdit form input[type="submit"] {
	background: #4eb8dd;
	box-shadow: 0 3px 0 0 #ddf1fa;
	border-radius: 2px;
	border: none;
	color: #fff;
	cursor: pointer;
	display: block;
	font-size: 2em;
	line-height: 1.6em;
	margin: 2em 0 0;
	outline: none;
	padding: .8em 0;
	text-shadow: 0 1px #ddf1fa;
}

div.noticeEdit form input[type="submit"]:hover {
	background: #ddf1fa;
	text-shadow: 0 1px 3px rgba(70, 93, 41, 0.7);
}

div.noticeEdit form input[type="button"] {
	background: #4eb8dd;
	box-shadow: 0 3px 0 0 #ddf1fa;
	border-radius: 2px;
	border: none;
	color: #fff;
	cursor: pointer;
	display: block;
	font-size: 2em;
	line-height: 1.6em;
	margin: 2em 0 0;
	outline: none;
	padding: .8em 0;
	text-shadow: 0 1px #ddf1fa;
}

div.noticeEdit form input[type="button"]:hover {
	background: #ddf1fa;
	text-shadow: 0 1px 3px rgba(70, 93, 41, 0.7);
}

div.noticeEdit form label {
	position: absolute;
	left: 8px;
	top: 12px;
	color: #999;
	font-size: 16px;
	display: inline-block;
	padding: 4px 10px;
	font-weight: 400;
	background-color: rgba(255, 255, 255, 0);
	-moz-transition: color 0.3s, top 0.3s, background-color 0.8s;
	-o-transition: color 0.3s, top 0.3s, background-color 0.8s;
	-webkit-transition: color 0.3s, top 0.3s, background-color 0.8s;
	transition: color 0.3s, top 0.3s, background-color 0.8s;
}

div.noticeEdit form label.floatLabel {
	top: -11px;
	background-color: rgba(255, 255, 255, 0.8);
	font-size: 14px;
}
</style>
</head>
<body>
		<div class="noticeEditLayer" >
			<div class="noticeEdit" >
					<p>
						<img id="backImg" src="${root }/image/admin/return-to-the-past.png" onclick="history.back();" width="30">
					</p>
					<h2>공지 내용</h2>
					<p>
						<label for="notice_writer" class="floatLabel">작성자</label>
						<input name="notice_writer" type="text" value="공지사항 관리자" readonly="readonly">
					</p>
					<p>
						<label for="notice_subject" class="floatLabel">제 목</label>
						<input name="notice_subject" type="text" value="${dto.notice_subject}" readonly="readonly">
					</p>
						<div class="noticeContent">
							${dto.notice_content }
						</div>
			</div>
		</div>
</body>
</html>