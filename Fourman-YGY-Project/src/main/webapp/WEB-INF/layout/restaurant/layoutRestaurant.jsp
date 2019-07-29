<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="${root }/css/layout/layoutStyle.css"/>
</head>
<body>
<div id="top" class="layout">
	<tiles:insertAttribute name="top" />
</div>
<div id="topmenu" class="layout">
	<tiles:insertAttribute name="topmenu" />
</div>
<div id="main" class="layout">
	<tiles:insertAttribute name="main" />
</div>
<div id="bottom" class="layout">
	<tiles:insertAttribute name="bottom" />
</div>
</body>
</html>