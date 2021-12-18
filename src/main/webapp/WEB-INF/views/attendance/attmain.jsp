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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/attmain.css" /><!-- basic css -->
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
					<p id="working_time">00:00:00</p>
				</div>
				<div class="div_title">
					<p>Today's 출근시각</p>
				</div>
				<div class="div_time">
					<p id="checkin_time">00:00:00</p>
				</div>
				<div class="div_title">
					<p>Today's 퇴근시각</p>
				</div>
				<div class="div_time">
					<p id="checkout_time">00:00:00</p>
				</div>
				<div class="div_btn">
					 	<a href="javascript:fnCheckin()" class="btn_click" id="btn_check">출근</a>
				</div>
			</div>
			<div class="div_restin">
				<div class="div_title">
					<p>Today's 휴게시간</p>
				</div>
				<div class="div_time">
					<p id="rest_time">00:00:00</p>
				</div>
				<div class="div_title">
					<p>최근 휴식시작</p>
				</div>
				<div class="div_time">
					<p id="restin_time">00:00:00</p>
				</div>
				<div class="div_title">
					<p>최근 휴식종료</p>
				</div>
				<div class="div_time">
					<p id="restout_time">00:00:00</p>
				</div>
				<div class="div_btn">
					<a href="javascript:fnRestIn()" class="btn_click" id="btn_rest">휴식 시작</a>
				</div>
			</div>
			<div class="div_apply">
				<div class="div_title">
					<p>발생 연차</p>
				</div>
				<div class="div_time">
					<p id="calAplT">00개</p>
				</div>
				<div class="div_title">
					<p>사용 연차</p>
				</div>
				<div class="div_time">
					<p id="calAplU">00개</p>
				</div>
				<div class="div_title">
					<p>잔여 연차</p>
				</div>
				<div class="div_time">
					<p id="calApl">00개</p>
				</div>
				<div class="div_btn">
					<a href="javascript:fnApply()" class="btn_click" id="btn_apply">휴가/재택 신청</a>
				</div>
			</div>		
		</article>
<!--		<article id="article_b">
		
			<h1>차트</h1>
			
		</article>   -->
		<article id="article_c">
			<h1><br>휴가신청 상세내역<input type="checkbox" name="check_able1" value="onlyAble"></h1>
			<div>
				<div class="div_restin_title">
					<div class="div_restin_closer">
						<ul class="restin_ul_title">
							<li><a href="javascript:restin_showhide();" class="btn_i"><i class="fas fa-minus"></i></a></li>
							<li>휴가시작일자</li>
							<li>휴가종료일자</li>
							<li>신청일</li>
							<li>신청사유</li>
							<li>연차사용여부</li>
						</ul>
					</div>
			 	</div>
				<div class="div_restin_contents" id="div_restin_contents">
				</div>
				<div class="div_restin_paging" id="div_restin_paging">
					<ul></ul>
				</div>
			</div>
		</article>
		<article id="article_d">
			<h1><br>재택근무 상세내역<input type="checkbox" name="check_able2" value="onlyAble"></h1>
			<div>
				<div class="div_home_title">
					<div class="div_home_closer">
						<ul class="home_ul_title">
							<li><a href="javascript:home_showhide();" class="btn_i"><i class="fas fa-minus"></i></a></li>
							<li>재택시작일자</li>
							<li>재택종료일자</li>
							<li>신청일</li>
						</ul>
					</div>
			 	</div>
				<div class="div_home_contents" id="div_home_contents">
				</div>
				<div class="div_home_paging" id="div_home_paging">
					<ul></ul>
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
							<li>총 근무시간</li>
							<li>출근시간</li>
							<li>퇴근시간</li>
							<li>휴식시간</li>
						</ul>
					</div>
			 	</div>
				<div class="div_wh_contents" id="div_wh_contents">
				</div>
				<div class="div_wh_paging" id="div_wh_paging">
					<ul></ul>
				</div>
			</div>

		</article>
	</section>
	
	
	<div id="modal_wrapper" class="modal_wrapper">
		<div class="modal_content">
			<div class="div_tab">
				<button id="btn_m_first" class="btn_tablink">휴가 신청</button><button class="btn_tablink">재택 신청</button>
			</div>
			<div id="div_m_restapply" class="div_tabcontent">
				<form id="restApply" action="restapply" method="post">
					<div id="div_m_restapply_content">
						<h1>휴가 신청서</h1>
						<label for="select_restReason">사유</label>
						<select id="select_restReason" class="select_restReason" name="xiuNo" required>
							<option selected value="">--선택하기--</option>
						</select>
						<label for="from_apl">연차 적용여부</label>
	                        <input type="text" id="from_apl" readonly>
						<label for="">시작일자</label>
						<input type="date" id="xaStart" name="xaStart" required>
						<label for="">종료일자</label>
						<input type="date" id="xaEnd" name="xaEnd" required>
	                    <button id="btn_restRegist">등록</button>
	                    <span class="span_btn_restRegist">설정된 휴가코드가 없습니다.<br>관리자에게 문의해주세요</span>
					</div>
				</form>
			</div>
			<div id="div_m_whomeapply" class="div_tabcontent">
				<form id="whomeApply" action="whomeapply" method="post">
					<div id="div_m_whomeapply_content">
						<h1>재택근무 신청서</h1>
						<label for="">시작일자</label>
						<input type="date" id="whStart" name="whStart" required>
						<label for="">종료일자</label>
						<input type="date" id="whEnd" name="whEnd" required>
	                    <button id="btn_whomeRegist">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script>
