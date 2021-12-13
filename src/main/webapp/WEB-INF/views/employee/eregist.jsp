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
		<form action="eregist" method="post">
			<div id="divImg">
				<label class="inf">프로필 사진 : </label>
				<input type="text" name="stfImg" class="inf2"/><br><br><br><br><br>
				<label class="inf">서명:</label>
				<input type="text" name="stfSign" class="inf2"/>
			</div>
			<div id="divInformation">
				<label class="inf">사원 번호 :</label>
				<input type="number" name="stfNo" class="inf2" placeholder="숫자를 입력해주세요."/>
				<label for="select-deptNo" class="inf">부서 번호 :</label>
				<select id="select-deptNo" name="deptNo" class="inf2">
					<option value=1>임원</option>
					<option value=2>기획</option>
					<option value=3>인사</option>
					<option value=4>개발</option>
					<option value=5>영업</option>
				</select>
			
				<label for="select-stfLvl" class="inf">직급 :</label>
				<select id="select-stfLvl" name="stfLvl" class="inf2">
					<option value="사원">사원</option>
					<option value="전무이사">전무이사</option>
					<option value="상무이사">상무이사</option>
					<option value="대표이사">대표이사</option>					
				</select>
				<br><br><br><br><br><label class="inf">이름 :</label>
				<input type="text" name="stfName" class="inf2" placeholder="문자를 입력해주세요."/>
				<label class="inf">아이디 :</label>
				<input type="text" name="stfId" class="inf2" placeholder="문자를 입력해주세요."/>
				<label class="inf">비밀번호 :</label>
				<input type="text" name="stfPasswd" class="inf2" placeholder="문자를 입력해주세요.">
				<br><br><br><br><br><label class="inf">핸드폰 번호 :</label>
				<input type="text" name="stfPhone" class="inf2" placeholder="-까지 입력해주세요.">
				<label class="inf">이메일 :</label>
				<input type="email" name="stfMail" class="inf2" placeholder="문자를 입력해주세요.">
				<label class="inf">입사일 :</label>
				<input type="text" name="stfEnroll" class="inf2" placeholder="YYYY-MM-DD 형식"/><br><br><br><br><br>
			</div>
			<div id="divBtn">
				<button type="submit" id="regist" class="rBtn">등록</button>
				<button type="reset" id="reset" class="rBtn">리셋</button>
			</div> 
		</form>
</body>
</html>