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
<link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css"> <!-- 테이블 css from w3schools -->
</head>
<body>
	<%@ include file="../ldit_header.jsp" %>
	<%@ include file="../ldit_aside.jsp" %>
	
	
	
	<section>
		<article id="article_a">
			<h1>근무제도 관리</h1>
			<form action="whmanage" method="post" onsubmit="return checkEnable();">
				<div id="div_whm_outer">
					<h1>근무제도 선택</h1>
					<div>
						<label for="whm_fix">고정근무제</label>
						<input type="radio"	id="whm_fix" name="whm_type" value="0">
						<label for="whm_week">근무유연제</label>
						<input type="radio" id="whm_week" name="whm_type" value="1">
					</div>
					<h1>휴식제도 선택</h1>
					<div>
						<label for="in_rest">휴식시간 포함</label>
						<input type="radio"	id="in_rest" name="rest_type" value="0">
						<label for="out_rest">휴식시간 제외</label>
						<input type="radio" id="out_rest" name="rest_type" value="1">
					</div>
					<h1>소정근무시간</h1>
					<div>
						<input type="number" value="40" id="week_hours" name="week_hours">
					</div>
					<h1>근무일 설정</h1>
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
					<h1>근무시간 설정</h1>
					<div>
					<input type="time" id="time_in" name="time_in" value="09:00:00" class="select_time" step="1">
					-
					<input type="time" id="time_out" name="time_out" value="18:00:00" class="select_time" step="1">
					</div>
				</div>
				<button class="btn_whn_manage">완&nbsp;&nbsp;&nbsp;&nbsp;료</button>
			</form>
		</article>
		<br>
		<article id="article_b">
			<h1>휴가코드 관리</h1>
			<div id="div_apply_outer">
				<div id="div_btnapply_outer">
					<button type="button" id="btn_add_xiuxi" class="btn_apply">추&nbsp;&nbsp;&nbsp;&nbsp;가</button><button type="button" id="btn_remove_xiuxi" class="btn_apply">삭&nbsp;&nbsp;&nbsp;&nbsp;제</button>
				</div>
				<table class="w3-table w3-striped w3-border">
					<thead>
						<tr>
							<th><input type="checkbox" id="checkbox_all"></th>
							<th>휴가코드</th>
							<th>휴가종류명</th>
							<th>휴가차감여부</th>
						</tr>
					</thead>
					<c:choose>
						<c:when test="${!empty xiuxiList}">
							<tbody>
								<c:forEach items="${xiuxiList}" var="x">
									<tr class="tr_read_data">
										<td><input type="checkbox" name="ck_xiuxi" value="${x.xiuNo}"></td>
										<td>${x.xiuNo}</td>
										<td>${x.xiuReason}</td>
										<c:choose>
											<c:when test="${x.xiuAplYesNo eq 0}">
												<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;N</td>
											</c:when>
											<c:when test="${x.xiuAplYesNo eq 1}">
												<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Y</td>
											</c:when>
										</c:choose>
									</tr>
								</c:forEach>
							</tbody>
						</c:when>
						<c:when test="${empty xiuxiList}">
							<tbody>
								<tr>
									<td colspan="4">등록된 휴가가 없습니다.</td>
								</tr>
							</tbody>
						</c:when>
					</c:choose>
				</table>
			</div>
		</article>
	</section>	
	
<!--휴가코드 추가 모달 창-->
<div id="modal_wrapper" class="modal_wrapper">
  <!-- Modal content -->
  <div class="modal_content">
  	<h1>휴가코드 추가</h1>
  	<form action="xiuxiset" method="post" onsubmit="return checkReason();">
	    <div><label for="xiuxi_code">휴가코드&nbsp;:&nbsp;&nbsp;</label><input type="number" name="xiu_no" id="xiuxi_code" required min="0" max="99"><span id="result_checkDuplicate"></span></div>
	    <div><label for="xiuxi_reason">휴가사유&nbsp;:&nbsp;&nbsp;</label><input type="text" name="xiu_reason" id="xiuxi_reason" required placeholder="10자 이내로 입력하세요"></div>
		<div>
			<input type="radio" id="apl_yes" name="xiu_apl_yesno" class="xiu_apl_yesno" value="1" checked><label for="apl_yes">&nbsp;연차적용</label>
			<input type="radio" id="apl_no" name="xiu_apl_yesno" class="xiu_apl_yesno" value="0"><label for="apl_no">&nbsp;연차미적용</label>
		</div>
		<div><button class="btn_xiuxi_apply">등록</button></div>
	</form>
  </div>
</div>
	
<script>

var modal = document.getElementById("modal_wrapper");
var btn = document.getElementById("btn_add_xiuxi");

btn.onclick = function() {
  modal.style.display = "block";
  modal.style.display = "flex";
}

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

