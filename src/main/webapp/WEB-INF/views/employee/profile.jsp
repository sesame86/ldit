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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/profile.css" /><!-- profile css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>직원 상세 정보</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	<form>
		<table>
				<tr>
					<td><img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG"></td>
					<td>${profile.stfNo}</td>
					<td>${profile.department.deptName}</td>
					<td>${profile.stfLvl}</td>
					<td>${profile.stfName}</td>
					<td>${profile.stfId}</td>
					<td>${profile.stfPasswd}</td>
					<td>${profile.stfPhone}</td>
					<td>${profile.stfMail}</td>
					<td>${profile.stfEnroll}</td>
				</tr>
		</table>
	</form>
</body>
</html>