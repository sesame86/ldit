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
					<button type="button" id="btn_add_xiuxi" class="btn_apply">추&nbsp;&nbsp;&nbsp;&nbsp;가</button>
					<button type="button" id="btn_remove_xiuxi" class="btn_apply">삭&nbsp;&nbsp;&nbsp;&nbsp;제</button>
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
									<tr>
										<td><input type="checkbox" name="ck_xiuxi" value="${x.xiuNo}"></td>
										<td>${x.xiuNo}</td>
										<td>${x.xiuReason}</td>
										<c:choose>
											<c:when test="${x.xiuAplYesNo eq 0}">
												<td>N</td>
											</c:when>
											<c:when test="${x.xiuAplYesNo eq 1}">
												<td>Y</td>
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
	
		<div class="modal hidden">
			<div class="modal_overlay">
				<div class="modal_content">
					<div class="tab">
						<div><button class="tablinks" onclick="openTab(event, 'm_div_restapply')">휴가신청</button></div>
						<div><button class="tablinks" onclick="openTab(event, 'm_div_whomeapply')">재택근무신청</button></div>
						<div id="m_div_restapply" class="tabcontent">
							<form method="post" action="#">
								<p>사유</p>
								<select>
									<option>개인일정</option>
								</select>
								<p>연차 사용여부</p>
								<input type="text" readonly="readonly" value="">
								<p>일자</p>
								<div></div>
								<button type="button">신청</button>							
							</form>
						</div>
						<div id="m_div_whomeapply" class="tabcontent">
							<form method="post" action="#">
								<p>일자</p>
								<div></div>
								<button type="button">신청</button>							
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	
<script>

const openButton = document.getElementById("btn_add_xiuxi");
const modal = document.querySelector(".modal");
const overlay = document.querySelector(".modal_overlay");
openButton.addEventListener("click", function(){
	modal.classList.remove("hidden");
});
overlay.addEventListener("click", function(){
	modal.classList.add("hidden");
});

function openTab(evt, tabName){
	var i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }
	document.getElementById(tabName).style.display = "block";
	evt.currentTarget.className += " active";
}



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

	$("#btn_remove_xiuxi").click(
			function() {
				var checkedXiuxi = [];
				$("input[name='ck_xiuxi']:checked").each(function(i) {
					checkedXiuxi.push($(this).val());
					console.log(checkedXiuxi);
				});
				if (checkedXiuxi.length) {
					$.ajax({
						url : "xiuxiRemove",
						data : {
							"checkedXiuxi" : checkedXiuxi
						},
						type : "post",
						success : function(data) {
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