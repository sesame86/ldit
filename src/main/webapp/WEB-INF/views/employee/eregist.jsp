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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/eregist.css" /><!-- basic css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>직원 등록</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	
	<h3> 직원 등록</h3>
	<section>
		<form action="eregist" method="post">
			<label>
				<span>사원 번호 :</span><input type="number" name="stfNo" placeholder="숫자를 입력해주세요."><br>
			</label>
			<label for="select-deptNo">부서 번호 :</label>
			<select id="select-deptNo" name="deptNo">
				<option value=1>임원</option>
				<option value=2>기획</option>
				<option value=3>인사</option>
				<option value=4>개발</option>
				<option value=5>영업</option>
			</select><br>
			<label for="select-stfLvl">직급 :</label>
			<select id="select-stfLvl" name="stfLvl">
				<option value="사원">사원</option>
				<option value="전무이사">전무이사</option>
				<option value="상무이사">상무이사</option>
				<option value="대표이사">대표이사</option>					
			</select><br>
			<label>
				<span>이름 :</span><input type="text" name="stfName" placeholder="문자를 입력해주세요."><br>
			</label>
			<label>
				<span>아이디 :</span><input type="text" name="stfId" placeholder="문자를 입력해주세요."><br>
			</label>
			<label>
				<span>비밀번호 :</span><input type="text" name="stfPasswd" placeholder="문자를 입력해주세요."><br>
			</label>
			<label>
				<span>프로필 사진 :</span><input type="text" name="stfImg"><br>
			</label>
			<label>
				<span>서명:</span><input type="text" name="stfSign"><br>
			</label>
			<label>
				<span>핸드폰 번호 :</span><input type="text" name="stfPhone" placeholder="-까지 입력해주세요."><br>
			</label>
			<label>
				<span>이메일 :</span><input type="email" name="stfMail" placeholder="문자를 입력해주세요."><br>
			</label>
			<label>
				<span>입사일 :</span><input type="date" name="stfEnroll" ><br>
			</label>
			<button type="reset">리셋</button>
			<button>등록</button> 
		</form>
	</section>
</body>
</html>