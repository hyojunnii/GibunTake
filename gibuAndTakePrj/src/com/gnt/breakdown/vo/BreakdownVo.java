package com.gnt.breakdown.vo;

public class BreakdownVo {
	//기부 내역 vo
	public BreakdownVo () {
		
	}

	public BreakdownVo(String memberId, String memberName, String memberRegNum, String memberAdd, String regName,
			String payNo, String payName, String payMoney, String payDate, String corpName, String corpRegNum,
			String corpAdd, String corpClass) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberRegNum = memberRegNum;
		this.memberAdd = memberAdd;
		this.regName = regName;
		this.payNo = payNo;
		this.payName = payName;
		this.payMoney = payMoney;
		this.payDate = payDate;
		this.corpName = corpName;
		this.corpRegNum = corpRegNum;
		this.corpAdd = corpAdd;
		this.corpClass = corpClass;
	}

	private String memberId; //유저 아이디
	private String memberName; //유저 이름
	private String memberRegNum; //주민번호
	private String memberAdd; //주소
	private String regName; //기부 프로그램 이름
	private String payNo; //결제 번호
	private String payName; //결제 수단
	private String payMoney; //기부(결제) 금액
	private String payDate; //기부(결제) 일자

	private String corpName;
	private String corpRegNum;
	private String corpAdd;
	private String corpClass;
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberRegNum() {
		return memberRegNum;
	}

	public void setMemberRegNum(String memberRegNum) {
		this.memberRegNum = memberRegNum;
	}

	public String getMemberAdd() {
		return memberAdd;
	}

	public void setMemberAdd(String memberAdd) {
		this.memberAdd = memberAdd;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpRegNum() {
		return corpRegNum;
	}

	public void setCorpRegNum(String corpRegNum) {
		this.corpRegNum = corpRegNum;
	}

	public String getCorpAdd() {
		return corpAdd;
	}

	public void setCorpAdd(String corpAdd) {
		this.corpAdd = corpAdd;
	}

	public String getCorpClass() {
		return corpClass;
	}

	public void setCorpClass(String corpClass) {
		this.corpClass = corpClass;
	}

	@Override
	public String toString() {
		return "BreakdownVo [memberId=" + memberId + ", memberName=" + memberName + ", memberRegNum=" + memberRegNum
				+ ", memberAdd=" + memberAdd + ", regName=" + regName + ", payNo=" + payNo + ", payName=" + payName
				+ ", payMoney=" + payMoney + ", payDate=" + payDate + ", corpName=" + corpName + ", corpRegNum="
				+ corpRegNum + ", corpAdd=" + corpAdd + ", corpClass=" + corpClass + "]";
	}

	
}
