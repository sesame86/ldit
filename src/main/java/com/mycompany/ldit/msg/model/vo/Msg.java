package com.mycompany.ldit.msg.model.vo;

import org.springframework.stereotype.Component;

import com.mycompany.ldit.receivemsg.model.vo.ReceiveMsg;
import com.mycompany.ldit.sendmsg.model.vo.SendMsg;

@Component
public class Msg {
	private static final long serialVersionUID = 1111L;
	private int mNo;
	private String mTitle;
	private String mContent;
	
	private int sMNo;
	private String sMTime;
	
	private int rMNo;
	private int rMCheck;
	
	private SendMsg sendmsg;
	private ReceiveMsg receivemsg;
	
	public Msg() {
		super();
	}

	
	public int getMNo() {
		return mNo;
	}

	public void setMNo(int mNo) {
		this.mNo = mNo;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setMTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getMContent() {
		return mContent;
	}

	public void setMContent(String mContent) {
		this.mContent = mContent;
	}

	public int getSMNo() {
		return sMNo;
	}

	public void setSMNo(int sMNo) {
		this.sMNo = sMNo;
	}

	public String getSMTime() {
		return sMTime;
	}

	public void setSMTime(String sMTime) {
		this.sMTime = sMTime;
	}

	public int getRMNo() {
		return rMNo;
	}

	public void setRMNo(int rMNo) {
		this.rMNo = rMNo;
	}

	public int getRMCheck() {
		return rMCheck;
	}

	public void setRMCheck(int rMCheck) {
		this.rMCheck = rMCheck;
	}

	public SendMsg getSendMsg() {
		return sendmsg;
	}

	public void setSendMsg(SendMsg sendmsg) {
		this.sendmsg = sendmsg;
	}

	public ReceiveMsg getReceiveMsg() {
		return receivemsg;
	}

	public void setReceiveMsg(ReceiveMsg receivemsg) {
		this.receivemsg = receivemsg;
	}


	@Override
	public String toString() {
		return "Msg [mNo=" + mNo + ", mTitle=" + mTitle + ", mContent=" + mContent + ", sMNo=" + sMNo + ", sMTime="
				+ sMTime + ", rMNo=" + rMNo + ", rMCheck=" + rMCheck + ", sendmsg=" + sendmsg + ", receivemsg="
				+ receivemsg + "]";
	}

}
