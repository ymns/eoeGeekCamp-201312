package com.eoe.day13_1;

public class GeneralInfo {

	/**放置每一位将军的信息
	 * @param args
	 */
	private String name;
	private	int photoId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	
	public GeneralInfo() {
		// TODO Auto-generated constructor stub
	}
	public GeneralInfo(String name, int photoId) {
		super();
		this.name = name;
		this.photoId = photoId;
	}
	

}
