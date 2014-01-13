package com.eoe.oop.day03.entity;

public abstract class Person_ {

	/**
	 * 抽象类示例
	 * 
	 * @param args
	 */
	protected int id;
	protected String name;
	protected char sex;
	protected int age;
	protected double height;
	protected String type;

	public Person_() {
		super();
	}

	public Person_(int id, String name, char sex, int age, double height,
			String type) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.height = height;
		this.type = type;
	}

	// name赋值
	public String getName (){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// sex赋值判断
	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		if (sex == '男' || sex == '女') {
			this.sex = sex;
		} else {
			this.sex = '女';
		}
	}

	// age赋值判断
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0 && age < 200) {
			this.age = age;
		} else {
			this.age = 18;
		}
	}

	// hegiht赋值判断
	public double getHeghit() {
		return height;
	}

	public void setHeight(double height) {
		if (height > 0 && height < 3) {
			this.height = height;
		} else {
			this.height = 1.8;
		}
	}

	// type赋值
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	// 说话，打招呼,say方法是非静态方法
	public void say() {
		System.out.println("嗨，大家好，俺叫" + name + "，今年" + age + "岁,身高" + height
				+ "米,俺是一个" + type + sex + "士");
	}

	// feeling方法是非静态方法
	public void feeling(String cause, String content) {
		System.out.println(cause);
		System.out.println(content);
	}
	//抽象方法
	public abstract void doing();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
