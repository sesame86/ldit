package com.mycompany.ldit.approval.model.vo;

import java.sql.Date;

public class Approval {
	
	// Approval
		private int appNo;

		private Date appWriteDate;

		private String firstApprover;

		private String interimApprover;

		private String finalApprover;

		private Date appCheckSysdate; // 결재결과일시

		private String appReason; // 반려사유

		private String appOriginalFileName;

		private String appRenameFileName;

		private int appWriterNo; // member.getUser_no

		private String appCheckProgress; // APP_CHECK_PROGRESS IN ('결재대기', '결재중', '결재완료')

		private String appKinds; // 결재 종류

		private String appPresent;

		private int userNo;

		private String deptName;

		private String userName;

		private int rowNum;

		private String rank;

		// App_Receive_Ref

		private int receiveRefNo; // 왜????

		private int receiveRefAppNo; // 수신참조 테이블 approval 시퀀스

		private String referList; // 수신참조내역

		// App_Loa
		private int loaNo; // LOA 시퀀스

		private int loaAppNo; // APP 시퀀스

		private String loaTitle; // 제목

		private String loaContent; // 상세내용

		private String loaStatus;

		private String loaPresent; // 결재현황

		// App_Leave
		private int leaveNo;

		private int leaveAppNo;

		private String leaveClassify; // 휴가구분

		private Date leaveStart;

		private Date leaveFinish;

		private String leaveDetail;

		private String leaveStatus; // 문서상태

		private String leavePreasent; // 결재상태

		private String appEmergncyCall; // 비상연락망

		// App_ER
		private int erNo;

		private int erAppNo;

		private Date erDeadline;

		private String erClassify; // 계정과목

		private String allAmount;

		private String erTitle;

		private String erDetail; // 적요

		private String erAmount; // 금액

		private String erReference; // 비고

		private String erStatus; // 문서상태

		private String erPresent; // 결재상태

		private String monetaryUnit; // 화폐단위

		public int getAppNo() {
			return appNo;
		}

		public void setAppNo(int appNo) {
			this.appNo = appNo;
		}

		public Date getAppWriteDate() {
			return appWriteDate;
		}

		public void setAppWriteDate(Date appWriteDate) {
			this.appWriteDate = appWriteDate;
		}

		public String getFirstApprover() {
			return firstApprover;
		}

		public void setFirstApprover(String firstApprover) {
			this.firstApprover = firstApprover;
		}

		public String getInterimApprover() {
			return interimApprover;
		}

		public void setInterimApprover(String interimApprover) {
			this.interimApprover = interimApprover;
		}

		public String getFinalApprover() {
			return finalApprover;
		}

		public void setFinalApprover(String finalApprover) {
			this.finalApprover = finalApprover;
		}

		public Date getAppCheckSysdate() {
			return appCheckSysdate;
		}

		public void setAppCheckSysdate(Date appCheckSysdate) {
			this.appCheckSysdate = appCheckSysdate;
		}

		public String getAppReason() {
			return appReason;
		}

		public void setAppReason(String appReason) {
			this.appReason = appReason;
		}

		public String getAppOriginalFileName() {
			return appOriginalFileName;
		}

		public void setAppOriginalFileName(String appOriginalFileName) {
			this.appOriginalFileName = appOriginalFileName;
		}

		public String getAppRenameFileName() {
			return appRenameFileName;
		}

		public void setAppRenameFileName(String appRenameFileName) {
			this.appRenameFileName = appRenameFileName;
		}

		public int getAppWriterNo() {
			return appWriterNo;
		}

		public void setAppWriterNo(int appWriterNo) {
			this.appWriterNo = appWriterNo;
		}

		public String getAppCheckProgress() {
			return appCheckProgress;
		}

		public void setAppCheckProgress(String appCheckProgress) {
			this.appCheckProgress = appCheckProgress;
		}

		public String getAppKinds() {
			return appKinds;
		}

		public void setAppKinds(String appKinds) {
			this.appKinds = appKinds;
		}

		public String getAppPresent() {
			return appPresent;
		}

		public void setAppPresent(String appPresent) {
			this.appPresent = appPresent;
		}

		public int getUserNo() {
			return userNo;
		}

		public void setUserNo(int userNo) {
			this.userNo = userNo;
		}

		public String getDeptName() {
			return deptName;
		}

		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public int getRowNum() {
			return rowNum;
		}

		public void setRowNum(int rowNum) {
			this.rowNum = rowNum;
		}

		public String getRank() {
			return rank;
		}

		public void setRank(String rank) {
			this.rank = rank;
		}

		public int getReceiveRefNo() {
			return receiveRefNo;
		}

		public void setReceiveRefNo(int receiveRefNo) {
			this.receiveRefNo = receiveRefNo;
		}

		public int getReceiveRefAppNo() {
			return receiveRefAppNo;
		}

		public void setReceiveRefAppNo(int receiveRefAppNo) {
			this.receiveRefAppNo = receiveRefAppNo;
		}

		public String getReferList() {
			return referList;
		}

		public void setReferList(String referList) {
			this.referList = referList;
		}

		public int getLoaNo() {
			return loaNo;
		}

		public void setLoaNo(int loaNo) {
			this.loaNo = loaNo;
		}

		public int getLoaAppNo() {
			return loaAppNo;
		}

		public void setLoaAppNo(int loaAppNo) {
			this.loaAppNo = loaAppNo;
		}

		public String getLoaTitle() {
			return loaTitle;
		}

		public void setLoaTitle(String loaTitle) {
			this.loaTitle = loaTitle;
		}

		public String getLoaContent() {
			return loaContent;
		}

		public void setLoaContent(String loaContent) {
			this.loaContent = loaContent;
		}

		public String getLoaStatus() {
			return loaStatus;
		}

