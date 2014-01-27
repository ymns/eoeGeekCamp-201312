package com.eoe.day08_01.entity;

public class User {
	public String name;
	public String pwd;
	public char sex;
	public String city;//所在地
	public String hobby;//爱好
	public User() {
		
	}
	public User(String name, String pwd, char sex, String city,
			String hobby) {
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.city = city;
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "name=" + name + ", pwd=" + pwd
				+ ", sex=" + sex + ", city=" + city + "," + hobby;
	}
	
}
