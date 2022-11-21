package com.gnt.campaign.vo;

public class CampaignProofVo {
	public CampaignProofVo() {
		
	}
	

	public CampaignProofVo(String cpno, String mno, String camno, String cpcontent, String cpdate, String cpdel,
			String cpban, String cpmod, String mnick, String imgsrc, String regno) {
		this.cpno = cpno;
		this.mno = mno;
		this.camno = camno;
		this.cpcontent = cpcontent;
		this.cpdate = cpdate;
		this.cpdel = cpdel;
		this.cpban = cpban;
		this.cpmod = cpmod;
		this.mnick = mnick;
		this.imgsrc = imgsrc;
		this.regno = regno;
	}





	private String cpno;		//댓글번호
	private String mno;			//사용자번호
	private String camno;		//캠페인 번호
	private String cpcontent;	//댓글내용
	private String cpdate;		//작성일
	private String cpdel;		//삭제여부
	private String cpban;		//신고여부
	private String cpmod;		//마지막수정일자
	private String mnick;		//사용자 닉네임
	private String imgsrc;
	
	private String regno; 		//등록번호
	
	
	public String getRegno() {
		return regno;
	}



	public void setRegno(String regno) {
		this.regno = regno;
	}



	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getCpno() {
		return cpno;
	}
	public void setCpno(String cpno) {
		this.cpno = cpno;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getCamno() {
		return camno;
	}
	public void setCamno(String camno) {
		this.camno = camno;
	}
	public String getCpcontent() {
		return cpcontent;
	}
	public void setCpcontent(String cpcontent) {
		this.cpcontent = cpcontent;
	}
	public String getCpdate() {
		return cpdate;
	}
	public void setCpdate(String cpdate) {
		this.cpdate = cpdate;
	}
	public String getCpdel() {
		return cpdel;
	}
	public void setCpdel(String cpdel) {
		this.cpdel = cpdel;
	}
	public String getCpban() {
		return cpban;
	}
	public void setCpban(String cpban) {
		this.cpban = cpban;
	}
	public String getCpmod() {
		return cpmod;
	}
	public void setCpmod(String cpmod) {
		this.cpmod = cpmod;
	}
	public String getMnick() {
		return mnick;
	}
	public void setMnick(String mnick) {
		this.mnick = mnick;
	}


	@Override
	public String toString() {
		return "CampaignProofVo [cpno=" + cpno + ", mno=" + mno + ", camno=" + camno + ", cpcontent=" + cpcontent
				+ ", cpdate=" + cpdate + ", cpdel=" + cpdel + ", cpban=" + cpban + ", cpmod=" + cpmod + ", mnick="
				+ mnick + ", imgsrc=" + imgsrc + ", regno=" + regno + "]";
	}


}
