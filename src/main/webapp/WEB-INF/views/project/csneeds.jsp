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
			<c:if test="${rightNo == 0}">
            	<a href="csadd?prono=${proNo}" id="csadd"><i class="fas fa-user-plus"></i></a>
            </c:if>
			<div class="flexContainer">
				<div id="urgent" class="droptarget" ondrop="drop(event)" ondragover="allowDrop(event)">
					<h4>긴급</h4>
					<c:forEach var="vo" items="${urgentList}">
					<div id="urgentList" ondragstart="dragStart(event)" ondrag="dragging(event)" draggable="true">
						<c:if test="${vo.cnDeactivate == 'Y'.toString()}">
							<div class="reqColorSmall" style="background-color: red"></div>
						</c:if>
							<c:if test="${vo.cnDeactivate == 'N'.toString()}">
						<div class="reqColorSmall"></div>
						</c:if>
						<div class="listInfo">
							<a href="#" onclick="csDetailView(${vo.cnId})">${vo.cnTitle}</a>
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
							<a href="#" onclick="csDetailView(${vo.cnId})">${vo.cnTitle}</a>
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
							<a href="#" onclick="csDetailView(${vo.cnId})">${vo.cnTitle}</a>
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
							<a href="#" onclick="csDetailView(${vo.cnId})">${vo.cnTitle}</a>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- 고객 요구사항 상세조회 modal -->
        <div id="csDetailModal">
		    <div class="modal-content">
		      <div class="container">
		        <div id="csBasic">
		        	<span onclick="closeModal()" id="cancleBtn"><i class="fas fa-times"></i></span>
			        <h1 class="csH1">고객 요구사항</h1>
			        <div id="csDetailContent">
			        </div>
		        </div>
		        <div id="goalList">
		        </div>
		      </div>
		    </div>
		</div>
	</section>
	<script type="text/javascript">
		/* function dragStart(event) {
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
		} */
		function csDetailView(cnId) {
    		$("#csDetailContent").children().remove();
    		$("#csDisableBtn").remove();
    		$.ajax({
    			url:"getCSDetail.do",
    			data:{"cnId": cnId},
    			contentType: 'application/json; charset=utf-8',
    			type: "GET",
    			dataType: "json",
    			success: function(result){
    				console.log(result.length);
    				if(result != null){
    					$("#csDetailModal").css("display", "block");
    					if(result.cnPriority == 1){
    						prior = "긴급";
    					}else if(result.cnPriority == 2){
    						prior = "높음";
    					}else if(result.cnPriority == 3){
    						prior = "보통";
    					}else if(result.cnPriority == 4){
    						prior = "낮음";
    					}
    					if ("${rightNo}" == 0){
    						$(".csH1").append("<button id='csDisableBtn' onclick='disableCS("+cnId+")'>비활성화</button>");
    					}
    					var html = "<h4>제목</h4><p>"+result.cnTitle+"</p><h4>내용</h4><p>"+result.cnContent+"</p><h4>우선순위</h4><p>"+prior+"</p>";
    					$("#csDetailContent").append(html);
    				}
    			},
    			error : function(e) {
		        }
    		})
		}
		function closeModal() {
    		$("#csDetailModal").css("display", "none");
		}
		function disableCS(cnId) {
			var con = confirm("비활성화를 되돌릴 수 없습니다. 계속 진행하시겠습니까?");
			if(con == true){
	    		$.ajax({
	    			url:"disablecs.do",
	    			data:{"cnId": cnId},
	    			contentType: 'application/json; charset=utf-8',
	    			type: "GET",
	    			dataType: "json",
	    			success: function(result){
	    				if(result > 0){
	    					alert("비활성화 완료");
	    				}
	    			},
	    			error : function(e) {
	    				alert("code:"+e.status+"\n"+"message:"+e.responseText+"\n"+"error:"+e);
			        }
	    		})
			}
		}
	</script>
</body>
</html>