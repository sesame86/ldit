<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 이모티콘 -->
<script src="https://kit.fontawesome.com/616f27e0c4.js"
	crossorigin="anonymous"></script>
<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/login.css" />
<!-- login css -->

<!-- jquery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<div class="login">
			<h2></h2>
			<div class="logo">
				<img src="./resources/image/logo.png" width="100%"">
			</div>
			<div class="login_id">
				<h4>
					ID <i class="fas fa-user"></i>
				</h4>
				<input type="text" name="" id="" placeholder="아이디">
			</div>
			<div class="login_pw">
				<h4>
					Password <i class="fas fa-key"></i>
				</h4>
				<input type="password" name="" id="" placeholder="비밀번호">
			</div>

			<div class="login_check">
				<span class="option_wrap"> <input type="checkbox"
					name="saveEmail" id="saveLoginId" tabindex="5"> <label
					id="login_id_save_label">계정 저장</label>
				</span> <span class="option_wrap">|</span> <a class="option_wrap"
					id="findPwd">비밀번호 찾기</a>
			</div>

			<div class="submit">
				<input type="submit" value="로그인">

			</div>
		</div>
	</div>

</body>
</html>