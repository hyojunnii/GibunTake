package com.gnt.faq.vo;

public class FaqVo {

	public FaqVo() {
		
	}


	public FaqVo(String no, String cate, String title, String content, String writer, String date, String status) {
		super();
		this.no = no;
		this.cate = cate;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.status = status;
	}



	private String no;
	private String cate;
	private String title;
	private String content;
	private String writer;
	private String date;
	private String status;
	
	
	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getCate() {
		return cate;
	}


	public void setCate(String cate) {
		this.cate = cate;
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


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "FaqVo [no=" + no + ", cate=" + cate + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", date=" + date + ", status=" + status + "]";
	}
	
	
	
	
	
}
