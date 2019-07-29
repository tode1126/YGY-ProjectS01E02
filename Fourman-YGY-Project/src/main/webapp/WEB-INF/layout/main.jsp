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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
</head>
<body>
main<br>
master<br>
add Hello dev(hotfix) check
<c:if test="${not empty param.gaip}">
	<script type="text/javascript">
	gaiptrue();
	</script>
</c:if>
<c:if test="${not empty param.userLeave }">
	<script type="text/javascript">
	userLeave();
	</script>
</c:if>
</body>
</html>