		public void setLoaStatus(String loaStatus) {
			this.loaStatus = loaStatus;
		}

		public String getLoaPresent() {
			return loaPresent;
		}

		public void setLoaPresent(String loaPresent) {
			this.loaPresent = loaPresent;
		}

		public int getLeaveNo() {
			return leaveNo;
		}

		public void setLeaveNo(int leaveNo) {
			this.leaveNo = leaveNo;
		}

		public int getLeaveAppNo() {
			return leaveAppNo;
		}

		public void setLeaveAppNo(int leaveAppNo) {
			this.leaveAppNo = leaveAppNo;
		}

		public String getLeaveClassify() {
			return leaveClassify;
		}

		public void setLeaveClassify(String leaveClassify) {
			this.leaveClassify = leaveClassify;
		}

		public Date getLeaveStart() {
			return leaveStart;
		}

		public void setLeaveStart(Date leaveStart) {
			this.leaveStart = leaveStart;
		}

		public Date getLeaveFinish() {
			return leaveFinish;
		}

		public void setLeaveFinish(Date leaveFinish) {
			this.leaveFinish = leaveFinish;
		}

		public String getLeaveDetail() {
			return leaveDetail;
		}

		public void setLeaveDetail(String leaveDetail) {
			this.leaveDetail = leaveDetail;
		}

		public String getLeaveStatus() {
			return leaveStatus;
		}

		public void setLeaveStatus(String leaveStatus) {
			this.leaveStatus = leaveStatus;
		}

		public String getLeavePreasent() {
			return leavePreasent;
		}

		public void setLeavePreasent(String leavePreasent) {
			this.leavePreasent = leavePreasent;
		}

		public String getAppEmergncyCall() {
			return appEmergncyCall;
		}

		public void setAppEmergncyCall(String appEmergncyCall) {
			this.appEmergncyCall = appEmergncyCall;
		}

		public int getErNo() {
			return erNo;
		}

		public void setErNo(int erNo) {
			this.erNo = erNo;
		}

		public int getErAppNo() {
			return erAppNo;
		}

		public void setErAppNo(int erAppNo) {
			this.erAppNo = erAppNo;
		}

		public Date getErDeadline() {
			return erDeadline;
		}

		public void setErDeadline(Date erDeadline) {
			this.erDeadline = erDeadline;
		}

		public String getErClassify() {
			return erClassify;
		}

		public void setErClassify(String erClassify) {
			this.erClassify = erClassify;
		}

		public String getAllAmount() {
			return allAmount;
		}

		public void setAllAmount(String allAmount) {
			this.allAmount = allAmount;
		}

		public String getErTitle() {
			return erTitle;
		}

		public void setErTitle(String erTitle) {
			this.erTitle = erTitle;
		}

		public String getErDetail() {
			return erDetail;
		}

		public void setErDetail(String erDetail) {
			this.erDetail = erDetail;
		}

		public String getErAmount() {
			return erAmount;
		}

		public void setErAmount(String erAmount) {
			this.erAmount = erAmount;
		}

		public String getErReference() {
			return erReference;
		}

		public void setErReference(String erReference) {
			this.erReference = erReference;
		}

		public String getErStatus() {
			return erStatus;
		}

		public void setErStatus(String erStatus) {
			this.erStatus = erStatus;
		}

		public String getErPresent() {
			return erPresent;
		}

		public void setErPresent(String erPresent) {
			this.erPresent = erPresent;
		}

		public String getMonetaryUnit() {
			return monetaryUnit;
		}

		public void setMonetaryUnit(String monetaryUnit) {
			this.monetaryUnit = monetaryUnit;
		}

		@Override
		public String toString() {
			return "Approval [appNo=" + appNo + ", appWriteDate=" + appWriteDate + ", firstApprover=" + firstApprover
					+ ", interimApprover=" + interimApprover + ", finalApprover=" + finalApprover + ", appCheckSysdate="
					+ appCheckSysdate + ", appReason=" + appReason + ", appOriginalFileName=" + appOriginalFileName
					+ ", appRenameFileName=" + appRenameFileName + ", appWriterNo=" + appWriterNo
					+ ", appCheckProgress=" + appCheckProgress + ", appKinds=" + appKinds + ", appPresent=" + appPresent
					+ ", userNo=" + userNo + ", deptName=" + deptName + ", userName=" + userName + ", rowNum=" + rowNum
					+ ", rank=" + rank + ", receiveRefNo=" + receiveRefNo + ", receiveRefAppNo=" + receiveRefAppNo
					+ ", referList=" + referList + ", loaNo=" + loaNo + ", loaAppNo=" + loaAppNo + ", loaTitle="
					+ loaTitle + ", loaContent=" + loaContent + ", loaStatus=" + loaStatus + ", loaPresent="
					+ loaPresent + ", leaveNo=" + leaveNo + ", leaveAppNo=" + leaveAppNo + ", leaveClassify="
					+ leaveClassify + ", leaveStart=" + leaveStart + ", leaveFinish=" + leaveFinish + ", leaveDetail="
					+ leaveDetail + ", leaveStatus=" + leaveStatus + ", leavePreasent=" + leavePreasent
					+ ", appEmergncyCall=" + appEmergncyCall + ", erNo=" + erNo + ", erAppNo=" + erAppNo
					+ ", erDeadline=" + erDeadline + ", erClassify=" + erClassify + ", allAmount=" + allAmount
					+ ", erTitle=" + erTitle + ", erDetail=" + erDetail + ", erAmount=" + erAmount + ", erReference="
					+ erReference + ", erStatus=" + erStatus + ", erPresent=" + erPresent + ", monetaryUnit="
					+ monetaryUnit + "]";
		}

		public Approval() {
			super();
		}
		
		

	}

