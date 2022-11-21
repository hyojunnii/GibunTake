package com.gnt.common;

public class ReplyVo {

	public ReplyVo() {
		
	}
	
	

	


	public ReplyVo(String repno, String mno, String regno, String repcontent, String repdate, String repdel,
			String repban, String repmod, String mnick) {
		this.repno = repno;
		this.mno = mno;
		this.regno = regno;
		this.repcontent = repcontent;
		this.repdate = repdate;
		this.repdel = repdel;
		this.repban = repban;
		this.repmod = repmod;
		this.mnick = mnick;

	}






	private String repno;		//댓글번호
	private String mno;			//사용자번호
	private String regno;		//등록번호
	private String repcontent;	//댓글내용
	private String repdate;		//작성일
	private String repdel;		//삭제여부
	private String repban;		//신고여부
	private String repmod;		//마지막수정일자
	private String mnick;		//사용자 닉네임





	public String getRepno() {
		return repno;
	}



	public void setRepno(String repno) {
		this.repno = repno;
	}



	public String getMno() {
		return mno;
	}



	public void setMno(String mno) {
		this.mno = mno;
	}



	public String getRegno() {
		return regno;
	}



	public void setRegno(String regno) {
		this.regno = regno;
	}



	public String getRepcontent() {
		return repcontent;
	}



	public void setRepcontent(String repcontent) {
		this.repcontent = repcontent;
	}



	public String getRepdate() {
		return repdate;
	}



	public void setRepdate(String repdate) {
		this.repdate = repdate;
	}



	public String getRepdel() {
		return repdel;
	}



	public void setRepdel(String repdel) {
		this.repdel = repdel;
	}



	public String getRepban() {
		return repban;
	}



	public void setRepban(String repban) {
		this.repban = repban;
	}



	public String getRepmod() {
		return repmod;
	}



	public void setRepmod(String repmod) {
		this.repmod = repmod;
	}



	public String getMnick() {
		return mnick;
	}



	public void setMnick(String mnick) {
		this.mnick = mnick;
	}






	@Override
	public String toString() {
		return "ReplyVo [repno=" + repno + ", mno=" + mno + ", regno=" + regno + ", repcontent=" + repcontent
				+ ", repdate=" + repdate + ", repdel=" + repdel + ", repban=" + repban + ", repmod=" + repmod
				+ ", mnick=" + mnick + "]";
	}
	
		
}
