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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/csneeds.css" /><!-- csneeds css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>LDIT: 고객 요구사항</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp" %>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp" %>
	<section>
		<div id="csContainer">
			<h1>고객 요구사항</h1>
			<div class="flexContainer">
				<div id="urgent" class="droptarget" ondrop="drop(event)" ondragover="allowDrop(event)">
					<h4>긴급</h4>
					<c:forEach var="vo" items="${urgentList}">
					<div id="urgentList" ondragstart="dragStart(event)" ondrag="dragging(event)" draggable="true">
						<div class="reqColorSmall"></div>
						<div class="listInfo">
							<h4>${vo.cn_title}</h4>
						</div>
					</div>
					</c:forEach>
				</div>
				<div id="high" class="droptarget" ondrop="drop(event)" ondragover="allowDrop(event)">
					<h4>중요</h4>
					<c:forEach var="vo" items="${highList}">
					<div id="highList" id="urgentList" ondragstart="dragStart(event)" ondrag="dragging(event)" draggable="true">
						<div class="reqColorSmall"></div>
						<div class="listInfo">
							<h4>${vo.cn_title}</h4>
						</div>
					</div>
					</c:forEach>
				</div>
				<div id="normal">
					<h4>보통</h4>
					<c:forEach var="vo" items="${normalList}">
					<div id="normalList">
						<div class="reqColorSmall"></div>
						<div class="listInfo">
							<h4>${vo.cn_title}</h4>
						</div>
					</div>
					</c:forEach>
				</div>
				<div id="low">
					<h4>낮음</h4>
					<c:forEach var="vo" items="${lowList}">
					<div id="lowList">
						<div class="reqColorSmall"></div>
						<div class="listInfo">
							<h4>${vo.cn_title}</h4>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		function dragStart(event) {
		  event.dataTransfer.setData("Text", event.target.id);
		}
		
		function dragging(event) {
		  document.getElementById("demo").innerHTML = "The p element is being dragged";
		}
		
		function allowDrop(event) {
		  event.preventDefault();
		}
		
		function drop(event) {
		  event.preventDefault();
		  var data = event.dataTransfer.getData("Text");
		  event.target.appendChild(document.getElementById(data));
		  document.getElementById("demo").innerHTML = "The p element was dropped";
		}
	</script>
</body>
</html>