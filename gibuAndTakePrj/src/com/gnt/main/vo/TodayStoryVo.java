package com.gnt.main.vo;

public class TodayStoryVo {
	
	public TodayStoryVo() {
	}
	
	public TodayStoryVo(String today, String dPeople, String dMoney, String fPeople, String fMoney) {
		this.today = today;
		this.dPeople = dPeople;
		this.dMoney = dMoney;
		this.fPeople = fPeople;
		this.fMoney = fMoney;
	}

	private String today;
	private String dPeople;
	private String dMoney;
	private String fPeople;
	private String fMoney;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getdPeople() {
		return dPeople;
	}

	public void setdPeople(String dPeople) {
		this.dPeople = dPeople;
	}

	public String getdMoney() {
		return dMoney;
	}

	public void setdMoney(String dMoney) {
		this.dMoney = dMoney;
	}

	public String getfPeople() {
		return fPeople;
	}

	public void setfPeople(String fPeople) {
		this.fPeople = fPeople;
	}

	public String getfMoney() {
		return fMoney;
	}

	public void setfMoney(String fMoney) {
		this.fMoney = fMoney;
	}

	@Override
	public String toString() {
		return "TodayStoryVo [today=" + today + ", dPeople=" + dPeople + ", dMoney=" + dMoney + ", fPeople=" + fPeople
				+ ", fMoney=" + fMoney + "]";
	}

}
