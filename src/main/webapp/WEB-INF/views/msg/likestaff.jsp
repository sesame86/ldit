<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/likestaff.css" /><!-- main css -->
<meta charset="UTF-8">
<!-- 이모티콘 -->
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<title>직원 쪽지 즐겨찾기</title>
</head>
<body>
<section>
	<article>
		<!-- [[${allStaffList}]]  -->
		<div id="div_staff_container">
			<c:forEach var="i" items="${allStaffList}">
				<div id="div_staff_each_container">
					<div id="staff_img_container"><img src="${pageContext.request.contextPath}/resources/image/myInfoAlt.JPG"></div>
					<div id="staff_like_container">
						<c:choose>
							<c:when test="${!empty i.staffLike and i.staffLike.wantedStfNo eq i.stfNo}"><a href="javascript:cbDelete(${i.stfNo})" id="${i.stfNo}"><i class="fas fa-minus fa-2x"></i></a></c:when>
							<c:when test="${empty i.staffLike}"><a href="javascript:cbLike(${i.stfNo})" id="${i.stfNo}"><i class="fas fa-plus fa-2x"></i></a></c:when>
						</c:choose>				
					</div>
					<div id="staff_info_container">
						<p>${i.stfName}(${i.stfNo})</p>
						<p>직급: ${i.stfLvl}</p>
						<p>부서: ${i.department.deptName}</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</article>
</section>
<script>

$(document).ready(function(){
//	if($("a").attr('id') == "${WANTED_STF_NO}"){
//		
//	}
});
function cbLike(e){
	let selectedStfNo = e;
	var keyWordForChoose = "추가";
	$.ajax({
		type : "post",
		url : "deleteandlikestaff",
		data : {
			hostStfNo : "${loginUser.stfNo}",
			wantedStfNo : selectedStfNo,
			keyWordForChoose : keyWordForChoose
		},
		success : function(receive) {
			console.log("receive값은:"  + receive);
			if(receive == 2){
				location.reload();
			} else {
				alert("오류가 발생했습니다. 관리자에게 문의하세요");
			}
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:"
					+ error);
		}
	});
}	

function cbDelete(e) {
	let selectedDeleteStfNo = e;
	var keyWordForChoose = "삭제";
	$.ajax({
		type : "post",
		url : "deleteandlikestaff",
		data : {
			hostStfNo : "${loginUser.stfNo}",
			wantedStfNo : selectedDeleteStfNo,
			keyWordForChoose : keyWordForChoose
		},
		success : function(receive) {
			console.log("receive값은:"  + receive);
			if(receive == 1){
				location.reload();
			} else {
				alert("오류가 발생했습니다. 관리자에게 문의하세요");
			}
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:"
					+ error);
		}
	});
}
</script>
</body>
</html>