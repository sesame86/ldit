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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/team_main.css" /><!-- team_main css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp" %>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp" %>
	<section>
        <a id="leftArrow"><i class="fas fa-chevron-left"></i></a>
        <div id="teamContainer">
            <h1>Team</h1>
            <c:if test="${id == 'TM'}">
            	<a href="teamadd" id="teamAdd"><i class="fas fa-user-plus"></i></a>
            </c:if>
            <a href="teamadd" id="teamAdd"><i class="fas fa-user-plus"></i></a>
            <div id="teamConGrid">
                <article class="card">
                    <img class="cardImg" src="https://htmlcolorcodes.com/assets/images/colors/light-gray-color-solid-background-1920x1080.png">
                    <div class="cardGridCon">
                        <h4 class="teamName">팀명</h4>
                        <div class="cardGrid">
                            <p>TM</p>
                            <div>김예은</div>
                            <p>팀목표</p>
                            <progress value="60" max="100"></progress>
                        </div>
                    </div>
                </article>
                <article class="card">
                    <img class="cardImg" src="https://htmlcolorcodes.com/assets/images/colors/light-gray-color-solid-background-1920x1080.png">
                    <div class="cardGridCon">
                        <h4 class="teamName">팀명</h4>
                        <div class="cardGrid">
                            <p>TM</p>
                            <div>김예은</div>
                            <p>팀목표</p>
                            <progress value="60" max="100"></progress>
                        </div>
                    </div>
                </article>
                <article class="card">
                    <img class="cardImg" src="https://htmlcolorcodes.com/assets/images/colors/light-gray-color-solid-background-1920x1080.png">
                    <div class="cardGridCon">
                        <h4 class="teamName">팀명</h4>
                        <div class="cardGrid">
                            <p>TM</p>
                            <div>김예은</div>
                            <p>팀목표</p>
                            <progress value="60" max="100"></progress>
                        </div>
                    </div>
                </article>
                <article class="card">
                    <img class="cardImg" src="https://htmlcolorcodes.com/assets/images/colors/light-gray-color-solid-background-1920x1080.png">
                    <div class="cardGridCon">
                        <h4 class="teamName">팀명</h4>
                        <div class="cardGrid">
                            <p>TM</p>
                            <div>김예은</div>
                            <p>팀목표</p>
                            <progress value="60" max="100"></progress>
                        </div>
                    </div>
                </article>
                <article class="card">
                    <img class="cardImg" src="https://htmlcolorcodes.com/assets/images/colors/light-gray-color-solid-background-1920x1080.png">
                    <div class="cardGridCon">
                        <h4 class="teamName">팀명</h4>
                        <div class="cardGrid">
                            <p>TM</p>
                            <div>김예은</div>
                            <p>팀목표</p>
                            <progress value="60" max="100"></progress>
                        </div>
                    </div>
                </article>
                <article class="card">
                    <img class="cardImg" src="https://htmlcolorcodes.com/assets/images/colors/light-gray-color-solid-background-1920x1080.png">
                    <div class="cardGridCon">
                        <h4 class="teamName">팀명</h4>
                        <div class="cardGrid">
                            <p>TM</p>
                            <div>김예은</div>
                            <p>팀목표</p>
                            <progress value="60" max="100"></progress>
                        </div>
                    </div>
                </article>
                <article class="card">
                    <img class="cardImg" src="https://htmlcolorcodes.com/assets/images/colors/light-gray-color-solid-background-1920x1080.png">
                    <div class="cardGridCon">
                        <h4 class="teamName">팀명</h4>
                        <div class="cardGrid">
                            <p>TM</p>
                            <div>김예은</div>
                            <p>팀목표</p>
                            <progress value="60" max="100"></progress>
                        </div>
                    </div>
                </article>
                <article class="card">
                    <img class="cardImg" src="https://htmlcolorcodes.com/assets/images/colors/light-gray-color-solid-background-1920x1080.png">
                    <div class="cardGridCon">
                        <h4 class="teamName">팀명</h4>
                        <div class="cardGrid">
                            <p>TM</p>
                            <div>김예은</div>
                            <p>팀목표</p>
                            <progress value="60" max="100"></progress>
                        </div>
                    </div>
                </article>
            </div>
        </div>
        <a id="rigthArrow"><i class="fas fa-chevron-right"></i></a>
        <div id="dotContainer">
            <a><i class="fas fa-circle"></i></a>
            <a><i class="fas fa-circle"></i></a>
            <a><i class="fas fa-circle"></i></a>
        </div>
    </section>
</body>
</html>