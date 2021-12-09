<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
    
<link rel="stylesheet" href="${path}/css/approvalStyle.css">
<link rel="stylesheet" href="${path}/css/expenseReport.css">
<script src="${path}/js/jquery-3.5.1.js"></script>

<%@ include file="../approval/approvalSubMenu.jsp" %>
    
	<c:if test="${!empty approval.appReason}">
		<div style="position:absolute; margin-left:400px; margin-top:30px">
			<img src="${path}/images/rejected.png" style="width:200px; height:200px" />
		</div>
	</c:if>
    <div class="cash-form-section" style="height: 100%; margin: 0 300px 0 300px;">
        <div class="cash-disbursement" style="text-align: center; margin: 80px 0px 80px 200px; border: 2px solid black;">
            <table border="2" style="width: 100%; font-size: 20px; border-collapse: collapse;">
                <tr>
                    <td rowspan="3" colspan="4" style="width: 300px; height: 140px; font-size: 40px; font-weight: 600;">지 출 결 의 서</td>
                    <td rowspan="3" style="width: 20px; padding-top: 30px; font-size: 25px;">결 재</td>
                    <td style="height: 25px; width: 100px; font-size:17px">최초승인자</td>
                    <td style="height: 25px; width: 100px; font-size:17px">중간승인자</td>
                    <td style="height: 25px; width: 100px; font-size:17px">최종승인자</td>
                </tr>
                <tr>
                    <c:choose>
						<c:when test="${approval.appPresent eq 'A'}">
					    	<td name="firstA" id="firstA">${approval.firstApprover}</td>
					    	<td name="interimA" id="interimA">${approval.interimApprover}</td>
					    	<td name="finalA" id="finalA">${approval.finalApprover}</td>
					    </c:when>
						<c:when test="${approval.appPresent eq 'B'}">
					        <td name="firstA" id="firstA">${approval.firstApprover}<img src="${path}/images/approved.png" style="position:absolute; width:130px; height:130px; margin-left:-92px; margin-top:-50px" /></td>
					        <td name="interimA" id="interimA">${approval.interimApprover}</td>
					        <td name="finalA" id="finalA">${approval.finalApprover}</td>
					    </c:when>
						<c:when test="${approval.appPresent eq 'C'}">
					        <td name="firstA" id="firstA">${approval.firstApprover}<img src="${path}/images/approved.png" style="position:absolute; width:130px; height:130px; margin-left:-92px; margin-top:-50px" /></td>
					        <td name="interimA" id="interimA">${approval.interimApprover}<img src="${path}/images/approved.png" style="position:absolute; width:130px; height:130px; margin-left:-92px; margin-top:-50px" /></td>
					        <td name="finalA" id="finalA">${approval.finalApprover}</td>
					    </c:when>
						<c:when test="${approval.appPresent eq 'D'}">
					        <td name="firstA" id="firstA">${approval.firstApprover}<img src="${path}/images/approved.png" style="position:absolute; width:130px; height:130px; margin-left:-92px; margin-top:-50px" /></td>
					        <td name="interimA" id="interimA">${approval.interimApprover}<img src="${path}/images/approved.png" style="position:absolute; width:130px; height:130px; margin-left:-92px; margin-top:-50px" /></td>
					        <td name="finalA" id="finalA">${approval.finalApprover}<img src="${path}/images/approved.png" style="position:absolute; width:130px; height:130px; margin-left:-92px; margin-top:-50px" /></td>
					    </c:when>
						<c:otherwise>
					        <td name="firstA" id="firstA">${approval.firstApprover}</td>
					        <td name="interimA" id="interimA">${approval.interimApprover}</td>
					        <td name="finalA" id="finalA">${approval.finalApprover}</td>
						</c:otherwise>
					</c:choose>
                </tr>
                <tr style="height: 30px;">
                    <c:choose>
	                    <c:when test="${!empty approval.appReason}">
	                    	<td><input type="button" name="Approver1" id="Approver1" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
							<td><input type="button" name="Approver2" id="Approver2" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
							<td><input type="button" name="Approver3" id="Approver3" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
	                    </c:when>
	                    <c:otherwise>
	                    	<c:choose>
								<c:when test="${loginMember.user_name eq approval.firstApprover && approval.appPresent eq 'A'}">
							    	<td><input type="button" name="Approver1" id="Approver1" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" /></td>
							    	<td><input type="button" name="Approver2" id="Approver2" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
							    	<td><input type="button" name="Approver3" id="Approver3" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
								</c:when>
								<c:when test="${loginMember.user_name eq approval.interimApprover && approval.appPresent eq 'B'}">
							    	<td><input type="button" name="Approver1" id="Approver1" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
							    	<td><input type="button" name="Approver2" id="Approver2" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" /></td>
							    	<td><input type="button" name="Approver3" id="Approver3" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
								</c:when>
								<c:when test="${loginMember.user_name eq approval.finalApprover && approval.appPresent eq 'C'}">
				                    <td><input type="button" name="Approver1" id="Approver1" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
				                    <td><input type="button" name="Approver2" id="Approver2" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
				                    <td><input type="button" name="Approver3" id="Approver3" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" /></td>
								</c:when>
								<c:otherwise>
									<td><input type="button" name="Approver1" id="Approver1" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
									<td><input type="button" name="Approver2" id="Approver2" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
									<td><input type="button" name="Approver3" id="Approver3" style="font-size:15px; width:70px; height:25px; border: none; text-align: center; border-radius:20px;" value="결재서명" disabled /></td>
								</c:otherwise>
							</c:choose>
	                    </c:otherwise>
                    </c:choose>
                </tr>
                <tr>
                    <td colspan="2" style="height: 70px;">
                        <button class="send-open" type="button" disabled>수신참조자 +</button>
                    </td>
                    <td colspan="6" style="height: 70px;">
                    	<textArea readonly name="referList" id="referList" style="border:none;margin-bottom:-12px; font-size:19px; width:600px; height:60px; text-align: center; resize: none;">${approval.referList}</textArea>
                    </td>	
                </tr>
                <tr>
                    <td style="height: 70px; width: 80px;">성 명</td>
                    <td><input type="text" readonly value="${approval.userName}"></td>
                    <td style="width: 80px;">부 서</td>
                    <td><input type="text" readonly value="${approval.deptName}"></td>
                    <td style="width: 80px;">직 급</td>
                    <td colspan="3"><input type="text" readonly value="${approval.rank}"></td>
                </tr>
                <tr>                    
                    <td colspan="1">마감일</td>
                    <td colspan="1"><input type="date" name="erDeadline" id="erDeadline" style="background:none;margin-left:35px;font-size:30px;" readonly value="${approval.erDeadline}" ></td>
                    <td colspan="1" style="height: 70px; width: 80px;">지출금액</td>
                    <td colspan="3" ><input type="text" name="allAmount" id="allAmount" readonly value="${approval.allAmount}"/></td>
                    <td colspan="2" style="border:0px"><input type="text" name="monetaryUnit" id="monetaryUnit" readonly value="${approval.monetaryUnit}"/></td>
                </tr>
                <tr>
                    <td style="height: 70px; width: 80px;">제 목</td>
                    <td colspan="7"><input type="text" readonly value="${approval.erTitle}"></td>
                </tr>
                <tr>
                    <td rowspan="10" style="width: 80px;">내 역</td>
                    <td colspan="2">적 요</td>
                    <td colspan="2">금 액</td>
                    <td colspan="3">비 고</td>
                </tr>
                
                <!-- 적요 -->
                <c:set var="erDetailArr" value="${ approval.erDetail }"></c:set>
				<c:set var="erDeArr" value="${fn:split(erDetailArr,',')}"/> 
				
				<!-- 금액  -->
				<c:set var="erAmountArr" value="${ approval.erAmount }"></c:set>
				<c:set var="eAArr" value="${fn:split(erAmountArr,',')}"/>
				
				<!-- 비고  -->
				<c:set var="erReferenceArr" value="${ approval.erReference }"></c:set>
				<c:set var="eRFArr" value="${fn:split(erReferenceArr,',')}"/>

                <c:forEach begin="0" end="${fn:length(eRFArr)-1}" varStatus="status">
	                <tr>
				        <td colspan="2"><input type="text" style="font-size:20px; height:55px" value="${erDeArr[status.index]}" readonly ></td>
					    <td colspan="2"><input type="text" style="font-size:20px; height:55px" value="${eAArr[status.index]}" readonly ></td>
		                <td colspan="3"><input type="text" style="font-size:20px; height:55px" value="${eRFArr[status.index]}" readonly ></td>
	                </tr>
            	</c:forEach>
                <tr>
                    <td colspan="8" style="text-align: center; height: 100px; border-bottom: none;">위 금액을 청구하오니 결재바랍니다.</td>
                </tr>
                <tr style="border: white;">
                    <td colspan="8" style="text-align: center; height: 100px;">
                        <input type="text" style="text-align:center; font-size: 30px;" readonly><fmt:formatDate value="${approval.appWriteDate}" pattern="yyyy 년 MM 월 dd 일"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="8" style="text-align: right; height: 100px; padding-right: 50px;">
                        영수인 : <input type="text" style=" width:200px; border: none; text-align: center;" maxlength="4" readonly value="${approval.userName}">
                        (인)
                    </td>
                </tr>
            </table>
        </div>
        <div id="button">
        	<input type="hidden" name="appNo" value = "${approval.appNo}"/>
	        	
	        <%-- <c:if test="${loginMember.user_name eq approval.firstApprover || approval.interimApprover || approval.finalApprover}">
       			 --%><c:choose>
       				<c:when test="${!empty approval.appReason}">
       					<button type="button" class="openRejectionWhy">반려사유</button>
        				<input type="text" style="border: none; width: 40px;" disabled>
	        		</c:when>
	        		<c:otherwise>
	        			<c:choose>
		        			<c:when test="${(loginMember.user_name eq approval.firstApprover && approval.appPresent eq 'A') || 
		        						(loginMember.user_name eq approval.interimApprover && approval.appPresent eq 'B') ||
		        						(loginMember.user_name eq approval.finalApprover && approval.appPresent eq 'C')}">
			        			<button type="submit" id="approveddone">결재</button>
		       					<input type="text" style="border: none; width: 40px;"disabled >
		       					<button type="button" style="color:red" id="openRejection">반려</button>
		        				<input type="text" style="border: none; width: 40px;" disabled>
	        				</c:when>
        					<c:otherwise>
        						<button type="submit" id="approveddone" disabled>결재</button>
	       						<input type="text" style="border: none; width: 40px;"disabled >
	       						<button type="button" id="openRejection" disabled>반려</button>
	        					<input type="text" style="border: none; width: 40px;" disabled>
        					</c:otherwise>
        				</c:choose>
	        		</c:otherwise>
        		</c:choose>
			<%-- </c:if> --%>
			<button><a href="${path}/approval/approvalMain" style="color:black">취소</a></button>
        </div>
    </div>
    
    <!-- 모달 테이블(반려 확인) -->
    
	<div class="modal modal1 hidden">
        <div class="bg"></div>
        <div class="modalBox" style="width:600px; height:400px; border-radius:20px">
            <div style="font-size:26px; margin:30px">
            	정말 반려처리 하시겠습니까?
            </div>
            <div style="margin: 43% 0px 0% 53%;">
                <span style="padding-right: 20px; margin-left:46px; float: left;" >
                    <button type="submit" class="closeBtn-in rejModalOk1" id="rejectOrNo">확인</button>
                </span>
                <button class="closeBtn-out rejModalNo1">취소</button>
            </div>
        </div>
    </div>
    
    <!-- 모달 테이블(반려 사유 작성) -->
    
	<div class="modal modal2 hidden">
        <div class="bg"></div>
        <div class="modalBox" style="width:600px; height:400px; border-radius:20px">
            <div style="font-size:26px; margin:30px">
            	반려 사유를 입력해주세요.
            </div>
            <textarea name="rejectReasonText" rows="5" cols="45" style="font-size:23px; margin-left:23px; resize: none;"></textarea>
            <div style="margin: 8.8% 0px 0% 53%;">
                <span style="padding-right: 20px; margin-left:46px;float: left;" >
                    <button type="submit" class="closeBtn-in rejModalOk2" id="rejectReason">확인</button>
                </span>
                <button class="closeBtn-out rejModalNo2">취소</button>
            </div>
        </div>
    </div>
    
    <!-- 반려사유 보여주는 모달 -->
    
    <div class="modal modal3 hidden">
        <div class="bg"></div>
        <div class="modalBox" style="width:600px; height:400px; border-radius:20px">
            <div style="font-size:26px; margin:30px">
            	반려사유 :
            </div>
            <textarea name="rejectReasonText" rows="6" cols="45" style="font-size:23px; margin-left:23px; resize: none;" readonly>${approval.appReason}</textarea>
            <div style="margin: 5% 0px 0% 69%;">
                <span style="padding-right: 20px; margin-left:46px; float: left;" >
                    <button type="button" class="closeBtn-in3">확인</button>
                </span>
            </div>
        </div>
    </div>
    
    <script>
    /* 반려사유 확인 모달 */
	const open3 = () => {
    	document.querySelector(".modal3").classList.remove("hidden");
    }

    const close3 = () => {
        document.querySelector(".modal3").classList.add("hidden");
    }
	
    document.querySelector(".openRejectionWhy").addEventListener("click", open3);
    document.querySelector(".closeBtn-in3").addEventListener("click", close3);
	
    </script>
    
    <!-- 모달 스크립트 -->
    <script>
    	const open = () => {
	    	document.querySelector(".modal1").classList.remove("hidden");
	    }
	
	    const close = () => {
	        document.querySelector(".modal1").classList.add("hidden");
	    }
	
	    document.querySelector("#openRejection").addEventListener("click", open);
	    document.querySelector(".rejModalNo1").addEventListener("click", close);
    		
	    /* 모달 반려사유 */
	    
    	const open2 = () => {
	    	document.querySelector(".modal2").classList.remove("hidden");
	    }
	
	    const close2 = () => {
	        document.querySelector(".modal2").classList.add("hidden");
	    }
		
	    document.querySelector(".rejModalOk1").addEventListener("click", close);
	    document.querySelector(".rejModalOk1").addEventListener("click", open2);
	    document.querySelector(".rejModalNo2").addEventListener("click", close2);

	    
    	document.querySelector(".rejModalOk2").addEventListener("click",close2);
    	
    	$(document).ready(function() {
	    	$('#rejectReason').click(function() {
	    		var rejectReasonText = $("textarea[name='rejectReasonText']").val();
	    		var appNo = $("input[name=appNo]").val();
	    		
	    		console.log(rejectReasonText);
	    		$.ajax({
	                   type: "post",
	                   url: "${path}/approval/letterOfApprovalUpdate?appNo="+appNo,
	                   data: {
	                	   rejectReasonText:rejectReasonText
	   				   },
	                   success: function(data){
	                	   var url = "${path}/approval/approvalMain";
               	           
	                	   if(data != 0) {
	                		   /* alert("결재반려 처리가 정상적으로 완료되었습니다."); */
	                		   Swal.fire({
	                			   icon: 'success',
	                			   title: '결재반려 처리가 \n정상적으로 완료되었습니다.'
	                			})
      		    	   	       $(location).attr('href',url);
	                	   } else {
	                		   /* alert("결재반려 처리에 \n실패하였습니다."); */
	                		   Swal.fire({
	                  			   icon: 'error',
	                  			   title: '결재반려 처리에 \n실패하였습니다.'
	                  			})
      		    	   	       $(location).attr('href',url);
	                	   }
	            	   },
	                   error: function(){ alert("잠시 후 다시 시도해주세요."); }
	       		});
	    	});
    	});
    </script>
    
    <!-- 결재승인버튼 스크립트 -->
    <script>
    	$("#Approver1").one("click",function(){
    		
    		$.ajax({
                type: "post",
                url: "${path}/approval/loaApproved1?appNo="+${approval.appNo},
                success: function(){
           		   /* alert("결재서명이 완료되었습니다."); */
	           		/* Swal.fire({
	     			   icon: 'success',
	     			   title: '결재서명이 \n완료되었습니다.'
	     			}) */
   				   $("#firstA").append('<img src="${path}/images/approved.png" id="checkIfApproved" style="position:absolute; width:130px; height:130px; margin-left:-92px; margin-top:-50px" />');
         	   },
                error: function(){ alert("잠시 후 다시 시도해주세요."); }
    		});
    	});
    	
		$("#Approver2").one("click",function(){
    		
    		$.ajax({
                type: "post",
                url: "${path}/approval/loaApproved2?appNo="+${approval.appNo},
                success: function(){
                	/* alert("결재서명이 완료되었습니다."); */
	           		Swal.fire({
	     			   icon: 'success',
	     			   title: '결재서명이 \n완료되었습니다.'
	     			})
   				   $("#interimA").append('<img src="${path}/images/approved.png" id="checkIfApproved" style="position:absolute; width:130px; height:130px; margin-left:-92px; margin-top:-50px" />');
         	   },
                error: function(){ alert("잠시 후 다시 시도해주세요."); }
    		});
    	});
		
		$("#Approver3").one("click",function(){
    		
    		$.ajax({
                type: "post",
                url: "${path}/approval/loaApproved3?appNo="+${approval.appNo},
                success: function(){
                	/* alert("결재서명이 완료되었습니다."); */
	           		Swal.fire({
	     			   icon: 'success',
	     			   title: '결재서명이 \n완료되었습니다.'
	     			})
   				   $("#finalA").append('<img src="${path}/images/approved.png" id="checkIfApproved" style="position:absolute; width:130px; height:130px; margin-left:-92px; margin-top:-50px" />');
         	   },
                error: function(){ alert("잠시 후 다시 시도해주세요."); }
    		});
    	});
   	</script>
   	
   	<!-- 하단 결재버튼 -->
   	<script>
   		$("#approveddone").click(function() {
   			if($('#checkIfApproved').length > 0) {
   				var url = "${path}/approval/approvalMain";
	   			alert("결재가 완료되었습니다.");
	   	        $(location).attr('href', url);  			
   			} else {
   				var url = "${path}/approval/letterOfApprovalView?appNo="+${approval.appNo};
   				alert("결재서명 후 결재를 진행해주세요.");
   			}
   		});
   		
   		/* function checkIfApproved() {
		    if(document.getElementById('checkIfApproved')){
		        alert("결재가 완료되었습니다.");
		        
				return true;
			} else {
		        alert("결재서명 후 결재를 진행해주세요.");
		        
		        return false;
			}
		} */
   	</script>