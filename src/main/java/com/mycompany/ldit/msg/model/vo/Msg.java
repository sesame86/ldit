package com.mycompany.ldit.msg.model.vo;

import org.springframework.stereotype.Component;

import com.mycompany.ldit.receivemsg.model.vo.ReceiveMsg;
import com.mycompany.ldit.sendmsg.model.vo.SendMsg;
import com.mycompany.ldit.staff.model.vo.Staff;

@Component
public class Msg {
	private static final long serialVersionUID = 1111L;
	private int mNo;
	private String mTitle;
	private String mContent;
	
	private int sMNo;
	private String sMTime;
	private String rStfId;
	
	private int rMNo;
	private int rMCheck;
	private String sStfId;
	private int stfNo;
	private String rMTime;
	
	private String stfId;
	private String stfName;
	
	private SendMsg sendMsg;
	private ReceiveMsg receiveMsg;
	private Staff staff;
	
	public Msg() {
		super();
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public int getsMNo() {
		return sMNo;
	}

	public void setsMNo(int sMNo) {
		this.sMNo = sMNo;
	}

	public String getsMTime() {
		return sMTime;
	}

	public void setsMTime(String sMTime) {
		this.sMTime = sMTime;
	}

	public String getrStfId() {
		return rStfId;
	}

	public void setrStfId(String rStfId) {
		this.rStfId = rStfId;
	}

	public int getrMNo() {
		return rMNo;
	}

	public void setrMNo(int rMNo) {
		this.rMNo = rMNo;
	}

	public int getrMCheck() {
		return rMCheck;
	}

	public void setrMCheck(int rMCheck) {
		this.rMCheck = rMCheck;
	}

	public String getsStfId() {
		return sStfId;
	}

	public void setsStfId(String sStfId) {
		this.sStfId = sStfId;
	}

	public int getStfNo() {
		return stfNo;
	}

	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}

	public String getrMTime() {
		return rMTime;
	}

	public void setrMTime(String rMTime) {
		this.rMTime = rMTime;
	}

	public String getStfId() {
		return stfId;
	}

	public void setStfId(String stfId) {
		this.stfId = stfId;
	}

	public String getStfName() {
		return stfName;
	}

	public void setStfName(String stfName) {
		this.stfName = stfName;
	}

	public SendMsg getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(SendMsg sendMsg) {
		this.sendMsg = sendMsg;
	}

	public ReceiveMsg getReceiveMsg() {
		return receiveMsg;
	}

	public void setReceiveMsg(ReceiveMsg receiveMsg) {
		this.receiveMsg = receiveMsg;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "Msg [mNo=" + mNo + ", mTitle=" + mTitle + ", mContent=" + mContent + ", sMNo=" + sMNo + ", sMTime="
				+ sMTime + ", rStfId=" + rStfId + ", rMNo=" + rMNo + ", rMCheck=" + rMCheck + ", sStfId=" + sStfId
				+ ", stfNo=" + stfNo + ", rMTime=" + rMTime + ", stfId=" + stfId + ", stfName=" + stfName + ", sendMsg="
				+ sendMsg + ", receiveMsg=" + receiveMsg + ", staff=" + staff + "]";
	}

}
