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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/team_add.css" /><!-- team_add css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


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
                	<c:if test="${getProject.proStatus.toString() eq 'N'}">
                    <div id="smallColor" style="background-color: #3498DB"></div>
                    </c:if>
                    <c:if test="${getProject.proStatus.toString() eq 'C'}">
                    <div id="smallColor" style="background-color: #27AE60"></div>
                    </c:if>
                    <c:if test="${getProject.proStatus.toString() eq 'F'}">
                    <div id="smallColor" style="background-color: yellow"></div>
                    </c:if>
                    <div id="pjTitle">${getProject.proTitle}</div>
                    <div id="pmName">${getProject.proManager}</div>
                    <div id="startDate">${getProject.proStart}</div>
                    <div id="endDate">${getProject.proEnd}</div>
                    <c:if test="${getProject.proStatus.toString() eq 'N'}">
                    <div id="bigColor" style="background-color: #3498DB">새로운 요청</div>
                    </c:if>
                    <c:if test="${getProject.proStatus.toString() eq 'C'}">
                    <div id="bigColor" style="background-color: #27AE60">진행중</div>
                    </c:if>
                    <c:if test="${getProject.proStatus.toString() eq 'F'}">
                    <div id="bigColor" style="background-color: yellow">완료</div>
                    </c:if>
                </div>
                <form id="tmAddFrm" action="teamadd" method="post">
                	<input type="hidden" name="proNo" value="${getProject.proNo }">
                    <label>팀명</label>
                    <input id="teamTitle" name="teamTitle"><br>
                    <label>책임자</label>
                    <input id="tmInput"><br>
                    <p></p>
                    <div>
                    	<ul id="scPmList">
                    		<li id="scTitle"><p>사원번호</p><p>이름</p><p>부서</p><p>직급</p></li>
                    	</ul>
                    </div><p></p>
                    <label>팀원 추가</label>
                    <input id="addTeamMem">
                    <a href="#" id="teamAddBtn" onclick="addTeamMember()"><i class="far fa-plus-square"></i></a>
                    <p></p>
                    <div>
                    	<ul id="scTmemList">
                    		<li id="tmemTitle"><p>사원번호</p><p>이름</p><p>부서</p><p>직급</p></li>
                    	</ul>
                    </div><p></p>
                    <br>
                    <div class="addResultCon">

                    </div>
                    <p></p><p></p>
  
                    <button type="submit" id="submitBtn">저장</button>
                </form>
            </article>
        </div>
    </section>
    <script type="text/javascript">
    	//Team manager 추가
    	$("#tmInput").keyup(function(event){
    		if($("#tmInput").val().length == 0){
    			$("#scPmList").css("display","none");
    			$("#scTitle").nextAll().remove();
    		}else{
    			$.ajax({
        			url:"searchpm.do",
        			data:{"searchPM": $("#tmInput").val()},
        			contentType: 'application/json; charset=utf-8',
        			type: "GET",
        			dataType: "json",
        			success: function(result){
        				if(result.length > 0){
        					$("#scTitle").nextAll().remove();
        					for(var i=0; i<result.length; i++){
        						$("#scPmList").css("display","block");
        						$("#scPmList").append("<li onclick='pickPM("+i+")'><p id='scId_"+i+"'>"+result[i].stfNo+"</p><p id='scName_"+i+"'>"+result[i].stfName+"</p><p>"+result[i].deptNo+"</p><p>"+result[i].stfLvl+"</p></li>");
        					}
        				}
        			},
        			error:function(e) {
    		        	alert(e.responseText);
    		        }
        		})
    		}
    	})
    	function pickPM(i) {
    		var staffName = $("#scName_"+i).html();
    		var staffNo = $("#scId_"+i).html();
    		$("#tmInput").val(staffName);
    		$("#tmInput").next().append("<input name='teamManager' value='"+staffNo+"' type='hidden'>");
    		$("#scTitle").nextAll().remove();
    		$("#scPmList").css("display","none");
    	}
    	//팀 멤버 검색
    	$("#addTeamMem").keyup(function(event){
    		if($("#addTeamMem").val().length == 0){
    			$("#scTmemList").css("display","none");
    			$("#tmemTitle").nextAll().remove();
    		}else{
    			$.ajax({
        			url:"searchtmem.do",
        			data:{"searchTmem": $("#addTeamMem").val()},
        			contentType: 'application/json; charset=utf-8',
        			type: "GET",
        			dataType: "json",
        			success: function(result){
        				if(result.length > 0){
        					$("#tmemTitle").nextAll().remove();
        					for(var i=0; i<result.length; i++){
        						$("#scTmemList").css("display","block");
        						$("#scTmemList").append("<li onclick='pickTeamMember("+i+")'><p id='tmemId_"+i+"'>"+result[i].stfNo+"</p><p id='tmemName_"+i+"'>"+result[i].stfName+"</p><p>"+result[i].deptNo+"</p><p>"+result[i].stfLvl+"</p></li>");
        					}
        				}
        			},
        			error:function(e) {
    		        	alert(e.responseText);
    		        }
        		})
    		}
    	})
    	function pickTeamMember(i) {
    		$("#pickNo").remove();
    		var tmemName = $("#tmemName_"+i).html();
    		var tmemId = $("#tmemId_"+i).html();
    		$("#addTeamMem").val(tmemName);
    		$("#addTeamMem").next().append("<input id='pickNo' value='"+tmemId+"' type='hidden'>");
    		//$(".addResultCon").next().append("<a href='#'><i class='fas fa-user-minus'></i></a><img class='tmInfoImg' src='/ldit/resources/image/myInfoAlt.JPG'><p>김예은</p>");
    		$("#tmemTitle").nextAll().remove();
    		$("#scTmemList").css("display","none");
    	}
    	//팀 멤버 화면에 추가
    	function addTeamMember(){
    		$.ajax({
    			url:"searchbyno.do",
    			data:{"searchByNo": $("#pickNo").val()},
    			contentType: 'application/json; charset=utf-8',
    			type: "GET",
    			dataType: "json",
    			success: function(result){
    				if(duplicationCheck(result.stfNo) == false){
    					alert("이미 추가한 팀원입니다.");
    				}else{
    					$(".addResultCon").append("<input class=checkDupid type='hidden' name='staffList["+$(".checkDupid").length+"].stfNo' value='"+result.stfNo+"'><a href='#' onclick='deleteTeamMember("+result.stfNo+")' id='icon_"+result.stfNo+"'><i class='fas fa-user-minus'></i></a><img class='tmInfoImg' src='<%=request.getContextPath()%>/resources/image/"+result.stfImg+".png' id='img_"+result.stfNo+"'><p id='name_"+result.stfNo+"'>"+result.stfName+"</p>");
    				}
    			},
    			error:function(e) {
		        	alert("멤버 추가를 실패했습니다. 정확히 선택 후 다시 시도해 주세요.");
		        }
    		})
    	}
    	function duplicationCheck(no) {
    		var tmemLen = $(".checkDupid").length;
    		var tmemArr = new Array(tmemLen);
			for(var i=0; i<tmemLen; i++){
				tmemArr[i] = $(".checkDupid").eq(i).val();
			}
			console.log(tmemArr);
			console.log(no);
			var result = null;
			if(tmemArr.indexOf(no.toString()) === -1){
				result = true;
			}else{
				result = false;
			}
			return result;
		}
    	function deleteTeamMember(no) {
			$("#icon_"+no).remove();
			$("#img_"+no).remove();
			$("#name_"+no).remove();
		}
    </script>
</body>
</html>