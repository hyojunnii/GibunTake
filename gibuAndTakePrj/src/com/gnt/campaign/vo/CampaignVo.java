package com.gnt.campaign.vo;

public class CampaignVo {

	public CampaignVo() {
		
	}
	
	
	public CampaignVo(String camno, String regno, int camgpeople, int camppeople, String regclass, String regname,
			String regcontent, String regsdate, String regfdate, String regpass, String regfin, String regdel,
			String regmod, int regcnt, String mno, String mnick, String imgsrc, String moneypercent, int rscnt) {
		this.camno = camno;
		this.regno = regno;
		this.camgpeople = camgpeople;
		this.camppeople = camppeople;
		this.regclass = regclass;
		this.regname = regname;
		this.regcontent = regcontent;
		this.regsdate = regsdate;
		this.regfdate = regfdate;
		this.regpass = regpass;
		this.regfin = regfin;
		this.regdel = regdel;
		this.regmod = regmod;
		this.regcnt = regcnt;
		this.mno = mno;
		this.mnick = mnick;
		this.imgsrc = imgsrc;
		this.moneypercent = moneypercent;
		this.rscnt = rscnt;
	}


	private String camno;	//캠페인번호
	private String regno;	//등록번호
	private int camgpeople;	//목표인원수
	private int camppeople;	//참여인원수
	
	
	
	private String regclass;	//카테고리 (기부/펀딩/캠페인)
	private String regname;		//제목
	private String regcontent;	//내용
	private String regsdate;	//시작일
	private String regfdate;	//종료일
	private String regpass;		//통과여부
	private String regfin;		//종료여부
	private String regdel;		//삭제여부
	private String regmod;		//마지막 수정일자
	private int regcnt;			//조회수
	private String mno;			//사용자번호
	private String mnick;		//사용자닉네임(기업이면 기업명)
		
	private String imgsrc;	//이미지경로
	private String moneypercent; //퍼센트
	private int rscnt;			//조회된게시글 수
	public String getCamno() {
		return camno;
	}
	public void setCamno(String camno) {
		this.camno = camno;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public int getCamgpeople() {
		return camgpeople;
	}
	public void setCamgpeople(int camgpeople) {
		this.camgpeople = camgpeople;
	}
	public int getCamppeople() {
		return camppeople;
	}
	public void setCamppeople(int camppeople) {
		this.camppeople = camppeople;
	}
	public String getRegclass() {
		return regclass;
	}
	public void setRegclass(String regclass) {
		this.regclass = regclass;
	}
	public String getRegname() {
		return regname;
	}
	public void setRegname(String regname) {
		this.regname = regname;
	}
	public String getRegcontent() {
		return regcontent;
	}
	public void setRegcontent(String regcontent) {
		this.regcontent = regcontent;
	}
	public String getRegsdate() {
		return regsdate;
	}
	public void setRegsdate(String regsdate) {
		this.regsdate = regsdate;
	}
	public String getRegfdate() {
		return regfdate;
	}
	public void setRegfdate(String regfdate) {
		this.regfdate = regfdate;
	}
	public String getRegpass() {
		return regpass;
	}
	public void setRegpass(String regpass) {
		this.regpass = regpass;
	}
	public String getRegfin() {
		return regfin;
	}
	public void setRegfin(String regfin) {
		this.regfin = regfin;
	}
	public String getRegdel() {
		return regdel;
	}
	public void setRegdel(String regdel) {
		this.regdel = regdel;
	}
	public String getRegmod() {
		return regmod;
	}
	public void setRegmod(String regmod) {
		this.regmod = regmod;
	}
	public int getRegcnt() {
		return regcnt;
	}
	public void setRegcnt(int regcnt) {
		this.regcnt = regcnt;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getMnick() {
		return mnick;
	}
	public void setMnick(String mnick) {
		this.mnick = mnick;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public String getMoneypercent() {
		return moneypercent;
	}
	public void setMoneypercent(String moneypercent) {
		this.moneypercent = moneypercent;
	}
	public int getRscnt() {
		return rscnt;
	}
	public void setRscnt(int rscnt) {
		this.rscnt = rscnt;
	}
	@Override
	public String toString() {
		return "CampaignVo [camno=" + camno + ", regno=" + regno + ", camgpeople=" + camgpeople + ", camppeople="
				+ camppeople + ", regclass=" + regclass + ", regname=" + regname + ", regcontent=" + regcontent
				+ ", regsdate=" + regsdate + ", regfdate=" + regfdate + ", regpass=" + regpass + ", regfin=" + regfin
				+ ", regdel=" + regdel + ", regmod=" + regmod + ", regcnt=" + regcnt + ", mno=" + mno + ", mnick="
				+ mnick + ", imgsrc=" + imgsrc + ", moneypercent=" + moneypercent + ", rscnt=" + rscnt + "]";
	}
	
	
}
