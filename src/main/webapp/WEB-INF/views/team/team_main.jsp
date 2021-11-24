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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/team_main.css" /><!-- team_main css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>LDIT: 팀 메인</title>
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
            <c:forEach var="vo" items="${getTeam}">
                <article class="card">
                    <c:if test="${vo.teamAim.aimFinish == 'N'.charAt(0)}">
                            	<c:if test="${vo.teamAim.aimStatus == 0}">
                            	<img class="cardImg" src="<%=request.getContextPath()%>/resources/image/new.png">
	                            </c:if>
                            	<c:if test="${vo.teamAim.aimStatus > 0 && vo.teamAim.aimStatus < 100}">
                            	<img class="cardImg" src="<%=request.getContextPath()%>/resources/image/ongoing.png">
	                            </c:if>
	                            <c:if test="${vo.teamAim.aimStatus == 100}">
	                            <img class="cardImg" src="<%=request.getContextPath()%>/resources/image/finish.png">
	                            </c:if>
                            </c:if>
                            <c:if test="${vo.teamAim.aimFinish == 'Y'.charAt(0)}">
                            <img class="cardImg" src="<%=request.getContextPath()%>/resources/image/finish.png">
                            </c:if>
                    <div class="cardGridCon">
                        <h4 class="teamName">${vo.teamTitle}</h4>
                        <div class="cardGrid">
                            <p>TM</p>
                            <div>${vo.staff.stfName}</div>
                            <p onclick="teamGoalList(${vo.teamId})">팀목표</p>
                            <c:if test="${vo.teamAim.aimFinish == 'N'.charAt(0)}">
                            	<c:if test="${vo.teamAim.aimStatus == 0}">
	                            <progress value="${vo.teamAim.aimStatus}" max="100" id="mainPbarBlue"></progress>
	                            </c:if>
                            	<c:if test="${vo.teamAim.aimStatus > 0 && vo.teamAim.aimStatus < 100}">
	                            <progress value="${vo.teamAim.aimStatus}" max="100" id="mainPbarGreen"></progress>
	                            </c:if>
	                            <c:if test="${vo.teamAim.aimStatus == 100}">
	                            <progress value="${vo.teamAim.aimStatus}" max="100" id="mainPbarYellow"></progress>
	                            </c:if>
                            </c:if>
                            <c:if test="${vo.teamAim.aimFinish == 'Y'.charAt(0)}">
                            <progress value="${vo.teamAim.aimStatus}" max="100" id="mainPbarRed"></progress>
                            </c:if>
                        </div>
                    </div>
                </article>
            </c:forEach>
            </div>
        </div>
        <a id="rigthArrow"><i class="fas fa-chevron-right"></i></a>
        <div id="dotContainer">
            <a><i class="fas fa-circle"></i></a>
            <a><i class="fas fa-circle"></i></a>
            <a><i class="fas fa-circle"></i></a>
        </div>
        <!-- team goal list modal -->
        <div id="teamGoalModal">
		    <div class="modal-content">
		      <div class="container">
		        <div id="goalBasic">
		        	<span onclick="closeModal()" id="cancleBtn"><i class="fas fa-times"></i></span>
			        <h1 class="teamH1">팀 목표</h1>
			        <a class="addGoalBtn" onclick="moveToAddgoal()"><i class="far fa-plus-square"></i></a>
		        </div>
		        <div id="goalList">
		        </div>
		      </div>
		    </div>
		</div>
	    <!-- team goal register modal -->
        <div id="tgRegisterModal">
		    <div class="modal-content">
		      <div class="container">
		        <div id="goalBasic">
		        	<span onclick="closeModal()" id="cancleBtn"><i class="fas fa-times"></i></span>
			        <h1 class="teamH1" id="modalTitle">팀 목표 등록</h1>
		        </div>
		        <form method="post" action="goaladd" id="tgModalFrm">
		        	<div id="tgForm">
		        		<input type="hidden" id="teamId" name="teamId" value="0">
		        		<label>목표 제목</label>
			        	<input name="aimTitle" required="required" id="aimTitle">
			        	<label>내용</label>
			        	<textarea rows="8" name="aimContent" required="required" id="aimContent"></textarea>
			        	<label>기간</label>
			        	<select id="spendTime">
			        		<option value="0">사용자 지정</option>
			        		<option value="7">1주일</option>
			        		<option value="14">2주일</option>
			        		<option value="21">3주일</option>
			        		<option value="28">4주일</option>
			        	</select>
			        	<label>시작일</label>
			        	<input type="date" id="startDate" name="aimStart">
			        	<label>마감일</label>
			        	<input type="date" id="endDate" name="aimEnd">
		        	</div>
		        	<button type="submit" id="sbBtn">등록</button>
		        </form>
		      </div>
		    </div>
	    </div>
    </section>
    <script type="text/javascript">
    
    	function teamGoalList(teamId) {
    		$("#goalList").children().remove();
    		$.ajax({
    			url:"getteamgoal.do",
    			data:{"teamId": teamId},
    			contentType: 'application/json; charset=utf-8',
    			type: "GET",
    			dataType: "json",
    			success: function(result){
    				var teamText = "<input type='hidden' value='"+teamId+"' id='storeTeamId'>";
					if($("#storeTeamId").val() != null){
						$("#storeTeamId").remove();
					}
					$("#teamGoalModal").append(teamText);
    				if(result.length>0){
    					$("#teamGoalModal").css("display", "block");
    					for(var i=0; i<result.length; i++){
    						var text = "";
	    					text += "<div class='goalListCon'>";
	    					text += "<div class='reqColorSmall' id='color_"+i+"'></div>";
	    					text += "<div class='goalInfo'>";
	    					text += "<h4>"+result[i].aimTitle+"</h4>";
	    					if(result[i].aimStatus != 100 && result[i].aimFinish == 'N'){
	    						text += "<button onclick='getUpdateGoal("+result[i].teamId+")'>수정</button>";
	    						text += "<button onclick='disableGoal("+result[i].teamId+")'>비활성화</button>";
	    					}
	    					text += "<p class='dateP'>"+result[i].aimStart+" ~ "+result[i].aimEnd+"</p>";
	    					text += "<progress value="+result[i].aimStatus+" max='100' class='modalPbar'></progress><p class='percentP'>"+result[i].aimStatus+"%</p>";
	    					text += "</div>";
	    					text += "</div>";
	    					$("#teamGoalModal #goalList").append(text);
	    					if(result[i].aimFinish == 'N'){
	    						if(result[i].aimStatus == 0){
		    						$("#color_"+i).css("background-color", "#3498DB");
		    					}else if(result[i].aimStatus > 0 && result[i].aimStatus < 100){
		    						$("#color_"+i).css("background-color", "#27AE60");
		    					}else if(result[i].aimStatus == 100){
		    						$("#color_"+i).css("background-color", "#FFE08C");
		    					}
	    					}else if(result[i].aimFinish == 'Y'){
	    						$("#color_"+i).css("background-color", "#DE4F4F");
	    					}
    					}
    				}else{
    					$("#teamGoalModal").css("display", "block");
    					$("#teamGoalModal #goalList").append("<h4 style='text-align:center'>팀의 목표가 존재하지 않습니다</h4>");
    				}
    			},
    			error : function(e) {
		        }
    		})
		}
    	function closeModal() {
    		$("#teamGoalModal").css("display", "none");
    		$("#tgRegisterModal").css("display", "none");
		}
    	function moveToAddgoal() {
    		$("#teamId").val($("#storeTeamId").val());
    		$.ajax({
    			url:"gstatuscheck.do",
    			data:{"teamId": $("#storeTeamId").val()},
    			contentType: 'application/json; charset=utf-8',
    			type: "GET",
    			dataType: "json",
    			success: function(result){
    				if(result.aimFinish == 'N'){
    					if(result.aimStatus >= 0 && result.aimStatus < 100){
    						alert("이전 목표를 완료해주세요");
    					}else if(result.aimStatus == 100){
    						addGoal();
    					}
    				}else if(result.aimFinish == 'Y'){
    					addGoal();
    				}
    			},
    			error : function(e) {
    				alert("code:"+e.status+"\n"+"message:"+e.responseText+"\n"+"error:"+e);
		        }
    		})
		}
    	function addGoal() {
    		//팀 목표 등록 모달로 이동
			$("#teamGoalModal").css("display", "none");
			$("#tgRegisterModal").css("display", "block");
			$("#tgModalFrm").attr("action", "goaladd");
			$("#aimTitle").val("");
			$("#aimContent").val("");
			$("#startDate").val("");
			$("#endDate").val("");
			$("#modalTitle").text("팀 목표 등록");
			$("#sbBtn").text("등록");
		
			$("#teamGoalModal").css("display", "none");
			$("#tgRegisterModal").css("display", "block");
		}
    	$("#startDate").on("change", function(){
    		if($("#spendTime").val() == 0){
    			
    		}else{
    			var startDate = new Date($("#startDate").val());
    			var endDate = new Date();
    			endDate.setDate(parseInt(startDate.getDate()) + parseInt($("#spendTime").val()));
    			$("#endDate").val(formatDate(endDate));
    		}
    	})
    	$("#spendTime").on("change", function(){
    		if($("#startDate").val() != null){
    			var startDate = new Date($("#startDate").val());
    			var endDate = new Date();
    			endDate.setDate(parseInt(startDate.getDate()) + parseInt($("#spendTime").val()));
    			$("#endDate").val(formatDate(endDate));
    		}
    	})
    	function formatDate(date) {
    		var d = new Date(date),
    		month = '' + (d.getMonth() + 1),
    		day = '' + d.getDate(),
    		year = d.getFullYear();
    		if (month.length < 2)
    			month = '0' + month;
    		if (day.length < 2)
    			day = '0' + day;
    		return [year, month, day].join('-');
    	}
    	//업데이트 하기위해 팀 목표 상세 정보 가져오기
    	function getUpdateGoal(teamId) {
    		$("#teamId").val($("#storeTeamId").val());
    		$.ajax({
    			url:"getUpdateGoal.do",
    			data:{"teamId": $("#storeTeamId").val()},
    			contentType: 'application/json; charset=utf-8',
    			type: "GET",
    			dataType: "json",
    			success: function(result){
    				//팀 목표 수정 모달로 이동
					$("#teamGoalModal").css("display", "none");
					$("#tgRegisterModal").css("display", "block");
					$("#tgModalFrm").attr("action", "goalupdate");
					$("#aimTitle").val(result.aimTitle);
					$("#aimContent").val(result.aimContent);
					$("#startDate").val(formatSqlDate(result.aimStart));
					$("#endDate").val(formatSqlDate(result.aimEnd));
					$("#modalTitle").text("팀 목표 수정");
					$("#sbBtn").text("수정");
    			},
    			error : function(e) {
    				alert("code:"+e.status+"\n"+"message:"+e.responseText+"\n"+"error:"+e);
		        }
    		})
		}
    	function formatSqlDate(date) {
    		month = date.split("월")[0];
    		day = date.split("월 ")[1].split(",")[0];
    		year = date.split(", ")[1];
    		if (month.length < 2)
    			month = '0' + month;
    		if (day.length < 2)
    			day = '0' + day;
    		return [year, month, day].join('-');
    	}
    	function disableGoal(teamId) {
			var con = confirm("비활성화를 되돌릴 수 없습니다. 계속 진행하시겠습니까?");
			if(con == true){
	    		$.ajax({
	    			url:"disablegoal.do",
	    			data:{"teamId": teamId},
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