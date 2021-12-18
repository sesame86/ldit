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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/sendBox.css" /><!-- sendBox css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>보낸 쪽지 확인</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	<input type="hidden" id=value="${loginuser.stfNo}"/>
	<h1>보낸 쪽지 확인</h1>
	<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>보낸 날짜</th>
				<th>수신 날짜</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${mlist}">
			<h1>${vo.sendMsg}</h1>
			<h1>${vo.sendMsg.sMTime}</h1>
			<c:if test="${vo.sendMsg.stfNo == loginUser.stfNo}">
				<tr>
					<th><button>${vo.mTitle}</button></th>
					<th>${vo.sendMsg.sMTime}</th>
					<th>${vo.receiveMsg.rMCheck}</th>
				</tr>
			</c:if>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>