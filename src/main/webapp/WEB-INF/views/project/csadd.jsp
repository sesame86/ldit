<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<!-- 이모티콘 -->
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/csadd.css" /><!-- team_add css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<title>LDIT: 고객 요구사항 등록</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp" %>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp" %>
	<section>
		<div id="csAddCon">
			<h1>고객 요구사항 등록</h1>
			<article>
				<form id="csAddFrm" action="csadd" method="post">
					<div id="csGrid">
						<input type="hidden" id="proNo" name="proNo" value="${proNo}">
						<label>요구사항 제목</label>
						<input id="cnTitle" name="cnTitle" required="required">
						<label>요구사항 내용</label>
						<textarea id="cnContent" name="cnContent" rows="10" required="required"></textarea>
						<label>요구사항 우선순위</label>
						<select name="cnPriority">
							<option value="1">긴급</option>
							<option value="2">높음</option>
							<option value="3">보통</option>
							<option value="4">낮음</option>
						</select>
					</div>
					<button type="submit" id="submitBtn">저장</button>
				</form>
			</article>
		</div>
	</section>
</body>
</html>