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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/projectdetail.css" /><!-- projectadd css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>LDIT: 프로젝트 상세</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp" %>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp" %>
	<section>
        <div id="pjAdd">
            <h1>Project 상세</h1>
            <article>
            <%-- console.log(${detailList});
            <%-- console.log(${loginUser.stfNo}); --%>
                <c:forEach var="vo" items="${detailList}">
	                <div class="submitBtn" id="pJAddBtnDiv">
	                <c:if test="${loginUser.stfNo == vo.proManager}">
		                 <button type="button" class="submitAddBtn" id="pJProceedBtn" value="${vo.proNo}">진행</button>
		                 <button type="button" class="submitAddBtn" id="pJCompleteBtn" value="${vo.proNo}">완료</button>
		                 <%-- <button type="button" class="submitAddBtn" id="pJUpdateBtn" value="${vo.proNo}">수정</button> --%>
	                </c:if>
	                <button type="button" class="submitAddBtn" id="pJCancelBtn" onclick="location.href='projectmain'">목록</button>
	                </div>
	                <form id="pjAddFrm" action="pjadd" method="post">
	                    <div class="textBox" id="calendar">
	                    	<label>시작일</label>
	                    	<!-- <input type="date" id="proStart" name="proStart" required="required"> -->
	                    	<li class="inTextBox">${vo.proStart}</li>
	                    	<label>종료일</label>
	                    	<!-- <input type="date" id="proEnd" name="proEnd" required="required"> -->
	                    	<li class="inTextBox">${vo.proEnd}</li>
	                   	</div>
	                   	<br>
	                    <div class="textBox" id="pjTitle">
	                    	<label>프로젝트명</label>
	                    	<!-- <input type = "text" name = "proTitle" class = "stf_name_input" id = "proTitle" placeholder="제목을 입력해주세요" required="required"> -->
	                    	<li class="inTextBox">${vo.proTitle}</li>
	                    </div>
	                    <br>
	                    <div class="textBox" id="pjTm">
	                    	<label>프로젝트 TM</label>
							<!-- <input type = "text" name = "stf_name" class = "stf_name_input" id = "stf_name_input" placeholder="이름으로 검색해주세요"> -->
							<li class="inTextBox">${vo.stfName}</li>
	                    </div>
	                    <br>
	                    <div class="textBox" id="pjContent">
	                    	<label>프로젝트 내용</label>
	                    	<!-- <input type = "text" name = "proContent" class = "stf_no_input" id = "proContent" placeholder="내용을 입력해주세요" required="required"> -->
	                    	<li class="inTextBox">${vo.proContent}</li>
	                    </div>
	                    <br>
	                </form>
                </c:forEach>
                	<!-- <div class="submitBtn" id="pJCancelBtnDiv">
                	</div> -->
            </article>
        </div>
    </section>
    <script>
    	/* 프로젝트 진행기능 */
	    $("#pJProceedBtn").on("click",	function() {
			$.ajax({
				url : "proceed",
				data:{
					"getproNo" : $("#pJProceedBtn").val()
					},
				type : "GET",
				success : function(data) {
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
			alert("프로젝트를 진행합니다.")
			location.href='projectmain'
		});
    	
    	/* 프로젝트 완료기능 */
	    $("#pJCompleteBtn").on("click",	function() {
			$.ajax({
				url : "pcomplete",
				data:{
					"getproNo" : $("#pJCompleteBtn").val()
					},
				type : "GET",
				success : function(data) {
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
			alert("프로젝트를 완료하였습니다.")
			location.href='projectmain'
		});
    </script>
</body>
</html>