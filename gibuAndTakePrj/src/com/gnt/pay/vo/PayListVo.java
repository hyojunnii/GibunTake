package com.gnt.pay.vo;

public class PayListVo {
	public PayListVo() {
		
	}
	
	private String plNo;
	private String regNo;
	private String pNo;
	private String plDate;
	private String plMoney;
	
	public PayListVo(String plNo, String regNo, String pNo, String plDate, String plMoney) {
		super();
		this.plNo = plNo;
		this.regNo = regNo;
		this.pNo = pNo;
		this.plDate = plDate;
		this.plMoney = plMoney;
	}

	public String getPlNo() {
		return plNo;
	}

	public void setPlNo(String plNo) {
		this.plNo = plNo;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getPlDate() {
		return plDate;
	}

	public void setPlDate(String plDate) {
		this.plDate = plDate;
	}

	public String getPlMoney() {
		return plMoney;
	}

	public void setPlMoney(String plMoney) {
		this.plMoney = plMoney;
	}

	@Override
	public String toString() {
		return "PayListVo [plNo=" + plNo + ", regNo=" + regNo + ", pNo=" + pNo + ", plDate=" + plDate + ", plMoney="
				+ plMoney + "]";
	}
	
	
}
