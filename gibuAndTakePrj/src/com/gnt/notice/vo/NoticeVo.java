package com.gnt.notice.vo;

public class NoticeVo {
	
	public NoticeVo() {
		
	}
	
	

	public NoticeVo(String no, String cate, String title, String content, String writer, String cnt, String date,
			String mod, String status) {
		super();
		this.no = no;
		this.cate = cate;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.cnt = cnt;
		this.date = date;
		this.mod = mod;
		this.status = status;
	}



	private String no;
	private String cate;
	private String title;
	private String content;
	private String writer;
	private String cnt;
	private String date;
	private String mod;
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



	public String getCnt() {
		return cnt;
	}



	public void setCnt(String cnt) {
		this.cnt = cnt;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getMod() {
		return mod;
	}



	public void setMod(String mod) {
		this.mod = mod;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "NoticeVo [no=" + no + ", cate=" + cate + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", cnt=" + cnt + ", date=" + date + ", mod=" + mod + ", status=" + status + "]";
	}
	
	
	
}