let ckInterval = "";
let attNoFormat = "";
let attStartFormat = "";
let attEndFormat = "";
let restStartFormat = "";
let restEndFormat = "";
let attStartDateTime = "";
let calAplT = "";
let calAplU = "";
let elapsedWTime = "";
let elapsedRTime = "";
let brNo = "";
let XiuApl = [];

let today = new Date();
let tomorrow = new Date(today.setDate(today.getDate()+1));
let tomorrowYear = tomorrow.getFullYear();
let tomorrowMonth = (tomorrow.getMonth()+1);
let tomorrowDate = tomorrow.getDate();
let minDate = tomorrowYear+"-"+tomorrowMonth+"-"+tomorrowDate;
$("#xaStart").attr('min', minDate);
$("#xaEnd").attr('min', minDate);
$("#whStart").attr('min', minDate);
$("#whEnd").attr('min', minDate);

$(function(){
	if("${chooseID}" != null){
		location.href="#${chooseID}";		
	}
});

$("#restApply").submit(function(){
	var dateFrom = document.getElementById("xaStart");
	var dateTo = document.getElementById("xaEnd");
	dateFrom = new Date(dateFrom.value);
	var fromYear = dateFrom.getFullYear();
	var fromMonth = dateFrom.getMonth() + 1;
	var fromDay = dateFrom.getDate();
	dateFrom = fromYear +'/'+ fromMonth +'/'+fromDay;
	dateTo = new Date(dateTo.value);
	var toYear = dateTo.getFullYear();
	var toMonth = dateTo.getMonth() + 1;
	var toDay = dateTo.getDate();
	dateTo = toYear +'/'+ toMonth +'/'+toDay;
	if(dateFrom > dateTo){
		alert("시작일자가 종료일자보다 먼저 일 수 없습니다.");
		return false;
	}
	return true;
});

$("#whomeApply").submit(function(){
	var dateFrom = document.getElementById("whStart");
	var dateTo = document.getElementById("whEnd");
	dateFrom = new Date(dateFrom.value);
	var fromYear = dateFrom.getFullYear();
	var fromMonth = dateFrom.getMonth() + 1;
	var fromDay = dateFrom.getDate();
	dateFrom = fromYear +'/'+ fromMonth +'/'+fromDay;
	dateTo = new Date(dateTo.value);
	var toYear = dateTo.getFullYear();
	var toMonth = dateTo.getMonth() + 1;
	var toDay = dateTo.getDate();
	dateTo = toYear +'/'+ toMonth +'/'+toDay;
	if(dateFrom > dateTo){
		alert("시작일자가 종료일자보다 먼저 일 수 없습니다.");
		return false;
	}
	return true;
});

