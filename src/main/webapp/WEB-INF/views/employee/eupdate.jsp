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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/eupdate.css" /><!-- eupdate css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>직원 상세 정보</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	<label><img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG"></label>
	<label>${loginUser.stfNo}</label>
	<label><input type="text" name="profileDeptName" value="${loginUser.department.deptName}"/></label>
	<label><input type="text" name="profileStfLvl" value="${loginUser.stfLvl}"/></label>
	<label>${loginUser.stfName}</label>
	<label>${loginUser.stfId}</label>
	<label><input type="text" name="profileStfPasswd" value="${loginUser.stfPasswd}"/></label>
	<label><input type="text" name="profileStfPhone" value="${loginUser.stfPhone}"/></label>
	<label><input type="text" name="profileStfMail" value="${loginUser.stfMail}"/></label>
	<label>${loginUser.stfEnroll}</label>
	<button id=></button>
	<input type="button" value="취소" onclick="cancel()">
<script>
		function update(){
			if(confirm("개인 정보 수정을 완료하시겠습니까?")){
				document.location.href="'eupdate2?stfId=${loginUser.stfId}&&deptName=${loginUser.deptName}&&stfLvl=${loginUser.stfLvl}&& stfPasswd=${loginUser.stfPasswd}&&stfPhone=${loginUser.stfPhone}&&stfMail=${loginUser.stfMail}'";
			} else {
				return false;
			}
		}
		
		function cancel(){
			if(confirm("개인 정보 수정을 취소하시겠습니까?")){
				document.location.href="main";
			}
			else{
				return false;
			}
		}
</script>
</body>
</html>