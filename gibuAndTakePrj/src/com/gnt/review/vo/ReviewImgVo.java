package com.gnt.review.vo;

public class ReviewImgVo {
	public ReviewImgVo() {
		
	}
	
	private String revNo;
	private String url;
	private String responseCode;
	
	

	public ReviewImgVo(String revNo, String url, String responseCode) {
		super();
		this.revNo = revNo;
		this.url = url;
		this.responseCode = responseCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	public String getRevNo() {
		return revNo;
	}

	public void setRevNo(String revNo) {
		this.revNo = revNo;
	}

	@Override
	public String toString() {
		return "ReviewImgVo [url=" + url + ", responseCode=" + responseCode + "]";
	}
	
	
	
}
