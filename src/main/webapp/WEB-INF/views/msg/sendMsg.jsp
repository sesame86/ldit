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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/sendMsg.css" /><!-- sendMsg css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>쪽지 보내기</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	
	<h1>쪽지 보내기</h1>
	<form action="sendMsg" method="post">
		<input type="hidden" name="stfNo" value="${loginUser.stfNo}"/>
		<input type="hidden" name="sStfId" value="${loginUser.stfId}"/>
		<div id="Msg1" class="information">
			<label class="inf">받는 사람 </label>
			<textarea id="rStfId" name="rStfId" class="inf2" placeholder="받을 사람의 아이디를 입력해주세요.0" required></textarea><br>
		</div>
		<div id="Msg2" class="information">
			<label class="inf">제목 </label>
			<textarea id="mTitle" name="mTitle" class="inf2" placeholder="쪽지 제목을 입력해주세요." required></textarea><br>
		</div>
		<div id="Msg3" class="information">
			<label class="inf">내용 </label>
			<textarea id="mContent" name="mContent" class="inf2" placeholder="쪽지 내용을 입력해주세요." required></textarea>
		</div>
		<div id="divBtn">
			<button type="submit" id="regist" class="rBtn">보내기</button>
			<button type="button" id="cancel" class="rBtn" onclick="location.href='main'">취소</button>
		</div>
	</form>
</body>
</html>