<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

    <!-- 중간 승인자 모달창  -->
    <div id="testForm">
       <div class="appModal Amodal">
          <div class="appModal_content">
          <div class="appModalInputName">이름을 입력해 주세요.</div>
             <div>
                <input type="text" id="memSearchInput2" name="userName" class="APPLE_searchArea"> <lable class="anserMember">님이 맞으신가요?</lable>
             </div>
             <br><br>
                <button class="modalSearchMember" type="button" id="appModalClose2" style="">확인</button>
          </div>
       </div>
    </div>
    
    <!-- 최초 승인자 모달창  -->
    <div id="testForm1">
       <div class="appModal Amodal1">
          <div class="appModal_content">
          <div class="appModalInputName">이름을 입력해 주세요.</div>
             <div>
                <input type="text" id="memSearchInput1" name="userName" class="APPLE_searchArea"> <lable class="anserMember">님이 맞으신가요?</lable>
             </div>
             <br><br>
                <button class="modalSearchMember" type="button" id="appModalCloseFirst">확인</button>
          </div>
       </div>
    </div>
    
    <!-- 최종 승인자 모달창  -->
    <div id="testForm3">
       <div class="appModal Amodal3">
          <div class="appModal_content">
          <div class="appModalInputName">이름을 입력해 주세요.</div>
             <div>
                <input type="text" id="memSearchInput3" name="userName" class="APPLE_searchArea"> <lable class="anserMember">님이 맞으신가요?</lable>
             </div>
             <br><br>
                <button class="modalSearchMember" type="button" id="appModalCloseThird">확인</button>
          </div>
       </div>
    </div>

<script>
	/* 중간 승인자 */
    $(function(){ 
    	$("#secondBtn").click(function(){ 
    		$(".Amodal").fadeIn(); 
    		$("#memSearchInput2").autocomplete({
    			source:function(request, response){
    				$.ajax({
    					url : "${path}/approval/search/json",
    					type : "get",
    					dataType : 'json',
    					data : {
    						userName:$("#memSearchInput2").val()
    					},
    					success : function(data){
    						var result = data;
    						response(result);
    					},
    					error : function(e){
    						alert("ajax에러발생..!")
						}
					});
				},
				focus : function(event, ui) {    //포커스 가면
					return false;//한글 에러 잡기용도로 사용됨
				},
				minLength: 1,// 최소 글자수
				autoFocus: true, //첫번째 항목 자동 포커스 기본값 false
				delay: 300,    //검색창에 글자 써지고 나서 autocomplete 창 뜰 때 까지 딜레이 시간(ms)
    		 });
    	}); 
    	
    	$("#appModalClose2").click(function(){ 
			var secondName = $("#memSearchInput2").val();
			
			secondName = secondName.split('_');
			
			$('#interimName').attr('value',secondName[0]);
			
    		$(".Amodal").fadeOut(); 
    	}); 
    });
    
	/* 최초승인자 */
	$(function(){ 
		$("#firstBtn").click(function(){ 
			$(".Amodal1").fadeIn(); 
			$("#memSearchInput1").autocomplete({
				source:function(request, response){
					$.ajax({
						url : "${path}/approval/search/json",
						type : "get",
						dataType : 'json',
						data : {
							userName:$("#memSearchInput1").val()
						},
						success : function(data){
							var result = data;
							response(result);
						},
						error : function(e){
							alert("ajax에러발생..!")
						}
					});
				},
				focus : function(event, ui) {    //포커스 가면
					return false;//한글 에러 잡기용도로 사용됨
				},
				minLength: 1,// 최소 글자수
				autoFocus: true, //첫번째 항목 자동 포커스 기본값 false
				delay: 300,    //검색창에 글자 써지고 나서 autocomplete 창 뜰 때 까지 딜레이 시간(ms)
			 });
		}); 
		
		$("#appModalCloseFirst").click(function(){ 
			var firstName = $("#memSearchInput1").val();
			
			firstName = firstName.split('_');
			
			$('#firstApprover').attr('value',firstName[0]);
			$(".Amodal1").fadeOut(); 
		}); 
	});
	/* 최종승인자 */
	$(function(){ 
		$("#thirdBtn").click(function(){ 
			$(".Amodal3").fadeIn(); 
			$("#memSearchInput3").autocomplete({
				source:function(request, response){
					$.ajax({
						url : "${path}/approval/search/json",
						type : "get",
						dataType : 'json',
						data : {
							userName:$("#memSearchInput3").val()
						},
						success : function(data){
							var result = data;
							response(result);
							
							console.log(data);
							/* 
							let arr1 = result[0].split('_');
							document.getElementById('finalApprover').value = arr1[0]; */
						},
						error : function(e){
							alert("ajax에러발생..!")
						}
					});
				},
				focus : function(event, ui) {    //포커스 가면
					return false;//한글 에러 잡기용도로 사용됨
				},
				minLength: 1,// 최소 글자수
				autoFocus: true, //첫번째 항목 자동 포커스 기본값 false
				delay: 300,    //검색창에 글자 써지고 나서 autocomplete 창 뜰 때 까지 딜레이 시간(ms)
			 });
		}); 
		
		$("#appModalCloseThird").click(function(){ 
			var ThirdName = $("#memSearchInput3").val();
			
			/* console.log(testName); */
			
			ThirdName = ThirdName.split('_');
			/* console.log(testName[0]); */
			
			$('#finalApprover').attr('value',ThirdName[0]);
			
			$(".Amodal3").fadeOut(); 
		}); 
	});
    
</script>