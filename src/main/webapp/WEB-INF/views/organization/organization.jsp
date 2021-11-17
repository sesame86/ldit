<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//${pageContext.request.contextPath}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- XMLHttpRequest 모듈 로딩 -->
<script type="text/javascript" src="/WebContent/js"></script> 
<title>조직도</title>
</head>
<body>
	<h1>조직도</h1>
	<label>인사부</label>
	<label>aa</label>
	${orlist }
</body>
</html>