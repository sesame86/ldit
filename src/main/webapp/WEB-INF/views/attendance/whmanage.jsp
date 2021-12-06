<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>근무계획 설정</title>
<!-- fontawesome cdn -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<!-- css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/whmanage.css" /><!-- whmanage css -->
</head>
<body>
	<%@ include file="../ldit_header.jsp" %>
	<%@ include file="../ldit_aside.jsp" %>
	
	
	
	<section>
		<article id="article_a">
			<form action="whmanage" method="post" onsubmit="return checkEnable();">
				<fieldset>
					<legend>근무계획설정</legend>
						<div>
							<div>
								<div>근무제도 선택</div>
								<div>								
									<label for="whm_fix">고정근무제</label><input type="radio" id="whm_fix" name="whm_type" value="0">
									<label for="whm_week">근무유연제</label><input type="radio" id="whm_week" name="whm_type" value="1">	
								</div>
							</div>
							<div>
								<div>휴식제도 선택</div>
								<div>
									<label for="in_rest">휴식시간 포함</label><input type="radio" id="in_rest" name="rest_type" value="0">
									<label for="out_rest">휴식시간 제외</label><input type="radio" id="out_rest" name="rest_type" value="1">								
								</div>
							</div>
							<div>
								<div>소정근무시간</div>
								<div><input type="number" value="40" id="week_hours" name="week_hours"></div>							
							</div>
							<div>
								<div>근무일 설정</div>
								<div>
									<input type="checkbox" name="select_day" id="mon" class="select_day" value="월요일">
									<label for="mon">월요일</label>
									<input type="checkbox" name="select_day" id="tues" class="select_day" value="화요일">
									<label for="tues">화요일</label>
									<input type="checkbox" name="select_day" id="wed" class="select_day" value="수요일">
									<label for="wed">수요일</label>
									<input type="checkbox" name="select_day" id="thurs" class="select_day" value="목요일">
									<label for="thurs">목요일</label>
									<input type="checkbox" name="select_day" id="fri" class="select_day" value="금요일">
									<label for="fri">금요일</label>
									<input type="checkbox" name="select_day" id="sat" class="select_day" value="토요일">
									<label for="sat">토요일</label>
									<input type="checkbox" name="select_day" id="sun" class="select_day" value="일요일">
									<label for="sun">일요일</label>
								</div>
							</div>
							<div>
								<div>근무시간 설정</div>
								<div>
									  <input type="time" id="time_in" name="time_in" value="09:00:00" class="select_time" step="1">
									  -
									  <input type="time" id="time_out" name="time_out" value="18:00:00" class="select_time" step="1">
								</div>
							</div>
						</div>
				</fieldset>
				<button>완료</button>
			</form>
		</article>
	</section>
	
<script>
$(document).ready(function(){
    $("input:radio[name=whm_type]").click(function(){
        if($("input[name=whm_type]:checked").val() == "0"){
            $("#week_hours").attr("disabled", true);
            $(".select_time").attr("disabled", false);
            $(".select_day").attr("disabled", false);
        }else if($("input[name=whm_type]:checked").val() == "1"){
              $(".select_time").attr("disabled", true);
              $(".select_day").attr("disabled", true);
              $("#week_hours").attr("disabled", false);
        }
    });
});

$(document).ready(function(){
	if("${whm.whmCode}"=="0"){
		$("#whm_fix").attr("checked", true);
	} else if("${whm.whmCode}"=="1") {
		$("#whm_week").attr("checked", true);
	}
	if($("input[name=whm_type]:checked").val() == "0"){
        $("#week_hours").attr("disabled", true);
        $(".select_time").attr("disabled", false);
        $(".select_day").attr("disabled", false);
    }else if($("input[name=whm_type]:checked").val() == "1"){
          $(".select_time").attr("disabled", true);
          $(".select_day").attr("disabled", true);
          $("#week_hours").attr("disabled", false);
    }
	if("${whm.whmRestCode}" == "0"){
		$("#in_rest").attr("checked", true);
	} else if("${whm.whmRestCode}" == "1"){
		$("#out_rest").attr("checked", true);
	}
});


function checkEnable(){
	if($("input[name=whm_type]:checked").val() == "0"){
		var lcheck = $(".select_day:checked").length;
		if (lcheck == 0) {
			alert("근무일을 하루 이상 선택하세요.");
			return false;
			}
    }else if($("input[name=whm_type]:checked").val() == "1"){
		if(!$("#week_hours").val() || $("#week_hours").val() == 0){
			alert("1주 소정근로시간을 입력해주세요.");
			return false;
		}
    }
    $("#week_hours").attr("disabled", false);
    $(".select_time").attr("disabled", false);
    $(".select_day").attr("disabled", false);
}
</script>


<!--<c:if test="${loginUser.deptNo ne 3}">
[[${loginUser.deptNo}]]
	<script>
 		window.setTimeout(redirectFunc, 3000);
 		function redirectFunc() {
 			location.href="main";
 		}
 	</script>
</c:if>-->


</body>
</html>