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
<link rel="stylesheet" href="${root }/css/Ji_Button_Style.css" />
<link rel="stylesheet" href="${root }/css/admin/topmenuAdminStyle.css" />
</head>
<body>
	<div class="menuLayer">
		<ul class="menu">
			<li><a href="${root}/admin/admin.do">Home</a></li>
			<li><a href="${root }/admin/userManagement/allUserList.do" id="current">회원관리</a>
				<ul>
					<li><a href="${root }/admin/userManagement/allUserList.do">전체회원</a></li>
					<li><a href="${root }/admin/userManagement/leaveUserList.do">탈퇴회원</a></li>
					<li><a href="${root }/admin/userManagement/allFoodUserList.do">전체기업회원</a></li>
					<li><a href="${root }/admin/userManagement/leaveFoodUserList.do">탈퇴기업회원</a></li>
				</ul>
			</li>
			<li><a href="${root }/admin/foodManagement/allFoodList.do">식당관리</a>
				<ul>
					<li><a href="${root }/admin/foodManagement/allFoodList.do">전체식당</a></li>
					<li><a href="${root }/admin/foodManagement/leaveFoodList.do">탈퇴식당</a></li>
				</ul>
			</li>
			<li><a href="#">게시판관리</a>
				<ul>
					<li><a href="#">이벤트관리</a></li>
					<li><a href="${root }/admin/notice_boardManagement/notice_boardList.do">공지관리</a></li>
					<li><a href="#">후기관리</a></li>
				</ul>
			</li>
			<li><a href="${root }/admin/adminManagement/adminList.do">관리자관리</a></li>
			<li><a href="${root }/admin/mailService/allMailSend.do">일괄메일</a></li>
		</ul>
	</div>
</body>
</html>