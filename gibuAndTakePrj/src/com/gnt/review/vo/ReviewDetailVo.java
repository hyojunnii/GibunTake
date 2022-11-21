package com.gnt.review.vo;

public class ReviewDetailVo {
	public ReviewDetailVo() {
		
	}
	
	private String revNo;
	private String mNo;
	private String mNick;
	private String revName;
	private String revContent;
	private String revDate;
	private String camGpeople;
	private String camPpeople;
	private String Gmoney;
	private String Pmoney;
	private String corpContent;
	private String regSdate;
	private String regFdate;
	private String img;
	

	public ReviewDetailVo(String revNo, String mNo, String mNick, String revName, String revContent, String revDate,
			String camGpeople, String camPpeople, String gmoney, String pmoney, String corpContent, String regSdate,
			String regFdate, String img) {
		super();
		this.revNo = revNo;
		this.mNo = mNo;
		this.mNick = mNick;
		this.revName = revName;
		this.revContent = revContent;
		this.revDate = revDate;
		this.camGpeople = camGpeople;
		this.camPpeople = camPpeople;
		Gmoney = gmoney;
		Pmoney = pmoney;
		this.corpContent = corpContent;
		this.regSdate = regSdate;
		this.regFdate = regFdate;
		this.img = img;
	}



	public String getRevNo() {
		return revNo;
	}

	public void setRevNo(String revNo) {
		this.revNo = revNo;
	}

	public String getmNo() {
		return mNo;
	}

	public void setmNo(String mNo) {
		this.mNo = mNo;
	}

	public String getmNick() {
		return mNick;
	}

	public void setmNick(String mNick) {
		this.mNick = mNick;
	}

	public String getRevName() {
		return revName;
	}

	public void setRevName(String revName) {
		this.revName = revName;
	}

	public String getRevContent() {
		return revContent;
	}

	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}

	public String getRevDate() {
		return revDate;
	}

	public void setRevDate(String revDate) {
		this.revDate = revDate;
	}

	public String getCamGpeople() {
		return camGpeople;
	}

	public void setCamGpeople(String camGpeople) {
		this.camGpeople = camGpeople;
	}

	public String getCamPpeople() {
		return camPpeople;
	}

	public void setCamPpeople(String camPpeople) {
		this.camPpeople = camPpeople;
	}

	public String getCorpContent() {
		return corpContent;
	}

	public void setCorpContent(String corpContent) {
		this.corpContent = corpContent;
	}

	public String getRegSdate() {
		return regSdate;
	}

	public void setRegSdate(String regSdate) {
		this.regSdate = regSdate;
	}

	public String getRegFdate() {
		return regFdate;
	}

	public void setRegFdate(String regFdate) {
		this.regFdate = regFdate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public String getGmoney() {
		return Gmoney;
	}

	public void setGmoney(String gmoney) {
		Gmoney = gmoney;
	}

	public String getPmoney() {
		return Pmoney;
	}

	public void setPmoney(String pmoney) {
		Pmoney = pmoney;
	}

	@Override
	public String toString() {
		return "ReviewDetailVo [revNo=" + revNo + ", mNo=" + mNo + ", mNick=" + mNick + ", revName=" + revName
				+ ", revContent=" + revContent + ", revDate=" + revDate + ", camGpeople=" + camGpeople + ", camPpeople="
				+ camPpeople + ", corpContent=" + corpContent + ", regSdate=" + regSdate + ", regFdate=" + regFdate
				+ "]";
	}
	
	
	
}
