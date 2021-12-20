<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<!-- 이모티콘 -->
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/ldit_aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/main.css" /><!-- main css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Insert title here</title>
</head>
<body>
	<c:if test="${!empty authMsg}">
	<script>
		alert("${authMsg}");
	</script>
	</c:if>
	<%@ include file="ldit_header.jsp" %>
	<%@ include file="ldit_aside.jsp" %>
	<section>
        <article id="a1">
            <h1 class="mainTitle">오늘의 일정</h1>
            <h1 class="mainTitle">내정보</h1>
            <h1 class="mainTitle">공지사항</h1>

            <h1 class="mobileTitle">오늘의 일정</h1>
            <div id="todayWork">
                <!--여기 작성 3-->
                <c:forEach var="vo" items="${workList}">
                 <div class="today">
                    <div class="aaaaa"></div>
                    <div class="bbbbb" onclick="location.href='workmain'" style="cursor: pointer;">
                        <h4>${vo.workTitle }</h4>
                    </div>
                </div>
                </c:forEach>
            </div>
            <h1 class="mobileTitle">내정보</h1>
            <div id="myInfo">
             	<c:choose>
                	<c:when test="${!empty loginUser.stfImg}"><img src="<%=request.getContextPath() %>/resources/image/${loginUser.stfImg}"></c:when>
                	<c:otherwise><img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG"></c:otherwise>
               	</c:choose>
                <h3 id="miName">${loginUser.stfName}</h3>
                <c:choose>
                	<c:when test="${!empty att.attStart}">
	                	<div id="miToday">
		                    <p id="miGo">출근</p>
		                    <p id="miGoTime">${att.attStart}</p>
		                    <p id="miOut">퇴근</p>
		                    <p id="miOutTime">${att.attEnd}</p>
		                </div>
                	</c:when>
                	<c:otherwise>
                		<div id="miToday">
                			<button id="checkin_btn">오늘의 근무 시작</button>
                		</div>
                	</c:otherwise>
                </c:choose>
                <p id="miWeekHour">주간 근무시간</p>
                <progress value="60" max="100"></progress>
                <p id="miMonthHour">월간 근무시간</p>
                <progress value="20" max="100"></progress>
            </div>
            <h1 id="nonvisible" class="mobileTitle">공지사항</h1>
            <div id="restInfo">
                <div id="info_alert">
                	<table>
                		<tr>
                			<td><MARQUEE scrollamount="0"><span><i class="fas fa-exclamation-circle"></i></span> No.50 [공지] 원격훈련 중 부정훈련 예방을 위한 모니터링 실시(운영부)</MARQUEE></td>
                		</tr>
                		<tr>
                			<td><MARQUEE scrollamount="0"><span><i class="fas fa-exclamation-circle"></i></span> No.49 훈련장려금 신청(단위기간: 2021-10-19~2021-11-18)</MARQUEE></td>
                		</tr>
                		<tr>
	                		<td><MARQUEE scrollamount="0"><span><i class="fas fa-exclamation-circle"></i></span> No.48 [행정]7/19 행정팀 OT자료입니다.(고용노동부 규정, 학습안내서 및 평가계획서)</MARQUEE></td>
                		</tr>
                		<tr>
	                		<td><MARQUEE scrollamount="0"><span><i class="fas fa-exclamation-circle"></i></span> No.47 [공지]평가 일정표 안내(인사부)</MARQUEE></td>
                		</tr>
                		<tr>
	                		<td><MARQUEE scrollamount="0"><span><i class="fas fa-exclamation-circle"></i></span> No.46 글로벌사회공헌원 글로벌지속가능발전포럼(GEEF) 2022 Internship 모집 (~12/16)</MARQUEE></td>
                		</tr>
                	</table>
                </div>
                <h1 style="text-align: left;font-size: 1.4rem">오늘의 근무 정보</h1>
				<div>
					<c:choose>
						<c:when test="${empty att.attEnd}">
							<p id="miHour">일이 즐거우면 인생은 낙원이다</p>
						</c:when>
						<c:otherwise>
							<p id="miHour">오늘 총 근무시간 | ${todayHours}시간 ${todayMinutes}분</p>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${empty att.attRestAll || att.attRestAll eq '::'}">
							<p id="miHour">따뜻한 미소는 친절을 표현하는 세계 공통어이다</p>
						</c:when>
						<c:otherwise>
							<p id="restHour">오늘 총 휴식시간 | ${att.attRestAll}</p>
						</c:otherwise>
					</c:choose>
					<p id="dayoff">연차 잔여일수 | ${calApl}</p>
				</div>
			</div>
        </article>
        <article id="a2">
            <h1 id="pjTitle">진행중인 프로젝트</h1>
            <h1 id="msgTitle">쪽지 즐겨찾기</h1>
            <h1 class="mobileTitle">진행중인 프로젝트</h1>
            <div id="myProject">
            <c:forEach var="pVo" items="${projectVo}">
                <div class="mpContainer">
                	<c:if test="${pVo.proStatus == 'N'.charAt(0)}">
                		<div class="reqColorSmall" style="background-color: #3498DB"></div>
                    </c:if>
                    <c:if test="${pVo.proStatus == 'C'.charAt(0)}">
                    	<div class="reqColorSmall" style="background-color: #27AE60"></div>
                    </c:if>
                        <div class="mpInfo">
                        <h4>${pVo.proTitle}</h4>
                        <p>${pVo.proStart} ~ ${pVo.proEnd}</p>
                    </div>
                    <c:if test="${pVo.proStatus == 'N'.charAt(0)}">
                    	<div class="reqColorBig" style="background-color: #3498DB"><a href="pupdate?getproNo=${pVo.proNo}">새로운 요청</a></div>
                    </c:if>
                    <c:if test="${pVo.proStatus == 'C'.charAt(0)}">
                    	<div class="reqColorBig" style="background-color: #27AE60">진행중</div>
                    </c:if>
                </div>
             </c:forEach>
            </div>
            <h1 class="mobileTitle">쪽지 즐겨찾기</h1>
            <div id="msgBookmark">
       		    <div class="bmContainer">
                    <a href="likestaff" href="#" onClick="window.open(this.href, '_blank', 'width=410,height=533');return false" class="like_add_icon"><i class="fas fa-plus"></i></a>
                </div>
                <c:forEach var="i" items="${likeStaffList}">
	                <hr>
	                <div class="bmContainer">
	                	<c:choose>
		                	<c:when test="${!empty i.stfImg}"><img src="<%=request.getContextPath() %>/resources/image/${i.stfImg}"></c:when>
		                	<c:otherwise><img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG"></c:otherwise>
	                	</c:choose>
	                    <div class="bmInfo">
	                        <h4>${i.stfName}(${i.stfNo})</h4>
	                        <p>${i.department.deptName}</p>
	                    </div>
	                    <input type="hidden" value="${i.stfName}">
	                    <a class="sendMsg"><i class="far fa-paper-plane"></i></a>
	                    <input type="hidden" value="${i.stfId}">
	                </div>
	           </c:forEach>
            </div>         
            
        </article>
            <!--메세지 모달 창-->
			<div id="modal_wrapper" class="modal_wrapper">
			  <!-- Modal content -->
			  <div class="modal_content">
			  	<a href="javascript:closeModalBtn()"><i class="fas fa-times"></i></a>
			  	<form action="sendMsg" method="post">
			  		<input type="hidden" name="stfNo" value="${loginUser.stfNo}" required>
					<input type="hidden" name="sStfId" value="${loginUser.stfId}" required>
					<input id="receiveID" type="hidden" name="rStfId" required="required">
					<input id="show_name" type="text" readonly="readonly" value="님에게 쪽지보내기">
			  		<label for="send_tt">제목</label>
					<input id="send_tt" type="text" name="mTitle" required>
					<label for="send_ct">내용</label>
					<textarea id="send_ct" name="mContent" required></textarea>
					<div><button id="btn_send" class="btn_send">발신</button></div>
				</form>
			  </div>
			</div>  
    </section>
    
    <script type="text/javascript">
    //location.reload();
    	//모달창 열기
    	$(".sendMsg").click(function () {
    		  	var modal = document.getElementById("modal_wrapper");
    			modal.style.display = 'block';
//    			$(this).parent().css('color','red');
    			let showName = $(this).prev("input").val();
    			let showID = $(this).next("input").val();
    			console.log(showName);
    			console.log(showID);
    			$("#show_name").val(showName+"님에게 쪽지보내기");
    			$("#receiveID").val(showID);
    			console.log($("#show_name").val());
    			console.log($("#receiveID").val());
		});
    	//모달창 열기
