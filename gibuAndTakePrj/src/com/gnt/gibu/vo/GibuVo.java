package com.gnt.gibu.vo;

public class GibuVo {
	public GibuVo() {
		
	}
	
	public GibuVo(String dno, String regno, String dclass, int dgmoney, int dpmoney, String dsdate, String dedate,
			String dperson, String regclass, String regname, String regcontent, String regsdate, String regfdate,
			String regpass, String regfin, String regdel, String regmod, int regcnt, String mno, String mnick,
			String imgsrc, String moneypercent, int rscnt) {
		this.dno = dno;
		this.regno = regno;
		this.dclass = dclass;
		this.dgmoney = dgmoney;
		this.dpmoney = dpmoney;
		this.dsdate = dsdate;
		this.dedate = dedate;
		this.dperson = dperson;
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

	private String dno;			//기부번호
	private String regno;		//등록번호
	private String dclass;		//기부분야(0:전체/1:아동,청소년/..
	private int dgmoney;		//목표금액
	private int dpmoney;		//참여금액
	private String dsdate;		//사업기간 시간
	private String dedate;		//사업기간끝
	private String dperson;		//사업대상
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
	
//	private String corpno;		//기업번호
//	private String corpcontent; //기업설명
//	private String corpClass;	//기업유형
	
	
	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getDclass() {
		return dclass;
	}

	public void setDclass(String dclass) {
		this.dclass = dclass;
	}

	public int getDgmoney() {
		return dgmoney;
	}

	public void setDgmoney(int dgmoney) {
		this.dgmoney = dgmoney;
	}

	public int getDpmoney() {
		return dpmoney;
	}

	public void setDpmoney(int dpmoney) {
		this.dpmoney = dpmoney;
	}

	public String getDsdate() {
		return dsdate;
	}

	public void setDsdate(String dsdate) {
		this.dsdate = dsdate;
	}

	public String getDedate() {
		return dedate;
	}

	public void setDedate(String dedate) {
		this.dedate = dedate;
	}

	public String getDperson() {
		return dperson;
	}

	public void setDperson(String dperson) {
		this.dperson = dperson;
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
		return "GibuVo [dno=" + dno + ", regno=" + regno + ", dclass=" + dclass + ", dgmoney=" + dgmoney + ", dpmoney="
				+ dpmoney + ", dsdate=" + dsdate + ", dedate=" + dedate + ", dperson=" + dperson + ", regclass="
				+ regclass + ", regname=" + regname + ", regcontent=" + regcontent + ", regsdate=" + regsdate
				+ ", regfdate=" + regfdate + ", regpass=" + regpass + ", regfin=" + regfin + ", regdel=" + regdel
				+ ", regmod=" + regmod + ", regcnt=" + regcnt + ", mno=" + mno + ", mnick=" + mnick + ", imgsrc="
				+ imgsrc + ", moneypercent=" + moneypercent + ", rscnt=" + rscnt + "]";
	}
	
		
		
}
