package com.gnt.project.vo;

public class RegistVo {
	public RegistVo() {
	}
	
	public RegistVo(int regNo, String mNo, String category, String title, String content, String sDate, String fDate,
			String pass, String fin, String del, String mod, String cnt, String deny, String url) {
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
		this.url = url;
	}

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
	
	private String url;
	
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
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "RegistVo [regNo=" + regNo + ", mNo=" + mNo + ", category=" + category + ", title=" + title
				+ ", content=" + content + ", sDate=" + sDate + ", fDate=" + fDate + ", pass=" + pass + ", fin=" + fin
				+ ", del=" + del + ", mod=" + mod + ", cnt=" + cnt + ", deny=" + deny + ", url=" + url + "]";
	}

}
