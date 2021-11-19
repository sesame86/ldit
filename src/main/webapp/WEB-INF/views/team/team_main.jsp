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
            <c:forEach var="vo" items="${getTeam}">
                <article class="card">
                    <img class="cardImg" src="https://htmlcolorcodes.com/assets/images/colors/light-gray-color-solid-background-1920x1080.png">
                    <div class="cardGridCon">
                        <h4 class="teamName">${vo.team_title}</h4>
                        <div class="cardGrid">
                            <p>TM</p>
                            <div>${vo.staff.stf_name}</div>
                            <p onclick="teamGoalList(${vo.team_id})">팀목표</p>
                            <progress value="${vo.teamAim.aim_status}" max="100" id="mainPbar"></progress>
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
			        <h1 id="teamH1">팀 목표</h1>
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
			        <h1 id="teamH1">팀 목표 등록</h1>
		        </div>
		        <form method="post" action="goaladd">
		        	<div id="tgForm">
		        		<input type="hidden" id="team_id" name="team_id" value="0">
		        		<label>목표 제목</label>
			        	<input name="aim_title" required="required" id="aim_title">
			        	<label>내용</label>
			        	<textarea rows="8" name="aim_content" required="required" id="aim_content"></textarea>
			        	<label>기간</label>
			        	<select id="spendTime">
			        		<option value="0">사용자 지정</option>
			        		<option value="7">1주일</option>
			        		<option value="14">2주일</option>
			        		<option value="21">3주일</option>
			        		<option value="28">4주일</option>
			        	</select>
			        	<label>시작일</label>
			        	<input type="date" id="startDate" name="aim_start">
			        	<label>마감일</label>
			        	<input type="date" id="endDate" name="aim_end">
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
	    					var text = "<div class='goalListCon'>"
	    							+"<div class='reqColorSmall' id='color_"+i+"'></div>"
	    							+"<div class='goalInfo'>"
	    							+"<h4>"+result[i].aim_title+"</h4>"
	    							+"<p class='dateP'>"+result[i].aim_start+" ~ "+result[i].aim_end+"</p>"
	    							+"<progress value="+result[i].aim_status+" max='100' class='modalPbar'></progress><p class='percentP'>"+result[i].aim_status+"%</p>"
	    							+"</div>"
	    							+"</div>";
	    					$("#teamGoalModal #goalList").append(text);
	    					if(result[i].aim_status == 0){
	    						$("#color_"+i).css("background-color", "#3498DB");
	    					}else if(result[i].aim_status > 0 && result[i].aim_status < 100){
	    						$("#color_"+i).css("background-color", "#27AE60");
	    					}else if(result[i].aim_status == 100){
	    						$("#color_"+i).css("background-color", "#FFE08C");
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
    		$("#team_id").val($("#storeTeamId").val());
    		$.ajax({
    			url:"gstatuscheck.do",
    			data:{"teamId": $("#storeTeamId").val()},
    			contentType: 'application/json; charset=utf-8',
    			type: "GET",
    			dataType: "json",
    			success: function(result){
    				console.log("result"+result);
    				
					if(result >= 0 && result < 100){
						alert("이전 목표를 완료해주세요");
					}else if(result == 100 || result == "noGoal"){
						//팀 목표 등록 모달로 이동
						$("#teamGoalModal").css("display", "none");
						$("#tgRegisterModal").css("display", "block");
					}
    			},
    			error : function(e) {
    				console.log("result");
		        }
    		})
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
    </script>
</body>
</html>