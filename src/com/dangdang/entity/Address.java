package com.dangdang.entity;

import java.io.Serializable;

public class Address implements Serializable{
	private int id;
	private String receiveName;
	private String address;
	private String mobile;
	private int deleteState;
	private int selectedState;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", receiveName=" + receiveName
				+ ", address=" + address + ", mobile=" + mobile
				+ ", deleteState=" + deleteState + ", selectedState="
				+ selectedState + ", user=" + user + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(int deleteState) {
		this.deleteState = deleteState;
	}
	public int getSelectedState() {
		return selectedState;
	}
	public void setSelectedState(int selectedState) {
		this.selectedState = selectedState;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int id, String receiveName, String address, String mobile,
			int deleteState, int selectedState, User user) {
		super();
		this.id = id;
		this.receiveName = receiveName;
		this.address = address;
		this.mobile = mobile;
		this.deleteState = deleteState;
		this.selectedState = selectedState;
		this.user = user;
	}
	
}
