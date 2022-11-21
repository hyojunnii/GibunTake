package com.gnt.campaignproof.vo;

public class CampaignProofVo {
	public CampaignProofVo() {
	}
	
	public CampaignProofVo(int mNo, int camNo, String content) {
		this.mNo = mNo;
		this.camNo = camNo;
		this.content = content;
	}

	private int mNo;
	private int camNo;
	private String content;
	
	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getCamNo() {
		return camNo;
	}

	public void setCamNo(int camNo) {
		this.camNo = camNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CampaignProofVo [mNo=" + mNo + ", camNo=" + camNo + ", content=" + content + "]";
	}
}
