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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/einquire.css" /><!-- einquire css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>조직도</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	<section>
	<h1>조직도</h1>
		<div id="staffContainer1" class="staffContainer">
			<div id="deptNM1">임원</div>
			<div id="staffInfo1">
				<c:forEach var="vo" items="${orlist}">
					<c:if test="${vo.department.dept_name =='임원'}">
						<br><br>
						<img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
						<label class="staffName">${vo.stf_name}</label>
						<label class="staffPhone">${vo.stf_phone}</label>
						<label class="staffMail">${vo.stf_mail}</label><br><br><br>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<p><img src="<%=request.getContextPath() %>/resources/image/bar.png"></p>
		<br><br><br>
		<div id="staffContainer2" class="staffContainer">
			<div id="deptNM2">기획부</div>
			<div id="staffInfo2">
				<c:forEach var="vo" items="${orlist}">
					<c:if test="${vo.department.dept_name =='기획'}">
						<br><br>
						<img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
						<label class="staffName">${vo.stf_name}</label>
						<label class="staffPhone">${vo.stf_phone}</label>
						<label class="staffMail">${vo.stf_mail}</label><br><br><br>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<p><img src="<%=request.getContextPath() %>/resources/image/bar.png"></p>
		<br><br><br>
		<div id="staffContainer3" class="staffContainer">
			<div id="deptNM3">인사부</div>
			<div id="staffInfo3">
				<c:forEach var="vo" items="${orlist}">
					<c:if test="${vo.department.dept_name =='인사'}">
						<br><br>
						<img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
						<label class="staffName">${vo.stf_name}</label>
						<label class="staffPhone">${vo.stf_phone}</label>
						<label class="staffMail">${vo.stf_mail}</label><br><br><br>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<p><img src="<%=request.getContextPath() %>/resources/image/bar.png"></p>
		<br><br><br>
		<div id="staffContainer4" class="staffContainer">
			<div id="deptNM4">개발부</div>
			<div id="staffInfo4">
				<c:forEach var="vo" items="${orlist}">
					<c:if test="${vo.department.dept_name =='개발'}">
						<br><br>
						<img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
						<label class="staffName">${vo.stf_name}</label>
						<label class="staffPhone">${vo.stf_phone}</label>
						<label class="staffMail">${vo.stf_mail}</label><br><br><br>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<p><img src="<%=request.getContextPath() %>/resources/image/bar.png"></p>
		<br><br><br>	
		<div id="staffContainer5" class="staffContainer">
			<div id="deptNM5">영업부</div>
			<div id="staffInfo5">
				<c:forEach var="vo" items="${orlist}">
					<c:if test="${vo.department.dept_name =='영업'}">
						<br><br>
						<img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
						<label class="staffName">${vo.stf_name}</label>
						<label class="staffPhone">${vo.stf_phone}</label>
						<label class="staffMail">${vo.stf_mail}</label><br><br><br>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<br><br><br>
	</section>
</body>
</html>