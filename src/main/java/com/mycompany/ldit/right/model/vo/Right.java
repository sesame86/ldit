package com.mycompany.ldit.right.model.vo;

public class Right {
	private static final long serialVersionUID = 1111L;
	   private int proNo;
	   private int stfNo;
	   private int rightNo;
	   
	   public Right() {
	      super();
	   }

	@Override
	public String toString() {
		return "Right [proNo=" + proNo + ", stfNo=" + stfNo + ", rightNo=" + rightNo + "]";
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public int getStfNo() {
		return stfNo;
	}

	public void setStfNo(int stfNo) {
		this.stfNo = stfNo;
	}

	public int getRightNo() {
		return rightNo;
	}

	public void setRightNo(int rightNo) {
		this.rightNo = rightNo;
	}
}
