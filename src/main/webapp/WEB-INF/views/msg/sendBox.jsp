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
	<input type="hidden" value="${loginuser.stfNo}"/>
	<h1>보낸 쪽지 확인</h1>
	<table>
		<thead>
			<tr>
				<th id="no">쪽지 번호</th>
				<th id="title">제목</th>
				<th id="time">보낸 날짜</th>
				<th id="id">받은 사람</th>
				<th id="check">수신 여부</th>
				<th id="delete">삭제</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${mlist}">
			<c:choose>
				<c:when test="${vo.receiveMsg.rMCheck == 0 && vo.sendMsg.stfNo == loginUser.stfNo}" >
					<tr>
						<td id="no"><input id="No" class="none" value="${vo.sendMsg.sMNo}" disabled/></td>
						<td id="title"><input class="input" type="button" value="${vo.mTitle}" onclick="location.href='checkMsg?mNo=${vo.mNo}'"/></td>
						<td id="time"><input id="Time" class="none" value="${vo.sendMsg.sMTime}" disabled/></td>
						<td id="id"><input id="Id" class="none" value="${vo.sendMsg.rStfId}" disabled/></td>
						<td id="check"><input id="readCheck" class="none2" value="읽지 않음" disabled/></td>
						<td id="delete"><button onclick="location.href='smdelete?sMNo=${vo.sendMsg.sMNo}'">삭제</button></td>
					</tr>
					</c:when>
					<c:when test="${vo.receiveMsg.rMCheck == 1 && vo.sendMsg.stfNo == loginUser.stfNo}" >
					<tr>
						<td id="no"><input id="No" class="none" value="${vo.sendMsg.sMNo}" disabled/></td>
						<td id="title"><input class="input" type="button" value="${vo.mTitle}" onclick="location.href='checkMsg?mNo=${vo.mNo}'"/></td>
						<td id="time"><input id="Time" class="none" value="${vo.sendMsg.sMTime}" disabled/></td>
						<td id="id"><input id="Id" class="none" value="${vo.sendMsg.rStfId}" disabled/></td>
						<td id="check"><input id="readCheck" class="none2" value="읽음" disabled/></td>
						<td id="delete"><button onclick="location.href='smdelete?sMNo=${vo.sendMsg.sMNo}'">삭제</button></td>
					</tr>
					</c:when>
			</c:choose>
		</c:forEach>
		</tbody>
	</table>
<script>	
/* $(document).ready(function(){
	console.log($(".none2").val());
	if($(".none2").val() == 0){
		$(".none2").val("읽지 않음");
	}
	else
		$(".none2").val("읽음");
	console.log($(".none2").val());
}); */
	
</script>
</body>
</html>