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

<title>개인 정보 수정</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	
	<h1>개인 정보 수정 </h1>
	<form action="eupdate2" method="post">
	<div id="box">
		<div id="divImg">
			<label><img id="stfImg" src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG"></label><br><br><br>
		</div>
		<div id="divInformation">
		<label class="inf">사원 번호 : </label>
		<label class="inf2">${loginUser.stfNo}</label><br><br><br>
		<label for="deptNo" class="inf">부서이름 : </label>
		<c:if test="${loginUser.department.deptName == '임원'}">
			<select id="deptNo" name="deptNo" class="inf2">
				<option value=1 selected>임원</option>
				<option value=2>기획부</option>
				<option value=3>인사부</option>
				<option value=4>개발부</option>					
				<option value=5>영업부</option>					
			</select>
		</c:if>
		<c:if test="${loginUser.department.deptName == '기획'}">
			<select id="deptNo" name="deptNo" class="inf2">
				<option value=1>임원</option>
				<option value=2 selected>기획부</option>
				<option value=3>인사부</option>
				<option value=4>개발부</option>					
				<option value=5>영업부</option>					
			</select>
		</c:if>
		<c:if test="${loginUser.department.deptName == '인사'}">
			<select id="deptNo" name="deptNo" class="inf2">
				<option value=1>임원</option>
				<option value=2>기획부</option>
				<option value=3 selected>인사부</option>
				<option value=4>개발부</option>					
				<option value=5>영업부</option>					
			</select>
		</c:if>
		<c:if test="${loginUser.department.deptName == '개발'}">
			<select id="deptNo" name="deptNo" class="inf2">
				<option value=1>임원</option>
				<option value=2>기획부</option>
				<option value=3>인사부</option>
				<option value=4 selected>개발부</option>					
				<option value=5>영업부</option>					
			</select>
		</c:if>
		<c:if test="${loginUser.department.deptName == '영업'}">
			<select id="deptNo" name="deptNo" class="inf2">
				<option value=1>임원</option>
				<option value=2>기획부</option>
				<option value=3>인사부</option>
				<option value=4>개발부</option>					
				<option value=5 selected>영업부</option>					
			</select>
		</c:if><br><br><br>
		<label for="stfLvl" class="inf">직급 : </label>
		<c:if test="${loginUser.stfLvl == '사원'}">
			<select id="stfLvl" name="stfLvl" class="inf2">
				<option value="사원" selected>사원</option>
				<option value="전무이사">전무이사</option>
				<option value="상무이사">상무이사</option>
				<option value="대표이사">대표이사</option>					
			</select>
		</c:if>
		<c:if test="${loginUser.stfLvl == '전무이사'}">
			<select id="stfLvl" name="stfLvl" class="inf2">
				<option value="사원">사원</option>
				<option value="전무이사" selected>전무이사</option>
				<option value="상무이사">상무이사</option>
				<option value="대표이사">대표이사</option>					
			</select>
		</c:if>
		<c:if test="${loginUser.stfLvl == '상무이사'}">
			<select id="stfLvl" name="stfLvl" class="inf2">
				<option value="사원">사원</option>
				<option value="전무이사">전무이사</option>
				<option value="상무이사" selected>상무이사</option>
				<option value="대표이사">대표이사</option>					
			</select>
		</c:if>
		<c:if test="${loginUser.stfLvl == '대표이사'}">
			<select id="stfLvl" name="stfLvl" class="inf2">
				<option value="사원">사원</option>
				<option value="전무이사">전무이사</option>
				<option value="상무이사">상무이사</option>
				<option value="대표이사" selected>대표이사</option>					
			</select>
		</c:if><br><br><br>
		<label class="inf">사원 이름 : </label>
		<label class="inf2">${loginUser.stfName}</label><br><br><br>
		<input type="hidden" id="stfId" name="stfId" value="${loginUser.stfId}"/>
		<label class="inf">아이디 : </label>
		<label class="inf2">${loginUser.stfId}</label><br><br><br>
		<label class="inf">비밀번호 : </label>
		<label><input type="text" id="stfPasswd" name="stfPasswd" class="inf2" value="${loginUser.stfPasswd}"/></label><br><br><br>
		<label class="inf">전화번호 : </label>
		<label><input type="text" id="stfPhone" name="stfPhone" class="inf2" value="${loginUser.stfPhone}"/></label><br><br><br>
		<label class="inf">이메일 : </label>
		<label><input type="email" id="stfMail" name="stfMail" class="inf2" value="${loginUser.stfMail}"/></label><br><br><br>
		<label class="inf">입사일 : </label>
		<label class="inf2">${loginUser.stfEnroll}</label><br><br><br>
		</div>
		</div>
		<div id="divBtn">
			<button type="submit" id="update" class="uBtn">수정</button>
			<button type="button" id="cancel" onclick="location.href='main'" class="uBtn">취소</button>
		</div>
	</form>
</body>
</html>