package com.xu.model;

import java.util.List;

public class User {
	private String openId = null;
	private String phone = null;
	private String nickName = null;
	private String name = null;
	private String sex = null;
	private String cerType = null;
	private String cerNo = null;
	private List<HouseRelation> houses = null;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCerType() {
		return cerType;
	}

	public void setCerType(String cerType) {
		this.cerType = cerType;
	}

	public String getCerNo() {
		return cerNo;
	}

	public void setCerNo(String cerNo) {
		this.cerNo = cerNo;
	}

	public List<HouseRelation> getHouses() {
		return houses;
	}

	public void setHouses(List<HouseRelation> houses) {
		this.houses = houses;
	}


}
