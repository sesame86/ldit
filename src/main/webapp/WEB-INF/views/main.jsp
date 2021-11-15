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

            </div>
            <h1 class="mobileTitle">내정보</h1>
            <div id="myInfo">
                <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                <h3 id="miName">홍길동</h3>
                <p id="miHour">오늘의 근무시간 00:00:00</p>
                <div id="miToday">
                    <p id="miGo">출근</p>
                    <p id="miGoTime">00:00:00</p>
                    <p id="miOut">퇴근</p>
                    <p id="miOutTime">00:00:00</p>
                </div>
                <p id="miWeekHour">주간 근무시간</p>
                <progress value="60" max="100"></progress>
                <p id="miMonthHour">월간 근무시간</p>
                <progress value="20" max="100"></progress>
            </div>
            <h1 class="mobileTitle">휴식정보</h1>
            <div id="restInfo">
                <!--여기 작성 5-->

            </div>
        </article>
        <article id="a2">
            <h1 id="pjTitle">진행중인 프로젝트</h1>
            <h1 id="msgTitle">쪽지 즐겨찾기</h1>
            <h1 class="mobileTitle">진행중인 프로젝트</h1>
            <div id="myProject">
                <div class="mpContainer">
                    <div class="reqColorSmall"></div>
                        <div class="mpInfo">
                        <h4>프로젝트명</h4>
                        <p>2021/11/11 ~ 2021/12/20</p>
                    </div>
                    <div class="reqColorBig">새로운 요청</div>
                </div>
                <div class="mpContainer">
                    <div class="reqColorSmall"></div>
                        <div class="mpInfo">
                        <h4>프로젝트명</h4>
                        <p>2021/11/11 ~ 2021/12/20</p>
                    </div>
                    <div class="reqColorBig">새로운 요청</div>
                </div>
                <div class="mpContainer">
                    <div class="reqColorSmall"></div>
                        <div class="mpInfo">
                        <h4>프로젝트명</h4>
                        <p>2021/11/11 ~ 2021/12/20</p>
                    </div>
                    <div class="reqColorBig">새로운 요청</div>
                </div>
                <div class="mpContainer">
                    <div class="reqColorSmall" style="background-color: #27AE60;"></div>
                        <div class="mpInfo">
                        <h4>프로젝트명</h4>
                        <p>2021/11/11 ~ 2021/12/20</p>
                    </div>
                    <div class="reqColorBig" style="background-color: #27AE60;">진행중</div>
                </div>
                <div class="mpContainer">
                    <div class="reqColorSmall" style="background-color: #27AE60;"></div>
                        <div class="mpInfo">
                        <h4>프로젝트명</h4>
                        <p>2021/11/11 ~ 2021/12/20</p>
                    </div>
                    <div class="reqColorBig" style="background-color: #27AE60;">진행중</div>
                </div>
                <div class="mpContainer">
                    <div class="reqColorSmall" style="background-color: #27AE60;"></div>
                        <div class="mpInfo">
                        <h4>프로젝트명</h4>
                        <p>2021/11/11 ~ 2021/12/20</p>
                    </div>
                    <div class="reqColorBig" style="background-color: #27AE60;">진행중</div>
                </div>
                <div class="mpContainer">
                    <div class="reqColorSmall" style="background-color: #27AE60;"></div>
                        <div class="mpInfo">
                        <h4>프로젝트명</h4>
                        <p>2021/11/11 ~ 2021/12/20</p>
                    </div>
                    <div class="reqColorBig" style="background-color: #27AE60;">진행중</div>
                </div>
            </div>
            <h1 class="mobileTitle">쪽지 즐겨찾기</h1>
            <div id="msgBookmark">
                <div class="bmContainer">
                    <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                    <div class="bmInfo">
                        <h4>김예은</h4>
                        <p>개발팀</p>
                    </div>
                    <a class="sendMsg" href="#"><i class="far fa-paper-plane"></i></a>
                </div>
                <hr>
                <div class="bmContainer">
                    <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                    <div class="bmInfo">
                        <h4>김예은</h4>
                        <p>개발팀</p>
                    </div>
                    <a class="sendMsg" href="#"><i class="far fa-paper-plane"></i></a>
                </div>
                <hr>
                <div class="bmContainer">
                    <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                    <div class="bmInfo">
                        <h4>김예은</h4>
                        <p>개발팀</p>
                    </div>
                    <a class="sendMsg" href="#"><i class="far fa-paper-plane"></i></a>
                </div>
                <hr>
                <div class="bmContainer">
                    <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                    <div class="bmInfo">
                        <h4>김예은</h4>
                        <p>개발팀</p>
                    </div>
                    <a class="sendMsg" href="#"><i class="far fa-paper-plane"></i></a>
                </div>
                <hr>
                <div class="bmContainer">
                    <img src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                    <div class="bmInfo">
                        <h4>김예은</h4>
                        <p>개발팀</p>
                    </div>
                    <a class="sendMsg" href="#"><i class="far fa-paper-plane"></i></a>
                </div>
            </div>
        </article>
    </section>
</body>
</html>