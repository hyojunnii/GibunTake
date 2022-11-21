package com.gnt.stmt.vo;

public class ExeVo {
	
	public ExeVo() {
		
	}

	public ExeVo(String donaNo, String exeNo, String exeCtg, String exeCnt, String exeMoney) {
		super();
		this.donaNo = donaNo;
		this.exeNo = exeNo;
		this.exeCtg = exeCtg;
		this.exeCnt = exeCnt;
		this.exeMoney = exeMoney;
	}

	private String donaNo;
	private String exeNo;
	private String exeCtg;
	private String exeCnt;
	private String exeMoney;
	
	
	public String getDonaNo() {
		return donaNo;
	}

	public void setDonaNo(String donaNo) {
		this.donaNo = donaNo;
	}

	public String getExeNo() {
		return exeNo;
	}

	public void setExeNo(String exeNo) {
		this.exeNo = exeNo;
	}

	public String getExeCtg() {
		return exeCtg;
	}

	public void setExeCtg(String exeCtg) {
		this.exeCtg = exeCtg;
	}

	public String getExeCnt() {
		return exeCnt;
	}

	public void setExeCnt(String exeCnt) {
		this.exeCnt = exeCnt;
	}

	public String getExeMoney() {
		return exeMoney;
	}

	public void setExeMoney(String exeMoney) {
		this.exeMoney = exeMoney;
	}

	@Override
	public String toString() {
		return "ExeVo [donaNo=" + donaNo + ", exeNo=" + exeNo + ", exeCtg=" + exeCtg + ", exeCnt=" + exeCnt
				+ ", exeMoney=" + exeMoney + "]";
	}
	
	
}
