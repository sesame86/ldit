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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/receiveBox.css" /><!-- receiveBox css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>받은 쪽지 확인</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	<h1>받은 쪽지 확인</h1>
	<table>
		<thead>
			<tr>
				<th id="no">쪽지 번호</th>
				<th id="title">제목</th>
				<th id="time">받은 날짜</th>
				<th id="id">보낸 사람</th>
				<th id="delete">삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${mlist}">
				<c:if test="${vo.receiveMsg.stfNo == loginUser.stfNo}">
					<tr>
						<td id="no"><input id="No" class="none" value="${vo.receiveMsg.rMNo}" disabled/></td>
						<td id="title"><input id="input" type="button" value="${vo.mTitle}" onclick="location.href='checkMsg?mNo=${vo.mNo}'"/></td>
						<td id="time"><input id="Time" class="none" value="${vo.receiveMsg.rMTime}" disabled/></td>
						<td id="id"><input id="Id" class="none" value="${vo.receiveMsg.sStfId}" disabled/></td>
						<td id="delete"><button onclick="location.href='rmdelete?rMNo=${vo.receiveMsg.rMNo}'">삭제</button></td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
<script>

</script>
</body>
</html>