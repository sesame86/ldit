<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 등록</title>
</head>
<body>
<h3> 직원 등록</h3>
	<form action="login" method="post">
		<label>사원 번호 :</label><input type="text" name="memberId"><br>
		<label>부서 번호 :</label><input type="text" name="deptNo"><br>
		<label>직급 :</label><input type="text" name="stfLvl"><br>
		<label>이름 :</label><input type="text" name="stfName"><br>
		<label>아이디 :</label><input type="text" name="stfId"><br>
		<label>비밀번호 :</label><input type="text" name="stfPasswd"><br>
		<label>프로필 사진 :</label><input type="text" name="stfImg"><br>
		<label>서명:</label><input type="text" name="stfSign"><br>
		<label>핸드폰 번호 :</label><input type="text" name="stfPhone"><br>
		<label>이메일 :</label><input type="text" name="stfMail"><br>
		<label>입사일 :</label><input type="text" name="stfEnroll"><br>
		<button type="reset">리셋</button>
	</form>
</body>
</html>