$(document).ready(function(){
	$.ajax({
		url : "attmaingetdata"
		, type : "post"
		, dataType: "json"
		, success: function(data) {
			if(!isNull(data.att)){
				attStartFormat = data.att.attStart;
				attEndFormat = data.att.attEnd;
				elapsedRTime = data.att.attRestAll;
			} 
			attStartDateTime = data.attStartDateTime;
			elapsedWTime = data.elapsedWTime;
			if(!isNull(data.wb)){
				restStartFormat = data.wb.brStart;
				restEndFormat = data.wb.brEnd;
				brNo = data.wb.brNo;
			}
			if(data.xiuxiList != null){
				$.each(data.xiuxiList, function(i) {
					var xiuNo = data.xiuxiList[i].xiuNo;
					var xiuReason = data.xiuxiList[i].xiuReason;
					var xiuAplYesNo = data.xiuxiList[i].xiuAplYesNo;
					var opt = '<option value='+xiuNo+'>'+xiuReason+'</option>'
					$("#select_restReason").append(opt);
					XiuApl.push(xiuAplYesNo);
				});
			} else {
				$("#btn_restRegist").attr('disabled', 'true');
				$("#btn_restRegist").hover(function (){
				$(".span_btn_restRegist").addClass('.on');
				});
			}
			calAplT = data.calAplT;
			calAplU = data.calAplU;
			
			if(!isNull(attStartFormat) && isNull(attEndFormat)){
				ckInterval = setInterval(countTime, 1000);
				$("#btn_check").attr('href', "javascript:fnCheckOut()");
				$("#btn_check").html("퇴근");
			}
			if(!isNull(attStartFormat) && !isNull(attEndFormat)){
				$("#btn_check").attr('href', "#");
				$("#btn_check").addClass('notable');
				$("#btn_check").html("출근");
				$("#btn_rest").attr('href', "#");
				$("#btn_rest").addClass('notable');
				$("#btn_rest").html("휴식 시작");
			}
			if(!isNull(restStartFormat) && isNull(restEndFormat)){
				$("#btn_rest").attr('href', "javascript:fnRestOut()");
				$("#btn_rest").html("휴식 종료");
			}

			$("#checkin_time").html(setDefaultValueAtNull(attStartFormat));
			$("#checkout_time").html(setDefaultValueAtNull(attEndFormat));
			$("#restin_time").html(setDefaultValueAtNull(restStartFormat));
			$("#restout_time").html(setDefaultValueAtNull(restEndFormat));
			
			$("#working_time").html(setDefaultValueAtNull(elapsedWTime));
			if(elapsedRTime == "::"){
				elapsedRTime = "00:00:00";
			}
			$("#rest_time").html(setDefaultValueAtNull(elapsedRTime));
			
			$("#calAplT").html(calAplT);
			$("#calAplU").html(calAplU);
			$("#calApl").html(calAplT-calAplU);
			
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
 	
});

function isNull(obj) {
	return (typeof obj != "undefined" && obj != null && obj != "") ? false : true;
}
function setDefaultValueAtNull(obj) {
	return (typeof obj != "undefined" && obj != null && obj != "") ? obj : "00:00:00";
}

function countTime() {
	var nowDate = new Date();
	var str;
	console.log(nowDate);
	if(attStartDateTime.length<7){
		attStartFormat = attStartFormat.replaceAll(":", "");
		str = nowDate.getFullYear()+addZero(nowDate.getMonth(), 2)+addZero(nowDate.getDate(), 2)+attStartFormat;
	} else {
		str = attStartDateTime;
	}
	var by = str.substr(0,4);
	var bmm = str.substr(4,2)-1;
	var bd = str.substr(6,2);
	var bh = str.substr(8,2);
	var bm = str.substr(10,2);
	var bs = str.substr(12,2);
	var checkinDate = new Date(by, bmm, bd, bh, bm, bs);
	console.log(checkinDate);
	var gapTime = nowDate.getTime()-checkinDate.getTime();
	console.log(gapTime);
	var wh = Math.floor((gapTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	var wm = Math.floor((gapTime % (1000 * 60 * 60)) / (1000 * 60));
	var ws = Math.floor((gapTime % (1000 * 60)) / 1000);
	var totalWorkingTime = addZero(wh,2)+":"+addZero(wm,2)+":"+addZero(ws,2);
	$("#working_time").html("");
	$("#working_time").html(totalWorkingTime);	
}

function addZero(num, digits){
	var zero = '';
	num = num.toString();
	if (num.length < digits) {
		for (var i = 0; i < digits - num.length; i++)
	    zero += '0';
	  }
	return zero + num;
}

getPageRest(1);
$("input[name=check_able1]").change(function() {
    if($(this).is(":checked")) { 
    	getPageRest(1);
    } else {
    	getPageRest(1);
    }
});

function getPageRest(page) {
	var keyValue = $("input[name=check_able1]:checked").val();
	$.ajax({
		url : "getxalist"
		, data : {stfNo : "${loginUser.stfNo}"
					, currentPage : page 
					, keyValue : keyValue
					}
		, type : "get"
		, dataType: "json"
		, success: function(data) {
			console.log(data);
			var result = data.xiuxiApplyList;
			if(result.length==0){
				$("#div_restin_contents").html("");
				$("#div_restin_contents").html('<ul><li class="li_no_xaList">신청한 휴가 내역이 없습니다.</li></ul>');
			} else {
				<!--리스트불러오기-->
				var r = '';				
				$.each(result, function(i){
					r +='<div>';
					r +='<ul>';
					r +='<li>'+result[i].xaStart+'</li>';
					r +='<li>'+result[i].xaEnd+'</li>';					
					r +='<li>'+result[i].xaWhen+'</li>';
					r +='<li>'+result[i].xiuxi.xiuReason+'</li>';					
					if(result[i].xiuxi.xiuAplYesNo == 0){
					r +='<li>'+"N"+'</li>';		
					} else if(result[i].xiuxi.xiuAplYesNo == 1){
					r +='<li>'+"Y"+'</li>';		
					}
					r +='</ul>';
					r +='</div>';
				})
				$("#div_restin_contents").html("");
				$("#div_restin_contents").html(r);
				<!--페이징처리-->
				var p = '';
				for(var d=data.startPage; d<=data.endPage; d++){
					if(d==data.currentPage){
						p += '<li>'+'<a href="javascript:getPageRest('+d+')" name="a_current" class="a_current">'+d+'</a>'+'</li>';
					}else{
						p += '<li>'+'<a href="javascript:getPageRest('+d+')">'+d+'</a>'+'</li>';
					}
				}
				$("#div_restin_paging > ul").html("");
				$("#div_restin_paging > ul").html(p);
			} 
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
}

getPageWhome(1);
$("input[name=check_able2]").change(function() {
    if($(this).is(":checked")) { 
    	getPageWhome(1);
    } else {
    	getPageWhome(1);
    }
});

function getPageWhome(page) {
	var keyValue = $("input[name=check_able2]:checked").val();
	$.ajax({
		url : "getwhomelist"
		, data : {stfNo : "${loginUser.stfNo}"
					, currentPage : page 
					, keyValue : keyValue
					}
		, type : "get"
		, dataType: "json"
		, success: function(data) {
			console.log(data);
			var result = data.whomeList;
			if(result.length==0){
				$("#div_home_contents").html("");
				$("#div_home_contents").html('<ul><li class="li_no_xaList">신청한 재택근무 내역이 없습니다.</li></ul>');
			} else {
				<!--리스트불러오기-->
				var r = '';				
				$.each(result, function(i){
					r +='<div>';
					r +='<ul>';
					r +='<li>'+result[i].whStart+'</li>';
					r +='<li>'+result[i].whEnd+'</li>';					
					r +='<li>'+result[i].whWhen+'</li>';
					r +='</ul>';
					r +='</div>';
				})
				$("#div_home_contents").html("");
				$("#div_home_contents").html(r);
				<!--페이징처리-->
				var p = '';
				for(var d=data.startPage; d<=data.endPage; d++){
					if(d==data.currentPage){
						p += '<li>'+'<a href="javascript:getPageWhome('+d+')" name="a_current" class="a_current">'+d+'</a>'+'</li>';
					}else{
						p += '<li>'+'<a href="javascript:getPageWhome('+d+')">'+d+'</a>'+'</li>';
					}
				}
				$("#div_home_paging > ul").html("");
				$("#div_home_paging > ul").html(p);
			} 
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
}

getPageWork(1);
function getPageWork(page) {
	$.ajax({
		url : "getattlist"
		, data : {stfNo : "${loginUser.stfNo}"
					, currentPage : page}
		, type : "get"
		, dataType: "json"
		, success: function(data) {
			var restCode = data.restCode;
			var result = data.attList;
			let totalWorkTime = "";
			if(result.length==0){
				$("#div_wh_contents").html("");
				$("#div_wh_contents").html('<ul><li class="li_no_xaList">근무 내역이 없습니다.</li></ul>');
			} else {
				<!--리스트불러오기-->
				var r = '';				
				$.each(result, function(i){
					let restAllTime = result[i].attRestAll;
					let attSTime = "";
					let attETime = "";
					if(restAllTime=="::" || isNull(restAllTime)){
						restAllTime = null;
					}
					r +='<div>';
					r +='<ul>';
					r +='<li>'+result[i].attNo+'</li>'; //근무일자
					if(restCode == 1 && isNull(restAllTime)){
						attSTime = attTimeFormat(result[i].attStart);
						attETime = attTimeFormat(result[i].attEnd);
						totalWorkTime = calTimeTwo(attSTime, attETime);
					} else if(restCode == 1 && !isNull(restAllTime)) {
						attSTime = attTimeFormat(result[i].attStart);
						attETime = attTimeFormat(result[i].attEnd);
						totalWorkTime = calTimeThree(attSTime, attETime, restAllTime);
					} else {
						attSTime = attTimeFormat(result[i].attStart);
						attETime = attTimeFormat(result[i].attEnd);
						totalWorkTime = calTimeTwo(attSTime, attETime);
					}
					r +='<li>'+totalWorkTime+'</li>'; //총근무시간
					r +='<li>'+timeFormat(result[i].attStart)+'</li>'; //출근시각					
					r +='<li>'+timeFormat(result[i].attEnd)+'</li>'; //퇴근시각
					if(isNull(restAllTime)){
						restAllTime = "00:00:00";
					}
					r +='<li>'+restAllTime+'</li>';
					r +='</ul>';
					r +='</div>';
				})
				$("#div_wh_contents").html("");
				$("#div_wh_contents").html(r);
				<!--페이징처리-->
				var p = '';
				for(var d=data.startPage; d<=data.endPage; d++){
					if(d==data.currentPage){
						p += '<li>'+'<a href="javascript:getPageWork('+d+')" name="a_current" class="a_current">'+d+'</a>'+'</li>';
					}else{
						p += '<li>'+'<a href="javascript:getPageWork('+d+')">'+d+'</a>'+'</li>';
					}
				}
				$("#div_wh_paging > ul").html("");
				$("#div_wh_paging > ul").html(p);
			} 
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
}


function timeFormat(e){
	let getTime = e;
	let getTimeH = getTime.substr(8,2);
	let getTimeM = getTime.substr(10,2);
	let getTimeS = getTime.substr(12,2);
	let formattedTime = getTimeH+":"+getTimeM+":"+getTimeS;
	return formattedTime;
}


function attTimeFormat(e){
	var str = e;
	var by = str.substr(0,4);
	var bmm = str.substr(4,2)-1;
	var bd = str.substr(6,2);
	var bh = str.substr(8,2);
	var bm = str.substr(10,2);
	var bs = str.substr(12,2);
	let attTimeAfter = new Date(by, bmm, bd, bh, bm, bs);
	return attTimeAfter;
}

function calTimeTwo(x, y){
	var gapTime = y-x;
	var wh = Math.floor((gapTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	var wm = Math.floor((gapTime % (1000 * 60 * 60)) / (1000 * 60));
	var ws = Math.floor((gapTime % (1000 * 60)) / 1000);
	var totalWorkingTime = addZero(wh,2)+":"+addZero(wm,2)+":"+addZero(ws,2);
	return totalWorkingTime
}

function calTimeThree(x, y, z){
	//퇴근시간-출근시간
	var gapTime = y-x;
	var wh = Math.floor((gapTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	var wm = Math.floor((gapTime % (1000 * 60 * 60)) / (1000 * 60));
	var ws = Math.floor((gapTime % (1000 * 60)) / 1000);
	var calculatedTime = addZero(wh,2)+":"+addZero(wm,2)+":"+addZero(ws,2);
	//휴식시간 포맷바꾸기
	var nowDate = new Date();
	let restTimeBefore = z.replaceAll(":", "");
	var str = nowDate.getFullYear()+addZero(nowDate.getMonth(), 2)+addZero(nowDate.getDate(), 2)+restTimeBefore;
	var ry = str.substr(0,4);
	var rmm = str.substr(4,2)-1;
	var rd = str.substr(6,2);
	var rh = str.substr(8,2);
	var rm = str.substr(10,2);
	var rs = str.substr(12,2);
	let restTimeAfter = new Date(ry, rmm, rd, rh, rm, rs);
	//calculatedTime 포맷바꾸기
	let calTimeBefore = calculatedTime.replaceAll(":", "");
	var str = nowDate.getFullYear()+addZero(nowDate.getMonth(), 2)+addZero(nowDate.getDate(), 2)+calTimeBefore;
	var cy = str.substr(0,4);
	var cmm = str.substr(4,2)-1;
	var cd = str.substr(6,2);
	var ch = str.substr(8,2);
	var cm = str.substr(10,2);
	var cs = str.substr(12,2);
	let calTimeAfter = new Date(cy, cmm, cd, ch, cm, cs);
	//퇴근시간-출근시간-휴식시간
	var gapTime = calTimeAfter - restTimeAfter;
	var wh = Math.floor((gapTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	var wm = Math.floor((gapTime % (1000 * 60 * 60)) / (1000 * 60));
	var ws = Math.floor((gapTime % (1000 * 60)) / 1000);
	var totalWorkingTime = addZero(wh,2)+":"+addZero(wm,2)+":"+addZero(ws,2);
	return totalWorkingTime
}

function fnCheckin(){
	$.ajax({
		url : "checkin"
		, data: {stfNo : "${loginUser.stfNo}"}
		, type : "post"
		, success: function(data) {
			console.log(data);
			
			if(!isNull(data)){
				attStartDateTime = "";
				attStartFormat = data;
				ckInterval = setInterval(countTime, 1000);
				$("#btn_check").attr('href', "javascript:fnCheckOut()");
				$("#btn_check").html("퇴근");
				$("#checkin_time").html(attStartFormat);
			} else {
				alert("출근 등록에 실패했습니다.");
			}
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
}

function fnCheckOut(){
	console.log("버튼눌림");
	$.ajax({
		url : "checkout"
		, data: {stfNo : "${loginUser.stfNo}"}
		, type : "post"
		, success: function(data) {
			console.log(data);
			if(!isNull(data)){
			$("#btn_check").attr('href', "#");
			$("#btn_check").addClass('notable');
			$("#btn_check").html("출근");
			$("#checkout_time").html(data);
			clearInterval(ckInterval);
			// 휴식종료기능 controller에서 되고 "휴식 시작" 버튼 눌려지지 않도록 함.
			$("#btn_rest").attr('href', "#");
			$("#btn_rest").addClass('notable');
			$("#btn_rest").html("휴식 시작");
			} else {
				alert("퇴근등록에 실패했습니다.");
				location.reload();
			}
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
}

function fnRestIn(){
	if(!isNull(attStartFormat) && isNull(attEndFormat)){
	$.ajax({
		url : "restin"
		, data: {stfNo : "${loginUser.stfNo}"}
		, type : "post"
		, dataType: "json"
		, success: function(data) {
			console.log(data);
			if(!isNull(data)){
				brNo = data.brNo;
				$("#btn_rest").attr('href', "javascript:fnRestOut()");
				$("#btn_rest").html("휴식 종료");
				$("#restin_time").html(data.brStart);
				$("#restout_time").html("00:00:00");
			} else {
				alert("휴식등록에 실패했습니다.");
			}
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
	} else{
		alert("출근 등록을 먼저 진행해주세요.");
	}
}

function fnRestOut(){
	if(!isNull(attStartFormat) && isNull(attEndFormat)){
	$.ajax({
		url : "restout"
		, data: {brNo : brNo}
		, type : "post"
		, dataType: "json"
		, success: function(data) {
			console.log(data);
			if(!isNull(data)){
			$("#btn_rest").attr('href', "javascript:fnRestIn()");
			$("#btn_rest").html("휴식 시작");
			restEndFormat = data.restEndFormat;
			elapsedRTime = data.elapsedRTime;
			$("#restout_time").html(restEndFormat);
			$("#rest_time").html(elapsedRTime);

			} else {
				alert("휴식종료에 실패했습니다.");
			}
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
	} else {
		alert("이미 퇴근했습니다.");
	}
}

$("select[name=xiuNo]").on('change', function() {
	let idxs = $("#select_restReason option").index($("#select_restReason option:selected"));
	if(idxs == 0){
		$("#from_apl").val("");
	} else {
	let valueAPL = XiuApl.at(idxs);
	if(valueAPL == 0){
		valueAPL = "N";
	} else {
		valueAPL = "Y";
	}
	$("#from_apl").val(valueAPL);		
	}
});

$(".div_tab > button").on('click', function(){
    var thisOne = $(this);
    var idx = thisOne.index();
    var pOne = thisOne.closest('.modal_content');
    pOne.find('.div_tab button').removeClass('on');
    pOne.find('.div_tabcontent').removeClass('on');
    pOne.find('.div_tabcontent:eq('+idx+')').addClass('on');
    thisOne.addClass('on');
});

var modal = document.getElementById("modal_wrapper");

function fnApply(){
	$("#btn_m_first").addClass('on');
	$("#div_m_restapply").addClass('on');
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