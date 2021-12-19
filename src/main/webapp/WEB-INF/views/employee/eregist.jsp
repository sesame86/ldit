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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/eregist.css" /><!-- eregist css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>직원 등록</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp"%>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp"%>
	
	<h1>직원 등록</h1>
		<form action="eregist" method="post" enctype="multipart/form-data">
		<div id="box">
			<div id="divImg">
				<label class="inf">프로필 사진 : </label>
				<input type="file" name="stfImg" class="inf2" required/><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				<label class="inf">서명 : </label>
				<input type="file" name="stfSign" class="inf2" required/>
			</div>
			<div id="divInformation">
				<label class="inf">사원 번호 :</label>
				<input type="number" name="stfNo" class="inf2" placeholder="사원 번호를 입력해주세요." required/><br><br><br>
				<label for="select-deptNo" class="inf">부서 번호 :</label>
				<select id="select-deptNo" name="deptNo" class="inf2" required>
					<option value=1>임원</option>
					<option value=2>기획</option>
					<option value=3>인사</option>
					<option value=4>개발</option>
					<option value=5>영업</option>
				</select>	
				<br><br><br><label for="select-stfLvl" class="inf">직급 :</label>
				<select id="select-stfLvl" name="stfLvl" class="inf2" required>
					<option value="사원">사원</option>
					<option value="전무이사">전무이사</option>
					<option value="상무이사">상무이사</option>
					<option value="대표이사">대표이사</option>					
				</select>
				<br><br><br><label class="inf">이름 :</label>
				<input type="text" name="stfName" class="inf2" placeholder="이름을 입력해주세요." required/><br><br><br>
				<label class="inf">아이디 :</label>
				<input type="text" name="stfId" id="stfId" class="inf2" placeholder="아이디를 입력해주세요." required/>
				<input type="button" id="idCheck" value="중복 확인" required/><br>
				<div id="idAlert"></div>				
				<br><br>
				<label class="inf">비밀번호 :</label>
				<input type="password" name="stfPasswd" class="inf2" placeholder="비밀 번호를 입력해주세요." required/><br><br><br>
				<label class="inf">비밀번호 확인 :</label>
				<input type="password" name="pwCheck" class="inf2" placeholder="비밀 번호를 입력해주세요." required/><br><br><br>
				<span id="pwdAlert"></span>
				<label class="inf">핸드폰 번호 :</label>
				<input type="text" name="stfPhone" class="inf2" placeholder="전화 번호를 입력해주세요." required/>
				<div id="phoneAlert">010-0000-0000 형식으로 입력해주세요.</div><br><br>
				<label class="inf">이메일 :</label>
				<input type="email" name="stfMail" class="inf2" placeholder="이메일을 입력해주세요." required/>
				<div id="mailAlert">aaa@aaa.com 형식으로 입력해주세요.</div><br><br>
				<label class="inf">입사일 :</label>
				<input type="date" name="stfEnroll" class="inf2" placeholder="입사일을 입력해주세요." required/>
			</div>
			</div> 
			<div id="divBtn">
				<button type="submit" id="regist" class="rBtn">등록</button>
				<button type="button" id="cancel" class="rBtn" onclick="location.href='main'">취소</button>
			</div>
		</form>
<script>
$(function(){
	$("#idCheck").on("click", function(){
		var id= $("#stfId").val();
		if(id == ""){
			alert("아이디를 입력해주세요.");
			return;
		}
		
		if(id != null){
			$("#idAlert").html("사용가능한 아이디입니다.");
			$("#idAlert").css("color", "green");
			$("#idAlert").css("font-size", "0.7rem");
		}else {
			$("#idAlert").html("아이디가 중복되었습니다.");
			$("#idAlert").css("color", "red");
		}
	});
});

</script>
</body>
</html>