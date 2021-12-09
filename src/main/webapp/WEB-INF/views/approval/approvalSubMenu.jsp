<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="EPay-index_section">
    <h2 style="margin-left:19px;"><a style="color:black;" href="${path}/approval/approvalMain">전자결재</a></h2>
    <li class="EPay-form">양식작성
        <div>
            <ul>
                <li><a href="${path}/approval/letterOfApproval">-품의서</a></li>
                <li><a href="${path}/approval/expenseReport">-지출결의서</a></li>
                <li><a href="${path}/approval/leaveApplication">-휴가신청서</a></li>
            </ul>
        </div>
    </li>
    <li class="EPay-list">
        <a href="${path}/approval/approvalList" style="color:black">결재리스트</a>
    </li>
    <li class="EPay-box">보관함
        <div>
         <ul>
             <li><a href="${path}/approval/approvalList?notice_search=결재대기">결재대기</a></li>
             <li><a href="${path}/approval/approvalList?notice_search=결재중">결재중</a></li>
             <li><a href="${path}/approval/approvalList?notice_search=결재완료">결재완료</a></li>
             <li><a href="${path}/approval/approvalList?notice_search=결재반려">결재반려</a></li>
         </ul>
        </div>
    </li>
</div>

<script>
    $(document).ready(function () {
        $('.EPay-form').on('click', function() {
            $('.EPay-form > div').slideToggle();
        });
    });

    $(document).ready(function () {
        $('.EPay-box').on('click', function() {
            $('.EPay-box > div').slideToggle();
        });
    });
</script>