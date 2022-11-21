package com.gnt.qa.vo;

public class QaVo {

	public QaVo() {
		
	}
	
	
	
	public QaVo(String no, String name, String content, String date, String cate, String answer, String adate,
			String del, String score) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
		this.date = date;
		this.cate = cate;
		this.answer = answer;
		this.adate = adate;
		this.del = del;
		this.score = score;
	}



	private String no;
	private String name;
	private String content;
	private String date;
	private String cate;
	private String answer;
	private String adate;
	private String del;
	private String score;
	
	public String getNo() {
		return no;
	}



	public void setNo(String no) {
		this.no = no;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getCate() {
		return cate;
	}



	public void setCate(String cate) {
		this.cate = cate;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public String getAdate() {
		return adate;
	}



	public void setAdate(String adate) {
		this.adate = adate;
	}



	public String getDel() {
		return del;
	}



	public void setDel(String del) {
		this.del = del;
	}



	public String getScore() {
		return score;
	}



	public void setScore(String score) {
		this.score = score;
	}



	@Override
	public String toString() {
		return "QaVo [no=" + no + ", name=" + name + ", content=" + content + ", date=" + date + ", cate=" + cate
				+ ", answer=" + answer + ", adate=" + adate + ", del=" + del + ", score=" + score + "]";
	}
	
	
}
