<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<link rel="stylesheet" href="${root }/css/layout/reboardStyle.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Cute+Font" rel="stylesheet">

<script type="text/javascript">
	$(function() {
		$("img.heart").hide();
		$("span.reboard_happy").click(function() {
			var num=$(this).attr("num")
			//alert(num);
			var n=$(this);
			//하트이미지 나타났다가 사라지는 애니메이션
			$(n).next().show('fast').animate({
				"width":"+=20px"}).hide('fast');
			
			$.ajax({
				type:'get',
				url:"happy.aj",
				data:{"num":num},
				dataType:"json",
				success:function(redata){	
					console.log(redata.reboard_happy);
					$(n).text(redata.reboard_happy);	 	
				},
				error:function(err){
					alert("errorcode:"+err.status);//에러코드출력
					//200: 응답페이지오류:chudata.jsp 문제
					//404: 매핑오류거나 jsp 를 못찾거나
					//500: 문법오류
				}
			});
		});
	});
</script>
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
  					 class="Chu" num="${dto.reboard_pk}">${dto.reboard_unhappy}</span></span>	 
				<span><pre style="height:200px; margin-top: 20px;">${dto.reboard_content}</pre></span>		
			</td>
		</tr>
	</table>
	<div style="margin-left: 170px; margin-bottom: 20px;"> 	
		<button type="button" class="btn btn-info btn-sm" style="width: 80px"
			onclick="location.href='reboardlist.do?pageNum=${pageNum}'">목록</button>
			
		<button type="button" class="btn btn-danger btn-sm" style="width: 80px;"
		  onclick="location.href='reboardform.do'">글쓰기</button>  
		
		<button type="button" class="btn btn-success btn-sm" style="width: 80px;"
		  onclick="location.href='reboardupdate.do?num=${dto.reboard_pk}&pageNum=${pageNum}'">수정</button>
		
		<button type="button" class="btn btn-warning btn-sm" style="width: 80px;"
		  onclick="location.href='delete.do?num=${dto.reboard_pk}&pageNum=${pageNum}'">삭제</button>  		
	</div>
</div>

</body>
</html>