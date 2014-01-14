package com.eoe.oop.day03.entity;

public class Student extends Person{

	/**
	 * @param args
	 */
	//定义两个变量
	private String inClass;
	private String inSchool;
	
	public String getInSchool(){
		return inSchool;
	}
	public void setInSchool(String inSchool){
		this.inSchool=inSchool;
	}
	
	public String getInClass(){
		return inClass;
	}
	public void setInClass(String inClass){
		this.inClass=inClass;
	}
	public void say(){
		super.say();
		System.out.println("我在"+inSchool+" "+inClass+"学习");
	}
	
	public void doing(){
		System.out.println(this.name+"正在写作业");
	}
	public Student(String name, char sex, int age, double height, String type,
			String inClass, String inSchool) {
		super(name, sex, age, height, type);
		this.inClass = inClass;
		this.inSchool = inSchool;
	}
	
	public Student() {
		super();
	}
	public static void main(String[] args) {

	}

}
