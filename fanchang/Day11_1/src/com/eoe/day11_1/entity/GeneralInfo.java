package com.eoe.day11_1.entity;

public class GeneralInfo {

	/**
	 * 军事家的的姓名和图片的Id
	 * 
	 * @param args
	 */

	private String name;
	private int photold;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhotold() {
		return photold;
	}

	public void setPhotold(int photold) {
		this.photold = photold;
	}
	//构造方法
	public GeneralInfo() {
		// TODO Auto-generated constructor stub
	}

	public GeneralInfo(String name, int photold) {
		super();
		this.name = name;
		this.photold = photold;
	}


}
