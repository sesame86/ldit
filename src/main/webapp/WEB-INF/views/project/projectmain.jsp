<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/projectmain.css" /><!-- csneeds css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>LDIT: 프로젝트 조회</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp" %>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp" %>
	<section>
		<div id="csContainer">
			<h1>프로젝트 조회</h1>
            <div>
				<c:forEach var="vo" items="${rightConfirm}">
	            	<c:if test="${vo.rightNo == 0}">
	            		<button class="newbtn" id="newbtn" onclick="location.href='popen'">프로젝트 등록</button>
	            	</c:if>
				</c:forEach>
            </div>
			<div class="flexContainer">
				<div id="new">
					<h4>예정</h4>
					<input type="hidden" id="stfNo" name="stfNo" value="${loginUser.stfNo}">
					<c:forEach var="vo" items="${newList}">
					<div id="newList">
							<div class="reqColorSmallNew"></div>
							<div class="listInfo">
								<i class="fas fa-user-plus" onclick="location.href='teammain'"></i>
								<br>
								<a href="pupdate?getproNo=${vo.proNo}">제목 : ${vo.proTitle}</a>
								<br>
								<p class="date">시작일 : ${vo.proStart}</p>
								<br>
								<p class="date">마감일 : ${vo.proEnd}</p>
								<input type="hidden" class="proNo" name="proNo" value="${vo.proNo}">
								<br>
								<i class="fas fa-bars" onclick="location.href='csneeds?proNo=${vo.proNo}'"></i>
							</div>
					</div>
					</c:forEach>
				</div>
				<div id="continue">
					<h4>진행중</h4>
					<c:forEach var="vo" items="${continueList}">
					<div id="continueList">
							<div class="reqColorSmallContinue"></div>
							<div class="listInfo">
								<i class="fas fa-user-plus" onclick="location.href='teammain'"></i>
								<br>
								<a href="pupdate?getproNo=${vo.proNo}">제목 : ${vo.proTitle}</a>
								<br>
								<p class="date">시작일 : ${vo.proStart}</p>
								<br>
								<p class="date">마감일 : ${vo.proEnd}</p>
								<input type="hidden" class="proNo" name="proNo" value="${vo.proNo}">
								<br>
								<i class="fas fa-bars" onclick="location.href='csneeds'"></i>
							</div>
					</div>
					</c:forEach>
				</div>
				<div id="finish">
					<h4>완료</h4>
					<c:forEach var="vo" items="${finishList}">
					<div id="finishList">
							<div class="reqColorSmallFinish"></div>
							<div class="listInfo">
								<i class="fas fa-user-plus" onclick="location.href='teammain'"></i>
								<br>
								<a href="pupdate?getproNo=${vo.proNo}">제목 : ${vo.proTitle}</a>
								<br>
								<p class="date">시작일 : ${vo.proStart}</p>
								<br>
								<p class="date">마감일 : ${vo.proEnd}</p>
								<input type="hidden" class="proNo" name="proNo" value="${vo.proNo}">
								<br>
								<i class="fas fa-bars" onclick="location.href='csneeds'"></i>
							</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
	</script>
</body>
</html>