<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<!-- 이모티콘 -->
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/msgInformation.css" /><!-- msgInformation css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>쪽지 상세 정보</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	<h1>쪽지 상세 내용</h1>
	<c:forEach var="vo" items="${mlist}">
		<div id="Msg1" class="information">
			<label class="inf">제목 </label>
			<textarea id="mTitle" name="mTitle" class="inf2" disabled>${vo.mTitle}</textarea><br>
		</div>
		<div id="Msg2" class="information">
			<label class="inf">내용 </label>
			<textarea id="mContent" name="mContent" class="inf2" disabled>${vo.mContent}</textarea>
		</div>
	</c:forEach>
	<div id="divBtn">
		<button id="cancel" class="rBtn" onclick="location.href='sendBox'">이전</button>
	</div>
</body>
</html>