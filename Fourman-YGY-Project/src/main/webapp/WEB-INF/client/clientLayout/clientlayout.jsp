<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>   
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
<!-- 고정 메인화면  -->
<div id="Top" class="Layout">
	<tiles:insertAttribute name="top" />
</div>
<div id="Topmenu" class="Layout">
	<tiles:insertAttribute name="topmenu" />
</div>

<!-- 고객센터  메인화면  -->
<div id="ClientTop2" class="Layout">
   <tiles:insertAttribute name="top2"/>
</div>
<div id="ClientTop3" class="Layout">
   <tiles:insertAttribute name="top3"/>
</div>

<div class="MainLayout">

<div id="ClientLeftmenu" class="Layout MainLeft">
	<tiles:insertAttribute name="leftmenu"/>
</div>

<div id="ClientMain" class="Layout Mainright">
	<tiles:insertAttribute name="clientMain"/>
</div>

</div>



<div id="Bottom" class="Layout">
	<tiles:insertAttribute name="bottom" />
</div>

</body>
</html>









