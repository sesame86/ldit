package com.mycompany.ldit.sendmsg.model.vo;

public class SendMsg {
	private static final long serialVersionUID = 1111L;
	   private int sMNo;
	   private int stfNo;
	   private int mNo;
	   private String sMTime;
	   private String rStfId;
	   
	   public SendMsg() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "sendMsg [sMNo=" + sMNo + ", stfNo=" + stfNo + ", mNo=" + mNo + ", sMTime=" + sMTime
	            + ", rStfId=" + rStfId + "]";
	   }
	   
	   public int getSMNo() {
	      return sMNo;
	   }

	   public void setSMNo(int sMNo) {
	      this.sMNo = sMNo;
	   }

	   public int getStfNo() {
	      return stfNo;
	   }

	   public void setStfNo(int stfNo) {
	      this.stfNo = stfNo;
	   }

	   public int getMNo() {
	      return mNo;
	   }

	   public void setMNo(int mNo) {
	      this.mNo = mNo;
	   }

	   public String getSMTime() {
	      return sMTime;
	   }

	   public void setSMTime(String sMTime) {
	      this.sMTime = sMTime;
	   }

	   public String getRStfId() {
	      return rStfId;
	   }

	   public void setRStfId(String rStfId) {
	      this.rStfId = rStfId;
	   }
}
