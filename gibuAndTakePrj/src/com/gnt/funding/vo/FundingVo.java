package com.gnt.funding.vo;

public class FundingVo {
	
	public FundingVo() {
		
	}
	
	



	public FundingVo(String fno, String regno, String fclass, int fgmoney, int fpmoney, int fppeople, String regclass,
			String regname, String regcontent, String regsdate, String regfdate, String regpass, String regfin,
			String regdel, String regmod, int regcnt, String mno, String mnick, String imgsrc, String moneypercent,
			int rscnt, int rewno, String rewname, int rewmoney, int rewcnt) {
		this.fno = fno;
		this.regno = regno;
		this.fclass = fclass;
		this.fgmoney = fgmoney;
		this.fpmoney = fpmoney;
		this.fppeople = fppeople;
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
		this.rewno = rewno;
		this.rewname = rewname;
		this.rewmoney = rewmoney;
		this.rewcnt = rewcnt;
	}





	private String fno;			//펀딩번호
	private String regno;		//등록번호
	private String fclass;	//펀딩분야
	private int  fgmoney;		//목표금액
	private int fpmoney;		//참여한금액
	private int fppeople;	//참여인원
	
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
	
	private int rewno;
	private String rewname;
	private int rewmoney;
	private int rewcnt; 
	
	
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getFclass() {
		return fclass;
	}
	public void setFclass(String fclass) {
		this.fclass = fclass;
	}
	public int getFgmoney() {
		return fgmoney;
	}
	public void setFgmoney(int fgmoney) {
		this.fgmoney = fgmoney;
	}
	public int getFpmoney() {
		return fpmoney;
	}
	public void setFpmoney(int fpmoney) {
		this.fpmoney = fpmoney;
	}
	public int getFppeople() {
		return fppeople;
	}
	public void setFppeople(int fppeople) {
		this.fppeople = fppeople;
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
	
	public int getRewno() {
		return rewno;
	}


	public void setRewno(int rewno) {
		this.rewno = rewno;
	}


	public String getRewname() {
		return rewname;
	}


	public void setRewname(String rewname) {
		this.rewname = rewname;
	}


	public int getRewmoney() {
		return rewmoney;
	}


	public void setRewmoney(int rewmoney) {
		this.rewmoney = rewmoney;
	}


	public int getRewcnt() {
		return rewcnt;
	}


	public void setRewcnt(int rewcnt) {
		this.rewcnt = rewcnt;
	}


	@Override
	public String toString() {
		return "FundingVo [fno=" + fno + ", regno=" + regno + ", fclass=" + fclass + ", fgmoney=" + fgmoney
				+ ", fpmoney=" + fpmoney + ", fppeople=" + fppeople + ", regclass=" + regclass + ", regname=" + regname
				+ ", regcontent=" + regcontent + ", regsdate=" + regsdate + ", regfdate=" + regfdate + ", regpass="
				+ regpass + ", regfin=" + regfin + ", regdel=" + regdel + ", regmod=" + regmod + ", regcnt=" + regcnt
				+ ", mno=" + mno + ", mnick=" + mnick + ", imgsrc=" + imgsrc + ", moneypercent=" + moneypercent
				+ ", rscnt=" + rscnt + ", rewno=" + rewno + ", rewname=" + rewname + ", rewmoney=" + rewmoney
				+ ", rewcnt=" + rewcnt + "]";
	}


	
}
