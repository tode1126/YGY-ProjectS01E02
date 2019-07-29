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
<link rel="stylesheet" href="${root }/css/layout/companyIntroStyle.css"/>
<script type="text/javascript">
	$(function(){
		$(".Title").click(function() {
			$(".Intro-List").slideDown('slow');
		});
	});
	
	
</script>

</head>
<body>    
<div class="Company">
	<div class="Company-Intro">
		<h1 class="Title">회사소개</h1>
		<ul class="Intro-List">
			<li> 
			<a href="${root }/company/outline.do" class="List1">회사개요</a>
			</li>
			<br>
			<li> 
			<a href="${root }/company/vision.do" class="List2">비전</a>
			</li>
			<br>
			<li> 
			<a href="${root }/company/benefit.do" class="List3">Benefit</a>
			</li>
			<br>
			<li>
			<a href="${root }/company/place.do" class="List4">오시는길</a>
			</li>
		</ul>
		<button type="button" class="Btn Btn-Close">닫기</button>
	</div>	
</div>
</body>
</html>