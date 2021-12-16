package com.mycompany.ldit.approval.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.mycompany.ldit.approval.model.vo.Approval;
import com.mycompany.ldit.staff.model.vo.Staff;

@Mapper
public interface ApprovalDao {
	
	int approvalCount_YET(Staff loginUser);
	int approvalCount_UNDER(Staff loginUser);
	int approvalCount_DONE(Staff loginUser);

	List<Approval> selectRecentList(Staff loginUser);	
	List<Approval> selectRecentList1(Staff loginUser);
	List<Approval> selectRecentList2(Staff loginUser);

	List<Approval> selectApprovalList(RowBounds rowBounds, String searchText);
	
	int listCount(String searchText);
	
	// 휴가신청서 등록
	int insertLetterOfApproval(Approval approval);
	int insertLetterOfApproval2(Approval approval);
	int insertLetterOfApproval3(Approval approval);

	Approval selectApprovalListDetail(int appNo);

	int rejectUpdate(Approval approval);

	int approved1(int appNo);
	int approved2(int appNo);
	int approved3(int appNo);
	
	// 휴가신청서 등록
	int insertApproval(Approval approval);
	int insertAppLeave(Approval approval);
	int insertReceiveRef(Approval approval);
	
	// 지출결의서 등록
	int insertExpenseReport(Approval approval);
	int insertExpenseReport2(Approval approval);
	int insertExpenseReport3(Approval approval);
	
	Approval selectExpenseReportListDetail(int appNo);
	
	Approval viewAppLeaveList(int appNo); //APP_LEAVE DAO
	
	// 쪽지관련
	Approval findByAppNoMsg(int appNo);


}
