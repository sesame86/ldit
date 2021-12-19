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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/rightgrant.css" /><!-- rightgrant css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>LDIT: PM권한 부여</title>
</head>
<body>
	<%@ include file="../ldit_header.jsp" %>
	<%@ include file="../ldit_aside.jsp" %>
	<section>
        <div id="pmGrant">
            <h1>권한관리</h1>
            <article>
                <div id="staffInfoSearchMenuBar">
                    <!-- <div id="smallColor"></div> -->
                    <div id="deptNameSelect">
                    	<select name="deptName" id="dept_select" class="dept_select">
							<option value="">부서를 선택해주세요</option>
							<option value="임원">임원</option>
							<option value="기획">기획</option>
							<option value="인사">인사</option>
							<option value="개발">개발</option>
							<option value="영업">영업</option>
						</select>
                    </div>
                    <div id="stf_name"><input type = "text" name = "stf_name" class = "stf_name_input" id = "stf_name_input" placeholder="이름을 입력해주세요"></div>
                    <div id="stf_no"><input type = "number" name = "stf_no" class = "stf_no_input" id = "stf_no_input" placeholder="사번을 입력해주세요"></div>
                    <button id="searchBtn"><i id="searchBtnImg" class="fas fa-search"></i></button>
                    <!-- <div id="searchBtn"><input type="button"><i id="searchBtnImg" class="fas fa-search"></i></div> -->
                </div>
                <div id="staffInfoTitle">
                    <div id="deptNameTitle">부서명</div>
                    <div id="stf_nameTitle">이름</div>
                    <div id="stf_noTitle">사원번호</div>
                </div>
                
                <!-- 검색조건 일치하는 사람 반복문으로 리스트 뿌려주기 및 페이징처리 -->
                <!-- <form id="rightgrantFrm" action="rightgrant" method="post"> -->
	                <div id="staffInfoList">
	                </div>
                <!-- </form> -->
            </article>
        </div>
        
        <!-- PM등록 버큰 클릭 시 사원번호 확인용 -->
        <input type="text" id="stf_noListVal" style="display: none;">
    </section>
    <script>
    	/* 조건별 검색기능 */
	    $("#searchBtn").on("click",	function() {
			$.ajax({
				url : "pmregist.do",
				data:{
					"deptName" : $("#dept_select").val()
					, "stfName" : $("#stf_name_input").val()
					, "stfNo" : $("#stf_no_input").val()
					},
				type : "GET",
				success : function(data) {
					console.log(data);
					resultHtml(data);
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
	    
	    /* 조건별 검색된 목록 리스트 출력 // 조건별 검색기능 ajax의 success로 전달 */
	    function resultHtml(data){
			var html="";
			$.each(data, function(i, value){
					html += '<div id="deptNameList">'+value.deptName+'</div>';
					html += '<div id="stf_nameList">'+value.stfName+'</div>';
					html += '<div id="stf_noList">'+value.stfNo+'</div>';
					html += '<button id="pmRegister" class="rightBtnList">PM등록</button>';
			});
			$("#staffInfoList").empty(); 
			$("#staffInfoList").append(html);
		}
	    
	    /* PM등록 기능 */
	    $(document).on("click", ".rightBtnList", function() {
	    	/* alert("클릭하였습니다.") */
	    	var stf_noVal = $(this).prev().text();
	    	console.log(stf_noVal);
	    	$("#stf_noListVal").val(stf_noVal);
	    	
			$.ajax({
				url : "insertPm.do",
				data:{
					"stfNo" : $("#stf_noListVal").val()
					},
				type : "POST",
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
			alert("PM 등록이 완료되었습니다.")
			location.reload();
		});
    </script>
</body>
</html>