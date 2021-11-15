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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/team_add.css" /><!-- team_add css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>LDIT: 팀 개설</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp" %>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp" %>
	<section>
        <div id="tmAddCon">
            <h1>팀 개설</h1>
            <article>
                <div id="pjInfoCon">
                    <div id="smallColor"></div>
                    <div id="pjTitle">${getProject.pro_title}</div>
                    <div id="pmName">${getProject.pro_manager}</div>
                    <div id="startDate">${getProject.pro_start}</div>
                    <div id="endDate">${getProject.pro_end}</div>
                    <c:if test="${getProject.pro_status} == 'N'">
                    <div id="bigColor" style="background-color: #3498DB">새로운 요청</div>
                    </c:if>
                    <c:if test="${getProject.pro_status} == 'C'">
                    <div id="bigColor" style="background-color: #27AE60">진행중</div>
                    </c:if>
                    <c:if test="${getProject.pro_status} == 'F'">
                    <div id="bigColor" style="background-color: yellow">완료</div>
                    </c:if>
                </div>
                <form id="tmAddFrm">
                    <label>팀명</label>
                    <input id="teamName" name="teamName"><br>
                    <label>책임자</label>
                    <input id="PM" name="PM"><br>
                    <label>팀원 추가</label>
                    <input>
                    <a href="#" id="teamAddBtn"><i class="far fa-plus-square"></i></a>
                    <br>
                    <div class="addResultCon">
                        <a href="#"><i class="fas fa-user-minus"></i></a>
                        <img class="tmInfoImg" src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                        <p>김예은</p>
                        <input type="hidden" name="id_clean">
                    </div>
                    <p></p><p></p>
                    <div class="addResultCon">
                        <a href="#"><i class="fas fa-user-minus"></i></a>
                        <img class="tmInfoImg" src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                        <p>김예은</p>
                    </div>
                    <p></p><p></p>
                    <div class="addResultCon">
                        <a href="#"><i class="fas fa-user-minus"></i></a>
                        <img class="tmInfoImg" src="<%=request.getContextPath() %>/resources/image/myInfoAlt.JPG">
                        <p>김예은</p>
                    </div><br>
                </form>
            </article>
        </div>
    </section>
</body>
</html>