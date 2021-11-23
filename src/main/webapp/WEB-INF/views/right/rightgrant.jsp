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
							<option value="1">임원</option>
							<option value="2">기획</option>
							<option value="3">인사</option>
							<option value="4">개발</option>
							<option value="5">영업</option>
						</select>
                    </div>
                    <div id="stf_name"><input type = "text" name = "stf_name" class = "stf_name_input" id = "stf_name_input" placeholder="이름을 입력해주세요"></div>
                    <div id="stf_no"><input type = "text" name = "stf_no" class = "stf_no_input" id = "stf_no_input" placeholder="사번을 입력해주세요"></div>
                    <div id="searchBtn"><input type="button"><i id="searchBtnImg" class="fas fa-search"></i></div>
                </div>
                <div id="staffInfoTitle">
                    <div id="deptNameTitle">부서명</div>
                    <div id="stf_nameTitle">이름</div>
                    <div id="stf_noTitle">사원번호</div>
                </div>
                
                <!-- 검색조건 일치하는 사람 반복문으로 리스트 뿌려주기 및 페이징처리 -->
                <form id="rightgrantFrm" action="rightgrant" method="post">
	                <div id="staffInfoList">
	                	<div id="deptNameList">부서명</div>
	                    <div id="stf_nameList">이름</div>
	                    <div id="stf_noList">사원번호</div>
	                    <button id="rightBtnList">PM등록</button>
	                </div>
	                <div id="staffInfoList">
	                	<div id="deptNameList">부서명</div>
	                    <div id="stf_nameList">이름</div>
	                    <div id="stf_noList">사원번호</div>
	                    <button id="rightBtnList">PM등록</button>
	                </div>
	                <div id="staffInfoList">
	                	<div id="deptNameList">부서명</div>
	                    <div id="stf_nameList">이름</div>
	                    <div id="stf_noList">사원번호</div>
	                    <button id="rightBtnList">PM등록</button>
	                </div>
	                <div id="staffInfoList">
	                	<div id="deptNameList">부서명</div>
	                    <div id="stf_nameList">이름</div>
	                    <div id="stf_noList">사원번호</div>
	                    <button id="rightBtnList">PM등록</button>
	                </div>
                </form>
            </article>
        </div>
    </section>
    <script>
	    $("#searchBtn").on("click",	function() {
			$.ajax({
				url : "pmregist.do",
				data:{
					"deptNo" : $("#dept_select").val()
					, "stfName" : $("#stf_name_input").val()
					, "stfNo" : $("#stf_no_input").val()
					},
				type : "GET",
				success : function(data) {
					console.log(data);
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
    </script>
</body>
</html>