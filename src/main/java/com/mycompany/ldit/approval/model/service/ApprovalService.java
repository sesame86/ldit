package com.mycompany.ldit.approval.model.service;

import java.util.List;

import com.mycompany.ldit.approval.model.vo.Approval;
import com.mycompany.ldit.common.PageInfo;
import com.mycompany.ldit.staff.model.vo.Staff;


public interface ApprovalService {
	
	int approvalCount_YET(Staff loginUser);
	int approvalCount_UNDER(Staff loginUser);
	int approvalCount_DONE(Staff loginUser);

	List<Approval> getRecentList(Staff loginUser);
	List<Approval> getRecentList1(Staff loginUser);
	List<Approval> getRecentList2(Staff loginUser);
	
	List<Approval> getApprovalList(PageInfo pageInfo, String searchText);

	int getListCount(String searchText);
	
	// LetterOfApproval 등록
		int saveLetterOfApproval(Approval approval);
		int saveLetterOfApproval2(Approval approval);
		int saveLetterOfApproval3(Approval approval);
		
		Approval findListByNo(int appNo);
		
		int rejectUpdate(Approval approval);
		
		// 결재상태 갱신
		int approved1(int appNo);
		int approved2(int appNo);
		int approved3(int appNo);
		
		// 휴가신청서 등록
		int insertApproval(Approval approval);
		int insertLeave(Approval approval);
		int insertReceive(Approval approval);
		
		int saveExpenseReport(Approval approval);
		int saveExpenseReport2(Approval approval);
		int saveExpenseReport3(Approval approval);
		
		Approval findExpenseReportListByNo(int appNo);
		
		// 휴가신청서 상세보기
	    Approval findListByLeaveNo(int appNo);
	    
	    // 쪽지 보내기전 자료 불러오기
	    Approval findByAppNoMsg(int appNo);

}
