<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>근무현황 페이지</title>
<!-- fontawesome cdn -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<!-- css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/attcheck.css" /><!-- basic css -->
</head>
<body>
	<%@ include file="../ldit_header.jsp" %>
	<%@ include file="../ldit_aside.jsp" %>

	<section>

		<article id="article_a">			
			<h1><br>출퇴근 등록</h1>
			<div class="div_checkin">
				<div class="div_title">
					<p>Today's 근무시간</p>
				</div>
				<div class="div_time">
					<p>00:00:00</p>
				</div>
				<div class="div_title">
					<p>Today's 출근시각</p>
				</div>
				<div class="div_time">
					<p>00:00:00</p>
				</div>
				<div class="div_title">
					<p>Today's 퇴근시각</p>
				</div>
				<div class="div_time">
					<p>00:00:00</p>
				</div>
				<div class="div_btn">
					<a href="javascript:fnCheckin()" class="btn_click" id="btn_checkin">출근</a>
				</div>
			</div>
			<div class="div_restin">
				<div class="div_title">
					<p>Today's 휴게시간</p>
				</div>
				<div class="div_time">
					<p>00:00:00</p>
				</div>
				<div class="div_title">
					<p>최근 휴식시작</p>
				</div>
				<div class="div_time">
					<p>00:00:00</p>
				</div>
				<div class="div_title">
					<p>최근 휴식종료</p>
				</div>
				<div class="div_time">
					<p>00:00:00</p>
				</div>
				<div class="div_btn">
					<a href="" class="btn_click" id="btn_restin">휴식 시작</a>
				</div>
			</div>
			<div class="div_apply">
				<div class="div_title">
					<p>잔여 연차 수</p>
				</div>
				<div class="div_time">
					<p>00</p>
				</div>
				<div class="div_btn">
					<a href="" class="btn_click" id="btn_apply">휴가/재택 신청</a>
				</div>
			</div>		
		</article>
		<article id="article_b">
		
			<h1>차트</h1>
			
		</article>
		<article id="article_c">
			<h1><br>휴가신청 상세내역</h1>
			<div>
				<div class="div_restin_title">
					<div class="div_restin_closer">
						<ul class="restin_ul_title">
							<li><a href="javascript:restin_showhide();" class="btn_i"><i class="fas fa-minus"></i></a></li>
							<li>신청기간</li>
							<li>신청일</li>
							<li>신청사유</li>
							<li>연차사용여부</li>
						</ul>
					</div>
			 	</div>
				<div class="div_restin_contents" id="div_restin_contents">
					<!-- for문 -->
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
				</div>
			</div>
		</article>
		<article id="article_d">
			<h1><br>재택근무 상세내역</h1>
			<div>
				<div class="div_home_title">
					<div class="div_home_closer">
						<ul class="home_ul_title">
							<li><a href="javascript:home_showhide();" class="btn_i"><i class="fas fa-minus"></i></a></li>
							<li>신청기간</li>
							<li>신청일</li>
							<li>승인여부</li>
						</ul>
					</div>
			 	</div>
				<div class="div_home_contents" id="div_home_contents">
					<!-- for문 -->
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
				</div>
			</div>		
		</article>
		<article id="article_e">
			<h1><br>근태조회 상세내역</h1>
			<div>
				<div class="div_wh_title">
					<div class="div_wh_closer">
						<ul class="wh_ul_title">
							<li><a href="javascript:wh_showhide();" class="btn_i"><i class="fas fa-minus"></i></a></li>
							<li>근무일자</li>
							<li>출근시간</li>
							<li>퇴근시간</li>
							<li>휴식시간</li>
							<li>추가근무</li>
							<li>총 근무시간</li>
						</ul>
					</div>
			 	</div>
				<div class="div_wh_contents" id="div_wh_contents">
					<!-- for문 -->
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
					<div><ul><li>신청기간</li><li>ㄴㅇㄹㄴㅇㄹㄴㅇ</li><li></li></ul></div>
				</div>
			</div>
		</article>
	</section>


<script>
function fnCheckin(){
	console.log("버튼눌림");
	$.ajax({
		url : "checkin"
		, data: {stfNo : 119}
		, type : "post"
		, dataType: "json"
		, success: function(data) {
			console.log("돌아옴");
			console.log(data);
			//alert(data);
			$("#btn_checkin").removeAttr('id');
			$("#btn_checkin").attr('id', "btn_checkout");
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
}

/*$("#btn_checkin").on("click", function(){
	console.log("버튼눌림");
	$.ajax({
		url : "checkin"
		, data: {stfNo : 119}
		, type : "post"
		, contentType:"json"
		, dataType: "json"
		, success: function(data) {
			console.log("돌아옴");
			alert(data);
			$("this").removeAttr('id');
			$("this").attr('id', "btn_checkout");
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
});*/

$("#btn_restin").on("click", function(){
	console.log("버튼눌림");
	$.ajax({
		url : "checkin"
		, type : "post"
		, contentType:"json"
		, dataType: "json"
		, success: function(data) {
			console.log("돌아옴");
			alert(data);
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
});


function restin_showhide(){
	var t_drc = $("#div_restin_contents");
	t_drc.toggle();
}

function home_showhide(){
	var t_drc = $("#div_home_contents");
	t_drc.toggle();
}

function wh_showhide(){
	var t_drc = $("#div_wh_contents");
	t_drc.toggle();
}

</script>
</body>
</html>