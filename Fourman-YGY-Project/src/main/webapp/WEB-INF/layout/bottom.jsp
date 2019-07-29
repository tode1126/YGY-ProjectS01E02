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
<link rel="stylesheet" href="${root }/css/layout/bottomStyle.css"/>
</head>
<body>
<strong>
<div class="Footer">
	<div class="Footer-Menu"> 
		<ul>
			<li>
				<a href="${root }/company/companyIntro.do">회사소개</a>
			</li>
			<li>
				<a href="${root }/company/terms.do">이용약관</a>
			</li>
			<li>
				<a href="${root }/company/privacy.do">개인정보처리방침</a>
			</li>
			<li>
				<a href="${root }/company/notice.do">공지사항</a>
			</li>		
		</ul>
	</div>
	<div class="Company-Wrap">
		<div class="Company-Logo">
			<a>여기요</a>
		</div>
		<div class="Company-Info">
			<p>
				<strong>(주)에이콘이즈 에이콘아카데미 포맨</strong>
				<br>
				서울특별시 강남구 강남대로 94길 20, 3,4층
				<span class="Bar">|</span>
				대표자 : 서병효
				<span class="Bar">|</span>
				사업자등록번호:211-00-12345
				<a href="" target="_blank" class="Biz-Info">사업자정보확인</a>
				<br>
				통신판매업신고:제 2019-서울강남-3000호
				<span class="Bar">|</span>
				개인정보담당자:
				<a>privacy@yeogiyo.co.kr</a>
				<span class="Bar">|</span>
				제휴문의:
				<a>partnership@acornacademy.co.kr</a>
				<span class="Bar">|</span>
				고객만족센터:
				<a>support@yeogiyo.co.kr</a>
				<br>
				호스트서비스사업자:(주)샴플렉스인터넷
			</p>
		</div>			  	
	</div>
	<div class="Service-Info">
 		<div class="Bpg">
 			<a>
 				<span class="Img"></span>
 				<span class="Text">
 					여기요
 					<br>
 					안심센터
 				</span>
 			</a>
 		</div>
 		<div class="CleanReview">
 			<a>
 				<span class="Img"></span>
 				<span class="Text">
 					여기요 100%
 					<br>
 					클린리뷰
 				</span>
 			</a>
 		</div>
 		<div class="Csc">
 			<em>고객만족센터</em>
 			<strong>02-3333-5555</strong>
 			<span>24시간, 연중무휴</span>
 		</div>
	</div>
	<div class="Guide">
 		<p>
 			(주)에이콘이즈 에이콘아카데미 포맨은 통신판매중개자이며 통신판매의 당사자가 아닙니다.<br> 
 			따라서 상품/ 거래정보 및 거래와 관련하여 여기요에 등록된 판매자의 고의 또는 과실로 소비자에게 발생하는 손해에 대해 (주)에이콘이즈 에이콘아카데미 포맨은 책임을 지지 않습니다.<br> 
 			상품 및 거래에 관하여 보다 정확한 정보는 해당 판매자에게 직접 확인하여 주시기 바랍니다. Copyright YEOGIYO. All Rights Reserved.
 		</p>
	</div>
</div>
</strong>
</body>
</html>