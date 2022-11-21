package com.gnt.pay.vo;

public class PaymentVo {
	public PaymentVo() {
		
	}
	
	private String pNo;
	private String mNo;
	private String pName;
	private String pNumber;
	
	
	public PaymentVo(String pNo, String mNo, String pName, String pNumber) {
		super();
		this.pNo = pNo;
		this.mNo = mNo;
		this.pName = pName;
		this.pNumber = pNumber;
	}


	public String getpNo() {
		return pNo;
	}


	public void setpNo(String pNo) {
		this.pNo = pNo;
	}


	public String getmNo() {
		return mNo;
	}


	public void setmNo(String mNo) {
		this.mNo = mNo;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpNumber() {
		return pNumber;
	}


	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}


	@Override
	public String toString() {
		return "PaymentVo [pNo=" + pNo + ", mNo=" + mNo + ", pName=" + pName + ", pNumber=" + pNumber + "]";
	}
	
	
	
}
