package com.mycompany.ldit.attendance.model.vo;

public class WorkHomeApply {

		
		private int whomeNo;
		private int stfNo;
		private int whWhen;
		private String whStart;
		private String whEnd;
		
		public WorkHomeApply() {
			super();
		}

		public WorkHomeApply(int whomeNo, int stfNo, int whWhen, String whStart, String whEnd) {
			super();
			this.whomeNo = whomeNo;
			this.stfNo = stfNo;
			this.whWhen = whWhen;
			this.whStart = whStart;
			this.whEnd = whEnd;
		}

		@Override
		public String toString() {
			return "WorkHomeApply [whomeNo=" + whomeNo + ", stfNo=" + stfNo + ", whWhen=" + whWhen + ", whStart="
					+ whStart + ", whEnd=" + whEnd + "]";
		}

		public int getWhomeNo() {
			return whomeNo;
		}

		public void setWhomeNo(int whomeNo) {
			this.whomeNo = whomeNo;
		}

		public int getStfNo() {
			return stfNo;
		}

		public void setStfNo(int stfNo) {
			this.stfNo = stfNo;
		}

		public int getWhWhen() {
			return whWhen;
		}

		public void setWhWhen(int whWhen) {
			this.whWhen = whWhen;
		}

		public String getWhStart() {
			return whStart;
		}

		public void setWhStart(String whStart) {
			this.whStart = whStart;
		}

		public String getWhEnd() {
			return whEnd;
		}

		public void setWhEnd(String whEnd) {
			this.whEnd = whEnd;
		}
		
}
