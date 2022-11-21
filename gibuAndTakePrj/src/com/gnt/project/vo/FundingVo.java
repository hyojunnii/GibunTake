package com.gnt.project.vo;

import java.util.Arrays;

public class FundingVo {
	public FundingVo() {
	}
	
	public FundingVo(int regNo, String mNo, String category, String title, String content, String sDate, String fDate,
			String pass, String fin, String del, String mod, String cnt, String deny, int fNo, String fundCategory,
			String gMoney, String pMoney, String pPeople, int rewNo, String[] name, String[] money, String[] count) {
		this.regNo = regNo;
		this.mNo = mNo;
		this.category = category;
		this.title = title;
		this.content = content;
		this.sDate = sDate;
		this.fDate = fDate;
		this.pass = pass;
		this.fin = fin;
		this.del = del;
		this.mod = mod;
		this.cnt = cnt;
		this.deny = deny;
		this.fNo = fNo;
		this.fundCategory = fundCategory;
		this.gMoney = gMoney;
		this.pMoney = pMoney;
		this.pPeople = pPeople;
		this.rewNo = rewNo;
		this.name = name;
		this.money = money;
		this.count = count;
	}

	//regist
	private int regNo;
	private String mNo;
	private String category; //기부/펀딩/캠페인
	private String title;
	private String content;
	private String sDate;
	private String fDate;
	private String pass;
	private String fin;
	private String del;
	private String mod;
	private String cnt;
	private String deny;
	
	//funding
	private int fNo;
	private String fundCategory;
	private String gMoney;
	private String pMoney;
	private String pPeople;
	
	//reward
	private int rewNo;
	private String[] name;
	private String[] money;
	private String[] count;
	
	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public String getmNo() {
		return mNo;
	}

	public void setmNo(String mNo) {
		this.mNo = mNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getfDate() {
		return fDate;
	}

	public void setfDate(String fDate) {
		this.fDate = fDate;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	public String getDeny() {
		return deny;
	}

	public void setDeny(String deny) {
		this.deny = deny;
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public String getFundCategory() {
		return fundCategory;
	}

	public void setFundCategory(String fundCategory) {
		this.fundCategory = fundCategory;
	}

	public String getgMoney() {
		return gMoney;
	}

	public void setgMoney(String gMoney) {
		this.gMoney = gMoney;
	}

	public String getpMoney() {
		return pMoney;
	}

	public void setpMoney(String pMoney) {
		this.pMoney = pMoney;
	}

	public String getpPeople() {
		return pPeople;
	}

	public void setpPeople(String pPeople) {
		this.pPeople = pPeople;
	}

	public int getRewNo() {
		return rewNo;
	}

	public void setRewNo(int rewNo) {
		this.rewNo = rewNo;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public String[] getMoney() {
		return money;
	}

	public void setMoney(String[] money) {
		this.money = money;
	}

	public String[] getCount() {
		return count;
	}

	public void setCount(String[] count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "FundingVo [regNo=" + regNo + ", mNo=" + mNo + ", category=" + category + ", title=" + title
				+ ", content=" + content + ", sDate=" + sDate + ", fDate=" + fDate + ", pass=" + pass + ", fin=" + fin
				+ ", del=" + del + ", mod=" + mod + ", cnt=" + cnt + ", deny=" + deny + ", fNo=" + fNo
				+ ", fundCategory=" + fundCategory + ", gMoney=" + gMoney + ", pMoney=" + pMoney + ", pPeople="
				+ pPeople + ", rewNo=" + rewNo + ", name=" + Arrays.toString(name) + ", money=" + Arrays.toString(money)
				+ ", count=" + Arrays.toString(count) + "]";
	}
	
}
