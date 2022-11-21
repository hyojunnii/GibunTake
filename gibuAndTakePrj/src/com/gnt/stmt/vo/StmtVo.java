package com.gnt.stmt.vo;

public class StmtVo {

	public StmtVo() {
		
	}

	public StmtVo(int memberNo, String regNo, String donaNo, String regName, String donaClass, String donaGmoney,
			String donaPmoney, String donaSdate, String donaEdate, String donaPerson) {
		super();
		this.memberNo = memberNo;
		this.regNo = regNo;
		this.donaNo = donaNo;
		this.regName = regName;
		this.donaClass = donaClass;
		this.donaGmoney = donaGmoney;
		this.donaPmoney = donaPmoney;
		this.donaSdate = donaSdate;
		this.donaEdate = donaEdate;
		this.donaPerson = donaPerson;
	}

	private int memberNo;
	private String regNo;
	private String donaNo;
	private String regName;
	private String donaClass;
	private String donaGmoney;
	private String donaPmoney;
	private String donaSdate;
	private String donaEdate;
	private String donaPerson; 
	
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int no) {
		this.memberNo = no;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getDonaNo() {
		return donaNo;
	}

	public void setDonaNo(String donaNo) {
		this.donaNo = donaNo;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getDonaClass() {
		return donaClass;
	}

	public void setDonaClass(String donaClass) {
		this.donaClass = donaClass;
	}

	public String getDonaGmoney() {
		return donaGmoney;
	}

	public void setDonaGmoney(String donaGmoney) {
		this.donaGmoney = donaGmoney;
	}

	public String getDonaPmoney() {
		return donaPmoney;
	}

	public void setDonaPmoney(String donaPmoney) {
		this.donaPmoney = donaPmoney;
	}

	public String getDonaSdate() {
		return donaSdate;
	}

	public void setDonaSdate(String donaSdate) {
		this.donaSdate = donaSdate;
	}

	public String getDonaEdate() {
		return donaEdate;
	}

	public void setDonaEdate(String donaEdate) {
		this.donaEdate = donaEdate;
	}

	public String getDonaPerson() {
		return donaPerson;
	}

	public void setDonaPerson(String donaPerson) {
		this.donaPerson = donaPerson;
	}

	@Override
	public String toString() {
		return "StmtVo [memberNo=" + memberNo + ", regNo=" + regNo + ", donaNo=" + donaNo + ", regName=" + regName
				+ ", donaClass=" + donaClass + ", donaGmomey=" + donaGmoney + ", donaPmoney=" + donaPmoney
				+ ", donaSdate=" + donaSdate + ", donaEdate=" + donaEdate + ", donaPerson=" + donaPerson + "]";
	}
	
}
