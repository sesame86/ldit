package com.mycompany.ldit.receivemsg.model.vo;

public class ReceiveMsg {
	private static final long serialVersionUID = 1111L;
	   private int rMNo;
	   private int stfNo;
	   private int mNo;
	   private String rMTime;
	   private int rMCheck;
	   private String sStfId;
	   
	   public ReceiveMsg() {
	      super();
	   }

	   @Override
	   public String toString() {
	      return "receiveMsg [rMNo=" + rMNo + ", stfNo=" + stfNo + ", mNo=" + mNo + ", rMTime=" + rMTime
	            + ", rMCheck=" + rMCheck + ", sStfId=" + sStfId + "]";
	   }
	   
	   public int getRMNo() {
	      return rMNo;
	   }

	   public void setRMNo(int rMNo) {
	      this.rMNo = rMNo;
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

	   public String getR_mTime() {
	      return rMTime;
	   }

	   public void setRMTime(String rMTime) {
	      this.rMTime = rMTime;
	   }

	   public int getRMCheck() {
	      return rMCheck;
	   }

	   public void setRMCheck(int rMCheck) {
	      this.rMCheck = rMCheck;
	   }

	   public String getSStfId() {
	      return sStfId;
	   }

	   public void setSStfId(String sStfId) {
	      this.sStfId = sStfId;
	   }
}
