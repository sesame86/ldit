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
            <h1 class="mainTitle">휴식정보</h1>

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
                <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                <h3 id="miName">${loginUser.stfName}</h3>
                <c:choose>
					<c:when test="${empty attEndFormat}">
		                <p id="miHour">일이 즐거우면 인생은 낙원이다</p>					
					</c:when>
					<c:otherwise>
						<p id="miHour">오늘 총 근무시간: ${todayHours}시간 ${todayMinutes}분</p>
					</c:otherwise>
                </c:choose>
                <div id="miToday">
                    <p id="miGo">출근</p>
                    <p id="miGoTime">${attStart}</p>
                    <p id="miOut">퇴근</p>
                    <p id="miOutTime">${attEndFormat}</p>
                </div>
                <p id="miWeekHour">주간 근무시간</p>
                <progress value="60" max="100"></progress>
                <p id="miMonthHour">월간 근무시간</p>
                <progress value="20" max="100"></progress>
            </div>
            <h1 class="mobileTitle">휴식정보</h1>
            <div id="restInfo">
                <!--여기 작성 5-->
                <div style="margin: 5em auto;">

                    <p id="restHour">오늘 총 휴식시간</p>
                    <div id="restToday">
                        <p id="restGo" > 휴식</p>
                    </div>
                    <div id="dayoffToday">
                    <p id="dayoff">연차 잔여일수</p>
                    <p id="dayoffconunt">10 일</p>
                    </div>
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
                    	<div class="reqColorBig" style="background-color: #3498DB">새로운 요청</div>
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
                <hr>
                <div class="bmContainer">
                    <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                    <div class="bmInfo">
                        <h4>김예은</h4>
                        <p>개발부</p>
                    </div>
                    <a class="sendMsg" href="#"><i class="far fa-paper-plane"></i></a>
                </div>
                <hr>
                <div class="bmContainer">
                    <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                    <div class="bmInfo">
                        <h4>신유리</h4>
                        <p>인사부</p>
                    </div>
                    <a class="sendMsg" href="#"><i class="far fa-paper-plane"></i></a>
                </div>
                <hr>
                <div class="bmContainer">
                    <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                    <div class="bmInfo">
                        <h4>김가희</h4>
                        <p>개발부</p>
                    </div>
                    <a class="sendMsg" href="#"><i class="far fa-paper-plane"></i></a>
                </div>
                <hr>
                <div class="bmContainer">
                    <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                    <div class="bmInfo">
                        <h4>추대경</h4>
                        <p>개발부</p>
                    </div>
                    <a class="sendMsg" href="#"><i class="far fa-paper-plane"></i></a>
                </div>
                <hr>
                <div class="bmContainer">
                    <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                    <div class="bmInfo">
                        <h4>노형욱</h4>
                        <p>개발부</p>
                    </div>
                    <a class="sendMsg" href="#"><i class="far fa-paper-plane"></i></a>
                </div>
            </div>
        </article>
        <h1 style="display: none;" id="test01">ddddd</h1>
    </section>
    <script type="text/javascript">
    
    
    
    	
	    
	    //쪽지 알림
	    //let msgAlert = setInterval(getalert, 10000);
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