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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/workmain.css" /><!-- workmain css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- calendar -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.css">
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/ldit_header.jsp" %>
	<%@ include file="/WEB-INF/views/ldit_aside.jsp" %>
	
	<section>
		<!-- 일자 클릭시 메뉴오픈 -->
        <div id="contextMenu" class="dropdown clearfix">
            <ul class="dropdown-menu dropNewEvent" role="menu" aria-labelledby="dropdownMenu"
                style="display:block;position:static;margin-bottom:5px;">
                <li><a tabindex="-1" href="#">업무 등록</a></li>
                <li class="divider"></li>
                <li><a tabindex="-1" href="#" data-role="close">Close</a></li>
            </ul>
        </div>
		<div id="calendarCon">
			<div id='calendar'></div>
		</div>
		<!-- team goal register modal -->
        <div id="workAddModal">
		    <div class="modal-content">
		      <div class="container">
		        <div id="workCon">
		        	<span onclick="closeModal()" id="cancleBtn"><i class="fas fa-times"></i></span>
			        <h1 class="workH1" id="modalTitle">업무 등록</h1>
			        <form id="workAddFrm" action="workadd" method="post">
			        	<div id="workGrid">
			        		<label>업무 제목</label>
					        <input id="workTitle" name="workTitle" required="required">
					        <label>업무 내용</label>
					        <textarea rows="5" id="workContent" name="workContent" required="required"></textarea>
					        <label>업무 시작일</label>
					        <input type="date" id="workStart" name="workStart">
					        <label>업무 마감일</label>
					        <input type="date" id="workEnd" name="workEnd">
					        <label>업무 상태</label>
					        <select id="workFinish" name="workFinish">
					        	<option value="0">업무 진행중</option>
					        	<option value="1">업무 완료</option>
					        </select>
			        	</div>
			        	<button type="submit" id=submitBtn>등록</button>
			        </form>
		        </div>
		      </div>
		    </div>
	    </div>
	</section>
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			var calendarEl = document.getElementById('calendar');
			var activeInactiveWeekends = true;
			var calendar = new FullCalendar.Calendar(calendarEl, {
				initialView : 'dayGridMonth',
				locale: 'ko',
				headerToolbar: {
					start: "",
					center: "prev title next",
					end: 'dayGridMonth,dayGridWeek,dayGridDay'
				}
				,titleFormat: function(date) {
					return date.date.year+'년 '+(parseInt(date.date.month) + 1)+'월';
				}
				,dayHeaderContent: function (date) {
					let weekList = ["일", "월", "화", "수", "목", "금", "토"];
					return weekList[date.dow];
				}
				,selectable: true
				,droppable: true
				,editable: true
				,events: [{
					title: 'My Event',
					start: '2021-11-01',
					url: '#'
					}// other events here
				]
				,eventClick: function(info) {
				    alert('Event: ' + info.event.title);
				    alert('Coordinates: ' + info.jsEvent.pageX + ',' + info.jsEvent.pageY);
				  }
				,select: function (start, end, jsEvent, view) {
				    $(".fc-daygrid").unbind('click');
				    $(".fc-daygrid").on('click', function (e) {
				      $("#contextMenu")
				        .addClass("contextOpened")
				        .css({
				          display: "block",
				          left: e.pageX,
				          top: e.pageY
				        });
				      return false;
				    });

				    //console.log(start.startStr);
				    //console.log(start.endStr);
				    //start = moment(start).format('YYYY-MM-DD HH:mm');
				    //end = moment(end).format('YYYY-MM-DD HH:mm');
				    //console.log(start);
				    //console.log(end);
				    
				    //날짜 클릭시 카테고리 선택메뉴
				    $("#contextMenu").on("click", "a", function (e) {
				      e.preventDefault();

				      //닫기 버튼이 아닐때
				      if ($(this).data().role !== 'close') {
				        newEvent(start, end, $(this).html());
				      }

				      $("#contextMenu").removeClass("contextOpened");
				      $("#contextMenu").hide();
				    });

				    $('body').on('click', function () {
				    	$("#contextMenu").removeClass("contextOpened");
				    	$("#contextMenu").hide();
				    });

				  }
				});
			calendar.render();
		});
		function closeModal() {
    		$("#workAddModal").css("display", "none");
		}
	</script>
	<script src="<%=request.getContextPath() %>/resources/js/addWork.js"></script>
</body>
</html>