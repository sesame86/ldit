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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/edelete.css" /><!-- edelete css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>직원 정보 삭제</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	<h1>직원 정보 삭제</h1>
		<div id="staffContainer" class="staffContainer">
				<table id="staffTable">
					<thead>
						<tr>
							<th>사원 번호</th>
							<th>부서 명</th>
							<th>직급</th>
							<th>이름</th>
							<th>아이디</th>
							<th>프로필 사진</th>
							<th>핸드폰 번호</th>
							<th>이메일</th>
							<th>입사일</th>
							<th>퇴사<th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${elist}">
							<tr>
								<td>${vo.stfNo}</td>
								<td>${vo.department.deptName}</td>
								<td>${vo.stfLvl}</td>
								<td>${vo.stfName}</td>
								<td>${vo.stfId}</td>
								<td><img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG"></td>
								<td>${vo.stfPhone}</td>
								<td>${vo.stfMail}</td>
								<td>${vo.stfEnroll}</td>
								<td><button onclick="location.href='edelete2?stfNo=${vo.stfNo}'">퇴사</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
</body>
</html>