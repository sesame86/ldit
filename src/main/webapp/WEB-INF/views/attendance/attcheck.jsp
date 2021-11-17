<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>근무현황 페이지</title>
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
			<h1>근태현황</h1>
			<div class="div_checkin">
				<div>
					<span>Today's 근무시간</span>
					<span>00:00:00</span>
				</div>
				<div>
					<span>Today's 출근시각</span>
					<span>00:00:00</span>
				</div>
				<div>
					<span>Today's 퇴근시각</span>
					<span>00:00:00</span>
				</div>
				<button type="button" id="btn_checkin">출근</button>
			</div>
			<div class="div_restin"></div>
			<div class="div_apply"></div>		
		</article>
		<article id="article_b">
		
			<h1>차트</h1>
			
		</article>
		<article id="article_c">
		
			<h1>휴가신청 상세내역</h1>
		
		</article>
		<article id="article_d">
		
			<h1>재택근무 상세내역</h1>
		
		</article>
		<article id="article_e">
		
			<h1>근태조회 상세내역</h1>
		
		</article>
	</section>


<script>













</script>
</body>
</html>