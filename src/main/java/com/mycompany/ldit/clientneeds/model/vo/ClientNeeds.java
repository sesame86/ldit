package com.mycompany.ldit.clientneeds.model.vo;

public class ClientNeeds {
	private static final long serialVersionUID = 1111L;
	private int cnId;
	private int proNo;
	private String cnTitle;
	private String cnContent;
	private int cnPriority;
	private String cnDeactivate;

	public ClientNeeds() {
		super();
	}
	@Override
	public String toString() {
		return "ClientNeeds [cnId=" + cnId + ", proNo=" + proNo + ", cnTitle=" + cnTitle + ", cnContent=" + cnContent
				+ ", cnPriority=" + cnPriority + ", cnDeactivate=" + cnDeactivate + "]";
	}

	public int getCnId() {
		return cnId;
	}

	public void setCnId(int cnId) {
		this.cnId = cnId;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public String getCnTitle() {
		return cnTitle;
	}

	public void setCnTitle(String cnTitle) {
		this.cnTitle = cnTitle;
	}

	public String getCnContent() {
		return cnContent;
	}

	public void setCnContent(String cnContent) {
		this.cnContent = cnContent;
	}

	public int getCnPriority() {
		return cnPriority;
	}

	public void setCnPriority(int cnPriority) {
		this.cnPriority = cnPriority;
	}

	public String getCnDeactivate() {
		return cnDeactivate;
	}

	public void setCnDeactivate(String cnDeactivate) {
		this.cnDeactivate = cnDeactivate;
	}
	
}