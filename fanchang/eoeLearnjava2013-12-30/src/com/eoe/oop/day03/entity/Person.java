package com.eoe.oop.day03.entity;

public  class Person {

	/**
	 * @param args
	 */
	//定义五个共有的变量
	protected String name;
	protected char sex;
	protected int age;
	protected double height;
	protected String type;
//name赋值
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
//sex赋值判断
	public char getSex(){
		return sex;
	}
	public void setSex(char sex){
		if (sex=='男'||sex=='女') {
			this.sex=sex;
		}else {
			this.sex='女';
		}
	}
//age赋值判断
	public int getAge(){
		return  age;
	}
	public void setAge(int age){
		if (age>0&&age<200) {
			this.age=age;
		}
		else {
			this.age=18;
		}
	}
//hegiht赋值判断
	public double getHeghit(){
		return  height;
	}
	public void setHeight(double height){
		if (height>0&&height<3) {
			this.height=height;
		}
		else {
			this.height=1.8;
		}
	}
//type赋值
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type=type;
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

	// 无参构造(器)方法,JVM默认提供一个构造方法
//	public Person() {
//		name = "张三";
//		sex = '男';
//		age = 18;
//		height = 1.7;
//		type = "活泼的";
//	}
	

//带参构造方法
	public Person(String name, char sex, int age, double height, String type) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.height = height;
		this.type = type;
	}


	public Person() {
		super();
	}
	//重写toString
	@Override
	public String toString() {
		return this.name;//返回人名
	}
//重写equals
	@Override
	public boolean equals(Object obj) {
		if (obj==null) {               //obj为空,则返回false
			return false;
		}
		Person other=null;
		if (obj instanceof Person) {   //判断能否转换
			other=(Person) obj;        //强制转换并赋值给other
		}else {
			return false;
		}if (obj==this) {          		//obj的地址和这个对象的地址相等,
			return true;
		}
		return this.name.equals(other.name)    //返回并比较
				&&this.sex==other.sex&&
				this.age==other.age&&
				((Math.abs(this.height-other.height))<0.0000001)&&
				this.type.equals(other.type);
	}
	public  void doing(){
		
	}

	public static void main(String[] args) {

	}

}
