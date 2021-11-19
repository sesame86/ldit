<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


테스트중
<button id="btn_checkin">눌러주세요</button>


<script>

$("#btn_checkin").on("click", function(){
	console.log("버튼눌림");
	$.ajax({
		url : "checkin"
		, type : "post"
		, dataType: "json"
		, succeess: function(data) {
			alert(data);
		}
		, error : function(request, status, errorData){ 
			 alert("error code : " + request.status + "\n" 
					 + "message : " + request.responseText + "\n" 
					 + "error : " + errorData);}
	});
	
	
});

</script>


</body>
</html>