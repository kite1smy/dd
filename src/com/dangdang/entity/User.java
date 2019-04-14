package com.dangdang.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private int id;
	private String email;
	private String nickName;
	private String password;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nickName=" + nickName
				+ ", password=" + password + ", date=" + date + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String email, String nickName, String password,
			Date date) {
		super();
		this.id = id;
		this.email = email;
		this.nickName = nickName;
		this.password = password;
		this.date = date;
	}
	
}
