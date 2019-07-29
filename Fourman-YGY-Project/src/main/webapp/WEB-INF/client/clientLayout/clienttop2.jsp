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
<link rel="stylesheet" href="${root }/css/client/clientLayoutStyle.css"/>

</head>
<body>

    <br>
	<div id="Top_2">
	
	<table>
	
	<td width="500px;">
	
	<d><b>여기요</b>를 이용하시는 고객님을 위해<br> 최고의 서비스를 약속합니다. </d>
	
	</td>	
		
		  <td class="Top2Image">

			<a href="${root}/client/service.do"> <img src="${root}/image/client/K_ask.png"
				width="40">
				<b>1:1문의</b>
				
			</a> 
			&nbsp;&nbsp;&nbsp;
			<a href="${root}/answer/main.do"> <img src="${root}/image/client/K_F&Q.png"
				width="40" >
				<b>자주 묻는 질문</b>
			</a> 
			&nbsp;&nbsp;&nbsp;
			<a href="${root}/notice/noticemain.do"> <img src="${root}/image/client/K_notice.png"
				width="40">
				<b>공지사항</b>
			</a> 
			&nbsp;&nbsp;&nbsp;
			<a href="${root}/client/service.do"> <img src="${root}/image/client/K_service.png"
				width="40" >
				<b>이용안내</b>
			</a> 
			&nbsp;&nbsp;&nbsp;
			</td>
					
	     </table>
		
	</div>

	


</body>
</html>
