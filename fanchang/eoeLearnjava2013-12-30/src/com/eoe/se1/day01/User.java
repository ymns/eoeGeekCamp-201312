package com.eoe.se1.day01;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * User类代表注册用户类
	 * 
	 * @param args
	 */
	private int id;
	private String name;
	private String pwd;
	private String phone;
	private String email;

	public User() {

	}

	public User(int id, String name, String pwd, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd
				+ ", phone=" + phone + ", email=" + email + "]";
	}
	@Override
	public boolean equals(Object obj) {
		User other=null;
		if (obj instanceof User) {
			other=(User) obj;
		}else{
			return false;
		}
		return other.id==this.id;
	}

}
