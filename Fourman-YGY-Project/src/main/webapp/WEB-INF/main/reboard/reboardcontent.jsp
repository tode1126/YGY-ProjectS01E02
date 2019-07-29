<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/reboard/reboardStyle.css"/>
<link rel="stylesheet" href="${root }/css/reboard/starRev.css"/>
<script type="text/javascript" src="${root }/js/reboard/starRev.js"></script>
<script type="text/javascript" src="${root }/js/reboard/delete.js"></script>
<script type="text/javascript" src="${root }/js/reboard/happy.js"></script>
<script type="text/javascript" src="${root }/js/reboard/unhappy.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Cute+Font" rel="stylesheet">

</head>
<body>
<div class="BoardContent">
	<table style="width: 500px; margin-left: 80px;" class="table table-boardered">
		<tr>
			<th>
				${dto.reboard_subject}
				<span style="margin-left: 300px; color: gray;">
					<fmt:formatDate value="${dto.reboard_writedate}"
						pattern="yyyy-MM-dd HH:mm"/>
				</span>		
			</th>
		</tr>
		<tr height="250">
			<td valign="top">
				작성자 : ${dto.user_info_nickname} (${dto.user_info_email})
				<span style="margin-left: 280px; color: gray">
				조회 ${dto.readcount}</span>
				<br><br>
				<span>별점 : ${dto.reboard_rating}</span>
				
				<span style="margin-left: 300px;">좋아요
  				<span style="color: red;font-weight: bold;cursor: pointer;"
  					 class="reboard_happy" num="${dto.reboard_pk}">${dto.reboard_happy}</span>
  					 <img src="../image/Seo_heart.png" width="30" class="heart"></span>
  					 
  				<span style="margin-left: 5px;">싫어요 
  				<span style="color: blue;font-weight: bold;cursor: pointer;"
  					 class="reboard_unhappy" num="${dto.reboard_pk}">${dto.reboard_unhappy}</span>
  					 <img src="../image/Seo_no.png" width="30" class="no"></span>
  					 	 
				<span><pre style="height:200px; margin-top: 20px;">${dto.reboard_content}</pre></span>		
			</td>
		</tr>
	</table>
	<div style="margin-left: 170px; margin-bottom: 20px;"> 	
		<button type="button" class="btn btn-info btn-sm" style="width: 80px"
			onclick="location.href='reboardlist.do?pageNum=${pageNum}'">목록</button>
			
		<button type="button" class="btn btn-danger btn-sm" style="width: 80px;"
		  onclick="location.href='reboardwrite.do'">글쓰기</button>  
		
		<button type="button" class="btn btn-success btn-sm" style="width: 80px;"
		  onclick="location.href='reboardupdate.do?num=${dto.reboard_pk}&pageNum=${pageNum}'">수정</button>
		
		<button type="button" class="btn btn-warning btn-sm" id="btnDelete" style="width: 80px;"
		  onclick="location.href='delete.do?num=${dto.reboard_pk}&pageNum=${pageNum}'">삭제</button>
		
		<button type="button" class="btn btn-info btn-sm" id="btnWrite" style="width: 80px;"
		  onclick="location.href='reply.do?num=${dto.reboard_pk}&pageNum=${pageNum}'">답글</button>
		    		
	</div>
</div>

</body>
</html>