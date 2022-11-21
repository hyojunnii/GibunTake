package com.gnt.story.vo;

public class StoryVo {
	
	public StoryVo() {
		
	}
	
	private String totalMoney;
	private String totalCnt;
	private String totalDonateMoney;
	private String totalDonateCnt;
	private String totalFundingMoney;
	private String totalFundingCnt;
	private String totalCampaignCnt;
	
	public StoryVo(String totalMoney, String totalCnt, String totalDonateMoney, String totalDonateCnt,
			String totalFundingMoney, String totalFundingCnt, String totalCampaignCnt) {
		super();
		this.totalMoney = totalMoney;
		this.totalCnt = totalCnt;
		this.totalDonateMoney = totalDonateMoney;
		this.totalDonateCnt = totalDonateCnt;
		this.totalFundingMoney = totalFundingMoney;
		this.totalFundingCnt = totalFundingCnt;
		this.totalCampaignCnt = totalCampaignCnt;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}

	public String getTotalDonateMoney() {
		return totalDonateMoney;
	}

	public void setTotalDonateMoney(String totalDonateMoney) {
		this.totalDonateMoney = totalDonateMoney;
	}

	public String getTotalDonateCnt() {
		return totalDonateCnt;
	}

	public void setTotalDonateCnt(String totalDonateCnt) {
		this.totalDonateCnt = totalDonateCnt;
	}

	public String getTotalFundingMoney() {
		return totalFundingMoney;
	}

	public void setTotalFundingMoney(String totalFundingMoney) {
		this.totalFundingMoney = totalFundingMoney;
	}

	public String getTotalFundingCnt() {
		return totalFundingCnt;
	}

	public void setTotalFundingCnt(String totalFundingCnt) {
		this.totalFundingCnt = totalFundingCnt;
	}

	public String getTotalCampaignCnt() {
		return totalCampaignCnt;
	}

	public void setTotalCampaignCnt(String totalCampaignCnt) {
		this.totalCampaignCnt = totalCampaignCnt;
	}

	@Override
	public String toString() {
		return "StoryVo [totalMoney=" + totalMoney + ", totalCnt=" + totalCnt + ", totalDonateMoney=" + totalDonateMoney
				+ ", totalDonateCnt=" + totalDonateCnt + ", totalFundingMoney=" + totalFundingMoney
				+ ", totalFundingCnt=" + totalFundingCnt + ", totalCampaignCnt=" + totalCampaignCnt + "]";
	}
	
	
	
	
	
}
