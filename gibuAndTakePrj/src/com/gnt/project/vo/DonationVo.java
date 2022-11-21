package com.gnt.project.vo;

import java.util.Arrays;

public class DonationVo {
	
	public DonationVo() {
	}

	public DonationVo(int regNo, String mNo, String category, String title, String content, String sDate, String fDate,
			String pass, String fin, String del, String mod, String cnt, String deny, int dNo, String donaCategory,
			String gMoney, String pMoney, String exeSDate, String exeEDate, String person, String pPeople, int[] eNo,
			String[] donaExecategory, String[] donaExecontent, String[] money) {
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
		this.dNo = dNo;
		this.donaCategory = donaCategory;
		this.gMoney = gMoney;
		this.pMoney = pMoney;
		this.exeSDate = exeSDate;
		this.exeEDate = exeEDate;
		this.person = person;
		this.pPeople = pPeople;
		this.eNo = eNo;
		this.donaExecategory = donaExecategory;
		this.donaExecontent = donaExecontent;
		this.money = money;
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
	
	//donation
	private int dNo;
	private String donaCategory;
	private String gMoney;
	private String pMoney;
	private String exeSDate;
	private String exeEDate;
	private String person;
	private String pPeople;
	
	//execute
	private int[] eNo;
	private String[] donaExecategory;
	private String[] donaExecontent;
	private String[] money;
	
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

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getDonaCategory() {
		return donaCategory;
	}

	public void setDonaCategory(String donaCategory) {
		this.donaCategory = donaCategory;
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

	public String getExeSDate() {
		return exeSDate;
	}

	public void setExeSDate(String exeSDate) {
		this.exeSDate = exeSDate;
	}

	public String getExeEDate() {
		return exeEDate;
	}

	public void setExeEDate(String exeEDate) {
		this.exeEDate = exeEDate;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getpPeople() {
		return pPeople;
	}

	public void setpPeople(String pPeople) {
		this.pPeople = pPeople;
	}

	public int[] geteNo() {
		return eNo;
	}

	public void seteNo(int[] eNo) {
		this.eNo = eNo;
	}

	public String[] getDonaExecategory() {
		return donaExecategory;
	}

	public void setDonaExecategory(String[] donaExecategory) {
		this.donaExecategory = donaExecategory;
	}

	public String[] getDonaExecontent() {
		return donaExecontent;
	}

	public void setDonaExecontent(String[] donaExecontent) {
		this.donaExecontent = donaExecontent;
	}

	public String[] getMoney() {
		return money;
	}

	public void setMoney(String[] money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "DonationVo [regNo=" + regNo + ", mNo=" + mNo + ", category=" + category + ", title=" + title
				+ ", content=" + content + ", sDate=" + sDate + ", fDate=" + fDate + ", pass=" + pass + ", fin=" + fin
				+ ", del=" + del + ", mod=" + mod + ", cnt=" + cnt + ", deny=" + deny + ", dNo=" + dNo
				+ ", donaCategory=" + donaCategory + ", gMoney=" + gMoney + ", pMoney=" + pMoney + ", exeSDate="
				+ exeSDate + ", exeEDate=" + exeEDate + ", person=" + person + ", pPeople=" + pPeople + ", eNo="
				+ Arrays.toString(eNo) + ", donaExecategory=" + Arrays.toString(donaExecategory) + ", donaExecontent="
				+ Arrays.toString(donaExecontent) + ", money=" + Arrays.toString(money) + "]";
	}

}
