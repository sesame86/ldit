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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/projectadd.css" /><!-- projectadd css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>LDIT: 프로젝트 개설</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp" %>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp" %>
	<section>
        <div id="pjAdd">
            <h1>Project 개설</h1>
            <article>
                <form id="pjAddFrm" action="pjadd" method="post">
                    <input type="hidden" id="proManager" name="proManager" value="${loginUser.stfNo}">
                    <div class="textBox" id="calendar">
                    	<label>시작일</label>
                    	<input type="date" id="proStart" name="proStart" required="required">
                    	<label>종료일</label>
                    	<input type="date" id="proEnd" name="proEnd" required="required">
                   	</div>
                   	<br>
                    <div class="textBox" id="pjTitle">
                    	<label>프로젝트명</label>
                    	<input type = "text" name = "proTitle" class = "stf_name_input" id = "proTitle" placeholder="제목을 입력해주세요" required="required">
                    </div>
                    <br>
                    <div class="textBox" id="pjTm">
                    	<label>프로젝트 TM</label>
						<input type = "text" name = "stf_name" class = "stf_name_input" id = "stf_name_input" placeholder="이름으로 검색해주세요">
                    	<button type="button" class="submitAddBtn" id="tMSearchBtn">검색</button>
                    </div>
                    <br>
                    <div class="textBox" id="pjContent">
                    	<label>프로젝트 내용</label>
                    	<input type = "text" name = "proContent" class = "stf_no_input" id = "proContent" placeholder="내용을 입력해주세요" required="required">
                    </div>
                    <br>
                    <div class="submitBtn" id="pJAddBtnDiv">
	                    <button type="submit" class="submitAddBtn" id="pJAddBtn">개설</button>
	                    <button type="button" class="submitAddBtn" id="pJCancelBtn" onclick="location.href='projectmain'">취소</button>
                    </div>
                </form>
                	<!-- <div class="submitBtn" id="pJCancelBtnDiv">
                	</div> -->
            </article>
        </div>
        
        <!-- TM등록 모달창 -->
        <div id="tmModal">
		    <div class="modal-content">
		      <div class="container">
		        <div id="tmBasic">
		        	<span onclick="closeModal()" id="cancleBtn"><i class="fas fa-times"></i></span>
			        <h1 class="tmH1">TM검색리스트</h1>
			        <div id="tmContent">
			        </div>
		        </div>
		        <div id="goalList">
		        </div>
		      </div>
		    </div>
		</div>
    </section>
    <script>
	    $("#tMSearchBtn").on("click",	function() {
			$.ajax({
				url : "tmregist",
				data:{
					"stfName" : $("#stf_name_input").val()
					},
				type : "GET",
				success : function(data) {
					resultHtml(data);
   					$("#tmModal").css("display", "block");
				},
				error : function(request, status, errorData) {
					alert("error code : "
							+ request.status + "\n"
							+ "message : "
							+ request.responseText
							+ "\n" + "error : "
							+ errorData);
				}
			});
		});
	    
	    function resultHtml(data){
			var html="";
			$.each(data, function(i, value){
				var stfName = value.stfName;
				html += "<h4>부서명</h4><p>"+value.deptName+"</p><h4>이름</h4><p>"+value.stfName+"<h4>사원번호</h4><p>"+value.stfNo+"</p><button onclick='tmBtn("+stfName+")' id='tmRegister' class='rightBtnList'>TM등록</button><br>";
			});
			$("#tmContent").empty(); 
			$("#tmContent").append(html);
		}
	    
	    function closeModal() {
    		$("#tmModal").css("display", "none");
		}
	    
	    /* function tmBtn(stfName) {
			document.getElementById("stf_name_input").innerHTML = stfNo;
		} */
    </script>
</body>
</html>