//    	function openModalBtn(e){
  //  		if(e == null || e == undefined){
    //			alert("수신인 정보가 없습니다");
   // 		}
   // 		var modal = document.getElementById("modal_wrapper");
	//  		modal.style.display = 'block';
	//		let showName = e;
	//		$("#show_name").val(e+" 님에게 쪽지 보내기");
	//		$("#receiveID").val(showName);
	//		sendID = $("#receiveID").val();
	//		console.log(sendID);
	//	}
    	//모달창 닫기
    	function closeModalBtn() {
    		var modal = document.getElementById("modal_wrapper");
    		modal.style.display = "none";
		}
    	
    	$("#send_tt").on("keyup", function() {
    		if ($(this).val().length > 100) {
    			$(this).val($(this).val().substring(0, 100));
    		}
    	});
    	
    	$("#send_ct").on("keyup", function() {
    		if ($(this).val().length > 100) {
    			$(this).val($(this).val().substring(0, 100));
    		}
    	});
    	    
    	//출근
    	$("#checkin_btn").click(function () {
    		$.ajax({
    			url : "checkin"
    			, data: {stfNo : "${loginUser.stfNo}"}
    			, type : "post"
    			, success: function(data) {
    				location.reload();
    			}
    			, error : function(request, status, errorData){ 
    				 alert("error code : " + request.status + "\n" 
    						 + "message : " + request.responseText + "\n" 
    						 + "error : " + errorData);}
    		});
		});
    
    	
	    
	    //쪽지 알림
	    let msgAlert = setInterval(getalert, 10000);
	    function getalert() {
			//bell
			$("#bellalert").remove();
    		$.ajax({
    			url:"getalert.do",
    			data:{},
    			contentType: 'application/json; charset=utf-8',
    			type: "GET",
    			dataType: "json",
    			success: function(result){
    				if(result != null){
    					$("#bell").append("<div id='bellalert'><p>"+result.length+"</p></div>");
    				}else{
    				}
    			},
    			error : function(e) {
    				alert("code:"+e.status+"\n"+"message:"+e.responseText+"\n"+"error:"+e);
		        }
    		})
		}
	    $("#bell").on("click", function() {
			location.href = "receiveBox";
	    })
    </script>
</body>
</html>