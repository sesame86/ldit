<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//${pageContext.request.contextPath}
%>
<!DOCTYPE html>
<html>
<!-- css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/einquire.css" /><!-- basic css -->
<head>
<meta charset="UTF-8">
<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

 
<!-- XMLHttpRequest 모듈 로딩 -->
<!-- <script type="text/javascript" src="/WebContent/js"></script>  -->

<title>조직도</title>
</head>
<body>
<%@ include file="../ldit_header.jsp"%>
<%@ include file="../ldit_aside.jsp"%>
	<h1>조직도</h1>
	${orlist}
</body>
</html>