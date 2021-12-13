<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<aside class="right-aside">

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<!--여기 작성 2-->
	<button class="aside-accordion" onclick="location.href='workmain'"><i class="far fa-calendar-alt"></i><p class="mobile-hidden">&nbsp&nbsp 일정</p></button>
          <div class="panel">
              <a href="#"></a>
          </div>
  
          <button class="aside-accordion"><p class="float-L"><i class="far fa-file-alt"></i><p class="mobile-hidden">&nbsp&nbsp 프로젝트</p><i class="fas fa-angle-down float-R"></i></p> </button>
          <div class="panel">
              <p class="pd1" onclick="location.href='projectmain'">프로젝트 조회</p>
              <p class="pd1">이슈</p>
              
          </div>
  
          <button class="aside-accordion"><p class="float-L"><i class="fas fa-columns"></i><p class="mobile-hidden">&nbsp&nbsp 근무계획</p><i class="fas fa-angle-down float-R"></i></p> </button>
          <div class="panel">
              <p class="pd1" onclick="location.href='attcheck'">출퇴근 관리</p>
              <p class="pd1" onclick="location.href='whmanage'">근태계획 설정</p>
              <p class="pd1">근태현황 조회</p>
  
          </div>
  
          <button class="aside-accordion"><p class="float-L"><i class="fas fa-sitemap"></i><p class="mobile-hidden">&nbsp&nbsp 조직도</p><i class="fas fa-angle-down float-R"></i></p> </button>
          <c:if test="${loginUser.deptNo==3}">
          <div class="panel">
			<p class="pd1" onclick="location.href='organization'">조직도</p>
          	<p class="pd1" onclick="location.href='eregist'">직원 등록</p>
          	<p class="pd1" onclick="location.href='edelete'">직원 퇴사</p>                            
          </div>
  		</c:if>
  		<c:if test="${loginUser.deptNo!=3}">
  		<div class="panel">
			<p class="pd1" onclick="location.href='organization'">조직도</p>                            
          </div>
  		</c:if>
          <button class="aside-accordion"><p class="float-L"><i class="far fa-envelope"></i><p class="mobile-hidden">&nbsp&nbsp 쪽지</p><i class="fas fa-angle-down float-R"></i></p></button>
          <div class="panel"  >
              <p class="pd1">쪽지보내기</p>
              <p class="pd1">보낸 쪽지 확인</p>
              <p class="pd1">받은쪽지 확인</p>
              <p class="pd1">쪽지 폴더 등록</p>
          </div>
  
          <button class="aside-accordion"><i class="fas fa-pen-fancy"></i><p class="mobile-hidden">&nbsp&nbsp 전자결재</p></button>
          <div class="panel">
              <a href="#"></a>
          </div>
          
          <!-- 인사팀만 해당 버튼 보이도록 바꿔줘야함 - 김정기 -->
          <button class="aside-accordion" onclick="location.href='pmregist'"><i class="far fa-id-badge"></i><p class="mobile-hidden">&nbsp&nbsp 권한관리</p></button>
          <div class="panel">
              <a href="#"></a>
          </div>
          <script>
           /*
           var acc = document.getElementsByClassName("accordion");
              var i;
  
              for (i = 0; i < acc.length; i++) {
                  acc[i].addEventListener("click", function () {
                      this.classList.toggle("active");
                      var panel = this.nextElementSibling;
                      if (panel.style.display === "block") {
                          panel.style.display = "none";
                      } else {
                          panel.style.display = "block";
                      }
                  });
              }
           */   
           
           
           $(document).ready(function(){
        	   // 제일 첫번째 아코디언 메뉴 버튼을 클릭한다.
        	   //$(".accordion").eq(0).trigger("click");
        	   
        	   /* 
        	   // 버튼의 색상 변경 (선택을 안 한 것처럼)
        	   $(".accordion").removeClass("active");
        	   
        	   // 모든 서브 메뉴 접기
        	   $(".panel").hide();
        	   // $("ul > li:first-child a").next().show();
        	   */
        	   
        	   // 아코디언 메뉴 버튼을 클릭할 때 실행
        	   $(".aside-accordion").click(function(){
            	   $(".aside-accordion").removeClass("active"); 
        	       $(this).addClass("active");
        	       
        	       $(this).next().slideToggle(300);
        	       // $(this).next().slideDown(300);
        	       $(".aside-accordion").not(this).next().slideUp(300);
        	       
        	       return false;
        	   });

        	 });
          </script>
	
</aside>