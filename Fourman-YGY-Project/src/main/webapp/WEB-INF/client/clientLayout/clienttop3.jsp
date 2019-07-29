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

<script type="text/javascript">
    
</script>

<c:set var="root" value="<%=request.getContextPath()%>"></c:set>


</head>
<body>

<ul>
 <li><div id="Top3Detail"><b>${menu }</b></div></li>
 <li><img src="${root}/image/client/K_call.png" width="20px"> 전화상담 : 02) 2189-3900</li>
 <li><img src="${root }/image/client/K_ask.png" width="20px"> 1:1문의 : 월-금 09:00-18:00</li>
 <%-- <li><img src="${root }/image/client/K_time.png" width="20px"> 주문마감시간 : 당일 14시 이후 주문은 익일 출고</li>  --%>

</ul>


</body>
</html>
