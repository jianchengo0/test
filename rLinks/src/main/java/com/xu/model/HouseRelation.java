package com.xu.model;

public class HouseRelation {
	private boolean defaultHouse = false;//默认房屋
	private House house = null;//房屋
	private String status = null;// 身份

	public boolean isDefaultHouse() {
		return defaultHouse;
	}
	public void setDefaultHouse(boolean defaultHouse) {
		this.defaultHouse = defaultHouse;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
