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
	<form name="form1" method="post">
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
					<input type="text" name="stf_id" id="stf_id" placeholder="아이디">
				</div>
				<div class="login_pw">
					<h4>
						Password <i class="fas fa-key"></i>
					</h4>
					<input type="password" name="stf_passwd" id="stf_passwd"
						placeholder="비밀번호">
				</div>

				<div class="login_check">
					<span class="option_wrap">
						<input type="checkbox" name="saveLoginId" id="saveLoginId" tabindex="5">
						<label id="login_id_save_label" for="saveLoginId">계정 저장</label>
					</span>
					<span class="option_wrap">|</span>
					<a class="option_wrap" id="findPwd">비밀번호 찾기</a>
				</div>

				<div class="submit">
					<button type="button" id="btnLogin">로그인</button>
					<c:if test="${msg == 'failure'}">
						<div style="color: red">아이디 또는 비밀번호가 일치 하지 않습니다.</div>
					</c:if>
					<c:if test="${msg=='logout'}">
						<div style="color: red;">로그아웃되었습니다.</div>
					</c:if>

				</div>
			</div>
		</div>
	</form>
	<script>
  $(document).ready(function(){
    $("#btnLogin").click(function(){
      
      //태그.val() : 태그에 입력된 값
      //태그.val("값") : 태그의 값을 변경
      var userId =$("#stf_id").val();
      var userPw =$("#stf_passwd").val();
      if(userId==""){
        alert("아이디를 입력해주세요.");
        $("#stf_id").focus();
        return;
      }
      if(userPw == ""){
        alert("비밀번호를 입력해주세요.");
        $("#stf_passwd").focus();
        return
      }
      //폼 내분의 데이터를 전송할 주소
      document.form1.action="loginCheck.do"
      //제출
      document.form1.submit();

    });
    
    $("#stf_passwd").keydown(function(e){
        
    	if(e.keyCode == 13){
    		$("#btnLogin").click();
  
    	}
      });
    
  });

	//아이디 저장 관련
    $(document).ready(function(){
    var userInputId = getCookie("userInputId");//저장된 쿠기값 가져오기
    $("input[name='stf_id']").val(userInputId); 
     
    if($("input[name='stf_id']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩
                                           // 아이디 저장하기 체크되어있을 시,
        $("#saveLoginId").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#saveLoginId").change(function(){ // 체크박스에 변화가 발생시
        if($("#saveLoginId").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("input[name='stf_id']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("userInputId"); 
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("input[name='stf_id']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#saveLoginId").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("input[name='stf_id']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
     </script>

</body>
</html>