window.addEventListener("keyup", function(e) {
    if(modal.style.display = "block" && e.key === "Escape") {
   	modal.style.display = "none";
    }
});

	$("#xiuxi_reason").on("keyup", function() {
		if ($(this).val().length > 10) {
			$(this).val($(this).val().substring(0, 10));
		}
	});

	$("input:radio[name=whm_type]").click(function() {
		if ($("input[name=whm_type]:checked").val() == "0") {
			$("#week_hours").attr("disabled", true);
			$(".select_time").attr("disabled", false);
			$(".select_day").attr("disabled", false);
		} else if ($("input[name=whm_type]:checked").val() == "1") {
			$(".select_time").attr("disabled", true);
			$(".select_day").attr("disabled", true);
			$("#week_hours").attr("disabled", false);
		}
	});

	$("#checkbox_all").click(function () {
		if($("input:checkbox[id='checkbox_all']").prop("checked")){
			$("input:checkbox[name='ck_xiuxi']").prop("checked", true);
		} else {
			$("input:checkbox[name='ck_xiuxi']").prop("checked", false);
		}
	});

	$(document).ready(function() {
		if ("${whm.whmCode}" == "0") {
			$("#whm_fix").attr("checked", true);
		} else if ("${whm.whmCode}" == "1") {
			$("#whm_week").attr("checked", true);
		}
		if ($("input[name=whm_type]:checked").val() == "0") {
			$("#week_hours").attr("disabled", true);
			$(".select_time").attr("disabled", false);
			$(".select_day").attr("disabled", false);
		} else if ($("input[name=whm_type]:checked").val() == "1") {
			$(".select_time").attr("disabled", true);
			$(".select_day").attr("disabled", true);
			$("#week_hours").attr("disabled", false);
		}
		if ("${whm.whmRestCode}" == "0") {
			$("#in_rest").attr("checked", true);
		} else if ("${whm.whmRestCode}" == "1") {
			$("#out_rest").attr("checked", true);
		}
	});

function checkEnable() {
	if ($("input[name=whm_type]:checked").val() == "0") {
		var lcheck = $(".select_day:checked").length;
		if (lcheck == 0) {
			alert("근무일을 하루 이상 선택하세요.");
			return false;
		}
	} else if ($("input[name=whm_type]:checked").val() == "1") {
		if (!$("#week_hours").val() || $("#week_hours").val() == 0) {
			alert("1주 소정근로시간을 입력해주세요.");
			return false;
		}
	}
	$("#week_hours").attr("disabled", false);
	$(".select_time").attr("disabled", false);
	$(".select_day").attr("disabled", false);
}
	
function checkReason() {
	var reasonBefore = $("#xiuxi_reason").val();
	console.log(reasonBefore);
	var reasonAfter = $.trim($("#xiuxi_reason").val());
	console.log(reasonAfter);
	isNull(reasonAfter);
	if(isNull(reasonAfter)){
		alert("관리할 휴가사유를 입력해주세요");
		return false;
	}
	$("#xiuxi_reason").val(reasonAfter);
	return true;
}

function isNull(obj) {
	return (typeof obj != "undefined" && obj != null && obj != "") ? false : true;
}
	$("#xiuxi_code").keyup(ckDuplXiuNo);

function ckDuplXiuNo() {
	$("#result_checkDuplicate").html("");
	var xiuNo = $("#xiuxi_code").val();
	var regExpNum = /^[0-9]{1,2}$/;
	if (!regExpNum.test(xiuNo)) {
		$("#result_checkDuplicate").html("0~99 사이 코드만 입력해주세요");
		$("#xiuxi_code").focus();
	} else {
		if (!isNull(xiuNo)) {
			$.ajax({
				url : "ckDuplXiuNo",
				data : {
					"xiuNo" : xiuNo
				},
				type : "post",
				success : function(data) {
					console.log(data);
					if (data == 0) {
						$("#xiuxi_code").css('color', 'blue');
						$("#xiuxi_code").css('border-color', 'blue');
						$("#result_checkDuplicate").html("사용가능한 코드입니다");
					} else {
						$("#xiuxi_code").css('color', 'red');
						$("#xiuxi_code").css('border-color', 'red');
						$("#result_checkDuplicate")
								.html("이미 사용하고 있는 코드입니다");
					}
				},
				error : function(request, status, errorData) {
					alert("error code : " + request.status + "\n"
							+ "message : " + request.responseText + "\n"
							+ "error : " + errorData);
				}
			});
		} else {
			$("#xiuxi_code").css('color', 'red');
			$("#xiuxi_code").css('border-color', 'red');
			$("#result_checkDuplicate").html("코드를 입력해주세요");
		}
	}
}

	$("#btn_remove_xiuxi").click(
			function() {
				var checkedXiuxi = [];
				$("input[name='ck_xiuxi']:checked").each(function(i) {
					checkedXiuxi.push($(this).val());
					console.log(checkedXiuxi);
				});
				if (checkedXiuxi.length) {
					$.ajax({
						url : "xiuxiremove",
						data : {
							"checkedXiuxi" : checkedXiuxi
						},
						type : "post",
						success : function(data) {
							console.log(data);
							if (data >= checkedXiuxi.length - 1) {
								alert("정상적으로 삭제되었습니다.");
								location.reload();
							}
						},
						error : function(request, status, errorData) {
							alert("error code : " + request.status + "\n"
									+ "message : " + request.responseText
									+ "\n" + "error : " + errorData);
						}
					});
				} else {
					alert("삭제할 항목을 선택해주세요.");
				}
			});
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